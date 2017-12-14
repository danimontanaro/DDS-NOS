package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Cuenta;
import Entity.Empresa;
import Entity.Indicador;
import Modelo.DAOIndicador;
import Modelo.DAOIndicadorJson;
import Modelo.DAOjson;
import parserIndicadores.GrammarIndicadores;
import parserIndicadores.TestForm;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class UIAltaIndicador extends JDialog {
//
//	private final JPanel contentPanel = new JPanel();
//	private JTextField textNombre;
//	private JTextField textFormula;
//
//	static GrammarIndicadores parser = null;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			UIAltaIndicador dialog = new UIAltaIndicador();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public boolean pertenecenTodasLasCuentas(ArrayList<Empresa> listaDeEmpresas,ArrayList<String> cuentasAVerificar)
//	{
//		for(int i=0;i<listaDeEmpresas.size();i++)
//		{
//			List<Cuenta> cuentasPorEmpresa = listaDeEmpresas.get(i).getCuentas();
//			ArrayList<String> nombreDeCuentas = new ArrayList<String>();
//			for(int j=0;j<cuentasPorEmpresa.size();j++)
//			{
//				nombreDeCuentas.add(cuentasPorEmpresa.get(j).getNombre());
//			}
//			//return nombreDeCuentas.containsAll(cuentasAVerificar);
//		}
//	 return true;
//	}
//	public UIAltaIndicador() {
//		
//		setBounds(100, 100, 450, 212);
//		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		contentPanel.setLayout(null);
//		{
//			JLabel lblNewLabel = new JLabel("Nombre del Indicador:");
//			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//			lblNewLabel.setBounds(24, 43, 149, 14);
//			contentPanel.add(lblNewLabel);
//		}
//		{
//			JLabel lblFormula = new JLabel("F\u00F3rmula");
//			lblFormula.setFont(new Font("Tahoma", Font.PLAIN, 13));
//			lblFormula.setBounds(22, 68, 76, 14);
//			contentPanel.add(lblFormula);
//		}
//		{
//			JButton btnGuardar = new JButton("Guardar");
//			btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
//			btnGuardar.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					
//					Indicador indicador= new Indicador();
//					DAOjson daoEmpresa=new DAOjson();
//					DAOIndicadorJson daoIndicador = new DAOIndicadorJson();
//					
//					ArrayList<Empresa> listaDeEmpresas=daoEmpresa.getAll();
//					ArrayList<Indicador> listaIndicadores = daoIndicador.getAll();
//					
//					//seteo el indicador con los valores
//					indicador.setNombre(textNombre.getText());
//					indicador.setFormula(textFormula.getText());
//					indicador.setSePuedeBorrar(false);
//					
//					if(daoIndicador.findIndicador(textNombre.getText())==0){
//						listaIndicadores.add(indicador);
//						daoIndicador.escribirArchivo(listaIndicadores);
//						JOptionPane.showMessageDialog(null, "Guardado exitosamente", "Well done", JOptionPane.CLOSED_OPTION);
//						textFormula.setText("");
//						textNombre.setText("");
//						
//					}
//					else{
//						JOptionPane.showMessageDialog(null, "Existe ese nombre", "HAYUNERRRORRBRO",
//                                JOptionPane.ERROR_MESSAGE);
//						 textFormula.setText("");
//						 textNombre.setText("");
//					}
//					 
//					
//
//				}
//			});
//			btnGuardar.setBounds(129, 137, 89, 23);
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
//			btnCancelar.setBounds(335, 139, 89, 23);
//			contentPanel.add(btnCancelar);
//		}
//		{
//			JLabel lblAltaDeIndicadores = new JLabel("Alta de Indicadores");
//			lblAltaDeIndicadores.setForeground(new Color(219, 112, 147));
//			lblAltaDeIndicadores.setHorizontalAlignment(SwingConstants.CENTER);
//			lblAltaDeIndicadores.setFont(new Font("Tahoma", Font.BOLD, 13));
//			lblAltaDeIndicadores.setBounds(89, 11, 246, 21);
//			contentPanel.add(lblAltaDeIndicadores);
//		}
//		
//		textNombre = new JTextField();
//		textNombre.setBounds(181, 40, 131, 20);
//		contentPanel.add(textNombre);
//		textNombre.setColumns(10);
//		
//		textFormula = new JTextField();
//		textFormula.setBounds(96, 65, 192, 20);
//		contentPanel.add(textFormula);
//		textFormula.setColumns(10);
//		
//		JLabel outputText = new JLabel(" ");
//		outputText.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		outputText.setForeground(new Color(139, 0, 0));
//		outputText.setBounds(10, 93, 414, 31);
//		contentPanel.add(outputText);
//		
//		JButton btnAlta = new JButton("Verificar Alta\r\n");
//		btnAlta.setFont(new Font("Tahoma", Font.BOLD, 13));
//		btnAlta.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			    String sentence = textFormula.getText();
//                // Put parens around sentence so that parser knows scope
//                sentence = "(" + sentence + ")";
//                InputStream is = new ByteArrayInputStream(sentence.getBytes());
//                if(parser == null)  parser = new GrammarIndicadores(is);
//                else GrammarIndicadores.ReInit(is);
//                try
//                {
//                  switch (GrammarIndicadores.start())
//                  {
//                    case 0 :
//                    	outputText.setText("La formula esta Sintacticamente correcta.");
//                    	
//                    	//GrammarIndicadores.symbol();
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
//		btnAlta.setBounds(298, 64, 126, 23);
//		contentPanel.add(btnAlta);
//		
//		
//	}
}
