package analizador;

import java.util.ArrayList;

public class AnalizadorTelefono extends AnalizadorTexto {

    public AnalizadorTelefono(String texto) {
        super(texto);
    }

    public ArrayList<String> extraerTelefonos() {
        String patron = "\\b\\d{3}[-.]?\\d{3}[-.]?\\d{4}\\b";
        return buscarPatron(patron);
    }
}