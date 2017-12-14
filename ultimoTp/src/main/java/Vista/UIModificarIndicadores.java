package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Indicador;
import Modelo.DAOIndicadorJson;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

public class UIModificarIndicadores extends JDialog {

//	private final JPanel contentPanel = new JPanel();
//	private JTextField textField;
//	private JTextField textField_1;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			UIModificarIndicadores dialog = new UIModificarIndicadores();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Create the dialog.
//	 */
//	public void getAllNombres(JComboBox comboIndicador)
//	{	ArrayList<Indicador> listaDeIndicadores  = new ArrayList<Indicador>();
//		DAOIndicadorJson daoIndicador=new DAOIndicadorJson();
//		listaDeIndicadores=daoIndicador.getAll();
//		for(int i = 0; i < listaDeIndicadores.size(); i++) {
//		    comboIndicador.addItem(listaDeIndicadores.get(i).getNombre());
//			}
//	}
//	
//	
//	public UIModificarIndicadores() {
//		setBounds(100, 100, 450, 300);
//		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		contentPanel.setLayout(null);
//		
//		JLabel lblSeleccionarUnIndicador = new JLabel("Seleccionar un indicador :");
//		lblSeleccionarUnIndicador.setForeground(new Color(219, 112, 147));
//		lblSeleccionarUnIndicador.setFont(new Font("Tahoma", Font.BOLD, 13));
//		lblSeleccionarUnIndicador.setBounds(39, 11, 207, 33);
//		contentPanel.add(lblSeleccionarUnIndicador);
//		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(49, 55, 155, 20);
//		this.getAllNombres(comboBox);
//		contentPanel.add(comboBox);
//		
//		JLabel label_1 = new JLabel("Nombre:");
//		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		label_1.setBounds(28, 101, 69, 14);
//		contentPanel.add(label_1);
//		
//		textField = new JTextField();
//		textField.setText((String) null);
//		textField.setColumns(10);
//		textField.setBounds(121, 102, 149, 20);
//		contentPanel.add(textField);
//		
//		textField_1 = new JTextField();
//		textField_1.setText((String) null);
//		textField_1.setColumns(10);
//		textField_1.setBounds(121, 133, 272, 20);
//		contentPanel.add(textField_1);
//		
//		JLabel lblFrmula = new JLabel("F\u00F3rmula:");
//		lblFrmula.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblFrmula.setBounds(28, 136, 83, 14);
//		contentPanel.add(lblFrmula);
//		
//		JButton btnGuardar = new JButton("Guardar");
//		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnGuardar.setActionCommand("Cancel");
//		btnGuardar.setBounds(148, 183, 111, 34);
//		contentPanel.add(btnGuardar);
//		{
//			JPanel buttonPane = new JPanel();
//			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
//			getContentPane().add(buttonPane, BorderLayout.SOUTH);
//			{
//				JButton cancelButton = new JButton("Cancel");
//				cancelButton.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						setVisible(false); // lo ocultas
//						dispose(); // lo destruis
//					}
//				});
//				cancelButton.setActionCommand("Cancel");
//				buttonPane.add(cancelButton);
//			}
//		}
//	}
}
