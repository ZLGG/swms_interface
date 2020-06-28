package com.mk.business.year.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

/**
*Description: 
*Created by zhangnengwei on 2020-4-8 15:07
*/
@ApiModel(value="com.mk.business.year.model.Year")
@Table(name = "t_d_year")
public class Year implements Serializable {
    @Id
    @Column(name = "`Year`")
    @ApiModelProperty(value="null")
    private Short year;

    @Column(name = "Year_Name")
    @ApiModelProperty(value="null")
    private String yearName;

    private static final long serialVersionUID = 1L;

    /**
     * @return Year
     */
    public Short getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(Short year) {
        this.year = year;
    }

    /**
     * @return Year_Name
     */
    public String getYearName() {
        return yearName;
    }

    /**
     * @param yearName
     */
    public void setYearName(String yearName) {
        this.yearName = yearName;
    }
}