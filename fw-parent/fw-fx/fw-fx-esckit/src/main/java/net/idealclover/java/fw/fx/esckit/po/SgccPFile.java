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
@Alias("SgccPFile")
public class SgccPFile implements Serializable {

    private Long id;
    private String filename;
    private String filepath;
    private String filetype;
    private long filesize;
    private Date uploadtime;
    private String uploadopr;
    private Date modifytime;
    private String modifyopr;
    private Integer modifycount;
    private String oldname;
    private String storetype;
    private String relapath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getUploadopr() {
        return uploadopr;
    }

    public void setUploadopr(String uploadopr) {
        this.uploadopr = uploadopr;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getModifyopr() {
        return modifyopr;
    }

    public void setModifyopr(String modifyopr) {
        this.modifyopr = modifyopr;
    }

    public Integer getModifycount() {
        return modifycount;
    }

    public void setModifycount(Integer modifycount) {
        this.modifycount = modifycount;
    }

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname;
    }

    public String getStoretype() {
        return storetype;
    }

    public void setStoretype(String storetype) {
        this.storetype = storetype;
    }

    public String getRelapath() {
        return relapath;
    }

    public void setRelapath(String relapath) {
        this.relapath = relapath;
    }

}
