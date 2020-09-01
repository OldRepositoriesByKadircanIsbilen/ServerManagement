
package yazlab1_2;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server extends Thread  {
    private String ServerName;
    private int Capacity;
    public static int MainRequest;
    private int RequestTime;
    private int ReplyTime;
    public static ArrayList<BoosterServer> BoosterServers=new ArrayList<BoosterServer>();
    Random random=new Random();
   
    public Server(){
        this.ServerName="Main Server";
        this.Capacity=10000;
        this.MainRequest=200;
        this.RequestTime=500;
        this.ReplyTime=200;
    }

    @Override
    public void run() {
       RequestThread.start();
       ReplyThread.start();
       }

    Thread RequestThread=new Thread(new Runnable(){
         @Override
    public void run() {
       while(true){
           try {
                int eklenecek=1+random.nextInt(100);
                if(MainRequest+eklenecek<Capacity && MainRequest+eklenecek>-1){
                  MainRequest+=eklenecek; 
                 Thread.sleep(RequestTime);
                }  } catch (InterruptedException ex) {
               Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
           } } } });
    
    
       Thread ReplyThread=new Thread(new Runnable(){
         @Override
    public void run() {
       while(true){
           try {
                int yanit=1+random.nextInt(50);
                 if(MainRequest <=1 && (MainRequest-yanit)<=0){      }
                   else{
                     MainRequest-=yanit;
                     for (int i = 0; i < yanit; i++) {
                    Thread.sleep(200); 
               }   }  
           } catch (InterruptedException ex) {
               Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
           } } } });
      
    public String getServerName() {
        return ServerName;
    }

    public void setServerName(String ServerName) {
        this.ServerName = ServerName;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }

    public int getMainRequest() {
        return MainRequest;
    }

    public void setMainRequest(int MainRequest) {
        this.MainRequest = MainRequest;
    }

    public int getRequestTime() {
        return RequestTime;
    }

    public void setRequestTime(int RequestTime) {
        this.RequestTime = RequestTime;
    }

    public int getReplyTime() {
        return ReplyTime;
    }

    public void setReplyTime(int ReplyTime) {
        this.ReplyTime = ReplyTime;
    }

    public static ArrayList<BoosterServer> getBoosterServer() {
        return BoosterServers;
    }

    public static void setBoosterServer(ArrayList<BoosterServer> BoosterServers) {
        Server.BoosterServers = BoosterServers;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
    
    
    
    
}
