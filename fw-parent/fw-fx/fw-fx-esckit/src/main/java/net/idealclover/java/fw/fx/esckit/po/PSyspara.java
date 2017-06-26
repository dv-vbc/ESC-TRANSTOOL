/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.po;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 *
 * @author DragonFly
 */
@Alias("PSyspara")
public class PSyspara implements Serializable {

    private Long paraId;
    private Long paraSortId;
    private String name;
    private String typeCode;
    private String defaultValue;
    private String maxLimit;
    private String minLimit;
    private String orgNo;
    private String maintOrgNo;
    private String effetiveFlag;
    private Date setTime;
    private Date effectTime;
    private Date expireTime;
    private String appNo;
    private String importLevelCode;

    public Long getParaId() {
        return paraId;
    }

    public void setParaId(Long paraId) {
        this.paraId = paraId;
    }

    public Long getParaSortId() {
        return paraSortId;
    }

    public void setParaSortId(Long paraSortId) {
        this.paraSortId = paraSortId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(String maxLimit) {
        this.maxLimit = maxLimit;
    }

    public String getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(String minLimit) {
        this.minLimit = minLimit;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getMaintOrgNo() {
        return maintOrgNo;
    }

    public void setMaintOrgNo(String maintOrgNo) {
        this.maintOrgNo = maintOrgNo;
    }

    public String getEffetiveFlag() {
        return effetiveFlag;
    }

    public void setEffetiveFlag(String effetiveFlag) {
        this.effetiveFlag = effetiveFlag;
    }

    public Date getSetTime() {
        return setTime;
    }

    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getImportLevelCode() {
        return importLevelCode;
    }

    public void setImportLevelCode(String importLevelCode) {
        this.importLevelCode = importLevelCode;
    }

}
