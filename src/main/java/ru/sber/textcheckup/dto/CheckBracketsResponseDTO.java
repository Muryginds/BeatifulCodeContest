package ru.sber.textcheckup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Answering model for check brackets response")
public class CheckBracketsResponseDTO {
    @JsonProperty("isCorrect")
    @Schema(description = "Shows the result of text checkup")
    private boolean isCorrect;
}
