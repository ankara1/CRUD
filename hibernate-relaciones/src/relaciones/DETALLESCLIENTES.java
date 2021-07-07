package relaciones;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity																								//
@Table(name="DETALLESCLIENTES")																		//
public class DETALLESCLIENTES {
	
	//------------------------------------------------------------------------------
	
	@Id																								//
	@GeneratedValue(strategy=GenerationType.IDENTITY)												//
	@Column(name="IDCLIENTE")																		//
	private int IDCLIENTE;
	
	@Column(name="TELEFONO")
	private int TELEFONO;
	
	@Column(name="EMAIL")
	private String EMAIL;
	
	@Column(name="DIRECCION")
	private String DIRECCION;
	
	//------------------------------------------------------------------------------
	
	public DETALLESCLIENTES() {																		//no se porque si no hay constructor por defecto, todo el programa cae
		
	}

	public DETALLESCLIENTES(int tELEFONO, String eMAIL, String dIRECCION) {							//
		TELEFONO = tELEFONO;
		EMAIL = eMAIL;
		DIRECCION = dIRECCION;
	}
	
	//-----------------------------------------------------------------------------
	
	@OneToOne(mappedBy="detallesclientes", cascade=CascadeType.ALL)									//aca para especificar la relacion bidireccional tengo que agregar el mappedBy= y especificar el nombre no de la instancia de esta clase sino del nombre de la variable objeto en esa clase, seguidamente de especificar la cascada           
	private CLIENTES clientes;																		//creo un CLIENTE para establecer getters y setters, para que si quiero crear un objeto de tipo DETALLESCLIENTES, con el mismo pueda establecer por medio de su set los datos de el CLIENTES y asi crear la bidireccionalidad en ambos
	
	//-----------------------------------------------------------------------------

	public CLIENTES getCLIENTES() {																	//
		return clientes;
	}

	public void setCLIENTES(CLIENTES clientes) {													//
		this.clientes = clientes;
	}
	
	//------------------------------------------------------------------------------
	

	public int getIDCLIENTE() {																		//
		return IDCLIENTE;
	}

	public void setIDCLIENTE(int iDCLIENTE) {
		IDCLIENTE = iDCLIENTE;
	}

	public int getTELEFONO() {
		return TELEFONO;
	}

	public void setTELEFONO(int tELEFONO) {
		TELEFONO = tELEFONO;
	}

	public String getEMAIL() {																		//
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getDIRECCION() {
		return DIRECCION;
	}

	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}
	
	//----------------------------------------------------------------------------

	@Override																						//el metodo toString lo que hace es que cada vez que queramos obtener un objeto con sus detalles, en vez de mostrarmelo en formato de objeto me lo muestre en formato texto con todos sus campos y variables
	public String toString() {
		return "DETALLESCLIENTES [IDCLIENTE=" + IDCLIENTE + ", TELEFONO=" + TELEFONO + ", EMAIL=" + EMAIL
				+ ", DIRECCION=" + DIRECCION + "]";
	}
	
	//-----------------------------------------------------------------------------

}
