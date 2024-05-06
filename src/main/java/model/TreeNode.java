package model;

import visitor.NodeVisitor;

import java.util.List;

public final class TreeNode {

    private TextNode textNode;
    private List<Choice> choices;

    private TreeNode() {
    }

    public TextNode getTextNode() {
        return textNode;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                ", textNode=" + textNode +
                ", choices=" + choices +
                '}';
    }

    public static class Builder {
        private TextNode textNode;
        private List<Choice> choices;

        public Builder setTextNode(TextNode textNode) {
            this.textNode = textNode;
            return this;
        }

        public Builder setChoices(List<Choice> choices) {
            this.choices = choices;
            return this;
        }

        public TreeNode build() {
            TreeNode treeNode = new TreeNode();
            treeNode.textNode = this.textNode;
            treeNode.choices = this.choices;
            return treeNode;
        }
    }

    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

}
