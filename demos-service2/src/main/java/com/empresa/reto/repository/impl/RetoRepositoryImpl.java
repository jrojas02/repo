/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.repository.impl;

import com.empresa.reto.dto.TemplateResponse;
import com.empresa.reto.entidades.Evento;
import com.empresa.reto.repository.RetoRepository;
import com.empresa.reto.repository.jpa.EventJpa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author _jrojasc
 */
@Repository
public class RetoRepositoryImpl implements RetoRepository{
    
    @Autowired
    EventJpa jpaRepository;
    

    @Override
    public List<Evento> listarEventos() {
        List<Evento> listEventos = jpaRepository.findAll();
        
        return listEventos;
    }

    @Override
    public Evento obtenerEvento(Integer idEvento) {
        Optional<Evento> eventoEntity = this.jpaRepository.findById(idEvento);
        if(eventoEntity.isPresent()){
            return eventoEntity.get();
        }
        return null;
    }

    @Override
    public void actualizarCapacidadEvento(Evento evento) {
        this.jpaRepository.save(evento);
    }
    
}
