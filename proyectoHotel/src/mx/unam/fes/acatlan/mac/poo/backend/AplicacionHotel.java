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

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class AplicacionHotel
{
	private ArrayList<Huesped> huespedes;
	private ArrayList<Empleado> empleados;
	
	public AplicacionHotel()
	{
		empleados = new ArrayList<Empleado>();
		empleados.add(new Empleado("Ariel","Gonzalez","Ordaz"));
		empleados.add(new Empleado("Alondra Paloma","Gabriel","Cruz"));
		empleados.add(new Empleado("Angel Gabriel","Castro","Gonzalez"));
		empleados.add(new Empleado("Pablo","San Pedro","Avila"));
		empleados.add(new Empleado("Miguel Angel","Rosas","Gonzalez"));
		
		huespedes = new ArrayList<Huesped>();
		huespedes.add(new Huesped("H-1",false,empleados.get(1),restarDias(LocalDate.of(2023,12,3),LocalDate.of(2023,12,4))
				,"A-1",LocalDate.of(2023,12,3),LocalDate.of(2023,12,4),3500.0
				,"Dante","Sparda","Perez",EstadoHospedaje.APARTADO));
		huespedes.add(new Huesped("H-2",true,empleados.get(4),restarDias(LocalDate.of(2023,12,1),LocalDate.of(2023,12,12))
				,"A-2",LocalDate.of(2023,12,1),LocalDate.of(2023,12,12),3650.0
				,"Vergil","Sparda","Lopez",EstadoHospedaje.HOSPEDADO));
		huespedes.add(new Huesped("H-3",false,empleados.get(3),restarDias(LocalDate.of(2023,12,6),LocalDate.of(2023,12,14))
				,"A-3",LocalDate.of(2023,12,6),LocalDate.of(2023,12,14),3500.0
				,"Nero","Sparda","Ramirez",EstadoHospedaje.APARTADO));
		huespedes.add(new Huesped("H-4",false,empleados.get(2),restarDias(LocalDate.of(2023,12,12),LocalDate.of(2023,12,14))
				,"A-4",LocalDate.of(2023,12,12),LocalDate.of(2023,12,14),2500.0
				,"Keching","Gonzalez","Lopez",EstadoHospedaje.CANCELADO));
		huespedes.add(new Huesped("H-1",true,empleados.get(0),restarDias(LocalDate.of(2023,11,12),LocalDate.of(2023,11,14))
				,"A-5",LocalDate.of(2023,11,12),LocalDate.of(2023,11,14),1000.0
				,"Terry","Bogard","Benitez",EstadoHospedaje.PAGADO));
		huespedes.add(new Huesped("H-2",true,empleados.get(1),restarDias(LocalDate.of(2023,11,12),LocalDate.of(2023,11,14))
				,"A-6",LocalDate.of(2023,11,12),LocalDate.of(2023,11,14),1000.0
				,"Andy","Bogard","Benitez",EstadoHospedaje.PAGADO));
		huespedes.add(new Huesped("H-2",false,empleados.get(0),restarDias(LocalDate.of(2024,01,12),LocalDate.of(2024,12,14))
				,"A-7",LocalDate.of(2024,01,12),LocalDate.of(2024,12,14),100000.0
				,"Mc LOVIN"," "," ",EstadoHospedaje.APARTADO));
	}

	public ArrayList<Huesped> getHuespedes()
	{
		return huespedes;
	}

	public void setHuespedes(ArrayList<Huesped> huespedes)
	{
		this.huespedes = huespedes;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados)
	{
		this.empleados = empleados;
	}

	public void aniadirHuesped(Huesped aux)
	{
		huespedes.add(aux);
	}
	
	public void modifHuesped(Huesped aux)
	{
		ArrayList<Huesped> huespedesAux = new ArrayList<Huesped>();
		huespedesAux.addAll(huespedes);
		
		huespedes.clear();
		for(Huesped h:huespedesAux)
		{
			if(h.getId().equals(aux.getId()))
			{
				huespedes.add(aux);
			}
			else
			{
				huespedes.add(h);
			}
		}
	}
	
	public Integer restarDias(LocalDate diaInicio,LocalDate diaFinal)
	{
		Integer diasHotel = (int)ChronoUnit.DAYS.between(diaInicio,diaFinal);
		return diasHotel;
	}
}
