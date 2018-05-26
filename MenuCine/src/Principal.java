import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int filas = 10;
		int columnas = 10;
		int opcion = 0;
		int entradas = 0;
		int [][] matriz = new int[filas][columnas];
		
		int fila=0, columna=0;
		Scanner teclado = new Scanner(System.in);
		
		//inicializar matriz con todo a 0
		inicializarMatriz(matriz, filas, columnas);
		
		do {
			
			System.out.println("            TAQUILLA ONLINE:              ");
			System.out.println("                                          ");
			System.out.println(" 1.-> Comprar  Entradas                   ");
			System.out.println(" 2.-> Cambiar  Entradas                   ");
			System.out.println(" 3.-> Devolver Entradas                   ");
			System.out.println(" 4.-> Salir                               ");
			System.out.println("                                          ");
			System.out.println(" Introduzca opción:                       ");
			opcion = teclado.nextInt();
		
		switch(opcion) {
			
			case 1:
				imprimirMatriz(matriz, filas, columnas);
				System.out.println();
				comprarEntrada(matriz, fila, columna, teclado, entradas);
				imprimirMatriz(matriz, filas, columnas);
				break;
			case 2:
				imprimirMatriz(matriz, filas, columnas);
				System.out.println();
				CambiarEntrada(matriz, fila, columna, teclado, entradas);
				imprimirMatriz(matriz, filas, columnas);
				break;
			case 3:
				imprimirMatriz(matriz, filas, columnas);
				System.out.println();
				DevolverEntrada(matriz, fila, columna, teclado, entradas);
				imprimirMatriz(matriz, filas, columnas);
				break;
			case 4:
				System.out.println(" Disfrute su pelicula.");
				break;
			default:
				System.out.println(" Opcion Invalida.");
				
		}
		
		
		
		
		}
		while(opcion !=4);
		
		

	}

	private static void comprarEntrada(int[][] matriz, int fila, int columna, Scanner teclado, int entradas) {
		//Pedir fila/columna al usuario
		System.out.println("¿Cuantas entradas quieres?:");
		entradas = teclado.nextInt();
		
		for (int i = 0 ; i< entradas ; i++ ) {
			try {
				System.out.println("Introduzca fila: ");
				fila = teclado.nextInt();
				System.out.println("Introduzca columna: ");
				columna = teclado.nextInt();
		
		//Si la j NO es 8 NI 1
				if((matriz[fila-1][columna-1]==8) || (matriz[fila-1][columna-1]==1)) {
					if (matriz[fila-1][columna-1]==8) {
						System.out.println("No hay butaca, es pasillo");
						i--;
					}
					else {
						System.out.println("Esa butaca ya está ocupada");
						i--;
					}
				}
				else {
					matriz[fila-1][columna-1] = 1;
				}
			}catch (InputMismatchException error) {
				System.out.println("No introduzca palabras raras");
			}catch (ArrayIndexOutOfBoundsException error) {
				System.out.println("El valor introducido no es correcto");
			}
		
		}
	}

	private static void imprimirMatriz(int[][] matriz, int filas, int columnas) {
		
		for(int i=0; i<filas; i++) {
			for(int j=0; j<columnas; j++) {
				System.out.print(matriz[i][j]+"\t");
			}
			System.out.println();
		}
	}

	private static void inicializarMatriz(int[][] matriz, int filas, int columnas) {
		
		for(int i=0; i<filas; i++) {
			for(int j=0; j<columnas; j++) {
				if ((j==4) || (j==5) || (i==0)) matriz[i][j]= 8;
				else matriz[i][j] = 0;
			}
		}
	}
	private static void DevolverEntrada(int[][] matriz, int fila, int columna, Scanner teclado, int entradas) {
		//Pedir fila/columna al usuario
		System.out.println("¿Cuantas entradas quieres devolver?:");
		entradas = teclado.nextInt();
		
		for (int i = 0 ; i< entradas ; i++ ) {
			try {
				System.out.println("Introduzca fila: ");
				fila = teclado.nextInt();
				System.out.println("Introduzca columna: ");
				columna = teclado.nextInt();
		
		//Si la j NO es 8 NI 0
				if((matriz[fila-1][columna-1]==8) || (matriz[fila-1][columna-1]==0)) {
					if (matriz[fila-1][columna-1]==8) {
						System.out.println("No hay butaca, es pasillo");
						i--;
					}
					else {
						System.out.println("Esa butaca  está libre");
						i--;
					}
				}
				else {
					matriz[fila-1][columna-1] = 0;
				}
			}catch (InputMismatchException error) {
				System.out.println("No introduzca palabras raras");
			}catch (ArrayIndexOutOfBoundsException error) {
				System.out.println("El valor introducido no es correcto");
			}
		
		}
	}
	
	private static void CambiarEntrada(int[][] matriz, int fila, int columna, Scanner teclado, int entradas) {
		//Pedir fila/columna al usuario
		System.out.println("¿Cuantas entradas quieres cambiar?:");
		entradas = teclado.nextInt();
		
		for (int i = 0 ; i< entradas ; i++ ) {
		

			try {
				System.out.println("Introduzca la fila de la  butaca actual: ");
				fila = teclado.nextInt();
				System.out.println("Introduzca la columna de la butaca actual : ");
				columna = teclado.nextInt();
		
		//Si la j NO es 8 NI 0
				if((matriz[fila-1][columna-1]==8) || (matriz[fila-1][columna-1]==0)) {
					if (matriz[fila-1][columna-1]==8) {
						System.out.println("No hay butaca, es pasillo");
						i--;
					}
					else {
						System.out.println("Esa butaca  está libre");
						i--;
					}
				}
				else {
					matriz[fila-1][columna-1] = 0;
				}
			}catch (InputMismatchException error) {
				System.out.println("No introduzca palabras raras");
			}catch (ArrayIndexOutOfBoundsException error) {
				System.out.println("El valor introducido no es correcto");
			}
		
			try {
				System.out.println("Introduzca la fila de tu nueva butaca: ");
				fila = teclado.nextInt();
				System.out.println("Introduzca la columna de tu nueva butaca: ");
				columna = teclado.nextInt();
		
		//Si la j NO es 8 NI 1
				if((matriz[fila-1][columna-1]==8) || (matriz[fila-1][columna-1]==1)) {
					if (matriz[fila-1][columna-1]==8) {
						System.out.println("No hay butaca, es pasillo");
					}
					else {
						System.out.println("Esa butaca ya está ocupada");
					}
				}
				else {
					matriz[fila-1][columna-1] = 1;
				}
			}catch (InputMismatchException error) {
				System.out.println("No introduzca palabras raras");
			}catch (ArrayIndexOutOfBoundsException error) {
				System.out.println("El valor introducido no es correcto");
			}
		}
	}	
	

}
