package com.codegym.service.impl;

import com.codegym.model.Computer;
import com.codegym.repository.ComputerRepository;
import com.codegym.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ComputerService implements IComputerService {
    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public void save(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public void delete(Long id) {
        computerRepository.deleteById(id);
    }

    @Override
    public Iterable<Computer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public Page<Computer> findAllPageAndSort(Pageable pageable) {
        return computerRepository.findAll(pageable);
    }

    @Override
    public Optional<Computer> findById(Long id) {
        return computerRepository.findById(id);
    }

    @Override
    public Page<Computer> findByNameContainingPageAndSort(String name, Pageable pageable) {
        return computerRepository.findByNameContaining(name, pageable);
    }
}