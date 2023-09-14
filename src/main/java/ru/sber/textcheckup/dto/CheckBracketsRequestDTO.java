package ru.sber.textcheckup.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CheckBracketsRequestDTO {
    @NotBlank(message = "Text must not be blank or empty")
    private String text;
}
