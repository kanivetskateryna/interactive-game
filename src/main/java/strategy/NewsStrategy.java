package strategy;

import model.TreeNode;
import org.springframework.context.ApplicationContext;
import reader.impl.UserChoiceReader;
import visitor.NodeVisitor;

/**
 * A concrete implementation of {@link PlotChoiceStrategy} that handles the scenario of news consumption
 * within a plot. This strategy is designed to guide the narrative based on user choices after consuming news.
 *
 * This class manages different plot paths depending on the user's decisions, integrating multiple
 * {@code PlotChoiceStrategy} objects to handle specific choices.
 */
public class NewsStrategy implements PlotChoiceStrategy {

    private final ApplicationContext applicationContext;
    private final PlotChoiceStrategy dressUpWithoutFirstAidKitStrategy;
    private final PlotChoiceStrategy pickThingsUpWithFirstAidKitStrategy;

    /**
     * Constructs a {@code NewsStrategy} with specified strategies for handling different plot choices.
     *
     * @param applicationContext the application context to fetch plot-related nodes
     * @param dressUpWithoutFirstAidKitStrategy a strategy to execute when choosing to dress up without a first aid kit
     * @param pickThingsUpWithFirstAidKitStrategy a strategy to execute when choosing to pick things up with a first aid kit
     */
    public NewsStrategy(ApplicationContext applicationContext,
                        PlotChoiceStrategy dressUpWithoutFirstAidKitStrategy,
                        PlotChoiceStrategy pickThingsUpWithFirstAidKitStrategy) {
        this.applicationContext = applicationContext;
        this.dressUpWithoutFirstAidKitStrategy = dressUpWithoutFirstAidKitStrategy;
        this.pickThingsUpWithFirstAidKitStrategy = pickThingsUpWithFirstAidKitStrategy;
    }

    /**
     * Executes the news consumption plot strategy using the given {@code NodeVisitor} and {@code UserChoiceReader}.
     * This method guides the user through a series of choices beginning at the news consumption stage,
     * branching into different scenarios based on user input.
     *
     * @param visitor the {@code NodeVisitor} used to visit and process plot nodes
     * @param userChoiceReader the {@code UserChoiceReader} used to obtain user input regarding plot choices
     */
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

