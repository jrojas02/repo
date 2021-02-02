/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.repository.impl;

import com.empresa.reto.dto.CompraTicketDto;
import com.empresa.reto.dto.TemplateResponse;
import com.empresa.reto.repository.RetoRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
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
    
    private final String urlTicket = "http://3.12.123.7:8083/";
    private final String urlEvento = "http://3.139.88.204:8082/";
    
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<String> comprarTicket(CompraTicketDto compra) {
        
        try {
            
            ResponseEntity<String[]> respTemplate = restTemplate.postForEntity(urlTicket, compra,String[].class);
            
            String[] body = respTemplate.getBody();
            
            if(respTemplate.getStatusCode().equals(HttpStatus.OK) && body != null){
                String resp =this.actualizarCapacidadEvento(compra.getIdEvento(), compra.getCantidadEntradas());
                if(resp.equals("OK")){
                return Arrays.asList(respTemplate.getBody());
                }
                
                
            }
            
            return new ArrayList<>();
            
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }  
       
    }
    
    private String actualizarCapacidadEvento(int idEvento, int cantidadEntradas){
        ResponseEntity<String> respTemplateEvento = restTemplate.getForEntity(urlEvento+"actualizar/"+idEvento+"/"+cantidadEntradas, String.class);
            
                String body = respTemplateEvento.getBody();
                if(respTemplateEvento.getStatusCode().equals(HttpStatus.OK) && body != null){
                return "OK";  
            }
                return "Error";
                
    }
    
}
