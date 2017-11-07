package PDS.Modelo;
public class ServicoComandaDTO {
    private int codigo;
    private FuncionarioDTO funcionario;
    private ComissaoDTO comissao = new ComissaoDTO();
    private float valorServico;
    private float valorComissao;

    public float getValorServico() {
        return valorServico;
    }

    public void setValorServico(float valorServico) {
        this.valorServico = valorServico;
    }

    public float getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(float valorComissao) {
        this.valorComissao = valorComissao;
    }

    public ServicoComandaDTO(FuncionarioDTO funcionario, ComissaoDTO comissao, float valor) {
        this.funcionario = funcionario;
        this.comissao = comissao;
        this.valorServico = valor;
    }

    public ServicoComandaDTO() {
    }

    public ServicoComandaDTO(float valor) {
        this.valorServico = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    

    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    public ComissaoDTO getComissao() {
        return comissao;
    }

    public void setComissao(ComissaoDTO comissao) {
        this.comissao = comissao;
    }

  
      public Object[] getLinhaTabela() {
        Object[] retorno = {funcionario, comissao.getServico(), valorServico};
        return retorno;
    }
}
