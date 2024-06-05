package analizador;

import java.util.ArrayList;

public class AnalizadorEmail extends AnalizadorTexto {

    public AnalizadorEmail(String texto) {
        super(texto);
    }

    public ArrayList<String> extraerEmails() {
        String patron = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";
        return buscarPatron(patron);
    }
}
