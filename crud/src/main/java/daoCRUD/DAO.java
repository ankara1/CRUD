package daoCRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.CRUD;

@Repository																					//para que toda esta clase se guarde como un bean se le debe dar esta annotation
public class DAO implements ClienteDAO {
	
	@Autowired
	private SessionFactory sessionFactory;													//importantisimo que se llame exactamente igual que el bean que esta en spring-crud-servlet

	@Override
	@Transactional																	//begin, commits y todo resumido en esta annotation
	public List<CRUD> getCRUD() {
		Session sesion = sessionFactory.getCurrentSession();
		Query<CRUD> query = sesion.createQuery("FROM CRUD", CRUD.class);
		List<CRUD> clientes = query.getResultList();
		return clientes;
	}

	@Override
	@Transactional																	//begin, commits y todo resumido en esta annotation
	public void insertado(CRUD elcrud) {														//cuesta de ver pero elcrud es el cliente que rellene en la form:form de AgregarCRUD que luego pase al controlador con el @PostMapping y el @ModelAttribute y almacene en un objeto de tipo CRUD, luego dentro del mismo metodo utilice instancia de interfaz ClienteDAO con autowired para crear un nuevo metodo que despues de declararlo en la interfaz es completado en esta clase para finalmente agregar ese cliente a la tabla del CRUD, ya que por parametro siempre paso elcrud que es instancia de clase CRUD       
		Session sesion = sessionFactory.getCurrentSession();
		sesion.saveOrUpdate(elcrud);
	}

	@Override
	@Transactional
	public CRUD getCliente(int iD) {
		Session sesion = sessionFactory.getCurrentSession();
		CRUD elcrud = sesion.get(CRUD.class, iD);
		return elcrud;
	}

	@Override
	@Transactional
	public void borrar(int iD) {
		Session sesion = sessionFactory.getCurrentSession();
		Query query = sesion.createQuery("DELETE FROM CRUD WHERE ID = :elIDaeliminar");
		query.setParameter("elIDaeliminar", iD);
		query.executeUpdate();
	}

}
