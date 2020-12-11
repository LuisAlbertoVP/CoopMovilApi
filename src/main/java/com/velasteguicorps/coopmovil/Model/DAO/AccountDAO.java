package com.velasteguicorps.coopmovil.Model.DAO;

import com.velasteguicorps.coopmovil.Model.VO.Account;
import com.velasteguicorps.coopmovil.Model.VO.Pagos;
import com.velasteguicorps.coopmovil.Model.VO.Transferencias;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis
 */
public class AccountDAO {
    
    Connection cnn;
    
    public AccountDAO(){
        this.cnn = DBConnection.getInstance().getConnection();
    }
 
    
    public boolean actualizarEntreCuentas(Account cuenta){
        boolean flag;
        CallableStatement c;
        try{
            c = cnn.prepareCall("{? = CALL actualizarEntreCuentas(?,?,?,?,?,?)}");
            
            c.registerOutParameter(1,Types.INTEGER);
            c.setInt(2, cuenta.getNumeroCooperativa());
            c.setString(3, cuenta.getPersonaObject().getCedula());
            c.setInt(4, cuenta.getTipoCuenta());
            c.setInt(5, cuenta.getListTransferencias().get(0).getTipoCuentaDestino());
            c.setDouble(6, cuenta.getListTransferencias().get(0).getMonto());
            c.setString(7, cuenta.getListTransferencias().get(0).getNombreTransferencia());
            c.execute();
            flag = (c.getInt(1)!=0);
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
            flag = false;
        }
        return flag;
    }
    
    public boolean actualizarPagos(Account cuenta){
        boolean flag;
        CallableStatement c;
        try{
            c = cnn.prepareCall("{? = CALL actualizarPagos(?,?,?)}");

            c.registerOutParameter(1,Types.INTEGER);
            c.setString(2, cuenta.getListPagos().get(0).getNombrePago());
            c.setDouble(3, cuenta.getListPagos().get(0).getMonto());
            c.setInt(4, cuenta.getNumeroCuenta());
            c.execute();
            flag = (c.getInt(1)!=0);
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
            flag = false;
        }
        return flag;
    }
    
    public boolean actualizarToCuenta(Account cuenta){
        boolean flag;
        CallableStatement c;
        try{
            c = cnn.prepareCall("{? = CALL actualizarToCuenta(?,?,?,?,?,?,?)}");
            
            c.registerOutParameter(1,Types.INTEGER);
            c.setInt(2, cuenta.getNumeroCooperativa());
            c.setString(3, cuenta.getPersonaObject().getCedula());
            c.setInt(4, cuenta.getTipoCuenta());
            c.setDouble(5, cuenta.getListTransferencias().get(0).getMonto());
            c.setInt(6, cuenta.getListTransferencias().get(0).getNumeroCuentaDestino());
            c.setInt(7, cuenta.getListTransferencias().get(0).getNumeroCooperativaDestino());
            c.setString(8, cuenta.getListTransferencias().get(0).getNombreTransferencia());
            c.execute();
            flag = (c.getInt(1)!=0);
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
            flag = false;
        }
        return flag;
    }
    
    public Account getCuenta(Account cuentaRequest){
        Account cuenta = new Account();
        CallableStatement c;
        ResultSet res;
        try{
            c = cnn.prepareCall("{CALL getCuenta(?)}");
            
            c.setInt(1, cuentaRequest.getNumeroCuenta());
            res = c.executeQuery();
            while(res.next()){
                cuenta.getPersonaObject().setNombres(res.getString("nombrePersona"));
                cuenta.setSaldoTotal(res.getDouble("saldoTotal"));
            }
            res.close();
            c.close();
            
            c = cnn.prepareCall("{CALL getPagos(?)}");
            
            c.setInt(1, cuentaRequest.getNumeroCuenta());
            res = c.executeQuery();
            while(res.next()){
                Pagos pagos = new Pagos();
                pagos.setFechaTransaccion(res.getString("fechaPagos"));
                pagos.setNombrePago(res.getString("nombrePagos"));
                pagos.setMonto(res.getDouble("valorPagos"));
                cuenta.getListPagos().add(pagos);
            }
            res.close();
            c.close();
            
            c = cnn.prepareCall("{CALL getTransferencias(?)}");
            
            c.setInt(1, cuentaRequest.getNumeroCuenta());
            res = c.executeQuery();
            while(res.next()){
                Transferencias transferencias = new Transferencias();
                transferencias.setFechaTransaccion(res.getString("fechaTransferencia"));
                transferencias.setNombreTransferencia(res.getString("nombreTransferencia"));
                transferencias.setMonto(res.getDouble("valorTransferencia"));
                cuenta.getListTransferencias().add(transferencias);
            }
            res.close();
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
        return cuenta;
    }
    
    public Integer getNumeroCuenta(Account cuenta){
        Integer NumeroCuenta = 0;
        CallableStatement c;
        try{
            c= cnn.prepareCall("{? = CALL getNumeroCuenta(?,?,?)}");
       
            c.registerOutParameter(1,Types.INTEGER);
            c.setInt(2, cuenta.getNumeroCooperativa());
            c.setString(3, cuenta.getPersonaObject().getCedula());
            c.setInt(4, cuenta.getTipoCuenta());
            c.execute();
            NumeroCuenta = c.getInt(1);
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: "+ ex);
        }
        return NumeroCuenta;
    }
    
    public List<Integer> getNumerosCuentas(Account cuenta){
        List<Integer> numerosCuentas = new ArrayList();
        CallableStatement c;
        ResultSet res;
        try{
            c = cnn.prepareCall("{CALL getNumerosCuentas(?)}");
            
            c.setString(1, cuenta.getPersonaObject().getCedula());
            res = c.executeQuery();
            while(res.next()){
                numerosCuentas.add(res.getInt("idCuenta"));
            }
            res.close();
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
        return numerosCuentas;
    }
    
    public boolean registrarCuenta(Account cuenta){
        boolean flag;
        CallableStatement c;
        try{
            c = cnn.prepareCall("{CALL registrarCuenta(?,?,?,?)}");
            
            c.setDouble(1, cuenta.getSaldoTotal());
            c.setInt(2, cuenta.getNumeroCooperativa());
            c.setString(3, cuenta.getPersonaObject().getCedula());
            c.setInt(4, cuenta.getTipoCuenta());
            c.execute();
            c.close();
            flag = true;
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
            flag = false;
        }
        return flag;
    }
    
    public Integer verificarNumeroCuenta(Integer Numero){
        Integer CantidadCuentas = 0;
        CallableStatement c;
        try{
            c= cnn.prepareCall("{? = CALL verificarNumeroCuenta(?)}");
            
            c.registerOutParameter(1,Types.INTEGER);
            c.setInt(2, Numero);
            c.execute();
            CantidadCuentas = c.getInt(1);
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: "+ ex);
        }
        return CantidadCuentas;
    }
    
}
