/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.vo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author DragonFly
 */
public final class DocTableVo {

    private Long id;
    private Long fileId;
    private String opdept;
    private String docDomain;
    private String docType;
    private final SimpleBooleanProperty checkbox = new SimpleBooleanProperty();
    private final SimpleStringProperty docDomainName = new SimpleStringProperty();
    private final SimpleStringProperty docTypeName = new SimpleStringProperty();
    private final SimpleStringProperty title = new SimpleStringProperty();
    private final SimpleStringProperty author = new SimpleStringProperty();
    private final SimpleStringProperty keyword = new SimpleStringProperty();
    private final SimpleStringProperty summary = new SimpleStringProperty();
    private final SimpleStringProperty filename = new SimpleStringProperty();
    private final SimpleStringProperty filetype = new SimpleStringProperty();
    private final SimpleLongProperty filesize = new SimpleLongProperty();
    private final SimpleStringProperty oldname = new SimpleStringProperty();
    private final SimpleStringProperty relapath = new SimpleStringProperty();
    private final SimpleStringProperty oper = new SimpleStringProperty();
    private final SimpleStringProperty optime = new SimpleStringProperty();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getOpdept() {
        return opdept;
    }

    public void setOpdept(String opdept) {
        this.opdept = opdept;
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

    public boolean getCheckbox() {
        return checkbox.get();
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox.set(checkbox);
    }

    public SimpleBooleanProperty checkboxProperty() {
        return checkbox;
    }

    public String getDocDomainName() {
        return docDomainName.get();
    }

    public void setDocDomainName(String docDomainName) {
        this.docDomainName.set(docDomainName);
    }

    public SimpleStringProperty docDomainNameProperty() {
        return docDomainName;
    }

    public String getDocTypeName() {
        return docTypeName.get();
    }

    public void setDocTypeName(String docTypeName) {
        this.docTypeName.set(docTypeName);
    }

    public SimpleStringProperty docTypeNameProperty() {
        return docTypeName;
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public String getAuthor() {
        return author.get();
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public String getKeyword() {
        return keyword.get();
    }

    public void setKeyword(String keyword) {
        this.keyword.set(keyword);
    }

    public SimpleStringProperty keywordProperty() {
        return keyword;
    }

    public String getSummary() {
        return summary.get();
    }

    public void setSummary(String summary) {
        this.summary.set(summary);
    }

    public SimpleStringProperty summaryProperty() {
        return summary;
    }

    public String getFilename() {
        return filename.get();
    }

    public void setFilename(String filename) {
        this.filename.set(filename);
    }

    public SimpleStringProperty filenameProperty() {
        return filename;
    }

    public String getFiletype() {
        return filetype.get();
    }

    public void setFiletype(String filetype) {
        this.filetype.set(filetype);
    }

    public SimpleStringProperty filetypeProperty() {
        return filetype;
    }

    public Long getFilesize() {
        return filesize.get();
    }

    public void setFilesize(Long filesize) {
        this.filesize.set(filesize);
    }

    public SimpleLongProperty filesizeProperty() {
        return filesize;
    }

    public String getOldname() {
        return oldname.get();
    }

    public void setOldname(String oldname) {
        this.oldname.set(oldname);
    }

    public SimpleStringProperty oldnameProperty() {
        return oldname;
    }

    public String getRelapath() {
        return relapath.get();
    }

    public void setRelapath(String relapath) {
        this.relapath.set(relapath);
    }

    public SimpleStringProperty relapathProperty() {
        return relapath;
    }

    public String getOper() {
        return oper.get();
    }

    public void setOper(String oper) {
        this.oper.set(oper);
    }

    public SimpleStringProperty operProperty() {
        return oper;
    }

    public String getOptime() {
        return optime.get();
    }

    public void setOptime(String optime) {
        this.optime.set(optime);
    }

    public SimpleStringProperty optimeProperty() {
        return optime;
    }

}
