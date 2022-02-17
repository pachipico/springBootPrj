package com.myweb.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.board.dto.BoardDTO;
import com.myweb.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService bsv;
	
	
	@PostMapping("/modify")
	public String modify (RedirectAttributes reAttr, BoardDTO bdto) {
		Long bno = bsv.modify(bdto);
		reAttr.addFlashAttribute("modify", bno);
		return "redirect:/board/detail?bno=" + bno; 
	}
	
	@PostMapping("/remove")
	public String delete(Long bno, RedirectAttributes reAttr) {
		bsv.remove(bno);
		reAttr.addFlashAttribute("result", bno);
		return "redirect:/board/list";
	}
	
	@GetMapping("/detail")
	public void detail(Long bno, Model model) {
		model.addAttribute("bdto", bsv.getDetail(bno));
		
	}
	
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", bsv.getList());
	}
	
	@PostMapping("/register")
	public String register(RedirectAttributes reAttr, BoardDTO bdto) {
		Long bno = bsv.register(bdto);
		reAttr.addFlashAttribute("result", bno);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		log.info(">>> /board/register");
	}
}
