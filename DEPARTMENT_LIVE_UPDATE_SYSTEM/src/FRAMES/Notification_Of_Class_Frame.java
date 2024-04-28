/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package FRAMES;

import BeanClasses.BatchBean;
import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.NotificationClassBean;
import BeanClasses.ProgramsBean;
import BeanClasses.SchemeBean;
import BeanClasses.SchemeDetailBean;
import BeanClasses.SchemePartBean;
import BeanClasses.SchemeSemesterBean;
import BeanClasses.StudentsBean;
import DatabaseManager.DatabaseManager;
import static DatabaseManager.DatabaseManager.getSchemePart;
import java.util.Vector;
import javax.swing.JOptionPane;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


/**
 *
 * @author Dell
 */
public class Notification_Of_Class_Frame extends javax.swing.JFrame {

    /** Creates new form Notification_Of_Class_Frame */
    public Notification_Of_Class_Frame() {
        initComponents();
        getFaculty();
        getNotificationDate();
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
   
   
   
       private void getNotificationDate(){
          
            try{
                Vector v=DatabaseManager.getNotification();
                notificationDateList.setListData(v);
            }catch(Exception e){e.printStackTrace();}
        }//end of getSchemeDetail
    
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
        notificationDateList = new javax.swing.JList();
        jLabel12 = new javax.swing.JLabel();
        CourseNoComboBox = new javax.swing.JComboBox();
        backButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        NotificationTypeComboBox = new javax.swing.JComboBox<>();
        TIME_OF_CLASS_STARTTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        courseTitleTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        NotificationIdTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        semesterComboBox = new javax.swing.JComboBox();
        clearButton1 = new javax.swing.JButton();
        schemePartComboBox = new javax.swing.JComboBox();
        schemePartComboBox2 = new javax.swing.JComboBox();
        DATE_OF_CLASS_STARTTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("FACULTY");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 120, 40));

        facultyComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 740, 40));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOTIFICATION OF CLASS START");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-340, -10, 1920, 60));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 170, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 740, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("PROGRAM");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 130, 40));

        programComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 740, 40));

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
        getContentPane().add(schemeYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 200, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setText("SCHEME YEAR");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 180, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("TIME OF CLASS START");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 300, 40));

        groupTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupTextField.setEnabled(false);
        getContentPane().add(groupTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 330, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("NOTIFICATION DATES");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 30, 400, 50));

        notificationDateList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        notificationDateList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                notificationDateListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(notificationDateList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 80, 380, 650));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setText("NOTIFICATION ID");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 200, 40));

        CourseNoComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        CourseNoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseNoComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(CourseNoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 330, 40));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 760, 140, 50));

        sendButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        sendButton.setText("SEND");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 750, 160, 60));

        deleteButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 760, 140, 50));

        updateButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 760, 140, 50));

        addButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 760, 140, 50));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 560, 740, 170));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("REMARKS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, 190, 50));

        NotificationTypeComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        NotificationTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MANUAL", "AUTO" }));
        getContentPane().add(NotificationTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 300, 40));

        TIME_OF_CLASS_STARTTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        TIME_OF_CLASS_STARTTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIME_OF_CLASS_STARTTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(TIME_OF_CLASS_STARTTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 200, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setText("COURSE NO");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 170, 40));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel15.setText("COURSE TITLE");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 180, 40));

        courseTitleTextField.setEditable(false);
        courseTitleTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        courseTitleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseTitleTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(courseTitleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 730, 40));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("GROUP");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 200, 40));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("NOTIFICATION SEND TYPE");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, 400, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("DATE OF CLASS START");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 420, 320, 40));

        NotificationIdTextField.setEditable(false);
        NotificationIdTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        NotificationIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificationIdTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(NotificationIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 200, 40));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("SEMESTER");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 200, 40));

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
        getContentPane().add(semesterComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 330, 40));

        clearButton1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        clearButton1.setText("CLEAR");
        clearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 760, 140, 50));

        schemePartComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        schemePartComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schemePartComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(schemePartComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 200, 40));

        schemePartComboBox2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        schemePartComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schemePartComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(schemePartComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 200, 40));

        DATE_OF_CLASS_STARTTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        DATE_OF_CLASS_STARTTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DATE_OF_CLASS_STARTTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(DATE_OF_CLASS_STARTTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 200, 40));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel16.setText("SCHEME PART");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 170, 40));

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
            }catch(Exception e){}
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
            }catch(Exception e){};
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void schemeYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_schemeYearComboBoxItemStateChanged
        // TODO add your handling code here:
        SchemeBean bean=(SchemeBean)schemeYearComboBox.getSelectedItem();
        if(bean==null)return;
        groupTextField.setText(EncoderDecoder.Decoder.groupDecode(bean.getGroupDes()));
    }//GEN-LAST:event_schemeYearComboBoxItemStateChanged

    private void schemeYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemeYearComboBoxActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_schemeYearComboBoxActionPerformed

    private void notificationDateListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_notificationDateListValueChanged
        // TODO add your handling code here:
        NotificationClassBean bean =(NotificationClassBean)notificationDateList.getSelectedValue();
        SchemeDetailBean beans=(SchemeDetailBean)CourseNoComboBox.getSelectedItem();

        if(bean==null || beans == null)return;
         courseTitleTextField.setText(beans.getCrouseTitle());
        DATE_OF_CLASS_STARTTextField1.setText(bean.getData_Of_Class());
        NotificationIdTextField.setText(""+bean.getNotificationId());
        TIME_OF_CLASS_STARTTextField.setText(bean.getTime_Of_Class());
        NotificationTypeComboBox.setSelectedItem(bean.getNotification_Send());
        remarksTextArea.setText(bean.getRemarks());       
        schemePartComboBox.setSelectedItem(bean.getSchemePart());
        semesterComboBox.setSelectedItem(bean.getSemester());
        CourseNoComboBox.setSelectedItem(bean.getCourseNo());
      
      
    }//GEN-LAST:event_notificationDateListValueChanged

    private void CourseNoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseNoComboBoxActionPerformed
        // TODO add your handling code here:
        SchemePartBean bean = (SchemePartBean)schemePartComboBox.getSelectedItem();
        SchemeDetailBean beans=(SchemeDetailBean)CourseNoComboBox.getSelectedItem();
          if(bean==null || beans==null)return;
           courseTitleTextField.setText(beans.getCrouseTitle());
          
            try{
                Vector v=DatabaseManager.getSchemeSemester(bean.getSchemePart(),bean.getSchemeId());
                semesterComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SchemeSemesterBean schemeSembean=(SchemeSemesterBean)v.elementAt(i);
                    semesterComboBox.addItem(schemeSembean);
                }
            }catch(Exception e){e.printStackTrace();}
    }//GEN-LAST:event_CourseNoComboBoxActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        DatabaseManager.SendEmail();       
    }//GEN-LAST:event_sendButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        SchemeBean bean = (SchemeBean) schemeYearComboBox.getSelectedItem();
        if (bean == null) return;
        int schemeId = bean.getSchemeId();

        SchemePartBean sp = (SchemePartBean) schemePartComboBox.getSelectedItem();
        int schemePart = sp.getSchemePart();

        SchemeSemesterBean sem = (SchemeSemesterBean) semesterComboBox.getSelectedItem();
        int semester = sem.getSemester();

        NotificationClassBean beans = (NotificationClassBean) notificationDateList.getSelectedValue();

        Object selectedCourseNoItem = CourseNoComboBox.getSelectedItem();

        // Check if the selected item is of type BeanClasses.SchemeDetailBean
        if (selectedCourseNoItem instanceof BeanClasses.SchemeDetailBean) {
            BeanClasses.SchemeDetailBean courseBean = (BeanClasses.SchemeDetailBean) selectedCourseNoItem;
            String courseNo = courseBean.getCourseNo();

            try {
                // Assuming you have notificationId available when updating
                int notificationId = beans.getNotificationId(); /* get the notificationId */;

                int row = DatabaseManager.deleteNotification(notificationId);

                if (row > 0) {
                    JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
                    getNotificationDate();
                    clearButton1ActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong during the deletion");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            // Handle the case where the selected item is not of type BeanClasses.SchemeDetailBean
            JOptionPane.showMessageDialog(null, "Invalid selection in CourseNoComboBox");
        }

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        SchemeBean bean = (SchemeBean) schemeYearComboBox.getSelectedItem();
        if (bean == null) return;
        int schemeId = bean.getSchemeId();

        SchemePartBean sp = (SchemePartBean) schemePartComboBox.getSelectedItem();
        int schemePart = sp.getSchemePart();

        SchemeSemesterBean sem = (SchemeSemesterBean) semesterComboBox.getSelectedItem();
        int semester = sem.getSemester();

        NotificationClassBean baean =(NotificationClassBean)notificationDateList.getSelectedValue();

        Object selectedCourseNoItem = CourseNoComboBox.getSelectedItem();

        // Check if the selected item is of type BeanClasses.SchemeDetailBean
        if (selectedCourseNoItem instanceof BeanClasses.SchemeDetailBean) {
            BeanClasses.SchemeDetailBean courseBean = (BeanClasses.SchemeDetailBean) selectedCourseNoItem;
            String courseNo = courseBean.getCourseNo();

            String dateOfClassStart = DATE_OF_CLASS_STARTTextField1.getText();
            String timeOfClassStart = TIME_OF_CLASS_STARTTextField.getText();
            String notificationSend = (String) NotificationTypeComboBox.getSelectedItem();
            String remarks = remarksTextArea.getText();

            try {
                // Assuming you have notificationId available when updating
                int notificationId = baean.getNotificationId();/* get the notificationId */;

                int row = DatabaseManager.updateNotification(notificationId, schemeId, schemePart, semester, courseNo, dateOfClassStart, timeOfClassStart, notificationSend, remarks);

                if (row > 0) {
                    JOptionPane.showMessageDialog(null, "RECORD UPDATED SUCCESSFULLY");
                    getNotificationDate();
                    clearButton1ActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(null, "Something went wrong during the update");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            // Handle the case where the selected item is not of type BeanClasses.SchemeDetailBean
            JOptionPane.showMessageDialog(null, "Invalid selection in CourseNoComboBox");
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
 SchemeBean bean = (SchemeBean) schemeYearComboBox.getSelectedItem();
if (bean == null) return;
int schemeId = bean.getSchemeId();

SchemePartBean sp = (SchemePartBean) schemePartComboBox.getSelectedItem();
int schemePart = sp.getSchemePart();

SchemeSemesterBean sem = (SchemeSemesterBean) semesterComboBox.getSelectedItem();
int semester = sem.getSemester();

Object selectedCourseNoItem = CourseNoComboBox.getSelectedItem();

// Check if the selected item is of type BeanClasses.SchemeDetailBean
if (selectedCourseNoItem instanceof BeanClasses.SchemeDetailBean) {
    BeanClasses.SchemeDetailBean courseBean = (BeanClasses.SchemeDetailBean) selectedCourseNoItem;
    String courseNo = courseBean.getCourseNo();
   // int cNo = Integer.parseInt(courseNo);

    String dateOfClassStart = DATE_OF_CLASS_STARTTextField1.getText();
    String timeOfClassStart = TIME_OF_CLASS_STARTTextField.getText();
    String notificationSend = (String) NotificationTypeComboBox.getSelectedItem();
    String remarks = remarksTextArea.getText();

    try {
        int row = DatabaseManager.addNotification(schemeId, schemePart, semester, courseNo, dateOfClassStart, timeOfClassStart, notificationSend, remarks);
        if (row > 0) {
            JOptionPane.showMessageDialog(null, "RECORD ADDED SUCCESSFULLY");
           getNotificationDate();
           clearButton1ActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
} else {
    // Handle the case where the selected item is not of type BeanClasses.SchemeDetailBean
    JOptionPane.showMessageDialog(null, "Invalid selection in CourseNoComboBox");
}


    }//GEN-LAST:event_addButtonActionPerformed

    private void TIME_OF_CLASS_STARTTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIME_OF_CLASS_STARTTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIME_OF_CLASS_STARTTextFieldActionPerformed

    private void courseTitleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseTitleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseTitleTextFieldActionPerformed

    private void NotificationIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificationIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NotificationIdTextFieldActionPerformed

    private void semesterComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_semesterComboBoxItemStateChanged
        // TODO add your handling code here:
        // getSchemeDetail();
    }//GEN-LAST:event_semesterComboBoxItemStateChanged

    private void semesterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterComboBoxActionPerformed
        // TODO add your handling code here:
           
            SchemeSemesterBean bean=(SchemeSemesterBean)semesterComboBox.getSelectedItem();
            if(bean==null){return;}
            
            try{
                Vector v=DatabaseManager.getSchemeDetail(bean.getSemester(),bean.getSchemeId(),bean.getPartScheme());
               CourseNoComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                CourseNoComboBox.addItem(v.elementAt(i));
               }
               }catch(Exception e){e.printStackTrace();}
        
    }//GEN-LAST:event_semesterComboBoxActionPerformed

    private void clearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton1ActionPerformed
        // TODO add your handling code here:
         courseTitleTextField.setText("");
        DATE_OF_CLASS_STARTTextField1.setText("");
        NotificationIdTextField.setText("");
        TIME_OF_CLASS_STARTTextField.setText("");
        NotificationTypeComboBox.setSelectedItem("");
        remarksTextArea.setText("");
      
    }//GEN-LAST:event_clearButton1ActionPerformed

    private void schemePartComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemePartComboBoxActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_schemePartComboBoxActionPerformed

    private void schemePartComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemePartComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schemePartComboBox2ActionPerformed

    private void DATE_OF_CLASS_STARTTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DATE_OF_CLASS_STARTTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DATE_OF_CLASS_STARTTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Notification_Of_Class_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notification_Of_Class_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notification_Of_Class_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notification_Of_Class_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notification_Of_Class_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CourseNoComboBox;
    private javax.swing.JTextField DATE_OF_CLASS_STARTTextField1;
    private javax.swing.JTextField NotificationIdTextField;
    private javax.swing.JComboBox<String> NotificationTypeComboBox;
    private javax.swing.JTextField TIME_OF_CLASS_STARTTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton1;
    private javax.swing.JTextField courseTitleTextField;
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
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JList notificationDateList;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JComboBox schemePartComboBox;
    private javax.swing.JComboBox schemePartComboBox2;
    javax.swing.JComboBox schemeYearComboBox;
    private javax.swing.JComboBox semesterComboBox;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

}
