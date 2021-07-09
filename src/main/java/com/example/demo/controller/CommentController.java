package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CommentService;
import com.example.demo.vo.CommentDTO;

@RequestMapping("/reply/*")
@RestController // Controller + @ResponseBody
public class CommentController {
	@Autowired
	private CommentService cservice;
	
	//댓글 추가
	@PostMapping("commentInsert")
	@ResponseBody
	public String insert(@RequestBody CommentDTO comment) {
		cservice.insert(comment);
		return "success";
	}
	
	//댓글리스트
	@GetMapping("commentList")
	public List<CommentDTO> list(int bnum) {
		List<CommentDTO> clist = cservice.getList(bnum);
		return clist;
	}
	// 댓글 삭제
	@DeleteMapping("delete/{cnum}")
	@ResponseBody
	public int delete(@PathVariable int cnum) {
		cservice.delete(cnum);
		return cnum;
	}

}
