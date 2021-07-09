package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.CommentDTO;

public interface CommentService {
	//추가
    public void insert(CommentDTO comment);
	//전체보기
    public List<CommentDTO> getList(int bnum);
	//댓글삭제
    public void delete(int cnum);

}
