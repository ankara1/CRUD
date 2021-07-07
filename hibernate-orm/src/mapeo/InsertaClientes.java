package mapeo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaClientes {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();     //con configure indico cual es el archivo de configuracion xml, con addAnotatedClass agrego la clase que va a contener a los clientes a agregar y buildsesion lo construye todo                   
		Session sesion = factory.openSession(); 											//para abrir la sesion
		
		try {
			Clientes cl1 = new Clientes("fede", "degea", 100000);
			sesion.beginTransaction();
			sesion.save(cl1);
			sesion.getTransaction().commit();
			System.out.println("se grabo correctamente al cliente");
			sesion.beginTransaction();
			System.out.println("lectura del cliente con id = " + cl1.getID());
			Clientes insertado = sesion.get(Clientes.class, cl1.getID());
			System.out.println("registro: " + insertado);
			sesion.getTransaction().commit();
			System.out.println("lectura terminada");
			
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
