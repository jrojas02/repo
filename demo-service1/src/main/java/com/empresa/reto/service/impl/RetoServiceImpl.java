package com.empresa.reto.service.impl;

import com.empresa.reto.dto.TemplateResponse;
import com.empresa.reto.dto.UsuarioDto;
import com.empresa.reto.entity.Usuarios;
import com.empresa.reto.repository.RetoRepository;
import com.empresa.reto.service.RetoService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author _jrojasc
 */
@Service
@AllArgsConstructor
public class RetoServiceImpl implements RetoService {

    private final RetoRepository repository;

    @Override
    public String registrarUsuario(UsuarioDto usuario) {
        Usuarios usuarioEntity = new Usuarios();
        usuarioEntity.setNombre(usuario.getNombres());
        usuarioEntity.setApellidos(usuario.getApellidos());
        usuarioEntity.setUsuario(usuario.getNombreUsuario());
        usuarioEntity.setContraseña(usuario.getPassword());
        Usuarios templResponse = this.repository.registrarUsuario(usuarioEntity);
        
        if(templResponse != null && templResponse.getId() > 0){
            return "Usuario registrado exitosamente";
        }
        return "Usuario no Registrado";
    }
}
