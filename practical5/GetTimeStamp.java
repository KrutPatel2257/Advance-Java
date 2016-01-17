// Date() = Constructs a Date object using current date and time
//method SimpleDateFormat.format() formats the object into String of the pattern "MM/dd/yyyy HH:mm:ss"
//SimpleDateFormat is a concrete class for formatting and parsing dates in a locale-sensitive manner

import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;

public class GetTimeStamp {
	
    public String get(){
        java.util.Date date= new java.util.Date();
        String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
        return timeStamp;
    }
}