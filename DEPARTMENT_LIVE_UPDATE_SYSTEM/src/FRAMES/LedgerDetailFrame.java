/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.*;
import DatabaseManager.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class LedgerDetailFrame extends javax.swing.JFrame {

    /**
     * Creates new form LedgerDetailFrame
     */
    public LedgerDetailFrame() {
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
                PartComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    PartBean partbean=(PartBean)v.elementAt(i);
                    PartComboBox.addItem(partbean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getPart
    
   
       private void getSeatList(){
            
        BatchBean bean=(BatchBean)batchYearComboBox.getSelectedItem();
        PartBean partBean=(PartBean)PartComboBox.getSelectedItem();
        
        if(bean==null || partBean==null){return;}

            try{
               Vector v=DatabaseManager.getSeatList(bean.getBatchId(),partBean.getPart());
                YearExamComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SeatListBean slbean=(SeatListBean)v.elementAt(i);
                    YearExamComboBox.addItem(slbean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getsealList
        

        private void getScheme(){
            ProgramsBean bean=(ProgramsBean)programComboBox.getSelectedItem();
            if(bean==null)return;
            try{
                Vector v=DatabaseManager.getScheme(bean.getProgId());
                SchemeYearComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SchemeBean schemebean=(SchemeBean)v.elementAt(i);
                    SchemeYearComboBox.addItem(schemebean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getScheme

        
         private void getSchemePart(){
            SchemeBean bean=(SchemeBean)SchemeYearComboBox.getSelectedItem();
            if(bean==null)return;
            try{
                Vector v=DatabaseManager.getSchemePart(bean.getSchemeId());
                schemePartComboBox1.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SchemePartBean spbean=(SchemePartBean)v.elementAt(i);
                    schemePartComboBox1.addItem(spbean);
                }
            }catch(Exception e){}
        }//end of getSchemePart
    
     
        private void getSchemeSemester(){
          SchemePartBean bean=(SchemePartBean)schemePartComboBox1.getSelectedItem();
          if(bean==null)return;  
          try{
                Vector v=DatabaseManager.getSchemeSemester(bean.getSchemePart(),bean.getSchemeId());
                semesterComboBox2.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SchemeSemesterBean schemeSembean=(SchemeSemesterBean)v.elementAt(i);
                    semesterComboBox2.addItem(schemeSembean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getSchemeSemester
        
        private void getSchemeDetail(){
            SchemeSemesterBean bean=(SchemeSemesterBean)semesterComboBox2.getSelectedItem();
            if(bean==null)return; 
            try{
                Vector v=DatabaseManager.getSchemeDetail(bean.getSemester(),bean.getSchemeId(),bean.getPartScheme());
                crouseNOComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SchemeDetailBean schemedetailbean=(SchemeDetailBean)v.elementAt(i);
                    crouseNOComboBox.addItem(schemedetailbean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getSchemeDetail
        
        
        private void getLedgerDetail(){
            SchemeDetailBean bean=(SchemeDetailBean)crouseNOComboBox.getSelectedItem();
            if(bean==null)return;
            try{
                Vector v=DatabaseManager.getLedgerDetail(bean.getCourseNo());
                rollNoList.setListData(v);
            }catch(Exception e){e.printStackTrace();}
        }//end of getLedgerDetail
        
    
     private void addRecord(){
            
            SeatListBean slbean=(SeatListBean)YearExamComboBox.getSelectedItem();
            if(slbean==null)return;
            
            int seatListId=slbean.getSeatListId();
            SchemeBean schemebean = (SchemeBean)SchemeYearComboBox.getSelectedItem();
            int schemeId = schemebean.getSchemeId();
            SchemePartBean  sp=(SchemePartBean) schemePartComboBox1.getSelectedItem();
            int schemePart =sp.getSchemePart();
            SchemeSemesterBean sem=(SchemeSemesterBean)semesterComboBox2.getSelectedItem();
            int semester=sem.getSemester();
            SchemeDetailBean crsNo=(SchemeDetailBean)crouseNOComboBox.getSelectedItem();
            String courseNo=crsNo.getCourseNo();
            String rollNo=(String)rollNoTypeTextField2.getText();
            String om=(String)obtainMarksTextField2.getText();
            int obtMarks=Integer.parseInt(om);
            String qualityPoints=(String)gpaTypeTextField3.getText();
            int qp=Integer.parseInt(qualityPoints);
            String grade=(String)gradeTextField.getText();
            String result=(String)resultTextField.getText();
            String remarks=(String)remarksTextArea.getText();
            
            try {
            int row = DatabaseManager.addLedgerDetail(rollNo,seatListId,schemeId,schemePart,semester,courseNo,obtMarks,qp,grade,result,remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
           getLedgerDetail();
           clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        }//end of addRecord
     
     
     
     private void updateRecord(){
            
            SeatListBean slbean=(SeatListBean)YearExamComboBox.getSelectedItem();
            if(slbean==null)return;
            
            int seatListId=slbean.getSeatListId();
            SchemeBean schemebean = (SchemeBean)SchemeYearComboBox.getSelectedItem();
            int schemeId = schemebean.getSchemeId();
            SchemePartBean  sp=(SchemePartBean) schemePartComboBox1.getSelectedItem();
            int schemePart =sp.getSchemePart();
            SchemeSemesterBean sem=(SchemeSemesterBean)semesterComboBox2.getSelectedItem();
            int semester=sem.getSemester();
            SchemeDetailBean crsNo=(SchemeDetailBean)crouseNOComboBox.getSelectedItem();
            String courseNo=crsNo.getCourseNo();
            String rollNo=(String)rollNoTypeTextField2.getText();
            String om=(String)obtainMarksTextField2.getText();
            int obtMarks=Integer.parseInt(om);
            String qualityPoints=(String)gpaTypeTextField3.getText();
            int qp=Integer.parseInt(qualityPoints);
            String grade=(String)gradeTextField.getText();
            String result=(String)resultTextField.getText();
            String remarks=(String)remarksTextArea.getText();
            
            try {
            int row = DatabaseManager.updateLedgerDetail(seatListId,schemeId,schemePart,semester,courseNo,rollNo,obtMarks,qp,grade,result,remarks);
            if(row>0){
                 JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
           getLedgerDetail();
           clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        }//end of addRecord

     
     
     private void deleteRecord(){    
        LedgerDetailBean  bean = (LedgerDetailBean)rollNoList.getSelectedValue();
        if(bean==null)return;
        try {
            int row = DatabaseManager.deleteLedgerDetail(bean.getCourseNO(),bean.getSemester(),bean.getSchemePart(),bean.getSchemeId(),bean.getSeatListId(),bean.getRollNo());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
             getLedgerDetail(); 
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        } catch (Exception ex){ex.printStackTrace();}
   }//end of deleteRecord
        
        
     
    
        private void clear(){
          rollNoTypeTextField2.setText(" ");
             gpaTypeTextField3.setText(" ");
             resultTextField.setText(" ");
                     gradeTextField.setText(" ");
                     obtainMarksTextField2.setText(" ");
                     remarksTextArea.setText(" ");
     
        
        } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        facultyLabel = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        departmentLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        batchYearComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        YearExamComboBox = new javax.swing.JComboBox();
        PartComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        examTypeTextField = new javax.swing.JTextField();
        crouseNOComboBox = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        obtainMarksTextField2 = new javax.swing.JTextField();
        gradeTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        resultTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        rollNoList = new javax.swing.JList();
        backButton = new javax.swing.JButton();
        SchemeYearComboBox = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        groupTextField1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        rollNoTypeTextField2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        gpaTypeTextField3 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        schemePartComboBox1 = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        semesterComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        shiftTextField1 = new javax.swing.JTextField();
        groupBatchTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("ROLL-NO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 470, -1));

        facultyLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        facultyLabel.setText("FACULTY");
        getContentPane().add(facultyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 90, 40));

        facultyComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
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
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 710, 40));

        departmentLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        departmentLabel.setText("DEPARTMENT");
        getContentPane().add(departmentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 130, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
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
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 710, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("PROGRAM");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 100, 40));

        programComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        programComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                programComboBoxItemStateChanged(evt);
            }
        });
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 710, 40));

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
        getContentPane().add(batchYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 180, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("BATCH YEAR");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 190, 70));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("SHIFT");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 120, 60));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("GROUP");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 120, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("EXAM YEAR");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 130, 40));

        YearExamComboBox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        YearExamComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                YearExamComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(YearExamComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 130, 40));

        PartComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        PartComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PartComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(PartComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 180, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("PART");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 140, 60));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("EXAM TYPE");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 130, 40));

        examTypeTextField.setEditable(false);
        examTypeTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(examTypeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 150, 40));

        crouseNOComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        crouseNOComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crouseNOComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(crouseNOComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 180, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setText("SCHEME YEAR");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 220, 80));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("COURSE NO");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 120, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("OBTAIN MARKS");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 160, 40));

        obtainMarksTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        obtainMarksTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtainMarksTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(obtainMarksTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 250, 40));

        gradeTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(gradeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 250, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("GRADE");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 100, 40));

        resultTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(resultTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, 190, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("RESULT");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 500, 110, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("REMARKS");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, 100, 40));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 630, 170));

        addButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 750, 140, 50));

        updateButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 750, 140, 50));

        deleteButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 750, 140, 50));

        clearButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 750, 140, 50));

        rollNoList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        rollNoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                rollNoListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(rollNoList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 370, 670));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 740, 370, 60));

        SchemeYearComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        SchemeYearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SchemeYearComboBoxItemStateChanged(evt);
            }
        });
        SchemeYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchemeYearComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(SchemeYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 180, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("GROUP");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 110, 50));

        groupTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(groupTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 180, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("ROLL-NO");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 110, 60));

        rollNoTypeTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(rollNoTypeTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 190, 40));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("QP");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 80, 60));

        gpaTypeTextField3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(gpaTypeTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 190, 40));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setText("SCHEME PART");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 220, 20));

        schemePartComboBox1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        schemePartComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schemePartComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(schemePartComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 355, 180, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel24.setText("SEMESTER");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 180, 40));

        semesterComboBox2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        semesterComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(semesterComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 190, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setText("LEDGER DETAIL ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 520, -1));

        shiftTextField1.setEditable(false);
        shiftTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(shiftTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 150, 40));

        groupBatchTextField.setEditable(false);
        groupBatchTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(groupBatchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 150, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBoxItemStateChanged
        // TODO add your handling code here:
      
    }//GEN-LAST:event_facultyComboBoxItemStateChanged

    private void departmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboBoxItemStateChanged
        // TODO add your handling code here:
      
    }//GEN-LAST:event_departmentComboBoxItemStateChanged

    private void programComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_programComboBoxItemStateChanged
        // TODO add your handling code here:

      
    }//GEN-LAST:event_programComboBoxItemStateChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
              addRecord();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        //      // TODO add your handling code here:
          updateRecord();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
         deleteRecord();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
         clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void rollNoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_rollNoListValueChanged
     LedgerDetailBean bea= (LedgerDetailBean)rollNoList.getSelectedValue();
    if(bea==null)return;
//       if(bea==null)return;
//        try {
//            SchemeBean sBean = DatabaseManager.getSchemeBySchemeId(bea.getSchemeId());    
//            if(sBean==null) return;
//            
//            for (int i = 0; i < SchemeYearComboBox.getItemCount(); i++) {
//                Object item = SchemeYearComboBox.getItemAt(i);
//
//                if (item instanceof SchemeBean && ((SchemeBean) item).getSchemeYear() == sBean.getSchemeYear()) {
//                    SchemeYearComboBox.setSelectedItem(item);
//                    break;
//                }
//            }
//
//            } catch (Exception e) {
//                // Handle the exception accordingly (e.g., log the error, display an error message)
//                e.printStackTrace();
//            }
     
       schemePartComboBox1.setSelectedItem(bea.getSchemePart());
        semesterComboBox2.setSelectedItem(bea.getSemester());
        rollNoTypeTextField2.setText(bea.getRollNo());
        gpaTypeTextField3.setText(""+bea.getQP());
        resultTextField.setText(bea.getResult());
        gradeTextField.setText(bea.getGrade()); 
        obtainMarksTextField2.setText(""+bea.getMarksObt());
        remarksTextArea.setText(bea.getRemarks());
     

    }//GEN-LAST:event_rollNoListValueChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void SchemeYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SchemeYearComboBoxItemStateChanged
        // TODO add your handling code here:
        
        SchemeBean bean =(SchemeBean) SchemeYearComboBox.getSelectedItem(); 
        if(bean==null)return;
        groupTextField1.setText(bean.getGroupDes());

    }//GEN-LAST:event_SchemeYearComboBoxItemStateChanged

    private void obtainMarksTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtainMarksTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obtainMarksTextField2ActionPerformed

    private void batchYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchYearComboBoxItemStateChanged
        // TODO add your handling code here:
        BatchBean selectedBean = (BatchBean) this.batchYearComboBox.getSelectedItem();
        if(selectedBean==null)return;
        shiftTextField1.setText(EncoderDecoder.Decoder.shiftDecode(selectedBean.getShift()));
        groupBatchTextField.setText(EncoderDecoder.Decoder.groupDecode(selectedBean.getGroupDes()));
    }//GEN-LAST:event_batchYearComboBoxItemStateChanged

    private void YearExamComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_YearExamComboBoxItemStateChanged
        SeatListBean bean = (SeatListBean) this.YearExamComboBox.getSelectedItem();
        if(bean==null)return;
    }//GEN-LAST:event_YearExamComboBoxItemStateChanged

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

    private void schemePartComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemePartComboBox1ActionPerformed
        // TODO add your handling code here:
         getSchemeSemester();
    }//GEN-LAST:event_schemePartComboBox1ActionPerformed

    private void crouseNOComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crouseNOComboBoxActionPerformed
        // TODO add your handling code here:
          getLedgerDetail();
    }//GEN-LAST:event_crouseNOComboBoxActionPerformed

    private void semesterComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterComboBox2ActionPerformed
        // TODO add your handling code here:
         getSchemeDetail();
    }//GEN-LAST:event_semesterComboBox2ActionPerformed

    private void SchemeYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchemeYearComboBoxActionPerformed
        // TODO add your handling code here:
         getSchemePart();
    }//GEN-LAST:event_SchemeYearComboBoxActionPerformed

    private void batchYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchYearComboBoxActionPerformed
        // TODO add your handling code here:
         getPart();
        
    }//GEN-LAST:event_batchYearComboBoxActionPerformed

    private void PartComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PartComboBoxActionPerformed
        // TODO add your handling code her
        getSeatList();
        getScheme();
    }//GEN-LAST:event_PartComboBoxActionPerformed

    
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
            java.util.logging.Logger.getLogger(LedgerDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LedgerDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LedgerDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LedgerDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LedgerDetailFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox PartComboBox;
    private javax.swing.JComboBox SchemeYearComboBox;
    private javax.swing.JComboBox YearExamComboBox;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox batchYearComboBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox crouseNOComboBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JTextField examTypeTextField;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JTextField gpaTypeTextField3;
    private javax.swing.JTextField gradeTextField;
    private javax.swing.JTextField groupBatchTextField;
    private javax.swing.JTextField groupTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField obtainMarksTextField2;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JTextField resultTextField;
    private javax.swing.JList rollNoList;
    private javax.swing.JTextField rollNoTypeTextField2;
    private javax.swing.JComboBox schemePartComboBox1;
    private javax.swing.JComboBox semesterComboBox2;
    private javax.swing.JTextField shiftTextField1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
