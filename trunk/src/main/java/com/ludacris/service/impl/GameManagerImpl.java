package com.ludacris.service.impl;

import org.springframework.stereotype.Service;

import com.ludacris.model.Game;
import com.ludacris.service.GameManager;

@Service("gameManager")
public class GameManagerImpl extends GenericManagerImpl<Game, Long> implements GameManager{

}
