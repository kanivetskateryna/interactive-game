package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reader.ScenarioReader;
import reader.impl.JsonScenarioReader;
import reader.impl.UserChoiceReader;

@Configuration
public class ReaderConfig {

    @Bean
    public ScenarioReader jsonScenarioReader() {
        return new JsonScenarioReader();
    }

    @Bean
    public UserChoiceReader userChoiceReader() {
        return new UserChoiceReader();
    }
}
