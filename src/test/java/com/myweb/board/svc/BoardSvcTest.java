package com.myweb.board.svc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myweb.board.dto.BoardDTO;
import com.myweb.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardSvcTest {

	@Autowired
	private BoardService service;
	
	@Test
	public void registerTest() {
		BoardDTO bdto = BoardDTO.builder()
								.title("Board Title Register Test")
								.writer("Board Writer Register Test")
								.content("Board Content Register Test").build();
		service.register(bdto);
		log.info(">>> {}", bdto);
	}
}
