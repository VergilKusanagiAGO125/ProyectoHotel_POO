package mx.unam.fes.acatlan.mac.poo.frontend;

import javax.swing.JFrame;

public class InterfazHotel extends JFrame
{
	private FondoHotel fondoHotel;
	
	public InterfazHotel()
	{
		setTitle("Gestion De Un Hotel");
		setSize(854,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		fondoHotel = new FondoHotel();
		
		setContentPane(fondoHotel);
	}
	
	public static void main(String[] args)
	{
		InterfazHotel interfazHotel = new InterfazHotel();
		interfazHotel.setVisible(true);
		
	}
}
