package com.myweb.board.service;

import java.util.List;

import com.myweb.board.dto.BoardDTO;
import com.myweb.board.entity.Board;

public interface BoardService {
	Long register(BoardDTO bdto);

	List<BoardDTO> getList();
	
	BoardDTO getDetail(Long bno);

	default Board convertDtoToEntity(BoardDTO bdto) {
		return Board.builder().bno(bdto.getBno()).title(bdto.getTitle()).writer(bdto.getWriter())
				.content(bdto.getContent()).build();
	}

	default BoardDTO convertEntityToDto(Board board) {
		return BoardDTO.builder().bno(board.getBno()).title(board.getTitle()).writer(board.getWriter())
				.content(board.getContent()).regAt(board.getRegAt()).modAt(board.getModAt()).build();
	}

	void remove(Long bno);

	Long modify(BoardDTO bdto);
}
