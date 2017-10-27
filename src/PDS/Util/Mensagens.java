package PDS.Util;

import javax.swing.JOptionPane;

public class Mensagens {

    public static void msgErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem,
                "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void msgAviso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem,
                "Alerta", JOptionPane.WARNING_MESSAGE);
    }

    public static void msgInfo(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem,
                "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean msgConf(String mensagem) {
        return JOptionPane.showConfirmDialog(null, mensagem,
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public static int msgOpcao() {
        String[] botoes = {"Dinheiro", "Cheque", "Cartão de Débito", "Cartão de Crédito", "Cancelar"};
        return JOptionPane.showOptionDialog(null, "Selecione uma opção abaixo", "Escolha",
                JOptionPane.DEFAULT_OPTION, 0, null, botoes, botoes[0]);
    }
}
