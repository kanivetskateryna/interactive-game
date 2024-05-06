package strategy;

import model.TreeNode;
import org.springframework.context.ApplicationContext;
import reader.impl.UserChoiceReader;
import visitor.NodeVisitor;

public class NewsStrategy implements PlotChoiceStrategy {

    private final ApplicationContext applicationContext;
    private final PlotChoiceStrategy dressUpWithoutFirstAidKitStrategy;
    private final PlotChoiceStrategy pickThingsUpWithFirstAidKitStrategy;

    public NewsStrategy(ApplicationContext applicationContext,
                        PlotChoiceStrategy dressUpWithoutFirstAidKitStrategy,
                        PlotChoiceStrategy pickThingsUpWithFirstAidKitStrategy) {
        this.applicationContext = applicationContext;
        this.dressUpWithoutFirstAidKitStrategy = dressUpWithoutFirstAidKitStrategy;
        this.pickThingsUpWithFirstAidKitStrategy = pickThingsUpWithFirstAidKitStrategy;
    }

    @Override
    public void execute(NodeVisitor visitor, UserChoiceReader userChoiceReader) {
        TreeNode newsNode = applicationContext.getBean("newsNode", TreeNode.class);
        TreeNode helicopterNode = applicationContext.getBean("helicopterNode", TreeNode.class);
        TreeNode watchTvNode = applicationContext.getBean("watchTvNode", TreeNode.class);
        TreeNode endNode = applicationContext.getBean("endNode", TreeNode.class);

        newsNode.accept(visitor);

        int plotChoice = userChoiceReader.read(helicopterNode.getChoices().size());

        if (plotChoice == 2) {
            endNode.accept(visitor);
            return;
        }

        watchTvNode.accept(visitor);

        plotChoice = userChoiceReader.read(watchTvNode.getChoices().size());

        switch (plotChoice) {
            case 1 -> endNode.accept(visitor);
            case 2 -> dressUpWithoutFirstAidKitStrategy.execute(visitor, userChoiceReader);
            case 3 -> pickThingsUpWithFirstAidKitStrategy.execute(visitor, userChoiceReader);
        }
    }
}
