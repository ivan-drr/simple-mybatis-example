package aytos.es.ejerciciomybatis.modelo;

public class Reserva {
	
	private int id;
	private int idCampo;
	private Integer idTipoDeporte;

	public Reserva() {
	}

	public Reserva(int id, int idCampo, Integer idTipoDeporte) {
		this.id = id;
		this.idCampo = idCampo;
		this.idTipoDeporte = idTipoDeporte;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCampo() {
		return this.idCampo;
	}

	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}

	public Integer getIdTipoDeporte() {
		return this.idTipoDeporte;
	}

	public void setIdTipoDeporte(Integer idTipoDeporte) {
		this.idTipoDeporte = idTipoDeporte;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + this.id + ", idCampo=" + this.idCampo + ", idTipoDeporte=" + this.idTipoDeporte + "]";
	}
	
}
