package analizador;

import java.util.ArrayList;

public class AnalizadorURL extends AnalizadorTexto {

    public AnalizadorURL(String texto) {
        super(texto);
    }

    public ArrayList<String> extraerURLs() {
        String patron = "(https?://[a-zA-Z0-9./-]+)";
        return buscarPatron(patron);
    }
}
