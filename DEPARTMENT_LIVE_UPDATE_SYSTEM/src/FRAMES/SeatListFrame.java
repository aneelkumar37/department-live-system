/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.BatchBean;
import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.PartBean;
import BeanClasses.ProgramsBean;
import BeanClasses.SeatListBean;
import BeanClasses.StudentPartBean;
import BeanClasses.StudentsBean;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan Hyder
 */
public class SeatListFrame extends javax.swing.JFrame {

    /**
     * Creates new form SeatListFrame
     */
    public SeatListFrame() {
        initComponents();
        getFaculty();   
 //    getSeatList();
        
        
        java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        setBounds(0,0,d.width,d.height);
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
        
       
    
    private void getPart(){
        
           BatchBean bean=(BatchBean)batchYearComboBox.getSelectedItem();
            try{
                Vector v=DatabaseManager.getPart(bean.getBatchId());
                partComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    PartBean partbean=(PartBean)v.elementAt(i);
                    partComboBox.addItem(partbean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getPart
    
        private void getSeatList(){
        BatchBean bean=(BatchBean)batchYearComboBox.getSelectedItem();
        PartBean partBean=(PartBean)partComboBox.getSelectedItem();
        if(bean==null || partBean==null){return;}
        try{
            Vector v=DatabaseManager.getSeatList(bean.getBatchId(),partBean.getPart());
            examYearList.setListData(v);
        }catch(Exception e){e.printStackTrace();}
    }//end of SeatList
        
            
    private void clear(){
   seatListIdTextField.setText("");
   seatListYearTextField.setText("");
    remarksTextArea.setText("");
    }
        
       private void addRecord(){
        BatchBean selectedBean = (BatchBean)batchYearComboBox.getSelectedItem();
        if(selectedBean==null)return;
    //  PartBean part=(PartBean)partComboBox.getSelectedItem();
        int batchId = selectedBean.getBatchId();
        PartBean part=(PartBean)partComboBox.getSelectedItem();
        if(part==null)return;      
// String part =(String)partComboBox.getSelectedItem();
        int p=Integer.parseInt(""+part.getPart());
        String slYear =(String)seatListYearTextField.getText();
        int seatListYear=Integer.parseInt(slYear);
        
        String type =(String)seatListTypeComboBox.getSelectedItem();
        String remarks = remarksTextArea.getText();
        
        try {
            int row = DatabaseManager.addSeatList(batchId,p,seatListYear,type,remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
            getSeatList();
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG");
            }
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//end of addSeatListYear
        
        private void updateRecord(){
       SeatListBean  bean = (SeatListBean)examYearList.getSelectedValue();
       BatchBean beanBatch=(BatchBean)batchYearComboBox.getSelectedItem();
        PartBean part=(PartBean)partComboBox.getSelectedItem();
        int p=Integer.parseInt(""+part.getPart());
        String slyear =(String)seatListYearTextField.getText();
        int seatListYear=Integer.parseInt(slyear);
        String type=(String)seatListTypeComboBox.getSelectedItem();
        if(bean==null || beanBatch==null)return;        
        try {        
            int row = DatabaseManager.updateSeatList(bean.getSeatListId(),seatListYear,type,remarksTextArea.getText());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               getSeatList();
               clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception e){
            
           e.printStackTrace();
        }
    }//end of updateSeatList
        
        private void deleteRecord(){
        SeatListBean  bean = (SeatListBean) examYearList.getSelectedValue();  
        if(bean==null)return;
        try {
            int row = DatabaseManager.deleteSeatList(bean.getSeatListId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
              getSeatList();     
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception e) {
           e.printStackTrace();
        }
    }//end of deleteseatList
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        partComboBox = new javax.swing.JComboBox();
        batchYearComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        seatListTypeComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        seatListIdTextField = new javax.swing.JTextField();
        shiftTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        examYearList = new javax.swing.JList();
        seatListYearTextField = new javax.swing.JTextField();
        groupTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SEAT LIST");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-270, 10, 1920, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("FACULTY");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 130, 40));

        facultyComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
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
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 740, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 740, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 180, 40));

        programComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 740, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("PROGRAM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 150, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PART");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 110, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GROUP");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 110, 40));

        partComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        partComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                partComboBoxItemStateChanged(evt);
            }
        });
        partComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(partComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 180, 40));

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
        getContentPane().add(batchYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 180, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("BATCH YEAR");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 170, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SHIFT");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 80, 40));

        seatListTypeComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        seatListTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "REGULAR", "IMPROVER", "FAILURE" }));
        getContentPane().add(seatListTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, 340, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("SEAT LIST ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 170, 40));

        seatListIdTextField.setEditable(false);
        seatListIdTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        getContentPane().add(seatListIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 160, 40));

        shiftTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        shiftTextField.setEnabled(false);
        getContentPane().add(shiftTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 150, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setText("REMARKS");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 130, 50));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setText("SEAT LIST YEAR");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 210, 40));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 730, 190));

        addButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 720, 140, 60));

        updateButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 720, 140, 60));

        deleteButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 720, 140, 60));

        clearButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 720, 140, 60));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 720, 330, 60));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setText("SEAT LIST TYPE");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 210, 40));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("EXAM YEAR");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 60, 450, 60));

        examYearList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        examYearList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                examYearListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(examYearList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 120, 330, 590));

        seatListYearTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        getContentPane().add(seatListYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 160, 40));

        groupTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupTextField.setEnabled(false);
        getContentPane().add(groupTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, 160, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void batchYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchYearComboBoxItemStateChanged
        // TODO add your handling code here:
        
        BatchBean beans=(BatchBean)batchYearComboBox.getSelectedItem();
        if(beans==null)return;
        shiftTextField.setText(EncoderDecoder.Decoder.shiftDecode(beans.getShift()));
        groupTextField.setText(EncoderDecoder.Decoder.groupDecode(beans.getGroupDes()));
       getPart();
    }//GEN-LAST:event_batchYearComboBoxItemStateChanged

    private void batchYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchYearComboBoxActionPerformed
        // TODO add your handling code here:
       // getPart();
    }//GEN-LAST:event_batchYearComboBoxActionPerformed

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

    private void examYearListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_examYearListValueChanged
        // TODO add your handling code here:
        SeatListBean bean=(SeatListBean)examYearList.getSelectedValue();
        if(bean==null)return;
        seatListIdTextField.setText(""+bean.getSeatListId());
        seatListYearTextField.setText(""+bean.getSeatListYear());
        shiftTextField.setText(""+bean.getSeatListYear());
        seatListTypeComboBox.setSelectedItem(bean.getType());
        remarksTextArea.setText(bean.getRemarks());
        
        BatchBean beans=(BatchBean)batchYearComboBox.getSelectedItem();
        if(beans==null)return;
        shiftTextField.setText(EncoderDecoder.Decoder.shiftDecode(beans.getShift()));
        groupTextField.setText(EncoderDecoder.Decoder.groupDecode(beans.getGroupDes()));
        
    }//GEN-LAST:event_examYearListValueChanged

    private void partComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partComboBoxActionPerformed
        // TODO add your handling code here:
        getSeatList();
    }//GEN-LAST:event_partComboBoxActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void partComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_partComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_partComboBoxItemStateChanged

    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_facultyComboBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(SeatListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeatListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeatListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeatListFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeatListFrame().setVisible(true);
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
    private javax.swing.JList examYearList;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JTextField groupTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox partComboBox;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JTextField seatListIdTextField;
    private javax.swing.JComboBox seatListTypeComboBox;
    private javax.swing.JTextField seatListYearTextField;
    private javax.swing.JTextField shiftTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
