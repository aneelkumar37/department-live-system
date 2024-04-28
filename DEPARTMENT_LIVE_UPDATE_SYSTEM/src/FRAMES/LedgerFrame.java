/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;
import BeanClasses.BatchBean;
import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.LedgerBean;
import BeanClasses.PartBean;
import BeanClasses.ProgramsBean;
import BeanClasses.SchemeBean;
import BeanClasses.SchemeSemesterBean;
import BeanClasses.SeatListBean;
import BeanClasses.SeatListDetailBean;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan Hyder
 */
public class LedgerFrame extends javax.swing.JFrame {

    /**
     * Creates new form LedgerFrame
     */
    public LedgerFrame() {
        initComponents();
        
        getFaculty();
        getSeatList();
        getScheme();
        getLedger();
        
        
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
        
        private void getLedger(){
            SeatListBean bean=(SeatListBean)examYearComboBox.getSelectedItem();
             SchemeBean schemebean=(SchemeBean)schemeYearComboBox.getSelectedItem();
            if(bean==null || schemebean==null)return;
            try{
                Vector v=DatabaseManager.getLedger(bean.getSeatListId(),schemebean.getSchemeId());
                checkerNameList.setListData(v);
            }catch(Exception e){e.printStackTrace();}
        }//end of getLedger
        
        private void clear(){
            checkerNameTextField.setText("");
            tabulatorNameTextField.setText("");
            announcementDateTextField.setText("");
            remarksTextArea.setText("");
        }//end of Clear
        
        private void addRecord(){
             
            SeatListBean seatListBean=(SeatListBean)examYearComboBox.getSelectedItem();
            if(seatListBean==null)return;
            int seatListId=seatListBean.getSeatListId();
            SchemeBean schemeBean=(SchemeBean)schemeYearComboBox.getSelectedItem();
            if(schemeBean==null)return;
            int schemeId=schemeBean.getSchemeId();
            String tabulatorName=(String)tabulatorNameTextField.getText();
            String checkerName=(String)checkerNameTextField.getText();
            String doa=(String)announcementDateTextField.getText();
            String remarks =(String)remarksTextArea.getText();
        try {
            int row = DatabaseManager.addLedger(seatListId, schemeId, tabulatorName, checkerName, doa, remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
            getLedger();
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG");
            }
        }catch (Exception e){
             e.printStackTrace();
          javax.swing.JOptionPane.showMessageDialog(null,"Error : "+e);
        }
        }//end of addRecord 
        
        private void updateRecord(){
            
            LedgerBean bean = (LedgerBean)checkerNameList.getSelectedValue();
            if(bean==null)return;
            
            SchemeBean schemeBean=(SchemeBean)schemeYearComboBox.getSelectedItem();
            int schemeId=schemeBean.getSchemeId();
            String tabulatorName=(String)tabulatorNameTextField.getText();
            String checkerName=(String)checkerNameTextField.getText();
            String doa=(String)announcementDateTextField.getText();
            String remarks =(String)remarksTextArea.getText();
            try {
            int row = DatabaseManager.updateLedger(schemeId, tabulatorName, checkerName, doa, remarks);
            if(row>0){
                 JOptionPane.showMessageDialog(null,"RECORD UPDATED SUCCESSFULLY");  
                 getLedger();       
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        } catch (Exception ex) {
              ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }  
        }//end of updateRecord
        
        private void deleteRecord(){    
        LedgerBean  bean = (LedgerBean)checkerNameList.getSelectedValue();
        if(bean==null)return;
        try {
            int row = DatabaseManager.deleteLedger(bean.getSchemeId(),bean.getSLId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
             getLedger(); 
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        } catch (Exception ex){ex.printStackTrace();}
   }//end of deleteRecord
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        batchYearComboBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        shiftTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        groupTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        partComboBox = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        examYearComboBox = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        examTypeTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        checkerNameList = new javax.swing.JList();
        jLabel15 = new javax.swing.JLabel();
        schemeYearComboBox = new javax.swing.JComboBox();
        groupTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        checkerNameTextField = new javax.swing.JTextField();
        tabulatorNameTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        announcementDateTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("PROGRAM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, 50));

        programComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 660, -1));

        departmentComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 660, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 180, 50));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("FACULTY");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 130, 50));

        facultyComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 660, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LEDGER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 920, 60));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("BATCH YEAR");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 170, 40));

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
        getContentPane().add(batchYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 170, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SHIFT");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 130, 40));

        shiftTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        shiftTextField.setEnabled(false);
        getContentPane().add(shiftTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 130, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GROUP");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 130, 30));

        groupTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupTextField.setEnabled(false);
        getContentPane().add(groupTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 130, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PART");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 110, 40));

        partComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        partComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(partComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 220, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("EXAM YEAR");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 180, 40));

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
        getContentPane().add(examYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 220, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("EXAM TYPE");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 180, 50));

        examTypeTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        examTypeTextField.setEnabled(false);
        getContentPane().add(examTypeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 265, 280, -1));

        checkerNameList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        checkerNameList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                checkerNameListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(checkerNameList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 70, 360, 610));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("CHECKER NAME");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 380, 60));

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
        getContentPane().add(schemeYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 220, -1));

        groupTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupTextField1.setEnabled(false);
        getContentPane().add(groupTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 305, 280, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("GROUP");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 180, 50));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setText("ANNOUNCEMENT DATE ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 290, 40));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel16.setText("SCHEME YEAR");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 190, 40));

        checkerNameTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        checkerNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkerNameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(checkerNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 680, -1));

        tabulatorNameTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tabulatorNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabulatorNameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(tabulatorNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 680, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel18.setText("CHECKER NAME");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 210, 40));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel19.setText("TABULATOR NAME");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 230, 40));

        announcementDateTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        announcementDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                announcementDateTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(announcementDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 240, -1));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 690, 350, -1));

        clearButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 690, 160, 60));

        deleteButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 690, 160, 60));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 680, 210));

        updateButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 690, 160, 60));

        addButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 690, 160, 60));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("REMARKS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 140, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
       getBatch();
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
       getProgram();
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
       getDepartment();
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void batchYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchYearComboBoxItemStateChanged
        // TODO add your handling code here:

        BatchBean beans=(BatchBean)batchYearComboBox.getSelectedItem();
        if(beans==null)return;
        shiftTextField.setText(EncoderDecoder.Decoder.shiftDecode(beans.getShift()));
        groupTextField.setText(EncoderDecoder.Decoder.groupDecode(beans.getGroupDes()));

    }//GEN-LAST:event_batchYearComboBoxItemStateChanged

    private void batchYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchYearComboBoxActionPerformed
        // TODO add your handling code here:
        getPart();
    }//GEN-LAST:event_batchYearComboBoxActionPerformed

    private void partComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partComboBoxActionPerformed
        // TODO add your handling code here:
        getSeatList();
    }//GEN-LAST:event_partComboBoxActionPerformed

    private void examYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_examYearComboBoxItemStateChanged
        // TODO add your handling code here:
        SeatListBean bean=(SeatListBean)examYearComboBox.getSelectedItem();
        if(bean==null)return;
        examTypeTextField.setText(bean.getType());

    }//GEN-LAST:event_examYearComboBoxItemStateChanged

    private void examYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examYearComboBoxActionPerformed
        // TODO add your handling code here:
        getScheme();
    }//GEN-LAST:event_examYearComboBoxActionPerformed

    private void checkerNameListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_checkerNameListValueChanged
        // TODO add your handling code here:
        LedgerBean bean =(LedgerBean)checkerNameList.getSelectedValue();
        if(bean==null)return;
        examYearComboBox.setSelectedItem(bean.getSLId());
        schemeYearComboBox.setSelectedItem(bean.getSchemeId()-1);
        checkerNameTextField.setText(bean.getCheckerName());
        tabulatorNameTextField.setText(bean.getTabulatorName());
        announcementDateTextField.setText(""+bean.getDateOfAnnouncement());
        remarksTextArea.setText(bean.getRemarks());

    }//GEN-LAST:event_checkerNameListValueChanged

    private void schemeYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_schemeYearComboBoxItemStateChanged
        // TODO add your handling code here:
        SchemeBean bean=(SchemeBean)schemeYearComboBox.getSelectedItem();
        if(bean==null)return;
        groupTextField.setText(bean.getGroupDes());
    }//GEN-LAST:event_schemeYearComboBoxItemStateChanged

    private void schemeYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemeYearComboBoxActionPerformed
        // TODO add your handling code here:
         getLedger();
    }//GEN-LAST:event_schemeYearComboBoxActionPerformed

    private void checkerNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkerNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkerNameTextFieldActionPerformed

    private void tabulatorNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabulatorNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabulatorNameTextFieldActionPerformed

    private void announcementDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_announcementDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_announcementDateTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(LedgerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LedgerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LedgerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LedgerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LedgerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField announcementDateTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox batchYearComboBox;
    private javax.swing.JList checkerNameList;
    private javax.swing.JTextField checkerNameTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JTextField examTypeTextField;
    private javax.swing.JComboBox examYearComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JTextField groupTextField;
    private javax.swing.JTextField groupTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    javax.swing.JComboBox schemeYearComboBox;
    private javax.swing.JTextField shiftTextField;
    private javax.swing.JTextField tabulatorNameTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
