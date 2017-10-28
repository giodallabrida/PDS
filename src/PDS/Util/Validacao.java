package PDS.Util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static LocalDate getDataJava(Date dataMySQL) {
        return dataMySQL.toLocalDate();
    }

    public static Date getDataMySQL(LocalDate data) {
        return java.sql.Date.valueOf(data);
    }

    public static boolean validaData(String campo) {
        boolean aux = false;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
            df.parse(campo);
            aux = true;
        } catch (ParseException ex) {

        }
        return aux;
    }

    public static int comparaDatas(String inicio, String fim) {
        int aux = inicio.compareTo(fim);
        return aux;
    }

    public static Date converteStringData(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        return new java.sql.Date(format.parse(data).getTime());
    }

}
