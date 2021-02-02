/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.repository.jpa;

import com.empresa.reto.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author PCADMIN
 */
public interface IUsuarioJpa extends JpaRepository<Usuarios, Integer>{
    
}
