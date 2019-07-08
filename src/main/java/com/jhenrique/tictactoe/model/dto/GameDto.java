package com.jhenrique.tictactoe.model.dto;

import com.jhenrique.tictactoe.model.Game;

public class GameDto {

	private String id;
	private String playerStart;
	
	public GameDto(Game game) {
		this.setId(game.getId());
		this.setPlayerStart(game.getPlayerStart());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlayerStart() {
		return playerStart;
	}

	public void setPlayerStart(String playerStart) {
		this.playerStart = playerStart;
	}

}
