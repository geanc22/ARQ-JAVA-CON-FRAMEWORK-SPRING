package com.myproyects.demo.entidades;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conductores")
public class Conductor {
    @Id
    @NotNull
    @Min(8)
    @Max(8)
    private int dni;
    @Column
    @NotNull
    @Size(min=2, max=30)
    private String nombre;
    @Column
    @NotNull
    @Size(min=2, max=30)
    private String apellidoPaterno;
    @Column
    @NotNull
    @Size(min=2, max=30)
    private String apellidoMaterno;
    @Column
    private String fechaNacimiento;
    @Column
    @NotNull
    @Size(min=2, max=50)
    private String direccion;
    @Column
    private int telefono;
    @Column
    @NotNull
    @Size(min=2, max=30)
    private String email;

    public Conductor() {
    }

   

    public Conductor(@NotNull @Min(8) @Max(8) int dni, @NotNull @Size(min = 2, max = 30) String nombre,
			@NotNull @Size(min = 2, max = 30) String apellidoPaterno,
			@NotNull @Size(min = 2, max = 30) String apellidoMaterno, String fechaNacimiento,
			@NotNull @Size(min = 2, max = 50) String direccion, int telefono,
			@NotNull @Size(min = 2, max = 30) String email) {
	
		this.dni = dni;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}



	public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
    @Override
	public String toString() {
		return "Conductor [dni=" + dni + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", direccion="
				+ direccion + ", telefono=" + telefono + ", email=" + email + "]";
	}
    
    
}

