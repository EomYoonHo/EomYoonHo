package kr.co.green.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.green.board.model.dao.FreeDAO;
import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.common.DatabaseConnection;
import kr.co.green.common.PageInfo;

public class BoardServiceImpl implements BoardService {
	private Connection con;
	private DatabaseConnection dc;
	private FreeDAO freeDAO;
	
	public BoardServiceImpl() {
		freeDAO = new FreeDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	// 게시글 목록 조회
	public ArrayList<BoardDTO> boardList(PageInfo pi) {
		return freeDAO.boardList(con, pi);
	}
	
	
	// 전체 게시글 수
	public int boardListCount() {
		return freeDAO.boardListCount(con);
	}
	
	
}











