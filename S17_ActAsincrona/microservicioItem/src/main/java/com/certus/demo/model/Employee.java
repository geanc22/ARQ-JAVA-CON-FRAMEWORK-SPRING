package com.certus.demo.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Employee {

    private @NonNull String cantidad;

    private @NonNull String producto;




}