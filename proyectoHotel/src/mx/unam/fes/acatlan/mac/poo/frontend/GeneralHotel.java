package mx.unam.fes.acatlan.mac.poo.frontend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mx.unam.fes.acatlan.mac.poo.backend.*;

public class GeneralHotel extends JPanel implements ActionListener
{
	private JLabel lbTitulo;
    
    private JLabel lbBuscarID;
    private JTextField txtBuscarID;
	
	private JTable tablaHospedaje;
    private DefaultTableModel valoresTabla;

	private JButton btnBuscarID;
	private JButton btnVerTodos;
	
	private FondoHotel ventanaPrincipal;
	private ArrayList<Huesped> huespedes;
	
	public GeneralHotel(FondoHotel ventanaPrincipal)
	{
		//Valores Del Panel
		setLayout(null);
		setBounds(240,120,600,360);
		setBackground(new Color(185,35,20));

		this.ventanaPrincipal = ventanaPrincipal;
		
		//Colores ID
		Color clrFondoTabla = new Color(125,20,10);
		Color clrLetrasTabla = new Color(255,255,255);
		
		lbTitulo = new JLabel("REGISTRO TOTAL");
		lbTitulo.setBounds(20,20,240,20);
		lbTitulo.setForeground(clrLetrasTabla);
		add(lbTitulo);
		
		lbBuscarID = new JLabel("Ingrese ID del Cliente");
		lbBuscarID.setBounds(20,60,120,20);
		lbBuscarID.setForeground(clrLetrasTabla);
		add(lbBuscarID);
		
		txtBuscarID = new JTextField();
		txtBuscarID.setBounds(140,60,160,20);
		txtBuscarID.setBackground(clrFondoTabla);
		txtBuscarID.setForeground(clrLetrasTabla);
		add(txtBuscarID);

		btnBuscarID = new JButton("Buscar");
		btnBuscarID.setActionCommand("BUSCAR");
		btnBuscarID.addActionListener(this);
		btnBuscarID.setBounds(320,60,100,20);
		btnBuscarID.setBackground(clrFondoTabla);
		btnBuscarID.setForeground(clrLetrasTabla);
		add(btnBuscarID);

		btnVerTodos = new JButton("Ver Todos");
		btnVerTodos.setActionCommand("VER_TODOS");
		btnVerTodos.addActionListener(this);
		btnVerTodos.setBounds(440,60,100,20);
		btnVerTodos.setBackground(clrFondoTabla);
		btnVerTodos.setForeground(clrLetrasTabla);
		add(btnVerTodos);
		
		//Titulos Tabla
		String[] titulosTabla = {"Huesped","Empleado","Habitacion","Jacuzzi","ESTADO","Dia I","Dia F","Costo","ID"};
		valoresTabla = new DefaultTableModel(titulosTabla,0);
		ActualizarLista();
		//Config Tabla
		tablaHospedaje = new JTable(valoresTabla);
		tablaHospedaje.setEnabled(false);
		tablaHospedaje.setBackground(clrFondoTabla);
		tablaHospedaje.setForeground(clrLetrasTabla);
		tablaHospedaje.setGridColor(clrFondoTabla);
		tablaHospedaje.getTableHeader().setBackground(clrFondoTabla);
		tablaHospedaje.getTableHeader().setForeground(clrLetrasTabla);
		tablaHospedaje.getTableHeader().setReorderingAllowed(false);
		tablaHospedaje.getTableHeader().setResizingAllowed(false);
		JScrollPane scrbrTablaHospedaje = new JScrollPane(tablaHospedaje);
		scrbrTablaHospedaje.setBounds(0,100,600,200);
		add(scrbrTablaHospedaje);
	}

	public void ActualizarLista()
	{
		valoresTabla.setRowCount(0);
		huespedes = new ArrayList<Huesped>();
		huespedes.addAll(ventanaPrincipal.getHuespedes());
		for(Huesped h:huespedes)
		{
			String nombreHuesped = "" +h.getNombre() +" " +h.getApellidoP() +" " +h.getApellidoM();
			String nombreRecepcionista = "" +h.getRecepcionista().getNombre() +" " +h.getRecepcionista().getApellidoP() 
					+" " +h.getRecepcionista().getApellidoM();
			String jacuzzi = "";
			if(h.getJacuzzi() == true)
			{
				jacuzzi += "Si";
			}
			else
			{
				jacuzzi += "No";
			}
			String fechaI = "" +h.getDiaInicio().getDayOfMonth() +"/" +h.getDiaInicio().getMonthValue() +"/" 
					+h.getDiaInicio().getYear();
			String fechaF = "" +h.getDiaFinal().getDayOfMonth() +"/" +h.getDiaFinal().getMonthValue() +"/" 
					+h.getDiaFinal().getYear();
			Object[] datosHuesped = {nombreHuesped,nombreRecepcionista,h.getHabitacion(),jacuzzi
					,h.getEstado(),fechaI,fechaF,h.getCosto(),h.getId()};
			valoresTabla.addRow(datosHuesped);
		}
	}

	public void BuscarLista()
	{
		valoresTabla.setRowCount(0);
		
		String idAux = txtBuscarID.getText();
		
		huespedes = new ArrayList<Huesped>();
		huespedes.addAll(ventanaPrincipal.getHuespedes());
		for(Huesped h:huespedes)
		{
			if(idAux.equalsIgnoreCase(h.getId()))
			{
				String nombreHuesped = "" +h.getNombre() +" " +h.getApellidoP() +" " +h.getApellidoM();
				String nombreRecepcionista = "" +h.getRecepcionista().getNombre() +" " +h.getRecepcionista().getApellidoP() 
						+" " +h.getRecepcionista().getApellidoM();
				String jacuzzi = "";
				Double costo = 0.0;
				if(h.getJacuzzi() == false)
				{
					jacuzzi += "Si";
					costo += (500 * 7);
				}
				else
				{
					jacuzzi += "No";
					costo += (500 * 7) + 350;
				}
				Object[] datosHuesped = {nombreHuesped,nombreRecepcionista,h.getHabitacion(),jacuzzi
						,h.getDiasHotel(),h.getDiaInicio(),h.getDiaFinal(),costo,h.getId()};
				valoresTabla.addRow(datosHuesped);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String event = e.getActionCommand();
		if(event.equals("BUSCAR"))
		{
			BuscarLista();
		}
		else if(event.equals("VER_TODOS"))
		{
			ActualizarLista();
		}
	}
}
