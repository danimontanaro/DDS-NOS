package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Cuenta;
import Entity.Empresa;
import Entity.Periodo;
import Modelo.RepositorioDeEmpresas;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;

public class UIConsultaIndicador extends JDialog {

//	private final JPanel contentPanel = new JPanel();
//
//	/**
//	 * Launch the application.
//	 */
//	public static RepositorioDeEmpresas empresa;
//	public static ArrayList<Empresa> listaDeEmpresas;
//	
//	
//	public static void main(String[] args) {
//		try {
//			UIConsultaIndicador dialog = new UIConsultaIndicador(listaDeEmpresas,empresa);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public void getAllNombres(JComboBox comboEmpresa)
//	{
//		for(int i = 0; i < listaDeEmpresas.size(); i++) {
//		    comboEmpresa.addItem(listaDeEmpresas.get(i).getNombre());
//		}
//	}
//	public void getAllPeriodoDesde(JComboBox comboEmpresa)
//	{
//		for(int i = 0; i < listaDeEmpresas.size(); i++) {
//		    List<Cuenta> listaDeCuentas=listaDeEmpresas.get(i).getCuentas();
//		    for(int j=0;j<listaDeCuentas.size();j++)
//		    {
//		    	 List<Periodo> listaDePeriodos =listaDeCuentas.get(j).getPeriodo();
//		    	 for (int k=0;k<listaDePeriodos.size();k++)
//		    	 {
//		    		 comboEmpresa.addItem(listaDePeriodos.get(k).getDesde());
//		    	 }
//		    	
//		    }
//		}
//	}
//	public void getAllPeriodoHasta(JComboBox comboEmpresa)
//	{
//		for(int i = 0; i < listaDeEmpresas.size(); i++) {
//	    List<Cuenta> listaDeCuentas=listaDeEmpresas.get(i).getCuentas();
//	    for(int j=0;j<listaDeCuentas.size();j++)
//	    {
//	    	 List<Periodo> listaDePeriodos =listaDeCuentas.get(j).getPeriodo();
//	    	 for (int k=0;k<listaDePeriodos.size();k++)
//	    	 {
//	    		 comboEmpresa.addItem(listaDePeriodos.get(k).getHasta());
//	    	 }
//	    	
//	    }
//	}
//	}
//
//	/**
//	 * Create the dialog.
//	 */
//	public UIConsultaIndicador(ArrayList<Empresa> listaDeEmpresas, RepositorioDeEmpresas empresa) {
//		
//		//Seteo la lista de empresas recibida del otro controlPanel a esta lista local
//		this.setListaDeEmpresas(listaDeEmpresas);
//		this.setEmpresa(empresa);
//		setBounds(100, 100, 450, 181);
//		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		{
//			JButton btnConsultar = new JButton("Consultar");
//			btnConsultar.setBounds(130, 66, 89, 23);
//			btnConsultar.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//					UIIndicadorPredef indicador= new UIIndicadorPredef(listaDeEmpresas,empresa);
//					indicador.show();
//				}
//			});
//			contentPanel.setLayout(null);
//			contentPanel.add(btnConsultar);
//		}
//		
//		JLabel lblC = new JLabel("Consulta de Indicadores Predefinidos");
//		lblC.setForeground(Color.PINK);
//		lblC.setFont(new Font("Century Gothic", Font.PLAIN, 13));
//		lblC.setBounds(71, 11, 293, 14);
//		contentPanel.add(lblC);
//		
//		JComboBox comboEmpresa = new JComboBox();
//		this.getAllNombres(comboEmpresa);
//		comboEmpresa.setBounds(20, 36, 89, 20);
//		contentPanel.add(comboEmpresa);
//		
//		JComboBox comboDesde = new JComboBox();
//		this.getAllPeriodoDesde(comboDesde);
//		comboDesde.setBounds(20, 67, 89, 20);
//		contentPanel.add(comboDesde);
//		
//		JComboBox comboHasta = new JComboBox();
//		this.getAllPeriodoHasta(comboHasta);
//		comboHasta.setBounds(20, 98, 89, 20);
//		contentPanel.add(comboHasta);
//		
//		JButton btnCancel = new JButton("Cancel");
//		btnCancel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false); // lo ocultas
//				dispose(); // lo destruis
//			}
//		});
//		btnCancel.setBounds(345, 108, 89, 23);
//		contentPanel.add(btnCancel);
//		
//		JButton button = new JButton("Alta");
//		button.setBounds(229, 36, 96, 23);
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				UIAltaIndicador indicador= new UIAltaIndicador();
//				indicador.show();
//			}
//		});
//		
//		contentPanel.add(button);
//		
//		
//		JButton button_1 = new JButton("Baja");
//		button_1.setBounds(229, 66, 96, 23);
//		
//		button_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				UIDeleteIndicadores indicador_1= new UIDeleteIndicadores();
//				indicador_1.show();
//			}
//		});
//		
//		
//		contentPanel.add(button_1);
//		
//		
//		JButton btnModificacin = new JButton("Modificaci\u00F3n");
//		btnModificacin.setBounds(229, 97, 106, 23);
//		
//		btnModificacin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				UIModificarIndicadores indicador_2= new UIModificarIndicadores();
//				indicador_2.show();
//			}
//		});
//		
//		contentPanel.add(btnModificacin);
//	}
//
//	public static RepositorioDeEmpresas getEmpresa() {
//		return empresa;
//	}
//
//	public static void setEmpresa(RepositorioDeEmpresas empresa) {
//		UIConsultaIndicador.empresa = empresa;
//	}
//
//	public static ArrayList<Empresa> getListaDeEmpresas() {
//		return listaDeEmpresas;
//	}
//
//	public static void setListaDeEmpresas(ArrayList<Empresa> listaDeEmpresas) {
//		UIConsultaIndicador.listaDeEmpresas = listaDeEmpresas;
//	}
}
