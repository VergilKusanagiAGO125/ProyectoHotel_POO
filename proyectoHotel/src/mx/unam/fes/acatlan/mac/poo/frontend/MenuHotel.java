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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import mx.unam.fes.acatlan.mac.poo.backend.*;

public class MenuHotel extends JPanel implements ActionListener
{
	private JButton btnIngreso;
	private JButton btnLista;
	private JButton btnModificar;
	private JButton btnRegistro;

	private FondoHotel ventanaPrincipal;
	
	public MenuHotel(FondoHotel ventanaPrincipal)
	{
		//Valores Del Panel
		setLayout(null);
		setBounds(0,0,240,480);
		setBackground(new Color(75,8,2));

		this.ventanaPrincipal = ventanaPrincipal;
		
		Color clrFondoBotonesOn = new Color(250,200,25);
		Color clrFondoBotonesOff = new Color(125,20,10);
		Color clrLetrasBotonesOff = new Color(255,255,255);
		Color clrLetrasBotonesOn = new Color(0,0,0);
		
		//Botón Menu_1
		btnLista = new JButton("Lista De Clientes Hospedados");
		btnLista.setActionCommand("LISTA_CLIENTES");
		btnLista.addActionListener(this);
		btnLista.setBounds(0,120,240,40);
		btnLista.setBackground(clrFondoBotonesOff);
		btnLista.setForeground(clrLetrasBotonesOff);
		btnLista.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				btnLista.setBackground(clrFondoBotonesOn);
				btnLista.setForeground(clrLetrasBotonesOn);
			}
            public void mouseExited(MouseEvent e)
            {
            	btnLista.setBackground(clrFondoBotonesOff);
            	btnLista.setForeground(clrLetrasBotonesOff);
            }
		});
		add(btnLista);

		//Botón Menu_2
		btnIngreso = new JButton("Ingresar Cliente");
		btnIngreso.setActionCommand("INGRESAR_CLIENTE");
		btnIngreso.addActionListener(this);
		btnIngreso.setBounds(0,160,240,40);
		btnIngreso.setBackground(clrFondoBotonesOff);
		btnIngreso.setForeground(clrLetrasBotonesOff);
		btnIngreso.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				btnIngreso.setBackground(clrFondoBotonesOn);
				btnIngreso.setForeground(clrLetrasBotonesOn);
			}
            public void mouseExited(MouseEvent e)
            {
            	btnIngreso.setBackground(clrFondoBotonesOff);
            	btnIngreso.setForeground(clrLetrasBotonesOff);
            }
		});
		add(btnIngreso);

		//Botón Menu_3
		btnModificar = new JButton("Cambiar Estado De Cliente");
		btnModificar.setActionCommand("MODIFICAR_CLIENTES");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(0,200,240,40);
		btnModificar.setBackground(clrFondoBotonesOff);
		btnModificar.setForeground(clrLetrasBotonesOff);
		btnModificar.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				btnModificar.setBackground(clrFondoBotonesOn);
				btnModificar.setForeground(clrLetrasBotonesOn);
			}
            public void mouseExited(MouseEvent e)
            {
            	btnModificar.setBackground(clrFondoBotonesOff);
            	btnModificar.setForeground(clrLetrasBotonesOff);
            }
		});
		add(btnModificar);

		//Botón Menu_4
		btnRegistro = new JButton("Registro Total De Los Clientes");
		btnRegistro.setActionCommand("VER_REGISTRO");
		btnRegistro.addActionListener(this);
		btnRegistro.setBounds(0,240,240,40);
		btnRegistro.setBackground(clrFondoBotonesOff);
		btnRegistro.setForeground(clrLetrasBotonesOff);
		btnRegistro.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				btnRegistro.setBackground(clrFondoBotonesOn);
				btnRegistro.setForeground(clrLetrasBotonesOn);
			}
            public void mouseExited(MouseEvent e)
            {
            	btnRegistro.setBackground(clrFondoBotonesOff);
            	btnRegistro.setForeground(clrLetrasBotonesOff);
            }
		});
		add(btnRegistro);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String event = e.getActionCommand();
		if(event.equals("LISTA_CLIENTES"))
		{
			ventanaPrincipal.AbrirPanelLista();
		}
		else if(event.equals("INGRESAR_CLIENTE"))
		{
			ventanaPrincipal.AbrirPanelIngreso();
		}
		else if(event.equals("MODIFICAR_CLIENTES"))
		{
			ventanaPrincipal.AbrirPanelModificar();
		}
		else if(event.equals("VER_REGISTRO"))
		{
			ventanaPrincipal.AbrirPanelRegistro();
		}
	}
}
