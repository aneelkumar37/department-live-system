/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

/**
 *
 * @author Dell
 */
import BeanClasses.*;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class TeacherFrame extends javax.swing.JFrame {

    /**
     * Creates new form TeacherFrame
     */
    public TeacherFrame() {
        initComponents();
        getFaculty();
        getTeacher();
        
        java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
    }
    
     private void getFaculty(){
      try {
            Vector v = DatabaseManager.getFaculty();   
            for(int i = 0; i<v.size(); i++){
                this.facultyComboBox.addItem(v.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
     
      private void getTeacher(){
     
       DepartmentBean  bean = (DepartmentBean)this.departmentsComboBox.getSelectedItem();
       if(bean==null)return;
       try {
           int deptId = bean.getDeptId();
            Vector v = DatabaseManager.getTeacher(deptId); 
            teacherNameList.setListData(v);  
        }catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
     } 
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        departmentsComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teacherNameList = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        teacherIdTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fatherNameTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        surNameTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateOfBirthTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        contactNoTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        DesignatonAppointmentTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        dateOfAppointmentTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        currentDesignatonTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JToggleButton();
        backButton = new javax.swing.JToggleButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cNicTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("FACULTY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 130, 30));

        facultyComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        facultyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facultyComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 680, 30));

        departmentsComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        departmentsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentsComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(departmentsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 680, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("TEACHER ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 120, 30));

        teacherNameList.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        teacherNameList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                teacherNameListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(teacherNameList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 100, 350, 630));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 150, 30));

        teacherIdTextField.setEditable(false);
        teacherIdTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(teacherIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 120, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("NAME");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 60, 30));

        nameTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 440, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("FATHER's NAME");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 150, 30));

        fatherNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(fatherNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 440, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("SURNAME");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 160, 30));

        surNameTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(surNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 440, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("DATE OF BRITH");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 150, 40));

        dateOfBirthTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dateOfBirthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOfBirthTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(dateOfBirthTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 150, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("CONTACT NO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 120, 40));

        contactNoTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(contactNoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 150, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("DESIGNATON AT THE TIME OF APPOINTMENT");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 420, 40));

        DesignatonAppointmentTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(DesignatonAppointmentTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, 150, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("DATE OF APPOINTMENT");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 220, 30));

        dateOfAppointmentTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(dateOfAppointmentTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 150, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("TEACHER NAME");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 50, 290, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("REMARKS");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 590, 200, 30));

        currentDesignatonTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(currentDesignatonTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 440, 30));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 620, 670, 110));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("CURRENT DESIGNATON");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 260, 40));

        addButton.setBackground(new java.awt.Color(242, 242, 242));
        addButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 750, 100, 40));

        deleteButton.setBackground(new java.awt.Color(242, 242, 242));
        deleteButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 750, 110, 40));

        updateButton.setBackground(new java.awt.Color(242, 242, 242));
        updateButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 750, 120, 40));

        clearButton.setBackground(new java.awt.Color(242, 242, 242));
        clearButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 750, 120, 40));

        backButton.setBackground(new java.awt.Color(242, 242, 242));
        backButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 750, 180, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setText("TEACHER");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 190, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("CNIC");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 90, 50));

        cNicTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(cNicTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 220, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("EMAIL");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 160, 30));

        emailTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 440, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBoxItemStateChanged
        // TODO add your handling code here:
        FacultyBean selectedBean = (FacultyBean) this.facultyComboBox.getSelectedItem();
        try {
            Vector vec = DatabaseManager.getDepartment(selectedBean.getFacId());
            this.departmentsComboBox.removeAllItems();
            for(int i = 0; i<vec.size(); i++){
                System.out.println(vec.elementAt(i));
                this.departmentsComboBox.addItem(vec.elementAt(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_facultyComboBoxItemStateChanged

    private void departmentsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentsComboBoxItemStateChanged
        // TODO add your handling code here:
         DepartmentBean selectedBean = (DepartmentBean) this.departmentsComboBox.getSelectedItem();        
        if(selectedBean==null)return;     
        try {
                Vector v = DatabaseManager.getTeacher(selectedBean.getDeptId());
                 teacherNameList.setListData(v);
           
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_departmentsComboBoxItemStateChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
       
     DepartmentBean selectedBean = (DepartmentBean) this.departmentsComboBox.getSelectedItem();
      int deptId = selectedBean.getDeptId();
       
       String  name = nameTextField.getText();
       String  fName = fatherNameTextField.getText();
       String surName=surNameTextField.getText();
       String dateOfBirth=dateOfBirthTextField.getText();
       String contactNo=contactNoTextField.getText();
       String detaOfAppointment=dateOfAppointmentTextField.getText();
       String designatonOfAppointment=DesignatonAppointmentTextField.getText();
       String currentDesignaton=currentDesignatonTextField.getText();
       String email = emailTextField.getText(); 
       String remarks = remarksTextArea.getText();       
       String cNic = cNicTextField.getText(); 
       
       try{  
            int row = DatabaseManager.addTeacher(deptId,contactNo,name,fName,surName,dateOfBirth,detaOfAppointment,designatonOfAppointment,currentDesignaton,cNic,email,remarks);
            if(row>0){
                 JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
              getTeacher();
              clearButtonActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
           javax.swing.JOptionPane.showMessageDialog(this,ex.getMessage());
        }
       
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
           TeacherBean  bean = (TeacherBean) teacherNameList.getSelectedValue();  
       if(bean==null)return;
        try {
            
            int row = DatabaseManager.deleteTeacher(bean.getTeacherId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
              getTeacher();
              clearButtonActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
         TeacherBean  bean = (TeacherBean) teacherNameList.getSelectedValue();  
        if(bean==null)return;        
        try {
                 
            String a=(String)this.contactNoTextField.getText();
            String cNic = cNicTextField.getText();
            
                     
            int row = DatabaseManager.updateTeacher(bean.getTeacherId(),a,nameTextField.getText(),fatherNameTextField.getText(),surNameTextField.getText(),dateOfBirthTextField.getText(),dateOfAppointmentTextField.getText(),DesignatonAppointmentTextField.getText(),currentDesignatonTextField.getText(),cNic,emailTextField.getText(),remarksTextArea.getText());
            
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               
               getTeacher();
               clearButtonActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FacultyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        this.teacherIdTextField.setText(" ");
       this.nameTextField.setText(" ");
       this.fatherNameTextField.setText(" ");
       this.surNameTextField.setText(" ");
       this.dateOfBirthTextField.setText(" ");
       this.contactNoTextField.setText(" ");
       this.dateOfAppointmentTextField.setText(" ");
       this.DesignatonAppointmentTextField.setText(" ");
       this.currentDesignatonTextField.setText(" ");
       this.emailTextField.setText("");
       this.cNicTextField.setText("");
       this.remarksTextArea.setText(" ");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.hide();
        
        
    }//GEN-LAST:event_backButtonActionPerformed

    private void teacherNameListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_teacherNameListValueChanged
        // TODO add your handling code here:
         TeacherBean  bean = (TeacherBean) teacherNameList.getSelectedValue();  
       if(bean==null)return;   
       this.teacherIdTextField.setText(""+bean.getTeacherId());
       this.nameTextField.setText(bean.getTeacherName());
       this.fatherNameTextField.setText(bean.getFname());
       this.surNameTextField.setText(bean.getSurName());
       this.dateOfBirthTextField.setText(bean.getDataOfBirth());
       this.contactNoTextField.setText(""+bean.getContactNo());
       this.dateOfAppointmentTextField.setText(bean.getDateOfAppointment());
       this.DesignatonAppointmentTextField.setText(bean.getDesignationAppointment());
       this.currentDesignatonTextField.setText(bean.getCurrentDesignation());
        this.cNicTextField.setText(""+bean.getNic());
        this.emailTextField.setText(bean.getEmail());
       
       this.remarksTextArea.setText(bean.getRemarks());
    }//GEN-LAST:event_teacherNameListValueChanged

    private void dateOfBirthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOfBirthTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOfBirthTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DesignatonAppointmentTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JToggleButton backButton;
    private javax.swing.JTextField cNicTextField;
    private javax.swing.JToggleButton clearButton;
    private javax.swing.JTextField contactNoTextField;
    private javax.swing.JTextField currentDesignatonTextField;
    private javax.swing.JTextField dateOfAppointmentTextField;
    private javax.swing.JTextField dateOfBirthTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentsComboBox;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JTextField fatherNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JTextField surNameTextField;
    private javax.swing.JTextField teacherIdTextField;
    private javax.swing.JList teacherNameList;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
