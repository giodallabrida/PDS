package PDS.Modelo;


public class FuncionarioDTO {
    private int codFuncionario;
    private String nomFuncionario;
    private String rgFuncionario;
    private String cpfFuncionario;
    private String datNascimento;
    private String telFuncionario;
    private String endFuncionario;
    private boolean verificaAdm;
    private String senhaAdm;
    
    public FuncionarioDTO(){
        this.codFuncionario = 0;
        this.nomFuncionario = "";
        this.rgFuncionario = "";
        this.cpfFuncionario = "";
        this.datNascimento = "";
        this.telFuncionario = "";
        this.endFuncionario = "";
        this.verificaAdm = false;
        this.senhaAdm = "";
    }

    public FuncionarioDTO(int codFuncionario, String nomFuncionario, String rgFuncionario, String cpfFuncionario, String datNascimento, String telFuncionario, String endFuncionario) {
        this.codFuncionario = codFuncionario;
        this.nomFuncionario = nomFuncionario;
        this.rgFuncionario = rgFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.datNascimento = datNascimento;
        this.telFuncionario = telFuncionario;
        this.endFuncionario = endFuncionario;
    }

    public FuncionarioDTO(String nomFuncionario, String rgFuncionario, String cpfFuncionario, String datNascimento, String telFuncionario, String endFuncionario, boolean verificaAdm, String senhaAdm) {
        this.nomFuncionario = nomFuncionario;
        this.rgFuncionario = rgFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.datNascimento = datNascimento;
        this.telFuncionario = telFuncionario;
        this.endFuncionario = endFuncionario;
        this.verificaAdm = verificaAdm;
        this.senhaAdm = senhaAdm;
    }

    public FuncionarioDTO(String nomFuncionario) {
        this.nomFuncionario = nomFuncionario;
    }

    
    public boolean isVerificaAdm() {
        return verificaAdm;
    }

    public void setVerificaAdm(boolean verificaAdm) {
        this.verificaAdm = verificaAdm;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getNomFuncionario() {
        return nomFuncionario;
    }

    public void setNomFuncionario(String nomFuncionario) {
        this.nomFuncionario = nomFuncionario;
    }

    public String getRgFuncionario() {
        return rgFuncionario;
    }

    public void setRgFuncionario(String rgFuncionario) {
        this.rgFuncionario = rgFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getDatNascimento() {
        return datNascimento;
    }

    public void setDatNascimento(String datNascimento) {
        this.datNascimento = datNascimento;
    }

    public String getTelFuncionario() {
        return telFuncionario;
    }

    public void setTelFuncionario(String telFuncionario) {
        this.telFuncionario = telFuncionario;
    }

    public String getEndFuncionario() {
        return endFuncionario;
    }

    public void setEndFuncionario(String endFuncionario) {
        this.endFuncionario = endFuncionario;
    }

    public String getSenhaAdm() {
        return senhaAdm;
    }

    public void setSenhaAdm(String senhaAdm) {
        this.senhaAdm = senhaAdm;
    }
    
    public String toString(){
        return this.nomFuncionario;
    }
    
      public Object[] getLinhaTabela() {
        Object[] retorno = {this};
        return retorno;
    }
    
}
