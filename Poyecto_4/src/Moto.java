//Clase hija de vehiculo
public class Moto extends Vehiculo {
	
	//Atributos
				String cilindrada;

	//Constructor			
				public Moto(String marca, String modelo, String matricula,String cilindrada) {
					super(marca, modelo, matricula);
					this.cilindrada=cilindrada;
		
				}

	//Metodos dar y obtener valores
				
				public String getCilindrada() {
					return cilindrada;
				}

				public void setCilindrada(String cilindrada) {
					this.cilindrada = cilindrada;
				}

	//Metodo que imprime por pantalla los atributos
				@Override
				public String toString() {
					return "Moto [cilindrada=" + cilindrada + ", marca=" + marca + ", modelo=" + modelo + ", matricula="
							+ matricula + "]";
				}



				
				

}
