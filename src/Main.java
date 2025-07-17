import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print(printTreeTest());
        DecisionTree treeToUse = DecisionTree.createTreeFromFile("sampleTrees/decisionTree1");
        runDecisions(treeToUse);
    }

    private static void runDecisions(DecisionTree tree) throws IOException {

        Scanner k = new Scanner(System.in);
        DecisionNode currentNode = tree.getRootNode();
        do {
            if (currentNode.getChildren() != null && currentNode.getChildren().size() > 0) {
                printChildren(currentNode);
                int decisionNumber = getDecisionNumber(k, currentNode);
            } else {
                // break out of loop?
            }

        } while (true);

    }

    private static void printChildren(DecisionNode currentNode) {
        List<DecisionNode> children = currentNode.getChildren();
        for (int child = 0; child < children.size(); child++) {
            System.out.printf("%d. %s", child + 1, children.get(child));
        }
        System.out.println("Type a number to select a decision, or type exit to stop");
    }

    private static int getDecisionNumber(Scanner k, DecisionNode currentNode) {
        if (k.hasNextInt()) {
            int choice = k.nextInt();
            // @todo this stuff
            k.nextLine();
            if (choice <= 0 && choice >= currentNode.getChildren().size()) {
                return -1;
            }
            return choice;
            // verify valid integer
        } else if (k.hasNext()) {
            String choice = k.nextLine();
            if (choice.equalsIgnoreCase("exit")) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }

    }

    /**
     * Testing visualization of decision tree
     */
    public static String printTreeTest() {
        DecisionTree testTree = new DecisionTree();
        DecisionNode testRoot = testTree.getRootNode();

        // Add the first level of children
        String[] first_level_names = { "Hobby", "Work" };
        testRoot.addChildren(Arrays.asList(first_level_names));

        // Add second level of children
        String[][] second_level_names = { { "Guitar", "Cooking" }, { "Leetcode", "Project work", "Learn Framework" } };
        List<DecisionNode> testRootChildren1 = testRoot.getChildren();
        testRootChildren1.get(0).addChildren(Arrays.asList(second_level_names[0]));
        testRootChildren1.get(1).addChildren(Arrays.asList(second_level_names[1]));

        List<DecisionNode> testChildren2 = testRootChildren1.get(0).getChildren();
        List<DecisionNode> testChildren3 = testRootChildren1.get(1).getChildren();

        String[][] third_level_names = { { "Chords", "Songs" }, null,
                { "New problem", "Review problem", "Study Technique" }, null, { "React", "Spring" } };

        testChildren2.get(0).addChildren(Arrays.asList(third_level_names[0]));
        testChildren3.get(0).addChildren(Arrays.asList(third_level_names[2]));
        testChildren3.get(2).addChildren(Arrays.asList(third_level_names[4]));

        return testTree.toString();
    }

}