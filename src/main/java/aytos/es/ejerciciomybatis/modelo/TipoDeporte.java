package aytos.es.ejerciciomybatis.modelo;

public class TipoDeporte {

	private int id;
	private String nombre;

	public TipoDeporte() {
	}

	public TipoDeporte(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoDeporte [id=" + this.id + ", nombre=" + this.nombre + "]";
	}

}
