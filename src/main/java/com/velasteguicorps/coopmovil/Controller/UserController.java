package com.velasteguicorps.coopmovil.Controller;

import com.velasteguicorps.coopmovil.Model.DAO.UserDAO;
import com.velasteguicorps.coopmovil.Model.VO.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis
 */

@RestController
@RequestMapping("/CoopMovil/Usuario")
public class UserController {
    
    @RequestMapping(value = "/loginUsuario")
    public String loginUsuario(@RequestBody User user){
        UserDAO userDao = new UserDAO();
        return userDao.verificarUsuario(user);
    }
 
    @RequestMapping("/registrarUsuario")
    public String registrarUsuario(@RequestBody User user){
        String respuesta = "";
        UserDAO userDao = new UserDAO();
        if(userDao.registrarUsuario(user))
            respuesta = "OK";
        return respuesta;
    }
    
    @RequestMapping("/verificarCampos")
    public Integer[] verificarCamposUsuario(@RequestBody User user){
        Integer [] CantidadDuplicados = new Integer[3];
        UserDAO userDao = new UserDAO();
        CantidadDuplicados[0] = userDao.verificarCedula(user);
        CantidadDuplicados[1] = userDao.verificarNombreUsuario(user);
        CantidadDuplicados[2] = userDao.verificarCorreo(user);
        return CantidadDuplicados;
    }
    
}
