import parsenselib.*;

public class sample_app1{

public static void main(String[] args){
     
     client_apis apis = new client_apis();
     int a = apis.getNumDevices();
     System.out.print ("Returned device: " + a);
}

} 
 
