package com.ludacris.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoreController extends BaseController{
	
	@RequestMapping("/store/page1.html")
	public String page1() throws ServletException, IOException {
		return "store/page1";
	}
	
	@RequestMapping("/store/page2.html")
	public String page2() throws ServletException, IOException {
		return "store/page2";
	}
	
	@RequestMapping("/store/page3.html")
	public String page3() throws ServletException, IOException {
		return "store/page3";
	}
}
