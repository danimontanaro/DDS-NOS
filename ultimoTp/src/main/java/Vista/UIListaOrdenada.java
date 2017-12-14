package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.CondicionTaxativa;
import Entity.Empresa;
import Entity.Metodologia;
import Entity.CondicionOrdenamiento;
import Modelo.DAOjson;
import Modelo.DAOmetodologiaJson;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;

public class UIListaOrdenada extends JDialog {

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			UIListaOrdenada dialog = new UIListaOrdenada();
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
//	public UIListaOrdenada() {
//		setBounds(100, 100, 450, 300);
//		getContentPane().setLayout(null);
//		{
//			JPanel buttonPane = new JPanel();
//			buttonPane.setBounds(0, 228, 434, 33);
//			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
//			getContentPane().add(buttonPane);
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
//		{
//			JLabel lblListaDeEmpresas = new JLabel("Seleccione metodologia a ordenar:");
//			lblListaDeEmpresas.setToolTipText("");
//			lblListaDeEmpresas.setHorizontalAlignment(SwingConstants.LEFT);
//			lblListaDeEmpresas.setForeground(new Color(255, 105, 180));
//			lblListaDeEmpresas.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
//			lblListaDeEmpresas.setBounds(20, 38, 414, 26);
//			getContentPane().add(lblListaDeEmpresas);
//		}
//		
//		JList list_1 = new JList();
//		list_1.setBounds(20, 65, 381, 152);
//		getContentPane().add(list_1);
//		DefaultListModel modelo = new DefaultListModel();
//		list_1.setModel(modelo);
//		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setSelectedIndex(-1);
//		comboBox.setBounds(248, 15, 153, 20);
//		getContentPane().add(comboBox);
//		DAOjson dao= new DAOjson();
//		ArrayList<Empresa> listaEmpresas = dao.getAll();		
//		DAOmetodologiaJson daoMetodologia = new DAOmetodologiaJson();
//		List<Metodologia> listaMetodologias= daoMetodologia.getAll();
//		for(Metodologia metodologia: listaMetodologias){
//			comboBox.addItem(metodologia.getNombre());
//		}
//		
//		
//		List<CondicionTaxativa> listaCondiciones= new ArrayList<CondicionTaxativa>();
//		listaCondiciones= listaMetodologias.get(comboBox.getSelectedIndex()).getCondiciones();
//		MetodologiaDeOrdenamiento metodologiaOrdenamiento=new MetodologiaDeOrdenamiento(listaCondiciones);
//				
//		listaEmpresas = (ArrayList<Empresa>) metodologiaOrdenamiento.ordenarLista(listaEmpresas);
//		for(Empresa emp : listaEmpresas){
//			modelo.addElement(emp.getNombre());
//		}
//	}
}
