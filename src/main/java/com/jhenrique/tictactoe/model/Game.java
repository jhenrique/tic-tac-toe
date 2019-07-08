package com.jhenrique.tictactoe.model;

import java.math.BigInteger;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Game {

	private String id;
	private String playerStart;
	private String playerLast;
	private String playerWinner;
	private Board board = new Board();
	
	public Game() {
		this.id = new BigInteger(130, new Random()).toString(32).toUpperCase();
		int random = new Random().nextInt(11);
		this.playerStart =  random < 6 ?  "X" : "O";
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

	public String getPlayerLast() {
		return playerLast;
	}

	public void setPlayerLast(String playerLast) {
		this.playerLast = playerLast;
	}

	public String getPlayerWinner() {
		return playerWinner;
	}

	public void setPlayerWinner(String playerWinner) {
		this.playerWinner = playerWinner;
	}

	@JsonIgnore
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
