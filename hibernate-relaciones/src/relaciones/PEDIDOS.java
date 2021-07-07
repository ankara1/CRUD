package relaciones;

import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PEDIDOS")
public class PEDIDOS {
	
	//--------------------------------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPEDIDO")																						//clave primaria
	private int IDPEDIDO;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})			//especifico que la relacion es de uno a varios, quiere decir que por cada CLIENTES puede haber muchos PEDIDOS que se relacionen por medio de este campo, con lo cual este va a ser un campo que coincidira en ambas tablas con el mismo valor tanto en una como en otra.. la especificacion en cascada es que todo lo que se haga se haga en cascada menos eliminar, porque si quiero eliminar PEDIDOS quiero conservar el CLIENTES y si elimino un CLIENTES quiero conservar sus PEDIDOS         
	@JoinColumn(name="IDCLIENTE")																					//el campo IDCLIENTE de la tabla de PEDIDOS se relaciona con el objeto de tipo CLIENTES que creo debajo
	private CLIENTES IDCLIENTE;																						//**
	
	@Column(name="FORMADEPAGO")
	private String FORMADEPAGO;
	
	@Column(name="FECHA")
	private GregorianCalendar FECHA;
	
	//-------------------------------------------------------------------------------------------

	public PEDIDOS() {
	}

	public PEDIDOS(CLIENTES iDCLIENTE, String fORMADEPAGO, GregorianCalendar gregorianCalendar) {
		IDCLIENTE = iDCLIENTE;
		FORMADEPAGO = fORMADEPAGO;
		FECHA = gregorianCalendar;
	}
	
	//-------------------------------------------------------------------------------------------

	public int getIDPEDIDO() {
		return IDPEDIDO;
	}

	public void setIDPEDIDO(int iDPEDIDO) {
		IDPEDIDO = iDPEDIDO;
	}

	public CLIENTES getIDCLIENTE() {
		return IDCLIENTE;
	}

	public void setIDCLIENTE(CLIENTES iDCLIENTE) {
		IDCLIENTE = iDCLIENTE;
	}

	public String getFORMADEPAGO() {
		return FORMADEPAGO;
	}

	public void setFORMADEPAGO(String fORMADEPAGO) {
		FORMADEPAGO = fORMADEPAGO;
	}
	
	//-------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "PEDIDOS [IDPEDIDO=" + IDPEDIDO + ", FORMADEPAGO=" + FORMADEPAGO + ", FECHA=" + FECHA + "]";
	}

	//--------------------------------------------------------------------------------------------
	
}
