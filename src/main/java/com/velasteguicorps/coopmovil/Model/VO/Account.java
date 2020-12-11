package com.velasteguicorps.coopmovil.Model.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    
    @JsonProperty("NumeroCuenta")
    private Integer numeroCuenta;
    
    @JsonProperty("NumeroCooperativa")
    private Integer numeroCooperativa;
    
    @JsonProperty("TipoCuenta")
    private Integer tipoCuenta;
    
    @JsonProperty("PersonaObject")
    private Person personaObject;
    
    @JsonProperty("FechaConsulta")
    private String fechaConsulta;
    
    @JsonProperty("SaldoTotal")
    private Double saldoTotal;
    
    @JsonProperty("ListPagos")
    private List<Pagos> listPagos;
    
    @JsonProperty("ListTransferencias")
    private List<Transferencias> listTransferencias;

    
    public Account(){
        personaObject = new Person();
        listPagos = new ArrayList();
        listTransferencias = new ArrayList();
    }

    
    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Integer getNumeroCooperativa() {
        return numeroCooperativa;
    }

    public void setNumeroCooperativa(Integer numeroCooperativa) {
        this.numeroCooperativa = numeroCooperativa;
    }

    public Integer getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(Integer tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Person getPersonaObject() {
        return personaObject;
    }

    public void setPersonaObject(Person personaObject) {
        this.personaObject = personaObject;
    }

    public String getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(String fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public Double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public List<Pagos> getListPagos() {
        return listPagos;
    }

    public void setListPagos(List<Pagos> listPagos) {
        this.listPagos = listPagos;
    }

    public List<Transferencias> getListTransferencias() {
        return listTransferencias;
    }

    public void setListTransferencias(List<Transferencias> listTransferencias) {
        this.listTransferencias = listTransferencias;
    }
  
}
