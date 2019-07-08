package com.jhenrique.tictactoe.model.dto;

public class ResultDto {

	private String status;
	private String winner;
	
	public ResultDto(String status, String winner) {
		this.status = status;
		this.winner = winner;
	}

	
	public String getStatus() {
		return status;
	}

	public String getWinner() {
		return winner;
	}

}
