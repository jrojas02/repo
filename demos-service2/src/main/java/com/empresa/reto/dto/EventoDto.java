/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PCADMIN
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventoDto {
    private String nombre;
    private String descripcion;
    private Date fecha;
    private int capacidad;
}
