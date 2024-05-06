package factory;

import model.Choice;
import model.TextNode;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public final class NodeFactory {

    public static TreeNode createNodeWithChoices(TextNode textNode, List<TextNode> choiceTexts, List<TreeNode> choiceNodes) {
        List<Choice> choices = new ArrayList<>();
        for (TextNode choiceText : choiceTexts) {
            Choice choice = createChoice(choiceText, choiceNodes.get(0));
            choices.add(choice);
        }

        return createTreeNode(textNode, choices);
    }

    private static TreeNode createTreeNode(TextNode textNode, List<Choice> choices) {
        return new TreeNode.Builder()
                .setTextNode(textNode)
                .setChoices(choices)
                .build();
    }

    public static TextNode createTextNode(String text) {
        return new TextNode.Builder()
                .setText(text)
                .build();
    }

    private static Choice createChoice(TextNode textNode, TreeNode target) {
        return new Choice.Builder()
                .setTextNode(textNode)
                .setTarget(target)
                .build();
    }
}
