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

     /**
     * Convierte una imagen seleccionada en un arreglo de bytes.
     *
     * @param selectedFile archivo de imagen seleccionado
     * @return imagen convertida a byte[]
     */
        public byte[] getImageBytes(File selectedFile) {

        if (selectedFile == null) {
            return null;
        }

        try {

            return Files.readAllBytes(selectedFile.toPath());

        } catch (IOException e) {

            System.out.println(
                "Error al leer la imagen: "
                + e.getMessage()
            );

            return null;
        }
    }
    }
