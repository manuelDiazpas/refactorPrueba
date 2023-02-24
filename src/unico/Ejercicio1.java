package unico;

import java.util.Scanner;

/**
 * Queremos desarrollar una aplicación que nos ayude a gestionar las notas de un
 * centro educativo. Cada grupo (o clase) está compuesto por un número de
 * alumnos (máximo 20). Se pide leer las notas del primer, segundo y tercer
 * trimestre de un grupo. Debemos mostrar al final: la nota media del grupo en
 * cada trimestre, y la media del alumno que se encuentra en la posición N (N se
 * lee por teclado).
 */
public class Ejercicio1 {

	private static final int MAX_ALUM = 20;
	private static double[] notasDaw1;
	private static double[] notasDaw2;
	private static double[] notasDaw3;
	private static double media = 0;
	private static int numAlumnos = 0;
	private static boolean excepcion = false;
	private static int n = 0;

	public static void main(String[] args) {

		mostrarPantalla("¿Cuántos alumnos conforman el grupo?");
		Scanner teclado = new Scanner(System.in);

		do {
			try {
				n = teclado.nextInt();
			} catch (Exception e) {
				excepcion = true;
			}
		} while (excepcion);
		numAlumnos = n;
		notasDaw1 = new double[numAlumnos];
		notasDaw2 = new double[numAlumnos];
		notasDaw3 = new double[numAlumnos];

		mostrarPantalla("NOTAS DEL PRIMER TRIMESTRE:");
		excepcion = notasPrimerTrimestre(teclado, excepcion);

		mostrarPantalla("NOTAS DEL SEGUNDO TRIMESTRE:");
		excepcion = notasSegundoTrimestre(teclado, excepcion);

		mostrarPantalla("NOTAS DEL TERCER TRIMESTRE:");
		excepcion = notasTercerTrimestre(teclado, excepcion);

		mostrarPantalla("-----------------------------------");
		mediaSegundaEvyTercerAlumno(media);

	}

	private static boolean notasTercerTrimestre(Scanner teclado, boolean excepcion) {
		int n;
		for (int i = 0; i < MAX_ALUM; i++) {
			if (i < notasDaw3.length) {
			mostrarPantalla("Introduce la nota del alumno número " + (i + 1));
			n = 0;
			do {
				try {
					n = teclado.nextInt();
				} catch (Exception e) {
					excepcion = true;
				}
			} while (excepcion);
				notasDaw3[i] = n;
			} else {
				break;
			}
		}
		return excepcion;
	}

	private static boolean notasSegundoTrimestre(Scanner teclado, boolean excepcion) {
		int n;
		for (int i = 0; i < MAX_ALUM; i++) {
			if (i < notasDaw2.length) {
			mostrarPantalla("Introduce la nota del alumno número " + (i + 1));
			n = 0;
			do {
				try {
					n = teclado.nextInt();
				} catch (Exception e) {
					excepcion = true;
				}
			} while (excepcion);
			notasDaw2[i] = n;
			}else {
				break;
			}
		}
		return excepcion;
	}

	private static boolean notasPrimerTrimestre(Scanner teclado, boolean excepcion) {
		int n;
		for (int i = 0; i < MAX_ALUM; i++) {
			if (i < notasDaw1.length) {
			mostrarPantalla("Introduce la nota del alumno número " + (i + 1));
			n = 0;
			do {
				try {
					n = teclado.nextInt();
				} catch (Exception e) {
					excepcion = true;
				}
			} while (excepcion);
			
				notasDaw1[i] = n;
			} else {
				break;
			}
		}
		return excepcion;
	}

	private static void mediaSegundaEvyTercerAlumno(double media) {
		for (int i = 0; i < notasDaw1.length; i++) {
			mostrarPantalla("Alumno nº " + (i + 1) + ". 1ª eva: " + notasDaw1[i] + ". 2ª eva: " + notasDaw2[i]
					+ ". 3ª eva: " + notasDaw3[i]);
		}

		for (int i = 0; i < notasDaw2.length; i++) {
			media += notasDaw2[i];
		}
		mostrarPantalla("La media de la segunda evluación es: " + media / notasDaw2.length);

		media = notasDaw1[2] + notasDaw2[2] + notasDaw3[2];

		mostrarPantalla("La media del tercer alumno es: " + media / 3);
	}

	public static void mostrarPantalla(String cadena) {
		System.out.println(cadena);
	}

}