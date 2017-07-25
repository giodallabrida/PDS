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

    public static boolean validaFloat(JTextField campo, int min, int max) {
        try {
            float valor = Float.valueOf(campo.getText());
            if (valor <= min || valor >= max){
                Mensagens.msgErro(campo.getToolTipText());
                return false;
            }else{
                return true;
            }
        } catch (Exception e){
            Mensagens.msgErro(campo.getToolTipText());
            campo.requestFocus();
            return false;
        }
    }
}