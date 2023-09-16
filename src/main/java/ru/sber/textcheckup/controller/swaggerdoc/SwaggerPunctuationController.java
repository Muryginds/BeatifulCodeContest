package ru.sber.textcheckup.controller.swaggerdoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import ru.sber.textcheckup.dto.CheckBracketsRequestDTO;
import ru.sber.textcheckup.dto.CheckBracketsResponseDTO;
import ru.sber.textcheckup.dto.ErrorResponseDTO;

@Tag(name = "Text punctuation checking controller")
public interface SwaggerPunctuationController {

    @Operation(summary = "Checks text for correct brackets")
    @ApiResponse(
            responseCode = "200",
            description = "Text checked",
            content = {@Content(schema = @Schema(implementation = CheckBracketsResponseDTO.class), mediaType = "application/json")})
    @ApiResponse(
            responseCode = "400",
            description = "Wrong text input",
            content = {@Content(schema = @Schema(implementation = ErrorResponseDTO.class), mediaType = "application/json")})
    CheckBracketsResponseDTO checkBrackets(@Valid @RequestBody CheckBracketsRequestDTO requestDTO);
}
