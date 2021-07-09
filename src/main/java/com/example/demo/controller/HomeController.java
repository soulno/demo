package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.BoardService;
import com.example.demo.vo.BoardDTO;

@Controller
public class HomeController {
	@Autowired
	private BoardService bservice;
//	 @GetMapping("/")
//	 public String home() {
//		 return "home";
//	 }
	 @GetMapping("insert")
	 public String insert() {
		 return "insert";
	 }
	 @PostMapping("insert")
	 public String insert(BoardDTO board) {
		 bservice.insert(board);
		 return "redirect:list";
	 }
	 @GetMapping({"/","list"})
	 public String list(Model model) {
		List<BoardDTO> lists =  bservice.list();
		int count = bservice.count();
		model.addAttribute("lists", lists);
		model.addAttribute("count", count);
		 return "list";
	 }
	 // 상세보기
	 @GetMapping("view/{num}")
	 public String view(Model model,@PathVariable int num) {
		 BoardDTO board = bservice.findByNum(num);
		 model.addAttribute("board", board);
		 return "view";
	 }
	 //수정폼
	 @GetMapping("update/{num}")
	 public String update(Model model,@PathVariable int num) {
		 BoardDTO board = bservice.findByNum(num);
		 model.addAttribute("board", board);
		 return "update";
	 }
	 //수정하기
	 @PutMapping("update")
	 @ResponseBody
	 public String update(@RequestBody BoardDTO board) {
		 bservice.update(board);
		 return "success";
	 }
	 // 삭제하기
	 @DeleteMapping("delete/{num}")
	 @ResponseBody
	 public String delete(@PathVariable int num) {
		 bservice.delete(num);
		 return "success";
	 }
	 

}
