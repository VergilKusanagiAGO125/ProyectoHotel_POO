/* Proyecto Hotel POO
 * 
 * Integrentes:
 * Castro Gonzalez Angel Gabriel
 * Gabriel Cruz Alondra Paloma
 * Gonzalez Ordaz Ariel
 * Rosas Gonzalez Miguel Angel
 * San Pedro Avila Pablo
 */

package mx.unam.fes.acatlan.mac.poo.backend;

public class Empleado extends Persona
{
	public Empleado()
	{
		
	}
	public Empleado(String nombre, String apellidoP, String apellidoM)
	{
		super(nombre, apellidoP, apellidoM);
	}

	public String toString()
	{
		String data = "";
		data += nombre +" " +apellidoP +" " +apellidoM;
		return data;
	}
}
