package daoCRUD;

import java.util.List;

import entity.CRUD;

public interface ClienteDAO {
	
	public List<CRUD> getCRUD();

	public void insertado(CRUD elcrud);

	public CRUD getCliente(int iD);

	public void borrar(int iD);

}
