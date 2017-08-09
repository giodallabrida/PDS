package PDS.Modelo;

public class ServicoDTO {
    private int codServico;
    private String nomServico;
    private String infExtras;

    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }

    public String getNomServico() {
        return nomServico;
    }

    public void setNomServico(String nomServico) {
        this.nomServico = nomServico;
    }

    public String getInfExtras() {
        return infExtras;
    }

    public void setInfExtras(String infExtras) {
        this.infExtras = infExtras;
    }

    public ServicoDTO(int codServico, String nomServico, String infExtras) {
        this.codServico = codServico;
        this.nomServico = nomServico;
        this.infExtras = infExtras;
    }
}
