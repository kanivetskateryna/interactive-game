package model;

import visitor.NodeVisitor;

import java.util.List;

/**
 * This class represents a tree node in the game.
 * Each tree node has a text node and a list of choices.
 */
public final class TreeNode {

    private TextNode textNode;
    private List<Choice> choices;

    private TreeNode() {
    }

    /**
     * Gets the text node of this tree node.
     *
     * @return the text node
     */
    public TextNode getTextNode() {
        return textNode;
    }

    /**
     * Gets the choices of this tree node.
     *
     * @return the choices
     */
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

    /**
     * This class is a builder for the TreeNode class.
     */
    public static class Builder {
        private TextNode textNode;
        private List<Choice> choices;

        /**
         * Sets the text node of the tree node.
         *
         * @param textNode the text node
         * @return this builder
         */
        public Builder setTextNode(TextNode textNode) {
            this.textNode = textNode;
            return this;
        }

        /**
         * Sets the choices of the tree node.
         *
         * @param choices the choices
         * @return this builder
         */
        public Builder setChoices(List<Choice> choices) {
            this.choices = choices;
            return this;
        }

        /**
         * Builds a new TreeNode object.
         *
         * @return the new TreeNode object
         */
        public TreeNode build() {
            TreeNode treeNode = new TreeNode();
            treeNode.textNode = this.textNode;
            treeNode.choices = this.choices;
            return treeNode;
        }
    }

    /**
     * Accepts a visitor to visit this tree node.
     *
     * @param visitor the visitor
     */
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

}
