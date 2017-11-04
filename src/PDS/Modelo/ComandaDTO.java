package PDS.Modelo;

import PDS.Util.Validacao;
import java.sql.Date;
import java.time.LocalDate;

public class ComandaDTO {

    private int codigo;
    private ClienteDTO cliente;
    private FuncionarioDTO funcionario;
    private ServicoDTO servico;
    private LocalDate data;
    private float total;

    public ComandaDTO() {

    }

    public int getCodComanda() {
        return codigo;
    }

    public void setCodComanda(int codComanda) {
        this.codigo = codComanda;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    public ServicoDTO getServico() {
        return servico;
    }

    public void setServico(ServicoDTO servico) {
        this.servico = servico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ComandaDTO(int codigo, ClienteDTO cliente, FuncionarioDTO funcionario, ServicoDTO servico, LocalDate data, float total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.data = data;
        this.total = total;
    }

    public String toString() {
        return String.valueOf(this.codigo);
    }

    public Object[] getLinhaTabela() {
        Object[] retorno = {this, cliente, total};
        return retorno;
    }

    public Object[] getLinhaTabelaComanda() {
        Date dataL = Validacao.getDataMySQL(data);
        String dataCerta = Validacao.converteDataString(dataL);
        dataCerta = dataCerta.substring(8, 10) + "/" + dataCerta.substring(5, 7) + "/" + dataCerta.substring(0, 4);
        Object[] retorno = {cliente, dataCerta, total};
        return retorno;
    }
    
}
