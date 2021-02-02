/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.repository;

import com.empresa.reto.dto.TemplateResponse;
import com.empresa.reto.entidades.Evento;
import java.util.List;

/**
 *
 * @author _jrojasc
 */
public interface RetoRepository {
    List<Evento> listarEventos();
    Evento obtenerEvento(Integer idEvento);
    void  actualizarCapacidadEvento(Evento evento);
}
