package reader;

import java.io.IOException;

public interface ScenarioReader extends Reader<String> {

    String read(String filePath) throws IOException;

    String getValueByKey(String key) throws IOException;
}
