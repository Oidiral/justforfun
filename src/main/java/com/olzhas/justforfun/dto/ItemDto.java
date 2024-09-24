package com.olzhas.justforfun.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    @NotNull
    @NotBlank
    private String name;
    private String description;
    @NotNull
    private double price;
}
