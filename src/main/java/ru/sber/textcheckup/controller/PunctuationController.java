package ru.sber.textcheckup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.textcheckup.dto.CheckBracketsResponseDTO;
import ru.sber.textcheckup.service.PunctuationService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PunctuationController {
    private final PunctuationService punctuationService;

    @PostMapping("/checkBrackets")
    public CheckBracketsResponseDTO checkBrackets() {
        return punctuationService.checkBrackets();
    }
}
