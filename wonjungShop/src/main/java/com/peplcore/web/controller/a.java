package com.peplcore.web.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peplcore.blogic.member.MemberDAO;
import com.peplcore.blogic.member.MemberDTO;

/**
 * Servlet implementation class a
 */
@WebServlet("/a")
public class a extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MemberDAO dao= null;
       MemberDTO member= null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public a() {
        super();
        dao = new MemberDAO();
        member = new MemberDTO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Request dispatcher
	}

}
