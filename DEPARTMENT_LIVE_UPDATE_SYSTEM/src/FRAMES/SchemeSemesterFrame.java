/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.ProgramsBean;
import BeanClasses.SchemeBean;
import BeanClasses.SchemePartBean;
import BeanClasses.SchemeSemesterBean;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan Hyder
 */
public class SchemeSemesterFrame extends javax.swing.JFrame {

    /**
     * Creates new form SchemeSemesterFrame
     */
    public SchemeSemesterFrame() {
        initComponents();
        
        getFaculty();
        //getSchemePart();
       // getSchemeSemester();
        
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
    
        private void getScheme(){
            ProgramsBean bean=(ProgramsBean)programComboBox.getSelectedItem();
            if(bean==null)return;
            try{
                Vector v=DatabaseManager.getScheme(bean.getProgId());
                schemeYearComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SchemeBean schemebean=(SchemeBean)v.elementAt(i);
                    schemeYearComboBox.addItem(schemebean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getScheme
        
        private void getSchemePart(){
            SchemeBean bean=(SchemeBean)schemeYearComboBox.getSelectedItem();
            if(bean==null)return;
            try{
                Vector v=DatabaseManager.getSchemePart(bean.getSchemeId());
                schemePartComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SchemePartBean spbean=(SchemePartBean)v.elementAt(i);
                    schemePartComboBox.addItem(spbean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getSchemePart
        
        private void getSchemeSemester(){
            
            //SchemeBean bean=(SchemeBean)schemeYearComboBox.getSelectedItem();
            SchemePartBean bean=(SchemePartBean)schemePartComboBox.getSelectedItem();
            if(bean==null){return;}
            try{
                Vector v=DatabaseManager.getSchemeSemester(bean.getSchemePart(),bean.getSchemeId());
                semesterList.setListData(v);
            }catch(Exception e){e.printStackTrace();}
        }//end of getSchemeSemester
        
        private void clear(){
            semesterTextField.setText("");
            remarksTextArea.setText(" ");
    }//end of clear
    
     private void addRecord(){
         
        SchemeBean bean = (SchemeBean)schemeYearComboBox.getSelectedItem();
        if(bean==null)return;
        int schemeId = bean.getSchemeId();
        SchemePartBean  sp=(SchemePartBean) schemePartComboBox.getSelectedItem();
        int schemePart =sp.getSchemePart();
        String sem=(String)semesterTextField.getText();
        int semester=Integer.parseInt(sem);
        String remarks = remarksTextArea.getText();
  
        try {
            int row = DatabaseManager.addSchemeSemester(schemeId,schemePart,semester,remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
           getSchemeSemester();
           clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }//end of addRecord
     
     
     private void updateRecord(){
    
        SchemeBean bean = (SchemeBean) this.schemeYearComboBox.getSelectedItem();
        if(bean==null)return;
        int scId = bean.getSchemeId();
         SchemePartBean Bean = (SchemePartBean)schemePartComboBox.getSelectedItem();
        if(bean==null)return;
        int part = Bean.getSchemePart();
        
        String sm =(String) semesterTextField.getText();
        int semester =Integer.parseInt(sm);
        String remarks = remarksTextArea.getText();
        //String semester = schemeSemesterTextField.setText();
        try {
            int row = DatabaseManager.updateSchemeSemester(scId,part,semester,remarks);
            
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
           getSchemeSemester();
        clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
    }//updateRecord
     
    private void deleteRecord() {
    SchemeBean bean = (SchemeBean) this.schemeYearComboBox.getSelectedItem();
    if (bean == null) return;
    int scId = bean.getSchemeId();
    
    SchemePartBean partBean = (SchemePartBean) schemePartComboBox.getSelectedItem();
    if (partBean == null) return;
    int part = partBean.getSchemePart();

    String sm = (String) semesterTextField.getText();
    int semester = Integer.parseInt(sm);

    try {
        int row = DatabaseManager.deleteSchemeSemester(scId, part, semester);

        if (row > 0) {
            JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
            getSchemeSemester();
            clear();
        } else {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }

    } catch (Exception ex) {
        ex.printStackTrace();

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

        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        semesterList = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        facultyComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        schemeYearComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        groupTextField = new javax.swing.JTextField();
        schemePartComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        semesterTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 700, 160, 60));

        updateButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 700, 160, 60));

        deleteButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 700, 160, 60));

        clearButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 700, 160, 60));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 700, 330, 60));

        semesterList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        semesterList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                semesterListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(semesterList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, 330, 570));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SEMESTER");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 450, 50));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SCHEME SEMESTER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-230, 20, 1920, 60));

        programComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 750, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("PROGRAM");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 180, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 750, 40));

        facultyComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 750, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("FACULTY");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 130, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setText("SCHEME YEAR");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 190, 40));

        schemeYearComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        schemeYearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                schemeYearComboBoxItemStateChanged(evt);
            }
        });
        schemeYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schemeYearComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(schemeYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 200, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("GROUP");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 180, 40));

        groupTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupTextField.setEnabled(false);
        getContentPane().add(groupTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 270, 40));

        schemePartComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        schemePartComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schemePartComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(schemePartComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 200, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("SEMESTER");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 150, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setText("SCHEME PART");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 190, 40));

        semesterTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        semesterTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(semesterTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 200, 40));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 750, 240));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("REMARKS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 190, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        addRecord();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        updateRecord();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void semesterListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_semesterListValueChanged
        // TODO add your handling code here:
        SchemeSemesterBean bean=(SchemeSemesterBean)semesterList.getSelectedValue();
        if(bean==null)return;
        
        schemePartComboBox.setSelectedItem(bean.getPartScheme());
        semesterTextField.setText(""+bean.getSemester());
        remarksTextArea.setText(bean.getRemarks());
        
    }//GEN-LAST:event_semesterListValueChanged

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
       getScheme();
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
        getProgram();
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
        getDepartment();
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void schemeYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_schemeYearComboBoxItemStateChanged
        // TODO add your handling code here:
        SchemeBean bean=(SchemeBean)schemeYearComboBox.getSelectedItem();
        if(bean==null)return;
        groupTextField.setText(EncoderDecoder.Decoder.groupDecode(bean.getGroupDes()));
    }//GEN-LAST:event_schemeYearComboBoxItemStateChanged

    private void semesterTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterTextFieldActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void schemeYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemeYearComboBoxActionPerformed
        // TODO add your handling code here:
        getSchemePart();
    }//GEN-LAST:event_schemeYearComboBoxActionPerformed

    private void schemePartComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemePartComboBoxActionPerformed
        // TODO add your handling code here:
        getSchemeSemester();
    }//GEN-LAST:event_schemePartComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(SchemeSemesterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchemeSemesterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchemeSemesterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchemeSemesterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchemeSemesterFrame().setVisible(true);
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
    private javax.swing.JTextField groupTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JComboBox schemePartComboBox;
    javax.swing.JComboBox schemeYearComboBox;
    private javax.swing.JList semesterList;
    private javax.swing.JTextField semesterTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
