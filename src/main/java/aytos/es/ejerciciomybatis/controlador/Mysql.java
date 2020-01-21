package aytos.es.ejerciciomybatis.controlador;

import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import aytos.es.ejerciciomybatis.modelo.Campo;
import aytos.es.ejerciciomybatis.modelo.Reserva;
import aytos.es.ejerciciomybatis.modelo.TipoDeporte;

public class Mysql {

	private static final SqlMapClient sqlMap = Mysql.initSql();

	public static SqlMapClient initSql() {
		try {
			final String resource = "config-mybatis.xml";
			final Reader reader = Resources.getResourceAsReader(resource);
			final SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			return sqlMap;
		} catch (Exception e) {
			throw new PersistenceException("Couldn't config MyBatis correctly", e);
		}
	}

	public static boolean createCampo(Campo campo) {
		try {
			Mysql.sqlMap.insert("insertCampo", campo);
		} catch (Exception e) {
			System.out.println("No se pudo crear el Campo");
			return false;
		}
		return true;
	}

	public static boolean createTipoDeporte(TipoDeporte tipoDeporte) {
		try {
			Mysql.sqlMap.insert("insertTipoDeporte", tipoDeporte);
		} catch (Exception e) {
			System.out.println("No se pudo crear el Tipo de deporte");
			return false;
		}
		return true;
	}

	public static boolean createReserva(Reserva reserva) {
		try {
			Mysql.sqlMap.insert("insertReserva", reserva);
		} catch (Exception e) {
			System.out.println("No se pudo crear la reserva");
			return false;
		}
		return true;
	}

	public static Campo getCampo(int id) {
		try {
			return (Campo) Mysql.sqlMap.queryForObject("getCampo", id);
		} catch (Exception e) {
			throw new PersistenceException("Couldn't get Campo with id: " + id, e);
		}
	}

	public static TipoDeporte getTipoDeporte(int id) {
		try {
			return (TipoDeporte) Mysql.sqlMap.queryForObject("getTipoDeporte", id);
		} catch (Exception e) {
			throw new PersistenceException("Couldn't get TipoDeporte with id: " + id, e);
		}
	}

	public static Reserva getReserva(int id) {
		try {
			return (Reserva) Mysql.sqlMap.queryForObject("getReserva", id);
		} catch (Exception e) {
			throw new PersistenceException("Couldn't get Reserva with id: " + id, e);
		}
	}

	public static List<?> getCampos() {
		try {
			List<?> campos = Mysql.sqlMap.queryForList("getCampos");
			try {
				Arrays.asList(campos).stream().map(o -> (Campo) o);
			} catch (Exception e) {
				System.out.println("Recieved a non List of Campo");
			}
			return campos;

		} catch (Exception e) {
			throw new PersistenceException("Couldn't get all Campos: ", e);
		}
	}

	public static List<?> getTipoDeportes() {
		try {
			List<?> tipoDeportes = Mysql.sqlMap.queryForList("getTipoDeportes");
			try {
				Arrays.asList(tipoDeportes).stream().map(o -> (TipoDeporte) o);
			} catch (Exception e) {
				System.out.println("Recieved a non List of TipoDeporte");
			}
			return tipoDeportes;
		} catch (Exception e) {
			throw new PersistenceException("Couldn't get all TipoDeportes: ", e);
		}
	}

	public static List<?> getReservas() {
		try {
			List<?> reserva = Mysql.sqlMap.queryForList("getReserva");
			try {
				Arrays.asList(reserva).stream().map(o -> (Reserva) o);
			} catch (Exception e) {
				System.out.println("Recieved a non List of Reserva");
			}
			return reserva;
		} catch (Exception e) {
			throw new PersistenceException("Couldn't get all Reservas: ", e);
		}
	}

	public static boolean updateCampo(int id, Campo campoUpdate) {
		try {
			campoUpdate.setId(id);
			Mysql.sqlMap.update("updateCampo", campoUpdate);
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el Campo con id: " + id);
			return false;
		}
		return true;
	}

	public static boolean updateTipoDeporte(int id, TipoDeporte tipoDeporteUpdate) {
		try {
			tipoDeporteUpdate.setId(id);
			Mysql.sqlMap.update("updateTipoDeporte", tipoDeporteUpdate);
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el Tipo de deporte con id: " + id);
			return false;
		}
		return true;
	}

	public static boolean updateReserva(int id, Reserva reservaUpdate) {
		try {
			reservaUpdate.setId(id);
			Mysql.sqlMap.update("updateReserva", reservaUpdate);
		} catch (Exception e) {
			System.out.println("No se pudo actualizar la reserva con id: " + id);
			return false;
		}
		return true;
	}

	public static boolean deleteCampo(int id) {
		try {
			Mysql.sqlMap.delete("deleteCampo", id);
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el Campo con id: " + id);
			return false;
		}
		return true;
	}

	public static boolean deleteTipoDeporte(int id) {
		try {
			Mysql.sqlMap.delete("deleteTipoDeporte", id);
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el Tipo de deporte con id: " + id);
			return false;
		}
		return true;
	}

	public static boolean deleteReserva(int id) {
		try {
			Mysql.sqlMap.delete("deleteReserva", id);
		} catch (Exception e) {
			System.out.println("No se pudo eliminar la reserva con id: " + id);
			return false;
		}
		return true;
	}
}
