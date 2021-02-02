/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.controller;

import com.empresa.reto.dto.EventoDto;
import com.empresa.reto.dto.Response;
import com.empresa.reto.service.RetoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author _jrojasc
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/")
@AllArgsConstructor
public class RetoController {
    
    private final RetoService service;

    @GetMapping()
    public ResponseEntity<?> consultarEventos() {
        List<EventoDto> response;
        try {

            response = this.service.consultarEventosDisponibles();
            
            Response out = new Response();
            out.setData(response);
            
            return new ResponseEntity<>(out, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("actualizar/{idEvento}/{cantEntradas}")
    public ResponseEntity<?> actualizarCapacidadEvento(@PathVariable("idEvento") Integer idEvento, @PathVariable("cantEntradas") Integer cantEntradas) {
        try {

            String response = this.service.actualizarCapacidadEvento(idEvento,cantEntradas);
            
            
            return new ResponseEntity<>(response, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
