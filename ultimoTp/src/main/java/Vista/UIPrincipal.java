package Vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Empresa;
import Modelo.DAOjson;
import Modelo.RepositorioDeEmpresas;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Button;
import java.awt.Label;
import javax.swing.SwingConstants;

//
///*
// * @Author :Grupo 13
// */
public class UIPrincipal extends JFrame {
	
//	//Variables Globales 
//	//Creo esta lista para cargar los datos del json
//	public static ArrayList<Empresa> listaDeEmpresas  = new ArrayList<Empresa>();
//	
//	//Para poder usar las funciones para cargar los datos
//	public static DAOjson dao=new DAOjson(); 
//	
//	
//	//Creo el dao para usarlo en el repo
//	//Creo el repo xq es el que llama a las funciones del dao
//	public static RepositorioDeEmpresas empresa = new RepositorioDeEmpresas(dao);
//	
//	//Creo estas variables globales para no perder el contenido una vez que el usuario
//	//elija alguna opcion ya sea periodo o empresa
//	private JPanel contentPane;
//	
//	
//	//<Getters y Setters>
//	public static ArrayList<Empresa> getListaDeEmpresas() {
//		return listaDeEmpresas;
//	}
//
//	public static void setListaDeEmpresas(ArrayList<Empresa> listaDeEmpresas)
//	{
//		UIPrincipal.listaDeEmpresas = listaDeEmpresas;
//	}
//
//	// FIN <Getters y Setters>
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UIPrincipal frame = new UIPrincipal();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 * @throws IOException 
//	 */
//	public UIPrincipal() throws IOException 
//	{
//		//Creo el json
//		empresa.addAllStruct();
//		//Inicio de los botones
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 468, 314);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		
//		JComboBox comboDesde = new JComboBox();
//		comboDesde.setForeground(new Color(0, 0, 0));
//		comboDesde.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		comboDesde.setBounds(36, 49, 121, 23);
//		comboDesde.setModel(new DefaultComboBoxModel(new String[] {"PeriodoDesde", "01/01/2010", "01/01/2011", "01/06/2015"}));
//		
//		JComboBox comboHasta = new JComboBox();
//		comboHasta.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		comboHasta.setForeground(new Color(0, 0, 0));
//		comboHasta.setBounds(36, 83, 121, 20);
//		comboHasta.setModel(new DefaultComboBoxModel(new String[] {"PeriodoHasta", "30/06/2010", "31/12/2011", "30/12/2015"}));
//		
//		Label labelFaltaDato = new Label(" ");
//		labelFaltaDato.setForeground(new Color(205, 92, 92));
//		labelFaltaDato.setFont(null);
//		labelFaltaDato.setBounds(10, 162, 403, 61);
//		contentPane.add(labelFaltaDato);
//				
//		
//		JButton btnCargar = new JButton("Cargar");
//		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		btnCargar.setForeground(new Color(0, 0, 0));
//		btnCargar.setBounds(36, 133, 106, 23);
//
//		btnCargar.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent arg0)
//			{
//
//			
//				//Corroboro que no elija la opcion "Periodo"	
//				if ((comboDesde.getSelectedItem().toString()=="PeriodoDesde") ||
//						(comboHasta.getSelectedItem().toString()=="PeriodoHasta"))
//				{
//						labelFaltaDato.setText("Seleccione un Periodo !! ");
//				}
//				
//				else
//				{
//					//Uso find que devuelve la lista de empresas del periodo elegido
//					listaDeEmpresas=(ArrayList<Empresa>) empresa.find(comboDesde.getSelectedItem().toString(),comboHasta.getSelectedItem().toString());
//					labelFaltaDato.setText("Se Cargo Correctamente el Periodo:\n "+comboDesde.getSelectedItem().toString()+" Hasta :"+comboHasta.getSelectedItem().toString());
//				}
//			}
//			
//		});
//		
//		JButton btnConsultar = new JButton("Administrar Cuenta");
//		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnConsultar.setBounds(260, 56, 171, 23);
//		btnConsultar.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent e) 
//			{
//				//Agrego al constructor la 
//				//lista para que pueda obtener el otro controlPanel
//				//los datos de la empresa
//				UIConsultaCuentas consulta= new UIConsultaCuentas(listaDeEmpresas,empresa);
//				consulta.show();
//			}
//		});
//		
//	
//		JLabel lblSeleccioneElPeriodo = new JLabel("Seleccione el Periodo \r\npara la carga de Empresas:");
//		lblSeleccioneElPeriodo.setHorizontalAlignment(SwingConstants.CENTER);
//		lblSeleccioneElPeriodo.setToolTipText("");
//		lblSeleccioneElPeriodo.setBounds(36, 5, 377, 33);
//		lblSeleccioneElPeriodo.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
//		lblSeleccioneElPeriodo.setForeground(new Color(255, 105, 180));
//		
//		JButton btnConsultarIndicador = new JButton("Administrar Indicador");
//		btnConsultarIndicador.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnConsultarIndicador.setBounds(260, 89, 171, 23);
//		btnConsultarIndicador.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				UIConsultaIndicador indicador = new UIConsultaIndicador(listaDeEmpresas,empresa);
//				indicador.show();
//			}
//		});
//		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setBounds(120, 128, 0, 0);
//		contentPane.setLayout(null);
//		contentPane.add(lblSeleccioneElPeriodo);
//		contentPane.add(comboHasta);
//		contentPane.add(comboDesde);
//		contentPane.add(btnCargar);
//		contentPane.add(btnConsultar);
//		contentPane.add(btnConsultarIndicador);
//		contentPane.add(lblNewLabel);
//		
//		JButton btnCancel = new JButton("Salir");
//		btnCancel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false); // lo ocultas
//				dispose(); // lo destruis
//			}
//		});
//		btnCancel.setBounds(342, 241, 89, 23);
//		contentPane.add(btnCancel);
//		
//		JButton btnNewButton = new JButton("Administrar Metodolog\u00EDa");
//		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnNewButton.setBounds(259, 123, 172, 23);
//		btnNewButton.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent e) 
//			{
//				//Agrego al constructor la 
//				//lista para que pueda obtener el otro controlPanel
//				//los datos de la empresa
//				UIConsultaMetodologias consulta= new UIConsultaMetodologias ();
//				consulta.show();
//			}
//		});
//		
//		contentPane.add(btnNewButton);
//		
//		
//		
//		
//	}
}
