package aytos.es.ejerciciomybatis.utils;

import java.util.List;

import javax.swing.JOptionPane;

import aytos.es.ejerciciomybatis.controlador.Mysql;
import aytos.es.ejerciciomybatis.modelo.Campo;
import aytos.es.ejerciciomybatis.modelo.Reserva;
import aytos.es.ejerciciomybatis.modelo.TipoDeporte;

public class Menu {

	public void init() {
		final String menuMsg = JOptionPane
				.showInputDialog("Selecciona una tabla\n1. Campo\n2. Tipo de deporte\n3. Reserva");

		switch (menuMsg) {
		case "1":
			this.crud("campo");
			break;

		case "2":
			this.crud("tipoDeporte");
			break;

		case "3":
			this.crud("reserva");
			break;

		default:
			System.out.println("Seleccione una de las tablas existentes");
		}
	}

	public void crud(String table) {
		final String crudMsg = JOptionPane.showInputDialog(
				"Selecciona una operación\n1. Ver por id\n2. Ver todos\n3. Crear\n4. Actualizar\n5. Eliminar");
		
		switch (crudMsg) {
		case "1":
			final String idGet= JOptionPane.showInputDialog("Introduce un id válido");
			try {
				final Integer id = Integer.parseInt(idGet);
				Object resultGet = false;
				
				if (table.equals("campo")) resultGet = Mysql.getCampo(id);
				else if (table.equals("tipoDeporte")) resultGet = Mysql.getTipoDeporte(id);
				else if (table.equals("reserva")) resultGet = Mysql.getReserva(id);
				else System.out.println("Tabla no válida");
				
				System.out.println(resultGet);
			} catch (Exception e) {
				System.out.println("El id debe ser numérico");
			}
			break;
			
		case "2":
			List<?> result = null;
			
			if (table.equals("campo")) result = Mysql.getCampos();
			else if (table.equals("tipoDeporte")) result = Mysql.getTipoDeportes();
			else if (table.equals("reserva")) result = Mysql.getReservas();
			else System.out.println("Tabla no válida");
			
			if (result == null) System.out.println("Tabla incorrecta");
			else System.out.println(result);
			break;
			
		case "3":
			if (table.equals("campo")) {
				final String longitudMsg= JOptionPane.showInputDialog("Introduce una longitud para el campo");
				Campo campo = new Campo();
				try {
					final Integer longitud = Integer.parseInt(longitudMsg);
					campo.setLongitud(longitud);
					Mysql.createCampo(campo);
				} catch (Exception e) {
					System.out.println("La longitud debe ser numérica");
				}
			}
			
			if (table.equals("tipoDeporte")) {
				final String nombreMsg = JOptionPane.showInputDialog("Introduce un nombre para el tipo de deporte");
				TipoDeporte tipoDeporte = new TipoDeporte();
				tipoDeporte.setNombre(nombreMsg);
				Mysql.createTipoDeporte(tipoDeporte);
			}
			
			if (table.equals("reserva")) {
				final String idCampoMsg = JOptionPane.showInputDialog("Introduce un id par idCampo");
				final String idTipoDeporteMsg = JOptionPane.showInputDialog("Introduce un id para idTipoDeporte");
				Reserva reserva = new Reserva();
				try {
					final Integer idCampo = Integer.parseInt(idCampoMsg);
					final Integer idTipoDeporte = Integer.parseInt(idTipoDeporteMsg);
					reserva.setIdCampo(idCampo);
					reserva.setIdTipoDeporte(idTipoDeporte);
					
					Mysql.createReserva(reserva);
				} catch (Exception e) {
					System.out.println("Los id deben ser numéricos");
				}
			}
			break;
			
		case "4":
			final String idUpdate = JOptionPane.showInputDialog("Introduce un id válido");
			try {
				final Integer id = Integer.parseInt(idUpdate);
				if (table.equals("campo")) {
					Campo campoUpdate = new Campo();
					campoUpdate.setId(id);
					
					final String longitudUpdateMsg = JOptionPane.showInputDialog("Introduce un nuevo valor para la longitud");
					try {
						final Integer longitudUpdate = Integer.parseInt(longitudUpdateMsg);
						campoUpdate.setLongitud(longitudUpdate);
						
						Mysql.updateCampo(id, campoUpdate);
					} catch (Exception e) {
						System.out.println("La longitud debe ser numérica");
					}
				}
				
				if (table.equals("tipoDeporte")) {
					TipoDeporte tipoDeporteUpdate = new TipoDeporte();
					tipoDeporteUpdate.setId(id);
					
					final String nombreUpdateMsg = JOptionPane.showInputDialog("Introduce un nuevo valor para el nombre");
					tipoDeporteUpdate.setNombre(nombreUpdateMsg);
						
					Mysql.updateTipoDeporte(id, tipoDeporteUpdate);
				}
				
				if (table.equals("reserva")) {
					Reserva reservaUpdate = new Reserva();
					reservaUpdate.setId(id);
					
					final String idCampoUpdateMsg = JOptionPane.showInputDialog("Introduce un nuevo id para idCampo");
					final String idTipoDeporteUpdateMsg = JOptionPane.showInputDialog("Introduce un nuevo id para idTipoDeporte");
					try {
						final Integer idCampoUpdate = Integer.parseInt(idCampoUpdateMsg);
						final Integer idTipoDeportedUpdate = Integer.parseInt(idTipoDeporteUpdateMsg);
						
						reservaUpdate.setIdCampo(idCampoUpdate);
						reservaUpdate.setIdTipoDeporte(idTipoDeportedUpdate);
						
						Mysql.updateReserva(id, reservaUpdate);
					} catch (Exception e) {
						System.out.println("Los id deben ser numéricos");
					}
				}
			} catch (Exception e) {
				System.out.println("El id debe ser numérico");
			}
			break;
		
		case "5":
			final String idDelete = JOptionPane.showInputDialog("Introduce un id válido");
			try {
				final Integer id = Integer.parseInt(idDelete);
				if (table.equals("campo")) Mysql.deleteCampo(id);
				else if (table.equals("tipoDeporte")) Mysql.deleteTipoDeporte(id);
				else if (table.equals("reserva")) Mysql.deleteReserva(id);
				else System.out.println("Tabla no válida");
			} catch (Exception e) {
				System.out.println("El id debe ser numérico");
			}
		}
	}
}
