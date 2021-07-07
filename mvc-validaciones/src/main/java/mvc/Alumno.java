package mvc;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import validation.Postal;

public class Alumno {
	
	@NotNull
	@Size(min=2, message="el nombre no puede ser ni menor a 2 letras ni mayor a 15") 			//no valida o no hace el error porque es la version 6.0 la que anda bien y yo tengo la 7.0
	private String nombre;
	
	private String apellido;
	
	private String optativa;
	
	private String ciudad;
	
	@NotNull(message="campo requerido")					//prueba//
	private String idioma;
	
	@Min(value=10, message="no se permiten edades menores a 10")
	@Max(value=90, message="no se permiten edades mayores a 90")
	private int edad;
	
	@Email
	private String email;
	
//	@Pattern(regexp="[0-9a-zA-Z]{5}", message="solo 5 valores numericos")					//anotacion para expresiones regulares, entre corchetes para indicar entre que numero y numero o entre que letra y letra, y en las llaves va la longitud, el message es el mensaje a ver en caso de no cumplirse las condiciones
	@Postal
	private String codigopostal;
	
	//-------------------------------------------------------------------------------------------
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getOptativa() {
		return optativa;
	}
	public void setOptativa(String optativa) {
		this.optativa = optativa;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodigopostal() {
		return codigopostal;
	}
	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

}
