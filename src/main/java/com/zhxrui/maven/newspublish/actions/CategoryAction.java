package com.zhxrui.maven.newspublish.actions;

import java.util.List;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhxrui.maven.newspublish.dao.CategoryDao;
import com.zhxrui.maven.newspublish.models.Category;

public class CategoryAction extends ActionSupport {
	private Category category;
	private CategoryDao cd = new CategoryDao();
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Category> cList= cd.selectListByTopId(category.getTopId());
		request.setAttribute("clist", cList);
		return "clist";
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
