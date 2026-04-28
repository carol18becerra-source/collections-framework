package com.example;

import java.time.LocalDate;


import lombok.Builder;

@Builder

public record Persona(String nombre, String primerApellido, String segundoApellido, LocalDate fechadenacimiento,
		Genero genero, Double salario

) implements Comparable<Persona> {

	@Override
	public int compareTo(Persona persona) {

		int cmpPrimerApellido = this.primerApellido.compareTo(persona.primerApellido());
		int cmpSegundoApellido = this.segundoApellido.compareTo(persona.segundoApellido());
		int cmpNombre = this.nombre.compareTo(persona.nombre());
		return cmpPrimerApellido != 0 ? cmpPrimerApellido : cmpSegundoApellido != 0 ?
				cmpSegundoApellido : cmpNombre;
	}

}
