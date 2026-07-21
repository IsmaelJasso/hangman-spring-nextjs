package com.ismael.hangman;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest(WordController.class)
public class WordControllerTest {

    @Autowired
    private MockMvc mockMvc; 

    // THIS IS THE CRITICAL ANNOTATION THAT FIXES YOUR ERROR
    @MockitoBean
    private WordService wordService; 

    @Test
    public void testGetRandomWord() throws Exception {
        Word mockWord = new Word();
        mockWord.setId(1L);
        mockWord.setSpanishWord("GATO");
        mockWord.setCategory("general");

        Mockito.when(wordService.getRandomWord()).thenReturn(mockWord);

        mockMvc.perform(get("/api/words/random"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.spanishWord").value("GATO"))
                .andExpect(jsonPath("$.category").value("general"));
    }
}