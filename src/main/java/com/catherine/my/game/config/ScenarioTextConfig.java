package com.catherine.my.game.config;

import com.catherine.my.game.factory.NodeFactory;
import com.catherine.my.game.model.TextNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.catherine.my.game.reader.ScenarioReader;

import java.io.IOException;

/**
 * This class provides configuration for the text nodes used in the game scenario.
 * It imports the ReaderConfig class and uses the ScenarioReader bean to read the text for each node.
 */
@Configuration
@Import(ReaderConfig.class)
public class ScenarioTextConfig {

    @Autowired
    private ScenarioReader jsonScenarioReader;

    /**
     * Provides a bean of type TextNode that represents the beginning text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode beginningText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("beginningText"));
    }

    /**
     * Provides a bean of type TextNode that represents the helicopter choice text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode helicopterChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("helicopterChoiceText"));
    }

    /**
     * Provides a bean of type TextNode that represents the local news choice text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode localNewsChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("localNewsChoiceText"));
    }

    /**
     * Provides a bean of type TextNode that represents the urgent news text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode urgentNewsText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("urgentNewsText"));
    }

    /**
     * Provides a bean of type TextNode that represents the going to the house choice text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode letsGoToHouseChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("letsGoToHouseChoiceText"));
    }

    /**
     * Provides a bean of type TextNode that represents the having fun choice text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode letsHaveFunChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("letsHaveFunChoiceText"));
    }

    /**
     * Provides a bean of type TextNode that represents the one more helicopter text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode oneMoreHelicopterText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("oneMoreHelicopterText"));
    }

    /**
     * Provides a bean of type TextNode that represents the old walkie-talkie choice text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode oldWalkieTalkieChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("oldWalkieTalkieChoiceText"));
    }

    /**
     * Provides a bean of type TextNode that represents the going to the house to see secret virus news text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode goingToHouseToSeeSecretVirusNewsText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("goingToHouseToSeeSecretVirusNewsText"));
    }

    /**
     * Provides a bean of type TextNode that represents the going to the garage to hear secret virus news text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode goingToGarageToHearSecretVirusNewsText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("goingToGarageToHearSecretVirusNewsText"));
    }

    /**
     * Provides a bean of type TextNode that represents 'is it joke' text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode isItAJokeText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("isItAJokeText"));
    }

    /**
     * Provides a bean of type TextNode that represents the hurry-up suggestion text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode letsHurryUpText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("letsHurryUpText"));
    }

    /**
     * Provides a bean of type TextNode that represents the picking things up text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode letsPickThingsUpText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("letsPickThingsUpText"));
    }

    /**
     * Provides a bean of type TextNode that represents the picking things up without first aid kit text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode pickingThingsUpWithoutFirstAidKitText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("pickingThingsUpWithoutFirstAidKitText"));
    }

    /**
     * Provides a bean of type TextNode that represents the picking things up with first aid kit text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode pickingThingsUpWithFirstAidKitText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("pickingThingsUpWithFirstAidKitText"));
    }

    /**
     * Provides a bean of type TextNode that represents the worried Clara text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode worriedClaraText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("worriedClaraText"));
    }

    /**
     * Provides a bean of type TextNode that represents the trying to calm Clara down choice text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode tryingToCalmClaraDownChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("tryingToCalmClaraDownChoiceText"));
    }

    /**
     * Provides a bean of type TextNode that represents the trying to calm Clara down second choice text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode tryingToCalmClaraDownSecondChoiceText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("tryingToCalmClaraDownSecondChoiceText"));
    }

    /**
     * Provides a bean of type TextNode that represents the Clara still worried text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode claraStillWorriedText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("keepForYourselfFirstAidKitText"));
    }

    /**
     * Provides a bean of type TextNode that represents the useful fist aid kit text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode usefulFirstAidKitText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("usefulFirstAidKitText"));
    }

    /**
     * Provides a bean of type TextNode that represents the suggestion for the first aid kit text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode suggestFirstAidKitText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("suggestFirstAidKitText"));
    }

    /**
     * Provides a bean of type TextNode that represents the keeping for yourself first aid kit text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode keepForYourselfFirstAidKitText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("keepForYourselfFirstAidKitText"));
    }

    /**
     * Provides a bean of type TextNode that represents the winning text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode winningText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("winningText"));
    }

    /**
     * Provides a bean of type TextNode that represents the loosing text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode losingText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("losingText"));
    }

    /**
     * Provides a bean of type TextNode that represents the ending text of the game.
     *
     * @return a new TextNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TextNode endingText() throws IOException {
        return NodeFactory.createTextNode(jsonScenarioReader.getValueByKey("endingText"));
    }

}
