package com.jhenrique.tictactoe.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movement {

	@JsonProperty("id")
	private String gameId;
	private String player;
	private Position position;
	
	public Movement() {}
	
	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId.toUpperCase();
	}

	public void setPlayer(String player) {
		this.player = player.toUpperCase();
	}

	public String getPlayer() {
		return player;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
