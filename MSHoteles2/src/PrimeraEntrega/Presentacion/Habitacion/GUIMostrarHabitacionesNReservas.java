package PrimeraEntrega.Presentacion.Habitacion;

import java.util.List;

import javax.swing.JOptionPane;

import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;
import PrimeraEntrega.Presentacion.Vista;
import PrimeraEntrega.Presentacion.Controlador.Evento;
import PrimeraEntrega.Presentacion.Controlador.Implementacion.ControladorImp;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;

public class GUIMostrarHabitacionesNReservas extends javax.swing.JFrame implements Vista {

	/**
	 * Creates new form GUIMostrarHabitacionesNReservas
	 */
	static private GUIMostrarHabitacionesNReservas mostrarHabitacionesNReservas;

	/** Creates new form NuevoDepartamento */
	private GUIMostrarHabitacionesNReservas() {
		initComponents();
	}

	/**
	 * Obtiene la instancia de la ventana
	 * 
	 * @return la instancia de la ventana
	 */
	static public GUIMostrarHabitacionesNReservas obtenerInstancia() {
		if (mostrarHabitacionesNReservas == null) {
			mostrarHabitacionesNReservas = new GUIMostrarHabitacionesNReservas();
		}

		return mostrarHabitacionesNReservas;
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTextAreaIDs = new javax.swing.JTextArea();
		jFormattedTextFieldNumeroReservas = new javax.swing.JFormattedTextField();
		jLabelNReservas = new javax.swing.JLabel();
		jButtonAceptar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jTextAreaIDs.setColumns(20);
		jTextAreaIDs.setRows(5);
		jScrollPane1.setViewportView(jTextAreaIDs);

		jLabelNReservas.setText("Numero Reservas");

		jButtonAceptar.setText("Buscar");
		jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAceptarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(31, 31, 31)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jLabelNReservas).addGap(18, 18, 18)
								.addComponent(jFormattedTextFieldNumeroReservas, javax.swing.GroupLayout.PREFERRED_SIZE,
										116, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(jButtonAceptar))
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(29, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(14, 14, 14)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jFormattedTextFieldNumeroReservas, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelNReservas).addComponent(jButtonAceptar))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(29, 29, 29)));
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				// Borra lo anterior

				jTextAreaIDs.setText("");
			}
		});
		pack();
	}// </editor-fold>

	private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {

		ControladorImp.getInstancia().execute(Evento.MOSTRAR_HABITACION_N_RESERVAS,
				Integer.valueOf(jFormattedTextFieldNumeroReservas.getText()));
		// TODO add your handling code here:
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUIMostrarHabitacionesNReservas.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUIMostrarHabitacionesNReservas.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUIMostrarHabitacionesNReservas.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUIMostrarHabitacionesNReservas.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUIMostrarHabitacionesNReservas().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JFormattedTextField jFormattedTextFieldNumeroReservas;
	private javax.swing.JLabel jLabelNReservas;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextAreaIDs;
	private javax.swing.JButton jButtonAceptar;

	// End of variables declaration
	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		// Borra lo anterior

		jTextAreaIDs.setText("");

		if (id_evento_vista == EventoVista.MOSTRAR_HABITACION_N_RESERVAS_EXITO) {
			List<TransferHabitacion> lista_clientes = (List) datos;

			jTextAreaIDs.append(" Numero\tPiso\tTipo\n\n");

			for (TransferHabitacion t : lista_clientes) {
				jTextAreaIDs.append("  " + t.getNumero() + "\t" + t.getPiso() + "\t" + t.getTipo() + "\n");
			}

		} else if (id_evento_vista == EventoVista.MOSTRAR_HABITACION_N_RESERVAS_FALLO) {
			JOptionPane.showMessageDialog(null, "ERROR!! No se han encontrado Habitaciones para mostrar",
					"Mostrar Habitaciones", JOptionPane.ERROR_MESSAGE);
		}

	}
}
