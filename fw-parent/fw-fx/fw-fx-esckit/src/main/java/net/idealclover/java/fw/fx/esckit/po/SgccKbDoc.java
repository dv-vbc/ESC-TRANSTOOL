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
@Alias("SgccKbDoc")
public class SgccKbDoc implements Serializable {

    private Long id;
    private String oper;
    private String opdept;
    private Date optime;
    private String docDomain;
    private String docType;
    private Integer docLevel;
    private String docState;
    private String keyword;
    private String title;
    private String summary;
    private String author;
    private Date uploadtime;
    private Integer previewCount;
    private Integer downloadCount;
    private Long fileId;// 上传成功的文件id 隐藏的
    private String sn;
    private String sync;

    private String docDomainName;
    private String docTypeName;

    private SgccPFile sgccPFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getOpdept() {
        return opdept;
    }

    public void setOpdept(String opdept) {
        this.opdept = opdept;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getDocDomain() {
        return docDomain;
    }

    public void setDocDomain(String docDomain) {
        this.docDomain = docDomain;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Integer getDocLevel() {
        return docLevel;
    }

    public void setDocLevel(Integer docLevel) {
        this.docLevel = docLevel;
    }

    public String getDocState() {
        return docState;
    }

    public void setDocState(String docState) {
        this.docState = docState;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Integer getPreviewCount() {
        return previewCount;
    }

    public void setPreviewCount(Integer previewCount) {
        this.previewCount = previewCount;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSync() {
        return sync;
    }

    public void setSync(String sync) {
        this.sync = sync;
    }

    public String getDocDomainName() {
        return docDomainName;
    }

    public void setDocDomainName(String docDomainName) {
        this.docDomainName = docDomainName;
    }

    public String getDocTypeName() {
        return docTypeName;
    }

    public void setDocTypeName(String docTypeName) {
        this.docTypeName = docTypeName;
    }

    public SgccPFile getSgccPFile() {
        return sgccPFile;
    }

    public void setSgccPFile(SgccPFile sgccPFile) {
        this.sgccPFile = sgccPFile;
    }

}
