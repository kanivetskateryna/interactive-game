package strategy;

import model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import reader.impl.UserChoiceReader;
import visitor.NodeVisitor;

/**
 * A {@link PlotChoiceStrategy} implementation that models a specific narrative path where the plot
 * progresses without a first aid kit being available.
 * This strategy uses specific nodes within the narrative to simulate the consequences of the choices
 * made by the protagonist, reflecting a scenario where lack of preparation leads to significant challenges.
 */
@Component
public class DressUpWithoutFirstAidKitStrategy implements PlotChoiceStrategy {

    private final ApplicationContext applicationContext;

    /**
     * Constructs a new strategy using the Spring application context to manage narrative nodes.
     * The application context is used to retrieve specific {@link TreeNode} beans that represent different
     * points or decisions within the narrative.
     *
     * @param applicationContext the Spring {@link ApplicationContext} used for accessing beans
     */
    @Autowired
    public DressUpWithoutFirstAidKitStrategy(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Executes the strategy based on the state of the narrative defined by nodes within the Spring application context.
     * This method guides the narrative through several key nodes: getting dressed, encountering a character named Clara,
     * and facing the consequences of not calming down during a crucial moment which leads to a fatal encounter.
     *
     * @param visitor a {@link NodeVisitor} that visits each node to perform operations based on the node's type and data.
     * @param userChoiceReader a {@link UserChoiceReader} that reads and processes user decisions at critical points,
     *                         influencing the narrative's outcome.
     */
    @Override
    public void execute(NodeVisitor visitor, UserChoiceReader userChoiceReader) {
        TreeNode getDressedNode = applicationContext.getBean("getDressedNode", TreeNode.class);
        TreeNode claraNode = applicationContext.getBean("claraNode", TreeNode.class);
        TreeNode notCalmedDownNode = applicationContext.getBean("notCalmedDownNode", TreeNode.class);
        TreeNode teamMeetsDeathNode = applicationContext.getBean("teamMeetsDeathNode", TreeNode.class);

        getDressedNode.accept(visitor);
        claraNode.accept(visitor);

        userChoiceReader.read(claraNode.getChoices().size());

        notCalmedDownNode.accept(visitor);
        teamMeetsDeathNode.accept(visitor);
    }
}
