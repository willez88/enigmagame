package clases;

/*respuesta: se representa como un numero que el usuario debe acertar cumpliendo
 * numero<respuesta && numero>respuesta-6
*/
public class PreguntaJuego3 {
	private int id;
	private String pregunta;
	private int respuesta;

	public PreguntaJuego3() {
		// TODO Auto-generated constructor stub
		this.setId(0);
		this.setPregunta("");
		this.setRespuesta(0);
	}
	
	public PreguntaJuego3(int id, String pregunta, int respuesta) {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setPregunta(pregunta);
		this.setRespuesta(respuesta);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public int getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}

}
