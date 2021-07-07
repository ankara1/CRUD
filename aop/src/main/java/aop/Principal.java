package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.ClienteDAO;
import dao.ClienteVIP;

public class Principal {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		ClienteDAO cliente = contexto.getBean("clienteDAO", ClienteDAO.class);
		ClienteVIP cliente2 = contexto.getBean("BeanVIP", ClienteVIP.class);
		cliente.insertar(); 
		
		Cliente cl = new Cliente();
		cl.setNombre("juan");	cl.setTipo("profesor");						//estableci nombre y tipo pero en ningun momento lo mande a imprimir desde aca, el que esta imprimiendo el nombre y el tipo en consola es el JoinPoint del metodo before del Login
		cliente2.insertar(cl, cl.getTipo());
		System.out.println("\n");
		
		String codigo; String valoracion;
		codigo = cliente2.getCodigo();
		valoracion = cliente2.getValoracion();
		cliente2.setCodigo("");
		cliente2.setValoracion("");
		
		contexto.close();
	}

}
