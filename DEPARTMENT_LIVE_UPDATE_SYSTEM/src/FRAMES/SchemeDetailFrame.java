/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.ProgramsBean;
import BeanClasses.SchemeBean;
import BeanClasses.SchemeDetailBean;
import BeanClasses.SchemePartBean;
import BeanClasses.SchemeSemesterBean;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan Hyder
 */
public class SchemeDetailFrame extends javax.swing.JFrame {
 
    /**
     * Creates new form SchemeDetailFrame
     */
    public SchemeDetailFrame() {
        initComponents();
        
        getFaculty();
       // getSchemeSemester();
//       getSchemeDetail();
        
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
            }catch(Exception e){}
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
            }catch(Exception e){}
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
            }catch(Exception e){}
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
            }catch(Exception e){}
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
            }catch(Exception e){}
        }//end of getSchemePart
        
        private void getSchemeSemester(){
            SchemePartBean bean=(SchemePartBean)schemePartComboBox.getSelectedItem();
            if(bean==null)return;
            try{
                Vector v=DatabaseManager.getSchemeSemester(bean.getSchemePart(),bean.getSchemeId());
                semesterComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SchemeSemesterBean schemeSembean=(SchemeSemesterBean)v.elementAt(i);
                    semesterComboBox.addItem(schemeSembean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getSchemeSemester
        
        private void getSchemeDetail(){
            SchemeSemesterBean bean=(SchemeSemesterBean)semesterComboBox.getSelectedItem();
            if(bean==null){return;}
            try{
                Vector v=DatabaseManager.getSchemeDetail(bean.getSemester(),bean.getSchemeId(),bean.getPartScheme());
                courseNoList.setListData(v);
            }catch(Exception e){e.printStackTrace();}
        }//end of getSchemeDetail
        
        private void clear(){
            courseNoTextField.setText("");
            courseTitleTextField.setText("");
            credithrsTextField.setText("");
            maxMarksTextField.setText("");
            remarksTextArea.setText(" ");
        }//end of clear
        
        private void addRecord(){
         
        SchemeBean bean = (SchemeBean)schemeYearComboBox.getSelectedItem();
        if(bean==null)return;
        int schemeId = bean.getSchemeId();
        SchemePartBean  sp=(SchemePartBean) schemePartComboBox.getSelectedItem();
        int schemePart =sp.getSchemePart();

         SchemeSemesterBean sem=(SchemeSemesterBean)semesterComboBox.getSelectedItem();
        int semester=sem.getSemester();
      //  String courseNo=(String)courseNoTextField.getText();
        String courseTitle=courseTitleTextField.getText();
        String marks=(String)maxMarksTextField.getText();
        int maxMarks=Integer.parseInt(marks);
        String chrs=(String)credithrsTextField.getText();
        int credithrs=Integer.parseInt(chrs);
        String subType=(String)subTypeComboBox.getSelectedItem();
        String remarks = remarksTextArea.getText();
        try {
            int row = DatabaseManager.addSchemeDetail(schemeId,schemePart,semester,courseNoTextField.getText(),courseTitle,maxMarks,credithrs,subType,remarks);
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
           getSchemeDetail();
           clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//end of addRecord
        
        private void updateRecord(){
            
        SchemeBean bean = (SchemeBean)schemeYearComboBox.getSelectedItem();
        if(bean==null)return;
        int scId = bean.getSchemeId();
         SchemePartBean Bean = (SchemePartBean) schemePartComboBox.getSelectedItem();
        if(Bean==null)return;
        int part = Bean.getSchemePart();
       // String sem =(String)semesterComboBox.getSelectedItem();
        //int semester=Integer.parseInt(sem);
         SchemeSemesterBean Beansem = (SchemeSemesterBean)semesterComboBox.getSelectedItem();
        if(Beansem==null)return;
        int sm = Beansem.getSemester();
        String Marks=(String) maxMarksTextField.getText();
        int maxMarks =Integer.parseInt(Marks);
        String courseNo =(String) courseNoTextField.getText(); 
//        int courseCode =Integer.parseInt(courseNo); 
        String courseTitle=(String) courseTitleTextField.getText();
        String credithrs = credithrsTextField.getText();
        String remarks = remarksTextArea.getText();
     
        try {            
            
            int row = DatabaseManager.updateSchemeDetail(scId,maxMarks,courseNo,courseTitle, part,sm,remarks);
            if(row>0){
                 JOptionPane.showMessageDialog(null,"RECORD UPDATED SUCCESSFULLY");     //          getSeatListDetail();
                 getSchemeDetail();       
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//updateRecord
        
       private void deleteRecord() {
    SchemeBean bean = (SchemeBean) schemeYearComboBox.getSelectedItem();
    if (bean == null) return;
    int scId = bean.getSchemeId();

    SchemePartBean partBean = (SchemePartBean) schemePartComboBox.getSelectedItem();
    if (partBean == null) return;
    int part = partBean.getSchemePart();

    SchemeSemesterBean semBean = (SchemeSemesterBean) semesterComboBox.getSelectedItem();
    if (semBean == null) return;
    int semester = semBean.getSemester();

    String courseNo = courseNoTextField.getText();


    try {
        int row = DatabaseManager.deleteSchemeDetail(scId, courseNo,part, semester);

        if (row > 0) {
            JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
            getSchemeDetail();
            clear();
        } else {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
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

        jLabel3 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        schemeYearComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        groupTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        courseNoList = new javax.swing.JList();
        jLabel12 = new javax.swing.JLabel();
        schemePartComboBox = new javax.swing.JComboBox();
        backButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        subTypeComboBox = new javax.swing.JComboBox<>();
        maxMarksTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        courseNoTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        courseTitleTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        credithrsTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        semesterComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("FACULTY");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 130, 40));

        facultyComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 740, 40));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SCHEME DETAIL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 10, 1920, 60));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 180, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 740, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("PROGRAM");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 140, 40));

        programComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 740, 40));

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
        getContentPane().add(schemeYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 200, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setText("SCHEME YEAR");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 190, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("MAXIMUM MARKS");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 230, 40));

        groupTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupTextField.setEnabled(false);
        getContentPane().add(groupTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 270, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("COURSE NO");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 520, 50));

        courseNoList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        courseNoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                courseNoListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(courseNoList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 80, 370, 650));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setText("SCHEME PART");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 190, 40));

        schemePartComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        schemePartComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schemePartComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(schemePartComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 200, 40));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 740, 360, 60));

        clearButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 740, 160, 60));

        deleteButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 740, 160, 60));

        updateButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 740, 160, 60));

        addButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 740, 160, 60));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 700, 170));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("REMARKS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 190, 50));

        subTypeComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        subTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GENERAL", "ELECTIVE" }));
        getContentPane().add(subTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, 250, 40));

        maxMarksTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        maxMarksTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxMarksTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(maxMarksTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 200, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setText("COURSE NO");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 170, 40));

        courseNoTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        getContentPane().add(courseNoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 200, 40));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel15.setText("COURSE TITLE");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 200, 40));

        courseTitleTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        courseTitleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseTitleTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(courseTitleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 670, 40));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("GROUP");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 200, 40));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("SUBJECT TYPE");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 220, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("CREDIT HOURS");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 210, 40));

        credithrsTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        credithrsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credithrsTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(credithrsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 200, 40));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("SEMESTER");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 200, 40));

        semesterComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        semesterComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                semesterComboBoxItemStateChanged(evt);
            }
        });
        semesterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(semesterComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 270, 40));

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
        getScheme();
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void schemeYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_schemeYearComboBoxItemStateChanged
        // TODO add your handling code here:
        SchemeBean bean=(SchemeBean)schemeYearComboBox.getSelectedItem();
        if(bean==null)return;
        groupTextField.setText(EncoderDecoder.Decoder.groupDecode(bean.getGroupDes()));
    }//GEN-LAST:event_schemeYearComboBoxItemStateChanged

    private void courseNoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_courseNoListValueChanged
        // TODO add your handling code here:
        SchemeDetailBean bean =(SchemeDetailBean)courseNoList.getSelectedValue();
        if(bean==null)return;
        courseNoTextField.setText(bean.getCourseNo());
        courseTitleTextField.setText(bean.getCrouseTitle());
        credithrsTextField.setText(""+bean.getCreditHours());
        maxMarksTextField.setText(""+bean.getMaxMarks());
        subTypeComboBox.setSelectedItem(bean.getSubType());
        remarksTextArea.setText(bean.getRemarks());
        
    }//GEN-LAST:event_courseNoListValueChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

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

    private void maxMarksTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxMarksTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxMarksTextFieldActionPerformed

    private void courseTitleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseTitleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseTitleTextFieldActionPerformed

    private void credithrsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credithrsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_credithrsTextFieldActionPerformed

    private void schemeYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemeYearComboBoxActionPerformed
        // TODO add your handling code here:
        getSchemePart();
    }//GEN-LAST:event_schemeYearComboBoxActionPerformed

    private void schemePartComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemePartComboBoxActionPerformed
        // TODO add your handling code here:
        getSchemeSemester();
    }//GEN-LAST:event_schemePartComboBoxActionPerformed

    private void semesterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterComboBoxActionPerformed
         // TODO add your handling code here:
        getSchemeDetail();
    }//GEN-LAST:event_semesterComboBoxActionPerformed

    private void semesterComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_semesterComboBoxItemStateChanged
        // TODO add your handling code here:
       // getSchemeDetail();
    }//GEN-LAST:event_semesterComboBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(SchemeDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchemeDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchemeDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchemeDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchemeDetailFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JList courseNoList;
    private javax.swing.JTextField courseNoTextField;
    private javax.swing.JTextField courseTitleTextField;
    private javax.swing.JTextField credithrsTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JTextField groupTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField maxMarksTextField;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JComboBox schemePartComboBox;
    javax.swing.JComboBox schemeYearComboBox;
    private javax.swing.JComboBox semesterComboBox;
    private javax.swing.JComboBox<String> subTypeComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
