import java.util.List;

public class DecisionTree {

    private DecisionNode root;

    public DecisionTree() {
        this.root = new DecisionNode();
    }

    private class DecisionNode {
        private String name;
        private List<DecisionNode> children;

        private DecisionNode() {
            this.name = null;
            this.children = null;
        }

        private DecisionNode(String name, List<DecisionNode> children) {
            this.name = name;
            this.children = children;
        }
    }
}
