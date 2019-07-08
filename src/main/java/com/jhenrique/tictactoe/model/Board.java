package com.jhenrique.tictactoe.model;

public class Board {

	private int[][] board = new int[3][3];
	
	public Board() {}

	public int getPosicao(Position position) {
		return board[position.getX()][position.getY()];
	}

	public void setPosicao(Movement movement) {
		int mark = movement.getPlayer().equals("O") ? -1 : 1;
		board[movement.getPosition().getX()][movement.getPosition().getY()] = mark;
	}

	public int checkLines() {
		for (int line = 0; line < 3; line++) {
			if ((board[line][0] + board[line][1] + board[line][2]) == -3)
				return -1;
			if ((board[line][0] + board[line][1] + board[line][2]) == 3)
				return 1;
		}

		return 0;

	}

	public int checkColumns() {
		for (int column = 0; column < 3; column++) {
			if ((board[0][column] + board[1][column] + board[2][column]) == -3)
				return -1;
			if ((board[0][column] + board[1][column] + board[2][column]) == 3)
				return 1;
		}

		return 0;

	}

	public int checkDiagonals() {
		if ((board[0][0] + board[1][1] + board[2][2]) == -3)
			return -1;
		if ((board[0][0] + board[1][1] + board[2][2]) == 3)
			return 1;
		if ((board[0][2] + board[1][1] + board[2][0]) == -3)
			return -1;
		if ((board[0][2] + board[1][1] + board[2][0]) == 3)
			return 1;

		return 0;
	}

	public boolean fullBoard() {
		for (int linha = 0; linha < 3; linha++)
			for (int coluna = 0; coluna < 3; coluna++)
				if (board[linha][coluna] == 0)
					return false;
		return true;
	}	
}
