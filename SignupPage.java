/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;


import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author kavinduamarasinghe
 */
public class SignupPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    public SignupPage() {
        initComponents();
    }
    
    // method to insert values into users table

   public void insertSignupDetails(){
       String name = txt_username.getText();
       String pwd = txt_password.getText();
       String email = txt_email.getText();
       String contact = txt_contact.getText();
       
       try{
           Connection con = DBConnection.getConnection();
           String sql ="INSERT INTO users(name,password,email,contact) values(?,?,?,?)";
           
           PreparedStatement pst = con.prepareStatement(sql);
           
           pst.setString(1, name);
           pst.setString(2, pwd);
           pst.setString(3, email);
           pst.setString(4, contact);
           
           int updatedRowCount = pst.executeUpdate();
           
           
           if(updatedRowCount > 0){
               JOptionPane.showMessageDialog(this, "Record Inserted Successfully");
               Loginpage page = new Loginpage();
               page.setVisible(true);
               dispose();
               
           }else{
               JOptionPane.showMessageDialog(this, "Record Inserted Faild");
           }
           
           
       }catch(Exception e){
           e.printStackTrace();
           
       }
       
   }
   
   // Validation
    public boolean validateSignup(){
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Username");
            return false;
        }
        if(pwd.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Password");
            return false;
        }
        if(email.equals("") || !email.matches("^.+@.+\\..+$")){
            JOptionPane.showMessageDialog(this, "Please enter Valid Email");
            return false;
        }
        if(contact.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Contact No");
            return false;
        }
        
        
        return true;
        
    }
   
    // Cheak duplicate user
    
    public boolean checkDuplicateUser(){
        String name = txt_username.getText();
        boolean isExist = false;
        
        try{
            Connection con= DBConnection.getConnection();
            
            PreparedStatement pst = con.prepareStatement("select * from users where name = ?");
            pst.setString(1, name);
            ResultSet rs =  pst.executeQuery();
            
            if(rs.next()){
                isExist = true;
                
            }else{
                isExist = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
            
        }
        return isExist;
    }
   
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSMaterialButtonCircleBeanInfo1 = new rojerusan.RSMaterialButtonCircleBeanInfo();
        rSMaterialButtonCircleBeanInfo2 = new rojerusan.RSMaterialButtonCircleBeanInfo();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_email = new app.bolivia.swing.JCTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_contact = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Adelle Sans Devanagari", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(220, 95, 0));
        jLabel1.setText("Developer");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 220, 30));

        jLabel3.setFont(new java.awt.Font("Adelle Sans Devanagari", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(55, 58, 64));
        jLabel3.setText("KAVINDU");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 30));

        jLabel5.setFont(new java.awt.Font("STIX Two Text", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(220, 95, 0));
        jLabel5.setText("Nanasa Library");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 220, 40));

        jLabel6.setFont(new java.awt.Font("STIX Two Text", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(55, 58, 64));
        jLabel6.setText("Welcome to");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 220, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup-library-icon.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 840, 710));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 830));

        jPanel2.setBackground(new java.awt.Color(220, 95, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(238, 238, 238));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 50, 40));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(238, 238, 238));
        jLabel9.setText("Create New Account");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 250, 40));

        txt_username.setBackground(new java.awt.Color(220, 95, 0));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_username.setPlaceholder("Enter Username");
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 300, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(238, 238, 238));
        jLabel10.setText("Username");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 250, 40));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(238, 238, 238));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 50, 50));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(238, 238, 238));
        jLabel12.setText("Username:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 250, 40));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(238, 238, 238));
        jLabel13.setText("Password");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 250, 40));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(238, 238, 238));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 50, 50));

        txt_password.setBackground(new java.awt.Color(220, 95, 0));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_password.setPlaceholder("Enter Password");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 300, -1));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(238, 238, 238));
        jLabel15.setText("Email");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 250, 40));

        txt_email.setBackground(new java.awt.Color(220, 95, 0));
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_email.setPlaceholder("Enter Email");
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 300, -1));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(238, 238, 238));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 50, 50));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(238, 238, 238));
        jLabel18.setText("Contact");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 250, 40));

        txt_contact.setBackground(new java.awt.Color(220, 95, 0));
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_contact.setPlaceholder("Enter Contact no...");
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 300, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(55, 58, 64));
        rSMaterialButtonCircle3.setText("LOGIN");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 710, 320, 60));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(154, 3, 30));
        rSMaterialButtonCircle4.setText("SIGNUP");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, 320, 60));

        jLabel16.setFont(new java.awt.Font("STIX Two Math", 1, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(55, 58, 64));
        jLabel16.setText("Signup Page");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 220, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 480, 830));

        setSize(new java.awt.Dimension(1302, 853));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        Loginpage page = new Loginpage();
               page.setVisible(true);
               dispose();
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
       
        if(validateSignup() == true ){
            if(checkDuplicateUser() == false){
                insertSignupDetails();
            }else{
                 JOptionPane.showMessageDialog(this, "Username already exist");
            }
            
        }
        
        
        
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        if(checkDuplicateUser() == true){
            JOptionPane.showMessageDialog(this, "Username already exist");
            
        }
    }//GEN-LAST:event_txt_usernameFocusLost

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSMaterialButtonCircleBeanInfo rSMaterialButtonCircleBeanInfo1;
    private rojerusan.RSMaterialButtonCircleBeanInfo rSMaterialButtonCircleBeanInfo2;
    private app.bolivia.swing.JCTextField txt_contact;
    private app.bolivia.swing.JCTextField txt_email;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
