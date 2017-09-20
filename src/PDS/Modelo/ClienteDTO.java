package PDS.Modelo;

public class ClienteDTO {
    private int codCliente;
    private String nomCliente;
    private String telCliente;
    private String datNascimento;
    private String endCliente;
    private String datAtendimento;
    private String infExtras;
    
    public ClienteDTO() {
        this.codCliente = 0;
        this.nomCliente = "";
        this.telCliente = "";
        this.datNascimento = "";
        this.endCliente = "";
        this.infExtras = "";
        this.datAtendimento = "";
}

    public ClienteDTO(String nome) {
        this.nomCliente = nome;
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

    public String getDatNascimento() {
        return datNascimento;
    }

    public void setDatNascimento(String datNascimento) {
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
        Object[] retorno = {this.nomCliente};
        return retorno;
    }

    public ClienteDTO(int codCliente, String nomCliente, boolean adm, String telCliente, String datNascimento, String endCliente, String datAtendimento, String infExtras) {
        this.codCliente = codCliente;
        this.nomCliente = nomCliente;
        this.telCliente = telCliente;
        this.datNascimento = datNascimento;
        this.endCliente = endCliente;
        this.datAtendimento = datAtendimento;
        this.infExtras = infExtras;
    }
}
