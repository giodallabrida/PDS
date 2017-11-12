package PDS.Util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
            float valor = Float.valueOf(campo.getText().replace(".", ","));
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
        if(!aux){
            Mensagens.msgErro("Data informada inválida.");
        }
        return aux;
    }

    public static int comparaDatas(String inicio, String fim) {
        int aux = inicio.compareTo(fim);
        return aux;
    }

    public static Date converteStringData(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String dataA = data;
        dataA = dataA.substring(6, 10) + dataA.substring(2, 6) + dataA.substring(0, 2);
        //return new java.sql.Date(format.parse(data).getTime());
        return Date.valueOf(dataA.replaceAll("/", "-"));
    }

    public static String converteDataString(Date data) {
        return String.valueOf(data);
    }

    public static boolean validaCPF(String cpf) {
        if (cpf.equals("00000000000") || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999") || !cpf.matches("\\d{11}")) {
            Mensagens.msgErro("CPF inválido (digite apenas 11 números).");
            return false;
        } else {
            int dv1 = calculaDVCpf(cpf, 8, 10);
            int dv2 = calculaDVCpf(cpf, 9, 11);
            String subs1 = cpf.substring(9, 10);
            String subs2 = cpf.substring(10, 11);
            String Dig1 = Integer.toString(dv1);
            String Dig2 = Integer.toString(dv2);
            if (subs1.equals(Dig1) && subs2.equals(Dig2)) {
                return true;
            } else {
                Mensagens.msgErro("CPF informado inválido.");
                return false;
            }
        }
    }
//Calcula os dígitos verificadores do CPF informado.

    public static int calculaDVCpf(String cpf, int num, int peso) {
        int dv = 0;
        String parte;
        for (int i = 0; i <= num; i++) {
            parte = cpf.substring(i, i + 1);
            dv = dv + (Integer.valueOf(parte) * (peso - i));
        }
        dv = 11 - (dv % 11);
        if (dv == 11 || dv == 10) {
            dv = 0;
        }
        return dv;
    }
    
    public static boolean validaTelefone(String telefone) {
        boolean aux = telefone.matches("((10)|([1-9][1-9])) [2-9][0-9]{3}-[0-9]{4}");
        if(!aux){
            Mensagens.msgErro("Telefone informado inválido.");
        }
        return aux;
    }
}
