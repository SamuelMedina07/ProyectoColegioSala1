/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileHelper {
    /**
     * 
     * Esta clase y su método copyFile son útiles cuando necesita copiar archivos de una ubicación a 
     * otra en el sistema de archivos. Puedes usar este método para mover archivos a una 
     * ubicación segura en el proyecto
     */
    public static void copyFile(Path source, Path destination) throws IOException {
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}
