package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.CondicionTaxativa;
import Entity.Empresa;
import Entity.Metodologia;
import Modelo.DAOEmpresa;
import Modelo.DAOjson;
import Modelo.DAOmetodologiaJson;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JList;

public class UIConsulta1Empresa extends JDialog {
//
//	private final JPanel contentPanel = new JPanel();
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			UIConsulta1Empresa dialog = new UIConsulta1Empresa();
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
//	public void getAllNombres(JComboBox comboEmpresa)
//	{
//		ArrayList<Empresa> listaDeEmpresas  = new ArrayList<Empresa>();
//		DAOjson dao=new DAOjson();
//	
//		listaDeEmpresas=dao.getAll();
//		
//		for(int i = 0; i < listaDeEmpresas.size(); i++) {
//		    comboEmpresa.addItem(listaDeEmpresas.get(i).getNombre());
//		}
//	}
//	public void getAllNombresMetodologia(JComboBox comboEmpresa)
//	{
//		ArrayList<Metodologia> listaDeMetodologias  = new ArrayList<Metodologia>();
//		DAOmetodologiaJson dao=new DAOmetodologiaJson();
//		//dao.addAllStruct();
//		listaDeMetodologias=dao.getAll();
//		
//		for(int i = 0; i < listaDeMetodologias.size(); i++) {
//		    comboEmpresa.addItem(listaDeMetodologias.get(i).getNombre());
//		}
//	}
//	
//	public UIConsulta1Empresa() {
//		setBounds(100, 100, 450, 300);
//		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		
//		contentPanel.setLayout(null);
//		{
//			JLabel lblSeleccioneLaEmpresa = new JLabel("Seleccione la Empresa, el Periodo");
//			lblSeleccioneLaEmpresa.setToolTipText("");
//			lblSeleccioneLaEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
//			lblSeleccioneLaEmpresa.setForeground(new Color(255, 105, 180));
//			lblSeleccioneLaEmpresa.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
//			lblSeleccioneLaEmpresa.setBounds(10, 11, 414, 26);
//			contentPanel.add(lblSeleccioneLaEmpresa);
//		}
//		{
//			JLabel lblYLaMetodologia = new JLabel("y la Metodolog\u00EDa que desea aplicar :\r\n");
//			lblYLaMetodologia.setToolTipText("");
//			lblYLaMetodologia.setHorizontalAlignment(SwingConstants.CENTER);
//			lblYLaMetodologia.setForeground(new Color(255, 105, 180));
//			lblYLaMetodologia.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
//			lblYLaMetodologia.setBounds(10, 35, 414, 18);
//			contentPanel.add(lblYLaMetodologia);
//		}
//		{
//			JLabel label = new JLabel("Empresa:");
//			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
//			label.setBounds(10, 64, 78, 20);
//			contentPanel.add(label);
//		}
//		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(113, 65, 116, 20);
//		contentPanel.add(comboBox);
//		this.getAllNombres(comboBox);
//		
//		JComboBox comboBox_1 = new JComboBox();
//		comboBox_1.setBounds(113, 130, 116, 20);
//		contentPanel.add(comboBox_1);
//		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"30/06/2010", "31/12/2011", "30/12/2015"}));
//		
//		JLabel label = new JLabel("Periodo Desde:");
//		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		label.setBounds(10, 95, 99, 27);
//		contentPanel.add(label);
//		
//		JComboBox comboBox_2 = new JComboBox();
//		comboBox_2.setBounds(113, 99, 116, 20);
//		contentPanel.add(comboBox_2);
//		
//		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"01/01/2010", "01/01/2011", "01/06/2015"}));
//		
//		JLabel label_1 = new JLabel("Periodo Hasta:");
//		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		label_1.setBounds(10, 124, 99, 31);
//		contentPanel.add(label_1);
//		
//		JLabel lblMetodologia = new JLabel("Metodolog\u00EDa:");
//		lblMetodologia.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblMetodologia.setBounds(10, 166, 124, 20);
//		contentPanel.add(lblMetodologia);
//
//
//		JComboBox comboBox_3 = new JComboBox();
//		comboBox_3.setBounds(113, 161, 116, 20);
//		this.getAllNombresMetodologia(comboBox_3);
//		contentPanel.add(comboBox_3);
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
//	
//	
//	JButton btnAplicar = new JButton("Aplicar");
//	btnAplicar.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent arg0) {
//			Metodologia metodologia = new Metodologia();
//			CondicionTaxativa cond;
//			if(metodologia.perteneceMetodologia(comboBox_3.getSelectedItem().toString()))
//			{
//				Metodologia metodologiaSeleccionada=new Metodologia();
//				metodologiaSeleccionada= metodologia.buscarMetodologia(comboBox_3.getSelectedItem().toString());
//				boolean resultado;
//				resultado=metodologiaSeleccionada.cumpleCondiciones(comboBox.getSelectedItem().toString(),comboBox_2.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString(),metodologiaSeleccionada);
//				UIAvisoCumpleCondicion aviso= new UIAvisoCumpleCondicion(resultado);
//				aviso.show();
//			}
//		}
//
//	
//	});
//	btnAplicar.setForeground(Color.BLACK);
//	btnAplicar.setFont(new Font("Tahoma", Font.BOLD, 14));
//	btnAplicar.setBounds(289, 109, 106, 23);
//	contentPanel.add(btnAplicar);
//	
//	}
}
