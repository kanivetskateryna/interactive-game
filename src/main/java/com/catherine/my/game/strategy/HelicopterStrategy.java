package com.catherine.my.game.strategy;

import com.catherine.my.game.model.TreeNode;
import org.springframework.context.ApplicationContext;
import com.catherine.my.game.reader.impl.UserChoiceReader;
import com.catherine.my.game.visitor.NodeVisitor;

/**
 * A {@code HelicopterStrategy} implements the {@link PlotChoiceStrategy} for scenarios involving a helicopter.
 * This class manages the narrative branches based on user choices within a helicopter scenario, directing the narrative
 * towards different outcomes such as ending the plot or moving onto other decisions related to equipment and strategies.
 */
public class HelicopterStrategy implements PlotChoiceStrategy {

    private final ApplicationContext applicationContext;
    private final PlotChoiceStrategy dressUpWithoutFirstAidKitStrategy;
    private final PlotChoiceStrategy pickThingsUpWithFirstAidKitStrategy;

    /**
     * Constructs a new {@code HelicopterStrategy} with specified strategies for different plot choices.
     *
     * @param applicationContext the context for accessing beans needed within the com.catherine.my.game.strategy
     * @param dressUpWithoutFirstAidKitStrategy the com.catherine.my.game.strategy to execute when choosing to proceed without a first aid kit
     * @param pickThingsUpWithFirstAidKitStrategy the com.catherine.my.game.strategy to execute when choosing to pick things up with a first aid kit
     */
    public HelicopterStrategy(ApplicationContext applicationContext,
                              PlotChoiceStrategy dressUpWithoutFirstAidKitStrategy,
                              PlotChoiceStrategy pickThingsUpWithFirstAidKitStrategy) {
        this.applicationContext = applicationContext;
        this.dressUpWithoutFirstAidKitStrategy = dressUpWithoutFirstAidKitStrategy;
        this.pickThingsUpWithFirstAidKitStrategy = pickThingsUpWithFirstAidKitStrategy;
    }

    /**
     * Executes the helicopter plot com.catherine.my.game.strategy by directing the narrative through various nodes based on user input.
     * This method facilitates the interaction with different plot nodes like helicopterNode, walkieTalkieNode, and endNode,
     * managing user choices to guide the subsequent plot developments.
     *
     * @param visitor a {@code NodeVisitor} used to visit and process nodes within the plot
     * @param userChoiceReader a {@code UserChoiceReader} used to read user choices and guide the plot flow
     */
    @Override
    public void execute(NodeVisitor visitor, UserChoiceReader userChoiceReader) {
        TreeNode helicopterNode = applicationContext.getBean("helicopterNode", TreeNode.class);
        TreeNode walkieTalkieNode = applicationContext.getBean("walkieTalkieNode", TreeNode.class);
        TreeNode endNode = applicationContext.getBean("endNode", TreeNode.class);

        helicopterNode.accept(visitor);

        int plotChoice = userChoiceReader.read(helicopterNode.getChoices().size());

        if (plotChoice == 2) {
            endNode.accept(visitor);
            return;
        }

        walkieTalkieNode.accept(visitor);

        plotChoice = userChoiceReader.read(walkieTalkieNode.getChoices().size());

        switch (plotChoice) {
            case 1 -> endNode.accept(visitor);
            case 2 -> dressUpWithoutFirstAidKitStrategy.execute(visitor, userChoiceReader);
            case 3 -> pickThingsUpWithFirstAidKitStrategy.execute(visitor, userChoiceReader);
        }
    }
}

