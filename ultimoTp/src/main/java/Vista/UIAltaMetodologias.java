package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Entity.CondicionTaxativa;
import Entity.Cuenta;
import Entity.Empresa;
import Entity.Indicador;
import Entity.Metodologia;
import Modelo.DAOjson;
import Modelo.DAOmetodologiaJson;
import Modelo.RepositorioDeMetodologia;
import parserCondiciones.GrammarCondiciones;
import parserCondiciones.TestForm;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;


public class UIAltaMetodologias extends JDialog {
//
//	private final JPanel contentPanel = new JPanel();
//	private JTextField textNombre;
//	private JTextField textCondicion;	
//	static GrammarCondiciones parser = null;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			UIAltaMetodologias dialog = new UIAltaMetodologias();
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
//	public UIAltaMetodologias() {
//		
//		//Declaro variables
//		
//		DAOmetodologiaJson daoMetodologia = new DAOmetodologiaJson();
//		//Metodologia metodologiaAgregada = new Metodologia();
//		ArrayList<CondicionTaxativa> listaCondiciones = new ArrayList<CondicionTaxativa>();
//		CondicionTaxativa condicionT = new CondicionTaxativa();
//		RepositorioDeMetodologia repoMetodologia = new RepositorioDeMetodologia();
//		
//		
//		
//		setBounds(100, 100, 450, 212);
//		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		contentPanel.setLayout(null);
//		{
//			JLabel lblNewLabel = new JLabel("Nombre de la Metodología:");
//			lblNewLabel.setBounds(9, 43, 173, 14);
//			contentPanel.add(lblNewLabel);
//		}
//		{
//			JLabel lblFormula = new JLabel("Condici\u00F3n:");
//			lblFormula.setBounds(24, 68, 62, 14);
//			contentPanel.add(lblFormula);
//		}
//		{
//			JButton btnGuardar = new JButton("Guardar");
//			btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
//			btnGuardar.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e){
//					
//					ArrayList<Metodologia> listaMetodologias = new ArrayList<Metodologia>(); 
//					/*Indicador indicador= new Indicador();
//					DAOjson daoEmpresa=new DAOjson();
//					ArrayList<Empresa> listaDeEmpresas=new ArrayList<Empresa>();
//					listaDeEmpresas=daoEmpresa.getAll();*/
//					
//					String nombreMetodologia, condicion;
//					condicion = textCondicion.getText();
//					
//					String strar[]=condicion.split(" ");
//					nombreMetodologia = textNombre.getText();
//					
//					//--AGREGO CONDICION 
//					condicionT.setIndicadorOCuenta(strar[0]);
//					condicionT.setExpresion(strar[1]);
//					int valorAComparar= Integer.parseInt(strar[2]);
//					condicionT.setValorAComparar(valorAComparar);
//					
//					//AGREGO CONDICION A LISTACONDICION
//					listaCondiciones.add(condicionT);
//					
//					System.out.println("Nombre Metodologia " + nombreMetodologia + " Cuenta: "+ strar[0] + "A comparar: " +strar[1]+" valor: "+valorAComparar);
//					//metodologiaAgregada.setCondiciones(listaCondiciones);
//					Metodologia metodologiaAgregada = new Metodologia(nombreMetodologia,listaCondiciones);
//					listaMetodologias = daoMetodologia.getAll();
//					
//					
//					if(daoMetodologia.findMetodologia(nombreMetodologia)== 0){
//						try {
//							listaMetodologias.add(metodologiaAgregada);
//							repoMetodologia.writeArray(listaMetodologias);
//							dispose();
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block					
//							e1.printStackTrace();
//						}
//					}
//					else{
//						 JOptionPane.showMessageDialog(null, "HAYUNERRRORRBRO", "Existe ese nombre",
//                                 JOptionPane.ERROR_MESSAGE);
//						 textCondicion.setText("");
//						 textNombre.setText("");
//					}
//					
//				}
//			});
//			btnGuardar.setBounds(181, 140, 107, 23);
//			contentPanel.add(btnGuardar);
//		}
//		{
//			JButton btnCancelar = new JButton("Cancelar");
//			btnCancelar.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					setVisible(false); // lo ocultas
//					dispose(); // lo destruis
//				}
//			});
//			btnCancelar.setBounds(319, 140, 89, 23);
//			contentPanel.add(btnCancelar);
//		}
//		{
//			JLabel lblAltaDeMetodologías = new JLabel("Alta de Metodologías");
//			lblAltaDeMetodologías.setForeground(new Color(219, 112, 147));
//			lblAltaDeMetodologías.setHorizontalAlignment(SwingConstants.CENTER);
//			lblAltaDeMetodologías.setFont(new Font("Tahoma", Font.BOLD, 13));
//			lblAltaDeMetodologías.setBounds(122, 11, 201, 21);
//			contentPanel.add(lblAltaDeMetodologías);
//		}
//		
//		textNombre = new JTextField();
//		textNombre.setBounds(192, 40, 131, 20);
//		contentPanel.add(textNombre);
//		textNombre.setColumns(10);
//		
//		textCondicion = new JTextField();
//		textCondicion.setBounds(96, 65, 192, 20);
//		contentPanel.add(textCondicion);
//		textCondicion.setColumns(10);
//		
//		JLabel outputText = new JLabel(" ");
//		outputText.setBounds(40, 110, 324, 14);
//		contentPanel.add(outputText);
//		
//		JButton btnAlta = new JButton("Verificar Alta\r\n");
//		btnAlta.setFont(new Font("Tahoma", Font.BOLD, 11));
//		btnAlta.setForeground(new Color(0, 0, 0));
//		btnAlta.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			    String sentence = textCondicion.getText();
//                // Put parens around sentence so that parser knows scope
//                sentence = "(" + sentence + ")";
//                InputStream is = new ByteArrayInputStream(sentence.getBytes());
//                if(parser == null) parser = new GrammarCondiciones(is);
//                else GrammarCondiciones.ReInit(is);
//                try
//                {
//                  switch (GrammarCondiciones.start())
//                  {
//                    case 0 :
//                    	outputText.setText("La formula esta Sintacticamente correcta.");
//                    	//IF del se puede aplicar
//                    	//si esta todo OK aplicateA
//                    break;
//                    default :
//                    break;
//                  }
//                }
//                catch (Exception e)
//                {
//                  outputText.setText("Error de Sintaxis.");
//                }
//                catch (Error e)
//                {
//                 outputText.setText("Error de Sintaxis.");
//                }
//                finally
//                {
//                  
//                }
//        	
//			}
//		});
//		btnAlta.setBounds(304, 64, 120, 23);
//		contentPanel.add(btnAlta);
//		
//		
//	}
}