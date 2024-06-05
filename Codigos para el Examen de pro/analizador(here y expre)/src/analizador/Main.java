package analizador;

public class Main {
    public static void main(String[] args) {
        String texto = "Aquí hay un email: ejemplo@example.com, un teléfono: 123-456-7890, y una URL: https://www.ejemplo.com";

        AnalizadorEmail analizadorEmail = new AnalizadorEmail(texto);
        System.out.println("Emails encontrados: " + analizadorEmail.extraerEmails());

        AnalizadorTelefono analizadorTelefono = new AnalizadorTelefono(texto);
        System.out.println("Teléfonos encontrados: " + analizadorTelefono.extraerTelefonos());

        AnalizadorURL analizadorURL = new AnalizadorURL(texto);
        System.out.println("URLs encontradas: " + analizadorURL.extraerURLs());
    }
}

