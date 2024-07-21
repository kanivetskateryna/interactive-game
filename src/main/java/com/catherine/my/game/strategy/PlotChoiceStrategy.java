package com.catherine.my.game.strategy;

import com.catherine.my.game.reader.impl.UserChoiceReader;
import com.catherine.my.game.visitor.NodeVisitor;

/**
 * Represents a com.catherine.my.game.strategy for handling plot choices in a narrative or decision-based application.
 * This interface is designed to be implemented by classes that define specific strategies
 * for processing user choices and directing the flow of the narrative based on those choices.
 */
public interface PlotChoiceStrategy {

    /**
     * Executes the com.catherine.my.game.strategy using the provided {@code NodeVisitor} and {@code UserChoiceReader}.
     * This method is intended to manage interactions and decisions within the plot, facilitating
     * the advancement of the narrative or decision process based on user input.
     *
     * @param visitor a {@code NodeVisitor} object that may be used to visit various nodes or elements
     *                of the plot depending on the com.catherine.my.game.strategy implementation.
     * @param userChoiceReader a {@code UserChoiceReader} object used to read and process user inputs,
     *                         ensuring that the com.catherine.my.game.strategy responds appropriately to the choices made by the user.
     */
    void execute(NodeVisitor visitor, UserChoiceReader userChoiceReader);
}

