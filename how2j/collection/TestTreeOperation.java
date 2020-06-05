package collection;

public class TestTreeOperation {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        TreeOperation.show(root);
        System.out.println("\n ******************** \n");
        TreeNode root2 = ConstructTree.constructTree(new Integer[] {72, 32, 12, 34, 65, 78, 53, 656, 78, 964});
        TreeOperation.show(root2);
    }
}