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
				IntroducirCoche(matriz, filas, columnas , cuota,teclado);
				break;
			case 3:
				IntroducirMoto(matriz, filas, columnas , cuota,teclado);
				break;
			case 4:
				IntroducirAutobus(matriz, filas, columnas , cuota,teclado);
				break;
			case 5:
				SacarVehiculo(matriz, filas, columnas,teclado);
				break;
			case 6:
				MostrarBeneficio(cuota);
				break;
			case 7:
				System.out.println(" Disfrute su pelicula.");
				break;
			default:
				System.out.println(" Opcion Invalida.");
				
		}

		
	}

while (opcion !=7);

	}

	
private static void InicializarMatriz(char [][] matriz, int filas, int columnas){
		
		for(int f = 0 ; f<filas ; f++) {
			for(int c=0 ; f<columnas ; c++) {
					if((f == 0) || (f == 4) ||(c == 9) || (c == 0) ) 
						matriz [f][c] = 'P';
					if(((c == 0) && ((f == 0 )||(f == 2)|| (f== 4))) ||((c == 10) && ((f == 0 )||(f == 2)|| (f== 4))) ) 
						matriz [f][c] = 'X';
					if((f == 0) && (c == 1 ) ) 
						matriz [f][c] = 'E';
					if( (f == 0) && (c == 3) ) 
						matriz [f][c] = 'S';
									
			}
		}					
	}
	
private static void ImprimirMatriz(char [][] matriz, int filas, int columnas){
	
		for(int f = 0 ; f<filas ; f++) {
			for(int c=0 ; f<columnas ; c++) {
				System.out.print(matriz[f][c]+"\t");
				}
				System.out.println();
			}		
}

private static void IntroducirCoche(char [][]matriz,int filas,int columnas ,int cuota,Scanner teclado) {
		
	try {
		System.out.println("Introduce la fila: ");
		filas = teclado.nextInt();
		System.out.println("Introduce la columa: ");
		columnas = teclado.nextInt();
		
		if(matriz[filas-1][columnas-1] == 'X' ||matriz[filas-1][columnas-1] == 'P' || matriz[filas-1][columnas-1] == 'E'|| matriz[filas-1][columnas-1] == 'S'){		
			if(matriz[filas-1][columnas-1] == 'E' ||matriz[filas-1][columnas-1] == 'S')
				System.out.println("Esta la salida o la entrada");
			if(matriz[filas-1][columnas] == 'X' ||matriz[filas][columnas] == 'P')
				System.out.println("Es pared o columna");
		}
		else 
			matriz[filas][columnas] = 'C';
			cuota += 5;
	}catch(InputMismatchException error) {
		System.out.println("No introduzca palabras raras");
	}catch (ArrayIndexOutOfBoundsException error) {
		System.out.println("El valor introducido no es correcto");
	}
}
private static void IntroducirMoto(char [][]matriz,int filas,int columnas ,int cuota,Scanner teclado) {
	
	try {
		System.out.println("Introduce la fila: ");
		filas = teclado.nextInt();
		System.out.println("Introduce la columa: ");
		columnas = teclado.nextInt();
		
		if(matriz[filas-1][columnas-1] == 'X' ||matriz[filas-1][columnas-1] == 'P' || matriz[filas-1][columnas-1] == 'E'|| matriz[filas-1][columnas-1] == 'S'){		
			if(matriz[filas-1][columnas-1] == 'E' ||matriz[filas-1][columnas-1] == 'S')
				System.out.println("Esta la salida o la entrada");
			if(matriz[filas-1][columnas] == 'X' ||matriz[filas][columnas] == 'P')
				System.out.println("Es pared o columna");
		}
		else 
			matriz[filas][columnas] = 'M';
			cuota += 3;
	}catch(InputMismatchException error) {
		System.out.println("No introduzca palabras raras");
	}catch (ArrayIndexOutOfBoundsException error) {
		System.out.println("El valor introducido no es correcto");
	}
}
private static void IntroducirAutobus(char [][]matriz,int filas,int columnas ,int cuota,Scanner teclado) {
	
	try {
		System.out.println("Introduce la fila: ");
		filas = teclado.nextInt();
		System.out.println("Introduce la columa: ");
		columnas = teclado.nextInt();
		
		if(matriz[filas-1][columnas-1] == 'X' ||matriz[filas-1][columnas-1] == 'P' || matriz[filas-1][columnas-1] == 'E'|| matriz[filas-1][columnas-1] == 'S'){		
			if(matriz[filas-1][columnas-1] == 'E' ||matriz[filas-1][columnas-1] == 'S')
				System.out.println("Esta la salida o la entrada");
			if(matriz[filas-1][columnas] == 'X' ||matriz[filas][columnas] == 'P')
				System.out.println("Es pared o columna");
		}
		else 
			matriz[filas][columnas] = 'A';
			cuota += 10;
	}catch(InputMismatchException error) {
		System.out.println("No introduzca palabras raras");
	}catch (ArrayIndexOutOfBoundsException error) {
		System.out.println("El valor introducido no es correcto");
	}
}
private static void MostrarBeneficio(int cuota) {
	
	System.out.println(cuota+"\t");
	
}
private static void SacarVehiculo( char [][] matriz, int filas, int columnas,Scanner teclado) {

	try {
		System.out.println("Introduce la fila: ");
		filas = teclado.nextInt();
		System.out.println("Introduce la columa: ");
		columnas = teclado.nextInt();
		
		if(matriz[filas-1][columnas-1] == 'X' ||matriz[filas-1][columnas-1] == 'P' || matriz[filas-1][columnas-1] == 'E'|| matriz[filas-1][columnas-1] == 'S'||matriz[filas-1][columnas-1] == 'A' ||matriz[filas-1][columnas-1] == 'M' || matriz[filas-1][columnas-1] == 'C'){		
			if(matriz[filas-1][columnas-1] == 'E' ||matriz[filas-1][columnas-1] == 'S')
				System.out.println("Esta la salida o la entrada");
			if(matriz[filas-1][columnas] == 'X' ||matriz[filas][columnas] == 'P')
				System.out.println("Es pared o columna");
			if(matriz[filas-1][columnas-1] == 'A' ||matriz[filas-1][columnas-1] == 'M' || matriz[filas-1][columnas-1] == 'C')
				System.out.println("Es un vehiculo");
		}
				else 
			matriz[filas][columnas] = ' ';
	
	}catch(InputMismatchException error) {
		System.out.println("No introduzca palabras raras");
	}catch (ArrayIndexOutOfBoundsException error) {
		System.out.println("El valor introducido no es correcto");
	}
}
	

}








