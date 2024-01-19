package com.calculate.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Calculate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double num1;

    @Column(nullable = false)
    private String operation;

    @Column(nullable = false)
    private Double num2;

    @Column(nullable = false)
    private Double result;



}
