package com.catherine.my.game.factory;

import com.catherine.my.game.model.Choice;
import com.catherine.my.game.model.TextNode;
import com.catherine.my.game.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a com.catherine.my.game.factory for creating tree nodes, text nodes, and choices.
 */
public final class NodeFactory {

    /**
     * Creates a tree node with choices.
     *
     * @param textNode the text node of the tree node
     * @param choiceTexts the text nodes of the choices
     * @param choiceNodes the target tree nodes of the choices
     * @return the new tree node
     */
    public static TreeNode createNodeWithChoices(TextNode textNode, List<TextNode> choiceTexts, List<TreeNode> choiceNodes) {
        List<Choice> choices = new ArrayList<>();
        for (TextNode choiceText : choiceTexts) {
            Choice choice = createChoice(choiceText, choiceNodes.get(0));
            choices.add(choice);
        }

        return createTreeNode(textNode, choices);
    }

    /**
     * Creates a tree node.
     *
     * @param textNode the text node of the tree node
     * @param choices the choices of the tree node
     * @return the new tree node
     */
    private static TreeNode createTreeNode(TextNode textNode, List<Choice> choices) {
        return new TreeNode.Builder()
                .setTextNode(textNode)
                .setChoices(choices)
                .build();
    }

    /**
     * Creates a text node.
     *
     * @param text the text of the text node
     * @return the new text node
     */
    public static TextNode createTextNode(String text) {
        return new TextNode.Builder()
                .setText(text)
                .build();
    }

    /**
     * Creates a choice.
     *
     * @param textNode the text node of the choice
     * @param target the target tree node of the choice
     * @return the new choice
     */
    private static Choice createChoice(TextNode textNode, TreeNode target) {
        return new Choice.Builder()
                .setTextNode(textNode)
                .setTarget(target)
                .build();
    }
}
