import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int filas = 5;
		int columnas = 10;
		int opcion = 0;
		int cuota = 0;
		char [][] matriz = new char [filas][columnas];
		Scanner teclado = new Scanner(System.in);
		int fila = 0;
		int columna =0;
		int nVehiculos=0;
		
		
		InicializarMatriz(matriz, filas, columnas);
		
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
			
			
			switch(opcion) {
			
			case 1:
				ImprimirMatriz(matriz, filas, columnas);
				break;
			case 2:
				if(nVehiculos==24) {
					System.out.println("Parking Lleno");
				}
				else
				IntroducirCoche(matriz, fila, columna,teclado);
				cuota+=5;
				nVehiculos++;
				break;
			case 3:
				if(nVehiculos==24) {
					System.out.println("Parking Lleno");
				}
				else
				IntroducirMoto(matriz, filas, columnas ,teclado);
				cuota+=3;
				nVehiculos++;
				break;
			case 4:
				if(nVehiculos==24) {
					System.out.println("Parking Lleno");
				}
				else
				IntroducirAutobus(matriz, filas, columnas ,teclado, cuota);
				nVehiculos++;
				break;
			case 5:
				if(nVehiculos==0) {
					System.out.println("Parking Vacio");
				}
				SacarVehiculo(matriz, fila, columna,teclado);
				nVehiculos--;
				break;
			case 6:
				MostrarBeneficio(cuota);
				break;
			case 7:
				System.out.println(" Hasta luego.");
				break;
			default:
				System.out.println(" Opcion Invalida.");
				
		}

		
	}

while (opcion !=7);

}

	
private static void InicializarMatriz(char [][] matriz, int filas, int columnas){
		
		for(int f = 0 ; f<filas ; f++) {
			for(int c=0 ; c<columnas ; c++) {
					if( (f == 0) || (f == 4) || (c == 9) || (c == 0) ) {
						matriz [f][c] = 'P'; 
						}
					if( (c == 0) && (f == 0 ) || (c == 9) && (f == 0 ) || (c == 9) &&  (f == 4)|| (c == 0) && (f == 4 )) {
						matriz [f][c] = 'X';
						}
					if( (f == 1) && (c == 0 ) ) { 
						matriz [f][c] = 'E';
						}
					if( (f == 3) && (c == 0) ) { 
						matriz [f][c] = 'S';
					}
			}
		}					
	}
	
private static void ImprimirMatriz(char [][] matriz, int filas, int columnas){
	
		for(int f = 0 ; f<filas ; f++) {
			for(int c=0 ; c<columnas ; c++) {
				System.out.print(matriz[f][c]+"\t");
				}
				System.out.println();
			}		
}

private static void IntroducirCoche(char [][]matriz,int fila,int columna ,Scanner teclado) {
		
	try {
		System.out.println("Introduce la fila: ");
		fila = teclado.nextInt();
		System.out.println("Introduce la columna: ");
		columna = teclado.nextInt();
		
		if(matriz[fila-1][columna-1] == 'X' ||matriz[fila-1][columna-1] == 'P' || matriz[fila-1][columna-1] == 'E'|| matriz[fila-1][columna-1] == 'S'|| matriz[fila-1][columna-1] == 'M'
				|| matriz[fila-1][columna-1] == 'C'|| matriz[fila-1][columna-1] == 'A'){		
			if(matriz[fila-1][columna-1] == 'E' ||matriz[fila-1][columna-1] == 'S') {
				System.out.println("Esta la salida o la entrada");
				}
			if(matriz[fila-1][columna-1] == 'X' ||matriz[fila-1][columna-1] == 'P') {
				System.out.println("Es pared o columna");
				}
			if(matriz[fila-1][columna-1] == 'A' ||matriz[fila-1][columna-1] == 'C'||matriz[fila-1][columna-1] == 'M') {
				System.out.println("Esta plaza ya esta ocupada");
			}
		}
		else {
			matriz[fila-1][columna-1] = 'C';
			}
		
	}catch(InputMismatchException error) {
		System.out.println("No introduzca palabras raras");
	}catch (ArrayIndexOutOfBoundsException error) {
		System.out.println("El valor introducido no es correcto");
	}
}
private static void IntroducirMoto(char [][]matriz,int fila,int columna ,Scanner teclado) {
	
	try {
		System.out.println("Introduce la fila: ");
		fila = teclado.nextInt();
		System.out.println("Introduce la columna: ");
		columna = teclado.nextInt();
		
		if(matriz[fila-1][columna-1] == 'X' ||matriz[fila-1][columna-1] == 'P' || matriz[fila-1][columna-1] == 'E'|| matriz[fila-1][columna-1] == 'S'|| matriz[fila-1][columna-1] == 'M'
				|| matriz[fila-1][columna-1] == 'C'|| matriz[fila-1][columna-1] == 'A'){		
			if(matriz[fila-1][columna-1] == 'E' ||matriz[fila-1][columna-1] == 'S') {
				System.out.println("Esta la salida o la entrada");
				}
			if(matriz[fila-1][columna-1] == 'X' ||matriz[fila-1][columna-1] == 'P') {
				System.out.println("Es pared o columna");
				}
			if(matriz[fila-1][columna-1] == 'A' ||matriz[fila-1][columna-1] == 'C'||matriz[fila-1][columna-1] == 'M') {
				System.out.println("Esta plaza ya esta ocupada");
			}
		}
		else {
			matriz[fila-1][columna-1] = 'M';
			}
			
	}catch(InputMismatchException error) {
		System.out.println("No introduzca palabras raras");
	}catch (ArrayIndexOutOfBoundsException error) {
		System.out.println("El valor introducido no es correcto");
	}
}

private static void IntroducirAutobus(char [][]matriz,int fila,int columna ,Scanner teclado,int cuota) {
	
	try {
		System.out.println("Introduce la fila: ");
		fila = teclado.nextInt();
		System.out.println("Introduce la columna: ");
		columna = teclado.nextInt();
		
		if(matriz[fila-1][columna-1] == 'X' ||matriz[fila-1][columna-1] == 'P' || matriz[fila-1][columna-1] == 'E'|| matriz[fila-1][columna-1] == 'S'|| matriz[fila-1][columna-1] == 'M'
				|| matriz[fila-1][columna-1] == 'C'|| matriz[fila-1][columna-1] == 'A'){		
			if(matriz[fila-1][columna-1] == 'E' ||matriz[fila-1][columna-1] == 'S') {
				System.out.println("Esta la salida o la entrada");
				}
			if(matriz[fila-1][columna-1] == 'X' ||matriz[fila-1][columna-1] == 'P') {
				System.out.println("Es pared o columna");
				}
			if(matriz[fila-1][columna-1] == 'A' ||matriz[fila-1][columna-1] == 'C'||matriz[fila-1][columna-1] == 'M') {
				System.out.println("Esta plaza ya esta ocupada");
			}
		}
		else {
			matriz[fila-1][columna-1] = 'A';
			cuota+=10;
			}
		}catch(InputMismatchException error) {
		System.out.println("No introduzca palabras raras");
	}catch (ArrayIndexOutOfBoundsException error) {
		System.out.println("El valor introducido no es correcto");
	}
}
private static void MostrarBeneficio(int cuota) {
	
	System.out.println(cuota+"\t");
	
}
private static void SacarVehiculo( char [][] matriz, int fila, int columna,Scanner teclado) {

	try {
		System.out.println("Introduce la fila: ");
		fila = teclado.nextInt();
		System.out.println("Introduce la columna: ");
		columna = teclado.nextInt();
		
		if(matriz[fila-1][columna-1] == 'X' ||matriz[fila-1][columna-1] == 'P' || matriz[fila-1][columna-1] == 'E'|| matriz[fila-1][columna-1] == 'S'){		
			if(matriz[fila-1][columna-1] == 'E' ||matriz[fila-1][columna-1] == 'S')
				System.out.println("Esta la salida o la entrada");
			if(matriz[fila-1][columna] == 'X' ||matriz[fila][columna] == 'P')
				System.out.println("Es pared o columna");
		}
				else 
			matriz[fila-1][columna-1] = ' ';
	
	}catch(InputMismatchException error) {
		System.out.println("No introduzca palabras raras");
	}catch (ArrayIndexOutOfBoundsException error) {
		System.out.println("El valor introducido no es correcto");
	}
}
	

}









