package com.codegym.controller;

import com.codegym.model.DTO.TypeDTO;
import com.codegym.model.Type;
import com.codegym.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/types")
@CrossOrigin("*")
public class TypeRestController {

    private final ITypeService typeService;

    @Autowired
    public TypeRestController(ITypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public Iterable<Type> getAllTypes() {
        return typeService.findAll();
    }

    @GetMapping("/{id}")
    public Type getTypeById(@PathVariable Long id) {
        return typeService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Type not found with id " + id));
    }

    @PostMapping
    public Type createType(@RequestBody Type type) {
        typeService.save(type);
        return type;
    }

    @PutMapping("/{id}")
    public Type updateType(@PathVariable Long id, @RequestBody Type type) {
        type.setId(id);
        typeService.save(type);
        return type;
    }

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Long id) {
        typeService.delete(id);
    }

    @GetMapping("/statistic")
    public Page<TypeDTO> getTypeStatistics(Pageable pageable) {
        return typeService.findQuantityInTypeByIdType(pageable);
    }
}
