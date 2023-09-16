package ru.sber.textcheckup.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Common response in case of error")
public class ErrorResponseDTO {
    @Schema(description = "Error description", example = "Empty input")
    private String error;
}
