package com.zhxrui.maven.newspublish.models;
import java.util.Date;
public class Afnews {
	private int id;
	private String title;
	private String content;
	private Date createtime;
	private int sign;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}

}
