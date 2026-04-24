package com.example;

import lombok.Builder;
import java.time.LocalDate;

@Builder


public record Persona(
	String nombre,
	String primerApellido,
	String segundoApellido,
	LocalDate fechadenacimiento,
	Genero genero){

}
