package com.calculate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalculateRequest {

    @NotNull(message = "Please enter your first number")
    private Double num1;

    @NotBlank(message="Please enter your operation type")
    private String operation;

    @NotNull(message = "Please enter your second number")
    private Double num2;

}
