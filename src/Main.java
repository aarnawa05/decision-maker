import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        printTreeTest();
    }

    /**
     * Testing visualization of decision tree
     */
    public static void printTreeTest() {
        DecisionTree testTree = new DecisionTree();
        DecisionNode testRoot = testTree.getRootNode();

        // Add the first level of children
        String[] first_level_names = { "hello", "hi" };
        testRoot.addChildren(Arrays.asList(first_level_names));

        // Add second level of children
        String[] second_level_names1 = { "yo", "whatsup" };
        String[] second_level_names2 = { "sup", "wasgood" };
        List<DecisionNode> testRootChildren1 = testRoot.getChildren();
        testRootChildren1.get(0).addChildren(Arrays.asList(second_level_names1));
        testRootChildren1.get(1).addChildren(Arrays.asList(second_level_names2));

        System.out.println(testTree);
    }

}