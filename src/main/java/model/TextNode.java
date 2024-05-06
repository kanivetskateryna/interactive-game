package model;

/**
 * This class represents a text node in the game.
 * Each text node has a text string.
 */
public final class TextNode {

    private String text;

    private TextNode() {
    }

    /**
     * Gets the text of this text node.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "TextNode{" +
                ", text='" + text + '\'' +
                '}';
    }

    /**
     * This class is a builder for the TextNode class.
     */
    public static class Builder {
        private String text;

        /**
         * Sets the text of the text node.
         *
         * @param text the text
         * @return this builder
         */
        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        /**
         * Builds a new TextNode object.
         *
         * @return the new TextNode object
         */
        public TextNode build() {
            TextNode textNode = new TextNode();
            textNode.text = this.text;
            return textNode;
        }
    }
}
