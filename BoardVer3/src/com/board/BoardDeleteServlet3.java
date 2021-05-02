package com.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del3")
public class BoardDeleteServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		request.setAttribute(iboard, BoardDAO.deleteBoard(intIboard));
		System.out.println("iboard : " + iboard);
		response.sendRedirect("/list3");
	}

}
