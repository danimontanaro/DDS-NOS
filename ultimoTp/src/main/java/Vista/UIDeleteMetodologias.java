package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Metodologia;
import Modelo.DAOmetodologiaJson;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JComboBox;

public class UIDeleteMetodologias extends JDialog {
//
//	private final JPanel contentPanel = new JPanel();
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			UIDeleteMetodologias dialog = new UIDeleteMetodologias();
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
//	
//	public void getAllNombres(JComboBox comboMetodologia)
//	{
//		ArrayList<Metodologia> listaDeMetodologias  = new ArrayList<Metodologia>();
//		DAOmetodologiaJson daoMetodologia=new DAOmetodologiaJson();
//	
//		listaDeMetodologias=daoMetodologia.getAll();
//		for(int i = 0; i < listaDeMetodologias.size(); i++) {
//		    comboMetodologia.addItem(listaDeMetodologias.get(i).getNombre());
//			}
//	}
//	
//	
//	public UIDeleteMetodologias() {
//		setBounds(100, 100, 450, 300);
//		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		
//			JPanel panel = new JPanel();
//			panel.setBounds(0, 0, 446, 40);
//			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
//			contentPanel.add(panel);
//			panel.setLayout(new FlowLayout());
//			
//			JLabel lblSeleccioneLaMetodologia = new JLabel("Seleccione la metodolog\u00EDa que desea eliminar :");
//			lblSeleccioneLaMetodologia.setForeground(Color.PINK);
//			lblSeleccioneLaMetodologia.setFont(new Font("Tahoma", Font.BOLD, 16));
//			panel.add(lblSeleccioneLaMetodologia);
//			
//		
//			contentPanel.setLayout(null);
//			JLabel lblMetodologa = new JLabel("Metodolog\u00EDa:");
//			lblMetodologa.setBounds(24, 77, 124, 20);
//			lblMetodologa.setFont(new Font("Tahoma", Font.PLAIN, 16));
//			contentPanel.add(lblMetodologa);
//		
//		
//			JComboBox met = new JComboBox();
//			met.setBounds(142, 78, 116, 20);
//			met.setFont(new Font("Tahoma", Font.PLAIN, 13));
//			met.addItem("Metodología");
//			this.getAllNombres(met);
//			contentPanel.add(met);
//				
//				
//			JLabel label = new JLabel(" ");
//			label.setBounds(10, 108, 414, 62);
//			label.setForeground(new Color(139, 0, 0));
//			label.setFont(new Font("Tahoma", Font.PLAIN, 13));
//			contentPanel.add(label);
//		
//		
//			JButton btnBorrar = new JButton("Borrar");
//			btnBorrar.addActionListener(new ActionListener() {
//				
//				public void actionPerformed(ActionEvent arg0) {
//					Metodologia metodologia = new Metodologia();
//					DAOmetodologiaJson daoMetodologia = new DAOmetodologiaJson();
//					//daoMetodologia.addAllStruct();
//					ArrayList<Metodologia> listaDeMetodologias= daoMetodologia.getAll();
//										
//					//Corroboro que no elija la opcion "Metodología"
//				    							
//					if (met.getSelectedItem().toString() == "Metodología" )
//					{
//							label.setText("Seleccione una Metodología !! ");
//					}
//					
//					else
//					{
//						//Elimino la metodología seleccionada.
//						daoMetodologia.delete(met.getSelectedItem().toString());
//										
//						label.setText("Se eliminó Correctamente la Metodología:\n "+met.getSelectedItem().toString());
//					}
//				}
//				});
//			
//			
//			btnBorrar.setBounds(142, 183, 106, 23);
//			btnBorrar.setForeground(Color.BLACK);
//			btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
//			contentPanel.add(btnBorrar);
//		
//		
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