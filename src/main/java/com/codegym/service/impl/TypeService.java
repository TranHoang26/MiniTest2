package com.codegym.service.impl;

import com.codegym.model.DTO.TypeDTO;
import com.codegym.model.Type;
import com.codegym.repository.TypeRepository;
import com.codegym.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class TypeService implements ITypeService {
    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public void save(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public Page<TypeDTO> findQuantityInTypeByIdType(Pageable pageable) {
        return typeRepository.findQuantityInTypeByIdType(pageable);
    }
}