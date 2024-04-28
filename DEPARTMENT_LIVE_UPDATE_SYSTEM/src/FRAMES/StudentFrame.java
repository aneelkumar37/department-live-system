/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.*;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import EncoderDecoder.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class StudentFrame extends javax.swing.JFrame {

    /**
     * Creates new form Student
     */
    public StudentFrame() {
        initComponents();
        
        getFaculty();
        
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
            if(bean==null)return;
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
           if(bean==null)return;
            try{
                Vector v=DatabaseManager.getProgram(bean.getDeptId());
                programComboBox.removeAllItems();
            
                for(int i=0; i<v.size(); i++){
                
                    ProgramsBean programbean=(ProgramsBean)v.elementAt(i);
                    programComboBox.addItem(programbean);
                }
            }catch(Exception e){e.printStackTrace();}
        }
        private void getBatch(){
    
           ProgramsBean bean=(ProgramsBean)programComboBox.getSelectedItem();
           if(bean==null)return; 
           try{
                Vector v=DatabaseManager.getBatch(bean.getProgId());
                batchYearComboBox.removeAllItems();
            
                for(int i=0; i<v.size(); i++){
                
                    BatchBean batchbean=(BatchBean)v.elementAt(i);
                    batchYearComboBox.addItem(batchbean);
                }
            }catch(Exception e){e.printStackTrace();}
        }
        
      private void getStudent(){
        
        BatchBean bean=(BatchBean)batchYearComboBox.getSelectedItem();
        if(bean==null){return;}
        try{
            Vector v=DatabaseManager.getStudent(bean.getBatchId());
            rollNoList.setListData(v);
            
        }catch(Exception e){e.printStackTrace();}
    }
    
    
     private void addRecord(){
    
     BatchBean selectedBean = (BatchBean) batchYearComboBox.getSelectedItem();
        
       int batchId = selectedBean.getBatchId();
       String  name = nameTextField.getText();
       String  fName = fatherNameTextField.getText();
       String surName=surNameTextField.getText();
       String rollNo=rollNoTextField.getText();
       String remarks = remarksTextArea.getText();
       
        
        try {
            int row = DatabaseManager.addStudent(batchId,name,fName,surName,rollNo,remarks);
            
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
           getStudent();
           clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
      private void deleteRecord(){
      
        StudentsBean  bean = (StudentsBean ) rollNoList.getSelectedValue();  
       if(bean==null)return;
        try {
            
            int row = DatabaseManager.deleteStudent(bean.getStudId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
                getStudent();
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
           ex.printStackTrace();
        }
   }  
      
      
      private void updateRecord(){
        StudentsBean  bean = (StudentsBean) rollNoList.getSelectedValue();
        if(bean==null)return;
        try {
                        
            int row = DatabaseManager.updateStudent(bean.getStudId(),nameTextField.getText(),fatherNameTextField.getText(),surNameTextField.getText(),rollNoTextField.getText(),remarksTextArea.getText());
            
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               getStudent();
               clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    
 }//end of updateRecord  
    
      private void clear(){
       studentIdTextField.setText("");
       nameTextField.setText("");
       fatherNameTextField.setText("");
       surNameTextField.setText("");
       rollNoTextField.setText("");
       remarksTextArea.setText("");
      
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
        programComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        batchYearComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        studentIdTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fatherNameTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        surNameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rollNoTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        rollNoList = new javax.swing.JList();
        jLabel14 = new javax.swing.JLabel();
        addButton1 = new javax.swing.JButton();
        updateButton1 = new javax.swing.JButton();
        deleteButton1 = new javax.swing.JToggleButton();
        clearButton1 = new javax.swing.JToggleButton();
        backButton1 = new javax.swing.JToggleButton();
        shiftComboBox = new javax.swing.JComboBox();
        groupComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 180, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("FACULTY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 130, 40));

        facultyComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 820, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("DEPARTMENT");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 170, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 820, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText(" PROGRAM");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 150, 40));

        programComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 820, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("BATCH YEAR");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 160, 20));

        batchYearComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        batchYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchYearComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(batchYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 230, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("SHIFT");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 70, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GROUP");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 100, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("STUDENT ID");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 160, 40));

        studentIdTextField.setEditable(false);
        studentIdTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        studentIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIdTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(studentIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 230, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setText("NAME");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 80, 40));

        nameTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 500, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setText("FATHER's NAME");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 200, 40));

        fatherNameTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        getContentPane().add(fatherNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 500, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setText("SURNAME");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 130, 40));

        surNameTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        getContentPane().add(surNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 500, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setText("ROLL-NO");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 120, 40));

        rollNoTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        rollNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollNoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(rollNoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 500, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setText("REMARKS");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 120, 20));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 820, 140));

        rollNoList.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        rollNoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                rollNoListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(rollNoList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 50, 330, 640));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ROLL NO");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, -10, 320, 80));

        addButton1.setBackground(new java.awt.Color(242, 242, 242));
        addButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        addButton1.setText("ADD");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(addButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 710, 140, 70));

        updateButton1.setBackground(new java.awt.Color(242, 242, 242));
        updateButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        updateButton1.setText("UPDATE");
        updateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 710, 150, 70));

        deleteButton1.setBackground(new java.awt.Color(242, 242, 242));
        deleteButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        deleteButton1.setText("DELETE");
        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 710, 140, 70));

        clearButton1.setBackground(new java.awt.Color(242, 242, 242));
        clearButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        clearButton1.setText("CLEAR");
        clearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 710, 140, 70));

        backButton1.setBackground(new java.awt.Color(242, 242, 242));
        backButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        backButton1.setText("BACK");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(backButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 710, 330, 70));

        shiftComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MORNING", "EVENING" }));
        shiftComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(shiftComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 210, 40));

        groupComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MEDICAL ", "ENGINEERING", "COMMERCE ", "GENERAL" }));
        getContentPane().add(groupComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 230, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
        getBatch();
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void rollNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rollNoTextFieldActionPerformed

    private void updateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1ActionPerformed
        // TODO add your handling code here:
        updateRecord();
    }//GEN-LAST:event_updateButton1ActionPerformed

    private void clearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButton1ActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_backButton1ActionPerformed

    private void studentIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIdTextFieldActionPerformed

    private void batchYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchYearComboBoxActionPerformed
        // TODO add your handling code here:
         BatchBean selectedBean = (BatchBean) this.batchYearComboBox.getSelectedItem();         
        if(selectedBean==null)return;     
          shiftComboBox.setSelectedItem(EncoderDecoder.Decoder.shiftDecode(selectedBean.getShift()));
        groupComboBox.setSelectedItem(EncoderDecoder.Decoder.groupDecode(selectedBean.getGroupDes()));
        
        getStudent();
    }//GEN-LAST:event_batchYearComboBoxActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        // TODO add your handling code here:
        addRecord();
    }//GEN-LAST:event_addButton1ActionPerformed

    private void rollNoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_rollNoListValueChanged
        // TODO add your handling code here:
       
       StudentsBean  bean = (StudentsBean) rollNoList.getSelectedValue(); 
       if(bean==null)return;
       
       studentIdTextField.setText(""+bean.getStudId());
       nameTextField.setText(bean.getStudName());
       fatherNameTextField.setText(bean.getFname());
       surNameTextField.setText(bean.getSurName());
       rollNoTextField.setText(bean.getRollNo());
       remarksTextArea.setText(bean.getRemarks());
       
       BatchBean beans = (BatchBean) batchYearComboBox.getSelectedItem();
       
       shiftComboBox.setSelectedItem(EncoderDecoder.Decoder.shiftDecode(beans.getShift()));
       groupComboBox.setSelectedItem(EncoderDecoder.Decoder.groupDecode(beans.getGroupDes()));
       
//       ImageIcon icon =new ImageIcon("D:\\Picture\\"+bean.getStudId()+".jpg");
//       
//       picLabel.setIcon(icon);
//       
//       new ImageIcon("picture\\"+bean.getStudId()+".jpg");
       
    }//GEN-LAST:event_rollNoListValueChanged

    private void shiftComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftComboBoxActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_shiftComboBoxActionPerformed

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
        getDepartment();
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
        getProgram();
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton1;
    private javax.swing.JToggleButton backButton1;
    private javax.swing.JComboBox batchYearComboBox;
    private javax.swing.JToggleButton clearButton1;
    private javax.swing.JToggleButton deleteButton1;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JTextField fatherNameTextField;
    private javax.swing.JComboBox<String> groupComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JList rollNoList;
    private javax.swing.JTextField rollNoTextField;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JTextField studentIdTextField;
    private javax.swing.JTextField surNameTextField;
    private javax.swing.JButton updateButton1;
    // End of variables declaration//GEN-END:variables
}
