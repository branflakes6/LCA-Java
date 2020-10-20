public class LCA {


    public static class Node<Key extends Comparable<Key>, Value> {
       public Key key;
       public Value val;
       public Node[] children;

        public Node (Key key, Value val, Node[] children){
            this.key = key;
            this.val = val;
            this.children = children;
        }
        public static Node findLCA (Node root, Node a, Node b) {
            try {
                if (root == null || root.key.equals(a.key) || root.key.equals(b.key)) {
                    return root;
                }
                Node child = null;
                int count = 0;
                if (root.children != null) {
                    for (int i = 0; i < root.children.length; i++) {
                        Node temp = findLCA(root.children[i], a, b);
                        if (temp != null) {
                            count++;
                            child = temp;
                        }
                        if (count >= 2) {
                            return root;
                        }
                    }
                }
                return child;
            } catch (Exception e) {
                System.out.println("Cannot find to LCA as either Root, a or b is Null");
                return null;
            }
        }
    }
}

