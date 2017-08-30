package PDS.telas;

import PDS.Modelo.ClienteDTO;
import PDS.Modelo.FuncionarioDTO;
import PDS.Modelo.ServicoDTO;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCadastroFunc = new javax.swing.JButton();
        btnCadastroClientes = new javax.swing.JButton();
        btnCadastroServicos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnAgenda = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnComandas = new javax.swing.JButton();
        btnComissoes = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        btnAniversarios = new javax.swing.JButton();
        btnMarcados = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(650, 420));
        setMinimumSize(new java.awt.Dimension(650, 420));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel1.setText("Cadastros");

        btnCadastroFunc.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnCadastroFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/woman.png"))); // NOI18N
        btnCadastroFunc.setText("Funcionários");
        btnCadastroFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroFuncActionPerformed(evt);
            }
        });

        btnCadastroClientes.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnCadastroClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/multiple-users-silhouette.png"))); // NOI18N
        btnCadastroClientes.setText("Clientes");
        btnCadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroClientesActionPerformed(evt);
            }
        });

        btnCadastroServicos.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnCadastroServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/scissors-and-comb.png"))); // NOI18N
        btnCadastroServicos.setText("Serviços");
        btnCadastroServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroServicosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadastroClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastroFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastroServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(btnCadastroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnCadastroFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastroServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel3.setText("Agendamento");

        btnAgenda.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/notebook.png"))); // NOI18N
        btnAgenda.setText("Agenda");
        btnAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel2.setText("Relatórios");

        btnComandas.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnComandas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/comanda.png"))); // NOI18N
        btnComandas.setText("Comandas");
        btnComandas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComandasActionPerformed(evt);
            }
        });

        btnComissoes.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnComissoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/piggybank.png"))); // NOI18N
        btnComissoes.setText("Comissões");
        btnComissoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComissoesActionPerformed(evt);
            }
        });

        btnCaixa.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/moneyblack.png"))); // NOI18N
        btnCaixa.setText("Caixa");
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnComandas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(btnComissoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComandas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComissoes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );

        btnAniversarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/birthday-cake.png"))); // NOI18N
        btnAniversarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniversariosActionPerformed(evt);
            }
        });

        btnMarcados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/ficha.png"))); // NOI18N
        btnMarcados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(btnMarcados, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btnAniversarios, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMarcados)
                    .addComponent(btnAniversarios, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComandasActionPerformed
        if (Login.criaLogin()) {
            relatorioComandas rlComandas = new relatorioComandas();
            rlComandas.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnComandasActionPerformed

    private void btnComissoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComissoesActionPerformed
        if (Login.criaLogin()) {
            relatorioComissoes rlComissoes = new relatorioComissoes();
            rlComissoes.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnComissoesActionPerformed
    
    private void btnCadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroClientesActionPerformed
        cadastroClientes cadastro = new cadastroClientes(true, new ClienteDTO());
        cadastro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCadastroClientesActionPerformed

    private void btnCadastroFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroFuncActionPerformed
        if (Login.criaLogin()) {
            cadastroFuncionarios cadastro = new cadastroFuncionarios(true, new FuncionarioDTO());
            cadastro.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_btnCadastroFuncActionPerformed

    private void btnCadastroServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroServicosActionPerformed
        if (Login.criaLogin()) {
            cadastroServicos cadastro = new cadastroServicos(true, new ServicoDTO());
            cadastro.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCadastroServicosActionPerformed

    private void btnAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaActionPerformed
        Agenda ag = new Agenda();
        ag.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAgendaActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        if (Login.criaLogin()) {
            relatorioCaixa rlCaixa = new relatorioCaixa();
            rlCaixa.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnMarcadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcadosActionPerformed
        Marcados marcados = new Marcados();
        marcados.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMarcadosActionPerformed

    private void btnAniversariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniversariosActionPerformed
        relatorioAniversariantes rlAniversariantes = new relatorioAniversariantes();
        rlAniversariantes.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAniversariosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgenda;
    private javax.swing.JButton btnAniversarios;
    private javax.swing.JButton btnCadastroClientes;
    private javax.swing.JButton btnCadastroFunc;
    private javax.swing.JButton btnCadastroServicos;
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnComandas;
    private javax.swing.JButton btnComissoes;
    private javax.swing.JButton btnMarcados;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables
}