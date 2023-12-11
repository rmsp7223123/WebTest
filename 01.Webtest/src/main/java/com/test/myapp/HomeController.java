package com.test.myapp;

import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public String loginCheck(MemberVO vo) {
	    String returnUrl = "";
	    int login = sql.selectOne("login.loginCheck", vo);
	    if (login == 1) {
	        returnUrl = "redirect:/main"; // 로그인 성공 시
	    } else {
	        returnUrl = "redirect:/"; // 로그인 실패 시
	    }
	    return returnUrl;
	}

	
}
