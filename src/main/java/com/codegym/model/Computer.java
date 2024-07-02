package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @Pattern(regexp = "[A-Za-z0-9]{3}", message = "Vui lòng nhập theo định dạng sau :Ab1")
    private String code;
    @NotEmpty(message = "Tên không được để trống")
    private String name;
    private String producer;
    @Min(value = 500, message = "Giá phải lớn hơn 500")
    private Double price;
    @ManyToOne
    private Type type;

    public Computer(Long id, String code, String name, String producer, Double price, Type type) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.type = type;
    }

    public Computer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Pattern(regexp = "^[A-Za-z0-9]{3}", message = "Sai định dạng mã máy, vui lòng nhập theo định dạng sau :Ab1") String getCode() {
        return code;
    }

    public void setCode(@Pattern(regexp = "^[A-Za-z0-9]{3}", message = "Sai định dạng mã máy, vui lòng nhập theo định dạng sau :Ab1") String code) {
        this.code = code;
    }

    public @NotEmpty(message = "Tên không được để trống") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Tên không được để trống") String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public @Min(value = 500, message = "Giá phải lớn hơn 500") Double getPrice() {
        return price;
    }

    public void setPrice(@Min(value = 500, message = "Giá phải lớn hơn 500") Double price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}