package com.codegym.controller;

import com.codegym.model.Computer;
import com.codegym.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/computers")
@CrossOrigin("*")
public class ComputerRestController {

    private final IComputerService computerService;

    @Autowired
    public ComputerRestController(IComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Computer>> findAllComputer() {
        List<Computer> computers = (List<Computer>) computerService.findAll();
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Computer getComputerById(@PathVariable Long id) {
        return computerService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Computer not found with id " + id));
    }

    @PostMapping
    public Computer createComputer(@RequestBody Computer computer) {
        computerService.save(computer);
        return computer;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateProduct(@PathVariable Long id, @RequestBody Computer computer) {
        Optional<Computer> car1 = computerService.findById(id);
        if (car1.isPresent()) {
            computer.setId(id);
            computerService.save(computer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComputer(@PathVariable Long id) {
        Optional<Computer> computer = computerService.findById(id);
        if (computer.isPresent()) {
            computerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/search")
//    public ResponseEntity<Page<Computer>> search(@RequestParam String name , @PageableDefault(value = 5) Pageable pageable) {
//        Page<Computer> car = computerService.findByNameContainingPageAndSort(name,pageable);
//        if (car == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(car,HttpStatus.OK);
//    }
}
