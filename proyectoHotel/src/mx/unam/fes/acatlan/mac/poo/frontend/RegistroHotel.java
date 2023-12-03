package mx.unam.fes.acatlan.mac.poo.frontend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mx.unam.fes.acatlan.mac.poo.backend.*;

public class RegistroHotel extends JPanel implements ActionListener
{
	private JLabel lbTitulo;
	
    private JLabel lbNombre;
    private JTextField txtNombre;
    
    private JLabel lbPaterno;
    private JTextField txtPaterno;
    
    private JLabel lbMaterno;
    private JTextField txtMaterno;
    
    private JLabel lbDiasHospedados;
    private JTextField txtDiasHospedados;
    
    private JLabel lbDiaDentro;
    private JTextField txtDiaDentro;

    private JLabel lbDiaInicial;
    private JTextField txtDiaInicial;

    private JLabel lbDiaFinal;
	private JTextField txtDiaFinal;
    
	private JLabel lbHabitacion;
	private JTextField txtHabitacion;
    
	private JLabel lbAsignarEmpleados;
	private JComboBox<Empleado> cbAsignarEmpleados;

    private JLabel lbJacuzzi;
    private JComboBox<String> cbJacuzzi;
    
	private JButton btnMostrarDias;
	private JButton btnIngresar;
	
	private JLabel lbCosto;
	private JTextField txtCosto;

	private AplicacionHotel aplicacionHotel;
	private FondoHotel ventanaPrincipal;
	private ArrayList<Empleado> empleados;
	private ArrayList<Huesped> huespedes;
	
	public RegistroHotel(FondoHotel ventanaPrincipal)
	{
		//Valores Del Panel
		setLayout(null);
		setBounds(240,120,600,360);
		setBackground(new Color(185,35,20));

		this.ventanaPrincipal = ventanaPrincipal;
		
		//Colores ID
		Color clrFondoTabla = new Color(125,20,10);
		Color clrLetrasTabla = new Color(255,255,255);

		lbTitulo = new JLabel("REGISTRAR CLIENTE");
		lbTitulo.setBounds(20,20,150,20);
		lbTitulo.setForeground(clrLetrasTabla);
		add(lbTitulo);

		lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(20,60,150,20);
		lbNombre.setForeground(clrLetrasTabla);
		add(lbNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(true);
		txtNombre.setBounds(20,80,150,20);
		txtNombre.setBackground(clrFondoTabla);
		txtNombre.setForeground(clrLetrasTabla);
		add(txtNombre);

		lbPaterno = new JLabel("Apellido Paterno");
		lbPaterno.setBounds(190,60,150,20);
		lbPaterno.setForeground(clrLetrasTabla);
		add(lbPaterno);
		
		txtPaterno = new JTextField();
		txtPaterno.setEditable(true);
		txtPaterno.setBounds(190,80,150,20);
		txtPaterno.setBackground(clrFondoTabla);
		txtPaterno.setForeground(clrLetrasTabla);
		add(txtPaterno);

		lbMaterno = new JLabel("Apellido Materno");
		lbMaterno.setBounds(370,60,150,20);
		lbMaterno.setForeground(clrLetrasTabla);
		add(lbMaterno);
		
		txtMaterno = new JTextField();
		txtMaterno.setEditable(true);
		txtMaterno.setBounds(370,80,150,20);
		txtMaterno.setBackground(clrFondoTabla);
		txtMaterno.setForeground(clrLetrasTabla);
		add(txtMaterno);

		lbDiaDentro = new JLabel("Hospedado Dentro De");
		lbDiaDentro.setBounds(20,100,150,20);
		lbDiaDentro.setForeground(clrLetrasTabla);
		add(lbDiaDentro);

		txtDiaDentro = new JTextField("1");
		txtDiaDentro.setEditable(true);
		txtDiaDentro.setBounds(20,120,150,20);
		txtDiaDentro.setBackground(clrFondoTabla);
		txtDiaDentro.setForeground(clrLetrasTabla);
		add(txtDiaDentro);

		lbDiasHospedados = new JLabel("Dias Hospedados");
		lbDiasHospedados.setBounds(190,100,150,20);
		lbDiasHospedados.setForeground(clrLetrasTabla);
		add(lbDiasHospedados);
		
		txtDiasHospedados = new JTextField("1");
		txtDiasHospedados.setEditable(true);
		txtDiasHospedados.setBounds(190,120,150,20);
		txtDiasHospedados.setBackground(clrFondoTabla);
		txtDiasHospedados.setForeground(clrLetrasTabla);
		add(txtDiasHospedados);

		btnMostrarDias = new JButton("Actualizar");
		btnMostrarDias.setActionCommand("ACTUALIZAR_DIAS");
		btnMostrarDias.addActionListener(this);
		btnMostrarDias.setBounds(370,120,150,20);
		btnMostrarDias.setBackground(clrFondoTabla);
		btnMostrarDias.setForeground(clrLetrasTabla);
		add(btnMostrarDias);
		
		lbDiaInicial = new JLabel("De (Automatico)");
		lbDiaInicial.setBounds(20,140,150,20);
		lbDiaInicial.setForeground(clrLetrasTabla);
		add(lbDiaInicial);

		txtDiaInicial = new JTextField();
		txtDiaInicial.setEditable(false);
		txtDiaInicial.setBounds(20,160,150,20);
		txtDiaInicial.setBackground(clrFondoTabla);
		txtDiaInicial.setForeground(clrLetrasTabla);
		add(txtDiaInicial);
		
		lbDiaFinal = new JLabel("Hasta (Automatico)");
		lbDiaFinal.setBounds(190,140,150,20);
		lbDiaFinal.setForeground(clrLetrasTabla);
		add(lbDiaFinal);

		txtDiaFinal = new JTextField();
		txtDiaFinal.setEditable(false);
		txtDiaFinal.setBounds(190,160,150,20);
		txtDiaFinal.setBackground(clrFondoTabla);
		txtDiaFinal.setForeground(clrLetrasTabla);
		add(txtDiaFinal);

		lbHabitacion = new JLabel("Habitacion (1,2,3,...,100)");
		lbHabitacion.setBounds(370,140,150,20);
		lbHabitacion.setForeground(clrLetrasTabla);
		add(lbHabitacion);
		
		txtHabitacion = new JTextField("1");
		txtHabitacion.setEditable(true);
		txtHabitacion.setBounds(370,160,150,20);
		txtHabitacion.setBackground(clrFondoTabla);
		txtHabitacion.setForeground(clrLetrasTabla);
		add(txtHabitacion);

		lbAsignarEmpleados = new JLabel("Quien Lo Atendio?");
		lbAsignarEmpleados.setBounds(20,180,150,20);
		lbAsignarEmpleados.setForeground(clrLetrasTabla);
		add(lbAsignarEmpleados);
		
		cbAsignarEmpleados = new JComboBox();
		cbAsignarEmpleados.setModel(new DefaultComboBoxModel(ventanaPrincipal.getEmpleados().toArray()));
		cbAsignarEmpleados.setBounds(20,200,150,20);
		cbAsignarEmpleados.setBackground(clrFondoTabla);
		cbAsignarEmpleados.setForeground(clrLetrasTabla);
		add(cbAsignarEmpleados);

		lbJacuzzi = new JLabel("Jacuzzi");
		lbJacuzzi.setBounds(190,180,150,20);
		lbJacuzzi.setForeground(clrLetrasTabla);
		add(lbJacuzzi);

		cbJacuzzi = new JComboBox<String>();
		cbJacuzzi.addItem("SI");
		cbJacuzzi.addItem("NO");
		cbJacuzzi.setActionCommand("JACUZZI");
		cbJacuzzi.addActionListener(this);
		cbJacuzzi.setBounds(190,200,150,20);
		cbJacuzzi.setBackground(clrFondoTabla);
		cbJacuzzi.setForeground(clrLetrasTabla);
		add(cbJacuzzi);

		lbCosto = new JLabel("Costo (Automatico)");
		lbCosto.setBounds(370,180,150,20);
		lbCosto.setForeground(clrLetrasTabla);
		add(lbCosto);

		txtCosto = new JTextField();
		txtCosto.setEditable(false);
		txtCosto.setBounds(370,200,150,20);
		txtCosto.setBackground(clrFondoTabla);
		txtCosto.setForeground(clrLetrasTabla);
		add(txtCosto);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setActionCommand("INGRESAR");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(20,260,150,20);
		btnIngresar.setBackground(clrFondoTabla);
		btnIngresar.setForeground(clrLetrasTabla);
		add(btnIngresar);
	}

	public static boolean ComprobarIngresoNumero(String texto)
	{
		for(char c:texto.toCharArray())
		{
			if(!Character.isDigit(c))
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean ingresoNumerosDias()
	{
		if(ComprobarIngresoNumero(txtDiaDentro.getText()) == true && 
				ComprobarIngresoNumero(txtDiasHospedados.getText()) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean ingresoNumerosGeneral()
	{
		if(ComprobarIngresoNumero(txtHabitacion.getText()) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean camposVaciosDias()
	{
		return txtDiaDentro.getText().isEmpty() || txtDiasHospedados.getText().isEmpty();
    }

	private boolean camposVaciosGeneral()
	{
		return txtNombre.getText().isEmpty() || txtPaterno.getText().isEmpty() || 
				txtMaterno.getText().isEmpty() || lbDiaDentro.getText().isEmpty() ||
				txtDiasHospedados.getText().isEmpty() || lbDiaInicial.getText().isEmpty() || 
				txtDiaFinal.getText().isEmpty() || txtHabitacion.getText().isEmpty() ||
				txtCosto.getText().isEmpty();
    }

	private boolean valoresIncorrectosDia()
	{
		Integer compare1 = Integer.parseInt(txtDiaDentro.getText());
		Integer compare2 = Integer.parseInt(txtDiasHospedados.getText());
		if(compare1 < 0 || compare2 <= 0)
		{
			return true;
		}
		return false;
    }

	public void obtenerDia()
	{
		LocalDate obtenerFechaActual = LocalDate.now();
		LocalDate fechaInicial = obtenerFechaActual.plusDays(Integer.parseInt(txtDiaDentro.getText()));
		LocalDate fechaFinal = fechaInicial.plusDays(Integer.parseInt(txtDiasHospedados.getText()));
		String diaInicialObtenido = "" +fechaInicial.getDayOfMonth() +"/" +fechaInicial.getMonthValue() +"/" +fechaInicial.getYear();
		txtDiaInicial.setText(diaInicialObtenido);
		String diaFinalObtenido = "" +fechaFinal.getDayOfMonth() +"/" +fechaFinal.getMonthValue() +"/" +fechaFinal.getYear();
		txtDiaFinal.setText(diaFinalObtenido);
	}
	
	public Double costoHotel()
	{
		Double costoHotel = 0.0;
		costoHotel += 500 * Integer.parseInt(txtDiasHospedados.getText());
		if(cbJacuzzi.getSelectedItem().equals("SI"))
		{
			costoHotel += 150.0;
		}
		else if(cbJacuzzi.getSelectedItem().equals("NO"))
		{
			costoHotel += 0;
		}
		return costoHotel;
	}

	public LocalDate obtenerDiaInicio()
	{
		LocalDate obtenerFechaActual = LocalDate.now();
		LocalDate fechaInicial = obtenerFechaActual.plusDays(Integer.parseInt(txtDiaDentro.getText()));
		return fechaInicial;
	}

	public LocalDate obtenerDiaFinal()
	{
		LocalDate obtenerFechaActual = LocalDate.now();
		LocalDate fechaInicial = obtenerFechaActual.plusDays(Integer.parseInt(txtDiaDentro.getText()));
		LocalDate fechaFinal = fechaInicial.plusDays(Integer.parseInt(txtDiasHospedados.getText()));
		return fechaFinal;
	}

	public boolean verificarHabitacionOcupada(Huesped auxHuesped)
	{
		Boolean condi = false;
		huespedes = new ArrayList<Huesped>();
		huespedes.addAll(ventanaPrincipal.getHuespedes());
		
		LocalDate auxFechaInicio = auxHuesped.getDiaInicio();
		LocalDate auxFechaFinal = auxHuesped.getDiaFinal();
		auxFechaFinal.minusDays(1);
		for(Huesped h:huespedes)
		{
			if(h.getHabitacion().equals(auxHuesped.getHabitacion()))
			{
				if(!auxFechaInicio.isBefore(h.getDiaInicio()) && !auxFechaInicio.isAfter(h.getDiaFinal()) == true)
				{
					condi = true;
					return condi;
				}
				if(!auxFechaFinal.isBefore(h.getDiaInicio()) && !auxFechaFinal.isAfter(h.getDiaFinal()) == true)
				{
					condi = true;
					return condi;
				}
			}
		}
		return condi;
    }
	
	public Huesped ObtenerDatos()
	{
		String auxOption = "" +cbAsignarEmpleados.getSelectedItem();
		Empleado empleadoaux = new Empleado();
		empleados = new ArrayList<Empleado>();
		empleados.addAll(ventanaPrincipal.getEmpleados());
		for(Empleado emp:empleados)
		{
			if(emp.toString().equals(auxOption))
			{
				empleadoaux = emp;
			}
		}
		Boolean jakuzzi = false;
		if(cbJacuzzi.getSelectedItem().equals("SI"))
		{
			jakuzzi = true;
		}
		else if(cbJacuzzi.getSelectedItem().equals("NO"))
		{
			jakuzzi = false;
		}
		huespedes = new ArrayList<Huesped>();
		huespedes.addAll(ventanaPrincipal.getHuespedes());
		Integer addID = huespedes.size() + 1;
		String id = "A-" +(addID);
		Huesped auxHuesped = new Huesped("H-" +txtHabitacion.getText(),jakuzzi,empleadoaux,Integer.parseInt(txtDiasHospedados.getText()),
				"" +id,obtenerDiaInicio(),obtenerDiaFinal(),costoHotel(),
				txtNombre.getText(),txtPaterno.getText(),txtMaterno.getText(),EstadoHospedaje.APARTADO);
		return auxHuesped;
	}
	
	public boolean LimiteHabitaciones()
	{
		int comp = Integer.parseInt(txtHabitacion.getText());
		if(comp > 0 && comp <= 100)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void guardarDatos()
	{
		Huesped auxHuesped = ObtenerDatos();
		ventanaPrincipal.AgregarHuesped(auxHuesped);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String event = e.getActionCommand();
		if(event.equals("ACTUALIZAR_DIAS"))
		{
			if(camposVaciosDias() == false)
			{
				if(ingresoNumerosDias() == true)
				{
					if(valoresIncorrectosDia() == false)
					{
						obtenerDia();
						txtCosto.setText("" +costoHotel());
						revalidate();
						repaint();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Ingrese Valores Validos");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Ingrese Solo Numeros");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Llene Todas Las Casillas");
			}
		}
		else if(event.equals("JACUZZI"))
		{
			txtCosto.setText("" +costoHotel());
			revalidate();
			repaint();
		}
		
		else if(event.equals("INGRESAR"))
		{
			if(camposVaciosGeneral() == false)
			{
				if(ingresoNumerosDias() == true)
				{
					if(ingresoNumerosGeneral() == true)
					{
						Huesped auxHuespedComp = ObtenerDatos();
						if(verificarHabitacionOcupada(auxHuespedComp) == false)
						{
							if(LimiteHabitaciones() == true)
							{
								if(valoresIncorrectosDia() == false)
								{
									obtenerDia();
									txtCosto.setText("" +costoHotel());
									guardarDatos();
									ventanaPrincipal.AbrirPanelLista();
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Ingrese Valores Validos");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Habitacion No Existente");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"No Esta Disponible La Fecha");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Ingrese Solo Numeros");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Ingrese Solo Numeros");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Llene Todas Las Casillas");
			}
		}
	}
}
