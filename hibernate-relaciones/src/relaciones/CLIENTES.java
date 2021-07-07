package relaciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class CLIENTES {
	
	//------------------------------------------------------------------------------
	
	@Id																						//
	@GeneratedValue(strategy=GenerationType.IDENTITY)										//
	@Column(name="IDCLIENTE")																//
	private int IDCLIENTE;																	//
	
	@Column(name="NOMBRE")
	private String NOMBRE;
	
	@Column(name="APELLIDO")
	private String APELLIDO;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="IDCLIENTE", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})  		//la relacion entre PEDIDOS y CLIENTES era de varios a uno, pero esta de CLIENTES a PEDIDOS es de uno a varios, porque un CLIENTES puede tener varios PEDIDOS pero los PEDIDOS individuales no pueden ser hechos por varios CLIENTES simultaneos, las cascadas indican que quiero hacer cualquier modificacion en cascada excepto por las operaciones de borrado.. mappedBy hace referencia al campo que va a tomar de referencia para hacer la relacion de uno a varios... fetchType indica que cantidad de informacion te va a devolver una clase, por ejemplo, si yo le pido especificando fetchType Eager la informacion de un CLIENTES, me va a devolver absolutamente toda la informacion relacionada de el campo que contiene el fetchType, en este caso el arraylist de pedidos, en cambio si el fetchType es LAZY solo me va a devolver dicha informacion cuando se la pida especificamente... uno carga toda informacion de golpe, con lo cual si es innecesario va a consumir recursos que no son necesarios y otro va a cargar la informacion a medida que se la vallamos pidiendo... usar uno u otro depende de la necesidad de el momento         
	private List<PEDIDOS> pedidos;															//de que va este arraylist? tengo que especificar o poder guardar todos los PEDIDOS que me hizo un CLIENTES en un campo, y lo mas conveniente es que sea en un arraylist
	
	//------------------------------------------------------------------------------
	
	public void agregarpedidos(PEDIDOS elpedido) {  										//este metodo pide por parametro un objeto de tipo PEDIDOS el cual se guardara en el arraylist pedidos, puede guardar tantos pedidos como le pidamos
		if(pedidos==null) {																	//si no le hicimos ningun pedido previo el List estara vacio
			pedidos = new ArrayList<>();													//en ese entonces iniciaremos pedidos como new Arraylist y guardara todos los pedidos que le pidamos... no hace falta else
		}
		pedidos.add(elpedido);																//al List pedidos le voy a agregar el pedido que le pase al metodo
		elpedido.setIDCLIENTE(this);														//a cada pedido nuevo se le establecera el IDCLIENTE que es uno de los parametros que pide el constructor de PEDIDOS y se establecera el IDCLIENTE de esta clase que lo llama al metodo... es enrevesado.. pero elpedido es de tipo PEDIDOS, con lo cual tiene un metodo que es setIDCLIENTES, que pide por parametro un objeto de tipo CLIENTES y con el this se hace referencia a esta clase nueva, en conclusion cada vez que se cree un nuevo PEDIDOS el constructor pedira por parametro sus 3 campos, uno de ellos es de tipo CLIENTES, el cual sera este nuevo CLIENTES
	}
	
	//------------------------------------------------------------------------------
	
	public List<PEDIDOS> getPedidos() {														//con este metodo obtenes todos los PEDIDOS relacionados con este CLIENTES por medio del campo IDCLIENTE
		return pedidos;																		//devuelve un arraylist
	}

	public void setPedidos(List<PEDIDOS> pedidos) {		//
		this.pedidos = pedidos;
	}
	
	//------------------------------------------------------------------------------
	
	public CLIENTES() {																		//no se porque si no hay constructor por defecto, todo el programa cae
		
	}

	public CLIENTES(String NOMBRE, String APELLIDO) {										//cada vez que se construya un CLIENTES se le debera pasar obligatoriamente los parametros correspondientes para que nunca quede nulo
		this.NOMBRE = NOMBRE;
		this.APELLIDO = APELLIDO;
	}
	
	//-----------------------------------------------------------------------------
	
	@OneToOne(cascade=CascadeType.ALL)														//para actualizar y borrar en cascada y hacer relacion de 1 a 1 entre CLIENTES Y DETALLESCLIENTES 
	@JoinColumn(name="IDCLIENTE")															//la columna que va a hacer referencia al ID de CLIENTES para relacionar
	private DETALLESCLIENTES detallesclientes;												//especificando todo esto le avisas a hibernate que la tabla con la cual tendra relacion esta clase de CLIENTES va a ser DETALLESCLINTES con sus correspondientes anotaciones OneToOne y su JoinColumn para especificar cual va a ser la """"" por la cual se van a relacionar las tablas
	
	//-----------------------------------------------------------------------------

	public DETALLESCLIENTES getDetallesclientes() {											//como lo que se obtiene es un CLIENTES, el main llamara a esta clase CLIENTES el cual adentro tiene este metodo que permite obtener todos los detalles de la tabla DETALLESCLIENTES por medio de este get
		return detallesclientes;
	}

	public void setDetallesclientes(DETALLESCLIENTES detallesclientes) {					//cada vez que se haga un CLIENTE si se quiere establecer los detalles de DETALLESCLIENTES se debera llamar a este set y pasarle por parametro un objeto de tipo DETALLESCLIENTES, el cual en su constructor estara especificado que debe recibir por parametro todos los campos que constituyen su clase y asi cada vez que se construya un nuevo CLIENTES tambien se va a crear un DETALLESCLIENTES
		this.detallesclientes = detallesclientes;
	}
	
	//----------------------------------------------------------------------				//los setter y getter para modificar los campos de la tabla con mapeo ORM

	public int getIDCLIENTE() {
		return IDCLIENTE;
	}

	public void setIDCLIENTE(int IDCLIENTE) {
		this.IDCLIENTE = IDCLIENTE;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String NOMBRE) {
		this.NOMBRE = NOMBRE;
	}

	public String getAPELLIDO() {															
		return APELLIDO;
	}

	public void setAPELLIDO(String APELLIDO) {
		this.APELLIDO = APELLIDO;
	}
	
	//-----------------------------------------------------------------------------

	@Override																				//el metodo toString lo que hace es que cada vez que queramos obtener un objeto con sus detalles, en vez de mostrarmelo en formato de objeto me lo muestre en formato texto con todos sus campos y variables
	public String toString() {
		return "CLIENTES [IDCLIENTE=" + IDCLIENTE + ", NOMBRE=" + NOMBRE + ", APELLIDO=" + APELLIDO + "]";
	}
	
	//------------------------------------------------------------------------------

}
