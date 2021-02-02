package com.empresa.reto.service.impl;

import com.empresa.reto.dto.CompraTicketDto;
import com.empresa.reto.dto.TemplateResponse;
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
    public List<String> comprarEntradas(CompraTicketDto compra) {
        List<String> templResponse = this.repository.comprarTicket(compra);
        return templResponse;
    }
}
