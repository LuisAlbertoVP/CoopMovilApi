package com.velasteguicorps.coopmovil.Model.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Luis
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pagos extends Transaction{
    
    @JsonProperty("NombrePago")
    private String nombrePago;
    
   
    public Pagos(){}

    
    public String getNombrePago() {
        return nombrePago;
    }

    public void setNombrePago(String nombrePago) {
        this.nombrePago = nombrePago;
    }

}