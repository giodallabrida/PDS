package PDS.Modelo;

import java.time.LocalDate;

public class ClienteDTO {
    private int codCliente;
    private String nomCliente;
    private String telCliente;
    private LocalDate datNascimento;
    private String endCliente;
    private String datAtendimento;
    private String infExtras;
    
    public ClienteDTO() {
        this.codCliente = 0;
        this.nomCliente = "";
        this.telCliente = "";
        this.datNascimento = null;
        this.endCliente = "";
        this.infExtras = "";
        this.datAtendimento = "";
}

    public ClienteDTO(String nome, String telefone) {
        this.nomCliente = nome;
        this.telCliente = telefone;
    }

    public ClienteDTO(int codigo, String nome, String telefone, LocalDate datNasc, String endereco, String datAte, String infEx) {
        this.codCliente = codigo;
        this.nomCliente = nome;
        this.telCliente = telefone;
        this.datNascimento = datNasc;
        this.endCliente = endereco;
        this.infExtras = infEx;
        this.datAtendimento = datAte;
    }

    public ClienteDTO(String nome, String telefone, LocalDate datNasc, String endereco, String datAte, String infEx) {
        this.nomCliente = nome;
        this.telCliente = telefone;
        this.datNascimento = datNasc;
        this.endCliente = endereco;
        this.infExtras = infEx;
        this.datAtendimento = datAte;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(String telCliente) {
        this.telCliente = telCliente;
    }

    public LocalDate getDatNascimento() {
        return datNascimento;
    }

    public void setDatNascimento(LocalDate datNascimento) {
        this.datNascimento = datNascimento;
    }

    public String getEndCliente() {
        return endCliente;
    }

    public void setEndCliente(String endCliente) {
        this.endCliente = endCliente;
    }

    public String getDatAtendimento() {
        return datAtendimento;
    }

    public void setDatAtendimento(String datAtendimento) {
        this.datAtendimento = datAtendimento;
    }

    public String getInfExtras() {
        return infExtras;
    }

    public void setInfExtras(String infExtras) {
        this.infExtras = infExtras;
    }
    
    public Object[] getLinhaTabela() {
        Object[] retorno = {this};
        return retorno;
    }
    
    public Object[] getLinhaTabelaRelatorio() {
        Object[] retorno = {this, this.telCliente};
        return retorno;
    }
    
    public String toString(){
        return this.nomCliente;
    }

    public ClienteDTO(int codCliente, String nomCliente, boolean adm, String telCliente, LocalDate datNascimento, String endCliente, String datAtendimento, String infExtras) {
        this.codCliente = codCliente;
        this.nomCliente = nomCliente;
        this.telCliente = telCliente;
        this.datNascimento = datNascimento;
        this.endCliente = endCliente;
        this.datAtendimento = datAtendimento;
        this.infExtras = infExtras;
    }
}
