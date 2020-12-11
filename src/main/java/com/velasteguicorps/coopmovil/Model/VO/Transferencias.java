package com.velasteguicorps.coopmovil.Model.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Luis
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transferencias extends Transaction{
      
    @JsonProperty("NombreTransferencia")
    private String nombreTransferencia;
    
    @JsonProperty("NumeroCuentaDestino")
    private Integer numeroCuentaDestino;
    
    @JsonProperty("NumeroCooperativaDestino")
    private Integer numeroCooperativaDestino;
    
    @JsonProperty("TipoCuentaDestino")
    private Integer tipoCuentaDestino;
    

    
    public Transferencias() {}

    
    public String getNombreTransferencia() {
        return nombreTransferencia;
    }

    public void setNombreTransferencia(String nombreTransferencia) {
        this.nombreTransferencia = nombreTransferencia;
    }

    public Integer getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public void setNumeroCuentaDestino(Integer numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    public Integer getNumeroCooperativaDestino() {
        return numeroCooperativaDestino;
    }

    public void setNumeroCooperativaDestino(Integer numeroCooperativaDestino) {
        this.numeroCooperativaDestino = numeroCooperativaDestino;
    }

    public Integer getTipoCuentaDestino() {
        return tipoCuentaDestino;
    }

    public void setTipoCuentaDestino(Integer tipoCuentaDestino) {
        this.tipoCuentaDestino = tipoCuentaDestino;
    }

}
