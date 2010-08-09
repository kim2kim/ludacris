package com.ludacris.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.ludacris.dao.GameDao;
import com.ludacris.model.Game;

@Repository("gameDao")
public class GameDaoHibernate extends GenericDaoHibernate<Game, Long> implements GameDao{

	public GameDaoHibernate() {
		super(Game.class);
	}

}
