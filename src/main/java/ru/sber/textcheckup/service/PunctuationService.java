package ru.sber.textcheckup.service;

import org.springframework.stereotype.Service;
import ru.sber.textcheckup.dto.CheckBracketsResponseDTO;

@Service
public class PunctuationService {
    public CheckBracketsResponseDTO checkBrackets() {
        return new CheckBracketsResponseDTO(true);
    }
}
