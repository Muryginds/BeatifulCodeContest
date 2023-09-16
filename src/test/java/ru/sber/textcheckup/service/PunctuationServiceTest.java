package ru.sber.textcheckup.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sber.textcheckup.dto.CheckBracketsRequestDTO;
import ru.sber.textcheckup.dto.CheckBracketsResponseDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SuppressWarnings("java:S5976")
class PunctuationServiceTest {
    @Autowired
    private PunctuationService punctuationService;
    private CheckBracketsRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        requestDTO = new CheckBracketsRequestDTO();
    }

    @Test
    void testCheckBrackets_whenCorrectBrackets_thenReturnResultIsCorrect() {
        String testText = "Hello (World)";
        requestDTO.setText(testText);
        CheckBracketsResponseDTO responseDTO = punctuationService.checkBrackets(requestDTO);
        assertTrue(responseDTO.isCorrect());
    }

    @Test
    void testCheckBrackets_whenManyCorrectBrackets_thenReturnResultIsCorrect() {
        String testText = "Hello (World) is common test phrase (in programming)";
        requestDTO.setText(testText);
        CheckBracketsResponseDTO responseDTO = punctuationService.checkBrackets(requestDTO);
        assertTrue(responseDTO.isCorrect());
    }

    @Test
    void testCheckBrackets_whenOneCorrectPairAndOneWrongPair_thenReturnResultIsNotCorrect() {
        String testText = "Hello (World) is common test phrase (in programming";
        requestDTO.setText(testText);
        CheckBracketsResponseDTO responseDTO = punctuationService.checkBrackets(requestDTO);
        assertFalse(responseDTO.isCorrect());
    }

    @Test
    void testCheckBrackets_whenOnlyOneBracket_thenReturnResultIsNotCorrect() {
        String testText = "Hello ) World";
        requestDTO.setText(testText);
        CheckBracketsResponseDTO responseDTO = punctuationService.checkBrackets(requestDTO);
        assertFalse(responseDTO.isCorrect());
    }

    @Test
    void testCheckBrackets_whenBracketsInWrongOrder_thenReturnResultIsNotCorrect() {
        String testText = "Hello ) World(";
        requestDTO.setText(testText);
        CheckBracketsResponseDTO responseDTO = punctuationService.checkBrackets(requestDTO);
        assertFalse(responseDTO.isCorrect());
    }

    @Test
    void testCheckBrackets_whenNoTextBetweenBrackets_thenReturnResultIsNotCorrect() {
        String testText = "Hello () World";
        requestDTO.setText(testText);
        CheckBracketsResponseDTO responseDTO = punctuationService.checkBrackets(requestDTO);
        assertFalse(responseDTO.isCorrect());
    }
}