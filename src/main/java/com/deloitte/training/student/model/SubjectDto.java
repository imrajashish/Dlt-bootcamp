
package com.deloitte.training.student.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SubjectDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "Subject name cannot be blank")
    private String name;

    @NotBlank(message = "Subject code cannot be blank")
    private String code;

    private String description;
}
