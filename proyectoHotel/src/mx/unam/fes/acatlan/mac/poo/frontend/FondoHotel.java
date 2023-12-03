package mx.unam.fes.acatlan.mac.poo.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mx.unam.fes.acatlan.mac.poo.backend.*;

public class FondoHotel extends JPanel implements ActionListener
{
	private MenuHotel menuHotel;
	private ListaHotel listaHotel;
	private RegistroHotel registroHotel;
	private GeneralHotel generalHotel;
	private ModificarHotel modificarHotel;
	
	private JLabel lbTitulo;
	private JLabel lbLogo;
	
	private AplicacionHotel aplicacionHotel;
	
	public FondoHotel()
	{
		//Valores Del Panel
		setLayout(null);
		setBounds(0,0,840,480);
		setBackground(new Color(125,20,10));
		
		//Colores ID
		Color clrFondoTabla = new Color(125,20,10);
		Color clrLetrasTabla = new Color(255,255,255);
		Color clrLogoTabla = new Color(225,150,10);

		//Titulo
		lbTitulo = new JLabel("HOTEL CHEVALLIER");
		lbTitulo.setBounds(360,20,400,80);
		lbTitulo.setForeground(clrLetrasTabla);
		lbTitulo.setFont(new Font("French Script MT",Font.PLAIN,40));
		add(lbTitulo);

		//Titulo
		lbLogo = new JLabel("HC");
		lbLogo.setBounds(480,20,400,80);
		lbLogo.setForeground(clrLogoTabla);
		lbLogo.setFont(new Font("French Script MT",Font.PLAIN,100));
		add(lbLogo);

		//Crear Instancia
		aplicacionHotel = new AplicacionHotel();
		getHuespedes();
		getEmpleados();

		//Crear Paneles
		menuHotel = new MenuHotel(this);
		listaHotel = new ListaHotel(this);
		registroHotel = new RegistroHotel(this);
		generalHotel = new GeneralHotel(this);
		modificarHotel = new ModificarHotel(this);
		
		//Visualizar Paneles
		add(menuHotel);
		add(listaHotel);
	}

	public void actualizarHuespedes()
	{
		listaHotel.ActualizarLista();
		generalHotel.ActualizarLista();
	}
	
	public void BorrarPaneles()
	{
		remove(listaHotel);
		remove(registroHotel);
		remove(generalHotel);
		remove(modificarHotel);
	}

	public void AbrirPanelLista()
	{
		actualizarHuespedes();
		BorrarPaneles();
		add(listaHotel);
		revalidate();
		repaint();
	}

	public void AbrirPanelIngreso()
	{
		actualizarHuespedes();
		BorrarPaneles();
		add(registroHotel);
		revalidate();
		repaint();
	}

	public void AbrirPanelModificar()
	{
		actualizarHuespedes();
		BorrarPaneles();
		add(modificarHotel);
		revalidate();
		repaint();
	}

	public void AbrirPanelRegistro()
	{
		actualizarHuespedes();
		BorrarPaneles();
		add(generalHotel);
		revalidate();
		repaint();
	}
	
	public ArrayList<Huesped> AgregarHuesped(Huesped auxHuesped)
	{
		aplicacionHotel.aniadirHuesped(auxHuesped);
		JOptionPane.showMessageDialog(this,"Se Registro Correctamente El Huesped");
		return aplicacionHotel.getHuespedes();
	}

	public void ModificarHuesped(Huesped auxHuesped)
	{
		aplicacionHotel.modifHuesped(auxHuesped);
	}

	public ArrayList<Huesped> getHuespedes()
	{
		return aplicacionHotel.getHuespedes();
	}
	
	public ArrayList<Empleado> getEmpleados()
	{
		return aplicacionHotel.getEmpleados();
	}
	
	//Botones De Acciones
	public void actionPerformed(ActionEvent e)
	{
		String event = e.getActionCommand();
		
	}
}
