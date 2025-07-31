import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Authored by: Aarnawa Koirala
public class DecisionNode {

    // Constants
    private static final int MAX_NAME_LENGHT = 50;

    // Fields for the decision node
    private String activityName;
    private List<DecisionNode> children;
    private DecisionNode parent;

    public DecisionNode() {
        this.activityName = null;
        this.children = new ArrayList<DecisionNode>();
        this.parent = null;
    }

    public DecisionNode(String name, List<String> children, DecisionNode parent) {
        setActivityName(name);
        this.children = new ArrayList<DecisionNode>();
        addChildren(children);
        setParent(parent);
    }

    /* Getters */
    public String getActivityName() {
        return activityName;
    }

    public DecisionNode getParent() {
        return parent;
    }

    public List<DecisionNode> getChildren() {
        return children;
    }

    /* Setters */

    /*
     * pre: name must be a valid string and string length < MAX_NAME_LENGTH
     * return true if the name was successfully set
     */
    public void setActivityName(String activityName) {
        if (activityName == null || activityName.length() > MAX_NAME_LENGHT) {
            throw new IllegalArgumentException("Error trying to setName of node - Must be a valid name");
        }

        this.activityName = activityName;
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
        buffer.append(level + ". " + activityName);
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