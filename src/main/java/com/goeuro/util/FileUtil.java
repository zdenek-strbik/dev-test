package com.goeuro.util;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Zdenek Strbik
 */
public final class FileUtil {

    private FileUtil() {
    }

    /**
     * Reads file content into String
     * @param file Disk file
     * @param encoding Encoding used when reading file
     * @return String that was read from file
     * @throws IOException
     */
    public static String readFile(File file, String encoding) throws IOException {
        return readStream(new FileInputStream(file), encoding);
    }

    /**
     * Reads resource file content into String
     * @param fileName Resource file name
     * @param encoding Encoding used when reading file
     * @return String that was read from file
     * @throws IOException
     */
    public static String readResourceFile(String fileName, String encoding) throws IOException {
        return readStream(FileUtil.class.getClassLoader().getResourceAsStream(fileName), encoding);
    }

    private static String readStream(InputStream is, String encoding) throws IOException {
        return IOUtils.toString(is, encoding);
    }

}
