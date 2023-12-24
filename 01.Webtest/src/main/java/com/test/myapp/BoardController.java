package com.test.myapp;

import java.util.List;

import org.springframework.ui.Model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.PageVO;
import rxo.board.AttachmentVO;
import rxo.board.BoardDAO;
import rxo.board.BoardVO;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("rxo")
	SqlSession sql;

	@Autowired
	BoardDAO boardDAO;

	@RequestMapping("new")
	public String newWrite() {
		return "new";
	}

	@RequestMapping("insert")
	public String insertBoard(BoardVO vo, AttachmentVO vo2) {
		sql.insert("board.write", vo);
		if (vo2 != null && vo2.getFile_Path() != null && !vo2.getFile_Path().isEmpty()) {
			sql.insert("board.attachFile", vo2);
		}
		return "main";
	}

//	@RequestMapping("list")
//	public String getBoardList(Model model, PageVO page) {
//		model.addAttribute("page", boardDAO.board_list(page));
//		return "main";
//	}

}
