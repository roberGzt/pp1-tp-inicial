package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Agenda;
import modelo.Validador;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.FormularioContactos;
import presentacion.vista.Principal;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;

public class ControladorPrincipal implements ActionListener {
	private Principal vista;
	private List<PersonaDTO> personasEnTabla;
	private List<LocalidadDTO> localidades;
	private List<TipoDeContactoDTO> tiposDeContacto;
	private FormularioContactos ventanaPersona;
	private Agenda agenda;
	private ControladorGestionLocalidades controladorLocalidades;
	private ControladorGestionDeTiposContacto controladorTipos;
	private ControladorContactos controladorContactos;

	public ControladorPrincipal(Principal vista, Agenda agenda) {
		this.vista = vista;
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnBorrar().addActionListener(this);
		this.vista.getBtnEditar().addActionListener(this);
		this.vista.getBtnReporte().addActionListener(this);
		this.vista.getBtnGestionDeTipos().addActionListener(this);
		this.vista.getBtnGestionLocalidades().addActionListener(this);
		this.agenda = agenda;
		this.personasEnTabla = null;
		localidades = agenda.getLocalidades();
		tiposDeContacto = agenda.getTiposDeContacto();
		controladorLocalidades = ControladorGestionLocalidades.getInstance();
		controladorTipos = ControladorGestionDeTiposContacto.getInstance();
		controladorContactos = ControladorContactos.getInstance();
	}

	public void inicializar() {
		this.updateTabla();
	}

	private void updateTabla() {
		this.vista.getModelPersonas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelPersonas().setColumnCount(0);
		this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());

		this.personasEnTabla = agenda.obtenerPersonas();
		personasEnTabla.forEach(this::añadirPersonaATabla);

		this.vista.show();
	}

	private void añadirPersonaATabla(PersonaDTO p) {
		Object[] fila = { p.getNombre(), p.getTelefono(), p.getDomicilio().getCalle(), p.getDomicilio().getAltura(),
				p.getDomicilio().getPiso(), p.getDomicilio().getDepartamento(),
				p.getDomicilio().getLocalidad().getNombre(), p.getMail(), p.getFechaCumpleaños(),
				p.getTipoDeContacto().getNombre() };
		vista.getModelPersonas().addRow(fila);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getBtnAgregar()) {
			controladorContactos.abrirVentana(null);
		} else if (e.getSource() == vista.getBtnBorrar()) {

			int indexFilaSeleccionada = vista.getTablaPersonas().getSelectedRow();
			if (indexFilaSeleccionada != -1) {
				borrarPersonasSeleccionadas();
				updateTabla();
			} else
				JOptionPane.showMessageDialog(null, "Selecciona una persona para borrar primero", "Aviso",
						JOptionPane.ERROR_MESSAGE);

		} else if (e.getSource() == vista.getBtnReporte()) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();
		} else if (e.getSource() == vista.getBtnEditar()) {
			int indexFilaSeleccionada = vista.getTablaPersonas().getSelectedRow();
			if (indexFilaSeleccionada != -1)
				controladorContactos.abrirVentana(personasEnTabla.get(indexFilaSeleccionada));
			else
				JOptionPane.showMessageDialog(null, "Selecciona una persona para editar primero", "Aviso",
						JOptionPane.ERROR_MESSAGE);
		}
		else if (e.getSource() == vista.getBtnGestionDeTipos()) {
			abrirGestionDeTipos();
		}
		else if (e.getSource() == vista.getBtnGestionLocalidades()) {
			abrirGestionLocalidades();
		}		
	}

	private void abrirGestionLocalidades() {
		controladorLocalidades.abrirVentana();
	}

	private void abrirGestionDeTipos() {
		controladorTipos.abrirVentana();
	}

	

	

	private void borrarPersonasSeleccionadas() {
		int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
		for (int fila : filas_seleccionadas) {
			this.agenda.borrarPersona(this.personasEnTabla.get(fila));
		}
	}

	

}
