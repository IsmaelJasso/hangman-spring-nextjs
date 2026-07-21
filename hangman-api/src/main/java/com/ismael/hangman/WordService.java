package com.ismael.hangman;

import org.springframework.stereotype.Service;

@Service
public class WordService {

	private final WordRepository wordRepository;
	
	public WordService(WordRepository wordRepository) {
		this.wordRepository = wordRepository;
	}
	
	public Word getRandomWord() {
		return wordRepository.findRandomWord();
	}
}
