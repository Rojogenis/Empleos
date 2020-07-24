package com.jaime.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jaime.model.Vacante;


@Controller
public class HomeController {
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> list = getVacacntes();
		model.addAttribute("vacantes", list);
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostarListado(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingenieros de cominicaciones");
		vacante.setDescripcion("Se solicita ingeniero ppara dar soporte por internet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		model.addAttribute("vacante", vacante);
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<>();
		lista.add("Ingeniero de Sistemas ");
		lista.add("Auxiliar de Contabilidad ");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		
		return "listado";
		
		
		
	}
	
	@GetMapping("/")
	public String mostarHome(Model model) {
		//Ejemplo de crear variables string para la viusta en html 
		/**
		model.addAttribute("message", "Bienvenidos a Empleos App");
		model.addAttribute("date", new Date());
		return "home";
		*/
		String nombre = "Auxiliar de Contavilidad ";
		Date fechaPub =new Date();
		double salario =9000.0;
		boolean vigente = true;
		
		model.addAttribute("name", nombre);
		model.addAttribute("date", fechaPub);
		model.addAttribute("wage", salario);
		model.addAttribute("upTo", vigente);
		
		return "home";
		
	}
		
	private List<Vacante> getVacacntes(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		
		try {
			Vacante vacante1= new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos Ing. Civi para disenar puente peatonal");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(8500.0);
			
			Vacante vacante2= new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico");
			vacante2.setDescripcion("Empresa importante solicita contador con 5 anos de experiencia titulado");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(12000.0);
			
			Vacante vacante3= new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electrico");
			vacante3.setDescripcion("Empresa importante solicita ingeniero mecanico para mantenimieto de la instalacion electrica");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			vacante3.setSalario(10500.0);
			
			Vacante vacante4= new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Disenador Grafico");
			vacante4.setDescripcion("Solicitamos Disenador Grafico titulado para disenar publicidad de la empresa");
			vacante4.setFecha(sdf.parse("11-02-2019"));
			vacante4.setSalario(7500.0);
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		} catch (ParseException e) {
			System.out.println("Eror "+e.getMessage());
		}
		
		
		return lista;
	}
		
		
	
	
	
}
