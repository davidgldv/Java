
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		int filas = 5;									//Filas y columnas de la matriz
		int columnas = 10;
		int opcion = 0;									//Opcion del menu
		int cuota = 0;									//Cuota del parking
		char[][] matriz = new char[filas][columnas]; 	//Matriz
		Scanner teclado = new Scanner(System.in); 		//Variable para leer del teclado
		int fila = 0;									//Fila y columna que introduce el usuario
		int columna = 0;								
		int nVehiculos = 0;								//Contador de vehiculos
		Object vehiculo = new ArrayList<Object>();		//Crear array de objetos para guardar datos vehiculos
		boolean res = true;								//Booleano para ver si hay hueco o no se equivoca el usuario de sitio

		InicializarMatriz(matriz, filas, columnas);		//Inicializa los valores de la matriz

		//Bucle para crear el menu y seleccionar las opciones
		do {

			System.out.println("            TAQUILLA ONLINE:              ");
			System.out.println("                                          ");
			System.out.println(" 1.-> Mostrar Parking                     ");
			System.out.println(" 2.-> Introducir Coche                    ");
			System.out.println(" 3.-> Introducir Moto                     ");
			System.out.println(" 4.-> Introducir Autobus                  ");
			System.out.println(" 5.-> Sacar Vehiculo                      ");
			System.out.println(" 6.-> Mostrar Beneficio                   ");
			System.out.println(" 7.-> Salir                               ");
			System.out.println(" Introduzca opción:                       ");
			opcion = teclado.nextInt();

			switch (opcion) {

			case 1:
				ImprimirMatriz(matriz, filas, columnas);						//Imprime el parking con lso valores actualizados
				break;
			case 2:
				if (nVehiculos == 24) {											//Condicion para ver si el parking esta lleno
					System.out.println("Parking Lleno");
				} else
					res = IntroducirCoche(matriz, fila, columna, teclado);		//Funcion para introducir coche
				if (res == true) {
					cuota += 5;													//Incremento de cuota
					nVehiculos++;												//Incremento de contador
				}
				break;
			case 3:
				if (nVehiculos == 24) {											//Condicion para ver si el parking esta lleno
					System.out.println("Parking Lleno");
				} else
					res = IntroducirMoto(matriz, filas, columnas, teclado);		//Funcion para introducir moto
				if (res == true) {
					cuota += 3;													//Incremento de cuota
					nVehiculos++;												//Incremento de contador
				}
				break;
			case 4:
				if (nVehiculos == 24) {											//Condicion para ver si el parking esta lleno
					System.out.println("Parking Lleno");
				} else
					res = IntroducirAutobus(matriz, filas, columnas, teclado);	//Funcion para introducir autobus
				if (res == true) {
					cuota += 10;												//Incremento de cuota
					nVehiculos++;												//Incremento de contador
				}
				break;
			case 5:
				if (nVehiculos == 0) {											//Condicion para ver si el parking esta vacio
					System.out.println("Parking Vacio");
				}
				res=SacarVehiculo(matriz, fila, columna, teclado);				//Funcion para introducir autobus
				if (res == true) {
					nVehiculos--;												//Incremento de contador
				}
				break;
			case 6:
				MostrarBeneficio(cuota);										//Funcion para introducir autobus
				break;
			case 7:
				System.out.println(" Hasta luego.");							//Salir del programa
				break;
			default:
				System.out.println(" Opcion Invalida.");						//Opcion predeterminada por si el usuario mete una opcion distinta

			}

		}

		while (opcion != 7);

	}
	
//Funcion de inicializar matriz para dar valores e introducir valores a la matriz
	private static void InicializarMatriz(char[][] matriz, int filas, int columnas) {

		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				matriz[f][c] = ' ';
				if ((f == 0) || (f == 4) || (c == 9) || (c == 0)) {
					matriz[f][c] = 'P';
				}
				if ((c == 0) && (f == 0) || (c == 9) && (f == 0) || (c == 9) && (f == 4) || (c == 0) && (f == 4)) {
					matriz[f][c] = 'X';
				}
				if ((f == 1) && (c == 0)) {
					matriz[f][c] = 'E';
				}
				if ((f == 3) && (c == 0)) {
					matriz[f][c] = 'S';
				}
			}
		}
	}
	
//Funcion para imprimir la matriz por pantalla
	private static void ImprimirMatriz(char[][] matriz, int filas, int columnas) {

		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				System.out.print(matriz[f][c] + "\t");
			}
			System.out.println();
		}
	}
	
//Funcion que comprueba si se puede introducir un coche en la posicion deseada y si puede,lo introduce en la matriz
	private static boolean IntroducirCoche(char[][] matriz, int fila, int columna, Scanner teclado) {

		try {
			System.out.println("Introduce la fila: ");
			fila = teclado.nextInt();
			System.out.println("Introduce la columna: ");
			columna = teclado.nextInt();

			if (matriz[fila - 1][columna - 1] == 'X' || matriz[fila - 1][columna - 1] == 'P'
					|| matriz[fila - 1][columna - 1] == 'E' || matriz[fila - 1][columna - 1] == 'S'
					|| matriz[fila - 1][columna - 1] == 'M' || matriz[fila - 1][columna - 1] == 'C'
					|| matriz[fila - 1][columna - 1] == 'A') {
				if (matriz[fila - 1][columna - 1] == 'E' || matriz[fila - 1][columna - 1] == 'S') {
					System.out.println("Esta la salida o la entrada");
					return false;
				}
				if (matriz[fila - 1][columna - 1] == 'X' || matriz[fila - 1][columna - 1] == 'P') {
					System.out.println("Es pared o columna");
					return false;
				}
				if (matriz[fila - 1][columna - 1] == 'A' || matriz[fila - 1][columna - 1] == 'C'
						|| matriz[fila - 1][columna - 1] == 'M') {
					System.out.println("Esta plaza ya esta ocupada");
					return false;
				}
			} else {
				matriz[fila - 1][columna - 1] = 'C';
				return true;
			}

		} catch (InputMismatchException error) {
			System.out.println("No introduzca palabras raras");
			return false;
		} catch (ArrayIndexOutOfBoundsException error) {
			System.out.println("El valor introducido no es correcto");
			return false;
		}
		return true;
	}
	
//Funcion que comprueba si se puede introducir una moto en la posicion deseada y si puede,lo introduce en la matriz	
	private static boolean IntroducirMoto(char[][] matriz, int fila, int columna, Scanner teclado) {

		try {
			System.out.println("Introduce la fila: ");
			fila = teclado.nextInt();
			System.out.println("Introduce la columna: ");
			columna = teclado.nextInt();

			if (matriz[fila - 1][columna - 1] == 'X' || matriz[fila - 1][columna - 1] == 'P'
					|| matriz[fila - 1][columna - 1] == 'E' || matriz[fila - 1][columna - 1] == 'S'
					|| matriz[fila - 1][columna - 1] == 'M' || matriz[fila - 1][columna - 1] == 'C'
					|| matriz[fila - 1][columna - 1] == 'A') {
				if (matriz[fila - 1][columna - 1] == 'E' || matriz[fila - 1][columna - 1] == 'S') {
					System.out.println("Esta la salida o la entrada");
					return false;
				}
				if (matriz[fila - 1][columna - 1] == 'X' || matriz[fila - 1][columna - 1] == 'P') {
					System.out.println("Es pared o columna");
					return false;
				}
				if (matriz[fila - 1][columna - 1] == 'A' || matriz[fila - 1][columna - 1] == 'C'
						|| matriz[fila - 1][columna - 1] == 'M') {
					System.out.println("Esta plaza ya esta ocupada");
					return false;
				}
			} else {
				matriz[fila - 1][columna - 1] = 'M';
				return true;
			}

		} catch (InputMismatchException error) {
			System.out.println("No introduzca palabras raras");
			return false;
		} catch (ArrayIndexOutOfBoundsException error) {
			System.out.println("El valor introducido no es correcto");
			return false;
		}
		return true;
	}

//Funcion que comprueba si se puede introducir un autobus en la posicion deseada y si puede  lo introduce en la matriz
	private static boolean IntroducirAutobus(char[][] matriz, int fila, int columna, Scanner teclado) {

		try {
			System.out.println("Introduce la fila: ");
			fila = teclado.nextInt();
			System.out.println("Introduce la columna: ");
			columna = teclado.nextInt();

			if (matriz[fila - 1][columna - 1] == 'X' || matriz[fila - 1][columna - 1] == 'P'
					|| matriz[fila - 1][columna - 1] == 'E' || matriz[fila - 1][columna - 1] == 'S'
					|| matriz[fila - 1][columna - 1] == 'M' || matriz[fila - 1][columna - 1] == 'C'
					|| matriz[fila - 1][columna - 1] == 'A') {
				if (matriz[fila - 1][columna - 1] == 'E' || matriz[fila - 1][columna - 1] == 'S') {
					System.out.println("Esta la salida o la entrada");
					return false;
				}
				if (matriz[fila - 1][columna - 1] == 'X' || matriz[fila - 1][columna - 1] == 'P') {
					System.out.println("Es pared o columna");
					return false;
				}
				if (matriz[fila - 1][columna - 1] == 'A' || matriz[fila - 1][columna - 1] == 'C'
						|| matriz[fila - 1][columna - 1] == 'M') {
					System.out.println("Esta plaza ya esta ocupada");
					return false;
				}
			} else {
				matriz[fila - 1][columna - 1] = 'A';
			}
		} catch (InputMismatchException error) {
			System.out.println("No introduzca palabras raras");
			return false;
		} catch (ArrayIndexOutOfBoundsException error) {
			System.out.println("El valor introducido no es correcto");
			return false;
		}
		return true;
	}
	
//Funcion que imprime por pantalla el beneficio recaudado
	private static void MostrarBeneficio(int cuota) {

		System.out.println(cuota + "\t");

	}

//Funcion que comprueba si puede sacar cualquier vehiculo de la posicion deseada  y si se puede, lo elimina de la matriz
	private static boolean SacarVehiculo(char[][] matriz, int fila, int columna, Scanner teclado) {

		try {
			System.out.println("Introduce la fila: ");
			fila = teclado.nextInt();
			System.out.println("Introduce la columna: ");
			columna = teclado.nextInt();

			if (matriz[fila - 1][columna - 1] == 'X' || matriz[fila - 1][columna - 1] == 'P'
					|| matriz[fila - 1][columna - 1] == 'E' || matriz[fila - 1][columna - 1] == 'S') {
				if (matriz[fila - 1][columna - 1] == 'E' || matriz[fila - 1][columna - 1] == 'S') {
					System.out.println("Esta la salida o la entrada");
					return false;
				}
				if (matriz[fila - 1][columna] == 'X' || matriz[fila][columna] == 'P') {
					System.out.println("Es pared o columna");
					return false;
					}
			} else {
				matriz[fila - 1][columna - 1] = ' ';
				return true;
			}
		} catch (InputMismatchException error) {
			System.out.println("No introduzca palabras raras");
			return false;
		} catch (ArrayIndexOutOfBoundsException error) {
			System.out.println("El valor introducido no es correcto");
			return false;
		}
		return true;

	}

}
