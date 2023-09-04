package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Modelo del envio de correo
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CorreoModelo implements Serializable {
    private String correo;
    private String nombre;
}
