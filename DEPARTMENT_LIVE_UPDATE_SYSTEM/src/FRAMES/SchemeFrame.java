/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.BatchBean;
import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.ProgramsBean;
import BeanClasses.SchemeBean;
import BeanClasses.StudentPartBean;
import BeanClasses.StudentsBean;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan Hyder
 */
public class SchemeFrame extends javax.swing.JFrame {

    /**
     * Creates new form SchemeFrame
     */
    public SchemeFrame() {
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
            }catch(Exception ex){
             ex.printStackTrace();
            // javax.swing.JOptionPane.showMessageDialog(this,"Error: "+ex);
            }
        }//end of getFaculty
        
        private void getDepartment(){
            FacultyBean bean=(FacultyBean)facultyComboBox.getSelectedItem();
            try{
                Vector v=DatabaseManager.getDepartment(bean.getFacId());
                departmentComboBox.removeAllItems();
            
                for(int i=0; i<v.size(); i++){
                
                    DepartmentBean departmentbean=(DepartmentBean)v.elementAt(i);
                    departmentComboBox.addItem(departmentbean);
                }
            }catch(Exception ex){
            ex.printStackTrace();
             javax.swing.JOptionPane.showMessageDialog(this,"Error: "+ex);
            }
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
            }catch(Exception ex){
            ex.printStackTrace();
             javax.swing.JOptionPane.showMessageDialog(this,"Error: "+ex);
            }
        }//end of getProgram
    
    private void getScheme(){
        ProgramsBean bean=(ProgramsBean)programComboBox.getSelectedItem();
        if(bean==null){return;}
        try{
            Vector v=DatabaseManager.getScheme(bean.getProgId());
            schemeYearList.setListData(v);
        }catch(Exception ex){
             javax.swing.JOptionPane.showMessageDialog(this,"Error: "+ex);
            ex.printStackTrace();
        }
    }//end of getScheme
    
    private void clear(){
        schemeIdTextField.setText("");
        schemeYearTextField.setText("");
        miniMarksTextField.setText("");
        remarksTextArea.setText("");
    }//end of clear
    
    private void addRecord(){
       ProgramsBean bean = (ProgramsBean)programComboBox.getSelectedItem();
        int progId = bean.getProgId();
        String sY=schemeYearTextField.getText();
        int schemeYear=Integer.parseInt(sY);
        String  groupDes=(String) groupComboBox.getSelectedItem();
        String marks=miniMarksTextField.getText();
        int miniMarks=Integer.parseInt(marks);
        String remarks = remarksTextArea.getText();
        try {
            int row = DatabaseManager.addScheme(progId,schemeYear,groupDes,miniMarks,remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
            getScheme();
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG");
            }
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//end of addScheme
    
    private void updateRecord(){
    
       SchemeBean  bean = (SchemeBean)schemeYearList.getSelectedValue();
       String sY=schemeYearTextField.getText();
        int schemeYear=Integer.parseInt(sY);
        String  groupDes=(String) groupComboBox.getSelectedItem();
        String marks=miniMarksTextField.getText();
        int miniMarks=Integer.parseInt(marks);
        String remarks = remarksTextArea.getText();
       if(bean==null)return;
       try {        
            int row = DatabaseManager.updateScheme(bean.getSchemeId(),schemeYear,groupDes,miniMarks,remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               getScheme();
               clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception e){
           e.printStackTrace();
        }
    }//end of updateScheme
    
    private void deleteRecord(){
        SchemeBean  bean = (SchemeBean)schemeYearList.getSelectedValue();  
        if(bean==null)return;
        try {
            int row = DatabaseManager.deleteScheme(bean.getSchemeId(),bean.getProgId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
              getScheme();     
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception e) {
           e.printStackTrace();
        }
    }//end of deleteScheme
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        schemeYearTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        schemeIdTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        groupComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        miniMarksTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        schemeYearList = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SCHEME");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-360, 10, 1920, -1));

        programComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 710, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("FACULTY");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 130, 40));

        facultyComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 710, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 180, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 710, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REMARKS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 120, 50));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("PROGRAM");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 140, 40));

        schemeYearTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        getContentPane().add(schemeYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 160, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("SCHEME ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 150, 40));

        schemeIdTextField.setEditable(false);
        schemeIdTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        getContentPane().add(schemeIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 160, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("MINIMUM MARKS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 220, 40));

        groupComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GENERAL ", "MEDICAL", "ENGINEERING", "COMMERCE" }));
        getContentPane().add(groupComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 250, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setText("SCHEME YEAR");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 190, 40));

        miniMarksTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        getContentPane().add(miniMarksTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 160, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("GROUP");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 180, 60));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 710, 270));

        schemeYearList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        schemeYearList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                schemeYearListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(schemeYearList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 380, 620));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SCHEME YEAR");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 480, 40));

        clearButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 710, 160, 60));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 710, 380, 60));

        deleteButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 710, 160, 60));

        updateButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 710, 160, 60));

        addButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 710, 160, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
        getScheme();
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
        getDepartment();
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
        getProgram();
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void schemeYearListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_schemeYearListValueChanged
        // TODO add your handling code here:
        SchemeBean selectedBean =(SchemeBean)schemeYearList.getSelectedValue();
        
        if(selectedBean==null)return;
        schemeIdTextField.setText(""+selectedBean.getSchemeId());
        schemeYearTextField.setText(""+selectedBean.getSchemeYear());
        groupComboBox.setSelectedItem(""+selectedBean.getGroupDes());
        miniMarksTextField.setText(""+selectedBean.getMiniMarks());
        remarksTextArea.setText(""+selectedBean.getRemaks());
        groupComboBox.setSelectedItem(EncoderDecoder.Decoder.groupDecode(selectedBean.getGroupDes()));
    }//GEN-LAST:event_schemeYearListValueChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        updateRecord();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        addRecord();
    }//GEN-LAST:event_addButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SchemeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchemeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchemeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchemeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchemeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField miniMarksTextField;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JTextField schemeIdTextField;
    private javax.swing.JList schemeYearList;
    private javax.swing.JTextField schemeYearTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
