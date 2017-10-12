package clases;

public class PreguntaJuego4 {
	private int id;
	private String pregunta;
	private String opcion1;
	private String opcion2;
	private String opcion3;
	private String opcion4;
	private int respuesta;

	public PreguntaJuego4() {
		// TODO Auto-generated constructor stub
		this.setId(0);
		this.setPregunta("");
		this.setOpcion1("");
		this.setOpcion2("");
		this.setOpcion3("");
		this.setOpcion4("");
		this.setRespuesta(0);
	}
	
	public PreguntaJuego4(int id, String pregunta, String opcion1, String opcion2, String opcion3, String opcion4, int respuesta) {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setPregunta(pregunta);
		this.setOpcion1(opcion1);
		this.setOpcion2(opcion2);
		this.setOpcion3(opcion3);
		this.setOpcion4(opcion4);
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
	
	public String getOpcion1() {
		return opcion1;
	}

	public void setOpcion1(String opcion1) {
		this.opcion1 = opcion1;
	}

	public String getOpcion2() {
		return opcion2;
	}

	public void setOpcion2(String opcion2) {
		this.opcion2 = opcion2;
	}

	public String getOpcion3() {
		return opcion3;
	}

	public void setOpcion3(String opcion3) {
		this.opcion3 = opcion3;
	}

	public String getOpcion4() {
		return opcion4;
	}

	public void setOpcion4(String opcion4) {
		this.opcion4 = opcion4;
	}

}
