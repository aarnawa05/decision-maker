import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print(printTreeTest());
        DecisionTree.createTreeFromFile("sampleTrees/decisionTree1");
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