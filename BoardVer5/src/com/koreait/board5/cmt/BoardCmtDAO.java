package com.koreait.board5.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;
import com.koreait.board5.board.BoardEntity;

public class BoardCmtDAO {
	public static int insBoardCmt(BoardCmtEntity param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_board_cmt "
				   + " (iboard,iuser,cmt) "
				   + " VALUES(?,?,?) ";
		try {
			con = DBUtils.getCon();
			ps  = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		} return result;
	}
	
	public static List<BoardCmtDomain> selBoardCmtList(BoardCmtEntity param){
		List<BoardCmtDomain> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT A.iuser, A.cmt, A.regdate, A.icmt, B.unm AS writerNm "
				   + " FROM t_board_cmt A "
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser "
				   + " WHERE A.iboard = ? "
				   + " ORDER BY A.icmt ";
		try {
			con = DBUtils.getCon();
			ps  = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardCmtDomain vo = new BoardCmtDomain();
				list.add(vo);
				vo.setIboard(vo.getIboard());
				vo.setIuser(rs.getInt("iuser"));
				vo.setCmt(rs.getString("cmt"));
				vo.setWriterNm(rs.getString("writerNm"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setIcmt(rs.getInt("icmt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		} return list;
	}
}
