package com.velasteguicorps.coopmovil.Controller;

import com.velasteguicorps.coopmovil.Model.DAO.AccountDAO;
import com.velasteguicorps.coopmovil.Model.VO.Account;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis
 */

@RestController
@RequestMapping("/CoopMovil/Cuenta")
public class AccountController {
       
    @RequestMapping("/actualizarEntreCuentas")
    public String actualizarEntreCuentas(@RequestBody Account cuenta){
        String respuesta = "";
        AccountDAO accountDao = new AccountDAO();
        if(accountDao.actualizarEntreCuentas(cuenta))
            respuesta = "OK";
        return respuesta;
    }
    
    @RequestMapping("/actualizarPagos")
    public String registrarPagos(@RequestBody Account cuenta){
        String respuesta = "";
        AccountDAO accountDao = new AccountDAO();
        cuenta.setNumeroCuenta(accountDao.getNumeroCuenta(cuenta));
        if(accountDao.actualizarPagos(cuenta))
            respuesta = "OK";
        return respuesta;
    }
    
    @RequestMapping("/actualizarToCuenta")
    public String actualizarToCuenta(@RequestBody Account cuenta){
        String respuesta = "";
        boolean band = false;
        AccountDAO accountDao = new AccountDAO();
        if(accountDao.verificarNumeroCuenta(cuenta.getListTransferencias().get(0).getNumeroCuentaDestino()) != 0){
            List<Integer> numerosCuentas = accountDao.getNumerosCuentas(cuenta);
            for(Integer numeroCuenta : numerosCuentas){
                if(numeroCuenta.equals(cuenta.getListTransferencias().get(0).getNumeroCuentaDestino())){
                    band = true;
                    break;
                }
            }
            if(band == false){              
                if(accountDao.actualizarToCuenta(cuenta))                    
                    respuesta = "OK";
            }
        }
        return respuesta;
    }
       
    @RequestMapping("/recuperarCuenta")
    public Account recuperarCuenta(@RequestBody Account cuenta){
        AccountDAO accountDao = new AccountDAO();
        return accountDao.getCuenta(cuenta);
    }
    
    @RequestMapping("/recuperarNumeroCuenta")
    public Integer recuperarNumeroCuenta(@RequestBody Account cuenta){
        AccountDAO accountDao = new AccountDAO();
        return accountDao.getNumeroCuenta(cuenta);
    }
    
    @RequestMapping("/registrarCuenta")
    public String registrarCuenta(@RequestBody Account cuenta){
        String respuesta = "";
        AccountDAO accountDao = new AccountDAO();
        if(accountDao.getNumeroCuenta(cuenta) == 0){
            if(accountDao.registrarCuenta(cuenta))
                respuesta = "OK";
        }
        return respuesta;
    }
    
}
