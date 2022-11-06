public class getEx {
    public String getException(String[] i) throws IncorrectActionException 
    {
        if(!i[0].equals("add") || i[0].equals("remove") || i[0].equals("stop")){
            throw new IncorrectActionException("incorrect action");
        }
        else{
            return "";
        }
    }
}
