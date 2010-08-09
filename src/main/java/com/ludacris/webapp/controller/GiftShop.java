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
public class GiftShop extends BaseController {

	@Autowired
	private ProductManager productManager;
	
	@RequestMapping("/giftshop/home.htm")
	public String home(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("musics", productManager.findAllProductByCategory(Category.MUSIC.name(), 0));
		request.setAttribute("toys", productManager.findAllProductByCategory(Category.TOYS.name(), 0));
		request.setAttribute("gears", productManager.findAllProductByCategory(Category.GEAR.name(), 0));
		request.setAttribute("videos", productManager.findAllProductByCategory(Category.VIDEOS.name(), 0));
		return "shop/home";
	}
	
	@RequestMapping("/giftshop/product.htm")
	public String product(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String productId = request.getParameter("productId");
		if(productId == null){
			request.setAttribute("outputMsg", "The product could not be found.");
			return "errors";
		}
		
		Product product = this.productManager.get(Long.parseLong(productId));

		request.setAttribute("product", product);
		return "shop/product";
	}
	
	@RequestMapping("/giftshop/subcategory.htm")
	public String subcategory(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String category = request.getParameter("category");
		String subcategory =  request.getParameter("subcategory");
		
		if(category == null){
			request.setAttribute("outputMsg", "The category could not be found.");
			return "errors";
		}
		
		
		if(subcategory == null){
			request.setAttribute("outputMsg", "The subcategory could not be found.");
			return "errors";
		}
		
		
		String start = request.getParameter("start");
		if(start == null){
			start = "0";
		}
		List<Product> products = this.productManager.findAllProductBySubcategory(category, subcategory, Integer.parseInt(start));
		request.setAttribute("products", products);
		return "shop/subcategory";
	}
	
	@RequestMapping("/giftshop/category.htm")
	public String category(HttpServletRequest request,
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
		List<Product> products = this.productManager.findAllProductByCategory(category, Integer.parseInt(start));
		request.setAttribute("products", products);
		return "shop/category";
	}
}
