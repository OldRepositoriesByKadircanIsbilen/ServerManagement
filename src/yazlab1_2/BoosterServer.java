
package yazlab1_2;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static yazlab1_2.Server.BoosterServers;
import static yazlab1_2.Server.MainRequest;


public class BoosterServer extends Thread{
   
   private String BoosterServerName;
    private int Capacity;
    private int Request;
    private int RequestTime;
    private int ReplyTime;
    Random random=new Random();
    public boolean deleteControl=true;
   
    public BoosterServer(String BoosterServerName){
        this.BoosterServerName="";
        this.Capacity=5000;
        this.Request=0;
        this.RequestTime=400;
        this.ReplyTime=150;
    }

    public BoosterServer(String BoosterServerName, int Request){
        this.BoosterServerName="";
        this.Capacity=5000;
        this.Request=Request;
        this.RequestTime=500;
        this.ReplyTime=300;
    }
 
      Thread BoosterReplyThread=new Thread(new Runnable(){
         @Override
    public void run() {
       while(true){
           try {
    if(deleteControl==true){
               int yanit=1+random.nextInt(50);
                 if(Request <= 0 || (Request-yanit)<=0){ }
                 else{
                     for (int i = 0; i < yanit; i++) {
                       Thread.sleep(200);  }
                     //for döngüsünden çıkarılabilir
                  Request-=yanit; 
               } }
              } catch (InterruptedException ex) {
               Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
           } } } });
      
    Thread BoosterRequestThread=new Thread(new Runnable(){
         @Override
    public synchronized void run() {
       while(true){
           try {
               if(deleteControl==true){
                 int eklenecek=1+random.nextInt(100);
                  if(eklenecek<MainRequest){ 
                   MainRequest-=eklenecek; 
                   Request=Request+eklenecek;
                         } 
               Thread.sleep(RequestTime);   
               }
           } catch (InterruptedException ex) {
               Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
           } } } });
    
    public void run() {
            BoosterRequestThread.start();
            BoosterReplyThread.start();        
    }

    public String getBoosterServerName(int sayi) {
         String BoosterServerName="Alt Sunucu:"+sayi;
        return BoosterServerName;
    }

    public void setBoosterServerName(String BoosterServerName) {
        this.BoosterServerName = BoosterServerName;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }

    public int getRequest() {
        return Request;
    }

    public void setRequest(int Request) {
        this.Request = Request;
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

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Thread getRequestThread() {
        return BoosterRequestThread;
    }

    public void setRequestThread(Thread RequestThread) {
        this.BoosterRequestThread = RequestThread;
    }

    public Thread getBoosterReplyThread() {
        return BoosterReplyThread;
    }

    public void setBoosterReplyThread(Thread BoosterReplyThread) {
        this.BoosterReplyThread = BoosterReplyThread;
    }

   
    
    
}
