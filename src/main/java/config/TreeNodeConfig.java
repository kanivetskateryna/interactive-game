package config;

import factory.NodeFactory;
import model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.util.List;

@Configuration
@Import({ScenarioTextConfig.class})
public class TreeNodeConfig {

    @Autowired
    private ScenarioTextConfig scenario;

    @Bean
    public TreeNode endNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.endingText(), List.of(), List.of());
    }

    @Bean
    public TreeNode getDressedNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.pickingThingsUpWithoutFirstAidKitText(), List.of(), List.of());
    }

    @Bean
    public TreeNode pickThingsUpNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.pickingThingsUpWithFirstAidKitText(), List.of(), List.of());
    }

    @Bean
    public TreeNode notCalmedDownNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.claraStillWorriedText(), List.of(), List.of());
    }

    @Bean
    public TreeNode claraNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.worriedClaraText(),
                List.of(scenario.tryingToCalmClaraDownChoiceText(),
                        scenario.tryingToCalmClaraDownSecondChoiceText()),
                List.of(notCalmedDownNode(), notCalmedDownNode()));
    }

    @Bean
    public TreeNode teamMeetsDeathNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.losingText(), List.of(), List.of());
    }

    @Bean
    public TreeNode winningOptionNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.winningText(), List.of(), List.of());
    }

    @Bean
    public TreeNode firstAidKitWithYouNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.usefulFirstAidKitText(),
                List.of(scenario.suggestFirstAidKitText(),
                        scenario.keepForYourselfFirstAidKitText()),
                List.of(winningOptionNode(), teamMeetsDeathNode()));
    }

    @Bean
    public TreeNode walkieTalkieNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.goingToGarageToHearSecretVirusNewsText(),
                List.of(scenario.isItAJokeText(),
                        scenario.letsHurryUpText(),
                        scenario.letsPickThingsUpText()),
                List.of(endNode(), getDressedNode(), pickThingsUpNode()));
    }

    @Bean
    public TreeNode watchTvNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.goingToHouseToSeeSecretVirusNewsText(),
                List.of(scenario.isItAJokeText(),
                        scenario.letsHurryUpText(),
                        scenario.letsPickThingsUpText()),
                List.of(endNode(), getDressedNode(), pickThingsUpNode()));
    }

    @Bean
    public TreeNode helicopterNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.oneMoreHelicopterText(),
                List.of(scenario.oldWalkieTalkieChoiceText(),
                        scenario.letsHaveFunChoiceText()),
                List.of(walkieTalkieNode(), endNode()));
    }

    @Bean
    public TreeNode newsNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.urgentNewsText(),
                List.of(scenario.letsGoToHouseChoiceText(),
                        scenario.letsHaveFunChoiceText()),
                List.of(watchTvNode(), endNode()));
    }

    @Bean
    public TreeNode beginningNode() throws IOException {
        return NodeFactory.createNodeWithChoices(scenario.beginningText(),
                List.of(scenario.helicopterChoiceText(),
                        scenario.localNewsChoiceText()),
                List.of(helicopterNode(), newsNode()));
    }
}
