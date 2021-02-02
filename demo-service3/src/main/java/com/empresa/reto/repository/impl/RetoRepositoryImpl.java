/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.repository.impl;

import com.empresa.reto.dto.TemplateResponse;
import com.empresa.reto.entity.Tickets;
import com.empresa.reto.jpa.IJpaTicket;
import com.empresa.reto.repository.RetoRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private IJpaTicket jpaRepository;

    @Override
    public Tickets createTicket(Tickets ticketEntity) {
        
        Tickets ticketCreated = this.jpaRepository.save(ticketEntity);
        return ticketCreated;
       
    }
    
}
