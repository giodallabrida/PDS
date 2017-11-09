package PDS.Modelo;


public class FuncionarioDTO {
    private int codFuncionario;
    private String nomFuncionario;
    private String cpfFuncionario;
    private String telFuncionario;
    private String endFuncionario;
    private boolean verificaAdm;
    private String senhaAdm;
    
    public FuncionarioDTO(){
        this.codFuncionario = 0;
        this.nomFuncionario = "";
        this.cpfFuncionario = "";
        this.telFuncionario = "";
        this.endFuncionario = "";
        this.verificaAdm = false;
        this.senhaAdm = "";
    }

    public FuncionarioDTO(int codFuncionario, String nomFuncionario, String cpfFuncionario, String telFuncionario, String endFuncionario) {
        this.codFuncionario = codFuncionario;
        this.nomFuncionario = nomFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.telFuncionario = telFuncionario;
        this.endFuncionario = endFuncionario;
    }

    public FuncionarioDTO(String nomFuncionario, String cpfFuncionario, String telFuncionario, String endFuncionario, boolean verificaAdm, String senhaAdm) {
        this.nomFuncionario = nomFuncionario;
        this.cpfFuncionario = cpfFuncionario;
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

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
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
