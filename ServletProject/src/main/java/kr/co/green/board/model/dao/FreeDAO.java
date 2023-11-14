package kr.co.green.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.common.PageInfo;

public class FreeDAO {
	private PreparedStatement pstmt;

	public ArrayList<BoardDTO> boardList(Connection con, PageInfo pi) {                            
		// posts 변수명도 많이 사용됨
		ArrayList<BoardDTO> list = new ArrayList<>();
		
		// 1. 쿼리 작성
// 		MySQL offset 페이징
//		String query = "SELECT fb_idx,"
//				+ "			   fb_title,"
//				+ "			   fb_in_date,"
//				+ "			   fb_views,"
//				+ "			   fb_writer"
//				+ "		FROM free_board"
//				+ "		LIMIT ? OFFSET ?";
		
// 		MySQL cursor 페이징
//		String query = "SELECT fb_idx,"
//				+ "			   fb_title,"
//				+ "			   fb_in_date,"
//				+ "			   fb_views,"
//				+ "			   fb_writer"
//				+ "		FROM free_board"
//				+ "		WHERE fb_idx > ? LIMIT ?";
		
		String query = "SELECT fb2.*"
				+ "		FROM (SELECT rownum AS rnum, fb.* "
				+ "			  FROM (SELECT fb_idx,"
			+ "						 	   fb_title,"
			+ "						 	   fb_in_date,"
			+ "						  	   fb_views,"
			+ "						 	   fb_writer"
			+ "				  		FROM free_board"
			+ "				  		ORDER BY fb_in_date DESC) fb) fb2"
			+ "			WHERE rnum BETWEEN ? AND ?";
		
		try {
			// 2. 쿼리 사용할 준비
			pstmt = con.prepareStatement(query);
			
			// 3. 물음표 있으면 값 삽입
			
			// 0~5
			// 5~5
			// 10~5
			pstmt.setInt(1, pi.getOffset()); // 0
			pstmt.setInt(2, pi.getBoardLimit()); // 5
			
			// 4. 쿼리 실행
			ResultSet rs = pstmt.executeQuery();
			
//			BoardDTO board = new BoardDTO();
			while(rs.next()) {
				int idx = rs.getInt("FB_IDX");
				String title = rs.getString("FB_TITLE");                            
				String inDate = rs.getString("FB_IN_DATE");
				int views = rs.getInt("FB_VIEWS");
				String writer = rs.getString("FB_WRITER");
				
				BoardDTO board = new BoardDTO();
				
				board.setIdx(idx);
				board.setTitle(title);
				board.setInDate(inDate);
				board.setViews(views);
				board.setWriter(writer);
				
				list.add(board);
			}
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int boardListCount(Connection con) {
		String query = "SELECT count(*) AS cnt FROM free_board";
		
		try {
			pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("CNT");
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

}
