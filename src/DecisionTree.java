public class DecisionTree {

    private DecisionNode root;

    public DecisionTree() {
        this.root = new DecisionNode();
        this.root.setName("BASE");
    }

    public DecisionNode getRootNode() {
        return root;
    }

    public String toString() {
        return this.root.toString();
    }
}
