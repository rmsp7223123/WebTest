package com.test.myapp;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rxo.board.AttachmentVO;
import rxo.board.BoardVO;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("rxo")
	SqlSession sql;
	
	@RequestMapping("new")
	public String newWrite() {
		return "new";
	}
	
	@RequestMapping("insert")
	public String insertBoard(BoardVO vo, AttachmentVO vo2) {
		sql.insert("board.write", vo);
		if (vo2 != null && vo2.get != null && !vo2.getFilePath().isEmpty()) {
	        sql.insert("board.attachFile", vo2);
	    }
		return "new";
	}

}
