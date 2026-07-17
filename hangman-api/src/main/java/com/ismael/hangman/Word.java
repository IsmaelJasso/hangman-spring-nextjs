package com.ismael.hangman;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "words")
@Data
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "spanish_word", nullable = false)
	private String spanishWord;
	
	@Column(nullable = false)
	private String category;
	
	
	// Getters and Setters
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSpanishWord() {
		return spanishWord;
	}
	
	public void setSpanishWord(String sWord) {
		this.spanishWord = sWord;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String cat) {
		this.category = cat;
	}
}
