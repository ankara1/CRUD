package annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations {

	public static void main(String[] args) {
		
	//	ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");			//esta forma es para utilizar un archivo xml como proveedor de beans

		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(EmpleadosConfig.class);	//de esta otra forma es para utilizar una clase java como proveedor de beans
		
		Empleados elceo = contexto.getBean("CEOEmpleado", Empleados.class);
		System.out.println(elceo.getInformes() + "\n" + elceo.getTareas() + "\n\n");
		
		CEOEmpleado elceoreal = contexto.getBean("CEOEmpleado", CEOEmpleado.class);
		System.out.println(elceoreal.getNombreEmpresa() + "\n" + elceoreal.getEmail() + "\n\n");

		
		Empleados enzo = contexto.getBean("Vendedor", Empleados.class);
		System.out.println(enzo.getInformes() + "\n" + enzo.getTareas() + "\n\n");
		
		Empleados enzo2 = contexto.getBean("Vendedor", Empleados.class);
		Empleados enzo3 = contexto.getBean("Vendedor", Empleados.class);
		if(enzo2==enzo3) {																		//con una annotation @Scope en el bean podes especificar entre parentesis si queres crear bean con prototype o singleton u otros patrones de diseño
			System.out.println("son el mismo objeto con otro nombre");
		}else {
			System.out.println("no son el mismo objeto pero son clones de un mismo objeto");
		}
		
		contexto.close();
		
	}

}
