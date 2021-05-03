package com.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod3")
public class BoardModServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		System.out.println("iboard : "+iboard);
		
		int intIboard = Integer.parseInt(iboard); // 실제 값은 정수형 이기에 형변환
		
		BoardVO3 data = BoardDAO.selBoard(intIboard); // 객체명이 list가 붙어잇다는건
		request.setAttribute("data",data);
		
		request.getRequestDispatcher("/WEB-INF/view/mod3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int intIboard = Integer.parseInt(iboard);
		BoardVO3 vo = new BoardVO3();
		vo.setIboard(intIboard);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		BoardDAO.updataBoard(vo);
		response.sendRedirect("/detail3?iboard="+intIboard);
	}

}
