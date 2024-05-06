package model;

public final class Choice {

    private TextNode textNode;
    private TreeNode target;

    private Choice() {
    }

    public TextNode getTextNode() {
        return textNode;
    }

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

    public static class Builder {
        private TextNode textNode;
        private TreeNode target;

        public Builder setTextNode(TextNode textNode) {
            this.textNode = textNode;
            return this;
        }

        public Builder setTarget(TreeNode target) {
            this.target = target;
            return this;
        }

        public Choice build() {
            Choice choice = new Choice();
            choice.textNode = this.textNode;
            choice.target = this.target;
            return choice;
        }
    }
}
