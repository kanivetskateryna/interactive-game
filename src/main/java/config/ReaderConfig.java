package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reader.ScenarioReader;
import reader.impl.JsonScenarioReader;
import reader.impl.UserChoiceReader;

/**
 * This class provides configuration for the readers used in the application.
 */
@Configuration
public class ReaderConfig {

    /**
     * Provides a bean of type ScenarioReader that reads scenarios from JSON.
     *
     * @return a new JsonScenarioReader
     */
    @Bean
    public ScenarioReader jsonScenarioReader() {
        return new JsonScenarioReader();
    }

    /**
     * Provides a bean of type UserChoiceReader that reads user choices.
     *
     * @return a new UserChoiceReader
     */
    @Bean
    public UserChoiceReader userChoiceReader() {
        return new UserChoiceReader();
    }
}
