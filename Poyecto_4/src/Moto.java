
public class Moto extends Vehiculo {
				String cilindrada;

				public Moto(String marca, String modelo, String matricula,String cilindrada) {
					super(marca, modelo, matricula);
					this.cilindrada=cilindrada;
		
				}

				public String getCilindrada() {
					return cilindrada;
				}

				public void setCilindrada(String cilindrada) {
					this.cilindrada = cilindrada;
				}

				@Override
				public String toString() {
					return "Moto [cilindrada=" + cilindrada + ", marca=" + marca + ", modelo=" + modelo + ", matricula="
							+ matricula + "]";
				}



				
				

}
