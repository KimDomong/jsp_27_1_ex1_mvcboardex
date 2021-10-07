package com.domong.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domong.ex.dao.BDao;
import com.domong.ex.dto.BDto;

public class  BContentCommand implements BCommand{

	public BContentCommand() {
		
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bid = request.getParameter("bid");
		BDao dao = new BDao();
		BDto dto = dao.contentView(bid);
		
		System.out.println(bid);

		request.setAttribute("content_view", dto);
	}

	
}