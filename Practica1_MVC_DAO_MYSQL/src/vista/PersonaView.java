package vista;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelos.Persona;

public class PersonaView extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lbl_id;
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEdad;
	private JButton btnModificar;
	private JButton button_2;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblEdad;
	private JButton btnInsertar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonaView frame = new PersonaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonaView() {
		setResizable(false);
		initTable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBounds(new Rectangle(0, 0, 0, 300));
		panelSuperior.setBounds(0, 0, 586, 300);
		contentPane.add(panelSuperior);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBounds(0, 300, 586, 174);
		contentPane.add(panelInferior);
		panelInferior.setLayout(null);
		
		lbl_id = new JLabel("Id");
		lbl_id.setBounds(10, 29, 71, 25);
		panelInferior.add(lbl_id);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 64, 71, 25);
		panelInferior.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 100, 71, 25);
		panelInferior.add(lblApellido);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 135, 71, 25);
		panelInferior.add(lblEdad);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(91, 31, 191, 20);
		panelInferior.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(91, 66, 191, 20);
		panelInferior.add(textFieldNombre);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(91, 102, 191, 20);
		panelInferior.add(textFieldApellido);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(91, 137, 191, 20);
		panelInferior.add(textFieldEdad);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(332, 30, 89, 23);
		panelInferior.add(btnInsertar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(332, 65, 89, 23);
		panelInferior.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(332, 101, 89, 23);
		panelInferior.add(btnModificar);
		
		button_2 = new JButton("?");
		button_2.setBounds(332, 136, 89, 23);
		panelInferior.add(button_2);
		
		//Agrego scroll al panel
		panelSuperior.add(this.scrollPane);
	}
	
	private void initTable() {
		String[] columnNames = {"ID", "NOMBRE", "APELLIDO", "EDAD"};
		//PROVISIONAL
		Object[][] data = {
				{1, "Agus", "Perez", 20},
				{2, "Vicky", "Muse", 50},
				{3, "Augusto", "Mesu", 12}
		};
		
		this.dtm = new DefaultTableModel(data, columnNames);
		this.table = new JTable(dtm);
		this.scrollPane = new JScrollPane(this.table);
		
		
	}
	
	public JLabel getLbl_id() {
		return lbl_id;
	}

	public void setLbl_id(JLabel lbl_id) {
		this.lbl_id = lbl_id;
	}

	public JTextField getTextFieldId() {
		return textFieldId;
	}

	public void setTextFieldId(JTextField textFieldId) {
		this.textFieldId = textFieldId;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JTextField getTextFieldApellido() {
		return textFieldApellido;
	}

	public void setTextFieldApellido(JTextField textFieldApellido) {
		this.textFieldApellido = textFieldApellido;
	}

	public JTextField getTextFieldEdad() {
		return textFieldEdad;
	}

	public void setTextFieldEdad(JTextField textFieldEdad) {
		this.textFieldEdad = textFieldEdad;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getButton_2() {
		return button_2;
	}

	public void setButton_2(JButton button_2) {
		this.button_2 = button_2;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JLabel getLblEdad() {
		return lblEdad;
	}

	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}

	public JButton getBtnInsertar() {
		return btnInsertar;
	}

	public void setBtnInsertar(JButton btnInsertar) {
		this.btnInsertar = btnInsertar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	
}
