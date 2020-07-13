package com.demo.mytags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.demo.services.ProductService;

public class Tag3 extends RequestContextAwareTag{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3520973824963768246L;
	@Autowired
	private ProductService productService;
	@Override
	protected int doStartTagInternal() throws Exception {		
		if(productService==null) {
			WebApplicationContext applicationContext = getRequestContext().getWebApplicationContext();
			AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
			autowireCapableBeanFactory.autowireBean(this);
		}
		return SKIP_BODY;
	}

	@Override
	public void doFinally() {
		JspWriter writer = pageContext.getOut();
		try {
			String page = "../mytags/tag3/index.jsp";
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			request.setAttribute("products", productService.findAll());
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
