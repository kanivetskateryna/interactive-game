package com.catherine.my.game;

import com.catherine.my.game.config.ReaderConfig;
import com.catherine.my.game.config.StrategyConfig;
import com.catherine.my.game.config.TreeNodeConfig;
import com.catherine.my.game.config.VisitorConfig;
import com.catherine.my.game.model.TreeNode;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.catherine.my.game.reader.impl.UserChoiceReader;
import com.catherine.my.game.strategy.HelicopterStrategy;
import com.catherine.my.game.strategy.NewsStrategy;
import com.catherine.my.game.visitor.NodeVisitor;

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
