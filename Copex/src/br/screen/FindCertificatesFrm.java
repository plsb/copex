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
import br.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

        insertTableCertificates(false);

        SimpleDateFormat dfdtDataNascimento;
        dfdtDataNascimento = new SimpleDateFormat("dd/MM/yyyy");
        tfInitialDate.setText(dfdtDataNascimento.format(new Date()));

        FormataTamanhoColunasJTable.packColumns(tbCertificates, 1);
        String texto="";
        if(person.ispExterno()){
            texto = "Público Externo";
        } else {
            texto = "Público Interno";
        }
        if(person.isProfessor()){
            texto += ", Professor.";
        } else {
            texto += ".";
        }
        lblInfo.setText(texto);
    }

    public void insertTableCertificates(boolean entregue) {
        LocationDAO lDAO = new LocationDAO();

        List<Location> locationsPerson = lDAO.listPerPerson(person, entregue);
        List<Location> locationsCoautores = lDAO.listPerCoautores(person, entregue);
        List<Location> locationsFinal = new ArrayList<>();
        locationsFinal.addAll(locationsPerson);
        locationsFinal.addAll(locationsCoautores);
        LocationTableModel ltm = new LocationTableModel(locationsFinal);
        tbCertificates.setModel(ltm);
        FormataTamanhoColunasJTable.packColumns(tbCertificates, 1);
        tbCertificates.setAutoCreateRowSorter(true);
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
        btIMprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCertificates = new javax.swing.JTable();
        lblInfo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        tfInitialDate = new javax.swing.JFormattedTextField();
        lblData = new javax.swing.JLabel();
        cbSituacao = new javax.swing.JComboBox();
        btPesquisar = new javax.swing.JButton();
        lblPerson = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(59, 89, 152));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Consulta de Certificados");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 460, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(432, 177));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btIMprimir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btIMprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/imprimir2.png"))); // NOI18N
        btIMprimir.setToolTipText("Imrpimir Declaração");
        btIMprimir.setPreferredSize(new java.awt.Dimension(63, 39));
        btIMprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIMprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btIMprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 57, 33));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 760, 230));

        lblInfo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblInfo.setText("lblInfo");
        jPanel1.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 520, -1));

        jButton3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/SA.png"))); // NOI18N
        jButton3.setToolTipText("Sair");
        jButton3.setPreferredSize(new java.awt.Dimension(63, 39));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 57, 33));

        try {
            tfInitialDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfInitialDate.setToolTipText("Informe a Data Inicial ");
        tfInitialDate.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        tfInitialDate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfInitialDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 130, 20));

        lblData.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblData.setText("Data: ");
        jPanel1.add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        cbSituacao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não Entregues", "Entregues" }));
        jPanel1.add(cbSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/procurar_1.png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar Certificados");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 9, 40, 30));

        lblPerson.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblPerson.setText("Pessoa: ");
        jPanel1.add(lblPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 520, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void btIMprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIMprimirActionPerformed
        if (tfInitialDate.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a Data!");
            return;
        }

        JasperReport pathjrxml;
        HashMap parametros = new HashMap();

        String sql = "", texto = "";
        String dataInicial = "";
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = new java.sql.Date(format.parse(tfInitialDate.getText()).getTime());
            dataInicial = String.valueOf(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        sql += "'" + dataInicial + "' and l.pessoaEntregue_id=" + person.getId();

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
            File file = new File(Util.retornaCaminhoApp()+"/report/reportDeliveryCertificate.jrxml");
            FileInputStream is = new FileInputStream(file);
            pathjrxml = JasperCompileManager.compileReport(is);
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, parametros,
                    connection);
            JasperViewer jv = new JasperViewer(printReport, false);
            viewer.getContentPane().add(jv.getContentPane());
            viewer.setVisible(true);
                //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelAcervo.pdf");

            //jv.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }


    }//GEN-LAST:event_btIMprimirActionPerformed

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
                    if (l.isEntregue()==false) {
                        if (JOptionPane.showConfirmDialog(rootPane, "Entregar Certificado?",
                                "Opção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            l.setEntregue(true);
                            l.setDataEntregue(new Date());
                            l.setPessoaEntregue(person);
                            lDAO.update(l);

                            btPesquisarActionPerformed(null);
                        }
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

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        // TODO add your handling code here:
        insertTableCertificates(cbSituacao.getSelectedIndex() == 1);
        tfInitialDate.setVisible(cbSituacao.getSelectedIndex() == 0);
        btIMprimir.setVisible(cbSituacao.getSelectedIndex() == 0);
        lblData.setVisible(cbSituacao.getSelectedIndex() == 0);

    }//GEN-LAST:event_btPesquisarActionPerformed

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
    private javax.swing.JButton btIMprimir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JComboBox cbSituacao;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblPerson;
    private javax.swing.JTable tbCertificates;
    private javax.swing.JFormattedTextField tfInitialDate;
    // End of variables declaration//GEN-END:variables
}
