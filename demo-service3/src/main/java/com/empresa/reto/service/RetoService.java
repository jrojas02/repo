/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.service;

import com.empresa.reto.dto.TicketDto;
import java.util.List;

/**
 *
 * @author _jrojasc
 */
public interface RetoService {
    List<String> crearTicket(TicketDto ticket);
}
