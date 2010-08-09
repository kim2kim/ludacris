package com.ludacris.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ludacris.model.Game;
import com.ludacris.service.GameManager;

@Controller
public class GamesPage extends BaseController {

	@Autowired
	private GameManager gamesManager;

	@RequestMapping("/games/home.htm")
	public String play(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String gameId = request.getParameter("gameId");
		if(gameId == null){
			request.setAttribute("outputMsg", "The game could not be found.");
			return "errors";
		}
		
		Game game = this.gamesManager.get(Long.parseLong(gameId));

		request.setAttribute("game", game);
		return "games/play";
	}
	
	@RequestMapping("/games/gallery.htm")
	public String gallery(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = request.getParameter("start");
		if(start == null){
			start = "0";
		}
		
		List<Game> games = this.gamesManager.getAll();
		
		request.setAttribute("games", games);
		return "games/gallery";
	}
}
