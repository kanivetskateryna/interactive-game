package com.catherine.my.game.reader.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import com.catherine.my.game.reader.ScenarioReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A {@code ScenarioReader} that reads scenarios from a JSON file.
 * This class is specifically designed to read and process scenarios stored in a predefined JSON format.
 * It utilizes the Jackson library to parse JSON data.
 */
public class JsonScenarioReader implements ScenarioReader {

    private static final String FILE_PATH = "scenario.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Reads the entire JSON content from a specified file path and returns it as a string.
     * This method uses the {@link ClassPathResource} to ensure the file is accessible from the classpath.
     *
     * @param filePath the path to the JSON file within the classpath
     * @return the content of the file as a UTF-8 encoded string
     * @throws IOException if an I/O error occurs reading from the file or the file cannot be found
     */
    @Override
    public String read(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(JsonScenarioReader.FILE_PATH);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.getURI()));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    /**
     * Retrieves a specific value from the "scenario" array in the JSON file by its key.
     * Each element in the "scenario" array is expected to be an object, and this method
     * searches for the first object that contains the specified key.
     *
     * @param key the key whose value is to be retrieved from the JSON data
     * @return the value associated with the key as text
     * @throws IOException if an I/O error occurs during file reading or JSON parsing
     * @throws IllegalArgumentException if the key is not found in any JSON objects within the "scenario" array
     */
    @Override
    public String getValueByKey(String key) throws IOException {
        JsonNode jsonNode = OBJECT_MAPPER.readTree(read(FILE_PATH));
        JsonNode scenarioNode = jsonNode.get("scenario");

        if (scenarioNode.isArray()) {
            for (JsonNode node : scenarioNode) {
                if (node.has(key)) {
                    return node.get(key).asText();
                }
            }
        }

        throw new IllegalArgumentException("Key not found: " + key);
    }
}

