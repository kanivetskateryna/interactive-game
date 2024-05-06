package config;

import factory.NodeFactory;
import model.TextNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import reader.ScenarioReader;

import java.io.IOException;

@Configuration
@Import(ReaderConfig.class)
public class ScenarioTextConfig {

    @Autowired
    private ScenarioReader jsonScenarioReader;

    @Bean
    public TextNode beginningText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("beginningText"));
    }

    @Bean
    public TextNode helicopterChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("helicopterChoiceText"));
    }

    @Bean
    public TextNode localNewsChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("localNewsChoiceText"));
    }

    @Bean
    public TextNode urgentNewsText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("urgentNewsText"));
    }

    @Bean
    public TextNode letsGoToHouseChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("letsGoToHouseChoiceText"));
    }

    @Bean
    public TextNode letsHaveFunChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("letsHaveFunChoiceText"));
    }

    @Bean
    public TextNode oneMoreHelicopterText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("oneMoreHelicopterText"));
    }

    @Bean
    public TextNode oldWalkieTalkieChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("oldWalkieTalkieChoiceText"));
    }

    @Bean
    public TextNode goingToHouseToSeeSecretVirusNewsText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("goingToHouseToSeeSecretVirusNewsText"));
    }

    @Bean
    public TextNode goingToGarageToHearSecretVirusNewsText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("goingToGarageToHearSecretVirusNewsText"));
    }

    @Bean
    public TextNode isItAJokeText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("isItAJokeText"));
    }

    @Bean
    public TextNode letsHurryUpText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("letsHurryUpText"));
    }

    @Bean
    public TextNode letsPickThingsUpText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("letsPickThingsUpText"));
    }

    @Bean
    public TextNode pickingThingsUpWithoutFirstAidKitText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("pickingThingsUpWithoutFirstAidKitText"));
    }

    @Bean
    public TextNode pickingThingsUpWithFirstAidKitText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("pickingThingsUpWithFirstAidKitText"));
    }

    @Bean
    public TextNode worriedClaraText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("worriedClaraText"));
    }

    @Bean
    public TextNode tryingToCalmClaraDownChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("tryingToCalmClaraDownChoiceText"));
    }

    @Bean
    public TextNode tryingToCalmClaraDownSecondChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("tryingToCalmClaraDownSecondChoiceText"));
    }

    @Bean
    public TextNode claraStillWorriedText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("keepForYourselfFirstAidKitText"));
    }

    @Bean
    public TextNode usefulFirstAidKitText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("usefulFirstAidKitText"));
    }

    @Bean
    public TextNode suggestFirstAidKitText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("suggestFirstAidKitText"));
    }

    @Bean
    public TextNode keepForYourselfFirstAidKitText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("keepForYourselfFirstAidKitText"));
    }

    @Bean
    public TextNode winningText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("winningText"));
    }

    @Bean
    public TextNode losingText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("losingText"));
    }

    @Bean
    public TextNode endingText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("endingText"));
    }

}
