package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardMapper;
import com.example.demo.vo.BoardDTO;

@Service
public class BoardServiceImpl  implements BoardService{
  @Autowired
  private BoardMapper bMapper;
 
	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return bMapper.list();
	}

	@Override
	public void insert(BoardDTO board) {
		bMapper.insert(board);
		
	}

	@Override
	public BoardDTO findByNum(int num) {
		return bMapper.findByNum(num);
	}

	@Override
	public void update(BoardDTO board) {
		bMapper.update(board);
	}

	@Override
	public void delete(int num) {
		bMapper.delete(num);
		
	}

	@Override
	public int count() {
		return bMapper.count();
	}



}
