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
		System.out.println("�ҷ��Ӵ�?");
		
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";   }    //������������ �۾��� UIȭ�� �Դϴ�.
		 
		else if(com.equals("/write.do")) {
			command = new BWriteCommand();  //'write.do'��û�� ������ �ش� Ŀ��带 �����Ͽ� ������ �������� �� 'list.do'�������� ������
		 	command.execute(request,response); 
		 	viewPage = "list.do";            }
		
		else if(com.equals("/list.do")){
			command = new BListCommand();  //�񸮽�ƮĿ���� ����!
			command.execute(request,response);
			viewPage = "list.jsp";//�޼��� �����Ҽ� �ֵ���~
		}
		else if(com.equals("/content_view.do")){
			command = new BContentCommand();  //����ƮĿ���� ����!
			command.execute(request,response);
			viewPage = "content_view.jsp";//�޼��� �����Ҽ� �ֵ���~
		}
		RequestDispatcher dispatcher =  request.getRequestDispatcher(viewPage); //�������ϴ� ��ü�� �״�� ����
		dispatcher.forward(request, response);
	}
}
