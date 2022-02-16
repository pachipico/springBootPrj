package com.myweb.board.repos;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myweb.board.entity.Board;
import com.myweb.board.entity.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardReposTest {

	@Autowired
	private BoardRepository boardRepos;

	@Test
	public void insertDummyTest() {
		IntStream.rangeClosed(1, 1000).forEach(i -> {
			Board board = Board.builder()
					.title("This is Title of " + i)
					.content("This is Content of " + i)
					.writer("Tester" + i + "@tester.com").build();
			log.info(">>> {}", boardRepos.save(board));
		});
	}
}
