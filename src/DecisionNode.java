import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Authored by: Aarnawa Koirala
public class DecisionNode {

    // Constants
    private static final int MAX_NAME_LENGHT = 50;

    // Fields for the decision node
    private String name;
    private List<DecisionNode> children;
    private DecisionNode parent;

    public DecisionNode() {
        this.name = null;
        this.children = new ArrayList<DecisionNode>();
        this.parent = null;
    }

    public DecisionNode(String name, List<String> children, DecisionNode parent) {
        this.name = name;
        this.children = new ArrayList<DecisionNode>();
        this.parent = parent;
        addChildren(children);
    }

    /* Getters */
    public String getName() {
        return name;
    }

    public DecisionNode getParent() {
        return parent;
    }

    public List<DecisionNode> getChildren() {
        return children;
    }

    /* Setters */
    public void setName(String name) {
        if (name == null || name.length() > MAX_NAME_LENGHT) {
            throw new IllegalArgumentException("Error trying to setName of node - Must be a valid name");
        }

        this.name = name;
    }

    public void setParent(DecisionNode parent) {
        this.parent = parent;
    }

    /*
     * pre: child must not be null
     * return true if child successfully added
     */
    public DecisionNode addChild(String childName) {
        if (childName == null) {
            return null;
        }

        DecisionNode child = new DecisionNode(childName, null, this);
        this.children.add(child);
        return child;
    }

    /*
     * pre: children must be a valid list
     * return true if all children successfully added
     */
    public boolean addChildren(List<String> childrenNames) {
        if (childrenNames == null) {
            return false;
        }

        for (String childToAdd : childrenNames) {
            if (addChild(childToAdd) == null) {
                return false;
            }
        }

        return true;
    }

    /**
     * Prints out the tree using DFS
     * Solution posted by VasiliNovikov on StackOverFlow
     */
    public String toString() {
        // use StringBuilder to prevent extra time complexity w/ normal strings
        StringBuilder res = new StringBuilder(50);
        print(res, "", "", 0);
        return res.toString();
    }

    /** Helper method for toString */
    private void print(StringBuilder buffer, String prefix, String childrenPrefix, int level) {
        buffer.append(prefix);
        buffer.append(level + ". " + name);
        buffer.append("\n");

        int nextLevel = 1;
        for (Iterator<DecisionNode> it = children.iterator(); it.hasNext();) {
            DecisionNode childNode = it.next();
            if (it.hasNext()) {
                childNode.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ", nextLevel);
            } else {
                childNode.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ", nextLevel);
            }
            nextLevel++;
        }
    }
}