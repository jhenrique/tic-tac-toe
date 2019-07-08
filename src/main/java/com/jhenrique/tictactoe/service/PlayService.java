package com.jhenrique.tictactoe.service;

import org.springframework.stereotype.Service;

import com.jhenrique.tictactoe.model.Board;
import com.jhenrique.tictactoe.model.Game;
import com.jhenrique.tictactoe.model.Movement;
import com.jhenrique.tictactoe.model.dto.ResultDto;

@Service
public class PlayService {
	
	public ResultDto play(Game game, Movement movement) {
		
		Board board = game.getBoard();
		
		if (board.getPosicao(movement.getPosition()) != 0)
			return new ResultDto("Posição já preenchida", "");
			
		board.setPosicao(movement);
		game.setPlayerLast(movement.getPlayer());
		
		//Utilizado para validacao no console
		board.showBoard();
	
		if (board.fullBoard()) 
			return new ResultDto("Partida finalizada", "Draw");
		
		if (winner(board) == 0)
			return new ResultDto("Jogada Realizada com Sucesso", "");
		
		String playerWinner = winner(board) == 1 ? "X" : "O";
		game.setPlayerWinner(playerWinner);
				
		return new ResultDto("Partida finalizada", playerWinner);
	
	}
	
	public int winner(Board board){
        
		if(board.checkLines() == 1)
            return 1;
        if(board.checkColumns() == 1)
            return 1;
        if(board.checkDiagonals() == 1)
            return 1;
        
        if(board.checkLines() == -1)
            return -1;
        if(board.checkColumns() == -1)
            return -1;
        if(board.checkDiagonals() == -1)
            return -1;
        
        return 0;
    }

}
