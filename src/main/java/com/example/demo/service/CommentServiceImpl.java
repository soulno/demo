package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.BoardMapper;
import com.example.demo.dao.CommentMapper;
import com.example.demo.vo.CommentDTO;

@Service
public class CommentServiceImpl  implements CommentService{
	@Autowired
	private CommentMapper cmapper;
	
	@Autowired
	private BoardMapper bmapper;
   //추가
	@Override
	
	public void insert(CommentDTO comment) {
		comment.setUserid("aaa");
		cmapper.insert(comment);
		bmapper.updateReplyCnt(comment.getBnum(), 1);
	}

	@Override
	public List<CommentDTO> getList(int bnum) {
		return cmapper.getList(bnum);
	}

	@Transactional
	@Override
	public void delete(int cnum) {
		// TODO Auto-generated method stub
		CommentDTO cdto = cmapper.findByNum(cnum);
		//HashMap<String, Integer> map = new HashMap<String, Ineger>();
		//map.put("bnum", cdto.getBnum());
		//map.put("amount", -1);
		
		bmapper.updateReplyCnt(cdto.getBnum(), -1);
		cmapper.delete(cnum);
		
	}

}
