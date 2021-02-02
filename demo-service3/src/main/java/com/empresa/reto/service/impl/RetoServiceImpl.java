package com.empresa.reto.service.impl;

import com.empresa.reto.dto.TemplateResponse;
import com.empresa.reto.dto.TicketDto;
import com.empresa.reto.entity.Estados;
import com.empresa.reto.entity.Evento;
import com.empresa.reto.entity.Tickets;
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
    public List<String> crearTicket(TicketDto tickets) {

        List<String> listaTicketsCreados = new ArrayList<>();
        for(int i = 0; i < tickets.getCantidadEntradas(); i++){
            
            Tickets ticketEntity = new Tickets();
            ticketEntity.setEstado(new Estados(1));
            ticketEntity.setIdEvento(new Evento(tickets.getIdEvento()));
            ticketEntity.setIdUsuario(new Usuarios(tickets.getIdUsuario()));
            ticketEntity.setNumeroTicket(( String.valueOf(Math.random() * 50 + 1)));

            Tickets entity = this.repository.createTicket(ticketEntity);
            if(entity != null && entity.getId() >0){
                listaTicketsCreados.add(entity.getNumeroTicket());
            } 
        }
        return listaTicketsCreados;
    }
}
