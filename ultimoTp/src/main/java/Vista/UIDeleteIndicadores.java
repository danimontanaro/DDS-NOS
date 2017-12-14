package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Indicador;
import Modelo.DAOIndicadorJson;
import Modelo.RepositorioDeIndicadores;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JComboBox;

public class UIDeleteIndicadores extends JDialog {

//	private final JPanel contentPanel = new JPanel();
//
//	/**
//	 * Launch the application.
//	 */
//	
//	//public static RepositorioDeIndicadores indicador;
//	//public static ArrayList<Indicador> listaDeIndicadores;
//	
//	public static void main(String[] args) {
//		try {
//			UIDeleteIndicadores dialog = new UIDeleteIndicadores();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}	
//
//	/**
//	 * Create the dialog.
//	 *
//	 */
//	
//	public void getAllNombres(JComboBox comboIndicador)
//	{
//		ArrayList<Indicador> listaDeIndicadores  = new ArrayList<Indicador>();
//		DAOIndicadorJson daoIndicador=new DAOIndicadorJson();
//	
//		listaDeIndicadores=daoIndicador.getAll();
//		for(int i = 0; i < listaDeIndicadores.size(); i++) {
//			
//			if(listaDeIndicadores.get(i).isSePuedeBorrar()==true){
//			    comboIndicador.addItem(listaDeIndicadores.get(i).getNombre());}
//				}
//		    
//			}
//	
//	
//	
//	
//	public UIDeleteIndicadores() {
//		setBounds(100, 100, 450, 300);
//		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		contentPanel.setLayout(null);
//		
//		JPanel panel = new JPanel();
//		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		panel.setBounds(0, 0, 434, 228);
//		contentPanel.add(panel);
//		panel.setLayout(null);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(0, 0, 446, 40);
//		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
//		panel.add(panel_1);
//		panel_1.setLayout(new FlowLayout());
//		
//		JLabel lblSeleccioneElIndicador = new JLabel("Seleccione el Indicador que desea eliminar :");
//		lblSeleccioneElIndicador.setForeground(Color.PINK);
//		lblSeleccioneElIndicador.setFont(new Font("Tahoma", Font.BOLD, 16));
//		panel_1.add(lblSeleccioneElIndicador);
//		
//		JLabel lblIndicador = new JLabel("Indicador:");
//		lblIndicador.setBounds(24, 77, 124, 20);
//		lblIndicador.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		panel.add(lblIndicador);
//		
//				
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(132, 78, 116, 20);
//		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		comboBox.addItem("Indicador");
//		this.getAllNombres(comboBox);
//		panel.add(comboBox);
//		
//		
//		JLabel label_2 = new JLabel(" ");
//		label_2.setBounds(10, 108, 414, 62);
//		label_2.setForeground(new Color(139, 0, 0));
//		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		panel.add(label_2);
//		
//		
//		JButton button = new JButton("Borrar");
//		button.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent arg0) {
//				Indicador indicador = new Indicador();
//				DAOIndicadorJson daoInd = new DAOIndicadorJson();
//				
//				//daoInd.addAllStruct();
//				ArrayList<Indicador> listaDeIndicadores= daoInd.getAll();
//								
//				//Corroboro que no elija la opcion "Indicador"
//			    							
//				if (comboBox.getSelectedItem().toString() == "Indicador" )
//				{
//						label_2.setText("Seleccione un Indicador !! ");
//				}
//				
//				else
//				{
//					//Elimino el indicador seleccionado.
//					daoInd.delete(comboBox.getSelectedItem().toString());
//									
//					label_2.setText("Se eliminó Correctamente el Indicador:\n "+comboBox.getSelectedItem().toString());
//				}
//			}
//			});
//				
//		button.setBounds(142, 183, 106, 23);
//		button.setForeground(Color.BLACK);
//		button.setFont(new Font("Tahoma", Font.BOLD, 14));
//		panel.add(button);
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