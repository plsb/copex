/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;

import br.certificate.CertificateDAO;
import br.location.Location;
import br.location.LocationDAO;
import br.location.LocationTableModel;
import br.person.Person;
import br.util.ConnectionFactory;
import br.util.FormataTamanhoColunasJTable;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pedro Saraiva
 */
public class FindCertificatesFrm extends javax.swing.JDialog {

    public static void show(Person p) {
        person = p;
        new FindCertificatesFrm().setVisible(true);

    }

    private static Person person;

    /**
     * Creates new form FindCertificatesFrm
     */
    public FindCertificatesFrm() {
        initComponents();
        setTitle("Certificados");
        setModal(true);
        setLocationRelativeTo(null);
        lblPerson.setText(person.getNome().toString());

        insertTableCertificates();

        SimpleDateFormat dfdtDataNascimento;
        dfdtDataNascimento = new SimpleDateFormat("dd/MM/yyyy");
        tfInitialDate.setText(dfdtDataNascimento.format(new Date()));
        
        FormataTamanhoColunasJTable.packColumns(tbCertificates, 1);
    }

    public void insertTableCertificates() {
        LocationDAO lDAO = new LocationDAO();

        LocationTableModel ltm = new LocationTableModel(lDAO.listPerPerson(person));
        tbCertificates.setModel(ltm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCertificates = new javax.swing.JTable();
        lblPerson = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        tfInitialDate = new javax.swing.JFormattedTextField();
        Descricao_Biblioteca3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(59, 89, 152));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Certificados");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 390, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(432, 177));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/imprimir2.png"))); // NOI18N
        jButton2.setToolTipText("Imrpimir Declaração");
        jButton2.setPreferredSize(new java.awt.Dimension(63, 39));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 57, 33));

        tbCertificates.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCertificates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCertificatesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbCertificatesMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbCertificates);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 660, 230));

        lblPerson.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblPerson.setText("Pessoa: ");
        jPanel1.add(lblPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, -1));

        jButton3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/SA.png"))); // NOI18N
        jButton3.setToolTipText("Sair");
        jButton3.setPreferredSize(new java.awt.Dimension(63, 39));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 57, 33));

        try {
            tfInitialDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfInitialDate.setToolTipText("Informe a Data Inicial ");
        tfInitialDate.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        tfInitialDate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfInitialDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 130, 20));

        Descricao_Biblioteca3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Descricao_Biblioteca3.setText("Data: ");
        jPanel1.add(Descricao_Biblioteca3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tfInitialDate.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a Data!");
            return;
        }

        JasperReport pathjrxml;
        HashMap parametros = new HashMap();

        String sql = "", texto = "";
        String dataInicial="";
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = new java.sql.Date(format.parse(tfInitialDate.getText()).getTime());
            dataInicial = String.valueOf(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        sql += "'" + dataInicial + "' and p.id=" + person.getId();

        try {
            parametros.put("sql", sql);
        } catch (Exception e) {
        }

        Connection connection = new ConnectionFactory().getConnection();
        try {
            JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
            viewer.setSize(1000, 600);
            viewer.setLocationRelativeTo(null);
            viewer.setModal(true);
            pathjrxml = JasperCompileManager.compileReport("report/reportDeliveryCertificate.jrxml");
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, parametros,
                    connection);
            JasperViewer jv = new JasperViewer(printReport, false);
            viewer.getContentPane().add(jv.getContentPane());
            viewer.setVisible(true);
                //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelAcervo.pdf");

            //jv.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbCertificatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCertificatesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int row = tbCertificates.getSelectedRow();
            if (row > -1) { //então tem ítem selecionado
                Object o = tbCertificates.getValueAt(row, 0);
                int id = Integer.parseInt(String.valueOf(o));

                LocationDAO lDAO = new LocationDAO();
                Location l = lDAO.checkExists("id", id).get(0);
                if (l != null) {
                    if (JOptionPane.showConfirmDialog(rootPane, "Entregar Certificado?",
                            "Opção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        l.setEntregue(true);
                        l.setDataEntregue(new Date());
                        lDAO.update(l);

                        insertTableCertificates();
                    }
                }

            }
        }
    }//GEN-LAST:event_tbCertificatesMouseClicked

    private void tbCertificatesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCertificatesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCertificatesMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FindCertificatesFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindCertificatesFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindCertificatesFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindCertificatesFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FindCertificatesFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descricao_Biblioteca3;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPerson;
    private javax.swing.JTable tbCertificates;
    private javax.swing.JFormattedTextField tfInitialDate;
    // End of variables declaration//GEN-END:variables
}
