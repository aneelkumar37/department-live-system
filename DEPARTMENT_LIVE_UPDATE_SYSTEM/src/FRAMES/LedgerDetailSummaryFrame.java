/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.BatchBean;
import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.LedgerDetailBean;
import BeanClasses.LedgerDetailSummaryBean;
import BeanClasses.PartBean;
import BeanClasses.ProgramsBean;
import BeanClasses.SchemeBean;
import BeanClasses.SchemeDetailBean;
import BeanClasses.SchemePartBean;
import BeanClasses.SchemeSemesterBean;
import BeanClasses.SeatListBean;
import BeanClasses.SeatListDetailBean;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan Hyder
 */
public class LedgerDetailSummaryFrame extends javax.swing.JFrame {

    /**
     * Creates new form LedgerDetailSummaryFrame
     */
    public LedgerDetailSummaryFrame() {
        initComponents();
        
        getFaculty();
          getLedgerDetailSummary();
          getLedgerDetail();
      //  getLedgerDetail();
       // getLedgerDetailSummary();
        
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
           if(bean==null)return;
            try{
                  Vector v=DatabaseManager.getSchemeDetail(bean.getSemester(),bean.getSchemeId(),bean.getPartScheme());
                courseNoComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SchemeDetailBean schemedetailbean=(SchemeDetailBean)v.elementAt(i);
                    courseNoComboBox.addItem(schemedetailbean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getSchemeDetail
        
        private void getLedgerDetail(){
           // SchemeDetailBean bean=(SchemeDetailBean)courseNoComboBox.getSelectedItem();
           SeatListBean bean =(SeatListBean)examYearComboBox.getSelectedItem();
           if(bean==null)return; 
           try{
                Vector v=DatabaseManager.getSeatListDetail(bean.getSeatListId());
                rollNoComboBox.removeAllItems();
                for(int i=0; i<v.size(); i++){
                    SeatListDetailBean ldbean=(SeatListDetailBean)v.elementAt(i);
                    rollNoComboBox.addItem(ldbean);
                }
            }catch(Exception e){e.printStackTrace();}
        }//end of getLedgerDetail
        
        private void getLedgerDetailSummary(){
            //LedgerDetailSummaryBean bean=(LedgerDetailSummaryBean)gpaList.getSelectedValue();
            SeatListBean bean =(SeatListBean)examYearComboBox.getSelectedItem();
            if(bean==null)return;
            try{
                Vector v=DatabaseManager.getLedgerDetailSummary(bean.getSeatListId());
                gpaList.setListData(v);
            }catch(Exception e){e.printStackTrace();}
        }//end of getLedgerDetailSummary
        
        private void clear(){
            
            totalMarksTextField1.setText("");
            gpaTextField.setText("");
            resultTextField.setText("");
            percentageTextField.setText("");
            obtMarksTextField.setText("");
            individualDateOfAnnTextField.setText("");
            remarksTextArea.setText("");
            
        }//end of clear
        
        private void addRecord(){
            SeatListBean slbean=(SeatListBean)examYearComboBox.getSelectedItem();
            if(slbean==null)return;     
            int seatListId=slbean.getSeatListId();
           SeatListDetailBean B=(SeatListDetailBean)rollNoComboBox.getSelectedItem();
            if(B==null)return;
            //String B=(String)rollNoComboBox.getSelectedItem();
            String tm=(String)totalMarksTextField1.getText();
            int totalMarks=Integer.parseInt(tm);
            String om=(String)obtMarksTextField.getText();
            int obtMarks=Integer.parseInt(om);
            String gpa=(String)gpaTextField.getText();
            String result=(String)resultTextField.getText();
            String percentage=(String)percentageTextField.getText();
           // String IDA =(String)individualDateOfAnnTextField1.getText();
            String remarks=(String)remarksTextArea.getText();
            
            try {
            int row = DatabaseManager.addLedgerDetailSummary(seatListId,B.getRollNo(), gpa, totalMarks, obtMarks, result, percentage,individualDateOfAnnTextField.getText(), remarks);  
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
                getLedgerDetailSummary();
                clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"individualDateAnnouncement is a string in a valid date format This 8/12/2017");}
           
        }//end of addRecord
        
        private void updateRecord(){
            
            LedgerDetailSummaryBean ldsbean =(LedgerDetailSummaryBean)gpaList.getSelectedValue();
            if(ldsbean==null)return;
            SeatListBean slbean=(SeatListBean)examYearComboBox.getSelectedItem();
            int seatListId=slbean.getSeatListId();
            SeatListDetailBean ldbean=(SeatListDetailBean)rollNoComboBox.getSelectedItem();
            String tm=(String)totalMarksTextField1.getText();
            int totalMarks=Integer.parseInt(tm);
            String om=(String)obtMarksTextField.getText();
            int obtMarks=Integer.parseInt(om);
            String gpa=(String)gpaTextField.getText();
            String result=(String)resultTextField.getText();
            String IDA =(String)individualDateOfAnnTextField.getText();
            String percentage=(String)percentageTextField.getText();
            //String remarks=(String)remarksTextArea.getText();
            try{
                int row=DatabaseManager.updateLedgerDetailSummary(seatListId,ldbean.getRollNo(),gpa,totalMarks,obtMarks,result,percentage,individualDateOfAnnTextField.getText(),remarksTextArea.getText());
                if(row>0){ 
                JOptionPane.showMessageDialog(null,"RECORD UPDATED SUCCESSFULLY");
                 getLedgerDetailSummary();       
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }  
            }catch(Exception ex){
                ex.printStackTrace();}
        }//end of updateRecord
        
               
       private void deleteRecord(){    
       LedgerDetailSummaryBean  bean = (LedgerDetailSummaryBean)gpaList.getSelectedValue();
       if(bean==null)return;
       try {
           int row = DatabaseManager.deleteLedgerDetailSummary(bean.getSeatListId(),bean.getRollNo());
           if(row>0){
               JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
            getLedgerDetailSummary(); 
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

        jLabel1 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gpaList = new javax.swing.JList();
        programComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        batchYearComboBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        shiftTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        groupTextField = new javax.swing.JTextField();
        examTypeTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        examYearComboBox = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        partComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        schemeYearComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        groupTextField1 = new javax.swing.JTextField();
        schemePartComboBox = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        semesterComboBox = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        rollNoComboBox = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        courseNoComboBox = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        gpaTextField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        obtMarksTextField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        totalMarksTextField1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        resultTextField = new javax.swing.JTextField();
        percentageTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        individualDateOfAnnTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LEDGER DETAIL SUMMARY");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, 0, 1960, 60));

        facultyComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 780, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("FACULTY");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 180, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 780, 40));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("ROLL-NO");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 510, 70));

        gpaList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        gpaList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                gpaListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(gpaList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, 330, 650));

        programComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 780, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("BATCH YEAR");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 170, 40));

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
        getContentPane().add(batchYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 140, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SHIFT");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 120, 40));

        shiftTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        shiftTextField.setEnabled(false);
        getContentPane().add(shiftTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 160, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GROUP");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 170, 40));

        groupTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupTextField.setEnabled(false);
        getContentPane().add(groupTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, 180, 40));

        examTypeTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        examTypeTextField.setEnabled(false);
        getContentPane().add(examTypeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, 180, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("EXAM TYPE");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 170, 40));

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
        getContentPane().add(examYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 160, 40));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("EXAM YEAR");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 140, 40));

        partComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        partComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(partComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 140, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PART");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 110, 40));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel16.setText("SCHEME YEAR");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 190, 40));

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
        getContentPane().add(schemeYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 140, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("GROUP");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 130, 40));

        groupTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupTextField1.setEnabled(false);
        getContentPane().add(groupTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 160, 40));

        schemePartComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        schemePartComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schemePartComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(schemePartComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 340, 180, 40));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText(" SCHEME PART");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 190, 40));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("SEMESTER");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 170, 40));

        semesterComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        semesterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(semesterComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 140, 40));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("COURSE NO");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 150, 40));

        rollNoComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        rollNoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollNoComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(rollNoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 390, 180, 40));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("ROLL NO");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, 150, 40));

        courseNoComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        courseNoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNoComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(courseNoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 160, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("GPA");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, 150, 40));

        gpaTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        gpaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpaTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(gpaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 440, 180, 40));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("OBTAIN MARKS");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 180, 40));

        obtMarksTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        obtMarksTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtMarksTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(obtMarksTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 110, 40));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("TOTAL MARKS");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 220, 40));

        totalMarksTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        totalMarksTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalMarksTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(totalMarksTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 140, 40));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("RESULT");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 150, 40));

        resultTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        resultTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(resultTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 220, 40));

        percentageTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        percentageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentageTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(percentageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 160, 40));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("PERCENTAGE");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 220, 40));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel26.setText("INDIVDUAL DATE OF ANNOUNCEMENT  ");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 470, 40));

        individualDateOfAnnTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        individualDateOfAnnTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                individualDateOfAnnTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(individualDateOfAnnTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 540, 280, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("REMARKS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, 140, 50));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, 850, 140));

        addButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 740, 160, 60));

        updateButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 740, 160, 60));

        deleteButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 740, 160, 60));

        clearButton.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        clearButton.setText("CLEAR");
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 740, 160, 60));

        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 740, 330, 60));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("PROGRAM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 150, 40));

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

    private void gpaListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_gpaListValueChanged
//        // TODO add your handling code here:
        LedgerDetailSummaryBean bean =(LedgerDetailSummaryBean)gpaList.getSelectedValue();
        if(bean==null)return;
        
        totalMarksTextField1.setText(""+bean.getTotalMarks());
        gpaTextField.setText(bean.getGPA());
        resultTextField.setText(bean.getResult());
        percentageTextField.setText(bean.getPercentage());
        obtMarksTextField.setText(""+bean.getMarksObt());
        individualDateOfAnnTextField.setText(""+bean.getIndividaulDateOfAnn());
        remarksTextArea.setText(bean.getRemarks());
        
    }//GEN-LAST:event_gpaListValueChanged

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
        getBatch();
        getScheme();
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void batchYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchYearComboBoxItemStateChanged
        // TODO add your handling code here:
        BatchBean beans=(BatchBean)batchYearComboBox.getSelectedItem();
        shiftTextField.setText(EncoderDecoder.Decoder.shiftDecode(beans.getShift()));
        groupTextField.setText(EncoderDecoder.Decoder.groupDecode(beans.getGroupDes()));
    }//GEN-LAST:event_batchYearComboBoxItemStateChanged

    private void batchYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchYearComboBoxActionPerformed
        // TODO add your handling code here:
        getPart();
        getSeatList();
    }//GEN-LAST:event_batchYearComboBoxActionPerformed

    private void examYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_examYearComboBoxItemStateChanged
        // TODO add your handling code here:
        SeatListBean bean=(SeatListBean)examYearComboBox.getSelectedItem();
        if(bean==null)return;
        examTypeTextField.setText(bean.getType());
    }//GEN-LAST:event_examYearComboBoxItemStateChanged

    private void examYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examYearComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_examYearComboBoxActionPerformed

    private void partComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_partComboBoxActionPerformed

    private void schemeYearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_schemeYearComboBoxItemStateChanged
        // TODO add your handling code here:
        SchemeBean bean=(SchemeBean)schemeYearComboBox.getSelectedItem();
        if(bean==null)return;
        groupTextField.setText(EncoderDecoder.Decoder.groupDecode(bean.getGroupDes()));
    }//GEN-LAST:event_schemeYearComboBoxItemStateChanged

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

    private void rollNoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollNoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rollNoComboBoxActionPerformed

    private void courseNoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseNoComboBoxActionPerformed

    private void gpaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gpaTextFieldActionPerformed

    private void obtMarksTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtMarksTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obtMarksTextFieldActionPerformed

    private void totalMarksTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalMarksTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalMarksTextField1ActionPerformed

    private void resultTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultTextFieldActionPerformed

    private void percentageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_percentageTextFieldActionPerformed

    private void individualDateOfAnnTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_individualDateOfAnnTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_individualDateOfAnnTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(LedgerDetailSummaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LedgerDetailSummaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LedgerDetailSummaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LedgerDetailSummaryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LedgerDetailSummaryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox batchYearComboBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox courseNoComboBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JTextField examTypeTextField;
    private javax.swing.JComboBox examYearComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JList gpaList;
    private javax.swing.JTextField gpaTextField;
    private javax.swing.JTextField groupTextField;
    private javax.swing.JTextField groupTextField1;
    private javax.swing.JTextField individualDateOfAnnTextField;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField obtMarksTextField;
    private javax.swing.JComboBox partComboBox;
    private javax.swing.JTextField percentageTextField;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JTextField resultTextField;
    private javax.swing.JComboBox rollNoComboBox;
    private javax.swing.JComboBox schemePartComboBox;
    javax.swing.JComboBox schemeYearComboBox;
    private javax.swing.JComboBox semesterComboBox;
    private javax.swing.JTextField shiftTextField;
    private javax.swing.JTextField totalMarksTextField1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
