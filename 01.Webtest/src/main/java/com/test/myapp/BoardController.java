package com.test.myapp;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("rxo")
	SqlSession sql;
	
	@RequestMapping("new")
	public String newWrite() {
		return "new";
	}

}
