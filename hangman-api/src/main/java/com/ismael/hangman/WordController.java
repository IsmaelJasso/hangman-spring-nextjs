package com.ismael.hangman;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * REST controller that manages the word related api endpoints, it will 
 * handle the incoming HTTP requests from the frontend
 */
@RestController
@RequestMapping("/api/words")
@CrossOrigin(origins = "http://localhost:3000") // This is what allows the requests from the frontend
public class WordController {

	private final WordService wordService;
	
	public WordController(WordService wordService) {
		this.wordService = wordService;
	}
	
	/*
	 * This method will get one spanish word from our database to begin the handman game session
	 * and will return a word entity serialized as JSON
	 */
	@GetMapping("/random")
	public Word getRandomWord() {
		return wordService.getRandomWord();
	}
}
