package com.mycompany.feedback_mng_sys;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public final class Admin extends javax.swing.JFrame {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String query = null;
    private String selectedFacultyId = null;
    private String selectedStudentId = null;

    public Admin() {
        initComponents();
        conn = DatabaseConnector.connect();
        updateFacultyTable();
        updateStudentTable();
        tableFaculty.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tableFaculty.getSelectedRow();
                    if (selectedRow >= 0) {
                        selectedFacultyId = tableFaculty.getValueAt(selectedRow, 0).toString();
                        btnDelete.setEnabled(true);
                    }
                }
            }
        });
        
        tableStudents.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tableStudents.getSelectedRow();
                    if (selectedRow >= 0) {
                        selectedStudentId = tableStudents.getValueAt(selectedRow, 0).toString();
                        btnDeleteStu.setEnabled(true);
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        tabFaculty = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tabStudents = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_admin_logout = new javax.swing.JButton();
        panTabs = new javax.swing.JPanel();
        panFaculty = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFaculty = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        panStudents = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableStudents = new javax.swing.JTable();
        btnAddStu = new javax.swing.JButton();
        btnDeleteStu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Home");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        tabFaculty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabFaculty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabFacultyMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Faculty");

        javax.swing.GroupLayout tabFacultyLayout = new javax.swing.GroupLayout(tabFaculty);
        tabFaculty.setLayout(tabFacultyLayout);
        tabFacultyLayout.setHorizontalGroup(
            tabFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabFacultyLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabFacultyLayout.setVerticalGroup(
            tabFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabFacultyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        tabStudents.setBackground(new java.awt.Color(204, 204, 204));
        tabStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabStudentsMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Students");

        javax.swing.GroupLayout tabStudentsLayout = new javax.swing.GroupLayout(tabStudents);
        tabStudents.setLayout(tabStudentsLayout);
        tabStudentsLayout.setHorizontalGroup(
            tabStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabStudentsLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabStudentsLayout.setVerticalGroup(
            tabStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabStudentsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel1.setText("Admin");

        btn_admin_logout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_admin_logout.setText("Logout");
        btn_admin_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_admin_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabFaculty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btn_admin_logout))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(97, 97, 97)
                .addComponent(tabFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tabStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_admin_logout)
                .addGap(18, 18, 18))
        );

        panTabs.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("Faculty");

        tableFaculty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableFaculty.setModel(new javax.swing.table.DefaultTableModel(
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
        tableFaculty.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tableFaculty.setRowHeight(25);
        jScrollPane1.setViewportView(tableFaculty);

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panFacultyLayout = new javax.swing.GroupLayout(panFaculty);
        panFaculty.setLayout(panFacultyLayout);
        panFacultyLayout.setHorizontalGroup(
            panFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFacultyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFacultyLayout.createSequentialGroup()
                        .addGap(0, 270, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(272, 272, 272))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFacultyLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFacultyLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panFacultyLayout.setVerticalGroup(
            panFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFacultyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(panFacultyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setText("Students");

        tableStudents.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableStudents.setModel(new javax.swing.table.DefaultTableModel(
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
        tableStudents.setRowHeight(25);
        jScrollPane2.setViewportView(tableStudents);

        btnAddStu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddStu.setText("Add");
        btnAddStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStuActionPerformed(evt);
            }
        });

        btnDeleteStu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeleteStu.setText("Delete");
        btnDeleteStu.setEnabled(false);
        btnDeleteStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panStudentsLayout = new javax.swing.GroupLayout(panStudents);
        panStudents.setLayout(panStudentsLayout);
        panStudentsLayout.setHorizontalGroup(
            panStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panStudentsLayout.createSequentialGroup()
                .addGroup(panStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panStudentsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
                    .addGroup(panStudentsLayout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddStu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteStu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(416, Short.MAX_VALUE))
        );
        panStudentsLayout.setVerticalGroup(
            panStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddStu)
                    .addComponent(btnDeleteStu))
                .addContainerGap())
        );

        javax.swing.GroupLayout panTabsLayout = new javax.swing.GroupLayout(panTabs);
        panTabs.setLayout(panTabsLayout);
        panTabsLayout.setHorizontalGroup(
            panTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panStudents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panTabsLayout.setVerticalGroup(
            panTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panStudents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panTabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panTabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_admin_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_admin_logoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        LoginForm lf = new LoginForm();
        lf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_admin_logoutActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Admin_Add_Faculty anf = new Admin_Add_Faculty(this);
        anf.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void tabFacultyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabFacultyMouseClicked
        panFaculty.setVisible(true);
        panStudents.setVisible(false);

        tabFaculty.setBackground(new Color(217, 217, 217));
        tabStudents.setBackground(new Color(204, 204, 204));

    }//GEN-LAST:event_tabFacultyMouseClicked

    private void tabStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabStudentsMouseClicked
        panFaculty.setVisible(false);
        panStudents.setVisible(true);

        tabStudents.setBackground(new Color(217, 217, 217));
        tabFaculty.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_tabStudentsMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // Ask the user for confirmation before deleting
            int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this faculty?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                // The user confirmed the deletion
                query = "DELETE FROM multiuserlogin WHERE ID = ?";
                pst = conn.prepareStatement(query);
                pst.setString(1, selectedFacultyId);
                int rows = pst.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Faculty deleted successfully!");
                    updateFacultyTable();
                }
            } else {
                // The user canceled the deletion
                JOptionPane.showMessageDialog(this, "Deletion canceled.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStuActionPerformed
        new AddStudent(this).setVisible(true);
    }//GEN-LAST:event_btnAddStuActionPerformed

    private void btnDeleteStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStuActionPerformed
        try {
            // Ask the user for confirmation before deleting
            int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                // The user confirmed the deletion
                query = "DELETE FROM multiuserlogin WHERE ID = ?";
                pst = conn.prepareStatement(query);
                pst.setString(1, selectedStudentId);
                int rows = pst.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Student deleted successfully!" + selectedStudentId);
                    updateStudentTable();
                }
            } else {
                // The user canceled the deletion
                JOptionPane.showMessageDialog(this, "Deletion canceled.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteStuActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddStu;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteStu;
    private javax.swing.JButton btn_admin_logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panFaculty;
    private javax.swing.JPanel panStudents;
    private javax.swing.JPanel panTabs;
    private javax.swing.JPanel tabFaculty;
    private javax.swing.JPanel tabStudents;
    private javax.swing.JTable tableFaculty;
    private javax.swing.JTable tableStudents;
    // End of variables declaration//GEN-END:variables

    public void updateFacultyTable() {
        try {
            query = "SELECT * FROM FacultyList";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id");
            model.addColumn("Name");
            model.addColumn("Email");
            model.addColumn("Branch");
            model.addColumn("Password");

            while (rs.next()) {
                Object[] row = new Object[5]; // Change 5 to the number of columns
                for (int i = 1; i <= 5; i++) { // Change 5 to the number of columns
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

            tableFaculty.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void updateStudentTable() {
        try {
            query = "SELECT s.std_prn, s.std_rollno, s.std_name, branches.branch_name, s.std_year, multiuserlogin.Password FROM student s JOIN branches ON s.branch_id = branches.branch_id JOIN multiuserlogin ON s.std_prn = multiuserlogin.ID";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Prn No");
            model.addColumn("Roll No");
            model.addColumn("Name");
            model.addColumn("Branch");
            model.addColumn("Year");
            model.addColumn("Password");

            while (rs.next()) {
                Object[] row = new Object[6];
                for (int i = 1; i <= 6; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

            tableStudents.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
