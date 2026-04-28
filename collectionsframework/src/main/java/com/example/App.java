package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;

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
						.fechadenacimiento(LocalDate.of(1995, Month.JANUARY, 20)).genero(Genero.HOMBRE).salario(3500.50)
						.build());

		personas.add(Persona.builder().nombre("Carolina").primerApellido("Garzon").segundoApellido("Becerra")
				.fechadenacimiento(LocalDate.of(2000, Month.OCTOBER, 10)).genero(Genero.MUJER).salario(3600.45)
				.build());
		personas.add(Persona.builder().nombre("Maria").primerApellido("Garzon").segundoApellido("Becerra")
				.fechadenacimiento(LocalDate.of(2005, Month.DECEMBER, 14)).genero(Genero.MUJER).salario(3650.45)
				.build());

		personas.add(

				Persona.builder().nombre("Jeronimo").primerApellido("Arenal").segundoApellido("Gomez")
						.fechadenacimiento(LocalDate.of(1989, Month.MAY, 22)).genero(Genero.HOMBRE).salario(4200.25)
						.build());

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
		 * expresiones lambda
		 */

		/*
		 * variante #1 de recorrer/iterar sobre coleccion es decir utilizando un
		 * iterador a modo de ejemplo vamos a recorrer la coleccion de personas y
		 * eliminar las personas de genero HOMBRE
		 */

		System.out.println("-------------- Listado original de personas ----------------------");
		System.out.println(personas);

//		Iterator<Persona> it = personas.iterator();
//
//		while (it.hasNext()) {
//			if (it.next().genero().equals(Genero.HOMBRE)) {
//				it.remove();
//			}
//		}
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

		/**
		 * OPERACIONES DE AGREGADO PARA RECORRER LAS COLECCIONES
		 * 
		 * https://docs.oracle.com/javase/tutorial/collections/streams/index.html
		 * 
		 * Ejemplo: calcular el salario promedio de las personas del genero MUJER
		 * 
		 * Las operaciones de agregado implican convertir la coleccion en un flujo
		 * stream de elementos que circular por una tuberia imaginaria o pipeline por la
		 * tuberio o pipeline se entiende una secuencia de metodos de clase Stream es
		 * decir una sentencia de operaciones de agregado es decir metodos que para
		 * obtener un resultado agrupan elementos del flujo
		 * 
		 * 
		 * una tuberia o pipeline tine un origen que puede ser un array, una coleccion,
		 * un socket, un fichero una consulta de base de datos, etc, tambien la tubiria
		 * tiene cero o muchas operaciones intermedias y UNA SOLA operacione terminal
		 * 
		 * lo primero es utlizar el metodo stream (), que tambien podria ser
		 * parallelStream(), para convertir la coleccion en un flujo de elementos del
		 * mismo tipo de coleccion
		 * 
		 * A partir de tener un flujo de elementos entrar a funcionar los metodos de la
		 * clase Stream, operaciones intermedias como podria ser el metodo filter para
		 * permitir que solamente circule al proximo nivel de la tuberia las personas
		 * del Genero MUJER
		 * 
		 * predicate es una interfaz funcional es decir un tipo de interfaz que puede
		 * tener metodos por defecto que tiene cuerpo metodos estaticos etc., pero
		 * SOLAMENTE UN METODO ABSTRACTO. un predicate es una condicion que tiene que
		 * cumplir un elemento que circula por la tuberia o p
		 * 
		 */

		// Stream<Persona> flujodePersona = personas.stream();

		// Filtro filtro = new Filtro();

		// personas.stream().filter(filtro);

		// personas.stream().filter(new Filtro());

		/**
		 * El codigo hasta este momento se consideraria una total exageracion tener que
		 * crear una clase externa solamente para implementar la intefaz funcional
		 * predicate
		 * 
		 * por lo cual un enfoque mas eficiente seria crear una clase en el mismo sitio
		 * donde se va a instaniciar el objeto, es decir, juan palomo yo lo guiso yo me
		 * lo como, y aqui entrar las clases anonimas
		 * 
		 * ¿Que es una clase anonima?
		 * 
		 * Es en primer lugar una clase que no tiene nombre por lo cual una vez que se
		 * declara no podria ser utlizada para instanciar un objeto, es decir, una clase
		 * anonima es una expresion de clase, una expresion que vista con buenos ojos
		 * parece una clase pero no tiene nombre
		 * 
		 * Se puede utilizar una clase anonima para instanciar un objeto a partir de una
		 * interfaz pero tambien a partir de una clase abstracta
		 */

//		personas.stream().filter(new Predicate<Persona>() {
//
//			@Override
//			public boolean test(Persona p) {
//				// TODO Auto-generated method stub
//				return p.genero().equals(Genero.MUJER);
//			}
//		});

		/*
		 * El uso de clase anonima o mejor dicho de la expresion de clase anonima es
		 * mucho mejor que la implementacion de la clase filtro pero todavia continua
		 * siendo una exageracion si no se van a declarar variables adicionales ni se va
		 * a implementar otra cosa que sea el metodo abstacto de la interfaz funcional
		 * predicate
		 * 
		 * 
		 * Y se hace la luz y aparece las EXPRESIONES LAMBDA
		 * 
		 * ¿Que es una expresion lambda?
		 * 
		 * una expresion lambda hay que verla como un "metodo anonimo" por lo general se
		 * utilizan para implementar el metodo abtracto de las interfaces funcionales
		 * 
		 * concretamente para el ejemplo que estamos desarrallando ahora vamos a
		 * centrarnos en el metodo test
		 * 
		 * NOTA IMPORTANTE SOBRE LAS LAMBDAS Y LAS CLAVES ANOMIMAS
		 * 
		 * tanto las clases anonimas como las expresiones lambda solamente se pueden
		 * relacionar con variables locales (declaradas dentro de metodos) que sean
		 * explicitamente final o effectivel final (en efecto final)
		 * 
		 */

		// final int x = 4;

		// effectively final implica que se le ha asignado un valor y posteriormente no
		// se la ha asignado otro

		// int x = 7;

		// en el codigo siguiente el metodo average() de clase stream devuelve un
		// optional
		// ¿ que el tipo optional?
		// es un tipo de datos que surgio posteriormente a java 8 y es para proteger al
		// codigo del
		// del peligro NullPointException porque el optional hau que verlo como una caja
		// donde puede venir el valor esperado o un null y no habria problema porque
		// podemos
		// comprobar que hay en la cajita antes de extraer el valor

		OptionalDouble optionalDeSalarioPromedio = personas.stream().filter(p -> p.genero().equals(Genero.MUJER))
				.mapToDouble(p -> p.salario()).average();

		double salarioMedio = 0.0;
		// del optional del salario podemos extraer

		if (optionalDeSalarioPromedio.isPresent()) {
			salarioMedio = optionalDeSalarioPromedio.getAsDouble();

		}

		// otra variable de extraer el promedio del optional de salario medio

		double salarioPromedio = personas.stream().filter(p -> p.genero().equals(Genero.MUJER))
				.mapToDouble(p -> p.salario()).average().orElse(0);

		/*
		 * Metodo por referencia
		 * 
		 * si al expresion lambda lo unido que va a hacer es invocar al metodo que
		 * realiza el trabajo es mas efeciente pasar por referencia la direccion de
		 * dicho metodo para que realice el trabajo
		 * 
		 * por ejemplo en en el metodo mapToDouble le expresion lambda lo unico que hace
		 * es invocar al metodo que recupera el salio en este caso en lugar de utilizar
		 * una lambda es mas eficiente pasar por referencia el propio metodo que
		 * recuperar el salario
		 */

		double salarioPromedio2 = personas.stream().filter(p -> p.genero().equals(Genero.MUJER))
				.mapToDouble(Persona::salario).average().orElse(0);

		/*
		 * ¿La siguiente seria una expresion lambda varilida?
		 * 
		 * () ->
		 * 
		 * Rta. SI void imprimir () { system.out.println("Hola") }
		 * 
		 */

		/*
		 * Hasta el momento hemos creado colecciones List en este caso asignando memoria
		 * a traves de los constructores de las clases que implementan la interfaz para
		 * posteriormente utilizar el metodo add() y tambien a partir de un array que
		 * daria como resultado una coleccion de tamaño fijo ¿como crear una coleccion
		 * inmutable, es decir, que no se pueda modificar ni agregar ni eliminar
		 * elementos ni modificarlos?
		 */

		List<String> listaInmutable = List.of("Jeronimo", "Duglas", "Carolina");

		/*
		 * Object Ordering (ordenamiento de objetos)
		 * 
		 * https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html
		 *
		 */

		List<String> nombre = Arrays.asList("Jeronimo", "Duglas", "Carolina");

		Collections.sort(nombre);
		System.out.println(nombre);

		/*
		 * Intentar ordenar la lista de personaslist
		 * 
		 * El codigo siguiente da error porque el tipo persona no implementa la interfaz
		 * comparable de persona a diferencia de todos los tipos de buit-in de java que
		 * si implementan dicho interfaz
		 * 
		 * a modo de ejemplo: vamos a establecer un criterio de ordenamiento para que se
		 * ordene el listado de persona, primero por le primer apellido, luego el
		 * segundo apellido, y si hay dos personas con el mismo primer y segundo
		 * apellido que determine el nombre
		 */

		Collections.sort(personas);

		// Mostrar la lista de personas resultantes
		personas.stream().forEach(persona -> System.out.println(persona));

		/*
		 * ¿Como ordenar la lista de personas en Orden natural inverso es decir
		 * lexicograficamentede la z a la A ?
		 */

		/*
		 * Supongamos que el Record persona va a ser utilizado en otro Departamento o en
		 * otra aplicacion donde no les interesa el orden natural implementado, sino
		 * ordenar por el salario de menor a mayor
		 */

		Collections.sort(personas,
				(persona1, persona2) -> Double.valueOf(persona1.salario()).compareTo(persona2.salario()));

		System.out.println("Listado de personas ordenado por salario de menor a mayor,");
		personas.forEach(System.out::println);

		// a continuacion otra variante de ordenar por salario

		Collections.sort(personas, Comparator.comparingDouble(Persona::salario));
		System.out.println("Listado de personas ordenado por salario de menor a mayor,"
				+ "utilizando metodos de la propia interfaz comparator");
		personas.forEach(System.out::println);

		/*
		 * Ejercicio:
		 * Respetando el Natural ordering, ordenar la lista de personas por el salario
		 * de mayor a menor es decir es decir en orden inverso
		 */

		Collections.sort(personas, Comparator.comparingDouble(Persona::salario).reversed());

		System.out.println("Listado de personas ordenado por salario de mayor a menor usando reversed(): ");
		personas.forEach(System.out::println);

	}

}
