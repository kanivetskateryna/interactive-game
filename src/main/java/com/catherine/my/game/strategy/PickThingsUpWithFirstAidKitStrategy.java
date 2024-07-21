package com.catherine.my.game.strategy;

import com.catherine.my.game.model.TreeNode;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import com.catherine.my.game.reader.impl.UserChoiceReader;
import com.catherine.my.game.visitor.NodeVisitor;

/**
 * A specific {@link PlotChoiceStrategy} implementation for handling scenarios involving
 * the decision to pick things up while equipped with a first aid kit.
 * This com.catherine.my.game.strategy outlines the decision paths and results based on user choices within the scenario.
 */
@Component
public class PickThingsUpWithFirstAidKitStrategy implements PlotChoiceStrategy {

    private final ApplicationContext applicationContext;

    /**
     * Constructs a new com.catherine.my.game.strategy using the specified application context to access necessary beans.
     *
     * @param applicationContext the {@link ApplicationContext} used for accessing beans by name
     */
    public PickThingsUpWithFirstAidKitStrategy(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Executes the plot choice com.catherine.my.game.strategy using a node com.catherine.my.game.visitor and a user choice com.catherine.my.game.reader.
     * This method guides the user through a series of nodes, each representing a part of the narrative,
     * and manages user choices to determine the subsequent path in the scenario.
     *
     * @param visitor the {@code NodeVisitor} used to visit each node and process it accordingly
     * @param userChoiceReader the {@code UserChoiceReader} used to capture and process user decisions
     */
    @Override
    public void execute(NodeVisitor visitor, UserChoiceReader userChoiceReader) {
        TreeNode pickThingsUpNode = applicationContext.getBean("pickThingsUpNode", TreeNode.class);
        TreeNode claraNode = applicationContext.getBean("claraNode", TreeNode.class);
        TreeNode notCalmedDownNode = applicationContext.getBean("notCalmedDownNode", TreeNode.class);
        TreeNode firstAidKitWithYouNode = applicationContext.getBean("firstAidKitWithYouNode", TreeNode.class);
        TreeNode teamMeetsDeathNode = applicationContext.getBean("teamMeetsDeathNode", TreeNode.class);
        TreeNode winningOptionNode = applicationContext.getBean("winningOptionNode", TreeNode.class);

        pickThingsUpNode.accept(visitor);
        claraNode.accept(visitor);

        userChoiceReader.read(claraNode.getChoices().size());

        notCalmedDownNode.accept(visitor);
        firstAidKitWithYouNode.accept(visitor);

        int firstAidKitChoice = userChoiceReader.read(firstAidKitWithYouNode.getChoices().size());

        if (firstAidKitChoice == 2) {
            teamMeetsDeathNode.accept(visitor);
        } else {
            winningOptionNode.accept(visitor);
        }
    }
}

