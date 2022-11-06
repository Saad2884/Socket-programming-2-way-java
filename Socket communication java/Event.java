import java.util.ArrayList;
// import org.json.simple.JSONObject; 

public class Event {
    public String date;
    public String time;
    public String des;


//     JSONObject obj=new JSONObject();    
//   obj.put("name","sonoo");    
//   obj.put("age",new Integer(27));    
//   obj.put("salary",new Double(600000));    
//    System.out.print(obj);



    ArrayList<String> DATE = new ArrayList<String>();
    ArrayList<String> TIME = new ArrayList<String>();
    ArrayList<String> DESCRIPTION = new ArrayList<String>();

    public Event(String date, String time, String des){
        this.date = date;
        this.time = time;
        this.des = des;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }

    public String getDescription(){
        return des;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setTime(String time){
        this.time = time;
    }

    public void setDescription(String des){
        this.des = des;
    }
}
