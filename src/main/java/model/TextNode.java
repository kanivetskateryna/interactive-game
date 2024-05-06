package model;

public final class TextNode {

    private String text;

    private TextNode() {
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "TextNode{" +
                ", text='" + text + '\'' +
                '}';
    }

    public static class Builder {
        private String text;

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public TextNode build() {
            TextNode textNode = new TextNode();
            textNode.text = this.text;
            return textNode;
        }
    }
}
