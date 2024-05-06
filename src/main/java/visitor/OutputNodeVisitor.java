package visitor;

import model.Choice;
import model.TreeNode;
import util.ConsoleColors;

public class OutputNodeVisitor implements NodeVisitor {

    private static final int TYPING_DELAY = 10;

    @Override
    public void visit(TreeNode node) {
        typewriterEffect(node.getTextNode().getText(), TYPING_DELAY);
        for (Choice choice : node.getChoices()) {
            typewriterEffect(ConsoleColors.PURPLE_BOLD_BRIGHT + choice.getTextNode().getText(), TYPING_DELAY);
        }
    }

    private static void typewriterEffect(String text, int delay) {
        try {
            for (char c : text.toCharArray()) {
                System.out.print(c);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
