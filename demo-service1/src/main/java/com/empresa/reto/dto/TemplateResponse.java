/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.reto.dto;

import lombok.Data;

/**
 *
 * @author _jrojasc
 */
@Data
public class TemplateResponse {
    private String postId;
    private String id;
    private String name; 
    private String email; 
    private String body; 
}
