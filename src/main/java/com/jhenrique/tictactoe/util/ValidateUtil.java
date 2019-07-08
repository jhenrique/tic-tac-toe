package com.jhenrique.tictactoe.util;

import org.springframework.http.ResponseEntity;

import com.jhenrique.tictactoe.model.Game;
import com.jhenrique.tictactoe.model.Movement;

public class ValidateUtil {

	public static ResponseEntity<Object> validMovement(Movement movement, Game game) {

		if (movement.getGameId() == null)
			return ResponseEntity.badRequest().body("Id game não informado");

		if (movement.getPlayer() == null)
			return ResponseEntity.badRequest().body("Jogador não informado");

		if (movement.getPosition() == null)
			return ResponseEntity.badRequest().body("Posição não informada");

		if (game == null)
			return ResponseEntity.badRequest().body("Partida não encontrada");
		
		if (game.getPlayerWinner() != null) {
			return ResponseEntity.badRequest().body("Partida já finalizada, c o ganhandor: " + game.getPlayerWinner());
		}

	    //Caso seja a primeira jogada confirma se eh primeiro, caso nao verifica de quem eh a vez
		if ((game.getPlayerLast() == null && !game.getPlayerStart().equals(movement.getPlayer()))
				|| (game.getPlayerLast() != null && game.getPlayerLast().equals(movement.getPlayer())))
			return ResponseEntity.badRequest().body("Não é o turno do jogador");
		
		if (movement.getPosition().getX() < 0 || movement.getPosition().getX() > 2
				|| movement.getPosition().getY() < 0 || movement.getPosition().getY() > 2)
			return ResponseEntity.badRequest().body("Posição inválida");

		return null;
	}

}
