
import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import javax.swing.JOptionPane;import javax.swing.UIManager;
/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */
/** * * @author osha7 */public class Authentication extends javax.swing.JFrame {Connection conn;ResultSet rs;PreparedStatement pst;    /**     * Creates new form Authentication     */    public Authentication() {        super("Login");        initComponents();        conn=javaconnect.ConnectDb();    }
    /**     * This method is called from within the constructor to initialize the form.     * WARNING: Do NOT modify this code. The content of this method is always     * regenerated by the Form Editor.     */    @SuppressWarnings("unchecked")    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();        jTextField2 = new javax.swing.JTextField();        jLabel1 = new javax.swing.JLabel();        jLabel2 = new javax.swing.JLabel();        jButton1 = new javax.swing.JButton();        jLabel3 = new javax.swing.JLabel();        jTextField1 = new javax.swing.JTextField();        jButton2 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 321, 230, -1));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Banking-System-Project.jpg"))); // NOI18N        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 622, 211));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N        jLabel2.setText("Enter Account no.");        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 275, -1, -1));
        jButton1.setText("Login");        jButton1.addActionListener(new java.awt.event.ActionListener() {            public void actionPerformed(java.awt.event.ActionEvent evt) {                jButton1ActionPerformed(evt);            }        });        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 359, -1, -1));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N        jLabel3.setText("Pin");        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 317, -1, -1));        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 279, 230, -1));
        jButton2.setText("Signup");        jButton2.addActionListener(new java.awt.event.ActionListener() {            public void actionPerformed(java.awt.event.ActionEvent evt) {                jButton2ActionPerformed(evt);            }        });        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 359, -1, -1));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());        getContentPane().setLayout(layout);        layout.setHorizontalGroup(            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)            .addGroup(layout.createSequentialGroup()                .addContainerGap()                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))        );        layout.setVerticalGroup(            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)            .addGroup(layout.createSequentialGroup()                .addContainerGap()                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)                .addContainerGap())        );
        setSize(new java.awt.Dimension(670, 466));        setLocationRelativeTo(null);    }// </editor-fold>//GEN-END:initComponents
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed        // TODO add your handling code here:        setVisible(false);        Account ob=new Account();        ob.setVisible(true);    }//GEN-LAST:event_jButton2ActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed        // TODO add your handling code here:        String sql="select * from Account where Acc=? and Pin=?";        try{            pst=conn.prepareStatement(sql);            pst.setString(1, jTextField1.getText());            pst.setString(2, jTextField2.getText());            rs=pst.executeQuery();            if(rs.next()){                setVisible(false);                Loading ob=new Loading();                ob.setUpLoading();                ob.setVisible(true);                rs.close();                pst.close();            }            else{                JOptionPane.showMessageDialog(null, "Incorrect Credential");            }        }catch(Exception e){            JOptionPane.showMessageDialog(null, e);        }finally{            try{                rs.close();                pst.close();            }catch(Exception e){
            }        }    }//GEN-LAST:event_jButton1ActionPerformed
    /**     * @param args the command line arguments     */    public static void main(String args[]) {        /* Set the Nimbus look and feel */        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html          */        try {            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {              /*  if ("Nimbus".equals(info.getName())) {                    javax.swing.UIManager.setLookAndFeel(info.getClassName());                    break; */                UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");            }        } catch (ClassNotFoundException ex) {            java.util.logging.Logger.getLogger(Authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);        } catch (InstantiationException ex) {            java.util.logging.Logger.getLogger(Authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);        } catch (IllegalAccessException ex) {            java.util.logging.Logger.getLogger(Authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);        } catch (javax.swing.UnsupportedLookAndFeelException ex) {            java.util.logging.Logger.getLogger(Authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);        }        //</editor-fold>
        /* Create and display the form */        java.awt.EventQueue.invokeLater(new Runnable() {            public void run() {                new Authentication().setVisible(true);            }        });    }
    // Variables declaration - do not modify//GEN-BEGIN:variables    private javax.swing.JButton jButton1;    private javax.swing.JButton jButton2;    private javax.swing.JLabel jLabel1;    private javax.swing.JLabel jLabel2;    private javax.swing.JLabel jLabel3;    private javax.swing.JPanel jPanel1;    private javax.swing.JTextField jTextField1;    private javax.swing.JTextField jTextField2;    // End of variables declaration//GEN-END:variables}
