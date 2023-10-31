package com.mycompany.feedback_mng_sys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

public class GiveFeedback extends javax.swing.JFrame {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String query = null;
    private int curQue = 1;
    private int totalQue;
    private int feedbackId;
    private String loggedStudentId;
    private int selectedIndex = -1;
    private String[] radio_option = new String[5];
    private int counter = 0;
    private String manual_trigger = null;
    private PreparedStatement pst_trigger = null;
    private ResultSet rs_trigger = null;

    public GiveFeedback(String feedbackId, String feedName, String totalQes, String createdBy, String createdOn, String loggedStudentId) {
        initComponents();
        conn = DatabaseConnector.connect();
        totalQue = Integer.parseInt(totalQes);
        this.feedbackId = Integer.parseInt(feedbackId);
        txtQuestion.setText("<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</html>");
        txtFeedName.setText(feedName);
        txtTotalQue.setText(totalQes);
        txtCreatedBy.setText(createdBy);
        txtCreatedOn.setText(createdOn);
        txtQueNo.setText("Q. " + Integer.toString(curQue) + ".");
        this.loggedStudentId = loggedStudentId;
        updateQuestion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        options = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCreatedBy = new javax.swing.JLabel();
        txtFeedName = new javax.swing.JLabel();
        txtCreatedOn = new javax.swing.JLabel();
        txtTotalQue = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtQueNo = new javax.swing.JLabel();
        txtQuestion = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Give Feedback");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Feedback name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Created by:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Total questions:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Created on:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Feedback Form");

        txtCreatedBy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCreatedBy.setText("null");

        txtFeedName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFeedName.setText("null");

        txtCreatedOn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCreatedOn.setText("null");

        txtTotalQue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotalQue.setText("null");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtQueNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQueNo.setText("Q. 0.");

        txtQuestion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQuestion.setText("null");
        txtQuestion.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        options.add(jRadioButton1);
        jRadioButton1.setText("jRadioButton1");

        options.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");

        options.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");

        options.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        options.add(jRadioButton5);
        jRadioButton5.setText("jRadioButton5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtQueNo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQueNo)
                    .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton5)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        btnNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNext.setText("Next >");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPrevious.setText("< Previous");
        btnPrevious.setEnabled(false);
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnCancle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancle.setText("Cancle");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFeedName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCreatedBy)))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalQue))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCreatedOn)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtFeedName)
                    .addComponent(txtTotalQue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtCreatedBy)
                    .addComponent(txtCreatedOn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(btnCancle))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (options.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Select the option", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (curQue == totalQue) {
                int confirmResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to submit?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    opsSelected();
                    submitFeedback();
                    try {
                        manual_trigger = "UPDATE std_feedback SET is_completed = 'completed' WHERE std_prn = ? AND feed_id = ?";
                        pst_trigger = conn.prepareStatement(manual_trigger, PreparedStatement.RETURN_GENERATED_KEYS);
                        pst_trigger.setInt(1, Integer.parseInt(loggedStudentId));
                        pst_trigger.setInt(2, feedbackId);
                        int rowsAffected_trigger = pst_trigger.executeUpdate();
                        if (rowsAffected_trigger < 0) {
                            JOptionPane.showMessageDialog(this, "Error while performing manual trigger", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.dispose();
                    Student s = new Student(loggedStudentId);
                    s.setVisible(true);
                    JOptionPane.showMessageDialog(this, "Feedback Submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                opsSelected();
                submitFeedback();
                curQue++;
                btnPrevious.setEnabled(true);
                txtQueNo.setText("Q. " + Integer.toString(curQue) + ".");
                updateQuestion();
                options.clearSelection();
                if (curQue == totalQue) {
                    btnNext.setText("Submit");
                }
            }
        }
//        for(int i = 0; i < 5; i++){
//            System.out.println(radio_option[i]);
//        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        btnNext.setText("Next >");
        curQue--;
        txtQueNo.setText("Q. " + Integer.toString(curQue) + ".");
        updateQuestion();
        if (curQue == 1) {
            btnPrevious.setEnabled(false);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(GiveFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiveFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiveFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiveFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GiveFeedback(feedbackId, feedName, totalQes, createdBy, createdOn).setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.ButtonGroup options;
    private javax.swing.JLabel txtCreatedBy;
    private javax.swing.JLabel txtCreatedOn;
    private javax.swing.JLabel txtFeedName;
    private javax.swing.JLabel txtQueNo;
    private javax.swing.JLabel txtQuestion;
    private javax.swing.JLabel txtTotalQue;
    // End of variables declaration//GEN-END:variables

    private void updateQuestion() {
        try {
            query = "CALL GetQuestionByFeedId(?,?)";
            pst = conn.prepareStatement(query);
            pst.setInt(1, feedbackId);
            pst.setInt(2, curQue);
            rs = pst.executeQuery();

            if (rs.next()) {
                txtQuestion.setText(rs.getString("question"));
                jRadioButton1.setText(rs.getString("ops1"));
                jRadioButton2.setText(rs.getString("ops2"));
                jRadioButton3.setText(rs.getString("ops3"));
                jRadioButton4.setText(rs.getString("ops4"));
                jRadioButton5.setText(rs.getString("ops5"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void opsSelected() {
        ButtonModel selectedButtonModel = options.getSelection();
        if (selectedButtonModel != null) {
            // Get the index of the selected radio button
            Enumeration<AbstractButton> buttons = options.getElements();
            int selectedIndex = 1;

            while (buttons.hasMoreElements()) {
                if (selectedButtonModel == buttons.nextElement().getModel()) {
                    // Found the selected button
                    break;
                }
                selectedIndex++;
            }
            counter++;

            switch (selectedIndex) {
                case 1:
                    radio_option[counter] = "ops1";
                    break;
                case 2:
                    radio_option[counter] = "ops2";
                    break;
                case 3:
                    radio_option[counter] = "ops3";
                    break;
                case 4:
                    radio_option[counter] = "ops4";
                    break;
                case 5:
                    radio_option[counter] = "ops5";
                    break;
                default:
                    System.out.println("Invalid optin selected by user");
                    break;
            }
//            JOptionPane.showMessageDialog(this, "You slected index" + selectedIndex + "and option is " + radio_option[counter]);
        }
    }

    private void submitFeedback() {
        try {
            query = "INSERT INTO Std_Feedback_Responses (std_prn, feed_Id, que_no, ops_selected, is_given) VALUES (?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, Integer.parseInt(loggedStudentId));
            pst.setInt(2, feedbackId);
            pst.setInt(3, curQue);
            pst.setString(4, radio_option[counter]);
            pst.setBoolean(5, true);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected < 0) {
                JOptionPane.showMessageDialog(this, "Some error occured...", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
