package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import DAO.MemberDAO;	//데이터베이스 접속에 관련된 메서드들 집합
import DTO.Member;		//데이터를 이전할때 사용할 객체모양

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis=request.getRequestDispatcher("login.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		System.out.println("받아온 데이터 : "+id+", "+pwd);
		MemberDAO mDAO=MemberDAO.getInstance();
		int result=mDAO.userCheck(id, pwd);
		System.out.println("로그인 결과 : "+result);
		
		String url="login";
		if(result==1) {
			Member m=mDAO.getMember(id);	
			HttpSession session=request.getSession();	
			session.setAttribute("loginUser", m); 		
			request.setAttribute("msg", "로그인에 성공하였습니다.");
			url="index.jsp";
		}else if(result==0) {
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
		}else if(result==-1) {
			request.setAttribute("msg", "존재하지 않는 회원입니다.");
		}
		RequestDispatcher dis=request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}
