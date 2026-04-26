package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sun.source.tree.WhileLoopTree;

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

		// var realmente es List<Persona>
		var personas = new ArrayList<Persona>();

		personas.add(

				Persona.builder().nombre("Duglas").primerApellido("Taydron").segundoApellido("Gonzalez")
						.fechadenacimiento(LocalDate.of(1995, Month.JANUARY, 20)).genero(Genero.HOMBRE).build());

		personas.add(Persona.builder().nombre("Carolina").primerApellido("Garzon").segundoApellido("Becerra")
				.fechadenacimiento(LocalDate.of(2000, Month.OCTOBER, 10)).genero(Genero.MUJER).build());
		personas.add(Persona.builder().nombre("Maria").primerApellido("Garzon").segundoApellido("Gonzalez")
				.fechadenacimiento(LocalDate.of(2005, Month.DECEMBER, 14)).genero(Genero.MUJER).build());

		personas.add(

				Persona.builder().nombre("Jeronimo").primerApellido("Arenal").segundoApellido("Gomez")
						.fechadenacimiento(LocalDate.of(1989, Month.MAY, 22)).genero(Genero.HOMBRE).build());

		/*
		 * La lista resultante personas no es de tamaño fijo porque no se ha obtenido a
		 * partir un aray por lo cual le puedo agregar o eliminar elementos persona
		 * cuando quiera
		 */

		System.out.println(personas);

		/*
		 * Traversing Collections
		 * 
		 * En primer lugar:
		 * 
		 * https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.
		 * html
		 * 
		 * En segundo lugar ver el documento Arrays, Generics and collection Framework
		 */

		/*
		 * Existen 3 formas de recorrer una coleccion de las cuales solamente una
		 * permite eliminar elementos de la coleccion a la vez que se recorre:
		 * 
		 * 1- utilizando un iterador es dicir interfaz iterator<E>, que es la unica
		 * forma de eliminar un elemento de la colleccion a la misma vez que se recorrer
		 * 
		 * 2- utilizando una sentencia for mejorada
		 * 
		 * 3- (la variante sugerencia la mejor) utilizando operaciones de agregados en
		 * decir programacion funcional metodos de clase stream metodos de referencia y
		 * operaciones lambda
		 */

		/*
		 * variante #1 de recorrer/iterar sobre coleccion es decir utilizando un
		 * iterador a modo de ejemplo vamos a recorrer la coleccion de personas y
		 * eliminar las personas de genero HOMBRE
		 */

		System.out.println("-------------- Listado original de personas ----------------------");
		System.out.println(personas);

		Iterator<Persona> it = personas.iterator();

		while (it.hasNext()) {
			if (it.next().genero().equals(Genero.HOMBRE)) {
				it.remove();
			}
		}
		System.out.println("--- Listado resultante luego de eliminar las " + " personas del genero HOMBRE ---");
		System.out.println(personas);

		/*
		 * Ejercicio #1.
		 * 
		 * Utilizando un Iterador eliminar del listado de personas aquellas que sean del
		 * hOMBRE y el nombre tenga 6 caracteres
		 * 
		 * para la solucion: hacer un commit del estado actual y posteriormente eliminar
		 * o comentar el codigo del uso del itereador anterior para tener la lista de
		 * personas original
		 */
		
		Iterator<Persona> it = personas.iterator();
		
		while (it.hasNext()) {
			var persona = it.next();
			if (persona.genero().equals(Genero.HOMBRE) && persona.nombre().length() == 6) {
				it.remove();
			}
			System.out.println(" ---- Listado Resultante ----");
			System.out.println(personas);
		}

	}

}
