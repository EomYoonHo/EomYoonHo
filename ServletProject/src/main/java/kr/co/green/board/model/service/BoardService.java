package kr.co.green.board.model.service;

import java.util.ArrayList;

import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.common.PageInfo;

public interface BoardService {
	// 게시글 목록 조회
	public ArrayList<BoardDTO> boardList(PageInfo pi);
	
	// 전체 게시글 수
	public int boardListCount();

}
