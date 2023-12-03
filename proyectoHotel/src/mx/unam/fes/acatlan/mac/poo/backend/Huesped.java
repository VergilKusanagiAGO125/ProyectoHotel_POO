package mx.unam.fes.acatlan.mac.poo.backend;

import java.time.LocalDate;

public class Huesped extends Persona
{
	private String id;
	private String habitacion;
	private Integer diasHotel;
	private Boolean jacuzzi;
	private Empleado recepcionista;
	private LocalDate diaInicio;
	private LocalDate diaFinal;
	private Double costo;
	private EstadoHospedaje estado;

	public Huesped()
	{
		
	}
	public Huesped(String habitacion,Boolean jacuzzi,Empleado recepcionista,Integer diasHotel,
			String id,LocalDate diaInicio,LocalDate diaFinal,
			String nombre,String apellidoP,String apellidoM,EstadoHospedaje estado)
	{
		super(nombre, apellidoP, apellidoM);
		this.habitacion = habitacion;
		this.jacuzzi = jacuzzi;
		this.id = id;
		this.recepcionista = recepcionista;
		this.diasHotel = diasHotel;
		this.diaInicio = diaInicio;
		this.diaFinal = diaFinal;
		this.estado = estado;
	}

	public Huesped(String habitacion,Boolean jacuzzi,Empleado recepcionista,Integer diasHotel,
			String id,LocalDate diaInicio,LocalDate diaFinal,Double costo,
			String nombre,String apellidoP,String apellidoM,EstadoHospedaje estado)
	{
		super(nombre, apellidoP, apellidoM);
		this.habitacion = habitacion;
		this.jacuzzi = jacuzzi;
		this.id = id;
		this.recepcionista = recepcionista;
		this.diasHotel = diasHotel;
		this.diaInicio = diaInicio;
		this.diaFinal = diaFinal;
		this.costo = costo;
		this.estado = estado;
	}
	
	public Empleado getRecepcionista()
	{
		return recepcionista;
	}
	public void setRecepcionista(Empleado recepcionista)
	{
		this.recepcionista = recepcionista;
	}
	public Integer getDiasHotel()
	{
		return diasHotel;
	}
	public void setDiasHitel(Integer diasHotel)
	{
		this.diasHotel = diasHotel;
	}
	public String getHabitacion()
	{
		return habitacion;
	}
	public void setHabitacion(String habitacion)
	{
		this.habitacion = habitacion;
	}
	public Boolean getJacuzzi()
	{
		return jacuzzi;
	}
	public void setJacuzzi(Boolean jacuzzi)
	{
		this.jacuzzi = jacuzzi;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public LocalDate getDiaInicio()
	{
		return diaInicio;
	}
	public void setDiaInicio(LocalDate diaInicio)
	{
		this.diaInicio = diaInicio;
	}
	public LocalDate getDiaFinal() {
		return diaFinal;
	}
	public void setDiaFinal(LocalDate diaFinal)
	{
		this.diaFinal = diaFinal;
	}
	public Double getCosto()
	{
		return costo;
	}
	public void setCosto(Double costo)
	{
		this.costo = costo;
	}
	public EstadoHospedaje getEstado()
	{
		return estado;
	}
	public void setEstado(EstadoHospedaje estado)
	{
		this.estado = estado;
	}
	public String toString()
	{
		String data = "";
		data += nombre +" " +apellidoP +" " +apellidoM;
		return data;
	}
}
