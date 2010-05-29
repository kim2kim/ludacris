package com.ludacris.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParentController {
	
	@RequestMapping("/parent/page1.html")
	public String page1() throws ServletException, IOException {
		return "parent/page1";
	}
	
	@RequestMapping("/parent/page2.html")
	public String page2() throws ServletException, IOException {
		return "parent/page2";
	}
	
	@RequestMapping("/parent/page3.html")
	public String page3() throws ServletException, IOException {
		return "parent/page3";
	}
}
