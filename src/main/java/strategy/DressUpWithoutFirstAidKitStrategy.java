package strategy;

import model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import reader.impl.UserChoiceReader;
import visitor.NodeVisitor;

@Component
public class DressUpWithoutFirstAidKitStrategy implements PlotChoiceStrategy {

    private final ApplicationContext applicationContext;

    @Autowired
    public DressUpWithoutFirstAidKitStrategy(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


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
