package com.codegym.service;

import com.codegym.model.DTO.TypeDTO;
import com.codegym.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITypeService extends IService<Type>{
    Page<TypeDTO> findQuantityInTypeByIdType(Pageable pageable);
}
