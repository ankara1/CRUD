package validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy=CodigoPostal.class) 									//nombre de la clase que va a contener la logica de la validacion
@Target({ElementType.METHOD, ElementType.FIELD})								//Target lo que indica es que clase de objetos o parametros va a poder recibir esta annotation, en este caso a metodos y campos
@Retention(RetentionPolicy.RUNTIME)												//Retention indica en que momento queres comprobar la validacion, si es en tiempo de ejecucion o en algun caso diferente
public @interface Postal {
	
	public String value() default "28";											//metodo que especifica que por defecto el codigo postal sera 28
	public String message() default "el codigo postal debe empezar en 28";		//mensaje por defecto
	Class<?>[] groups() default {};												//los grupos definen que grupos de campos se van validando en tiempo de ejecucion
    Class<? extends Payload>[] payload() default {};							//son para almacenar metadatos(???)
}
