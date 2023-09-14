package ru.sber.textcheckup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckBracketsResponseDTO {
    @JsonProperty("isCorrect")
    private boolean isCorrect;
}
