package com.velasteguicorps.coopmovil.Model.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Luis
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    
    @JsonProperty("Cedula")
    private String cedula;
    
    @JsonProperty("Nombres")
    private String nombres;
    
    @JsonProperty("Direccion")
    private String direccion;
    
    @JsonProperty("Telefono")
    private String telefono;
    
    @JsonProperty("FechaNacimiento")
    private String fechaNacimiento;
    
    @JsonProperty("Correo")
    private String correo;

    
    public Person(){}

    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
