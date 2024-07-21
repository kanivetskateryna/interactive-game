package com.catherine.my.game.model;

/**
 * This class represents a choice in the game.
 * Each choice has a text node and a target tree node.
 */
public final class Choice {

    private TextNode textNode;
    private TreeNode target;

    private Choice() {
    }

    /**
     * Gets the text node of this choice.
     *
     * @return the text node
     */
    public TextNode getTextNode() {
        return textNode;
    }

    /**
     * Gets the target tree node of this choice.
     *
     * @return the target tree node
     */
    public TreeNode getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "Choice{" +
                ", text='" + textNode + '\'' +
                ", target=" + target +
                '}';
    }

    /**
     * This class is a builder for the Choice class.
     */
    public static class Builder {
        private TextNode textNode;
        private TreeNode target;

        /**
         * Sets the text node of the choice.
         *
         * @param textNode the text node
         * @return this builder
         */
        public Builder setTextNode(TextNode textNode) {
            this.textNode = textNode;
            return this;
        }

        /**
         * Sets the target tree node of the choice.
         *
         * @param target the target tree node
         * @return this builder
         */
        public Builder setTarget(TreeNode target) {
            this.target = target;
            return this;
        }

        /**
         * Builds a new Choice object.
         *
         * @return the new Choice object
         */
        public Choice build() {
            Choice choice = new Choice();
            choice.textNode = this.textNode;
            choice.target = this.target;
            return choice;
        }
    }
}
