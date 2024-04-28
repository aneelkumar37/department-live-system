/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package FRAMES;

import BeanClasses.DepartmentBean;
import BeanClasses.FacultyBean;
import BeanClasses.ProgramsBean;
import BeanClasses.TeacherBean;
import BeanClasses.TimeTableBean;
import DatabaseManager.DatabaseManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Dell
 */
public class TimeTableFrame extends javax.swing.JFrame {

    /**
     * Creates new form TimeTableFrame
     */
    //File selectedFile=null;
     String fileName;
      private File selectedFile;

    //System.out.print(fileName);
    
     public TimeTableFrame() {
        initComponents();
        getFaculty();
        getTimeTable();
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
    } 
     
      private void getTimeTable(){
        
         DepartmentBean bean = (DepartmentBean)departmentComboBox.getSelectedItem();
        if(bean==null){return;}
        try{
            Vector v=DatabaseManager.getTimeTable(bean.getDeptId());
            descNameList.setListData(v);            
        }catch(Exception e){e.printStackTrace();}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        facultyLabel = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        departmentLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        batchIdTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        browsTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        backButton = new javax.swing.JToggleButton();
        addButton = new javax.swing.JToggleButton();
        updateButton = new javax.swing.JToggleButton();
        deleteButton = new javax.swing.JToggleButton();
        browsButton = new javax.swing.JToggleButton();
        ViewButton = new javax.swing.JToggleButton();
        clearButton2 = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        picLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        descNameList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("TIME TABLE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 280, -1));

        facultyLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyLabel.setText("FACULTY");
        getContentPane().add(facultyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 120, 40));

        facultyComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
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
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 690, 40));

        departmentLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentLabel.setText("DEPARTMENT");
        getContentPane().add(departmentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 170, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
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
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 690, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("DESCRIPTION OF TIME TABLE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 400, 40));

        batchIdTextField.setEditable(false);
        batchIdTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        batchIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchIdTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(batchIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 140, 40));

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 400, 130));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("TIME TABLE ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 190, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("BROWS TIME TABLE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 610, 400, 40));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane3.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 400, 130));

        browsTextField.setEditable(false);
        browsTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        browsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(browsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 650, 390, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("REMARKS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 400, 40));

        backButton.setBackground(new java.awt.Color(242, 242, 242));
        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 570, 240, 50));

        addButton.setBackground(new java.awt.Color(242, 242, 242));
        addButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 750, 160, 50));

        updateButton.setBackground(new java.awt.Color(242, 242, 242));
        updateButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 750, -1, 50));

        deleteButton.setBackground(new java.awt.Color(242, 242, 242));
        deleteButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 750, 160, 50));

        browsButton.setBackground(new java.awt.Color(242, 242, 242));
        browsButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        browsButton.setText("BROWS");
        browsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(browsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 650, 160, 40));

        ViewButton.setBackground(new java.awt.Color(242, 242, 242));
        ViewButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ViewButton.setText("VIEW");
        ViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ViewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 570, 160, 40));

        clearButton2.setBackground(new java.awt.Color(242, 242, 242));
        clearButton2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        clearButton2.setText("CLEAR");
        clearButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 750, 160, 50));

        jLabel10.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("DESCRIPTION");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 50, 240, 20));

        picLabel.setBackground(new java.awt.Color(0, 0, 0));
        picLabel.setForeground(new java.awt.Color(255, 255, 255));
        picLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        picLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(picLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 290, 300));

        descNameList.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        descNameList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                descNameListValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(descNameList);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 80, 240, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
        // getDepartment();
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void departmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboBoxItemStateChanged
        // TODO add your handling code here:
        
          
        DepartmentBean bean=(DepartmentBean)departmentComboBox.getSelectedItem();
        if(bean==null){return;}
        try{
            Vector v=DatabaseManager.getTimeTable(bean.getDeptId());
            descNameList.setListData(v);     
          }catch(Exception e){e.printStackTrace();}

    }//GEN-LAST:event_departmentComboBoxItemStateChanged

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
        //getProgram();
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void batchIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batchIdTextFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    
    DepartmentBean selectedBean = (DepartmentBean)departmentComboBox.getSelectedItem();
     int deptId = selectedBean.getDeptId();
       //String stringValue = String.valueOf(deptId);
      
       String desctName = descriptionTextArea.getText();
      String remarks = remarksTextArea.getText();
      String iamgepath = browsTextField.getText();
   try{
      int row = DatabaseManager.addTimeTable(deptId, desctName, remarks);
   if (row > 0) {
        // If the image path is not empty
        if (!iamgepath.isEmpty()) {
            // Get the source file path
            Path sourcePath = Paths.get(iamgepath);

            // Set the destination folder
            String destinationFolder = "C:\\Users\\hp\\Desktop\\DEPARTMENT_LIVE_UPDATE_SYSTEM\\src\\ImageTimeTable";

            // Use desctName as the filename (replace invalid filename characters)
            String filename = desctName.replaceAll("[\\\\/:*?\"<>|]", "_") + ".jpg";

            // Build the destination file path
            String destinationFilePath = destinationFolder + File.separator + filename;

            // Copy the image file to the destination folder
            Files.copy(sourcePath, Paths.get(destinationFilePath), StandardCopyOption.REPLACE_EXISTING);
         
        }

        JOptionPane.showMessageDialog(null, row + " RECORD ADDED SUCCESSFULLY");
        getTimeTable();
        clearButton2ActionPerformed(evt);
    } else {
        JOptionPane.showMessageDialog(null, "Something went wrong");
    }
} catch (Exception ex) {
    ex.printStackTrace();
}

    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
       

 TimeTableBean selectedBean = (TimeTableBean) descNameList.getSelectedValue();
int timeId = selectedBean.getTimeTableId();

String desctName = descriptionTextArea.getText();
String remarks = remarksTextArea.getText();
String imagePath = browsTextField.getText();

try {
    // Assuming DatabaseManager.updateTimeTableWithImage method is available
    int updatedRow = DatabaseManager.updateTimeTable(timeId, desctName, remarks);

    if (updatedRow > 0) {
        // Update the associated image in the folder
        String destinationFolder = "C:\\Users\\hp\\Desktop\\DEPARTMENT_LIVE_UPDATE_SYSTEM\\src\\ImageTimeTable\\";
        String filenameToDelete = desctName.replaceAll("[\\\\/:*?\"<>|]", "_") + ".jpg";
        String pathToDelete = destinationFolder + File.separator + filenameToDelete;

        Files.deleteIfExists(Paths.get(pathToDelete));

        // Copy the new image to the destination folder
        Path sourcePath = Paths.get(imagePath);
        Path destinationPath = Paths.get(destinationFolder, desctName.replaceAll("[\\\\/:*?\"<>|]", "_") + ".jpg");
        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

        JOptionPane.showMessageDialog(null, updatedRow + " RECORD UPDATED SUCCESSFULLY");
        getTimeTable();
        clearButton2ActionPerformed(evt);
    } else {
        JOptionPane.showMessageDialog(null, "Error updating record");
    }
} catch (Exception e) {
    e.printStackTrace();
}



    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
 
       TimeTableBean selectedBean = (TimeTableBean) descNameList.getSelectedValue();
       int timeId = selectedBean.getTimeTableId();

        String desctName = descriptionTextArea.getText();
        String remarks = remarksTextArea.getText();
        String iamgepath = browsTextField.getText();

     try {
        int deletedRow = DatabaseManager.deleteTimeTable(timeId);

        if (deletedRow > 0) {
            // If the deletion is successful, also delete the associated image from the folder
            String destinationFolder = "C:\\Users\\hp\\Desktop\\DEPARTMENT_LIVE_UPDATE_SYSTEM\\src\\ImageTimeTable\\";
            String filenameToDelete = desctName.replaceAll("[\\\\/:*?\"<>|]", "_") + ".jpg";
            String pathToDelete = destinationFolder + File.separator + filenameToDelete;

            Files.deleteIfExists(Paths.get(pathToDelete));

           JOptionPane.showMessageDialog(null, deletedRow + " RECORD DELETED SUCCESSFULLY");
            getTimeTable();
            clearButton2ActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "Error deleting record");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }


    }//GEN-LAST:event_deleteButtonActionPerformed

    private void browsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsButtonActionPerformed
            
        
       JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select Image File");
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "gif"));

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    browsTextField.setText(filePath);
                    picLabel.setIcon(new ImageIcon(filePath));
                }                
    }//GEN-LAST:event_browsButtonActionPerformed

    private void ViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewButtonActionPerformed
        // TODO add your handling code here:
         TimeTableBean bean = (TimeTableBean) descNameList.getSelectedValue();
    if (bean == null) {
        // If no item is selected, you might want to show a message or perform some other action
        JOptionPane.showMessageDialog(this, "Please select an item from the list.");
        return;
    }

    String imagePath = "C:\\Users\\hp\\Desktop\\DEPARTMENT_LIVE_UPDATE_SYSTEM\\src\\ImageTimeTable\\" + bean.getDescription() + ".jpg";

    try {
        ImageIcon viewIcon = new ImageIcon(imagePath);

        // Create a new JFrame for displaying the image
        JFrame imageFrame = new JFrame("Image Viewer");
        imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Assuming 'picLabel' is a JLabel where you want to display the image
        JLabel picLabel = new JLabel(viewIcon);
        imageFrame.add(picLabel);

        // Set the size of the frame based on the image size
        imageFrame.setSize(viewIcon.getIconWidth(), viewIcon.getIconHeight());

        // Center the frame on the screen
        imageFrame.setLocationRelativeTo(null);

        // Make the frame visible
        imageFrame.setVisible(true);
    } catch (Exception e) {
        e.printStackTrace();
        // If there's an error loading the image, you might want to show a message or perform other error handling
        JOptionPane.showMessageDialog(this, "Error loading the image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_ViewButtonActionPerformed

    private void clearButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton2ActionPerformed
        // TODO add your handling code here:
        picLabel.setIcon(null);
         descriptionTextArea.setText("");
        remarksTextArea.setText("");
        batchIdTextField.setText("");
        browsTextField.setText("");
    }//GEN-LAST:event_clearButton2ActionPerformed

    private void descNameListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_descNameListValueChanged
        // TODO add your handling code here:
        
        TimeTableBean bean = (TimeTableBean)descNameList.getSelectedValue();
        if(bean==null)return;
         descriptionTextArea.setText(bean.getDescription());
         remarksTextArea.setText(bean.getRemarks());
         batchIdTextField.setText(""+bean.getTimeTableId());
       
         ImageIcon icon =new ImageIcon("C:\\Users\\hp\\Desktop\\DEPARTMENT_LIVE_UPDATE_SYSTEM\\src\\ImageTimeTable\\"+bean.getDescription()+".jpg");
          picLabel.setIcon(icon);
          
          //browsTextField.setText("");
     
    }//GEN-LAST:event_descNameListValueChanged

    private void browsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_browsTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(TimeTableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimeTableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimeTableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimeTableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimeTableFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ViewButton;
    private javax.swing.JToggleButton addButton;
    private javax.swing.JToggleButton backButton;
    private javax.swing.JTextField batchIdTextField;
    private javax.swing.JToggleButton browsButton;
    private javax.swing.JTextField browsTextField;
    private javax.swing.JToggleButton clearButton2;
    private javax.swing.JToggleButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JList descNameList;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel picLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JToggleButton updateButton;
    // End of variables declaration//GEN-END:variables
}
