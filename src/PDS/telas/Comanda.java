package PDS.telas;

import PDS.Modelo.ClienteDTO;
import PDS.Modelo.ComandaDTO;
import PDS.Modelo.ComissaoDTO;
import PDS.Modelo.FuncionarioDTO;
import PDS.Modelo.ServicoComandaDTO;
import PDS.Persistencia.ClienteDAO;
import PDS.Persistencia.ComandaDAO;
import PDS.Persistencia.FuncionarioDAO;
import PDS.Persistencia.ServicoComandaDAO;
import PDS.Persistencia.ServicoDAO;
import PDS.Util.Mensagens;
import PDS.Util.Validacao;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Comanda extends javax.swing.JFrame {

    public Comanda(ComandaDTO comanda, boolean modoInclusao) {
        this.modoInclusao = modoInclusao;
        this.comanda = comanda;
        initComponents();
        carregaCombinacoesComanda();
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
        data.setText(formatarDate.format(date));
        this.setLocationRelativeTo(null);
    }

    private boolean modoInclusao;
    ClienteDAO cliDAO = new ClienteDAO();
    FuncionarioDAO funcDAO = new FuncionarioDAO();
    ServicoDAO servDAO = new ServicoDAO();
    ArrayList<ClienteDTO> listaClientes = cliDAO.carregaClientesBD();
    ArrayList<FuncionarioDTO> listaFuncionarios = funcDAO.carregaFuncionariosBD();
    ArrayList<ComissaoDTO> listaServicos;
    ArrayList<ServicoComandaDTO> listaServicosComanda = new ArrayList();
    ComandaDTO comanda;

    ComandaDAO comandaDAO = new ComandaDAO();
    ServicoComandaDAO servicoComandaDAO = new ServicoComandaDAO();
    

    public boolean cadastraAlteraComanda(String situacao) throws SQLException, FileNotFoundException {
        boolean aux = false;
        boolean certo = false;
        ClienteDTO cliente = (ClienteDTO) clientes.getSelectedItem();
        comanda.setCliente(cliente);
        int codComanda = 0;
        if (Float.valueOf(total.getText()) == 0) {
            Mensagens.msgAviso("Sua comanda está vazia, favor adicionar um serviço.");
        } else if (modoInclusao) {
            String dataA = data.getText();
            dataA = dataA.substring(6, 10) + dataA.substring(2, 6) + dataA.substring(0, 2);
            codComanda = comandaDAO.cadastraComandaBD(cliente.getCodCliente(), Date.valueOf(dataA), Float.valueOf(total.getText()), situacao);
            if (codComanda != -1) {
                cod.setText(String.valueOf(codComanda));
                comanda.setCodComanda(codComanda);
            }
        } else {
            aux = comandaDAO.alteraComandaBD(cliente.getCodCliente(), Date.valueOf(data.getText()), Float.valueOf(total.getText()));
            comandaDAO.removeServicos(Integer.valueOf(cod.getText()));
        }

        if (codComanda != -1 || aux) {
            comandaDAO.cadastraServicosPrestadosBD(codComanda, listaServicosComanda);
        }
        // incluir todos os servicos que estao na tabela (tela) na tabela do banco de dados..
        if (modoInclusao && (codComanda != -1)) {
            Mensagens.msgInfo("Comanda adicionada com sucesso.");
            certo = true;
        } else if (!modoInclusao && aux) {
            Mensagens.msgInfo("Comanda alterada com sucesso.");
            certo = true;
        }
        return aux;
    }

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
        total = new javax.swing.JTextField();
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
        codigo = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();

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

        codigo.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        codigo.setText("Código");

        cod.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(codigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo)
                    .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(funcionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
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
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(adicionar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void funcionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionariosActionPerformed
        if (funcionarios.getSelectedIndex()!= 0) {
            FuncionarioDTO funcionario = (FuncionarioDTO) funcionarios.getSelectedItem();
            DefaultComboBoxModel modeloServicos = new DefaultComboBoxModel();
            listaServicos = funcDAO.carregaComissoesBD(funcionario.getCodFuncionario());
            //comissoes = funcionarioDAO.carregaComissoesBD(codFunc);
            modeloServicos.addElement("Selecione um serviço.");
            for (ComissaoDTO comissao : listaServicos) {
                modeloServicos.addElement(comissao);
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
        try {
            if(cadastraAlteraComanda("N")){
                ListaComandas listaComandas = new ListaComandas();
                listaComandas.setVisible(true);
                this.setVisible(false);
            }
        } catch (SQLException ex) {
            Mensagens.msgAviso("Ocorreu um erro no sistema.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Comanda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvarActionPerformed


    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        /*
         boolean achou = false;
        if (Validacao.validaCampo(porcentagem)) {
            ServicoDTO servico2;
            servico = (ServicoDTO) servicos.getSelectedItem();
            for (ComissaoDTO comissao : comissoes) {
                if (comissao.getServico().getCodServico() == servico.getCodServico()) {
                    Mensagens.msgAviso("Esse serviço já está cadastrado para esse funcionário. \n Escolha outro serviço!");
                    achou = true;
                }
            }
            if (!achou) {
                ComissaoDTO comissaoDTO = new ComissaoDTO();
                comissaoDTO.setServico(servico);
                comissaoDTO.setPercentual(Float.valueOf(porcentagem.getText()));
                comissoes.add(comissaoDTO);
                porcentagem.setText("");
                carregaComissoes(false);
            }
        }
    }                                         
         */
        boolean existeServ = false;
        if ((funcionarios.getSelectedIndex() > 0) && (servicos.getSelectedIndex() > 0) && (Validacao.validaCampo(valor)) && (Validacao.validaFloat(valor, 1, 5000))) {
            ServicoComandaDTO servicoComanda = new ServicoComandaDTO();
            servicoComanda.setFuncionario((FuncionarioDTO) funcionarios.getSelectedItem());
            servicoComanda.setComissao((ComissaoDTO) servicos.getSelectedItem());
            servicoComanda.setValorServico(Integer.valueOf(valor.getText()));
            float valorComissao = servicoComanda.getValorServico() * servicoComanda.getComissao().getPercentual() / 100;
            servicoComanda.setValorComissao(valorComissao);
            for (ServicoComandaDTO servicoLista : listaServicosComanda) {
                if (servicoLista.getFuncionario().getCodFuncionario() == servicoComanda.getFuncionario().getCodFuncionario()
                        && servicoLista.getComissao().getServico().getCodServico() == servicoComanda.getComissao().getServico().getCodServico()) {
                    existeServ = true;
                }
            }

            if (existeServ) {
                Mensagens.msgAviso("Este serviço já foi adicionado à comanda! \n Escolha outro serviço.");
            } else {
                
                listaServicosComanda.add(servicoComanda);
                
                carregaTabelaComanda(false);
                float valorTotal = 0;
                for (ServicoComandaDTO lista : listaServicosComanda) {
                    valorTotal = valorTotal + lista.getValorServico();
                }
                total.setText(String.valueOf(valorTotal));
                
                
                funcionarios.setSelectedIndex(0);
                servicos.setModel(new DefaultComboBoxModel<>());
                valor.setText("");
                
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

    float totalDinheiro;
    float totalCheque;
    float totalCartaoDebito;
    float totalCartaoCredito;
    
    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
        try {
            if(cadastraAlteraComanda("P")){
                int opcao = Mensagens.msgOpcao();
                switch (opcao){
                    case 1:
                        totalDinheiro = totalDinheiro + Float.valueOf(total.getText());
                        break;
                    case 2:
                        totalCheque = totalCheque + Float.valueOf(total.getText());
                        break;
                    case 3: 
                        totalCartaoDebito = totalCartaoDebito + Float.valueOf(total.getText());
                        break;
                    case 4: 
                        totalCartaoCredito = totalCartaoCredito + Float.valueOf(total.getText());
                        break;
                }
                ListaComandas listaComandas = new ListaComandas();
                listaComandas.setVisible(true);
                this.setVisible(false);
            }
        } catch (SQLException ex) {
            Mensagens.msgAviso("Ocorreu um erro no sistema.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Comanda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_pagarActionPerformed

    public void carregaTabelaComanda(boolean buscaBD) {
        if (buscaBD) {
            listaServicosComanda = comandaDAO.carregaTabelaComandaBD(comanda.getCodComanda());
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
    private javax.swing.JTextField cod;
    private javax.swing.JLabel codigo;
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
    private javax.swing.JButton pagar;
    private javax.swing.JButton remover;
    private javax.swing.JButton salvar;
    private javax.swing.JComboBox<String> servicos;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField total;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
