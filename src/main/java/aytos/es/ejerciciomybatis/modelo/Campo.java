package aytos.es.ejerciciomybatis.modelo;

public class Campo {

	private int id;
	private Integer longitud;

	public Campo() {
	}

	public Campo(int id, Integer longitud) {
		this.id = id;
		this.longitud = longitud;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Campo [id=" + this.id + ", longitud=" + this.longitud + "]";
	}

}
