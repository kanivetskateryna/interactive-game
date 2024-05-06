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

public class GameMain {

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
