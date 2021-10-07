package com.domong.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);

}   //execute 공통된 형식을 만들기 위함
