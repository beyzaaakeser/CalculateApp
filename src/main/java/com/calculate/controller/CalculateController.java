package com.calculate.controller;

import com.calculate.dto.CalculateDTO;
import com.calculate.dto.CalculateRequest;
import com.calculate.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor
public class CalculateController {

    private final CalculateService service;

    @PostMapping()
    public ResponseEntity<CalculateDTO> saveOperation(@RequestBody @Valid CalculateRequest calculateRequest){
       return service.saveCalculate(calculateRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalculateDTO> getById(@PathVariable Long id){
        CalculateDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CalculateDTO>> getAll(){
        List<CalculateDTO> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/operation")
    public ResponseEntity<List<CalculateDTO>> getByOperation(@RequestParam("operation") String operation){
        List<CalculateDTO> operations = service.getByOperation(operation);
        return ResponseEntity.ok(operations);
    }
}
