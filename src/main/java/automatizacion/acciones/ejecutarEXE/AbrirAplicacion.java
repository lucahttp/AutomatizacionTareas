package automatizacion.acciones.ejecutarEXE;

import automatizacion.acciones.Accion;

import java.io.IOException;

/**
 * @author Luca
 * @version 1.0
 * @created 10-May-2020 2:54:30 PM
 */
public class AbrirAplicacion extends Accion {


	//private String pathdeLaAplicacion;
	//private String parametrosdeLaAplicacion;
	//List<String> paraEjecutar = new ArrayList<String>();

	//https://www.geeksforgeeks.org/how-to-add-an-element-to-an-array-in-java/

	private String nombreDeLaAplicacionAAbrir;

	//private String[] paraEjecutar = new String[] {"", ""};
	private String[] DatosDeLaAplicacionAEjecutar;

	Runtime runtime = Runtime.getRuntime();     //getting Runtime object




	public AbrirAplicacion(String aplicacion){
		this.nombreDeLaAplicacionAAbrir = aplicacion;
		this.DatosDeLaAplicacionAEjecutar = new String[] {"", ""};
	}


	@Override
	public void ejecutar() {
		try
		{
			this.runtime.exec(DatosDeLaAplicacionAEjecutar);
			//this.runtime.exec("notepad.exe");        //opens new notepad instance

			//OR runtime.exec("notepad");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void setPath(String pathApplicacion){
		//this.pathdeLaAplicacion = pathApplicacion;
		//this.paraEjecutar.add(pathApplicacion);
		this.DatosDeLaAplicacionAEjecutar[0] = pathApplicacion;

	}

	public void setParametros(String parametrosApplicacion){
		//this.parametrosdeLaAplicacion = parametros;
		this.DatosDeLaAplicacionAEjecutar[1] = parametrosApplicacion;
	}



}//end AbrirAplicacion