
import PDS.telas.Apresentacao;
import PDS.telas.PanelPrincipal;
import javax.swing.JFrame;

public class Inicio {
    public static void main(String[] args) {
        Apresentacao frame = new Apresentacao();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PanelPrincipal(frame));
        frame.setVisible(true);
    }
}
