package relaciones;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import relaciones.CLIENTES;

public class InsertaPEDIDOS {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CLIENTES.class).addAnnotatedClass(DETALLESCLIENTES.class).addAnnotatedClass(PEDIDOS.class).buildSessionFactory();
		Session sesion = factory.openSession(); 
		try {
			CLIENTES cl1 = sesion.get(CLIENTES.class, 5);												//obtengo el CLIENTES que tiene id 1 en la base de datos y lo almaceno en un CLIENTES
			sesion.beginTransaction();
			PEDIDOS pedido1 = new PEDIDOS(cl1, "contado", new GregorianCalendar(2020, 7, 5));			//almaceno un CLIENTES en el campo IDCLIENTES, un String FORMADEPAGO, y un GregorianCalendar en la FECHA.. el IDPEDIDOS es autonumerico
			PEDIDOS pedido2 = new PEDIDOS(cl1, "tarjeta", new GregorianCalendar(2018, 5, 5));
			PEDIDOS pedido3 = new PEDIDOS(cl1, "contado", new GregorianCalendar(2019, 2, 5));
			cl1.agregarpedidos(pedido1);  cl1.agregarpedidos(pedido2);  cl1.agregarpedidos(pedido3); 	//agrego los 3 pedidos del mismo CLIENTES en el metodo agregarpedidos de la clase CLIENTES que lo que hace es guardar PEDIDOS en un List para ser llamado por medio de un getPedidos        
			sesion.save(pedido1);  sesion.save(pedido2);  sesion.save(pedido3);  						//guardo los PEDIDOS en la tabla PEDIDOS
			sesion.getTransaction().commit(); 
			System.out.println("pedidos insertados correctamente");										//si el commit no encuentra errores en las queries saldra este mensaje en consola
			
		}catch(Exception e){
			sesion.getTransaction().rollback();															//deshace todas las querys ejecutadas antes de haber encontrado la que contenia el error para que no queden registros incompletos y no ejecute ninguna query leida
			e.printStackTrace();
			System.out.println("algo salio mal en el try");
			
		}finally {
			sesion.close();
			factory.close();
		}

	}

}
