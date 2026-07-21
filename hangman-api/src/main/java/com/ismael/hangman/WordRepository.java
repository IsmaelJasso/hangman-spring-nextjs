package com.ismael.hangman;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long>{

	@Query(value = "SELECT * FROM words ORDER BY RAND() LIMIT 1", nativeQuery = true)
	Word findRandomWord();
}
