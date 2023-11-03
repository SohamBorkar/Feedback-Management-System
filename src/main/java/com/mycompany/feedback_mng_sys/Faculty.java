package com.mycompany.feedback_mng_sys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Faculty extends javax.swing.JFrame {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String loggedUserId;
    private String selectedFeedbackId = null;
    private String selectedFeedbackName = null;
    private String selectedTotalQue = null;

    public Faculty(String id) {
        initComponents();
        loggedUserId = id;
        try {
            String query = "SELECT f.* ,  branches.branch_name FROM faculty f JOIN branches ON f.branch_id = branches.branch_id WHERE f.faculty_id = ?";
            conn = DatabaseConnector.connect();
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            rs.next();
            txt_greeting.setText("Welcome " + rs.getString("faculty_name") + "!");
            txtFacId.setText(rs.getString("faculty_id"));
            txtBranch.setText(rs.getString("branch_name"));
            txtEmail.setText(rs.getString("email"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        getFeedbackList();

        tabFeedList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tabFeedList.getSelectedRow();
                    if (selectedRow >= 0) {
                        // active all buttons
                        btnPublish.setEnabled(true);
                        btnAnalysis.setEnabled(true);
                        btnReset.setEnabled(true);
                        btnDelete.setEnabled(true);

                        selectedFeedbackId = tabFeedList.getValueAt(selectedRow, 0).toString();
                        selectedFeedbackName = tabFeedList.getValueAt(selectedRow, 1).toString();
                        selectedTotalQue = tabFeedList.getValueAt(selectedRow, 3).toString();
                        if ("Published".equals(tabFeedList.getValueAt(selectedRow, 5).toString())) {
                            btnPublish.setText("Unpublish");
                            btnAnalysis.setEnabled(true);
                        } else {
                            btnPublish.setText("Publish");
                            btnAnalysis.setEnabled(false);
                        }
                    }
                }

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_greeting = new javax.swing.JLabel();
        btn_fac_logout = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFacId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBranch = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabFeedList = new javax.swing.JTable();
        btnPublish = new javax.swing.JButton();
        btnAnalysis = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Faculty Home");
        setResizable(false);

        txt_greeting.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_greeting.setText("Welcome Faculty !");

        btn_fac_logout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_fac_logout.setText("Logout");
        btn_fac_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fac_logoutActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("+ Create New Feedback");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Id: ");

        txtFacId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFacId.setText("null");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Branch:");

        txtBranch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBranch.setText("null");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setText("null");

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tabFeedList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabFeedList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabFeedList.setRowHeight(25);
        jScrollPane1.setViewportView(tabFeedList);

        btnPublish.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPublish.setText("Publish");
        btnPublish.setEnabled(false);
        btnPublish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublishActionPerformed(evt);
            }
        });

        btnAnalysis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAnalysis.setText("View Analysis");
        btnAnalysis.setEnabled(false);
        btnAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalysisActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setEnabled(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnPublish, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAnalysis)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnReset)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDelete))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFacId)
                                    .addGap(56, 56, 56)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtBranch)
                                    .addGap(56, 56, 56)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEmail))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txt_greeting)
                                    .addGap(127, 127, 127)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_fac_logout))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_greeting)
                    .addComponent(btn_fac_logout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFacId)
                    .addComponent(jLabel2)
                    .addComponent(txtBranch)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPublish)
                    .addComponent(btnAnalysis)
                    .addComponent(btnReset)
                    .addComponent(btnDelete))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_fac_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fac_logoutActionPerformed

        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            this.dispose(); // Close the current window
            LoginForm lf = new LoginForm();
            lf.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btn_fac_logoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Faculty_Create_New_Feedback fcnf = new Faculty_Create_New_Feedback(loggedUserId);
        fcnf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete and unpublish this feedback?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirmationResult == JOptionPane.YES_OPTION) {
            // User confirmed the deletion, proceed with the deletion and unpublishing
            unPublishFeedback(selectedFeedbackId);

            try {
                String query = "DELETE FROM feedbacks WHERE feed_id = ?";
                pst = conn.prepareStatement(query);
                pst.setString(1, selectedFeedbackId);
                pst.executeUpdate();
                getFeedbackList();

                getFeedbackList();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnPublishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublishActionPerformed
        if ("Publish".equals(btnPublish.getText())) {
            publishFeedback(selectedFeedbackId);
        } else {
            unPublishFeedback(selectedFeedbackId);
        }
    }//GEN-LAST:event_btnPublishActionPerformed

    private void btnAnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalysisActionPerformed
        this.dispose();
        new Faculty_Feedback_Analytics(Integer.parseInt(selectedFeedbackId), selectedFeedbackName, Integer.parseInt(selectedTotalQue), Integer.parseInt(loggedUserId)).setVisible(true);
    }//GEN-LAST:event_btnAnalysisActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        int confirmationResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to reset this feedback?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirmationResult == JOptionPane.YES_OPTION) {
            // User confirmed the reset, proceed with publishing and unpublishing
            unPublishFeedback(selectedFeedbackId);
            publishFeedback(selectedFeedbackId);

            // Perform any additional actions after reset if needed
        }
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Faculty().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalysis;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPublish;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btn_fac_logout;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabFeedList;
    private javax.swing.JLabel txtBranch;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtFacId;
    private javax.swing.JLabel txt_greeting;
    // End of variables declaration//GEN-END:variables

    private void getFeedbackList() {
        try {
            String query = "SELECT\n"
                    + "    feedbacks.*,\n"
                    + "    (\n"
                    + "        SELECT COUNT(DISTINCT std_prn)\n"
                    + "        FROM std_feedback\n"
                    + "        WHERE feed_id = feedbacks.feed_id\n"
                    + "        AND is_completed = 'completed'\n"
                    + "    ) AS responses\n"
                    + "FROM feedbacks\n"
                    + "WHERE by_faculty_Id = ?;";
            pst = conn.prepareStatement(query);
            pst.setString(1, loggedUserId);
            rs = pst.executeQuery();

            // Create a DefaultTableModel with column names
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Feedback Id");
            model.addColumn("Feedback Name");
            model.addColumn("Created On");
            model.addColumn("No of Questions");
            model.addColumn("Responses");
            model.addColumn("Status");

            // Populate the model with data from the result set
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("feed_id"),
                    rs.getString("feed_name"),
                    rs.getTimestamp("feed_time"),
                    rs.getInt("no_que"),
                    rs.getInt("responses"),
                    rs.getString("feed_status")
                });
            }

            // Set the table model to your JTable
            tabFeedList.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void publishFeedback(String feedbackId) {
        try {
            String query = "CALL AddFeedbackForAllStudents(?)";
            pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, feedbackId);
            pst.executeUpdate();
            btnPublish.setEnabled(false);
            btnAnalysis.setEnabled(false);
            btnReset.setEnabled(false);
            btnDelete.setEnabled(false);

            getFeedbackList();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void unPublishFeedback(String feedbackId) {
        try {
            String query = "CALL RemoveFeedbackForAllStudents(?)";
            pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, feedbackId);
            pst.executeUpdate();
            btnPublish.setEnabled(false);
            btnAnalysis.setEnabled(false);
            btnReset.setEnabled(false);
            btnDelete.setEnabled(false);

            getFeedbackList();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
