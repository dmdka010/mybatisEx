package org.iclass.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;

public class IoginActionController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		HashMap<String, String> loginMap = new HashMap<String, String>();
		
		loginMap.put("id", id);
		loginMap.put("password", pw);
		
		NewMember vo = dao.login(loginMap);
		
		HttpSession session = request.getSession();
		
		if(vo != null){
			session.setAttribute("id", id);
			response.sendRedirect("login_ok.jsp");
		}else{
			response.sendRedirect("login.jsp?type=false");
		}
		response.sendRedirect(request.getContextPath());
	}

}
