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
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * es una clase que se encarga de guardar la imagen seleccionada del estudiante.
 * Al llamar al método saveImage, se proporciona el archivo seleccionado y el ID
 * del estudiante. La imagen se copia al directorio especificado con el nombre
 * del archivo basado en el ID del estudiante.
 *
 */
public class ImageProcessor {

    public String saveImage(File selectedFile, String codigo) {
        // Directorio donde se guardarán todas las imágenes de los estudiantes
        String imagePath = "src/imagenes/fotos/";

        // Crear el directorio si no existe
        File directory = new File(imagePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Generar el nombre del archivo para la imagen del estudiante
        String fileName = codigo + ".jpg"; // O cualquier extensión de archivo deseada

        // Path de destino donde se guardará la imagen
        Path destination = Paths.get(imagePath, fileName);

        try {
            // Copiar la imagen seleccionada al directorio de imágenes del estudiante
            FileHelper.copyFile(selectedFile.toPath(), destination);
            System.out.println("Imagen guardada en: " + destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Devolver la ruta completa donde se guardó la imagen
        return destination.toString();
    }
}
