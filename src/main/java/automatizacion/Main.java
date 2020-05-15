package automatizacion;

import automatizacion.acciones.ejecutarEXE.AbrirAplicacion;
import automatizacion.acciones.email.AdapterEmailSender;
import automatizacion.acciones.email.AdapterJavaMail;
import automatizacion.acciones.email.EnviarMail;
import automatizacion.acciones.email.emailContent.Email;
import automatizacion.ejecuciones.EjecucionParalela;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        /*
        Tarea Google Chrome
         */

        Tarea abrirChromeTask = new Tarea(new EjecucionParalela());

        AbrirAplicacion abrirChrome = new AbrirAplicacion("Chrome");
        //C:\Program Files (x86)\Google\Chrome\Application\chrome.exe
        abrirChrome.setPath("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        abrirChrome.setParametros("https://www.facebook.com/");

        //mailto:?subject=&body=
        //abrirChrome.setParametros("mailto:?subject=Excel%20To%20JSON%20writed%20in%20Python%203&body=http://lukaneco.blogspot.com/2020/04/excel-to-json-writed-in-python-3.html");

        abrirChromeTask.agregarAccion(abrirChrome);

        /*
        Tarea Google Chrome
         */




        /*
        Tarea Google Chrome
         */

        Tarea enviarEmailTask = new Tarea(new EjecucionParalela());


        Email contenidoEmail = new Email();

        AdapterEmailSender javaMailApi = new AdapterJavaMail();

        EnviarMail enviarEmail = new EnviarMail(javaMailApi,contenidoEmail);



        //mailto:?subject=&body=
        //abrirChrome.setParametros("mailto:?subject=Excel%20To%20JSON%20writed%20in%20Python%203&body=http://lukaneco.blogspot.com/2020/04/excel-to-json-writed-in-python-3.html");

        enviarEmailTask.agregarAccion(enviarEmail);

        /*
        Tarea Google Chrome
         */



        EjecutadorDeTareas ejecutador = new EjecutadorDeTareas();
        ejecutador.agregarTarea(abrirChromeTask);
        ejecutador.agregarTarea(enviarEmailTask);



        Timer timer= new Timer(true);



        String fechaEnLaQueQuieroQueSeEjecute = "";


        //System.out.println("diferencia" + gg);

        //la Tarea se ejecuta pasado 5 segundos y luego periodicamente cada segundo

        long delayParaEjecutar = diferenciaEnMilis("14/05/2020","22:45");

        long perdiodoParaEjecutar =10*1000;
        //perdiodoParaEjecutar = 0;

        //timer.scheduleAtFixedRate(ejecutador,delayParaEjecutar,perdiodoParaEjecutar);
        Date myFecha = Date.from(Instant.now());

        System.out.println(myFecha);
        //timer.schedule(ejecutador,delayParaEjecutar);
        //timer.schedule(ejecutador,delayParaEjecutar);



        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

        timer.cancel();
        System.out.println("Termino la ejecucion del hilo y del thread principal");

    }


    public static long diferenciaEnMilis(String fecha, String hora){
        //Integer resultado = 0;
        long resultado = 0;
        try {
            String format = "dd/MM/yyyy HH:mm";

            SimpleDateFormat sdf = new SimpleDateFormat(format);

            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
            //String date3 = "07/15/2016";
            //String time3 = "11:00 AM";
            //System.out.println("the current date and time: "+ timeStamp);
            //Date dateObj1 = sdf.parse(Fecha1 + " " + Hora1);
            Date dateObj1 = sdf.parse(timeStamp);


            Date dateObj2 = sdf.parse(fecha + " " + hora);
            //System.out.println(dateObj1);
            //System.out.println(dateObj2 + "\n");
            DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");
            //long diff = dateObj2.getTime() - dateObj1.getTime();
            resultado = dateObj2.getTime() - dateObj1.getTime();

            System.out.println("difference between milliseconds: " + crunchifyFormatter.format(resultado));




        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultado;
    }


}
