package com.calculate.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CalculateDTO {

    private Double num1;
    private String operation;
    private Double num2;
    private Double result;


}
