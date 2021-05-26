package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO param = new BoardDTO();
		final int recordCnt = 5;
		int cPage = MyUtils.getParamInt("cPage", request);
		if(cPage == 0) {
			cPage = 1;
		}
		int startIdx = (cPage - 1) * recordCnt;
		param.setStartIdx(startIdx);
		param.setRecordCnt(recordCnt);
		
		int searchType = MyUtils.getParamInt("searchType", request);
		String searchText = request.getParameter("searchText");
		if(searchType != 0 && searchText != null && !searchText.equals("")) {
			param.setSearchType(searchType);
			param.setSearchText(searchText);
		}
		System.out.println("paging : " + BoardDAO.selPagingCnt(param));
		request.setAttribute("pagingCnt", BoardDAO.selPagingCnt(param));
		request.setAttribute("list", BoardDAO.selBoardList(param));
		MyUtils.openJsp("리스트", "board/boardList", request, response);
	}
}