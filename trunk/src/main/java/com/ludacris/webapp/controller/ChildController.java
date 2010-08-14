package com.ludacris.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChildController extends BaseController{

	@RequestMapping("/child/page1.do")
	public String page1() throws ServletException, IOException {
		return "child/page1";
	}
	
	@RequestMapping("/child/page2.do")
	public String page2() throws ServletException, IOException {
		return "child/page2";
	}
	
	@RequestMapping("/child/page3.do")
	public String page3() throws ServletException, IOException {
		return "child/page3";
	}
}
