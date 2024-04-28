/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.*;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import javax.swing.JOptionPane;


public class DepartmentFrame extends javax.swing.JFrame {

    public DepartmentFrame() {
        initComponents();
        
        getFaculty();
        
        
        java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
        
        
    }//end of DepartmentFrame constructor
    
    private void getFaculty(){   
        try{
            Vector v=DatabaseManager.getFaculty();
            facultyComboBox.removeAllItems();
            
            for(int i=0; i<v.size(); i++){
                
                FacultyBean bean=(FacultyBean)v.elementAt(i);
                facultyComboBox.addItem(bean);
            }
            
        }catch(Exception e){e.printStackTrace();}
    }//end of getFaculty
    
    private void getDepartment(){
        
        FacultyBean bean=(FacultyBean)facultyComboBox.getSelectedItem();
        if(bean==null){return;}
        try{
            Vector v=DatabaseManager.getDepartment(bean.getFacId());
            departmentNameList.setListData(v);
            
        }catch(Exception e){e.printStackTrace();}
    }//end of getDepartment
    
     private void addRecord(){
    
     FacultyBean selectedBean = (FacultyBean)facultyComboBox.getSelectedItem();
        
        int facId = selectedBean.getFacId();
        String deptName = departmentNameTextField.getText();
        String remarks = remarksTextArea.getText();
                  
        try {
            int row = DatabaseManager.addDepartment(facId,deptName, remarks);
            
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
            getDepartment();
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//end of addRecord
     
    private void clear(){
        
        departmentIDTextField.setText("");
        departmentNameTextField.setText("");
        remarksTextArea.setText("");
    }//end of clear
    
    private void updateRecord(){
      
        DepartmentBean  bean = (DepartmentBean) departmentNameList.getSelectedValue();  
       
        if(bean==null)return;
        
        try {
            int row = DatabaseManager.updateDepartment(bean.getDeptId(),departmentNameTextField.getText(),remarksTextArea.getText());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               clear();
               getDepartment();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//end of updateRecord
    
    private void deleteRecord(){
      
        DepartmentBean  bean = (DepartmentBean) departmentNameList.getSelectedValue();  
       if(bean==null)return;
        try {
            
            int row = DatabaseManager.deleteDepartment(bean.getDeptId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
            getDepartment();
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   }//end of deleteRecord
          
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        departmentLabel = new javax.swing.JLabel();
        facultyLabel = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        departmentIdLabel = new javax.swing.JLabel();
        departmentIDTextField = new javax.swing.JTextField();
        departmentNameLabel = new javax.swing.JLabel();
        departmentNameTextField = new javax.swing.JTextField();
        remarksLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JToggleButton();
        backButton = new javax.swing.JToggleButton();
        departmentNamesLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        departmentNameList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        departmentLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        departmentLabel.setText("DEPARTMENT");
        departmentLabel.setToolTipText("");
        getContentPane().add(departmentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 260, 38));

        facultyLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyLabel.setText("FACULTY");
        getContentPane().add(facultyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 130, 50));

        facultyComboBox.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        facultyComboBox.setToolTipText("");
        facultyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facultyComboBoxItemStateChanged(evt);
            }
        });
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 750, 50));

        departmentIdLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentIdLabel.setText("DEPARTMENT ID");
        getContentPane().add(departmentIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 210, 40));

        departmentIDTextField.setEditable(false);
        departmentIDTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        departmentIDTextField.setToolTipText("");
        getContentPane().add(departmentIDTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 170, 50));

        departmentNameLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentNameLabel.setText("DEPARTMENT NAME");
        getContentPane().add(departmentNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 250, 50));

        departmentNameTextField.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        departmentNameTextField.setToolTipText("");
        getContentPane().add(departmentNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 750, 50));

        remarksLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 140, 50));

        jScrollPane1.setToolTipText("");

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 750, 330));

        addButton.setBackground(new java.awt.Color(242, 242, 242));
        addButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 730, 150, 70));

        deleteButton.setBackground(new java.awt.Color(242, 242, 242));
        deleteButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 730, 150, 70));

        updateButton.setBackground(new java.awt.Color(242, 242, 242));
        updateButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 730, -1, 70));

        clearButton.setBackground(new java.awt.Color(242, 242, 242));
        clearButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 730, 150, 70));

        backButton.setBackground(new java.awt.Color(242, 242, 242));
        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 730, 310, 80));

        departmentNamesLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        departmentNamesLabel.setText("DEPARTMENT NAMES");
        getContentPane().add(departmentNamesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, 270, 30));

        jScrollPane3.setToolTipText("");

        departmentNameList.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        departmentNameList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                departmentNameListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(departmentNameList);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 120, 310, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        updateRecord();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
        getDepartment();
        
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        addRecord();    
    }//GEN-LAST:event_addButtonActionPerformed

    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_facultyComboBoxItemStateChanged

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
         deleteRecord();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void departmentNameListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_departmentNameListValueChanged
        // TODO add your handling code here:
          DepartmentBean  bean = (DepartmentBean) departmentNameList.getSelectedValue();
          
          if(bean==null)return;
          departmentIDTextField.setText(""+bean.getDeptId());
          departmentNameTextField.setText(bean.getDeptName());
          remarksTextArea.setText(bean.getRemarks());
        
    }//GEN-LAST:event_departmentNameListValueChanged

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DepartmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JToggleButton backButton;
    private javax.swing.JToggleButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField departmentIDTextField;
    private javax.swing.JLabel departmentIdLabel;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JLabel departmentNameLabel;
    private javax.swing.JList departmentNameList;
    private javax.swing.JTextField departmentNameTextField;
    private javax.swing.JLabel departmentNamesLabel;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    //private void initComponents() {
  //      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
