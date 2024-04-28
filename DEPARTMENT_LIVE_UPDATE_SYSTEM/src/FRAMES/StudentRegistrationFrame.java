/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.*;
import DatabaseManager.DatabaseManager;
import java.util.*;
import java.util.Vector.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan Hyder
 */
public class StudentRegistrationFrame extends javax.swing.JFrame {
    /**
     * Creates new form StudentRegistrationFrame
     */
    public StudentRegistrationFrame() {
        initComponents();
        
        getFaculty();
        getStudentPart();
        
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
        }//end of getFaculty
    
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
    }//end of getDepartment
    
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
        }//end of getProgram
    
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
        }//end of getBatch
    
    
    private void getStudent(){
    
           BatchBean bean=(BatchBean)batchYearComboBox.getSelectedItem();
           if(bean==null)return;
           try{
                Vector v=DatabaseManager.getStudent(bean.getBatchId());
                studentsComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    StudentsBean studentbean=(StudentsBean)v.elementAt(i);
                    studentsComboBox.addItem(studentbean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getStduent
    
    private void getStudentPart(){
        
        BatchBean bean=(BatchBean)batchYearComboBox.getSelectedItem();
        if(bean==null){return;}
        try{
            Vector v=DatabaseManager.getStudentPart(bean.getBatchId());
            rollNoList.setListData(v);
                      
        }catch(Exception e){e.printStackTrace();}
    }//end of StudentPart()

    
    private void addRecord(){
       BatchBean selectedBean = (BatchBean)batchYearComboBox.getSelectedItem();
        int batchId = selectedBean.getBatchId();
        //PartBean part =(PartBean) partComboBox.getSelectedItem(); 
        String part =(String)partComboBox.getSelectedItem(); 
        StudentsBean rollNo =(StudentsBean) studentsComboBox.getSelectedItem();
        String status =(String) statusComboBox.getSelectedItem();
        String remarks = remarksTextArea.getText();
        int p=Integer.parseInt(part);
        
        try {
            int row = DatabaseManager.addStudentPart(batchId,p,rollNo.getRollNo(),status,remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
            getStudentPart();
            //clear();
            }else{
                JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG");
            }
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//end of addStudentPart

private void updateRecord(){
    
       StudentPartBean  bean = (StudentPartBean)rollNoList.getSelectedValue();
       BatchBean beanBatch=(BatchBean)batchYearComboBox.getSelectedItem();
       String part=(String)partComboBox.getSelectedItem();
       int p=Integer.parseInt(part);
       
       StudentsBean studBean=(StudentsBean)studentsComboBox.getSelectedItem();
        
        if(bean==null)return;        
        try {        
            int row = DatabaseManager.updateStudentPart(bean.getBatchId(),p,studBean.getRollNo(),remarksTextArea.getText());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               getStudentPart();
               //clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception e){
            
           e.printStackTrace();
        }
    }//end of updateStudentPart

private void deleteRecord(){
        StudentPartBean  bean = (StudentPartBean) rollNoList.getSelectedValue();  
        if(bean==null)return;
        try {
            int row = DatabaseManager.deleteStudentPart(bean.getPart());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
              getStudentPart();     
            //clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception e) {
           e.printStackTrace();
        }
    }//end of deletePart

private void pasteRecord(){
    String part =(String)partComboBox.getSelectedItem();
    StudentsBean rollNo =(StudentsBean) studentsComboBox.getSelectedItem();
    int p=Integer.parseInt(part);
    String partBean =(String)partComboBox.getSelectedItem();
    if(partBean==null)return;
    int rows=0;
    int count=studentsComboBox.getItemCount();
    for(int i=0;i<count;i++){
       // StudentsBean stdBean=(StudentsBean)studentsComboBox.elementAt
       StudentsBean stdBean=(StudentsBean)studentsComboBox.getItemAt(i); 
       try {
            rows+=DatabaseManager.addStudentPart(stdBean.getBatchId(),p,stdBean.getRollNo(),"TEMPORARAY","Auto Paste");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     if(rows>0){
                JOptionPane.showMessageDialog(null,rows + "RECORD ADDED SUCCESSFULLY");
            getStudentPart();
            //clear();
            }else{
                JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG");
            }
    
}//end of PasteRecord
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
        programComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        studentsComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        partComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        groupComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        batchYearComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        shiftComboBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        rollNoList = new javax.swing.JList();
        jLabel12 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        pasteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT REGISTRATION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("STATUS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, -1, 40));

        programComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 880, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("FACULTY");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 50));

        facultyComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 880, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 170, 50));

        departmentComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 880, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("PROGRAM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 130, 50));

        studentsComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        studentsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studentsComboBoxItemStateChanged(evt);
            }
        });
        studentsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(studentsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 250, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("REMARKS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 140, 40));

        partComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        partComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        partComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(partComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 100, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PARTS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 90, 40));

        groupComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GENERAL", "ENGINEERING", "MEDICAL", "COMMERCE" }));
        getContentPane().add(groupComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 250, 190, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("BATCH YEAR");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 160, 50));

        batchYearComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        batchYearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchYearComboBoxItemStateChanged(evt);
            }
        });
        batchYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchYearComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(batchYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 170, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("SHIFT");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 90, 40));

        shiftComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MORNING", "EVENING" }));
        getContentPane().add(shiftComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 180, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ROLL NO");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 450, 60));

        statusComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TEMPORARY", "PERMANENT" }));
        getContentPane().add(statusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 330, -1, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setText("STUDENTS");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 140, 50));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 880, 270));

        rollNoList.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        rollNoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                rollNoListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(rollNoList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 100, 320, 590));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GROUP");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, 90, 40));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 700, 320, 80));

        addButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 710, 150, 70));

        updateButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 710, 150, 70));

        deleteButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 710, 150, 70));

        clearButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        clearButton.setText("CLEAR");
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 710, 150, 70));

        pasteButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        pasteButton.setText("PASTE");
        pasteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pasteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 710, 150, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        addRecord();
    }//GEN-LAST:event_addButtonActionPerformed

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
        getDepartment();
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
        getProgram();
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
        getBatch();
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void batchYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchYearComboBoxActionPerformed
        // TODO add your handling code here:
       getStudent();
    }//GEN-LAST:event_batchYearComboBoxActionPerformed

    private void studentsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_studentsComboBoxItemStateChanged
//        // TODO add your handling code here:

    }//GEN-LAST:event_studentsComboBoxItemStateChanged

    private void rollNoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_rollNoListValueChanged
        // TODO add your handling code here:
        StudentPartBean bean=(StudentPartBean)rollNoList.getSelectedValue();
        
        if(bean==null)return;
        batchYearComboBox.setSelectedItem(bean.getBatchId());
        studentsComboBox.setSelectedItem(bean.getRollNo());
        partComboBox.setSelectedItem(bean.getPart());
        statusComboBox.setSelectedItem(bean.getStatus());
        remarksTextArea.setText(bean.getRemarks());
        
        
        BatchBean beans=(BatchBean)batchYearComboBox.getSelectedItem();
        shiftComboBox.setSelectedItem(EncoderDecoder.Decoder.shiftDecode(beans.getShift()));
        groupComboBox.setSelectedItem(EncoderDecoder.Decoder.groupDecode(beans.getGroupDes()));
    }//GEN-LAST:event_rollNoListValueChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        updateRecord();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void pasteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteButtonActionPerformed
        // TODO add your handling code here:
        pasteRecord();
    }//GEN-LAST:event_pasteButtonActionPerformed

    private void studentsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentsComboBoxActionPerformed

    private void partComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partComboBoxActionPerformed
        // TODO add your handling code here:
        getStudentPart();
    }//GEN-LAST:event_partComboBoxActionPerformed

    private void batchYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchYearComboBoxItemStateChanged
        // TODO add your handling code here:
        
        BatchBean beans=(BatchBean)batchYearComboBox.getSelectedItem();
        shiftComboBox.setSelectedItem(EncoderDecoder.Decoder.shiftDecode(beans.getShift()));
        groupComboBox.setSelectedItem(EncoderDecoder.Decoder.groupDecode(beans.getGroupDes()));
        
    }//GEN-LAST:event_batchYearComboBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(StudentRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRegistrationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox batchYearComboBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JComboBox partComboBox;
    private javax.swing.JButton pasteButton;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JList rollNoList;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JComboBox studentsComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
