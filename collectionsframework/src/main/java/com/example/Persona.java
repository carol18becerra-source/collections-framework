package com.example;

import java.time.LocalDate;


import lombok.Builder;

@Builder

public record Persona(String nombre, String primerApellido, String segundoApellido, LocalDate fechadenacimiento,
		Genero genero, Double salario

) implements Comparable<Persona> {

	@Override
	public int compareTo(Persona persona) {
		
		/*resultado de la comparacion por el primer apellido de dos perosnas de la lista personas
		 * */
		
		/*Para que el orden sea lexicograficamente de la z a la A hay que ubicar primero el objeto 
		 * que se recibe como parametro */

		int cmpPrimerApellido = persona.primerApellido().compareTo(this.primerApellido);
		int cmpSegundoApellido = persona.segundoApellido().compareTo(this.segundoApellido);
		int cmpNombre = persona.nombre().compareTo(this.nombre);
		return cmpPrimerApellido != 0 ? cmpPrimerApellido : cmpSegundoApellido != 0 ?
				cmpSegundoApellido : cmpNombre;
	}

}
