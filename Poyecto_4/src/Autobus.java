//Clase hija de vehiculo
public class Autobus extends Vehiculo {
	
	//Atributos
		int plazas;
		String compañia;
	
	//Contructor
	public Autobus(String marca, String modelo, String matricula,int plazas, String compañia) {
		super(marca, modelo, matricula);
		this.plazas =plazas;
		this.compañia =compañia;
	}

	//Metodos de dar y obtener valores
	public int getPlazas() {
		return plazas;
	}


	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}


	public String getCompañia() {
		return compañia;
	}


	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	//Metodo para escribir por pantalla los atributos
	@Override
	public String toString() {
		return "Autobus [plazas=" + plazas + ", compañia=" + compañia + ", marca=" + marca + ", modelo=" + modelo
				+ ", matricula=" + matricula + "]";
	}



	
}
