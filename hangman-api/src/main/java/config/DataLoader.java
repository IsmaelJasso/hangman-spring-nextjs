package config;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;

import com.ismael.hangman.Word;
import com.ismael.hangman.WordRepository;

public class DataLoader implements CommandLineRunner {

	private final WordRepository WordRepository;
	
	public DataLoader(WordRepository WordRepository) {
		this.WordRepository = WordRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		if(WordRepository.count() == 0) {
			System.out.println("Database is empty. Loading words from text file");
			ClassPathResource resource = new ClassPathResource("SpanishWords.txt");
			List<Word> validWords = new ArrayList<>();
			
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String wordText = line.trim(); 
                    
                    if (wordText.length() >= 5 && wordText.length() <= 8) {
                        Word word = new Word();
                        word.setSpanishWord(wordText.toUpperCase());
                        word.setCategory("general"); 
                        
                        validWords.add(word);
                    }
                }
                WordRepository.saveAll(validWords);
                System.out.println("Successfully loaded " + validWords.size() + " clean words into the database!");
            }
			
			
		}else {
			System.out.println("Words already in database");
		}
		
	}
}
