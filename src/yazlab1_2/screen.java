package yazlab1_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import static yazlab1_2.Server.BoosterServers;

public class screen extends javax.swing.JFrame implements ActionListener {
    Control ControlThread=new Control();
    Server mainServer = new Server();
    BoosterServer boosterServer1 = new BoosterServer("");
    BoosterServer boosterServer2 = new BoosterServer("");
    DefaultTableModel server_model;
    Timer timer = new Timer(200, this);

    public screen() throws InterruptedException {
        initComponents();
        timer.start();
        mainServer.start();
        boosterServer1.start();
        boosterServer2.start();
        ControlThread.start();
        BoosterServers.add( boosterServer1);
        BoosterServers.add(boosterServer2);
        server_model = (DefaultTableModel) table.getModel();
    }

    public void setServerNumber() {
        int alt_sunucu = 1;
        if (mainServer.BoosterServers != null) {
            alt_sunucu += BoosterServers.size();
        }
        String number = "Toplam Sunucu Sayısı:  " + alt_sunucu;
        txt.setText(number);
    }
    public void updateServerTable() {
        server_model.setRowCount(0);
        ArrayList<BoosterServer> arrayThread = new ArrayList<>();
        ArrayList<BoosterServer> main = mainServer.BoosterServers;
        int main_istek_yuzde = (100 * mainServer.getMainRequest()) / mainServer.getCapacity();
        Object[] main_eklenecek = new Object[]{mainServer.getServerName(), mainServer.getMainRequest(), mainServer.getCapacity(), main_istek_yuzde};
        server_model.addRow(main_eklenecek);
        if (main != null) {
            for (BoosterServer i : main) {
             arrayThread.add(i);
                 }  }
        if (arrayThread != null) {
            int sayi = 0;
            for (BoosterServer i : arrayThread) {
                sayi++;
                int istek_yuzde = (100 * i.getRequest()) / i.getCapacity();
                Object[] eklenecek = new Object[]{i.getBoosterServerName(sayi), i.getRequest(), i.getCapacity(), istek_yuzde};
                server_model.addRow(eklenecek);
            }    } 
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Server Name", "Request Number", "Capacity", "Percent"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
                

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
         screen Screen;
        try {
            Screen = new screen();
             Screen.setVisible(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(screen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
       updateServerTable();
       setServerNumber();
    
    }

}
