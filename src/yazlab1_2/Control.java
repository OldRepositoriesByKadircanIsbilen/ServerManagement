
package yazlab1_2;

import java.util.logging.Level;
import java.util.logging.Logger;
import static yazlab1_2.Server.BoosterServers;


public class Control extends Thread {
     Thread ControlThread=new Thread(new Runnable(){
         @Override
    public void run() {
        while(true){
           try {
               CreateThreadAndDelete();
               Thread.sleep(10);
           } catch (InterruptedException ex) {
               Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
           } } } });
     
     public void CreateThreadAndDelete(){
           for (int i = 0; i <BoosterServers.size() ; i++) {
        if(BoosterServers.get(i).getRequest() >= (BoosterServers.get(i).getCapacity()*20)/100){
       int sayi=BoosterServers.size()+3;
       String BoosterServerName="alt sunucu:"+sayi;
       BoosterServers.add(new BoosterServer(BoosterServerName,BoosterServers.get(i).getRequest()/2));
       BoosterServers.get(i).setRequest(BoosterServers.get(i).getRequest()/2);     
       BoosterServers.get(BoosterServers.size()-1).start();   
      } 
       KillThread();      
         }  }
     
     public void KillThread(){
           for (int i = 0; i <BoosterServers.size() ; i++) {
           if ( ((BoosterServers.get(i).getRequest()*100) / BoosterServers.get(i).getCapacity() == 0)  && BoosterServers.size()>2) {
                   System.out.println("toplam sayı:  "+Thread.activeCount());
                  BoosterServers.get(i).deleteControl=false;
                  BoosterServers.remove(i);
                  break;
                 } } }
     
    public void run() {
    ControlThread.start();        
    }
}
