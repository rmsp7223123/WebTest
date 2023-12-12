package com.test.myapp;

import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rxo.member.MemberVO;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("rxo")
	SqlSession sql;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping({ "/home" })
	public String home() {
		return "main";
	}
	
	@RequestMapping("/login")
	public int loginCheck(MemberVO vo) {
		System.out.println("Received request with vo: " + vo);
	    int login = sql.selectOne("login.loginCheck", vo);
	    System.out.println("SQL executed. Result: " + login);
	    return login;
	}

	
}
