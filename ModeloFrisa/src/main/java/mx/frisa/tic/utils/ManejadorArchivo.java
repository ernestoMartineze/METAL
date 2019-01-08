/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author USER_1
 */
public class ManejadorArchivo {

    public static String contenidoArchivoEnZip(String directorioZip, String uuid) {

        //cadena que contiene la ruta donde están los archivos .zip
        //ruta donde están los archivos .zip
        File carpetaExtraer = new File(directorioZip);

        //valida si existe el directorio
        if (carpetaExtraer.exists()) {
            //lista los archivos que hay dentro  del directorio
            File[] ficheros = carpetaExtraer.listFiles();
            System.out.println("Número de ficheros encontrados: " + ficheros.length);

            //ciclo para recorrer todos los archivos .zip
            for (int i = 0; i < ficheros.length; i++) {
                System.out.println("Nombre del fichero: " + ficheros[i].getName());
                System.out.println("Descomprimiendo.....");

                String archivoContenido = recuperarArchivoEnZip(ficheros[i].getName(), uuid);
                System.out.println("archivoContenido: " + archivoContenido);

            }
            System.out.println("Directorio de salida: " + directorioZip);
        } else {
            System.out.println("No se encontró el directorio..");
        }
        return null;
    }

    private static String recuperarArchivoEnZip(String nombreZip, String uuid) {

        String nombreArchivoContenido = "";
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(nombreZip));) {
            //crea un buffer temporal para el archivo que se va descomprimir

            ZipEntry salida;
            //recorre todo el buffer extrayendo uno a uno cada archivo.zip y creándolos de nuevo en su archivo original 
            while (null != (salida = zis.getNextEntry())) {
                System.out.println("Nombre del Archivo: " + salida.getName());
                nombreArchivoContenido = "." + uuid + "/" + salida.getName();
                FileOutputStream fos = new FileOutputStream(nombreArchivoContenido);
                int leer;
                byte[] buffer = new byte[1024];
                while (0 < (leer = zis.read(buffer))) {
                    fos.write(buffer, 0, leer);
                }
                fos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombreArchivoContenido;
    }

    public static String encodeFileToBase64Binary(String fileName)
            throws IOException {

        File file = new File(fileName);
        byte[] bytes = loadFile(file);
        byte[] encoded = Base64.getEncoder().encode(bytes);
        String encodedString = new String(encoded, StandardCharsets.US_ASCII);

        return encodedString;
    }

    public static byte[] decodeBase64ToFileBinary(String datos)
            throws IOException {

        byte[] decoded = Base64.getDecoder().decode(datos);

        return decoded;
    }

    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;
    }

    public static List<Object> procesarArchivoZip(String dirArchivoZip, String nombreArchivoZip, String datosFactura) throws IOException {
        System.err.println("Creando ZIP : " + nombreArchivoZip);
        FileOutputStream archivoZip = null;
        List<Object> datosJsonTxt = new ArrayList();
        try {
            System.err.println("Validando DIR ZIP : " + dirArchivoZip);
            File dirZip = new File(dirArchivoZip);
            if (!dirZip.mkdirs()) {
                System.err.println("DIR Creado!!");
            }

//            File archivoZip = new File(nombreArchivoZip);
            archivoZip = new FileOutputStream(nombreArchivoZip);

            System.err.println("Generando archivo : " + nombreArchivoZip);
            System.err.println("Contenido archivo : " + archivoZip.toString());
//            byte contenido[] = datosFactura.getBytes();
            byte[] datos = decodeBase64ToFileBinary(datosFactura);
            archivoZip.write(datos);
            archivoZip.close();
            datosJsonTxt = recuperarJson(dirArchivoZip + File.separator + "descomp", nombreArchivoZip);

        } catch (Exception ex) {
            ex.printStackTrace();
            nombreArchivoZip = "";
        }
        return datosJsonTxt;
    }

    private static List<Object> recuperarJson(String dirArchivoZip, String archivoZip) {
        return unzip(archivoZip, dirArchivoZip);
    }

    private static List<Object> unzip(String zipFilePath, String destDir) {
        String fileName = "";
        StringBuilder result = new StringBuilder();
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if (!dir.exists()) {
            dir.mkdirs();
        }
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {
                fileName = destDir + File.separator + ze.getName();
                File newFile = new File(fileName);

                System.out.println("Unzipping to " + newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;

                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);

                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();

                //Leer el JSON
                result.append(leerLineasDelArchivo(fileName));
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Arrays.asList(result.toString(), fileName);
    }

    private static String leerLineasDelArchivo(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

}
