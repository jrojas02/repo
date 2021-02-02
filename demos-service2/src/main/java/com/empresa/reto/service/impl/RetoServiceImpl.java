package com.empresa.reto.service.impl;

import com.empresa.reto.dto.EventoDto;
import com.empresa.reto.dto.TemplateResponse;
import com.empresa.reto.entidades.Evento;
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
    public List<EventoDto> consultarEventosDisponibles() {
        List<Evento> entities = this.repository.listarEventos();
        try {
            
            return entities.stream().map(ev -> {
                return new EventoDto(ev.getNombre(), ev.getDescripcion(), ev.getFecha(), ev.getCapacidad());
            }).collect(Collectors.toList());
            
        } catch (NullPointerException e) {
            
            System.out.println(e.getMessage());
            return new ArrayList<>();
            
        }
    }

    @Override
    public String actualizarCapacidadEvento(Integer idEvento, Integer cantEntradas) throws Exception{
        
        Evento eventoEntity = this.repository.obtenerEvento(idEvento);
        
        if(eventoEntity != null && eventoEntity.getId() > 0){
            eventoEntity.setCapacidad(eventoEntity.getCapacidad() - cantEntradas);
            this.repository.actualizarCapacidadEvento(eventoEntity);
            return "capacidad Actualizada";
        }
        
        throw new Exception("no existe el evento a consultar");
        
    }
}
