package com.demo.mytags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

public class Tag1 extends RequestContextAwareTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = 423123734252776350L;

	@Override
	protected int doStartTagInternal() throws Exception {		
		return 0;
	}

	@Override
	public void doFinally() {
		JspWriter writer = pageContext.getOut();
		try {
			String page = "../mytags/tag1/index.jsp";
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			request.getRequestDispatcher(page);
			pageContext.include(page);
		} catch (Exception e) {
			try {
				writer.print(e.getMessage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
