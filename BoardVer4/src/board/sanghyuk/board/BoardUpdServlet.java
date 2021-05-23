package board.sanghyuk.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.sanghyuk.utils.MyUtils;

@WebServlet("/board/mod")
public class BoardUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		BoardVO data = BoardDAO.selBoard(iboard, iuser);
		request.setAttribute("data", data);
		MyUtils.openJsp("board/mod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		int iboard = MyUtils.getParamInt("iboard", request);
		vo.setIboard(iboard);
		vo.setIuser(MyUtils.getLoginUserPk(request));
		vo.setTitle(request.getParameter("title"));
		vo.setCtnt(request.getParameter("ctnt"));
		BoardDAO.updBoard(vo);
		System.out.println("iboard !! : "+iboard);
		System.out.println("TITLE :"+vo.getTitle());
		response.sendRedirect("detail?iboard="+iboard);
	}
}
