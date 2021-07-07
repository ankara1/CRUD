package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CRUD")
public class CRUD {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;
	
	@Column(name="NOMBRE")
	private String NOMBRE;
	
	@Column(name="APELLIDO")
	private String APELLIDO;
	
	@Column(name="EMAIL")
	private String EMAIL;

	//-------------------------------------------------------------------------------------------------------
	
	public CRUD() {
		
	}

	public CRUD(String nOMBRE, String aPELLIDO, String eMAIL) {
		super();
		NOMBRE = nOMBRE;
		APELLIDO = aPELLIDO;
		EMAIL = eMAIL;
	}
	
	//--------------------------------------------------------------------------------------------------------

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public String getAPELLIDO() {
		return APELLIDO;
	}
	public void setAPELLIDO(String aPELLIDO) {
		APELLIDO = aPELLIDO;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	
	//------------------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "CRUD [ID=" + ID + ", NOMBRE=" + NOMBRE + ", APELLIDO=" + APELLIDO + ", EMAIL=" + EMAIL + "]";
	}
	
	//------------------------------------------------------------------------------------------------------
	
}
