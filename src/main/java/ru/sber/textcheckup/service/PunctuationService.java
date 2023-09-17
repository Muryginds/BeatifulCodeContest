package ru.sber.textcheckup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sber.textcheckup.algorithm.CheckBracketsAlgorithm;
import ru.sber.textcheckup.dto.CheckBracketsRequestDTO;
import ru.sber.textcheckup.dto.CheckBracketsResponseDTO;

@Service
@RequiredArgsConstructor
public class PunctuationService {
    private final CheckBracketsAlgorithm checkBracketsAlgorithm;

    public CheckBracketsResponseDTO checkBrackets(CheckBracketsRequestDTO requestDTO) {
        String text = requestDTO.getText();
        boolean checkResult = checkBracketsAlgorithm.isBracketsOrderCorrect(text);
        return new CheckBracketsResponseDTO(checkResult);
    }
}
