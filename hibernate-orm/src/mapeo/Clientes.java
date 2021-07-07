package mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity																		//indico que es una entidad a la cual quiero transformar en un ORM 
@Table(name="Clientes")														//indico a cual de las tablas de mi bbdd me refiero
public class Clientes {
	
	@Id																		//indico que este es el id
	@GeneratedValue(strategy=GenerationType.IDENTITY)						//con esto indicas que es campo clave
	@Column(name="ID")														//en name indico que nombre exacto le di en mi bbdd a la columna
	private int ID;
	
	@Column(name="NOMBRE")													//en name indico que nombre exacto le di en mi bbdd a la columna
	private String NOMBRE;
	
	@Column(name="APELLIDO")												//en name indico que nombre exacto le di en mi bbdd a la columna
	private String APELLIDO;
	
	@Column(name="SUELDO")													//en name indico que nombre exacto le di en mi bbdd a la columna
	private double SUELDO;

	//------------------------------------------------------------------------
	
	public Clientes() { 													//constructor vacio por si no se los campos y quiero agregar
	}

	public Clientes(String nOMBRE, String aPELLIDO, double sUELDO) {		//contructor con todos los parametros menos con el id porque es autonumerico
		NOMBRE = nOMBRE;
		APELLIDO = aPELLIDO;
		SUELDO = sUELDO;
	}
	
	//--------------------------------------------------------------------------------------

	public int getID() {													//los setters y getters
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

	public double getSUELDO() {
		return SUELDO;
	}

	public void setSUELDO(double sUELDO) {
		SUELDO = sUELDO;
	}
	
	//---------------------------------------------------------------------------------

	@Override
	public String toString() {												//metodo to string para que sea legible la informacion
		return "CLIENTES [ID=" + ID + ", NOMBRE=" + NOMBRE + ", APELLIDO=" + APELLIDO + ", SUELDO=" + SUELDO + "]";
	}

}
