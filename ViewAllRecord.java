/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.*;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jframe.DBConnection.con;

/**
 *
 * @author kavinduamarasinghe
 */
public class ViewAllRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllRecord
     */
    
    DefaultTableModel model;
    
    public ViewAllRecord() {
        initComponents();
        setIssueBookDetailsToTable();
    }

    public void setIssueBookDetailsToTable(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details");
            
            while(rs.next()){
                String Id = rs.getString("id");
                String BookName = rs.getString("book_name");
                String StudentName = rs.getString("student_name");
                String IssueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                
                
                Object[] obj = {Id,BookName,StudentName,IssueDate,dueDate,status};
                model = (DefaultTableModel)tbl_ViewAllRecords.getModel();
                model.addRow(obj);
            }
           
            
            
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        
    }
    
    //  method to Clear table
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_ViewAllRecords.getModel();
        model.setRowCount(0);
    }
    
    // to fetch the Record using data fields
    
    public void search(){
        Date uFromDate = date_fromDate.getDatoFecha();
        Date uToDate = date_toDate.getDatoFecha();
        
        long l1 = uFromDate.getTime();
        long l2 = uToDate.getTime();
        
        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);
        
        try{
            
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
             
             
             String sql = "select * from issue_book_details where issue_date BETWEEN ? and ?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setDate(1, fromDate);
             pst.setDate(2, toDate);
           
            ResultSet rs = pst.executeQuery();
            
            
            if(rs.next() == false){
                JOptionPane.showMessageDialog(this,"No Record Found");
            }else{
            
            while(rs.next()){
                
                String Id = rs.getString("id");
                String BookName = rs.getString("book_name");
                String StudentName = rs.getString("student_name");
                String IssueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                
                
                Object[] obj = {Id,BookName,StudentName,IssueDate,dueDate,status};
                model = (DefaultTableModel)tbl_ViewAllRecords.getModel();
                model.addRow(obj);
                
            }
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        panel_table = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_ViewAllRecords = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(220, 95, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(55, 58, 64));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText(" View All Record");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, 110));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Issue Date :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 110, 40));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Issue Date :");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 110, 40));

        date_toDate.setColorBackground(new java.awt.Color(104, 109, 118));
        date_toDate.setColorForeground(new java.awt.Color(104, 109, 118));
        date_toDate.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        date_toDate.setPlaceholder("Select Due Date");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 280, 40));

        date_fromDate.setColorBackground(new java.awt.Color(104, 109, 118));
        date_fromDate.setColorForeground(new java.awt.Color(104, 109, 118));
        date_fromDate.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        date_fromDate.setPlaceholder("Select Issue Date");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 280, 40));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(154, 3, 30));
        rSMaterialButtonCircle1.setText("ALL");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 210, 160, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(55, 58, 64));
        rSMaterialButtonCircle2.setText("SEARCH");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 210, 160, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 350));

        panel_table.setBackground(new java.awt.Color(255, 255, 255));
        panel_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_ViewAllRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_ViewAllRecords.setColorBackgoundHead(new java.awt.Color(220, 95, 0));
        tbl_ViewAllRecords.setColorBordeFilas(new java.awt.Color(204, 204, 204));
        tbl_ViewAllRecords.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbl_ViewAllRecords.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_ViewAllRecords.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_ViewAllRecords.setColorSelBackgound(new java.awt.Color(220, 95, 0));
        tbl_ViewAllRecords.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 24)); // NOI18N
        tbl_ViewAllRecords.setFuenteFilas(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_ViewAllRecords.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tbl_ViewAllRecords.setFuenteHead(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tbl_ViewAllRecords.setRowHeight(40);
        tbl_ViewAllRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ViewAllRecordsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_ViewAllRecords);

        panel_table.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 1160, 370));

        getContentPane().add(panel_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 1440, 570));

        setSize(new java.awt.Dimension(1440, 942));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tbl_ViewAllRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ViewAllRecordsMouseClicked

        
    }//GEN-LAST:event_tbl_ViewAllRecordsMouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        
        clearTable();
        setIssueBookDetailsToTable();
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       if(date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha() != null){
            clearTable();
            search();
       } 
       else{
          JOptionPane.showMessageDialog(this,"Please Select Date.."); 
       }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel_table;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojeru_san.complementos.RSTableMetro tbl_ViewAllRecords;
    // End of variables declaration//GEN-END:variables
}
