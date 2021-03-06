package PDS.telas;

import PDS.Modelo.ClienteDTO;
import PDS.Modelo.ComandaDTO;
import PDS.Modelo.FuncionarioDTO;
import PDS.Modelo.ServicoDTO;
import PDS.Persistencia.ComandaDAO;
import PDS.Persistencia.FuncionarioDAO;
import PDS.Util.Mensagens;
import java.util.ArrayList;

public class Menu extends javax.swing.JFrame {

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    boolean vazio = false;

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        funcionarioDAO.verificaExecucao();
        this.listaComandas = comandaDAO.carregaComandasBD();
        if (listaComandas.isEmpty()) {
            vazio = true;
        }
        this.setTitle("Menu");
    }

    ComandaDAO comandaDAO = new ComandaDAO();

    ArrayList<ComandaDTO> listaComandas = new ArrayList();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCadastroFunc = new javax.swing.JButton();
        btnCadastroClientes = new javax.swing.JButton();
        btnCadastroServicos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        comanda = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnComandas = new javax.swing.JButton();
        btnComissoes = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        btnAniversarios = new javax.swing.JButton();
        alteraLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Bandeira = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(650, 420));
        setMinimumSize(new java.awt.Dimension(650, 420));
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(723, 417));
        jPanel5.setMinimumSize(new java.awt.Dimension(723, 417));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        comanda.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        comanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/comanda.png"))); // NOI18N
        comanda.setText("Gerar comanda");
        comanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comandaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comanda)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(comanda, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap()
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        btnAniversarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/birthday-cake.png"))); // NOI18N
        btnAniversarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniversariosActionPerformed(evt);
            }
        });

        alteraLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/settings-gears.png"))); // NOI18N
        alteraLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alteraLoginActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel4.setText("Mademoiselle");

        Bandeira.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/bandeira.png"))); // NOI18N
        Bandeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BandeiraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Bandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(alteraLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAniversarios, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(alteraLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(Bandeira, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAniversarios)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        if (vazio) {
            cadastroClientes cadastro = new cadastroClientes(true, new ClienteDTO());
            cadastro.setVisible(true);
            this.setVisible(false);
        } else {
            Mensagens.msgAviso("Para entrar no cadastro de clientes, você precisa \n encerrar todas as comandas em aberto.");
        }
    }//GEN-LAST:event_btnCadastroClientesActionPerformed

    private void btnCadastroFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroFuncActionPerformed
        if (vazio) {
            if (Login.criaLogin()) {
                cadastroFuncionarios cadastro = new cadastroFuncionarios(true, new FuncionarioDTO());
                cadastro.setVisible(true);
                this.setVisible(false);
            }
        } else {
            Mensagens.msgAviso("Para entrar no cadastro de funcionários, você precisa \n encerrar todas as comandas em aberto.");
        }
    }//GEN-LAST:event_btnCadastroFuncActionPerformed

    private void btnCadastroServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroServicosActionPerformed
        if (vazio) {
            if (Login.criaLogin()) {
                cadastroServicos cadastro = new cadastroServicos(true, new ServicoDTO());
                cadastro.setVisible(true);
                this.setVisible(false);
            }
        } else {
            Mensagens.msgAviso("Para entrar no cadastro de serviços, você precisa \n encerrar todas as comandas em aberto.");
        }
    }//GEN-LAST:event_btnCadastroServicosActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        if (Login.criaLogin()) {
            relatorioCaixa rlCaixa = new relatorioCaixa();
            rlCaixa.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCaixaActionPerformed


    private void btnAniversariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniversariosActionPerformed
        relatorioAniversariantes rlAniversariantes = new relatorioAniversariantes();
        rlAniversariantes.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAniversariosActionPerformed

    Login login = new Login(this, true);
    private void alteraLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alteraLoginActionPerformed
        if (login.criaLogin()) {
            AlteraLogin alt = new AlteraLogin();
            alt.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_alteraLoginActionPerformed

    private void comandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comandaActionPerformed
        ListaComandas listaComandas = new ListaComandas();
        listaComandas.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_comandaActionPerformed

    private void BandeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BandeiraActionPerformed
        if (login.criaLogin()) {
            AlteraPorcentagem bandeira = new AlteraPorcentagem();
            bandeira.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_BandeiraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bandeira;
    private javax.swing.JButton alteraLogin;
    private javax.swing.JButton btnAniversarios;
    private javax.swing.JButton btnCadastroClientes;
    private javax.swing.JButton btnCadastroFunc;
    private javax.swing.JButton btnCadastroServicos;
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnComandas;
    private javax.swing.JButton btnComissoes;
    private javax.swing.JButton comanda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
