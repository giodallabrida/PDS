package PDS.telas;

import PDS.Modelo.ComandaDTO;
import PDS.Modelo.FuncionarioDTO;
import PDS.Persistencia.ComandaDAO;
import PDS.Persistencia.FuncionarioDAO;
import PDS.Util.Mensagens;
import PDS.Util.Validacao;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class relatorioComissoes extends javax.swing.JFrame {

    public relatorioComissoes() {
        initComponents();
        DefaultComboBoxModel modeloFuncionarios = new DefaultComboBoxModel();
        for (FuncionarioDTO funcionario : listaFuncionarios) {
            modeloFuncionarios.addElement(funcionario);
        }
        funcionarios.setModel(modeloFuncionarios);
        this.setLocationRelativeTo(null);
    }

    FuncionarioDAO funcDAO = new FuncionarioDAO();
    ArrayList<FuncionarioDTO> listaFuncionarios = funcDAO.carregaFuncionariosBD();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        data = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        data1 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnVoltar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        de = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        ate = new javax.swing.JTextField();
        pesquisa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        funcionarios = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jTextField13 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        jLabel18.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel18.setText("Período do relatório:");

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel5.setText("De:");

        jLabel17.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel17.setText("Até:");

        jTextField12.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/money.png"))); // NOI18N
        jLabel16.setText("TOTAL");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(571, 444));
        setMinimumSize(new java.awt.Dimension(571, 444));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 30)); // NOI18N
        jLabel1.setText("Relatório de Comissões");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/return option.png"))); // NOI18N
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel19.setText("Período do relatório:");

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel6.setText("De:");

        de.setText("27/10/2017");

        jLabel20.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel20.setText("Até:");

        ate.setText("01/11/2017");

        pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/search menor.png"))); // NOI18N
        pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel2.setText("Funcionário:");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data", "Cliente", "Serviço", "Valor total", "Valor obtido"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jTextField13.setEditable(false);

        jLabel21.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/money.png"))); // NOI18N
        jLabel21.setText("TOTAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127)
                                .addComponent(jLabel1)))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(de, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(funcionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVoltar)
                    .addComponent(jLabel1))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(de, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(ate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(funcionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    
    ComandaDAO comandaDAO = new ComandaDAO();
    private void pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaActionPerformed
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
        String data = formatarDate.format(date);
        if (Validacao.validaCampo(de) && Validacao.validaCampo(ate)) {
            if (Validacao.validaData(de.getText()) && (Validacao.validaData(ate.getText()))) 
            //&& (Validacao.comparaDatas(de.getText(), ate.getText()) <= 0)) // && ((Validacao.comparaDatas(de.getText(), data) <= 0) 
            // && (Validacao.comparaDatas(ate.getText(), data)) <= 0)) 
            {
                FuncionarioDTO funcionario = (FuncionarioDTO) funcionarios.getSelectedItem();
                int codFunc = funcionario.getCodFuncionario();
                Mensagens.msgAviso("DATA CORRETA");
                try {
                    this.relatorioComissoes = comandaDAO.carregaRelatorioComissoesBD(Validacao.converteStringData(de.getText()), Validacao.converteStringData(ate.getText()), codFunc);
                } catch (ParseException ex) {
                    Logger.getLogger(relatorioComissoes.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (relatorioComissoes != null) {
                    carregaTabelaRelatorioComissoes();
                }
            } else {
                Mensagens.msgAviso("As datas informadas não são válidas.");
            }
        } else {
            Mensagens.msgAviso("Preencha todos os campos.");
        }
    }
        
        ArrayList<ComandaDTO> relatorioComissoes;

    public void carregaTabelaRelatorioComissoes() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("Data");
        modelo.addColumn("Cliente");
        modelo.addColumn("Serviço");
        modelo.addColumn("Valor Total");
        modelo.addColumn("Valor obtido");
        

        for (ComandaDTO cdto : relatorioComissoes) {
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

        tabela.getColumnModel().getColumn(0).setPreferredWidth(110);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(110);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(110);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(110);

        tabela.setAutoResizeMode(0);
    }//GEN-LAST:event_pesquisaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ate;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField data;
    private javax.swing.JTextField data1;
    private javax.swing.JTextField de;
    private javax.swing.JComboBox<String> funcionarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JButton pesquisa;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
