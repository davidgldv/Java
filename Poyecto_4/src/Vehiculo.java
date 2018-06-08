//Clase padre de vehiculo
public class Vehiculo {
	
	//Atributos
		String marca;
		String modelo;
		String matricula;
		
	//Constructor 	
		public Vehiculo(String marca, String modelo, String matricula) {
			this.marca = marca;
			this.modelo = modelo;
			this.matricula = matricula;
		}

	//Metodos de dar y obtener atributos
		public String getMarca() {
			return marca;
		}


		public void setMarca(String marca) {
			this.marca = marca;
		}


		public String getModelo() {
			return modelo;
		}


		public void setModelo(String modelo) {
			this.modelo = modelo;
		}


		public String getMatricula() {
			return matricula;
		}


		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

//Escribir por pantalla atributos 
		@Override
		public String toString() {
			return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + "]";
		}
		
}
