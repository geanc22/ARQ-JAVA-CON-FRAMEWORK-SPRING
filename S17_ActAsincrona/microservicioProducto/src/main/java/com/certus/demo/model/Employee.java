package com.certus.demo.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Employee {

    private @NonNull String id;

    private @NonNull String nombre;

    private @NonNull String precio;


}