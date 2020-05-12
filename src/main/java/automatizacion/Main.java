package automatizacion;

import automatizacion.acciones.ejecutarEXE.AbrirAplicacion;
import automatizacion.ejecuciones.EjecucionParalela;

import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        Tarea abrirChromeTask = new Tarea(new EjecucionParalela());

        AbrirAplicacion abrirChrome = new AbrirAplicacion("Chrome");
        //C:\Program Files (x86)\Google\Chrome\Application\chrome.exe
        abrirChrome.setPath("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        abrirChrome.setParametros("https://www.facebook.com/");

        //mailto:?subject=&body=
        //abrirChrome.setParametros("mailto:?subject=Excel%20To%20JSON%20writed%20in%20Python%203&body=http://lukaneco.blogspot.com/2020/04/excel-to-json-writed-in-python-3.html");

        abrirChromeTask.agregarAccion(abrirChrome);

        EjecutadorDeTareas ejecutador = new EjecutadorDeTareas();
        ejecutador.agregarTarea(abrirChromeTask);



        Timer timer= new Timer(true);


        timer.scheduleAtFixedRate(ejecutador,0,10*1000);


        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

        timer.cancel();
        System.out.println("Termino la ejecucion del hilo y del thread principal");

    }
}
