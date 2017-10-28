package PDS.telas;

import PDS.Modelo.ComandaDTO;
import PDS.Modelo.ServicoComandaDTO;
import PDS.Persistencia.ComandaDAO;
import PDS.Util.Mensagens;
import PDS.Util.Validacao;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class relatorioComandas extends javax.swing.JFrame {

    public relatorioComandas() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        btnVoltar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        de = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        ate = new javax.swing.JTextField();
        pesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(609, 460));
        setMinimumSize(new java.awt.Dimension(609, 460));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel1.setText("Relatório de Comandas");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/return option.png"))); // NOI18N
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel18.setText("Período do relatório:");

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel5.setText("De:");

        jLabel17.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel17.setText("Até:");

        pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/search menor.png"))); // NOI18N
        pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cliente", "Data", "Total"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel18)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(de, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(de, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(ate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    // if ((Validacao.comparaDatas(de.getText(), data) >= 0) && (Validacao.comparaDatas(ate.getText(), data) >= 0)) {
    ComandaDAO comandaDAO = new ComandaDAO();
    private void pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaActionPerformed
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
        String data = formatarDate.format(date);
        if (Validacao.validaCampo(de) && Validacao.validaCampo(ate)) {
            if (Validacao.validaData(de.getText()) && (Validacao.validaData(ate.getText()))
                    && (Validacao.comparaDatas(de.getText(), ate.getText()) <= 0)) // && ((Validacao.comparaDatas(de.getText(), data) <= 0) 
            // && (Validacao.comparaDatas(ate.getText(), data)) <= 0)) 
            {
                Mensagens.msgAviso("DATA CORRETA");
                try {
                    this.relatorioComandas = comandaDAO.carregaRelatorioComandasBD(Validacao.converteStringData(de.getText()), Validacao.converteStringData(ate.getText()));
                } catch (ParseException ex) {
                    Logger.getLogger(relatorioComandas.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (relatorioComandas != null) {
                    carregaTabelaRelatorioComandas();
                }
            } else {
                Mensagens.msgAviso("As datas informadas não são válidas.");
            }
        } else {
            Mensagens.msgAviso("Preencha todos os campos.");
        }
    }//GEN-LAST:event_pesquisaActionPerformed

    ArrayList<ComandaDTO> relatorioComandas;

    public void carregaTabelaRelatorioComandas() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("Cliente");
        modelo.addColumn("Data");
        modelo.addColumn("Total");

        for (ComandaDTO cdto : relatorioComandas) {
            modelo.addRow(cdto.getLinhaTabela());
        }

        tabela.setModel(modelo);
        tabela.setAutoResizeMode(0);

        DefaultTableCellRenderer alinhamentoCentro = new DefaultTableCellRenderer();
        DefaultTableCellRenderer alinhamentoDireita = new DefaultTableCellRenderer();
        alinhamentoCentro.setHorizontalAlignment(SwingConstants.CENTER);
        alinhamentoDireita.setHorizontalAlignment(SwingConstants.CENTER);
        tabela.getColumnModel().getColumn(0).setCellRenderer(alinhamentoCentro);
        tabela.getColumnModel().getColumn(1).setCellRenderer(alinhamentoCentro);
        tabela.getColumnModel().getColumn(2).setCellRenderer(alinhamentoDireita);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(190);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(190);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(190);

        tabela.setAutoResizeMode(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ate;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField de;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton pesquisa;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
