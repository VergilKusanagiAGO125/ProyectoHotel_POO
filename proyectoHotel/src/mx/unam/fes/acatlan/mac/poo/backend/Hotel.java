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

public class Hotel
{
	private Integer numHabitaciones;
	private String nombre;
	private String ubicacion;
	
	public Hotel()
	{
		
	}
	public Hotel(Integer numHabitaciones, String nombre, String ubicacion)
	{
		this.numHabitaciones = numHabitaciones;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}
	
	public Integer getNumHabitaciones()
	{
		return numHabitaciones;
	}
	public void setNumHabitaciones(Integer numHabitaciones)
	{
		this.numHabitaciones = numHabitaciones;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getUbicacion()
	{
		return ubicacion;
	}
	public void setUbicacion(String ubicacion)
	{
		this.ubicacion = ubicacion;
	}
}
