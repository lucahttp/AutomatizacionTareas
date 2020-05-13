
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;

class testAdd{
    public static void main(String args[]){
        String oldDate = "29/01/2017 17:45";
        System.out.println("Date before Addition: "+oldDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar c = Calendar.getInstance();
        try{
            c.setTime(sdf.parse(oldDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        //Incrementing the date by 1 day
        c.add(Calendar.DAY_OF_MONTH, 1);
        String newDate = sdf.format(c.getTime());
        System.out.println("Date Incremented by One: "+newDate);
    }
}