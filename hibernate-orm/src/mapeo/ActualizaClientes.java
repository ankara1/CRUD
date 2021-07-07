package mapeo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaClientes {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();     //con configure indico cual es el archivo de configuracion xml, con addAnotatedClass agrego la clase que va a contener a los clientes a agregar y buildsesion lo construye todo                   
		Session sesion = factory.openSession(); 																//para abrir la sesion
		
		try {
			int idcliente = 3;
			sesion.beginTransaction();																			//en el beginTransaction empiezan a ejecutarse las querys
			Clientes cl1 = sesion.get(Clientes.class, idcliente);												//en un objeto de tipo Cliente guardo un generico que es un cliente y precisamente uno con id 3 como especifico en el 2do argumento
			cl1.setAPELLIDO("arrizabalaga");																	//en vez de utilizar una consulta hql, uso el metodo set para establecer un nuevo apellido a esa variable
			sesion.createQuery("update Clientes set SUELDO=30000 where APELLIDO LIKE 'gui%'").executeUpdate();	//forma de actualizar con hql, LIKE es como, se utiliza como un comodin de expresion regular
			sesion.createQuery("delete Clientes where APELLIDO LIKE 'gonzal%'").executeUpdate();				//para eliminar en formato hql
			sesion.getTransaction().commit();																	//ejecuta todas las querys si es que no se encontro falla alguna
			System.out.println("actualizacion correcta");														//imprimo mensaje final
			System.out.println("eliminacion correcta");
			
		}catch(Exception e) {
			sesion.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("no se grabo nada porque algo fallo en el try");
			
		}finally {
			sesion.close();
			factory.close();
		}
	}
}
