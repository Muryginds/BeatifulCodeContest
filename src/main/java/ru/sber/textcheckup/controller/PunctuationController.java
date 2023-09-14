package ru.sber.textcheckup.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.textcheckup.dto.CheckBracketsRequestDTO;
import ru.sber.textcheckup.dto.CheckBracketsResponseDTO;
import ru.sber.textcheckup.service.PunctuationService;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PunctuationController {
    private final PunctuationService punctuationService;

    @PostMapping("/checkBrackets")
    public CheckBracketsResponseDTO checkBrackets(@Valid @RequestBody CheckBracketsRequestDTO requestDTO) {
        return punctuationService.checkBrackets(requestDTO);
    }
}
