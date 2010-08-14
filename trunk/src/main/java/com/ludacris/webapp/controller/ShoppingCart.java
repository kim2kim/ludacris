package com.ludacris.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCart extends BaseController{

	@RequestMapping("/shopingcart.do")
	public String cart(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "cart";
	}
}
