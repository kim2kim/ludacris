package com.ludacris.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ludacris.enums.Category;
import com.ludacris.model.Product;
import com.ludacris.service.ProductManager;

@Controller
public class MusicPage extends BaseController {
	
	@Autowired
	private ProductManager productManager;
	
	@RequestMapping("/music/home.do")
	public String home(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String category = request.getParameter("category");
		
		if(category == null){
			request.setAttribute("outputMsg", "The category could not be found.");
			return "errors";
		}
		
		String start = request.getParameter("start");
		if(start == null){
			start = "0";
		}
		
		List<Product> products = this.productManager.findAllProductByCategory(Category.MUSIC.name(), Integer.parseInt(start));
		request.setAttribute("songs", products);
		
		return "music/home";
	}
	
	@RequestMapping("/music/song.do")
	public String song(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String songId = request.getParameter("songId");
		if(songId == null){
			request.setAttribute("outputMsg", "The song could not be found.");
			return "errors";
		}
		
		Product song = this.productManager.get(Long.parseLong(songId));

		request.setAttribute("song", song);
		return "music/song";
	}

}
