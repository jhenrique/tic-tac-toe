package com.jhenrique.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jhenrique.tictactoe.controller.GameController;

public class GameControllerTests extends TicTacToeApplicationTests{

private MockMvc mockMvc;
	
	@Autowired
	private GameController gameController;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(gameController).build();
	}
	
	@Test
	public void testPostController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/game"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	

}
