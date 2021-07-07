package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import aop.Cliente;

@Aspect
@Component
public class Login {
	
	@Pointcut("execution(* dao.*.*(..))")  											//esto es para que actue en absolutamente todos los metodos dentro del paquete dao
	private void pointcutTotal() {}
	
	@Pointcut("execution(public * insertar(..))")									//lo que se modifique aqui tendra efecto en todo lo que utilice este pointcut
	private void pointcut() {} 														//este metodo no hace nada, solo guarda el PointcutExpresion para poder reutilizarlo
	
	@Pointcut("execution(* dao.*.get*(..))")										//esto es para que actue solo sobre los getters que se encuentren en este paquete, si quisiera que sean solo los setters cambio el get por un set
	private void pointcutGetters() {}
	
	@Pointcut("execution(* dao.*.set*(..))")										//esto es para que actue solo sobre los setters que se encuentren en este paquete, si quisiera que sean solo los getters cambio el set por un get
	private void pointcutSetters() {}
	
	@Pointcut("pointcutTotal() && !(pointcutGetters() || pointcutSetters())")		//esto es una combinacion de pointcuts con el primero ejecutandolo en todo y con operador !para negar o excluir a los otros 2 pointcuts que son los de getter y setter
	private void pointcutsingetyset() {}
	
//------------------------------------------------------------------------------------------------------------
	
//el aop.Cliente hace referencia al tipo de dato y su paquete, y los (..) son para indicar que luego del dato de tipo Cliente, puede tener objetos de otros tipos, si quitara el Cliente de los parametros recibiria con los (..) parametros de cualquier tipo
	@Before("execution(public * dao.ClienteVIP.inser*(aop.Cliente, ..))")					//como es un aspecto y se ejecuta antes de la llamada al metodo public void insertar, yo puedo agregar una pointcut expresion para copiar el cualified name de la clase que quiero que compruebe el aspecto y lo pego andes de el nombre del metodo y utilizo el punto para llamar a esa funcion, el asterisco es para usar de comodin para que ejecute el aspecto en todo metodo que arranque con inser... el asterisco delante del void indica que el metodo se ejecutara no importa si devuelve un tipo de objeto o si es un void por si tenemos metodos que se llamen insertar() pero uno es de tipo void y otro es de tipo String por ejemplo...      
		//que porque tanto quilombo? porque puede ser que quieras realizar una comprobacion de aspecto pero el aspecto debe recibir si o si un usuario, una contraseña, entre otras cosas que tiene que cumplir para realizar la comprobacion
	public void before(JoinPoint eljoin) {
			//el JoinPoint hace un punto de pausa como el debugger para analizar los argumentos del metodo al que hace referencia el pointcut, en este caso el metodo insertar
		Object[] array = eljoin.getArgs();													//almaceno en un array de objetos todos los parametros que se pasan en el metodo insertar para poder hacer las comprobaciones pertinente a si un cliente esta logueado o si es correcto
		for (Object object : array) {													//recorro los objetos
			if(object instanceof Cliente) {												//si lo que hay en objeto es una instancia de tipo Cliente...
				Cliente cl1 = (Cliente)object;											//haceme un casting de objeto a Cliente y metelo adentro de cl
					System.out.println(cl1.getNombre() + ", " + cl1.getTipo()); 		//pongo que imprima el nombre y el tipo en consola pero luego hare comprobacion de datos en la base de datos
			}
		}
		System.out.println("el usuario esta logueado");
		System.out.println("el perfil para insertar cliente es correcto");
	}
	
//	@Before("pointcut()")							//ejecutara estos 2 metodos tanto en el ClienteDAO como en el ClienteVIP
	@Before("pointcutGetters()")					//cada getter que se encuentre en el paquete dao que sea llamado ejecutara esto antes
	public void requisitos() {
		System.out.println("el cliente cumple con los requisitos para ser insertados");
	}
	
	@Before("pointcutsingetyset()")					//este metodo se aplicara en todo metodo menos es setter y getters de clases del paquete dao
	public void limite() {
		System.out.println("hay menos de 1000 registros asi que podes insertar este cliente");
	}
	//se pueden crear los pointcut directamente en la anotation @Before o se pueden encapsular en metodos vacios para luego ser llamados o implementados como si fueran beans con el nombre del metodo dentro de el @Before
	
//el metodo before solo se ejecuta en la clase ClienteVIP mientras que los metodos requisitos y limite se ejecutan tanto en ClienteVIP como en ClienteDAO

	//si quisiera aplicar un ordenamiento en el orden de ejecucion de las pointcut deberia crear cada metodo que llame a su respectivo pointcut en clases diferentes dentro del mismo paquete que especifique iba a tener los pointcut y luego a cada clase ponerle una anotacion @Order() y dentro de los parentesis el indice de prioridad, 1,2,3,4....  dichas clases deben contener las anotaciones @Aspect y @Component seguido del metodo con la ruta por delante de la pointcut
	
/*	@Before("aspects.Login.pointcutsingetyset()")					//este metodo se aplicara en todo metodo menos es setter y getters de clases del paquete dao
	public void limite() {
		System.out.println("hay menos de 1000 registros asi que podes insertar este cliente");              */

}
