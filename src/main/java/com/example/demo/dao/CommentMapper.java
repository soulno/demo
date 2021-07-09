package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.BoardDTO;
import com.example.demo.vo.CommentDTO;

@Mapper
public interface CommentMapper {
	public List<CommentDTO> getList(int bnum);  // 전체보기
	public void insert(CommentDTO board); //추가
	public CommentDTO findByNum(int cnum); //상세보기
	public void delete(int cnum); //삭제


}
