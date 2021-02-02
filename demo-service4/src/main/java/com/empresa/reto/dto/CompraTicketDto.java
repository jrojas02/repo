/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PCADMIN
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraTicketDto {
    private int idEvento;
    private int idUsuario;
    private int cantidadEntradas;
}
