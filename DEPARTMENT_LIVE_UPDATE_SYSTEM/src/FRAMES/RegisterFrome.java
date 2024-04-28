package FRAMES;

import DatabaseManager.DatabaseManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class RegisterFrome extends javax.swing.JFrame {

    /**
     * Creates new form ResgsterFrome
     */
    public RegisterFrome() {
        initComponents();
             java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        PasswordField = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        passField = new javax.swing.JPasswordField();
        SelectionjComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 0, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("REGISTER FROM");

        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jToggleButton1.setText("BACK");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel2)
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("CONFIRM PASS");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 180, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("FULL NAME");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 209, 60));

        nameTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel2.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 123, 290, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("USER EMAIL");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 160, 60));

        emailTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel2.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 203, 290, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("PASSWORD");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 209, 40));

        jButton1.setBackground(new java.awt.Color(255, 102, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REGISTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 490, 50));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jRadioButton1.setText("FEMALE");
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("MALE");
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, -1, -1));

        PasswordField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel2.add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 290, 40));

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox1.setText("Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, -1, -1));

        passField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel2.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 290, 40));

        SelectionjComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SelectionjComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ADMIN", "CR", "STUDENT" }));
        jPanel2.add(SelectionjComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 290, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Desktop\\DEPARTMENT_LIVE_UPDATE_SYSTEM\\src\\image\\rs.png")); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 610, 610));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 1110, 610));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1860, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addRecord();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:

        if(jCheckBox1.isSelected()) {
            PasswordField.setEchoChar((char)0);
           passField.setEchoChar((char)0); 
        }else{
            PasswordField.setEchoChar(('*'));
            passField.setEchoChar(('*'));
            
        }

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
         Login w=new Login();
         w.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void addRecord() {
    String name = this.nameTextField.getText();
    String email = this.emailTextField.getText();
    String pass = this.PasswordField.getText();
    String cp = passField.getText();
    
    String selection = (String) SelectionjComboBox1.getSelectedItem();

    // Check for empty fields
    if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || cp.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all the fields");
        return; // Don't proceed if any field is empty
    }

    // Check if the password and confirmation password match
    if (!pass.equals(cp)) {
        JOptionPane.showMessageDialog(null, "Password and confirmation password do not match");
        return;
    }

    try {
        // Assuming DatabaseManager has a method named addRegisterFrom
        int row = DatabaseManager.addRegsterFrom(name, pass, email,selection);

        if (row > 0) {
            JOptionPane.showMessageDialog(null, "SUCCESSFULLY  REGISTERED");
            
            // Open the Login window
            Login loginWindow = new Login();
            loginWindow.setVisible(true);

            // Close the current registration window
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
    } catch (Exception ex) {
        // Log the exception details for debugging
        ex.printStackTrace();

        // Display a user-friendly error message
        JOptionPane.showMessageDialog(null, "An error occurred during registration. Please try again.");
    }
}

    
    
    
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
            java.util.logging.Logger.getLogger(RegisterFrome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterFrome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterFrome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterFrome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterFrome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JComboBox SelectionjComboBox1;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPasswordField passField;
    // End of variables declaration//GEN-END:variables
}
