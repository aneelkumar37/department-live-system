
package FRAMES;


import BeanClasses.*;
import DatabaseManager.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PartFrame extends javax.swing.JFrame {

    public PartFrame() {
        initComponents();
        
        getFaculty();
         java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        setBounds(0,0,d.width,d.height);
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
        //PartBean partbean=(PartBean)partComboBox.getSelectedItem();
        if(bean==null){return;}
        try{
            Vector v=DatabaseManager.getPart(bean.getBatchId());
            partsList.setListData(v);
            
        }catch(Exception e){e.printStackTrace();}
    }//end of getPart
    
    private void clear(){
        
        partYearTextField.setText("");
        remarksTextArea.setText(" ");
    }//end of clear
    
    
    private void addRecord(){
       BatchBean selectedBean = (BatchBean)batchYearComboBox.getSelectedItem();
      
        int batchId = selectedBean.getBatchId();
        String part =(String) partComboBox.getSelectedItem(); 
        String partYear =(String) partYearTextField.getText(); 
        String remarks = remarksTextArea.getText();
        int p=Integer.parseInt(part);
        
        
        try {
            int row = DatabaseManager.addPart(batchId,p,partYear,remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
            getPart();
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG");
            }
        }catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,"duplicate part not allowed but \n Part Change Record Successfully Insert ");
        }
    }//end of addPart
    
    private void deleteRecord(){
        PartBean  bean = (PartBean) partsList.getSelectedValue();  
        BatchBean beanBatch = (BatchBean)batchYearComboBox.getSelectedItem();
        if(bean==null ||beanBatch==null)return;
        try {
            int row = DatabaseManager.deletePart(beanBatch.getBatchId(),bean.getPart());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
              getPart();     
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception e) {
           e.printStackTrace();
        }
    }//end of deletePart
    
    private void updateRecord(){
        PartBean  bean = (PartBean) partsList.getSelectedValue();  
        if(bean==null)return;        
        try {        
            int row = DatabaseManager.updatePart(bean.getPart(),partYearTextField.getText(),remarksTextArea.getText());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               getPart();
               clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception e){
            
           e.printStackTrace();
        }
    }//end of updatePart

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        facultyComboBox = new javax.swing.JComboBox();
        shiftComboBox = new javax.swing.JComboBox();
        groupComboBox = new javax.swing.JComboBox();
        partComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        partsList = new javax.swing.JList();
        partYearTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        addButton1 = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton1 = new javax.swing.JButton();
        clearButton1 = new javax.swing.JButton();
        batchYearComboBox = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PART");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        programComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 780, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("GROUP");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 100, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboBoxItemStateChanged(evt);
            }
        });
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 780, 40));

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
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 780, 40));

        shiftComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MORNING", "EVENING" }));
        shiftComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(shiftComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 170, 40));

        groupComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MEDICAL", "ENGINEERING", "COMMERCE", "GENEREL" }));
        groupComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(groupComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 220, 40));

        partComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        partComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        partComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(partComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 160, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("PARTS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, 160, 60));

        partsList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        partsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                partsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(partsList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 110, 400, 550));

        partYearTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        getContentPane().add(partYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 160, 40));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 790, 210));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 670, 400, 60));

        addButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        addButton1.setText("ADD");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(addButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 670, 160, 60));

        updateButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 670, 160, 60));

        deleteButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        deleteButton1.setText("DELETE");
        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 670, 160, 60));

        clearButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        clearButton1.setText("CLEAR");
        clearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 670, 160, 60));

        batchYearComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        batchYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchYearComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(batchYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 160, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setText("FACULTY");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 120, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setText("DEPARTMENT");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 170, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("PROGRAM");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 140, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("REMARKS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 160, 60));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setText("SHIFT");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 90, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("BATCH YEAR");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 170, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("PART");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 80, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setText("PART YEAR");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 150, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
        //getPart();
         getBatch();
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void shiftComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shiftComboBoxActionPerformed

    private void groupComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupComboBoxActionPerformed

    private void partComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_partComboBoxActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void batchYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchYearComboBoxActionPerformed
        // TODO add your handling code here:
        getPart();
          BatchBean beans=(BatchBean)batchYearComboBox.getSelectedItem();
        if(beans==null)return;
        shiftComboBox.setSelectedItem(EncoderDecoder.Decoder.shiftDecode(beans.getShift()));
        groupComboBox.setSelectedItem(EncoderDecoder.Decoder.groupDecode(beans.getGroupDes()));
        
    }//GEN-LAST:event_batchYearComboBoxActionPerformed

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        // TODO add your handling code here:
      addRecord();
    }//GEN-LAST:event_addButton1ActionPerformed

    private void partsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_partsListValueChanged
        // TODO add your handling code here:
        PartBean bean=(PartBean)partsList.getSelectedValue();
        if(bean==null)return;
        partYearTextField.setText(bean.getPartYear());
        remarksTextArea.setText(bean.getRemarks());
        //partComboBox.setSelectedIndex(bean.getPart());
        BatchBean beans=(BatchBean)batchYearComboBox.getSelectedItem();
        
        shiftComboBox.setSelectedItem(EncoderDecoder.Decoder.shiftDecode(beans.getShift()));
        groupComboBox.setSelectedItem(EncoderDecoder.Decoder.groupDecode(beans.getGroupDes()));
        
    }//GEN-LAST:event_partsListValueChanged

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
      updateRecord();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void clearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButton1ActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBoxItemStateChanged
        // TODO add your handling code here:
        
               FacultyBean selectedBean = (FacultyBean) this.facultyComboBox.getSelectedItem();        
        try {
            Vector vec = DatabaseManager.getDepartment(selectedBean.getFacId());
            this.departmentComboBox.removeAllItems();
            for(int i = 0; i<vec.size(); i++){
                System.out.println(vec.elementAt(i));
                this.departmentComboBox.addItem(vec.elementAt(i));
            }             
           
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_facultyComboBoxItemStateChanged

    private void departmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboBoxItemStateChanged
        // TODO add your handling code here
          DepartmentBean selectedBean = (DepartmentBean) this.departmentComboBox.getSelectedItem();        
               if(selectedBean==null) return;
             try {
            Vector vec = DatabaseManager.getProgram(selectedBean.getDeptId());
            this.programComboBox.removeAllItems();
            for(int i = 0; i<vec.size(); i++){
                System.out.println(vec.elementAt(i));
                this.programComboBox.addItem(vec.elementAt(i));
            }             
           
        } catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }               
    }//GEN-LAST:event_departmentComboBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(PartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton1;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox batchYearComboBox;
    private javax.swing.JButton clearButton1;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextField partYearTextField;
    private javax.swing.JList partsList;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
