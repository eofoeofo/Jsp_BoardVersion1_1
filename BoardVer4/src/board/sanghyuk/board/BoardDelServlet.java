package board.sanghyuk.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.sanghyuk.utils.MyUtils;

@WebServlet("/board/del")
public class BoardDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		vo.setIboard(MyUtils.getParamInt("iboard", request));
		vo.setIuser(MyUtils.getLoginUserPk(request));
		BoardDAO.delBoard(vo);
		response.sendRedirect("/board/list");
	}
}
