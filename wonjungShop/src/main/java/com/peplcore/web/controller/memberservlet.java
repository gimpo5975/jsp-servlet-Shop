package com.peplcore.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peplcore.blogic.member.MemberDAO;
import com.peplcore.blogic.member.MemberDTO;

@WebServlet("*.mc")
public class memberservlet extends HttpServlet {
	//직렬화 JVM(Java Virtual Machine 이하 JVM)의 메모리에 상주(힙 또는 스택)되어 
	//있는 객체 데이터를 바이트 형태로 변환하는 기술과 직렬화된 바이트 형태의 데이터를 객체로 
	//변환해서 JVM으로 상주시키는 형태를 같이 이야기합니다.
	/*
	 * 이 코드는 자바에서 직렬화(serialization)를 위해 사용되는 것으로, 
	 * 'serialVersionUID'라는 정적(static) 상수를 선언하고 있습니다. 
	 * serialVersionUID는 직렬화된 객체의 버전을 식별하는 데 사용됩니다. 
	 * 여기서 "1L"은 serialVersionUID의 값으로, 이 값은 개발자가 수동으로 설정할 수 있습니다.
	 * */
	private static final long serialVersionUID = 1L;
   
	//constructor
    public memberservlet() {
        super();
    }//end of constructor
    
    //service method
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//사용자 요청이 들어오면 경로를 추출
		final String URI = request.getRequestURI();
		final String PATH = URI.substring(URI.lastIndexOf("/"));
	
		switch(PATH) {
		case "/signIn.mc" : toSignIn(request, response);
			break;
		case "/signUp.mc" : toSignUp(request, response);
		break;
		case "/insertMember.mc" : insertMember(request, response);
		break;
			
		case "/logout.mc" :
			break;
		}//end of switch
		
	}//end of service

	//로그인 화면으로 이동하는 메소드
	private void toSignIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/signIn.jsp");
		dispatcher.forward(request, response);
		System.out.println("로그인 화면으로 이동완료");
	}//end of toSignIn
	
	//회원가입 화면으로 이동하는 메소드
	private void toSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/signUp.jsp");
		dispatcher.forward(request, response);
		System.out.println("회원가입 화면으로 이동완료");
	}//end of toSignUp
	
	//회원가입하는 메소드
	private void insertMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		//MemberDTO 객체 생성
		MemberDTO member = new MemberDTO();
		
		//주소 받아서 저장
		String address1 = request.getParameter("address1");
		//상세주소 받아서 저장
		String address2 = request.getParameter("address2");
		
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("pass1"));
		member.setName(request.getParameter("name"));
		member.setPhone(request.getParameter("phone"));
		member.setSsn(request.getParameter("ssn"));
		member.setEmail(request.getParameter("email"));
		member.setZipCode(request.getParameter("zipcode"));
		member.setAddress(address1+address2);//주소와 상세주소 합침
		member.setNewsAgency(request.getParameter("newsAgency"));
		member.setGender(request.getParameter("gender"));
		member.setCountrySelect(request.getParameter("countrySelect"));
		
		MemberDAO dao = new MemberDAO();
		dao.insertMember(member);
		
		//회원가입 후 메인페이지로 이동
		RequestDispatcher dispatcher =request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
		
	}//end of insertMember
	
}//end of class
