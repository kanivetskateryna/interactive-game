package strategy;

import reader.impl.UserChoiceReader;
import visitor.NodeVisitor;

public interface PlotChoiceStrategy {

    void execute(NodeVisitor visitor, UserChoiceReader userChoiceReader);
}
