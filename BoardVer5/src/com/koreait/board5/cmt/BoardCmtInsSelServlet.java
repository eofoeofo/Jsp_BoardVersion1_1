package com.koreait.board5.cmt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/cmtInsSel")
public class BoardCmtInsSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		List<BoardCmtDomain> list = BoardCmtDAO.selBoardCmtList(param);
		
		response.getWriter()
		.append(String.valueOf(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(MyUtils.getParamInt("iboard", request));
		param.setIuser(MyUtils.getLoginUserPk(request));
		param.setCmt(request.getParameter("cmt"));
		int result = BoardCmtDAO.insBoardCmt(param);
		
		response.getWriter()
		.append(String.valueOf(result));
	}
}