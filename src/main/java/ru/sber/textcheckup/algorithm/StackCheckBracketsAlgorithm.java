package ru.sber.textcheckup.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.LinkedList;

@Component("CheckBracketsAlgorithm")
@ConditionalOnProperty(value = "algorithm.check-brackets", havingValue = "stack", matchIfMissing = true)
public class StackCheckBracketsAlgorithm implements CheckBracketsAlgorithm {
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    @Override
    public boolean isBracketsOrderCorrect(String text) {
        Deque<Bracket> stack = new LinkedList<>();

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
