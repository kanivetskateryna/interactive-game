package com.catherine.my.game.reader;

import java.io.IOException;

/**
 * An extension of the {@link Reader} interface specialized for reading scenario data.
 * This interface provides the functionality to read entire data from a file and
 * to retrieve specific values based on a key from structured data formats like JSON or XML.
 */
public interface ScenarioReader extends Reader<String> {

    /**
     * Reads and returns the content of a file at the specified file path as a string.
     * This method is intended to be used for reading data files that contain scenario settings or configurations.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a String
     * @throws IOException if an error occurs during reading the file
     */
    String read(String filePath) throws IOException;

    /**
     * Retrieves a specific value from a structured data file (e.g., JSON, XML) based on the provided key.
     * This method assumes that the data file has already been loaded and that the key exists within the data.
     *
     * @param key the key for the value to be retrieved
     * @return the value associated with the specified key as a String
     * @throws IOException if an error occurs during file access or key lookup
     */
    String getValueByKey(String key) throws IOException;
}

