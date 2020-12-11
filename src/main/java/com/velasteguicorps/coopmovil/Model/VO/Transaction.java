package com.velasteguicorps.coopmovil.Model.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Luis
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {
    
    @JsonProperty("FechaTransaccion")
    private String fechaTransaccion;
    
    @JsonProperty("Monto")
    private Double monto;

    
    public Transaction(){}
    
    
    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
      
}
