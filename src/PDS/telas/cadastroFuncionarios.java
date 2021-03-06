package PDS.telas;

import PDS.Modelo.ComissaoDTO;
import PDS.Modelo.FuncionarioDTO;
import PDS.Modelo.ServicoDTO;
import PDS.Persistencia.FuncionarioDAO;
import PDS.Persistencia.ServicoDAO;
import PDS.Util.Mensagens;
import PDS.Util.Validacao;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class cadastroFuncionarios extends javax.swing.JFrame {

    private boolean modoInclusao;
    private FuncionarioDTO funcionario;

    public cadastroFuncionarios(boolean modoInclusao, FuncionarioDTO funcionario) {
        this.modoInclusao = modoInclusao;
        this.funcionario = funcionario;
        initComponents();
        this.listaFuncionarios = funcionarioDAO.carregaFuncionariosBD();
        if (listaFuncionarios != null) {
            carregaFuncionarios();
        }
        this.setLocationRelativeTo(null);
        this.setTitle("Cadastro de Funcionários");
        btnInativar.setEnabled(false);
        carregaCombinacao();
        comissoes = new ArrayList();
    }

    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public boolean cadastraAlteraFuncionario(JTextField nomeFunc, JTextField cpfFunc, JTextField telFunc, JTextArea endFunc) throws SQLException, FileNotFoundException {
        boolean aux = false;
        boolean certo = false;
        if (Validacao.validaCampo(nomeFunc) && Validacao.validaCampo(cpfFunc) && Validacao.validaCPF(cpfFunc.getText())
                && Validacao.validaCampo(telFunc) && Validacao.validaTelefone(telFunc.getText())) {
            int codigoFunc = 0;
            if (modoInclusao) {
                codigoFunc = funcionarioDAO.cadastraFuncionarioBD(nomeFunc.getText(), cpfFunc.getText(), telFunc.getText(), endFunc.getText());
                if (codigoFunc != -1) {
                    funcionario.setCodFuncionario(codigoFunc);
                    codFunc.setText(String.valueOf(codigoFunc));
                }
            } else {
                aux = funcionarioDAO.alteraFuncionarioBD(nomeFunc.getText(), cpfFunc.getText(), telFunc.getText(), endFunc.getText(), funcionario.getCodFuncionario());
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

    ComissaoDTO comissao = new ComissaoDTO();

    ServicoDAO servDAO = new ServicoDAO();

    int codSer;
    ArrayList<ServicoDTO> listaServicos = servDAO.carregaServicosBD();

    public void carregaCombinacao() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (ServicoDTO servico : listaServicos) {
            modelo.addElement(servico);
        }
        servicos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        codFunc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nomeFunc = new javax.swing.JTextField();
        telFunc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cpfFunc = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        comFunc = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        endFunc = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        remover = new javax.swing.JButton();
        servicos = new javax.swing.JComboBox<>();
        porcentagem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        adicionar = new javax.swing.JButton();
        pesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        listar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(813, 542));
        setMinimumSize(new java.awt.Dimension(813, 542));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 30)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/woman.png"))); // NOI18N
        jLabel1.setText("Cadastro de Funcionários");

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel7.setText("Código");

        codFunc.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel8.setText("Nome");

        nomeFunc.setToolTipText("Digite o nome do funcionário.");

        telFunc.setToolTipText("Digite o telefone do funcionário.");

        jLabel9.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel9.setText("Telefone");

        jLabel10.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel10.setText("Endereço");

        jLabel12.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel12.setText("CPF");

        cpfFunc.setText("57623740920");
        cpfFunc.setToolTipText("Informe o CPF do funcionário.");

        comFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serviço", "Comissão"
            }
        ));
        jScrollPane3.setViewportView(comFunc);

        jLabel14.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel14.setText("Serviços e Comissões");

        btnVoltar.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/return option.png"))); // NOI18N
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        endFunc.setColumns(20);
        endFunc.setRows(5);
        jScrollPane4.setViewportView(endFunc);

        btnSalvar.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/abrir.png"))); // NOI18N
        btnAlterar.setText("Abrir");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnInativar.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        btnInativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/icon.png"))); // NOI18N
        btnInativar.setText("Inativar");
        btnInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInativarActionPerformed(evt);
            }
        });

        remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/remove menor.png"))); // NOI18N
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        porcentagem.setToolTipText("Digite a comissão do funcionário (Entre 0% e 100%)");

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel2.setText("Porcentagem");

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel3.setText("Serviço");

        adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/add.png"))); // NOI18N
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/search menor.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Funcionários"
            }
        ));
        jScrollPane6.setViewportView(tabela);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ícones/list.png"))); // NOI18N
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel11.setText("Formato: 27889000020");

        jLabel13.setFont(new java.awt.Font("Baskerville Old Face", 0, 16)); // NOI18N
        jLabel13.setText("Formato: 47 3382-0000");

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel4.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cpfFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel13))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(224, 224, 224)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(telFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(codFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(servicos, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(porcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4))
                                            .addComponent(jLabel14))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSalvar)
                                        .addGap(61, 61, 61)
                                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(btnInativar)))))))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVoltar)
                    .addComponent(jLabel1))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(codFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(nomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cpfFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9)
                                    .addComponent(telFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(17, 17, 17)
                                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(servicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)
                                            .addComponent(porcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        if (funcionarioDAO.inativaFuncionarioBD(Integer.valueOf(codFunc.getText()))) {
            codFunc.setText("");
            nomeFunc.setText("");
            cpfFunc.setText("");
            telFunc.setText("");
            endFunc.setText("");
            comFunc.setModel(modelo);
            Mensagens.msgInfo("O funcionário foi removido com sucesso!");
            this.listaFuncionarios = funcionarioDAO.carregaFuncionariosBD();
            if (listaFuncionarios != null) {
                carregaFuncionarios();
            }
            Menu menu = new Menu();
            menu.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnInativarActionPerformed

    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        boolean aux = false;
        try {
            if (cadastraAlteraFuncionario(nomeFunc, cpfFunc, telFunc, endFunc)) {

                Menu menu = new Menu();
                menu.setVisible(true);
                this.setVisible(false);
            }
        } catch (Exception e) {
            Mensagens.msgAviso("Ocorreu um erro no sistema.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    FuncionarioDAO funcDAO = new FuncionarioDAO();
    ArrayList<FuncionarioDTO> listaFuncionarios;

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        this.listaFuncionarios = funcDAO.carregaFuncionariosBD();
        if (listaFuncionarios != null) {
            carregaFuncionarios();
        }
    }//GEN-LAST:event_listarActionPerformed

    ArrayList<FuncionarioDTO> funcionariosPesquisados;

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        funcionariosPesquisados = funcDAO.pesquisaFuncionariosBD(Validacao.verificaString(pesquisa));
        if (funcionariosPesquisados != null) {
            carregaPesquisados();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada > -1) {
            btnInativar.setEnabled(true);
            funcionario = (FuncionarioDTO) tabela.getValueAt(linhaSelecionada, 0);
            modoInclusao = false;
            codFunc.setText(String.valueOf(funcionario.getCodFuncionario()));
            nomeFunc.setText(funcionario.getNomFuncionario());
            cpfFunc.setText(funcionario.getCpfFuncionario());
            telFunc.setText(funcionario.getTelFuncionario());
            endFunc.setText(funcionario.getEndFuncionario());
            carregaComissoes(true);
        } else {
            Mensagens.msgAviso("Selecione um funcionário a ser alterado!");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    ServicoDTO servico;
    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        boolean achou = false;
        if (Validacao.validaCampo(porcentagem) && Validacao.validaFloat(porcentagem, -1, 101)) {
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
    }//GEN-LAST:event_adicionarActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        int linhaSelecionada = comFunc.getSelectedRow();
        if (linhaSelecionada > -1) {
            comissoes.remove(linhaSelecionada);
            carregaComissoes(false);
        } else {
            Mensagens.msgAviso("Selecione um serviço a ser removido!");
        }
    }//GEN-LAST:event_removerActionPerformed

    public void carregaFuncionarios() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("Funcionários");

        for (FuncionarioDTO fdto : listaFuncionarios) {
            modelo.addRow(fdto.getLinhaTabela());
        }

        tabela.setModel(modelo);
        tabela.setAutoResizeMode(0);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(227);

        tabela.setAutoResizeMode(0);
    }

    public void carregaPesquisados() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("Funcionários");

        for (FuncionarioDTO fdto : funcionariosPesquisados) {
            modelo.addRow(fdto.getLinhaTabela());
        }

        tabela.setModel(modelo);
        tabela.setAutoResizeMode(0);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(227);

        tabela.setAutoResizeMode(0);
    }

    ArrayList<ComissaoDTO> comissoes;

    public void carregaComissoes(boolean buscaBD) {
        if (buscaBD) {
            comissoes = funcionarioDAO.carregaComissoesBD(Integer.valueOf(codFunc.getText()));
        }
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("Serviços");
        modelo.addColumn("Comissões");

        for (ComissaoDTO cdto : comissoes) {
            modelo.addRow(cdto.getLinhaTabela());
        }

        comFunc.setModel(modelo);
        comFunc.setAutoResizeMode(0);

        comFunc.getColumnModel().getColumn(0).setPreferredWidth(230);
        comFunc.getColumnModel().getColumn(1).setPreferredWidth(227);

        comFunc.setAutoResizeMode(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnInativar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField codFunc;
    private javax.swing.JTable comFunc;
    private javax.swing.JTextField cpfFunc;
    private javax.swing.JTextArea endFunc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton listar;
    private javax.swing.JTextField nomeFunc;
    private javax.swing.JTextField pesquisa;
    private javax.swing.JTextField porcentagem;
    private javax.swing.JButton remover;
    private javax.swing.JComboBox<String> servicos;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField telFunc;
    // End of variables declaration//GEN-END:variables
}
