package net.idealclover.java.fw.fx.esckit.vo;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

@Searchable
public class DocSearch {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SearchableId
	private String id;
	private String oper;
	private String opdept;
	private String optime;
	@SearchableProperty(store=Store.YES,index=Index.NOT_ANALYZED)
	private String docdomain;
	@SearchableProperty(store=Store.YES,index=Index.NOT_ANALYZED)
	private String doctype;
	private String doclevel;
	private String docstate;
	@SearchableProperty(store=Store.YES,index=Index.ANALYZED)
	private String keyword;
	@SearchableProperty(store=Store.YES,index=Index.ANALYZED)
	private String title;
	@SearchableProperty(store=Store.YES,index=Index.ANALYZED)
	private String summary;
	@SearchableProperty(store=Store.YES,index=Index.ANALYZED)
	private String author;
	@SearchableProperty(store=Store.YES,index=Index.NOT_ANALYZED)
	private String uploadtime;
	private String previewcount;
	private String downloadcount;
	@SearchableProperty(store=Store.YES,index=Index.NOT_ANALYZED)
	private String fileid;// 上传成功的文件id 隐藏的
	@SearchableProperty(store=Store.YES,index=Index.NOT_ANALYZED)
	private String filename;// 上传文件的实际名称
	@SearchableProperty(store=Store.YES,index=Index.ANALYZED)
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getOptime() {
		return optime;
	}

	public void setOptime(String optime) {
		this.optime = optime;
	}

	public String getDocdomain() {
		return docdomain;
	}

	public void setDocdomain(String docdomain) {
		this.docdomain = docdomain;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getDoclevel() {
		return doclevel;
	}

	public void setDoclevel(String doclevel) {
		this.doclevel = doclevel;
	}

	public String getDocstate() {
		return docstate;
	}

	public void setDocstate(String docstate) {
		this.docstate = docstate;
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

	public String getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getPreviewcount() {
		return previewcount;
	}

	public void setPreviewcount(String previewcount) {
		this.previewcount = previewcount;
	}

	public String getDownloadcount() {
		return downloadcount;
	}

	public void setDownloadcount(String downloadcount) {
		this.downloadcount = downloadcount;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getFileid() {
		return fileid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
