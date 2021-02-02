/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.jpa;

import com.empresa.reto.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.security.krb5.internal.Ticket;

/**
 *
 * @author PCADMIN
 */
public interface IJpaTicket extends JpaRepository<Tickets, Integer>{
    
}
