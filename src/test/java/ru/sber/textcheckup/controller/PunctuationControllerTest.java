package ru.sber.textcheckup.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PunctuationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCheckBrackets_whenEmptyText_thenReturnError() throws Exception {
        mockMvc.perform(post("/api/checkBrackets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                    {
                                      "text": "   "
                                    }
                                """))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.isCorrect").doesNotExist());
    }

    @Test
    void testCheckBrackets_whenCorrectPair_thenStatusIsOkAndReturnIsCorrect() throws Exception {
        mockMvc.perform(post("/api/checkBrackets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                    {
                                      "text": "Hello (World) 1"
                                    }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").doesNotExist())
                .andExpect(jsonPath("$.isCorrect").value(true));
    }

    @Test
    void testCheckBrackets_whenIncorrectPair_thenStatusIsOkAndReturnIsNotCorrect() throws Exception {
        mockMvc.perform(post("/api/checkBrackets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                    {
                                      "text": "Hello World )( 1)"
                                    }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").doesNotExist())
                .andExpect(jsonPath("$.isCorrect").value(false));
    }

    @Test
    void testCheckBrackets_whenEmptyTextInBrackets_thenStatusIsOkAndReturnIsNotCorrect() throws Exception {
        mockMvc.perform(post("/api/checkBrackets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                    {
                                      "text": "Hello World ()"
                                    }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").doesNotExist())
                .andExpect(jsonPath("$.isCorrect").value(false));
    }

    @Test
    void testCheckBrackets_whenNoBrackets_thenStatusIsOkAndReturnIsCorrect() throws Exception {
        mockMvc.perform(post("/api/checkBrackets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                    {
                                      "text": "Hello World"
                                    }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").doesNotExist())
                .andExpect(jsonPath("$.isCorrect").value(true));
    }
}