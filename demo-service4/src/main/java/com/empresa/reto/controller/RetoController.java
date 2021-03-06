/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.controller;

import com.empresa.reto.dto.CompraTicketDto;
import com.empresa.reto.dto.Response;
import com.empresa.reto.service.RetoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author _jrojasc
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/comprarentrada")
@AllArgsConstructor
public class RetoController {
    
    private final RetoService service;

    @PostMapping()
    public ResponseEntity<?> comprarEntradas(@RequestBody CompraTicketDto compra) {
        List<String> response;
        try {

            response = this.service.comprarEntradas(compra);
            
            Response out = new Response();
            if(response.size() > 0){
            out.setData(response);
            out.setMensaje("Se han comprado los tickets de forma exitosa");
            return new ResponseEntity<>(out, HttpStatus.OK);
            }
            throw new Exception("fallo al comprar los tickets");
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
