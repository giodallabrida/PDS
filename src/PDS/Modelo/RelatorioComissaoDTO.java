
package PDS.Modelo;

import PDS.Util.Validacao;
import java.sql.Date;
import java.time.LocalDate;

public class RelatorioComissaoDTO {
    private LocalDate data;
    private ClienteDTO cliente;
    private ServicoDTO servico = new ServicoDTO();
    private float valorTotal;
    private float valorComissao;

    public RelatorioComissaoDTO(LocalDate data, ClienteDTO cliente, ServicoDTO servico, float valorTotal, float valorObtido) {
        this.data = data;
        this.cliente = cliente;
        this.servico = servico;
        this.valorTotal = valorTotal;
        this.valorComissao = valorObtido;
    }

    public RelatorioComissaoDTO() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ServicoDTO getServico() {
        return servico;
    }

    public void setServico(ServicoDTO servico) {
        this.servico = servico;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(float valorComissao) {
        this.valorComissao = valorComissao;
    }
    
    public String toString(){
        return this.cliente.getNomCliente();
    }
    
      public Object[] getLinhaTabela() {
        Object[] retorno = {this};
        return retorno;
    }
      
       
    public Object[] getLinhaTabelaComissoes() {
        Date dataL = Validacao.getDataMySQL(data);
        String dataCerta = Validacao.converteDataString(dataL);
        dataCerta = dataCerta.substring(8, 10) + "/" + dataCerta.substring(5, 7) + "/" + dataCerta.substring(0, 4);
        Object[] retorno = {dataCerta, cliente, servico.getNomServico(), valorTotal, valorComissao};
        return retorno;
    }
}
