package annotations;

import org.springframework.beans.factory.annotation.Value;

public class CEOEmpleado implements Empleados {
	
	private CreacionInforme informe;
	
	@Value("${email}")							//en el value se indica con ${} el nombre del campo a rescatar del archivo properties
	private String email;						
	
	@Value("${nombreEmpresa}")
	private String nombreEmpresa;				//para rescatar las variables del archivo properties deberiamos declarar variables vacias para meterle los valores que rescatemos en el properties
	
	public CEOEmpleado(CreacionInforme informe) {
		this.informe = informe;
	}
	
	//---------------------------------------------------------------------------------------
	
	public String getEmail() {
		return email;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	
	//----------------------------------------------------------------------------------------

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "soy el mas crack";
	}
	@Override
	public String getInformes() {
		// TODO Auto-generated method stub
		return informe.getInformeExtra();
	}

}
