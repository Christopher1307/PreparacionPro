package analizador;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalizadorTexto {
    protected String texto;

    public AnalizadorTexto(String texto) {
        this.texto = texto;
    }

    public ArrayList<String> buscarPatron(String patron) {
        ArrayList<String> resultados = new ArrayList<>();
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            resultados.add(matcher.group());
        }

        return resultados;
    }

    public String reemplazarPatron(String patron, String reemplazo) {
        return texto.replaceAll(patron, reemplazo);
    }

    public int contarOcurrencias(String patron) {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);
        int count = 0;

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public String[] dividirPorPatron(String patron) {
        return texto.split(patron);
    }
}
