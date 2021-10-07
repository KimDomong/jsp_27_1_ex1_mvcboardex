package com.domong.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domong.ex.command.BCommand;
import com.domong.ex.command.BContentCommand;
import com.domong.ex.command.BListCommand;
import com.domong.ex.command.BWriteCommand;


@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("불러왓니?");
		
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";   }    //웹브라우저에서 글쓰기 UI화면 입니다.
		 
		else if(com.equals("/write.do")) {
			command = new BWriteCommand();  //'write.do'요청이 들어오면 해당 커멘드를 생성하여 적절한 로직실행 후 'list.do'페이지로 포워딩
		 	command.execute(request,response); 
		 	viewPage = "list.do";            }
		
		else if(com.equals("/list.do")){
			command = new BListCommand();  //비리스트커멘드랑 연결!
			command.execute(request,response);
			viewPage = "list.jsp";//메서드 실행할수 있도록~
		}
		else if(com.equals("/content_view.do")){
			command = new BContentCommand();  //컨텐트커멘드랑 연결!
			command.execute(request,response);
			viewPage = "content_view.jsp";//메서드 실행할수 있도록~
		}
		RequestDispatcher dispatcher =  request.getRequestDispatcher(viewPage); //포워딩하는 객체를 그대로 전달
		dispatcher.forward(request, response);
	}
}
