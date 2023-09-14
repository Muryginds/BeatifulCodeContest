package ru.sber.textcheckup.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import ru.sber.textcheckup.dto.CheckBracketsRequestDTO;
import ru.sber.textcheckup.dto.CheckBracketsResponseDTO;

@Service
public class PunctuationService {
    public CheckBracketsResponseDTO checkBrackets(@Valid CheckBracketsRequestDTO requestDTO) {
        return new CheckBracketsResponseDTO(true);
    }
}
