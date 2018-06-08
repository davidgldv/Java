//Clase hija de vehiculo
public class Coche extends Vehiculo {
	
	//Atributos
			String dni;
			boolean electrico;
			
	//Constructor
			public Coche(String marca, String modelo, String matricula,String dni,boolean electrico) {
				super(marca, modelo, matricula);
				this.dni = dni;
				this.electrico = electrico;				
			}
			
	//Metodos de dar y obtener valores
			public String getDni() {
				return dni;
			}
			public void setDni(String dni) {
				this.dni = dni;
			}
			public boolean isElectrico() {
				return electrico;
			}
			public void setElectrico(boolean electrico) {
				this.electrico = electrico;
			}
			
	//Metodo de escribir los atributos
			@Override
			public String toString() {
				return "Coche [dni=" + dni + ", electrico=" + electrico + ", marca=" + marca + ", modelo=" + modelo
						+ ", matricula=" + matricula + "]";
			}

			
	
}
