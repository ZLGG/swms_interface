package com.mk.business.notice.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mk.business.Constance.Constance;
import com.mk.business.acceptance.dao.AcceptanceDao;
import com.mk.business.acceptance.model.Acceptance;
import com.mk.business.buyplan.dao.BuyplanDao;
import com.mk.business.buyplan.model.Buyplan;
import com.mk.business.commonutils.exception.ParamException;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.contract.dao.ContractDao;
import com.mk.business.contract.model.Contract;
import com.mk.business.notice.model.Notice;
import com.mk.business.notice.param.NoticeCheckoutParam;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.organization.service.OrganizationService;
import com.mk.business.region.service.RegionService;
import com.mk.utils.enums.BizTypeEnum;
import com.mk.utils.enums.StatusEnum;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import com.mk.utils.util.ListUtil;
import com.mk.utils.util.UUIDGenerator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.notice.dao.NoticeDao;
import com.mk.business.notice.service.NoticeService;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @date: 2020-4-28 15:04
 * @author: Znw · Smile
 * @Description:
 */
@Service
@Primary
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private BuyplanDao buyplanDao;

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private AcceptanceDao acceptanceDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Autowired
    private OptionlistService optionlistService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private RegionService regionService;


    @Override
    public ResponseInfoVo saveOrUpdateNotice(RequestInfoVo requestInfoVo) throws Exception {
        Notice notice;
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        String messageDecryptStringToBase64;
        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            responseInfoVo.returnErrorResult("-2", e.getMessage());
            return responseInfoVo;
        }
        try {
            notice = JSONObject.parseObject(messageDecryptStringToBase64, Notice.class);
        } catch (Exception e) {
            responseInfoVo.returnErrorResult("-2", "数据解析异常" + e.getMessage());
            return responseInfoVo;
        }
        // 校验参数
        checkNoticeParams(notice);

        //校验并转换业务ID
        checkAndSetBizGuid(notice);

        //设置时间戳
        Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
        Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
        notice.setBizTimeStamp(currentSqlDate);
        notice.setBizDate(dateWithoutTime);

        //查询公告是否存在
        Example noticeExample = new Example(Notice.class);
        Example.Criteria noticeCriteria = noticeExample.createCriteria();
        noticeCriteria.andEqualTo("interfaceCode", notice.getInterfaceCode());
        noticeCriteria.andEqualTo("dataResource", notice.getDataResource());
        Notice sqlNotice = noticeDao.selectOneByExample(noticeExample);

        if (null == sqlNotice) {
            // 新增公示
            notice.setNoticeGuid(UUIDGenerator.getUUID());
            noticeDao.insert(notice);
        } else {
            // 更新公示
            notice.setNoticeGuid(sqlNotice.getNoticeGuid());
            noticeDao.updateByPrimaryKey(notice);
        }
        Gson gson = new Gson();
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode("200");
        returnMessage.setMsg("保存成功");
        gson.toJson(returnMessage);
        responseInfoVo.returnSuccessResult(gson.toJson(returnMessage), null);
        return responseInfoVo;

    }

    /**
     * 校验并转换业务ID
     *
     * @Param: [notice]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 14:03
     */
    private void checkAndSetBizGuid(Notice notice) throws ParamException {
        String bizType = notice.getBizType();
        String buyplanKey = BizTypeEnum.BUYPLAN.getKey();
        String contractKey = BizTypeEnum.CONTRACT.getKey();
        String acceptanceKey = BizTypeEnum.ACCEPTANCE.getKey();
        String bizInterfaceCode = notice.getBizInterfaceCode();
        String interfaceCode = notice.getInterfaceCode();
        String dataResource = notice.getDataResource();
        if ((buyplanKey.equals(bizType))) {
            if (StringUtils.isNotBlank(bizInterfaceCode)) {
                Example buyPlanExample = new Example(Buyplan.class);
                Example.Criteria buyPlanExampleCriteria = buyPlanExample.createCriteria();
                buyPlanExampleCriteria.andEqualTo("interfaceCode", bizInterfaceCode);
                buyPlanExampleCriteria.andEqualTo("dataResource", dataResource);
                Buyplan buyplan = buyplanDao.selectOneByExample(buyPlanExample);
                if (null == buyplan) {
                    throw new ParamException(dataResource + "公示ID为： " + interfaceCode +
                            "下的业务ID: " + bizInterfaceCode + "转换为计划ID失败,原因：数据中心找不到计划ID对应数据");
                }
                notice.setBizGuid(buyplan.getBuyplanGuid());
            }
        } else if (contractKey.equals(bizType)) {
            if (StringUtils.isNotBlank(bizInterfaceCode)) {
                Example contractExample = new Example(Contract.class);
                Example.Criteria contractExampleCriteria = contractExample.createCriteria();
                contractExampleCriteria.andEqualTo("interfaceCode", bizInterfaceCode);
                contractExampleCriteria.andEqualTo("dataResource", dataResource);
                Contract contract = contractDao.selectOneByExample(contractExample);
                if (null == contract) {
                    throw new ParamException(dataResource + "公示ID为： " + interfaceCode +
                            "下的业务ID: " + bizInterfaceCode + "转换为合同ID失败,原因：数据中心找不到合同ID对应数据");
                }
                notice.setBizGuid(contract.getBuyplanGuid());
            }

        } else if (acceptanceKey.equals(bizType)) {
            if (StringUtils.isNotBlank(bizInterfaceCode)) {
                Example acceptanceExample = new Example(Acceptance.class);
                Example.Criteria acceptanceExampleCriteria = acceptanceExample.createCriteria();
                acceptanceExampleCriteria.andEqualTo("interfaceCode", bizInterfaceCode);
                acceptanceExampleCriteria.andEqualTo("dataResource", dataResource);
                Acceptance acceptance = acceptanceDao.selectOneByExample(acceptanceExample);
                if (null == acceptance) {
                    throw new ParamException(dataResource + "公示ID为： " + interfaceCode +
                            "下的业务ID: " + bizInterfaceCode + "转换为验收ID失败,原因：数据中心找不到验收ID对应数据");
                }
                notice.setBizGuid(acceptance.getAcceptanceGuid());
            }
        } else {
            throw new ParamException("推送公告失败,枚举值超出规定范围bizType：" + bizType);
        }
    }

    /**
     * 校验公告参数
     *
     * @Param: [notice]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 11:43
     */
    private void checkNoticeParams(Notice notice) throws Exception {
        // 请求数据校验
        NoticeCheckoutParam checkoutParam = ListUtil.copy(notice, NoticeCheckoutParam.class);
        List<String> nullParamList = commonUtilsService.checkRequestParam(checkoutParam);
        if (CollectionUtils.isNotEmpty(nullParamList)) {
            String errorParams = nullParamList.toString();
            throw new ParamException("公告数据推送失败: " + errorParams + "为空!");
        }

        // 枚举值校验
        if (StringUtils.isNotBlank(notice.getNoticeType())) {
            Optionlist notisType = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_NoticeType, notice.getNoticeType());
            if (null == notisType) {
                throw new ParamException("公告推送失败,找不到对应枚举值NoticeType：" + notice.getNoticeType());
            }
        }

        if (StringUtils.isNotBlank(notice.getPublishState())) {
            Optionlist publishState = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PublishState, notice.getPublishState());
            if (null == publishState) {
                throw new ParamException("公告推送失败,找不到对应枚举值publishState：" + notice.getPublishState());
            }
        }

        BigDecimal bizValid = notice.getBizValid();
        String validCheckParam = String.valueOf(bizValid);
        if (null != bizValid) {
            Optionlist valid = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Biz_Valid, validCheckParam);
            if (null == valid) {
                throw new ParamException("公告推送失败,找不到对应枚举值bizValid：" + validCheckParam);
            }
        }

        // todo (新版要求删除基础数据校验)基础数据校验
        /*int organization = organizationService.getOrganization(notice.getOrgGuid());
        if (StatusEnum.FALSE.getValue() == organization) {
            throw new ParamException("公告推送失败,找不到与OrgGuid对应数据： " + notice.getOrgGuid());
        }

        int region = regionService.getRegion(notice.getRegionGuid());
        if (StatusEnum.FALSE.getValue() == region) {
            throw new ParamException("公告推送失败,找不到与RegionGuid对应数据： " + notice.getRegionGuid());
        }*/
    }
}
