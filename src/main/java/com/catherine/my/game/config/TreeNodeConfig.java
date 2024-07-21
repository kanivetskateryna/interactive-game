package com.catherine.my.game.config;

import com.catherine.my.game.factory.NodeFactory;
import com.catherine.my.game.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.util.List;

/**
 * This class provides configuration for the tree nodes used in the game scenario.
 * It imports the ScenarioTextConfig class and uses the text nodes defined there to create the tree nodes.
 */
@Configuration
@Import({ScenarioTextConfig.class})
public class TreeNodeConfig {

    @Autowired
    private ScenarioTextConfig scenario;

    /**
     * Provides a bean of type TreeNode that represents the end node of the game.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode endNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.endingText(), List.of(), List.of());
    }

    /**
     * Provides a bean of type TreeNode that represents the node where the player gets dressed.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode getDressedNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.pickingThingsUpWithoutFirstAidKitText(), List.of(), List.of());
    }

    /**
     * Provides a bean of type TreeNode that represents the node where the player picks things up.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode pickThingsUpNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.pickingThingsUpWithFirstAidKitText(), List.of(), List.of());
    }

    /**
     * Provides a bean of type TreeNode that represents the node where Clara is not calmed down.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode notCalmedDownNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.claraStillWorriedText(), List.of(), List.of());
    }

    /**
     * Provides a bean of type TreeNode that represents the node where Clara is worried.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode claraNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.worriedClaraText(),
                List.of(scenario.tryingToCalmClaraDownChoiceText(),
                        scenario.tryingToCalmClaraDownSecondChoiceText()),
                List.of(notCalmedDownNode(), notCalmedDownNode()));
    }

    /**
     * Provides a bean of type TreeNode that represents the node where the team meets death.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode teamMeetsDeathNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.losingText(), List.of(), List.of());
    }

    /**
     * Provides a bean of type TreeNode that represents the node where the winning option is presented.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode winningOptionNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.winningText(), List.of(), List.of());
    }

    /**
     * Provides a bean of type TreeNode that represents the node where the player has a first aid kit.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode firstAidKitWithYouNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.usefulFirstAidKitText(),
                List.of(scenario.suggestFirstAidKitText(),
                        scenario.keepForYourselfFirstAidKitText()),
                List.of(winningOptionNode(), teamMeetsDeathNode()));
    }

    /**
     * Provides a bean of type TreeNode that represents the node where the player finds a walkie talkie.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode walkieTalkieNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.goingToGarageToHearSecretVirusNewsText(),
                List.of(scenario.isItAJokeText(),
                        scenario.letsHurryUpText(),
                        scenario.letsPickThingsUpText()),
                List.of(endNode(), getDressedNode(), pickThingsUpNode()));
    }

    /**
     * Provides a bean of type TreeNode that represents the node where the player watches TV.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode watchTvNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.goingToHouseToSeeSecretVirusNewsText(),
                List.of(scenario.isItAJokeText(),
                        scenario.letsHurryUpText(),
                        scenario.letsPickThingsUpText()),
                List.of(endNode(), getDressedNode(), pickThingsUpNode()));
    }

    /**
     * Provides a bean of type TreeNode that represents the node where the player encounters a helicopter.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode helicopterNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.oneMoreHelicopterText(),
                List.of(scenario.oldWalkieTalkieChoiceText(),
                        scenario.letsHaveFunChoiceText()),
                List.of(walkieTalkieNode(), endNode()));
    }

    /**
     * Provides a bean of type TreeNode that represents the node where the player encounters news.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode newsNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.urgentNewsText(),
                List.of(scenario.letsGoToHouseChoiceText(),
                        scenario.letsHaveFunChoiceText()),
                List.of(watchTvNode(), endNode()));
    }

    /**
     * Provides a bean of type TreeNode that represents the beginning node of the game.
     *
     * @return a new TreeNode
     * @throws IOException if an I/O error occurs
     */
    @Bean
    public TreeNode beginningNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.beginningText(),
                List.of(scenario.helicopterChoiceText(),
                        scenario.localNewsChoiceText()),
                List.of(helicopterNode(), newsNode()));
    }
}
