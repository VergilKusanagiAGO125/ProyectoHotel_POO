package mx.unam.fes.acatlan.mac.poo.backend;

public class Persona
{
	protected String nombre;
	protected String apellidoP;
	protected String apellidoM;
	
	public Persona()
	{
		
	}
	public Persona(String nombre, String apellidoP, String apellidoM)
	{
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getApellidoP()
	{
		return apellidoP;
	}
	public void setApellidoP(String apellidoP)
	{
		this.apellidoP = apellidoP;
	}
	public String getApellidoM()
	{
		return apellidoM;
	}
	public void setApellidoM(String apellidoM)	
	{
		this.apellidoM = apellidoM;
	}
	
	
}
