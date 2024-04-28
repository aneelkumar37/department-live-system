/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;
import BeanClasses.*;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Dell
 */
public class ProgramFrame extends javax.swing.JFrame {
    
    public ProgramFrame() {
        
        initComponents();
        
        getFaculty();
        getDepartment();
        
        java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
    }
    
    private void getFaculty(){
    
        try{ 
            Vector v=DatabaseManager.getFaculty();
            facultyComboBox.removeAllItems();
            
            for(int i=0; i<v.size(); i++){
                
                FacultyBean bean=(FacultyBean)v.elementAt(i);
                facultyComboBox.addItem(bean);
            }
            }catch(Exception e){e.printStackTrace();}
    }
    
    private void getDepartment(){
    
         FacultyBean bean=(FacultyBean)facultyComboBox.getSelectedItem();
        try{ 
           
            Vector v=DatabaseManager.getDepartment(bean.getFacId());
            departmentComboBox.removeAllItems();
            
            for(int i=0; i<v.size(); i++){
                
                DepartmentBean departmentbean=(DepartmentBean)v.elementAt(i);
                departmentComboBox.addItem(departmentbean);
                
            }
            }catch(Exception e){e.printStackTrace();}
    }
    
    private void getProgram(){
        
        DepartmentBean bean=(DepartmentBean)departmentComboBox.getSelectedItem();
        if(bean==null){return;}
        try{
            Vector v=DatabaseManager.getProgram(bean.getDeptId());
            programNameList.setListData(v);
                      
        }catch(Exception e){e.printStackTrace();}
    }
    
     private void addRecord(){
    
        DepartmentBean selectedBean = (DepartmentBean)departmentComboBox.getSelectedItem();
        
        int deptId = selectedBean.getDeptId();
       String progName = programNameTextField.getText();
       String remarks = remarksTextArea.getText();
      
      int progDuration=Integer.parseInt(programDurationInSemesterTextField.getText());
        try {
           int row = DatabaseManager.addProgram(deptId,progName,progDuration,remarks);
       
        if(row>0){
           JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
            getProgram();
            clear();
           }else{
              JOptionPane.showMessageDialog(null,"Something went wrong");
              }
        }catch (Exception ex) {
    Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
      }

 } 
    private void updateRecord(){
      
        ProgramsBean  bean = (ProgramsBean) programNameList.getSelectedValue();  
       
        if(bean==null)return;
        
        try {
             //int row = DatabaseManager.updateFaculty(bean.getFacId());
             
             //(int progId, String progName, String progDuration, String remarks)
                     
            int row = DatabaseManager.updateProgram(bean.getProgId(),programNameTextField.getText(),programDurationInSemesterTextField.getText(),remarksTextArea.getText());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               getProgram();
               clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }  
    
    private void clear(){
    programIdTextField.setText(" ");
    programNameTextField.setText("");
    programDurationInSemesterTextField.setText("");
    remarksTextArea.setText("");
    } 
     
     
      private void deleteRecord(){
      
        ProgramsBean  bean = (ProgramsBean) programNameList.getSelectedValue();  
       if(bean==null)return;
        try {
            
            int row = DatabaseManager.deleteProgram(bean.getProgId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
            getProgram();
            clear();
            
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
   }  
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        programIdTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        programNameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        programDurationInSemesterTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JToggleButton();
        clearButton = new javax.swing.JToggleButton();
        backButton = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        programNameList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("PROGRAM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 200, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("FACULTY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 120, 50));

        facultyComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 780, 50));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("DEPARTMENT");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 170, 50));

        departmentComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 780, 50));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("PROGRAM ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 170, 50));

        programIdTextField.setEditable(false);
        programIdTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        getContentPane().add(programIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 140, 50));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("RROGRAM NAME");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 210, 50));

        programNameTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        programNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programNameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(programNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 780, 50));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("PROGRAM DURATION IN SEMSTER");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 440, 50));

        programDurationInSemesterTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        programDurationInSemesterTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programDurationInSemesterTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(programDurationInSemesterTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 150, 50));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("REMARKS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 130, -1));

        addButton.setBackground(new java.awt.Color(242, 242, 242));
        addButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 710, 160, 70));

        updateButton.setBackground(new java.awt.Color(242, 242, 242));
        updateButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 710, 180, 70));

        deleteButton.setBackground(new java.awt.Color(242, 242, 242));
        deleteButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 710, 180, 70));

        clearButton.setBackground(new java.awt.Color(242, 242, 242));
        clearButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 710, 170, 70));

        backButton.setBackground(new java.awt.Color(242, 242, 242));
        backButton.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 710, 350, 70));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("PROGRAMS NAMES");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, -10, 460, 90));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane3.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 790, 210));

        programNameList.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        programNameList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                programNameListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(programNameList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 360, 620));

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

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
        getProgram();
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
        getDepartment();
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void programDurationInSemesterTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programDurationInSemesterTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programDurationInSemesterTextFieldActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
      //DepartmentBean selectedBean = (FacultyBean) this.departmentComboBox.getSelectedItem();
        addRecord();
      
    }//GEN-LAST:event_addButtonActionPerformed

    private void programNameListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_programNameListValueChanged
        // TODO add your handling code here:
        ProgramsBean  bean = (ProgramsBean) programNameList.getSelectedValue();
        if(bean==null)return;
        
        programIdTextField.setText(""+bean.getProgId());
        programNameTextField.setText(bean.getProgName());
        programDurationInSemesterTextField.setText(""+bean.getProgDuration());
        remarksTextArea.setText(bean.getRemarks());
       
    }//GEN-LAST:event_programNameListValueChanged

    private void programNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programNameTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgramFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JToggleButton backButton;
    private javax.swing.JToggleButton clearButton;
    private javax.swing.JToggleButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField programDurationInSemesterTextField;
    private javax.swing.JTextField programIdTextField;
    private javax.swing.JList programNameList;
    private javax.swing.JTextField programNameTextField;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
