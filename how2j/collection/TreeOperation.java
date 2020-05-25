package collection;

// TreeOperation.java
public class TreeOperation {
    
    /*���Ľṹʾ����
            1
        /   \
        2       3
        / \     / \
        4   5   6   7
    */

    // ���ڻ�����Ĳ���
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.leftNode), getTreeDepth(root.rightNode)));
    }


    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // ��֤���������Ϊ��
        if (currNode == null) return;
        // �Ƚ���ǰ�ڵ㱣�浽��ά������
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // ���㵱ǰλ�����ĵڼ���
        int currLevel = ((rowIndex + 1) / 2);
        // ���������һ�㣬�򷵻�
        if (currLevel == treeDepth) return;
        // ���㵱ǰ�е���һ�У�ÿ��Ԫ��֮��ļ������һ�е��������뵱ǰԪ�ص�������֮��ļ����
        int gap = treeDepth - currLevel - 1;

        // ������ӽ����жϣ���������ӣ����¼��Ӧ��"/"������ӵ�ֵ
        if (currNode.leftNode != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.leftNode, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // ���Ҷ��ӽ����жϣ������Ҷ��ӣ����¼��Ӧ��"\"���Ҷ��ӵ�ֵ
        if (currNode.rightNode != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.rightNode, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }


    public static void show(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // �õ��������
        int treeDepth = getTreeDepth(root);

        // ���һ�еĿ��Ϊ2�ģ�n - 1���η���3���ټ�1
        // ��Ϊ������ά����Ŀ��
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // ��һ���ַ����������洢ÿ��λ��Ӧ��ʾ��Ԫ��
        String[][] res = new String[arrayHeight][arrayWidth];
        // ��������г�ʼ����Ĭ��Ϊһ���ո�
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // �Ӹ��ڵ㿪ʼ���ݹ鴦��������
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // ��ʱ���Ѿ���������Ҫ��ʾ��Ԫ�ش��浽�˶�ά�����У�����ƴ�Ӳ���ӡ����
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }
}