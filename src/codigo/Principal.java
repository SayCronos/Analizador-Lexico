package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta1 = "C:/Users/RIDCO/Downloads/AnalizadorLexico/src/codigo/Lexer.flex";
        String ruta2 = "C:/Users/RIDCO/Downloads/AnalizadorLexico/src/codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/RIDCO/Downloads/AnalizadorLexico/src/codigo/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Users/RIDCO/Downloads/AnalizadorLexico/src/codigo/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        // CORRECCIÓN AQUÍ: Tomar "sym.java" suelto y moverlo a la ruta
        Files.move(
                Paths.get("sym.java"), 
                Paths.get("C:/Users/RIDCO/Downloads/AnalizadorLexico/src/codigo/sym.java")
        );
        
        Path rutaSin = Paths.get("C:/Users/RIDCO/Downloads/AnalizadorLexico/src/codigo/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        // CORRECCIÓN AQUÍ: Tomar "Sintax.java" suelto y moverlo a la ruta
        Files.move(
                Paths.get("Sintax.java"), 
                Paths.get("C:/Users/RIDCO/Downloads/AnalizadorLexico/src/codigo/Sintax.java")
        );
    }
}