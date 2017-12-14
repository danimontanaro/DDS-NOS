package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Empresa;
import Modelo.RepositorioDeEmpresas;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

public class UIConsultaMetodologias extends JDialog {

//	private final JPanel contentPanel = new JPanel();
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			UIConsultaMetodologias dialog = new UIConsultaMetodologias();
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
//	public UIConsultaMetodologias() {
//		setBounds(100, 100, 450, 275);
//		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		contentPanel.setLayout(null);
//		{
//			JLabel label = new JLabel("Seleccione a quien desea realizar la consulta:");
//			label.setForeground(Color.PINK);
//			label.setFont(new Font("Tahoma", Font.BOLD, 16));
//			label.setBounds(25, 0, 371, 20);
//			contentPanel.add(label);
//		}
//		{
//			JButton button = new JButton("Empresa \r\nEspecifica\r\n");
//			button.setFont(new Font("Tahoma", Font.BOLD, 11));
//			button.setBounds(23, 41, 166, 62);
//			button.addActionListener(new ActionListener() 
//			{
//				public void actionPerformed(ActionEvent e) 
//				{
//					//Agrego al constructor la 
//					//lista para que pueda obtener el otro controlPanel
//					//los datos de la empresa
//					UIConsulta1Empresa empresa= new UIConsulta1Empresa ();
//					empresa.show();
//				}
//			});
//			contentPanel.add(button);
//		}
//		{
//			JButton button = new JButton("Lista de empresas ordenadas\r\n");
//			button.setFont(new Font("Tahoma", Font.BOLD, 11));
//			button.setBounds(199, 41, 206, 62);
//			button.addActionListener(new ActionListener() 
//			{
//				public void actionPerformed(ActionEvent e) 
//				{
//					//Agrego al constructor la 
//					//lista para que pueda obtener el otro controlPanel
//					//los datos de la empresa
////					UIConsultaListaEmpresas empresas= new UIConsultaListaEmpresas();
////					empresas.show();
//					UIListaOrdenada lst = new UIListaOrdenada();
//					lst.show();
//				}
//			});
//			contentPanel.add(button);
//		}
//		{
//			JLabel label = new JLabel("Para realizar otras acciones :");
//			label.setForeground(new Color(0, 0, 128));
//			label.setFont(new Font("Tahoma", Font.BOLD, 12));
//			label.setBounds(33, 114, 371, 20);
//			contentPanel.add(label);
//		}
//		{
//			JButton button = new JButton("Alta Metodolog\u00EDa");
//			button.setFont(new Font("Tahoma", Font.PLAIN, 10));
//			button.setBounds(10, 154, 119, 23);
//			button.addActionListener(new ActionListener() 
//			{
//				public void actionPerformed(ActionEvent e) 
//				{
//					//Agrego al constructor la 
//					//lista para que pueda obtener el otro controlPanel
//					//los datos de la empresa
//					UIAltaMetodologias metod= new UIAltaMetodologias ();
//					metod.show();
//				}
//			});
//			contentPanel.add(button);
//		}
//		{
//			JButton button = new JButton("Eliminar Metodolog\u00EDa");
//			button.setFont(new Font("Tahoma", Font.PLAIN, 10));
//			button.setBounds(139, 154, 134, 23);
//			button.addActionListener(new ActionListener() 
//			{
//				public void actionPerformed(ActionEvent e) 
//				{
//					//Agrego al constructor la 
//					//lista para que pueda obtener el otro controlPanel
//					//los datos de la empresa
//					UIDeleteMetodologias metodDelete= new UIDeleteMetodologias();
//					metodDelete.show();
//				}
//			});
//			contentPanel.add(button);
//		}
//		{
//			JButton button = new JButton("Modificar Metodolog\u00EDa");
//			button.setFont(new Font("Tahoma", Font.PLAIN, 10));
//			button.setBounds(283, 154, 141, 23);
//			button.addActionListener(new ActionListener() 
//			{
//				public void actionPerformed(ActionEvent e) 
//				{
//					//Agrego al constructor la 
//					//lista para que pueda obtener el otro controlPanel
//					//los datos de la empresa
//					UIModificarMetodologia metodo= new UIModificarMetodologia();
//					metodo.show();
//				}
//			});
//			contentPanel.add(button);
//		}
//		{
//			JButton button = new JButton("Salir");
//			button.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					setVisible(false); // lo ocultas
//					dispose(); // lo destruis
//				}
//			});
//			button.setBounds(174, 209, 89, 23);
//			contentPanel.add(button);
//		}
//	}

}
