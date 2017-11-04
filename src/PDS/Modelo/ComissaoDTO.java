
package PDS.Modelo;

public class ComissaoDTO {
    private ServicoDTO servico;
    private float percentual;
    private int aux;

    public ComissaoDTO(float percentual) {
        this.percentual = percentual;
    }

    public ComissaoDTO() {
        
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }

    public ServicoDTO getServico() {
        return servico;
    }

    public void setServico(ServicoDTO servico) {
        this.servico = servico;
    }

    public float getPercentual() {
        return percentual;
    }

    public void setPercentual(float percentual) {
        this.percentual = percentual;
    }
    
    @Override
    public String toString(){
        return servico.getNomServico();
    }
    
    public Object[] getLinhaTabela() {
        Object[] retorno = {servico, percentual};
        return retorno;
    }
    
    public Object[] getLinhaTabelaComissao() {
        Object[] retorno = {servico, percentual};
        return retorno;
    }
    
}
