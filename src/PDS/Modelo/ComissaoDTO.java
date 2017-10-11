
package PDS.Modelo;

public class ComissaoDTO {
    private ServicoDTO servico;
    private float percentual;
    private int aux;
    private String nome;

    public ComissaoDTO(float percentual, String nome) {
        this.percentual = percentual;
        this.nome = nome;
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
    
    public Object[] getLinhaTabela() {
        Object[] retorno = {nome, percentual};
        return retorno;
    }
    
}
