package com.mk.business.audithistory.impl;

import com.mk.business.Constance.Constance;
import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.audithistory.param.AudithistoryCheckoutParam;
import com.mk.business.commonutils.exception.ParamException;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.organization.service.OrganizationService;
import com.mk.business.post.service.PostService;
import com.mk.business.user.service.UserService;
import com.mk.utils.enums.StatusEnum;
import com.mk.utils.util.ListUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mk.business.audithistory.dao.AudithistoryDao;
import com.mk.business.audithistory.service.AudithistoryService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @date: 2020-4-27 15:27
 * @author: Znw · Smile
 * @Description:
 */
@Service
@Primary
public class AudithistoryServiceImpl implements AudithistoryService {

    @Resource
    private AudithistoryDao audithistoryDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Autowired
    private OptionlistService optionlistService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Override
    public void deleteAuditHistryByBizId(String bizGuid) {
        Example auditHistoryExample = new Example(Audithistory.class);
        Example.Criteria auditHistoryCriteria = auditHistoryExample.createCriteria();
        auditHistoryCriteria.andEqualTo("bizGuid", bizGuid);
        audithistoryDao.deleteByExample(auditHistoryExample);
    }

    @Override
    public void insertAuditHistory(Audithistory audithistory) {
        audithistoryDao.insert(audithistory);
    }

    @Override
    public void checkAuditHistoryParam(Audithistory audithistory) throws Exception {
        // 校验请求数据
        AudithistoryCheckoutParam checkoutParam = ListUtil.copy(audithistory, AudithistoryCheckoutParam.class);
        List<String> nullParamList = commonUtilsService.checkRequestParam(checkoutParam);
        if (CollectionUtils.isNotEmpty(nullParamList)) {
            String errorParams = nullParamList.toString();
            throw new Exception(errorParams + "为空！");
        }

        // 校验枚举值
        String orgType = String.valueOf(audithistory.getExcuteOrgType());
        if (StringUtils.isNotBlank(orgType)) {
            Optionlist orgTypeFromSql = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_ORG_TYPE, orgType);
            if (null == orgTypeFromSql) {
                throw new ParamException("审核历史推送失败:枚举值超出范围orgType:" + orgType);
            }
        }

        // 校验基础数据
        /*int organization = organizationService.getOrganization(audithistory.getExcuteOrgGuid());
        if (StatusEnum.FALSE.getValue() == organization) {
            throw new ParamException("审核历史推送失败:数据中心找不到对应OrgGuid:" + audithistory.getExcuteOrgGuid());
        }

        int post = postService.getPost(audithistory.getPostGuid());
        if (StatusEnum.FALSE.getValue() == post) {
            throw new ParamException("审核历史推送失败:数据中心找不到对应PostGuid:" + audithistory.getPostGuid());
        }

        int user = userService.getUser(audithistory.getExcuteUserGuid());
        if (StatusEnum.FALSE.getValue() == user) {
            throw new ParamException("审核历史推送失败:数据中心找不到对应UserGuid:" + audithistory.getExcuteUserGuid());
        }*/
    }
}
