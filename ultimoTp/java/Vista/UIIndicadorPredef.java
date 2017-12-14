package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Empresa;
import Entity.Indicador;
import Modelo.DAOIndicadorJson;
import Modelo.RepositorioDeEmpresas;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class UIIndicadorPredef extends JDialog {
//	public static RepositorioDeEmpresas empresa;
//	public static ArrayList<Empresa> listaDeEmpresas;
//	public static ArrayList<Indicador> indicadores;
//	
//	public static RepositorioDeEmpresas getEmpresa() {
//		return empresa;
//	}
//
//	public static void setEmpresa(RepositorioDeEmpresas empresa) {
//		UIIndicadorPredef.empresa = empresa;
//	}
//
//	public static ArrayList<Empresa> getListaDeEmpresas() {
//		return listaDeEmpresas;
//	}
//
//	public static void setListaDeEmpresas(ArrayList<Empresa> listaDeEmpresas) {
//		UIIndicadorPredef.listaDeEmpresas = listaDeEmpresas;
//	}
//
//	public static void main(String[] args) {
//		try {
//			UIIndicadorPredef dialog = new UIIndicadorPredef(listaDeEmpresas,empresa);
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
//	public UIIndicadorPredef(ArrayList<Empresa> listaDeEmpresas, RepositorioDeEmpresas empresa) {
//		
//		//Seteo la lista de empresas recibida del otro controlPanel a esta lista local
//		this.setListaDeEmpresas(listaDeEmpresas);
//		this.setEmpresa(empresa);
//		setBounds(100, 100, 548, 316);
//		getContentPane().setLayout(null);
//	
//
//		JList list_1 = new JList();
//		list_1.setVisible(false);
//		list_1.setBounds(9, 36, 154, 172);
//		getContentPane().add(list_1);
//		{
//			DefaultListModel modelo = new DefaultListModel();
//			
//			for (int i = 0; i <listaDeEmpresas.size(); i++)
//			   {
//				DAOIndicadorJson daoIndicador = new DAOIndicadorJson();
//				indicadores= daoIndicador.getAll();
//				for(int j=0;j<indicadores.size();j++)
//				{
//					list_1.setVisible(true);
//					modelo.addElement(indicadores.get(j).getNombre());
//				}
//				
//			   }
//			list_1.setModel(modelo);
//		}
//		
//		{
//			JLabel lblNewLabel = new JLabel("Indicadores Predefinidos:");
//			lblNewLabel.setForeground(new Color(219, 112, 147));
//			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
//			lblNewLabel.setBounds(20, 11, 259, 23);
//			getContentPane().add(lblNewLabel);
//		}
//		{
//			JLabel lblSeleccioneUnoPara = new JLabel("\u00A1Seleccione uno para obtener el valor!");
//			lblSeleccioneUnoPara.setFont(new Font("Tahoma", Font.PLAIN, 13));
//			lblSeleccioneUnoPara.setBounds(20, 219, 275, 14);
//			getContentPane().add(lblSeleccioneUnoPara);
//		}
//		{
//			JButton cancelButton = new JButton("Cancel");
//			cancelButton.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					setVisible(false); // lo ocultas
//					dispose(); // lo destruis
//				}
//			});
//			cancelButton.setBounds(380, 244, 81, 23);
//			getContentPane().add(cancelButton);
//			cancelButton.setActionCommand("Cancel");
//		}
//		JList list = new JList();
//		list.setBounds(173, 36, 349, 105);
//		getContentPane().add(list);
//		{
//			DefaultListModel modelo = new DefaultListModel();
//			JButton btnObtenerValor = new JButton("Obtener Valor");
//			btnObtenerValor.setFont(new Font("Tahoma", Font.BOLD, 13));
//			btnObtenerValor.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) 
//				{
//					modelo.clear();
//					DAOIndicadorJson indicador= new DAOIndicadorJson();
//					modelo.addElement(indicador.findFormula(list_1.getSelectedValue().toString()));
//				
//					
//				}
//			});
//			btnObtenerValor.setBounds(30, 244, 133, 23);
//			getContentPane().add(btnObtenerValor);
//			list.setModel(modelo);
//		}
//		{
//			
//		}
//	}
}
