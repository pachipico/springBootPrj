package com.myweb.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.board.dto.BoardDTO;
import com.myweb.board.entity.Board;
import com.myweb.board.entity.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository repository;
	
	@Override
	public Long register(BoardDTO bdto) {
		log.info(">>> {}", bdto);
		return repository.save(convertDtoToEntity(bdto)).getBno();
	}

	@Override
	public List<BoardDTO> getList() {
		List<Board> list = repository.findAll();
		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();
		for (Board board : list) {
			dtoList.add(convertEntityToDto(board));
		}
		return dtoList;
	}

	@Override
	public BoardDTO getDetail(Long bno) {
		Optional<Board> board = repository.findById(bno);
		return board.isPresent() ? convertEntityToDto(board.get()) : null;
	}

	@Override
	public void remove(Long bno) {
		repository.deleteById(bno);
	}

	@Override
	public Long modify(BoardDTO bdto) {
		Optional<Board> board = repository.findById(bdto.getBno());
		if(board.isPresent()) {
			Board entity = board.get();
			entity.setTitle(bdto.getTitle());
			entity.setContent(bdto.getContent());
			return repository.save(entity).getBno();
		}
		return null;
	}

	

}
