package com.musicplayer.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.musicplayer.entity.User;

public class AutoLoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
    
	//�Զ���½������ʵ��
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		path = uri.substring(path.length()); 

		//����������Դ����login.jsp��Ҳ����/servlet/loginServlet��������ִ��
		if (!("/login.jsp".equals(path) || "/servlet/loginServlet".equals(path))) {
			User user = (User) request.getSession().getAttribute("user");
			//���session�õ���user����˵���Ѿ���¼�����Զ���¼����
			//��ô������һ����Դʱ�Ͳ���ִ���Զ���¼�ˡ�
			//�û�û�е�¼�������ǲ�ִ���Զ���¼ 
			if (user == null) {
				// 2������ҵ��
				// �õ�cookies����
				Cookie[] cookies = request.getCookies();
				String username = "";
				String password = "";
				// ���������ҵ���Ҫ��user�������Ϣ
				for (int i = 0; cookies != null && i < cookies.length; i++) {
					if ("user".equals(cookies[i].getName())) {
						String value = cookies[i].getValue();// tom&123
						String[] values = value.split("&");
						username = values[0];
						password = values[1];
					}
				}

				// ��¼���������ڲ��ϣ�
				
			}
		}
		
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
