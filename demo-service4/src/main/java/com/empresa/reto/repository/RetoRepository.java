/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.repository;

import com.empresa.reto.dto.CompraTicketDto;
import com.empresa.reto.dto.TemplateResponse;
import java.util.List;

/**
 *
 * @author _jrojasc
 */
public interface RetoRepository {
    List<String> comprarTicket(CompraTicketDto compra);
}
