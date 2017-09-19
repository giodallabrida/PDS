package PDS.Util;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Validacao {

    public static boolean validaCampo(JTextField campo) {
        if (campo.getText().trim().isEmpty()) {
            Mensagens.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean validaSenha(JPasswordField campo) {
        if (String.copyValueOf(campo.getPassword()).trim().isEmpty()) {
            Mensagens.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean validaString(JTextField campo, String definicao) {
        if (campo.getText().trim().length() >= 60) {
            Mensagens.msgAviso("Você só pode digitar 60 caracteres no campo " + definicao + ".");
            return false;
        }
        return true;
    }

    public static boolean validaFloat(JTextField campo, int min, int max) {
        try {
            float valor = Float.valueOf(campo.getText());
            if (valor <= min || valor >= max) {
                Mensagens.msgErro(campo.getToolTipText());
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            Mensagens.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        }
    }

    public static String verificaString(JTextField campo) {
        String aux;
        aux = campo.getText().trim();
        while (aux.contains("  ")) {
            aux = aux.replaceAll("  ", " ");
        }
        while (aux.contains(" ")) {
            aux = aux.replace(" ", "%");
        }
        aux = "%" + aux + "%";
        return aux;
    }
}
