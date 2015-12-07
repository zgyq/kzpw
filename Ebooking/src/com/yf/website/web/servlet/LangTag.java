package com.yf.website.web.servlet;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class LangTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;
	
	@Override
	public int doAfterBody() throws JspException {

		String out = "";
		int lang = 0;

		try {
			lang = Integer.parseInt(""+(pageContext.getSession().getAttribute("language")));
		} catch (Exception e) {
			lang = 0;
		}

		try {

			BodyContent bc = this.getBodyContent();
			String body = bc.getString();

			if (body != null) {
				String[] langs = body.split("\\|\\|\\|");
				if (langs.length > 0 && langs.length > lang) {
					out = langs[lang];
				} else {
					out = langs[0];
				}
				bc.getEnclosingWriter().print(out);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
