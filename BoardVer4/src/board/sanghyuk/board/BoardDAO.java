package board.sanghyuk.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.sanghyuk.utils.DBUtils;

public class BoardDAO {
	public static List<BoardVO> boardList(){
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.iboard, A.title, A.regdt, B.unm " 
				   + " FROM t_board A " 
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser "
				   + " ORDER BY A.iboard DESC ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardVO param = new BoardVO();
				list.add(param);
				param.setIboard(rs.getInt("iboard"));
				param.setTitle(rs.getString("title"));
				param.setRegdt(rs.getString("regdt"));
				param.setUnm(rs.getString("unm"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	public static BoardVO selBoard(int iboard,int iuser) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT A.ctnt, A.title, A.regdt, A.iuser, B.unm"
				   + " FROM t_board A " 
				   + " INNER JOIN t_user B "
				   + " ON A.iuser = B.iuser "
				   + " WHERE A.iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps  = con.prepareStatement(sql);
			ps.setInt(1,iboard);
			rs = ps.executeQuery();
			if(rs.next()) {
				BoardVO param = new BoardVO();
				param.setIboard(iboard);
				param.setIuser(rs.getInt("iuser"));
				param.setCtnt(rs.getString("ctnt"));
				param.setTitle(rs.getString("title"));
				param.setRegdt(rs.getString("regdt"));
				param.setUnm(rs.getString("unm"));
				return param;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		} return null;
	}
	public static int insBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_board " 
				   + " (title,ctnt,iuser) " 
				   + " VALUES(?,?,?) ";
		try {
			con = DBUtils.getCon();
			ps  = con.prepareStatement(sql);
			ps.setString(1,param.getTitle());
			ps.setString(2,param.getCtnt());
			ps.setInt(3,param.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		} return 0;
	}
	public static int updBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " UPDATE t_board "
				   + " SET title = ? "
				   + " ,ctnt = ? "
				   + " WHERE iboard = ? "
				   + " AND iuser = ? ";
		try {
			con = DBUtils.getCon();
			ps  = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			ps.setInt(4, param.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		} return 0;
	}
	public static int delBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " DELETE FROM t_board "
				   + " WHERE iboard = ? "
				   + " AND iuser = ? ";
		try {
			con = DBUtils.getCon();
			ps  = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		} return 0;
	}
}
