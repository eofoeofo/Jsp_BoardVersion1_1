package board.sanghyuk.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.sanghyuk.utils.MyUtils;

@WebServlet("/board/cmt")
public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CmtVO vo = new CmtVO();
		vo.setIcmt(MyUtils.getParamInt("icmt", request));
		vo.setIboard(MyUtils.getParamInt("iboard", request));
		vo.setIuser(MyUtils.getLoginUserPk(request));
		CmtDAO.delCmt(vo);
		response.sendRedirect("detail?iboard="+MyUtils.getParamInt("iboard", request));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CmtVO vo = new CmtVO();
		int iboard = MyUtils.getParamInt("iboard", request);
		vo.setIboard(iboard);
		vo.setIcmt(MyUtils.getParamInt("icmt", request));
		vo.setCmt(request.getParameter("cmt"));
		vo.setIuser(MyUtils.getLoginUserPk(request));
		vo.setRegdate(request.getParameter("regdate"));
		System.out.println("cmt!! : " + vo.getCmt());
		if(MyUtils.getParamInt("icmt", request) != 0) {
			CmtDAO.updCmt(vo);
		} else {
			CmtDAO.insCmt(vo);
		}
		response.sendRedirect("detail?iboard="+iboard);
	}
}
