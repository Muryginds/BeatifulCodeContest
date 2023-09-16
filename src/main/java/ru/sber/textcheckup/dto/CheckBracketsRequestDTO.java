package ru.sber.textcheckup.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Check brackets request model")
public class CheckBracketsRequestDTO {
    @NotBlank(message = "Text must not be blank or empty")
    @Schema(description = "Text to check", example = "Hello my dear (world)")
    private String text;
}
