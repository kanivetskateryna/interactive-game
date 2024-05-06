package strategy;

import model.TreeNode;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import reader.impl.UserChoiceReader;
import visitor.NodeVisitor;

@Component
public class PickThingsUpWithFirstAidKitStrategy implements PlotChoiceStrategy {

    private final ApplicationContext applicationContext;

    public PickThingsUpWithFirstAidKitStrategy(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void execute(NodeVisitor visitor, UserChoiceReader userChoiceReader) {
        TreeNode pickThingsUpNode = applicationContext.getBean("pickThingsUpNode", TreeNode.class);
        TreeNode claraNode = applicationContext.getBean("claraNode", TreeNode.class);
        TreeNode notCalmedDownNode = applicationContext.getBean("notCalmedDownNode", TreeNode.class);
        TreeNode firstAidKitWithYouNode = applicationContext.getBean("firstAidKitWithYouNode", TreeNode.class);
        TreeNode teamMeetsDeathNode = applicationContext.getBean("teamMeetsDeathNode", TreeNode.class);
        TreeNode winningOptionNode = applicationContext.getBean("winningOptionNode", TreeNode.class);

        pickThingsUpNode.accept(visitor);
        claraNode.accept(visitor);

        userChoiceReader.read(claraNode.getChoices().size());

        notCalmedDownNode.accept(visitor);
        firstAidKitWithYouNode.accept(visitor);

        int firstAidKitChoice = userChoiceReader.read(firstAidKitWithYouNode.getChoices().size());

        if (firstAidKitChoice == 2) {
            teamMeetsDeathNode.accept(visitor);
        } else {
            winningOptionNode.accept(visitor);
        }
    }
}
