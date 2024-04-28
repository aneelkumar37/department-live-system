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
import BeanClasses.SeatListDetailBean;
import BeanClasses.StudentsBean;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan Hyder
 */
public class SeatListDetailFrame extends javax.swing.JFrame {

    /**
     * Creates new form SeatListDetailFrame
     */
    public SeatListDetailFrame() {
        
        initComponents();
        getFaculty();
        //getSeatList();
        //getPart();
        //getSeatListDetails();
        
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
    
    private void getPart(){
        
           BatchBean bean=(BatchBean)batchYearComboBox.getSelectedItem();
           if(bean==null)return;
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
                examYearComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SeatListBean slbean=(SeatListBean)v.elementAt(i);
                    examYearComboBox.addItem(slbean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getsealList
        
        
        
        
        
        
        
        private void getSeatListDetails(){
        
        SeatListBean bean=(SeatListBean)examYearComboBox.getSelectedItem();
        if(bean==null){return;}
        try{
            Vector v=DatabaseManager.getSeatListDetail(bean.getSeatListId());
            rollNoList.setListData(v);
                      
        }catch(Exception e){e.printStackTrace();}
    }//end of getSeatListDetails
        
        private void addRecord(){
            
            SeatListBean selectedBean = (SeatListBean)examYearComboBox.getSelectedItem();
            //int slId=selectedBean.getSeatListId();
            int batchId = selectedBean.getBatchId();
            PartBean Bean = (PartBean)partComboBox.getSelectedItem();
            int part = Bean.getPart();
            //String part =(String)partComboBox.getSelectedItem();
            String rollNo =(String)rollNoTextField.getText();
            String status =(String) statusComboBox.getSelectedItem();
            String remarks = remarksTextArea.getText();
            //int p=Integer.parseInt(part);
        try {
            int row = DatabaseManager.addSeatListDetails(selectedBean.getSeatListId(),rollNo,status,selectedBean.getBatchId(),part,remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
            getSeatListDetails();
            //clear();
            }else{
                JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG");
            }
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//end of addRecords
        
         private void updateRecord(){
       SeatListDetailBean  bean = (SeatListDetailBean)rollNoList.getSelectedValue();
       String status=(String) statusComboBox.getSelectedItem();
       BatchBean beanBatch=(BatchBean)batchYearComboBox.getSelectedItem();
       PartBean partBean=(PartBean)partComboBox.getSelectedItem();
       //PartBean part=(PartBean)partComboBox.getSelectedItem();
       int p=partBean.getPart();
       if(bean==null)return;        
        try {        
            int row = DatabaseManager.updateSeatListDetail(bean.getRollNo(),p,beanBatch.getBatchId(),status,remarksTextArea.getText());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               getSeatList();
               //clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception e){
            
           e.printStackTrace();
        }
    }//end of updateSeatList
         
        

        
        private void deleteRecord(){
        SeatListDetailBean  bean = (SeatListDetailBean)rollNoList.getSelectedValue();  
        if(bean==null)return;
        try {
            int row = DatabaseManager.deleteSeatListDetails(bean.getSeatListId(),bean.getBatchId(),bean.getPart(),bean.getRollNo());
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
    }//end of deleterecord
        
        
 private void clear(){
    rollNoTextField.setText(" ");
     remarksTextArea.setText(" ");
    
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
        jLabel3 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        examYearComboBox = new javax.swing.JComboBox();
        batchYearComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox();
        examTypeTextField = new javax.swing.JTextField();
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
        rollNoList = new javax.swing.JList();
        jLabel16 = new javax.swing.JLabel();
        partComboBox = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        rollNoTextField = new javax.swing.JTextField();
        shiftTextField = new javax.swing.JTextField();
        groupTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SEAT LIST DETAIL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-330, 10, 1960, 60));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("FACULTY");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 130, 40));

        facultyComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 790, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 790, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 180, 40));

        programComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 790, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("PROGRAM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 140, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PART");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 110, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GROUP");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 130, 40));

        examYearComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        examYearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                examYearComboBoxItemStateChanged(evt);
            }
        });
        examYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examYearComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(examYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 220, 40));

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
        getContentPane().add(batchYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 220, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("BATCH YEAR");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 170, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SHIFT");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 130, 40));

        statusComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TEMPORARY", "LEGAL" }));
        getContentPane().add(statusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 390, 40));

        examTypeTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        examTypeTextField.setEnabled(false);
        getContentPane().add(examTypeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 390, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setText("REMARKS");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 130, 60));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("EXAM TYPE");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 180, 40));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 790, 200));

        addButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 710, 160, 70));

        updateButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 710, 160, 70));

        deleteButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 710, 160, 70));

        clearButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 710, 160, 70));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 710, 320, 70));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setText("STATUS");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 120, 40));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("ROLL NO");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 320, 60));

        rollNoList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        rollNoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                rollNoListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(rollNoList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 90, 320, 610));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel16.setText("ROLL NO");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 130, 40));

        partComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        partComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(partComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 220, 40));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("EXAM YEAR");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 180, 40));

        rollNoTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        getContentPane().add(rollNoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 220, 40));

        shiftTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        shiftTextField.setEnabled(false);
        getContentPane().add(shiftTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 160, 40));

        groupTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupTextField.setEnabled(false);
        getContentPane().add(groupTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 200, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        //getPart();
       // getSeatList();
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

    private void rollNoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_rollNoListValueChanged
        // TODO add your handling code here:
        SeatListDetailBean bean =(SeatListDetailBean)rollNoList.getSelectedValue();
        
        if(bean==null)return;
        
        batchYearComboBox.setSelectedItem(bean.getBatchId());
        partComboBox.setSelectedItem(bean.getPart());
        examYearComboBox.setSelectedItem(bean.getSeatListId());
        rollNoTextField.setText(bean.getRollNo());
        statusComboBox.setSelectedItem(bean.getStatus());
        remarksTextArea.setText(bean.getRemarks());
        
    }//GEN-LAST:event_rollNoListValueChanged

    private void examYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_examYearComboBoxItemStateChanged
        // TODO add your handling code here:
        SeatListBean bean=(SeatListBean)examYearComboBox.getSelectedItem();
        if(bean==null)return;
        examTypeTextField.setText(bean.getType());
        
    }//GEN-LAST:event_examYearComboBoxItemStateChanged

    private void examYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examYearComboBoxActionPerformed
        // TODO add your handling code here:
        getSeatListDetails();
    }//GEN-LAST:event_examYearComboBoxActionPerformed

    private void partComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partComboBoxActionPerformed
        // TODO add your handling code here:
        getSeatList();
    }//GEN-LAST:event_partComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(SeatListDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeatListDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeatListDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeatListDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeatListDetailFrame().setVisible(true);
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
    private javax.swing.JTextField examTypeTextField;
    private javax.swing.JComboBox examYearComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JTextField groupTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox partComboBox;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JList rollNoList;
    private javax.swing.JTextField rollNoTextField;
    private javax.swing.JTextField shiftTextField;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
