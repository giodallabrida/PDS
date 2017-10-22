package PDS.Modelo;
public class ServicoComandaDTO {
    private FuncionarioDTO funcionario;
    private ComissaoDTO comissao;
    private float valor;

    public ServicoComandaDTO(FuncionarioDTO funcionario, ComissaoDTO comissao, float valor) {
        this.funcionario = funcionario;
        this.comissao = comissao;
        this.valor = valor;
    }

    public ServicoComandaDTO() {
    }

    public ServicoComandaDTO(float valor) {
        this.valor = valor;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
      public Object[] getLinhaTabela() {
        Object[] retorno = {this};
        return retorno;
    }
}
