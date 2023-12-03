/* Proyecto Hotel POO
 * 
 * Integrentes:
 * Castro Gonzalez Angel Gabriel
 * Gabriel Cruz Alondra Paloma
 * Gonzalez Ordaz Ariel
 * Rosas Gonzalez Miguel Angel
 * San Pedro Avila Pablo
 */

package mx.unam.fes.acatlan.mac.poo.frontend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mx.unam.fes.acatlan.mac.poo.backend.*;

public class ModificarHotel extends JPanel implements ActionListener
{
	private JLabel lbTitulo;
    
    private JLabel lbBuscarID;
    private JTextField txtBuscarID;

	private JButton btnBuscarID;
	private JButton btnModificar;
	
    private JLabel lbNombre;
    private JTextField txtNombre;
    
    private JLabel lbPaterno;
    private JTextField txtPaterno;
    
    private JLabel lbMaterno;
    private JTextField txtMaterno;

    private JLabel lbDiaInicial;
    private JTextField txtDiaInicial;

    private JLabel lbDiaFinal;
	private JTextField txtDiaFinal;
    
	private JLabel lbAsignarEstado;
	private JComboBox<EstadoHospedaje> cbAsignarEstado;
	
	private FondoHotel ventanaPrincipal;
	private ArrayList<Huesped> huespedes;
	private Huesped auxHuesped;
	
	public ModificarHotel(FondoHotel ventanaPrincipal)
	{
		//Valores Del Panel
		setLayout(null);
		setBounds(240,120,600,360);
		setBackground(new Color(185,35,20));

		this.ventanaPrincipal = ventanaPrincipal;
		
		//Colores ID
		Color clrFondoTabla = new Color(125,20,10);
		Color clrLetrasTabla = new Color(255,255,255);

		lbTitulo = new JLabel("MODIFICAR ESTADO DE HOSPEDAJE");
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

		lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(20,100,150,20);
		lbNombre.setForeground(clrLetrasTabla);
		add(lbNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(20,120,150,20);
		txtNombre.setBackground(clrFondoTabla);
		txtNombre.setForeground(clrLetrasTabla);
		add(txtNombre);

		lbPaterno = new JLabel("Apellido Paterno");
		lbPaterno.setBounds(190,100,150,20);
		lbPaterno.setForeground(clrLetrasTabla);
		add(lbPaterno);
		
		txtPaterno = new JTextField();
		txtPaterno.setEditable(false);
		txtPaterno.setBounds(190,120,150,20);
		txtPaterno.setBackground(clrFondoTabla);
		txtPaterno.setForeground(clrLetrasTabla);
		add(txtPaterno);

		lbMaterno = new JLabel("Apellido Materno");
		lbMaterno.setBounds(370,100,150,20);
		lbMaterno.setForeground(clrLetrasTabla);
		add(lbMaterno);
		
		txtMaterno = new JTextField();
		txtMaterno.setEditable(false);
		txtMaterno.setBounds(370,120,150,20);
		txtMaterno.setBackground(clrFondoTabla);
		txtMaterno.setForeground(clrLetrasTabla);
		add(txtMaterno);

		lbDiaInicial = new JLabel("De");
		lbDiaInicial.setBounds(20,140,150,20);
		lbDiaInicial.setForeground(clrLetrasTabla);
		add(lbDiaInicial);

		txtDiaInicial = new JTextField();
		txtDiaInicial.setEditable(false);
		txtDiaInicial.setBounds(20,160,150,20);
		txtDiaInicial.setBackground(clrFondoTabla);
		txtDiaInicial.setForeground(clrLetrasTabla);
		add(txtDiaInicial);
		
		lbDiaFinal = new JLabel("Hasta");
		lbDiaFinal.setBounds(190,140,150,20);
		lbDiaFinal.setForeground(clrLetrasTabla);
		add(lbDiaFinal);

		txtDiaFinal = new JTextField();
		txtDiaFinal.setEditable(false);
		txtDiaFinal.setBounds(190,160,150,20);
		txtDiaFinal.setBackground(clrFondoTabla);
		txtDiaFinal.setForeground(clrLetrasTabla);
		add(txtDiaFinal);

		lbAsignarEstado = new JLabel("Nuevo Estado");
		lbAsignarEstado.setBounds(370,140,150,20);
		lbAsignarEstado.setForeground(clrLetrasTabla);
		add(lbAsignarEstado);

		cbAsignarEstado = new JComboBox<EstadoHospedaje> (EstadoHospedaje.values());
		cbAsignarEstado.setBounds(370,160,150,20);
		cbAsignarEstado.setBackground(clrFondoTabla);
		cbAsignarEstado.setForeground(clrLetrasTabla);
		add(cbAsignarEstado);

		btnModificar = new JButton("Modificar");
		btnModificar.setActionCommand("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(20,260,150,20);
		btnModificar.setBackground(clrFondoTabla);
		btnModificar.setForeground(clrLetrasTabla);
		add(btnModificar);
	}

	public Huesped BuscarLista()
	{
		String idAux = txtBuscarID.getText();
		auxHuesped = null;
		huespedes = new ArrayList<Huesped>();
		huespedes.addAll(ventanaPrincipal.getHuespedes());
		for(Huesped h:huespedes)
		{
			if(idAux.equalsIgnoreCase(h.getId()))
			{
				auxHuesped = h;
			}
		}
		return auxHuesped;
	}
	
	public void mostrarDatos()
	{
		Huesped aux = BuscarLista();
		txtNombre.setText(aux.getNombre());
		txtPaterno.setText(aux.getApellidoP());
		txtMaterno.setText(aux.getApellidoM());
		txtDiaInicial.setText("" +aux.getDiaInicio());
		txtDiaFinal.setText("" +aux.getDiaFinal());
	}

	public Huesped ObtenerNuevoDato()
	{
		Huesped aux = BuscarLista();
		EstadoHospedaje nuevoEstado = (EstadoHospedaje)cbAsignarEstado.getSelectedItem();
		Huesped auxHuesped = new Huesped(aux.getHabitacion(),aux.getJacuzzi(),aux.getRecepcionista(),aux.getDiasHotel(),
				aux.getId(),aux.getDiaInicio(),aux.getDiaFinal(),aux.getCosto(),
				aux.getNombre(),aux.getApellidoP(),aux.getApellidoM(),nuevoEstado);
		return auxHuesped;
	}
	
	//Botones De Acciones
	public void actionPerformed(ActionEvent e)
	{
		String event = e.getActionCommand();
		if(event.equals("BUSCAR"))
		{
			mostrarDatos();
		}
		else if(event.equals("MODIFICAR"))
		{
			Huesped auxModif = ObtenerNuevoDato();
			ventanaPrincipal.ModificarHuesped(auxModif);
			JOptionPane.showMessageDialog(null,"Datos Modificados");
			ventanaPrincipal.AbrirPanelRegistro();
		}
	}
}
