package reader.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import reader.ScenarioReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonScenarioReader implements ScenarioReader {

    private static final String FILE_PATH = "scenario.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public String read(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(JsonScenarioReader.FILE_PATH);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.getURI()));
        return new String(bytes, StandardCharsets.UTF_8);
    }

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
