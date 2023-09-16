package ru.sber.textcheckup.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.sber.textcheckup.dto.CheckBracketsRequestDTO;
import ru.sber.textcheckup.dto.CheckBracketsResponseDTO;

import java.util.ArrayDeque;
import java.util.Deque;

@Service
public class PunctuationService {
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    public CheckBracketsResponseDTO checkBrackets(CheckBracketsRequestDTO requestDTO) {
        String text = requestDTO.getText();
        boolean checkResult = areBracketsCorrect(text);
        return new CheckBracketsResponseDTO(checkResult);
    }

    private boolean areBracketsCorrect(String text) {
        Deque<Bracket> stack = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current == LEFT_BRACKET) {
                stack.push(new Bracket(current, i));
            } else if (current == RIGHT_BRACKET) {
                if (stack.isEmpty()) {
                    return false;
                }
                Bracket top = stack.pop();
                if (top.getElement() != LEFT_BRACKET) {
                    return false;
                }
                String textInBrackets = text.substring(top.getPosition() + 1, i);
                if (textInBrackets.isBlank()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    @Data
    @AllArgsConstructor
    private static class Bracket {
        private char element;
        private int position;
    }
}
