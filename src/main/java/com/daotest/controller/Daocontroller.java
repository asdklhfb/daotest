package com.daotest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.daotest.dao.Dao;
import com.daotest.service.Daoservice;

@Controller
public class Daocontroller {
	// Service
	@Autowired
	Daoservice ds;
	
	// GET방식 요청 / daotest.do, 폼 : daotest.jsp
	@GetMapping("daotest.do")
	public String daotestGet() {
		return "daotest";
	}
	
	// POST방식 요청 / daotest.do, Insert : daolist.jsp
	@RequestMapping(value="daotest.do", method=RequestMethod.POST)
	public String daotestPost(@RequestParam Map<String, String> map) {
		ds.insert(map);
		return "redirect:/daolist.do";
	}
	
	@RequestMapping("/daolist.do")
	public ModelAndView select(Daoservice ds) {
		ModelAndView mv = new ModelAndView();
		// ModelAndView에 모델과 뷰 추가
		ArrayList<HashMap<String, String>> list = (new Dao()).select();
		
		mv.addObject("list", list);
		mv.setViewName("daolist");
		// 모델&뷰 리턴
		return mv;
	}
}
