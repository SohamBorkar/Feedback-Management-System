package com.mycompany.feedback_mng_sys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Student extends javax.swing.JFrame {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String query = null;
    private String stdId;
    private String loggedInStudentId;

    // parameters for give feedback class
    private String feedbackId = null;
    private String feedName = null;
    private String totalQes = null;
    private String createdBy = null;
    private String createdOn = null;

    public Student(String id) {
        initComponents();
        conn = DatabaseConnector.connect();
        loggedInStudentId = id;
        generateData();
        getFeedbackList();
        tabFeedList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (isPending(e)) {
                    btnGiveFeed.setEnabled(true);
                } else {
                    btnGiveFeed.setEnabled(false);
                }
            }
        });

    }

    // Associate the btn_std_logoutActionPerformed method with the "Logout" button
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_std_greet = new javax.swing.JLabel();
        btn_std_logout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabFeedList = new javax.swing.JTable();
        txt_std_greet1 = new javax.swing.JLabel();
        txt_std_greet2 = new javax.swing.JLabel();
        txt_std_greet3 = new javax.swing.JLabel();
        txt_std_greet4 = new javax.swing.JLabel();
        txtBranch = new javax.swing.JLabel();
        txtYear = new javax.swing.JLabel();
        txtPrn = new javax.swing.JLabel();
        txtRollNo = new javax.swing.JLabel();
        btnGiveFeed = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Home");
        setResizable(false);

        txt_std_greet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_std_greet.setText("Welcome Student !");

        btn_std_logout.setText("Logout");
        btn_std_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_std_logoutActionPerformed(evt);
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

        txt_std_greet1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_std_greet1.setText("PRN: ");

        txt_std_greet2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_std_greet2.setText("Branch: ");

        txt_std_greet3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_std_greet3.setText("Roll No:");

        txt_std_greet4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_std_greet4.setText("Year:");

        txtBranch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBranch.setText("Null");

        txtYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtYear.setText("Null");

        txtPrn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrn.setText("Null");

        txtRollNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRollNo.setText("Null");

        btnGiveFeed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGiveFeed.setText("Give Feedback");
        btnGiveFeed.setEnabled(false);
        btnGiveFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiveFeedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_std_greet1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_std_greet2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBranch)))
                        .addGap(168, 168, 168)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_std_greet3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRollNo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_std_greet4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtYear))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGiveFeed)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_std_greet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_std_logout))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_std_greet)
                    .addComponent(btn_std_logout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_std_greet1)
                    .addComponent(txt_std_greet3)
                    .addComponent(txtRollNo)
                    .addComponent(txtPrn))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_std_greet2)
                    .addComponent(txt_std_greet4)
                    .addComponent(txtBranch)
                    .addComponent(txtYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGiveFeed)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_std_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_std_logoutActionPerformed

        this.dispose();
        LoginForm lf = new LoginForm();
        lf.setVisible(true);
    }//GEN-LAST:event_btn_std_logoutActionPerformed

    private void btnGiveFeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiveFeedActionPerformed
        this.dispose();
        new GiveFeedback(feedbackId, feedName, totalQes, createdBy, createdOn).setVisible(true);
    }//GEN-LAST:event_btnGiveFeedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
 /* Create and display the form */

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
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Student().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiveFeed;
    private javax.swing.JButton btn_std_logout;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabFeedList;
    private javax.swing.JLabel txtBranch;
    private javax.swing.JLabel txtPrn;
    private javax.swing.JLabel txtRollNo;
    private javax.swing.JLabel txtYear;
    private javax.swing.JLabel txt_std_greet;
    private javax.swing.JLabel txt_std_greet1;
    private javax.swing.JLabel txt_std_greet2;
    private javax.swing.JLabel txt_std_greet3;
    private javax.swing.JLabel txt_std_greet4;
    // End of variables declaration//GEN-END:variables

    private void generateData() {
        try {
            String query = "SELECT s.std_name, s.std_prn, s.std_rollno, branches.branch_name, s.std_year FROM student s JOIN branches ON s.branch_id = branches.branch_id WHERE s.std_prn = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, loggedInStudentId);
            rs = pst.executeQuery();
            rs.next();
            txt_std_greet.setText("Welcome " + rs.getString("std_name") + "!");
            txtPrn.setText(rs.getString("std_prn"));
            txtRollNo.setText(rs.getString("std_rollno"));
            txtBranch.setText(rs.getString("branch_name"));
            txtYear.setText(rs.getString("std_year"));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getFeedbackList() {
        try {
            String query = "CALL GetStudentFeedbacks(?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, loggedInStudentId);
            rs = pst.executeQuery();

            // Create a DefaultTableModel with column names
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id");
            model.addColumn("Feedback Name");
            model.addColumn("Created By");
            model.addColumn(    "No of Questions");
            model.addColumn("Created On");
            model.addColumn("Status");

            // Populate the model with data from the result set
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("feed_id"),
                    rs.getString("Feedback Name"),
                    rs.getString("Created By"),
                    rs.getInt("No of Questions"),
                    rs.getTimestamp("Created On"),
                    rs.getString("Status")
                });
            }

            // Set the table model to your JTable
            tabFeedList.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isPending(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabFeedList.getSelectedRow();
            if (selectedRow >= 0) {
                feedbackId = tabFeedList.getValueAt(selectedRow, 0).toString();
                feedName = tabFeedList.getValueAt(selectedRow, 1).toString();
                createdBy = tabFeedList.getValueAt(selectedRow, 2).toString();
                totalQes = tabFeedList.getValueAt(selectedRow, 3).toString();
                createdOn = tabFeedList.getValueAt(selectedRow, 4).toString();
                Object selectedData = tabFeedList.getValueAt(selectedRow, 5);
                if ("pending".equals(selectedData.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
