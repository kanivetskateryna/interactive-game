import config.ReaderConfig;
import config.StrategyConfig;
import config.TreeNodeConfig;
import config.VisitorConfig;
import model.TreeNode;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import reader.impl.UserChoiceReader;
import strategy.HelicopterStrategy;
import strategy.NewsStrategy;
import visitor.NodeVisitor;

/**
 * This is the main class for the game.
 */
public class GameMain {

    /**
     * The main method which is the entry point for the game.
     * It sets up the application context, gets the necessary beans,
     * starts the game, and handles the user's initial choice.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                TreeNodeConfig.class,
                VisitorConfig.class,
                ReaderConfig.class,
                StrategyConfig.class);

        UserChoiceReader userChoiceReader = context.getBean(UserChoiceReader.class);
        NodeVisitor visitor = context.getBean(NodeVisitor.class);
        TreeNode beginningNode = context.getBean("beginningNode", TreeNode.class);

        HelicopterStrategy helicopterStrategy = context.getBean(HelicopterStrategy.class);
        NewsStrategy newsStrategy = context.getBean(NewsStrategy.class);

        beginningNode.accept(visitor);

        int plotChoice = new UserChoiceReader().read(beginningNode.getChoices().size());

        if (plotChoice == 1) {
            helicopterStrategy.execute(visitor, userChoiceReader);
        } else {
            newsStrategy.execute(visitor, userChoiceReader);
        }

        context.close();
    }
}
