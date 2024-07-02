package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Tên không được để trống")
    private String name;

    public Type(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Type() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Tên không được để trống") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Tên không được để trống") String name) {
        this.name = name;
    }
}