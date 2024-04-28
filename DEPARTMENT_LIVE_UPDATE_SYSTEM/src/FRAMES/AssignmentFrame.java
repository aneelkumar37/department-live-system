/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

import BeanClasses.AssignmentBean;
import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.TeacherBean;
import DatabaseManager.DatabaseManager;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class AssignmentFrame extends javax.swing.JFrame {

    /**
     * Creates new form AssignmentFrame
     */
    public AssignmentFrame() {
        initComponents();
        getTeacher();
        getAssignment();
         java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
    }

    
      private void getAssignment(){
          TeacherBean  bean = (TeacherBean)this.TeacherComboBox.getSelectedItem();
          if(bean==null)return;
   
       try {
           int teacherId = bean.getTeacherId();
            Vector v = DatabaseManager.getAssignment(teacherId);
            AssignTitleNameList.setListData(v);  
        }catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
     } 
    
    private void getTeacher(){
     
       //TeacherBean  bean = (TeacherBean)this.TeacherComboBox.getSelectedItem();
      // if(bean==null)return;
       try {
           //int deptId = bean.getDeptId();
            Vector v = DatabaseManager.getTeacher();
               for(int i = 0; i<v.size(); i++){
                  TeacherComboBox.addItem(v.elementAt(i));  
               }
           
        }catch (Exception ex) {
            Logger.getLogger(DepartmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
     } 
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        facultyLabel = new javax.swing.JLabel();
        TeacherComboBox = new javax.swing.JComboBox();
        assignmentdTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        assignTitleTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        startDateTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lastDateTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        whoDoTheAssignTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        AssignTitleNameList = new javax.swing.JList();
        addButton = new javax.swing.JToggleButton();
        updateButton = new javax.swing.JToggleButton();
        deleteButton = new javax.swing.JToggleButton();
        clearButton2 = new javax.swing.JToggleButton();
        backButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("ASSIGNMENT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 280, -1));

        facultyLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyLabel.setText("TEACHER");
        getContentPane().add(facultyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 120, 40));

        TeacherComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        TeacherComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TeacherComboBoxItemStateChanged(evt);
            }
        });
        TeacherComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(TeacherComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 690, 40));

        assignmentdTextField.setEditable(false);
        assignmentdTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        assignmentdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignmentdTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(assignmentdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 140, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("ASSIGNMENT ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 200, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("ASSIGNMENT TITLE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 460, 40));

        assignTitleTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(assignTitleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 390, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("START_DATE");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 400, 40));

        startDateTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(startDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 390, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setText("LAST_DATE");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 400, 40));

        lastDateTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(lastDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 390, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("DESCRIPTION OF TIME TABLE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 400, 40));

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 400, 130));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane3.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 380, 130));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setText("REMARKS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, 400, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setText("WHO_DO_THE_ASSIGNMENT");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 420, 40));

        whoDoTheAssignTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(whoDoTheAssignTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 390, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ASSGIN TITLE");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 50, 240, 20));

        AssignTitleNameList.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        AssignTitleNameList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                AssignTitleNameListValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(AssignTitleNameList);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 80, 240, 540));

        addButton.setBackground(new java.awt.Color(242, 242, 242));
        addButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 640, 160, 50));

        updateButton.setBackground(new java.awt.Color(242, 242, 242));
        updateButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 640, -1, 50));

        deleteButton.setBackground(new java.awt.Color(242, 242, 242));
        deleteButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 640, 160, 50));

        clearButton2.setBackground(new java.awt.Color(242, 242, 242));
        clearButton2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        clearButton2.setText("CLEAR");
        clearButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 640, 160, 50));

        backButton.setBackground(new java.awt.Color(242, 242, 242));
        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 640, 230, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TeacherComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TeacherComboBoxItemStateChanged
        // TODO add your handling code here:
      
    }//GEN-LAST:event_TeacherComboBoxItemStateChanged

    private void TeacherComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherComboBoxActionPerformed
        // TODO add your handling code here:
         TeacherBean bean=(TeacherBean)TeacherComboBox.getSelectedItem();
        if(bean==null){return;}
        try{
            Vector v=DatabaseManager.getAssignment(bean.getTeacherId());
            AssignTitleNameList.setListData(v);
         }catch(Exception e){e.printStackTrace();}
        
    }//GEN-LAST:event_TeacherComboBoxActionPerformed

    private void assignmentdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignmentdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignmentdTextFieldActionPerformed

    private void AssignTitleNameListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_AssignTitleNameListValueChanged
        // TODO add your handling code here:
       AssignmentBean Bean = (AssignmentBean) this.AssignTitleNameList.getSelectedValue();    
       if(Bean==null)return;
       this.assignTitleTextField.setText(Bean.getAssigTitle());
       this.assignmentdTextField.setText(""+Bean.getAssginId());
       this.startDateTextField.setText(Bean.getStartDate());
       this.lastDateTextField.setText(Bean.getLastDate()); 
       this.whoDoTheAssignTextField.setText(Bean.getWhoDoTheAssign());
       this.descriptionTextArea.setText(Bean.getAssignDesc());
       this.remarksTextArea.setText(Bean.getRemarks());
       
         TeacherBean bean=(TeacherBean)TeacherComboBox.getSelectedItem();
        if(bean==null){return;}
       this.TeacherComboBox.setSelectedItem(bean.getDeptId()); 


 
    }//GEN-LAST:event_AssignTitleNameListValueChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    
      TeacherBean selectedBean = (TeacherBean) this.TeacherComboBox.getSelectedItem();
      int tracherId = selectedBean.getTeacherId();
        
       String  assignTitle = assignTitleTextField.getText();
       String   startDate = startDateTextField.getText();
       String lastDate=lastDateTextField.getText();
       String whoDoTheAssign=whoDoTheAssignTextField.getText();
       String description=descriptionTextArea.getText();
       String remarks = remarksTextArea.getText(); 
       try {
             int row = DatabaseManager.addAssignment(tracherId,assignTitle,startDate,lastDate,description,whoDoTheAssign,remarks);
            if(row>0){
                 JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");  
             getAssignment();
             clearButton2ActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
             }
        } catch (Exception ex) {
            Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
           javax.swing.JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        
        
        

    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        AssignmentBean selectedBean = (AssignmentBean) this.AssignTitleNameList.getSelectedValue();
        int assginId = selectedBean.getAssginId();

        String assignTitle = assignTitleTextField.getText();
        String startDate = startDateTextField.getText();
        String lastDate = lastDateTextField.getText();
        String whoDoTheAssign = whoDoTheAssignTextField.getText();
        String description = descriptionTextArea.getText();
        String remarks = remarksTextArea.getText();
        try {
            // Get the assignment ID you want to update. Replace 123 with the actual assignment ID.
            int row = DatabaseManager.updateAssignment(assginId, assignTitle, startDate, lastDate, description, whoDoTheAssign, remarks);
            if (row > 0) {
                JOptionPane.showMessageDialog(null, "RECORD UPDATED SUCCESSFULLY");
                // Additional logic if needed...
                getAssignment();
                clearButton2ActionPerformed(evt);
            } else {
                JOptionPane.showMessageDialog(null, "No rows updated. Check your conditions.");
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        AssignmentBean selectedBean = (AssignmentBean) this.AssignTitleNameList.getSelectedValue();
       if(selectedBean==null)return;
        int assginId = selectedBean.getAssginId();

        try {
            // Get the assignment ID you want to delete.
            int row = DatabaseManager.deleteAssignment(assginId);
            if (row > 0) {
                JOptionPane.showMessageDialog(null, "RECORD DELETED SUCCESSFULLY");
                // Additional logic if needed...
                getAssignment();
                clearButton2ActionPerformed(evt);
            } else {
                JOptionPane.showMessageDialog(null, "No rows deleted. Check your conditions.");
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton2ActionPerformed
        // TODO add your handling code here:
      
        assignmentdTextField.setText("");
        this.assignTitleTextField.setText("");
        this.startDateTextField.setText("");
        this.lastDateTextField.setText("");
        this.whoDoTheAssignTextField.setText("");
        this.descriptionTextArea.setText("");
        this. remarksTextArea.setText("");
    }//GEN-LAST:event_clearButton2ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.hide();
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
            java.util.logging.Logger.getLogger(AssignmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssignmentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList AssignTitleNameList;
    private javax.swing.JComboBox TeacherComboBox;
    private javax.swing.JToggleButton addButton;
    private javax.swing.JTextField assignTitleTextField;
    private javax.swing.JTextField assignmentdTextField;
    private javax.swing.JToggleButton backButton;
    private javax.swing.JToggleButton clearButton2;
    private javax.swing.JToggleButton deleteButton;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField lastDateTextField;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JTextField startDateTextField;
    private javax.swing.JToggleButton updateButton;
    private javax.swing.JTextField whoDoTheAssignTextField;
    // End of variables declaration//GEN-END:variables
}
