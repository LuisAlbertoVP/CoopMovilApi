package com.velasteguicorps.coopmovil.Model.DAO;

import com.velasteguicorps.coopmovil.Model.VO.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Luis
 */
public class UserDAO {
    Connection cnn;
    
    public UserDAO(){
        this.cnn = DBConnection.getInstance().getConnection();
    }
    
    
    public boolean registrarUsuario(User user){
        boolean flag;
        CallableStatement c;
        try{
            c = cnn.prepareCall("{CALL registrarUsuario(?,?,?,?,?,?,?,?)}");
            
            c.setString(1, user.getUserName());
            c.setString(2, user.getCorreo());
            c.setString(3, user.getPassword());
            c.setString(4, user.getCedula());
            c.setString(5, user.getNombres());
            c.setString(6, user.getDireccion());
            c.setString(7, user.getTelefono());
            c.setString(8, user.getFechaNacimiento());
            c.execute();
            c.close();
            flag = true;
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
            flag = false;
        }
        return flag;
    }
    
    public Integer verificarCedula(User user){
        CallableStatement c;
        Integer CantidadCedulas = 0;
        try{
            c = cnn.prepareCall("{? = CALL verificarCedula(?)}");
              
            c.registerOutParameter(1,Types.INTEGER);
            c.setString(2, user.getCedula());
            c.execute();
            CantidadCedulas = c.getInt(1);
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
        return CantidadCedulas;
    }
    
    public Integer verificarCorreo(User user){
        CallableStatement c;
        Integer CantidadCorreos = 0;
        try{
            c = cnn.prepareCall("{? = CALL verificarCorreo(?)}");
              
            c.registerOutParameter(1,Types.INTEGER);
            c.setString(2, user.getCorreo());
            c.execute();
            CantidadCorreos = c.getInt(1);
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
        return CantidadCorreos;
    }
    
    public Integer verificarNombreUsuario(User user){
        CallableStatement c;
        Integer CantidadNombreUsuarios = 0;
        try{
            c = cnn.prepareCall("{? = CALL verificarNombreUsuario(?)}");
              
            c.registerOutParameter(1,Types.INTEGER);
            c.setString(2, user.getUserName());
            c.execute();
            CantidadNombreUsuarios = c.getInt(1);
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
        return CantidadNombreUsuarios;
    }

    public String verificarUsuario(User user){
        CallableStatement c;
        String Cedula = "";
        try{
            c = cnn.prepareCall("{? = CALL verificarUsuario(?,?)}");
              
            c.registerOutParameter(1,Types.VARCHAR);
            c.setString(2, user.getUserName());
            c.setString(3, user.getPassword());
            c.execute();
            Cedula = c.getString(1);
            c.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }
        return Cedula;
    }
    
}
