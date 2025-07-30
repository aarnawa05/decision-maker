import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DecisionTree {

    private DecisionNode root;

    public DecisionTree() {
        this.root = new DecisionNode();
        this.root.setName("BASE");
    }

    /**
     * Generates a DecisionTree from a tree format file
     * 
     * @param fileName - the relative path of the decision tree format file
     * @return the decision tree created from file, null if unable to create
     * @throws IOException
     */
    public static DecisionTree createTreeFromFile(String fileName) throws IOException {
        // @todo validate filename and what not
        // @todo validate file
        File file = new File(fileName);
        System.out.println(file.getAbsolutePath());
        Scanner f = new Scanner(file);

        int currentLevel = 0;
        DecisionTree resTree = new DecisionTree();
        DecisionNode currentDecisionNode = resTree.getRootNode();

        while (f.hasNextLine()) {
            String line = f.nextLine();
            int spaceIndex = line.indexOf(' ');
            int level = line.substring(0, spaceIndex).length();

            DecisionNode child = null;
            String childName = line.substring(spaceIndex + 1, line.length());

            // Check level based on number of dashes
            if (level == currentLevel + 1) {
                child = currentDecisionNode.addChild(childName);
            } else if (level == currentLevel) {
                child = currentDecisionNode.getParent().addChild(childName);
            } else if (level < currentLevel) {
                while (level < currentLevel) {
                    currentDecisionNode = currentDecisionNode.getParent();
                    if (currentDecisionNode == null) {
                        f.close();
                        throw new IllegalArgumentException("Invalid file format");
                    }
                    currentLevel--;
                }
                child = currentDecisionNode.getParent().addChild(childName);
            } else {
                f.close();
                throw new IllegalArgumentException("Invalid file format");
            }

            currentLevel = level;
            currentDecisionNode = child;
        }

        f.close();
        System.out.println(resTree);
        return resTree;
    }

    public DecisionNode getRootNode() {
        return root;
    }

    public String toString() {
        return this.root.toString();
    }
}
