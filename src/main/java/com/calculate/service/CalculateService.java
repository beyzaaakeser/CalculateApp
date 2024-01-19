package com.calculate.service;

import com.calculate.domain.Calculate;
import com.calculate.dto.CalculateDTO;
import com.calculate.dto.CalculateRequest;
import com.calculate.exception.ExceptionMessage;
import com.calculate.exception.ResourceNotFoundException;
import com.calculate.factory.Operation;
import com.calculate.factory.OperationFactory;
import com.calculate.repository.CalculateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculateService {
    private final CalculateRepository repository;
    private final OperationFactory factory;

    public ResponseEntity<CalculateDTO> saveCalculate(CalculateRequest request) {
        Operation operationObject = factory.createOperation(request.getOperation());
        Double result = operationObject.calculate(request.getNum1(), request.getNum2());

        Calculate calculate = saveResult( request.getNum1(),request.getOperation(),request.getNum2(), result);
        CalculateDTO dto = changeDTO(calculate);

        return ResponseEntity.ok(dto);
    }

    private Calculate saveResult(Double number1,String operation,  Double number2, Double result) {
        Calculate operationResult = new Calculate();
        operationResult.setOperation(operation);
        operationResult.setNum1(number1);
        operationResult.setNum2(number2);
        operationResult.setResult(result);

        return repository.save(operationResult);
    }

    public CalculateDTO getById(Long id) {
        Calculate calculate = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ExceptionMessage.RESOURCE_NOT_FOUND_EXCEPTION,id)));
        return changeDTO(calculate);
    }

    public List<CalculateDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::changeDTO)
                .collect(Collectors.toList());
    }

    public List<CalculateDTO> getByOperation(String operation) {
        String type = change(operation);
        return repository.findByOperation(type)
                .stream()
                .map(this::changeDTO)
                .collect(Collectors.toList());
    }

    public static String change(String type){
        return switch (type) {
            case "add" -> "+";
            case "subtract" -> "-";
            case "multiply" -> "*";
            case "divide" -> "/";
            default-> throw new IllegalArgumentException("Invalid operation type: " + type);
        };
    }
    private CalculateDTO changeDTO(Calculate calculate){
        return CalculateDTO.builder()
                .num1(calculate.getNum1())
                .num2(calculate.getNum2())
                .result(calculate.getResult())
                .operation(calculate.getOperation())
                .build();
    }
}
