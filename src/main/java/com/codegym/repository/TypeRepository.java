package com.codegym.repository;


import com.codegym.model.DTO.TypeDTO;
import com.codegym.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    @Query(value = "select type.name as name , count(minitest2.type_id) as quantity from type left join minitest2 on type.id = minitest2.type_id group by type.id", countQuery = "SELECT count(*) FROM type", nativeQuery = true)
    Page<TypeDTO> findQuantityInTypeByIdType(Pageable pageable);
}