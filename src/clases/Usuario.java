package clases;

public class Usuario {
	private String nombre;
	private String clave;
	private int puntos;

	public Usuario() {
		// TODO Auto-generated constructor stub
		this.setNombre("");
		this.setClave("");
		this.setPuntos(0);
	}
	
	public Usuario(String nombre, String clave, int puntos){
		this.setNombre(nombre);
		this.setClave(clave);
		this.setPuntos(puntos);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
