package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * El Framework de Collections:
 * https://docs.oracle.com/javase/tutorial/collections/index.html
 */
public class App {
	public static void main(String[] args) {
		/* Collections de numeros enteros, a partir de un array */

		Integer[] arrayNumerosEnteros = { 1, 2, 3, 4, 5 };

		List<Integer> numerosEnteros = Arrays.asList(arrayNumerosEnteros);

		/*
		 * Una coleccion obtenida directamente a partir de un array es una coleccion de
		 * tamaño fijo, es decir, que no se le puede agregar ni eliminar elementos pero
		 * si se pueden modificar los elementos porque de lo contrario seria inmutable
		 */
		// numerosEnteros.add(0);

		// ejemplo de creacion de kista (coleccion) utilizando el metodo add(),
		// que es polimorfico para agregar elementos a la lista

		List<Persona> personas = null;
		Persona persona1 = Persona.builder().nombre("Duglas").primerApellido("Taydron").segundoApellido("Gonzalez")
				.fechadenacimiento(LocalDate.of(1995, Month.JANUARY, 20)).genero(Genero.HOMBRE).build();

		personas.add(persona1);

		/*
		 * si la lista de personas apunto a null, entonces no podemos agregar elementos
		 * Persona a dicho lista porque no hemos resevado memoria para la lista
		 * 
		 * ¿ y como se reserva memoria para la lista de persona?
		 * 
		 * utilizando el constructor de alguna de las clases que implementa la interfaz
		 * List
		 */
	}

}
