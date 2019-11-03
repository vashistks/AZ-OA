
private TreeNode buildBST(int[] nums, int node1, int node2) {
    TreeNode root = null;
    boolean found1 = false;
    boolean found2 = false;
    for (int val : nums) {
        if (val == node1) found1 = true;
        if (val == node2) found2 = true;
        
        TreeNode node = new TreeNode(val);
        if (root == null) {
            root = node;
            continue;
        }
        addToBST(root, node);
    }
    if (!found1 || !found2) return null;
    return root;
}

private void addToBST(TreeNode root, TreeNode node) {
    for (TreeNode curr = root; true; ) {
        if (curr.val > node.val) {
            if (curr.left == null) {
                curr.left = node;
                break;
            } else {
                curr = curr.left;
            }
        } else {
            if (curr.right == null) {
                curr.right = node;
                break;
            } else {
                curr = curr.right;
            }
        }
    }
}

