package clases;

public class PreguntaJuego2 {
	private int id;
	private String pregunta;
	private String respuesta;
	
	public PreguntaJuego2() {
		// TODO Auto-generated constructor stub
		this.setId(0);
		this.setPregunta("");
		this.setRespuesta("");
	}
	
	public PreguntaJuego2(int id, String pregunta, String respuesta) {
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

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
