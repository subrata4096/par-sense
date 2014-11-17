package purdue.crowdsense;

public class HBRecvUpdate{


public class HBRecv implements Runnable{

 private final BlockingQueue sharedQueue;

}

public class Update extends Thread{

	Update(){
		super("Update");
	}
	public void run(){
		for (;;) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
 
                synchronized(data){
                Iterator it = data.iterator();
                while (it.hasNext())
                    it.next();
                }
}


}

	public void 


}
