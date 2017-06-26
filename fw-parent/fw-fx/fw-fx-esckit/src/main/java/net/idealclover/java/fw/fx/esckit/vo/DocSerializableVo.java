/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DragonFly
 */
public class DocSerializableVo implements Serializable {

    private Long id;
    private String oper;
    private String opdept;
    private Date optime;
    private String docDomain;
    private String docType;
//    private Integer docLevel;
//    private String docState;
    private String keyword;
    private String title;
    private String summary;
    private String author;
    private Long fileId;

    private String filename;
    private String filetype;
    private Long filesize;
    private String oldname;
    private String relapath;

    private String docDomainName;
    private String docTypeName;

    public DocSerializableVo() {
    }

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

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname;
    }

    public String getRelapath() {
        return relapath;
    }

    public void setRelapath(String relapath) {
        this.relapath = relapath;
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

}
