package board.sanghyuk.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.sanghyuk.cmt.CmtDAO;
import board.sanghyuk.utils.MyUtils;

@WebServlet("/board/detail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.getLoginUser(request).getIuser();
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		BoardVO fav = BoardDAO.selBoard(iboard,iuser);
		System.out.println("iboard : "+ iboard);
		System.out.println("iuser : "+ iuser);
		request.setAttribute("data", fav);
		MyUtils.openJsp("board/detail", request, response);
	}
}
