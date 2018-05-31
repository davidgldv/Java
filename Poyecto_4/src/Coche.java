
public class Coche extends Vehiculo {
			String dni;
			boolean electrico;
			public Coche(String marca, String modelo, String matricula,String dni,boolean electrico) {
				super(marca, modelo, matricula);
				this.dni = dni;
				this.electrico = electrico;				
			}
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
			@Override
			public String toString() {
				return "Coche [dni=" + dni + ", electrico=" + electrico + ", marca=" + marca + ", modelo=" + modelo
						+ ", matricula=" + matricula + "]";
			}

			
	
}
