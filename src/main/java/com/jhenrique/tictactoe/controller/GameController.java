package com.jhenrique.tictactoe.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhenrique.tictactoe.model.Game;
import com.jhenrique.tictactoe.model.Movement;
import com.jhenrique.tictactoe.model.dto.GameDto;
import com.jhenrique.tictactoe.model.dto.ResultDto;
import com.jhenrique.tictactoe.service.PlayService;
import com.jhenrique.tictactoe.util.ValidateUtil;

@RestController
@RequestMapping("/api")
public class GameController {
	
	@Autowired
	PlayService playService;

	Map<String, Game> mapGames = new HashMap<String, Game>();

	@RequestMapping(value = "/game", method = RequestMethod.POST)
	public ResponseEntity<GameDto> newGame() {
		Game game = new Game();
		mapGames.put(game.getId(), game);
		return ResponseEntity.ok(new GameDto(game));
	}

	@RequestMapping(value = "/game/movement", method = RequestMethod.POST)
	public ResponseEntity<Object> movement(@RequestBody String movementJson) {

		ObjectMapper mapper = new ObjectMapper();
		Movement movement = null;
		try {
			movement = mapper.readValue(movementJson, Movement.class);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Não foi possível ler as informações");
		}
		
		Game game = mapGames.get(movement.getGameId());
		ResponseEntity<Object> invalidBody = ValidateUtil.validMovement(movement, game);
		
		if (invalidBody != null) 
			return invalidBody;
				
		
		ResultDto result = playService.play(game, movement);
		
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "/game/list", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Game>> list() {
		return ResponseEntity.ok(mapGames);
	}

}
