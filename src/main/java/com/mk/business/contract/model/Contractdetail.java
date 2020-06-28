package com.mk.business.contract.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *Description:
 *Created by zhangnengwei on 2020-4-15 9:34
 */
@ApiModel(value="com-mk-business-atest-model-Contractdetail")
@Table(name = "t_a_contractdetail")
public class Contractdetail implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "Contract_Detail_Guid")
    @ApiModelProperty(value="主键")
    private String contractDetailGuid;

    @Column(name = "Contract_Guid")
    @ApiModelProperty(value="")
    private String contractGuid;

    @Column(name = "BuyPlan_Detail_Guid")
    @ApiModelProperty(value="")
    private String buyplanDetailGuid;

    @Column(name = "PurCatalog_Type")
    @ApiModelProperty(value="")
    private String purcatalogType;

    @Column(name = "PurCatalog_Guid")
    @ApiModelProperty(value="")
    private String purcatalogGuid;

    @Column(name = "Goods_Name")
    @ApiModelProperty(value="")
    private String goodsName;

    /**
     * 品牌名称
     */
    @Column(name = "Brand_name")
    @ApiModelProperty(value="品牌名称")
    private String brandName;

    /**
     * 计量单位name
     */
    @Column(name = "Unit_Name")
    @ApiModelProperty(value="计量单位name")
    private String unitName;

    /**
     * 购买数量
     */
    @Column(name = "Plan_Purchase_Num")
    @ApiModelProperty(value="购买数量")
    private BigDecimal planPurchaseNum;

    /**
     * 单价
     */
    @Column(name = "Plan_Price")
    @ApiModelProperty(value="单价")
    private BigDecimal planPrice;

    /**
     * 总价
     */
    @Column(name = "Plan_Totle_Price")
    @ApiModelProperty(value="总价")
    private BigDecimal planTotlePrice;

    /**
     * 购买数量
     */
    @Column(name = "Purchase_Num")
    @ApiModelProperty(value="购买数量")
    private BigDecimal purchaseNum;

    /**
     * 单价
     */
    @Column(name = "Price")
    @ApiModelProperty(value="单价")
    private BigDecimal price;

    /**
     * 总价
     */
    @Column(name = "Totle_Price")
    @ApiModelProperty(value="总价")
    private BigDecimal totlePrice;

    /**
     * 是否进口
     */
    @Column(name = "Imports")
    @ApiModelProperty(value="是否进口")
    private Short imports;

    /**
     * 节能
     */
    @Column(name = "Efficient")
    @ApiModelProperty(value="节能")
    private Short efficient;

    /**
     * 节水
     */
    @Column(name = "Water_Saving")
    @ApiModelProperty(value="节水")
    private Short waterSaving;

    /**
     * 环保
     */
    @Column(name = "Environment")
    @ApiModelProperty(value="环保")
    private Short environment;

    /**
     * 规格参数
     */
    @Column(name = "Spec_Properties")
    @ApiModelProperty(value="规格参数")
    private String specProperties;

    /**
     * 国家编号
     */
    @Column(name = "Country_Code")
    @ApiModelProperty(value="国家编号")
    private String countryCode;

    /**
     * 产品品牌
     */
    @Column(name = "Product_Brand")
    @ApiModelProperty(value="产品品牌")
    private String productBrand;

    /**
     * 制造商名称
     */
    @Column(name = "Maker_Name")
    @ApiModelProperty(value="制造商名称")
    private String makerName;

    /**
     * 制造商规模
     */
    @Column(name = "Maker_Size")
    @ApiModelProperty(value="制造商规模")
    private String makerSize;

    /**
     * 制造商产地类型
     */
    @Column(name = "Maker_Origin_Type")
    @ApiModelProperty(value="制造商产地类型")
    private String makerOriginType;

    /**
     * 制造商特性
     */
    @Column(name = "Maker_Features")
    @ApiModelProperty(value="制造商特性")
    private String makerFeatures;

    /**
     * 采购内容
     */
    @Column(name = "Purchase_Content")
    @ApiModelProperty(value="采购内容")
    private String purchaseContent;

    /**
     * （采购计划）一般公共预算资金(元)*
     */
    @Column(name = "Plan_Money1")
    @ApiModelProperty(value="（采购计划）一般公共预算资金(元)*")
    private BigDecimal planMoney1;

    /**
     * （采购计划）政府性基金预算（元）*
     */
    @Column(name = "Plan_Money2")
    @ApiModelProperty(value="（采购计划）政府性基金预算（元）*")
    private BigDecimal planMoney2;

    /**
     * （采购计划）其他资金（元）*
     */
    @Column(name = "Plan_Money3")
    @ApiModelProperty(value="（采购计划）其他资金（元）*")
    private BigDecimal planMoney3;

    /**
     * （采购计划）非财政性资金（元）*
     */
    @Column(name = "Plan_Money4")
    @ApiModelProperty(value="（采购计划）非财政性资金（元）*")
    private BigDecimal planMoney4;

    /**
     * （实际采购）一般公共预算资金(元)*
     */
    @Column(name = "Contract_Money1")
    @ApiModelProperty(value="（实际采购）一般公共预算资金(元)*")
    private BigDecimal contractMoney1;

    /**
     * （实际采购）政府性基金预算（元）*
     */
    @Column(name = "Contract_Money2")
    @ApiModelProperty(value="（实际采购）政府性基金预算（元）*")
    private BigDecimal contractMoney2;

    /**
     * （实际采购）其他资金（元）*
     */
    @Column(name = "Contract_Money3")
    @ApiModelProperty(value="（实际采购）其他资金（元）*")
    private BigDecimal contractMoney3;

    /**
     * （实际采购）非财政性资金（元）*
     */
    @Column(name = "Contract_Money4")
    @ApiModelProperty(value="（实际采购）非财政性资金（元）*")
    private BigDecimal contractMoney4;

    /**
     * 产品型号
     */
    @Column(name = "Goods_Model")
    @ApiModelProperty(value="产品型号")
    private String goodsModel;

    /**
     * 项目类别(选项)
     */
    @Column(name = "Porject_Type")
    @ApiModelProperty(value="项目类别(选项)")
    private String porjectType;

    /**
     * 汽车类别(选项)
     */
    @Column(name = "Car_Type")
    @ApiModelProperty(value="汽车类别(选项)")
    private String carType;

    /**
     * 进口产品编号
     */
    @Column(name = "Imported_Product_Code")
    @ApiModelProperty(value="进口产品编号")
    private String importedProductCode;

    /**
     * 创新类别(cxlb002:普通产品和服务,cxlb001:创新产品和服务)
     */
    @Column(name = "Innovate_Type")
    @ApiModelProperty(value="创新类别(cxlb002:普通产品和服务,cxlb001:创新产品和服务)")
    private String innovateType;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return Contract_Detail_Guid - 主键
     */
    public String getContractDetailGuid() {
        return contractDetailGuid;
    }

    /**
     * 设置主键
     *
     * @param contractDetailGuid 主键
     */
    public void setContractDetailGuid(String contractDetailGuid) {
        this.contractDetailGuid = contractDetailGuid;
    }

    /**
     * @return Contract_Guid
     */
    public String getContractGuid() {
        return contractGuid;
    }

    /**
     * @param contractGuid
     */
    public void setContractGuid(String contractGuid) {
        this.contractGuid = contractGuid;
    }

    /**
     * @return BuyPlan_Detail_Guid
     */
    public String getBuyplanDetailGuid() {
        return buyplanDetailGuid;
    }

    /**
     * @param buyplanDetailGuid
     */
    public void setBuyplanDetailGuid(String buyplanDetailGuid) {
        this.buyplanDetailGuid = buyplanDetailGuid;
    }

    /**
     * @return PurCatalog_Type
     */
    public String getPurcatalogType() {
        return purcatalogType;
    }

    /**
     * @param purcatalogType
     */
    public void setPurcatalogType(String purcatalogType) {
        this.purcatalogType = purcatalogType;
    }

    /**
     * @return PurCatalog_Guid
     */
    public String getPurcatalogGuid() {
        return purcatalogGuid;
    }

    /**
     * @param purcatalogGuid
     */
    public void setPurcatalogGuid(String purcatalogGuid) {
        this.purcatalogGuid = purcatalogGuid;
    }

    /**
     * @return Goods_Name
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取品牌名称
     *
     * @return Brand_name - 品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置品牌名称
     *
     * @param brandName 品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 获取计量单位name
     *
     * @return Unit_Name - 计量单位name
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置计量单位name
     *
     * @param unitName 计量单位name
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取购买数量
     *
     * @return Plan_Purchase_Num - 购买数量
     */
    public BigDecimal getPlanPurchaseNum() {
        return planPurchaseNum;
    }

    /**
     * 设置购买数量
     *
     * @param planPurchaseNum 购买数量
     */
    public void setPlanPurchaseNum(BigDecimal planPurchaseNum) {
        this.planPurchaseNum = planPurchaseNum;
    }

    /**
     * 获取单价
     *
     * @return Plan_Price - 单价
     */
    public BigDecimal getPlanPrice() {
        return planPrice;
    }

    /**
     * 设置单价
     *
     * @param planPrice 单价
     */
    public void setPlanPrice(BigDecimal planPrice) {
        this.planPrice = planPrice;
    }

    /**
     * 获取总价
     *
     * @return Plan_Totle_Price - 总价
     */
    public BigDecimal getPlanTotlePrice() {
        return planTotlePrice;
    }

    /**
     * 设置总价
     *
     * @param planTotlePrice 总价
     */
    public void setPlanTotlePrice(BigDecimal planTotlePrice) {
        this.planTotlePrice = planTotlePrice;
    }

    /**
     * 获取购买数量
     *
     * @return Purchase_Num - 购买数量
     */
    public BigDecimal getPurchaseNum() {
        return purchaseNum;
    }

    /**
     * 设置购买数量
     *
     * @param purchaseNum 购买数量
     */
    public void setPurchaseNum(BigDecimal purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    /**
     * 获取单价
     *
     * @return Price - 单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置单价
     *
     * @param price 单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取总价
     *
     * @return Totle_Price - 总价
     */
    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    /**
     * 设置总价
     *
     * @param totlePrice 总价
     */
    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    /**
     * 获取是否进口
     *
     * @return imports - 是否进口
     */
    public Short getImports() {
        return imports;
    }

    /**
     * 设置是否进口
     *
     * @param imports 是否进口
     */
    public void setImports(Short imports) {
        this.imports = imports;
    }

    /**
     * 获取节能
     *
     * @return Efficient - 节能
     */
    public Short getEfficient() {
        return efficient;
    }

    /**
     * 设置节能
     *
     * @param efficient 节能
     */
    public void setEfficient(Short efficient) {
        this.efficient = efficient;
    }

    /**
     * 获取节水
     *
     * @return Water_Saving - 节水
     */
    public Short getWaterSaving() {
        return waterSaving;
    }

    /**
     * 设置节水
     *
     * @param waterSaving 节水
     */
    public void setWaterSaving(Short waterSaving) {
        this.waterSaving = waterSaving;
    }

    /**
     * 获取环保
     *
     * @return Environment - 环保
     */
    public Short getEnvironment() {
        return environment;
    }

    /**
     * 设置环保
     *
     * @param environment 环保
     */
    public void setEnvironment(Short environment) {
        this.environment = environment;
    }

    /**
     * 获取规格参数
     *
     * @return Spec_Properties - 规格参数
     */
    public String getSpecProperties() {
        return specProperties;
    }

    /**
     * 设置规格参数
     *
     * @param specProperties 规格参数
     */
    public void setSpecProperties(String specProperties) {
        this.specProperties = specProperties;
    }

    /**
     * 获取国家编号
     *
     * @return Country_Code - 国家编号
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 设置国家编号
     *
     * @param countryCode 国家编号
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * 获取产品品牌
     *
     * @return Product_Brand - 产品品牌
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     * 设置产品品牌
     *
     * @param productBrand 产品品牌
     */
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    /**
     * 获取制造商名称
     *
     * @return Maker_Name - 制造商名称
     */
    public String getMakerName() {
        return makerName;
    }

    /**
     * 设置制造商名称
     *
     * @param makerName 制造商名称
     */
    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    /**
     * 获取制造商规模
     *
     * @return Maker_Size - 制造商规模
     */
    public String getMakerSize() {
        return makerSize;
    }

    /**
     * 设置制造商规模
     *
     * @param makerSize 制造商规模
     */
    public void setMakerSize(String makerSize) {
        this.makerSize = makerSize;
    }

    /**
     * 获取制造商产地类型
     *
     * @return Maker_Origin_Type - 制造商产地类型
     */
    public String getMakerOriginType() {
        return makerOriginType;
    }

    /**
     * 设置制造商产地类型
     *
     * @param makerOriginType 制造商产地类型
     */
    public void setMakerOriginType(String makerOriginType) {
        this.makerOriginType = makerOriginType;
    }

    /**
     * 获取制造商特性
     *
     * @return Maker_Features - 制造商特性
     */
    public String getMakerFeatures() {
        return makerFeatures;
    }

    /**
     * 设置制造商特性
     *
     * @param makerFeatures 制造商特性
     */
    public void setMakerFeatures(String makerFeatures) {
        this.makerFeatures = makerFeatures;
    }

    /**
     * 获取采购内容
     *
     * @return Purchase_Content - 采购内容
     */
    public String getPurchaseContent() {
        return purchaseContent;
    }

    /**
     * 设置采购内容
     *
     * @param purchaseContent 采购内容
     */
    public void setPurchaseContent(String purchaseContent) {
        this.purchaseContent = purchaseContent;
    }

    /**
     * 获取（采购计划）一般公共预算资金(元)*
     *
     * @return Plan_Money1 - （采购计划）一般公共预算资金(元)*
     */
    public BigDecimal getPlanMoney1() {
        return planMoney1;
    }

    /**
     * 设置（采购计划）一般公共预算资金(元)*
     *
     * @param planMoney1 （采购计划）一般公共预算资金(元)*
     */
    public void setPlanMoney1(BigDecimal planMoney1) {
        this.planMoney1 = planMoney1;
    }

    /**
     * 获取（采购计划）政府性基金预算（元）*
     *
     * @return Plan_Money2 - （采购计划）政府性基金预算（元）*
     */
    public BigDecimal getPlanMoney2() {
        return planMoney2;
    }

    /**
     * 设置（采购计划）政府性基金预算（元）*
     *
     * @param planMoney2 （采购计划）政府性基金预算（元）*
     */
    public void setPlanMoney2(BigDecimal planMoney2) {
        this.planMoney2 = planMoney2;
    }

    /**
     * 获取（采购计划）其他资金（元）*
     *
     * @return Plan_Money3 - （采购计划）其他资金（元）*
     */
    public BigDecimal getPlanMoney3() {
        return planMoney3;
    }

    /**
     * 设置（采购计划）其他资金（元）*
     *
     * @param planMoney3 （采购计划）其他资金（元）*
     */
    public void setPlanMoney3(BigDecimal planMoney3) {
        this.planMoney3 = planMoney3;
    }

    /**
     * 获取（采购计划）非财政性资金（元）*
     *
     * @return Plan_Money4 - （采购计划）非财政性资金（元）*
     */
    public BigDecimal getPlanMoney4() {
        return planMoney4;
    }

    /**
     * 设置（采购计划）非财政性资金（元）*
     *
     * @param planMoney4 （采购计划）非财政性资金（元）*
     */
    public void setPlanMoney4(BigDecimal planMoney4) {
        this.planMoney4 = planMoney4;
    }

    /**
     * 获取（实际采购）一般公共预算资金(元)*
     *
     * @return Contract_Money1 - （实际采购）一般公共预算资金(元)*
     */
    public BigDecimal getContractMoney1() {
        return contractMoney1;
    }

    /**
     * 设置（实际采购）一般公共预算资金(元)*
     *
     * @param contractMoney1 （实际采购）一般公共预算资金(元)*
     */
    public void setContractMoney1(BigDecimal contractMoney1) {
        this.contractMoney1 = contractMoney1;
    }

    /**
     * 获取（实际采购）政府性基金预算（元）*
     *
     * @return Contract_Money2 - （实际采购）政府性基金预算（元）*
     */
    public BigDecimal getContractMoney2() {
        return contractMoney2;
    }

    /**
     * 设置（实际采购）政府性基金预算（元）*
     *
     * @param contractMoney2 （实际采购）政府性基金预算（元）*
     */
    public void setContractMoney2(BigDecimal contractMoney2) {
        this.contractMoney2 = contractMoney2;
    }

    /**
     * 获取（实际采购）其他资金（元）*
     *
     * @return Contract_Money3 - （实际采购）其他资金（元）*
     */
    public BigDecimal getContractMoney3() {
        return contractMoney3;
    }

    /**
     * 设置（实际采购）其他资金（元）*
     *
     * @param contractMoney3 （实际采购）其他资金（元）*
     */
    public void setContractMoney3(BigDecimal contractMoney3) {
        this.contractMoney3 = contractMoney3;
    }

    /**
     * 获取（实际采购）非财政性资金（元）*
     *
     * @return Contract_Money4 - （实际采购）非财政性资金（元）*
     */
    public BigDecimal getContractMoney4() {
        return contractMoney4;
    }

    /**
     * 设置（实际采购）非财政性资金（元）*
     *
     * @param contractMoney4 （实际采购）非财政性资金（元）*
     */
    public void setContractMoney4(BigDecimal contractMoney4) {
        this.contractMoney4 = contractMoney4;
    }

    /**
     * 获取产品型号
     *
     * @return Goods_Model - 产品型号
     */
    public String getGoodsModel() {
        return goodsModel;
    }

    /**
     * 设置产品型号
     *
     * @param goodsModel 产品型号
     */
    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel;
    }

    /**
     * 获取项目类别(选项)
     *
     * @return Porject_Type - 项目类别(选项)
     */
    public String getPorjectType() {
        return porjectType;
    }

    /**
     * 设置项目类别(选项)
     *
     * @param porjectType 项目类别(选项)
     */
    public void setPorjectType(String porjectType) {
        this.porjectType = porjectType;
    }

    /**
     * 获取汽车类别(选项)
     *
     * @return Car_Type - 汽车类别(选项)
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 设置汽车类别(选项)
     *
     * @param carType 汽车类别(选项)
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * 获取进口产品编号
     *
     * @return Imported_Product_Code - 进口产品编号
     */
    public String getImportedProductCode() {
        return importedProductCode;
    }

    /**
     * 设置进口产品编号
     *
     * @param importedProductCode 进口产品编号
     */
    public void setImportedProductCode(String importedProductCode) {
        this.importedProductCode = importedProductCode;
    }

    /**
     * 获取创新类别(cxlb002:普通产品和服务,cxlb001:创新产品和服务)
     *
     * @return Innovate_Type - 创新类别(cxlb002:普通产品和服务,cxlb001:创新产品和服务)
     */
    public String getInnovateType() {
        return innovateType;
    }

    /**
     * 设置创新类别(cxlb002:普通产品和服务,cxlb001:创新产品和服务)
     *
     * @param innovateType 创新类别(cxlb002:普通产品和服务,cxlb001:创新产品和服务)
     */
    public void setInnovateType(String innovateType) {
        this.innovateType = innovateType;
    }
}
