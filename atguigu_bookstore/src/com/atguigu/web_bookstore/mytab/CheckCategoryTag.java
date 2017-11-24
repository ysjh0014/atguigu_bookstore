package com.atguigu.web_bookstore.mytab;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.atguigu.web_bookstore.dao.BookDao;
import com.atguigu.web_bookstore.dao.impl.BookDaoImpl;
/*
 * 自定义标签
 * <CheckCategory id=${}>
 * 	${content}
 */
public class CheckCategoryTag extends SimpleTagSupport {

	
	private BookDao bookDao = new BookDaoImpl();
	
	private String id;
	
	
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void doTag() throws JspException, IOException {
		boolean has = bookDao.hasBookByCategorysId(id);
		JspFragment fragment = getJspBody();
		StringWriter writer = new StringWriter();
		fragment.invoke(writer);
		String result = writer.toString();
		if(has) {
			result = "<button disabled='disabled'>删除</button>";
		}
		getJspContext().getOut().write(result);
	}
}
