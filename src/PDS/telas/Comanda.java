package PDS.telas;

import PDS.Modelo.ClienteDTO;
import PDS.Modelo.ComissaoDTO;
import PDS.Modelo.FuncionarioDTO;
import PDS.Modelo.ServicoComandaDTO;
import PDS.Persistencia.ClienteDAO;
import PDS.Persistencia.ComandaDAO;
import PDS.Persistencia.FuncionarioDAO;
import PDS.Persistencia.ServicoDAO;
import PDS.Util.Mensagens;
import PDS.Util.Validacao;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Comanda extends javax.swing.JFrame {

    public Comanda() {
        initComponents();
        carregaCombinacoesComanda();
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
        data.setText(formatarDate.format(date));
        this.setLocationRelativeTo(null);
    }

    ClienteDAO cliDAO = new ClienteDAO();
    FuncionarioDAO funcDAO = new FuncionarioDAO();
    ServicoDAO servDAO = new ServicoDAO();
    ArrayList<ClienteDTO> listaClientes = cliDAO.carregaClientesBD();
    ArrayList<FuncionarioDTO> listaFuncionarios = funcDAO.carregaFuncionariosBD();
    ArrayList<ComissaoDTO> listaServicos;
    ArrayList<ServicoComandaDTO> listaServicosComanda;
    
   // public boolean cadastraAlteraComanda(JComboBox cliente, JTextField data, JTextField total){
        boolean aux = false;
        boolean certo = false;
        //if()
   // }
    
    /*
    public boolean cadastraAlteraFuncionario(JTextField nomeFunc, JTextField cpfFunc, JTextField rgFunc, JTextField datNascFunc, JTextField telFunc, JTextArea endFunc) throws SQLException, FileNotFoundException {
       
        if (Validacao.validaCampo(nomeFunc) && Validacao.validaCampo(cpfFunc) && Validacao.validaCampo(rgFunc)) {
            int codigoFunc = 0;
            if (modoInclusao) {

                codigoFunc = funcionarioDAO.cadastraFuncionarioBD(nomeFunc.getText(), cpfFunc.getText(), rgFunc.getText(), datNascFunc.getText(), telFunc.getText(), endFunc.getText());
                if (codigoFunc != -1) {
                    funcionario.setCodFuncionario(codigoFunc);
                    codFunc.setText(String.valueOf(codigoFunc));
                }
            } else {
                aux = funcionarioDAO.alteraFuncionarioBD(nomeFunc.getText(), cpfFunc.getText(), rgFunc.getText(), datNascFunc.getText(), telFunc.getText(), endFunc.getText(), funcionario.getCodFuncionario());
                // delete from servico_func where codfuncionario = ?
                funcionarioDAO.removeComissoes(funcionario.getCodFuncionario());
            }
            //professor sugeriu simplificar o código.
            if ((codigoFunc != -1) || aux) {
                for (ComissaoDTO comissao : comissoes) {
                    aux = funcionarioDAO.cadastraComissaoBD(comissao.getServico().getCodServico(), comissao.getPercentual(), codFunc);
                }
            }

            // incluir todos os servicos que estao na tabela (tela) na tabela do banco de dados..
            if (modoInclusao && (codigoFunc != -1)) {
                Mensagens.msgInfo("Funcionário adicionado com sucesso.");
                certo = true;
            } else if (!modoInclusao && aux) {
                Mensagens.msgInfo("Funcionário alterado com sucesso.");
                certo = true;
            }
        }
        return certo;
    }
    */

    public void carregaCombinacoesComanda() {
        DefaultComboBoxModel modeloCliente = new DefaultComboBoxModel();
        for (ClienteDTO cliente : listaClientes) {
            modeloCliente.addElement(cliente);
        }
        clientes.setModel(modeloCliente);

        DefaultComboBoxModel modeloFuncionarios = new DefaultComboBoxModel();
        modeloFuncionarios.addElement("Selecione um funcionário.");
        for (FuncionarioDTO funcionario : listaFuncionarios) {
            modeloFuncionarios.addElement(funcionario);
        }
        funcionarios.setModel(modeloFuncionarios);

        /* clientes.addItem("Selecione um cliente.");
        for (ClienteDTO cdto : cliDAO.carregaClientesBD()) {
            clientes.addItem(cdto.getNomCliente());
        }
        funcionarios.addItem("Selecione um funcionário.");
        for (FuncionarioDTO fdto : funcDAO.carregaFuncionariosBD()) {
            funcionarios.addItem(fdto.getNomFuncionario());
        }
         */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        data = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        funcionarios = new javax.swing.JComboBox<>();
        servicos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        adicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        salvar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        clientes = new javax.swing.JComboBox<>();
        remover = new javax.swing.JButton();
        pagar = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel1.setText("Comanda");

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel2.setText("Cliente");

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel3.setText("Data");

        data.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel4.setText("Total");

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel5.setText("Funcionário");

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel6.setText("Serviço");

        funcionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionariosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel7.setText("Valor");

        adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/add.png"))); // NOI18N
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
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
                "Funcionário", "Serviço", "Preço"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        salvar.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/save.png"))); // NOI18N
        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/icon.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/remove menor.png"))); // NOI18N
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        pagar.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        pagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/moneyblack.png"))); // NOI18N
        pagar.setText("Pagar");
        pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(salvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagar)
                .addGap(18, 18, 18)
                .addComponent(cancelar)
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(funcionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(servicos, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25)
                            .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(funcionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(adicionar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void funcionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionariosActionPerformed
        if (funcionarios.getSelectedItem() != " ") {
            FuncionarioDTO funcionario = (FuncionarioDTO) funcionarios.getSelectedItem();
            DefaultComboBoxModel modeloServicos = new DefaultComboBoxModel();
            listaServicos = funcDAO.carregaComissoesBD(funcionario.getCodFuncionario());
            //comissoes = funcionarioDAO.carregaComissoesBD(codFunc);
            modeloServicos.addElement("Selecione um serviço.");
            for (ComissaoDTO comissao : listaServicos) {
                modeloServicos.addElement(comissao.getServico().toString());
            }
            servicos.setModel(modeloServicos);
        }
    }//GEN-LAST:event_funcionariosActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        carregaTabelaComanda(true);
    }//GEN-LAST:event_salvarActionPerformed

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        //boolean existeFunc = false;
        boolean existeServ = false;
        if ((funcionarios.getSelectedIndex() > 0) && (servicos.getSelectedIndex() > 0) && (Validacao.validaCampo(valor)) && (Validacao.validaFloat(valor, 1, 5000))) {
            FuncionarioDTO funcionario = (FuncionarioDTO) funcionarios.getSelectedItem();
            ComissaoDTO comissao = (ComissaoDTO) servicos.getSelectedItem();
            /*for (FuncionarioDTO funcionarioDTO : funcionarios){
                if (funcionarioDTO.getCodFuncionario() == funcionario.getCodFuncionario()){
                    existeFunc = false;
                }
            }*/

            for (ServicoComandaDTO servicoComanda : listaServicosComanda) {
                if (servicoComanda.getComissao().getServico().getCodServico() == comissao.getServico().getCodServico()) {
                    existeServ = true;
                }
            }
            if (existeServ) {
                Mensagens.msgAviso("Este serviço já foi adicionado à comanda! \n Escolha outro serviço.");
            } else {
                funcionarios.setSelectedIndex(0);
                servicos.setModel(null);
                valor.setText("");
                carregaTabelaComanda(false);
            }
        }
        /* if (!achou) {
                ComissaoDTO comissaoDTO = new ComissaoDTO();
                comissaoDTO.setServico(servico);
                comissaoDTO.setPercentual(Float.valueOf(porcentagem.getText()));
                comissoes.add(comissaoDTO);
                porcentagem.setText("");
                carregaComissoes(false);

            }*/
    }//GEN-LAST:event_adicionarActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada > -1) {
            listaServicosComanda.remove(linhaSelecionada);
            carregaTabelaComanda(false);
        } else {
            Mensagens.msgAviso("Selecione uma linha a ser removido!");
        }
    }//GEN-LAST:event_removerActionPerformed

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagarActionPerformed

    ComandaDAO comandaDAO = new ComandaDAO();
    public void carregaTabelaComanda(boolean buscaBD) {
        if (buscaBD) {
            listaServicosComanda = comandaDAO.carregaTabelaComandaBD(WIDTH);
            //carregaComissoesBD(Integer.valueOf(codFunc.getText()));
        }
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("Funcionário");
        modelo.addColumn("Serviço");
        modelo.addColumn("Preço");

        for (ServicoComandaDTO cdto : listaServicosComanda) {
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

        tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(150);

        tabela.setAutoResizeMode(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> clientes;
    private javax.swing.JTextField data;
    private javax.swing.JComboBox<String> funcionarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton pagar;
    private javax.swing.JButton remover;
    private javax.swing.JButton salvar;
    private javax.swing.JComboBox<String> servicos;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
