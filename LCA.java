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
    }

    public static void main(String[] args)
    {
        Node<Integer, Integer> node6 = new Node<>(6,6,null);
        Node<Integer, Integer> node5 = new Node<>(5,5,null);
        Node<Integer, Integer> node4 = new Node<>(4,4,null);
        Node<Integer, Integer> node3 = new Node<>(3,3, null);
        Node<Integer, Integer> node2 = new Node<>(2,2, new Node[]{node5, node6});
        Node<Integer, Integer> node1 = new Node<>(1,1, new Node[]{node3, node4});
        Node<Integer, Integer> root = new Node<>(0, 0, new Node[]{node1, node2});
        Node<Integer, Integer> LCA = findLCA(root, node5, node6);
        System.out.println("The LCA of node node 5 and node 6 is "+ LCA.key);
    }
    public static Node findLCA (Node root, Node a, Node b) {
        if (root == null || root.key.equals(a.key) || root.key.equals(b.key))
        {
            return root;
        }
        Node child = null;
        int count = 0;
        if (root.children != null)
        {
            for (int i = 0; i < root.children.length; i++)
            {
                Node temp = findLCA(root.children[i], a, b);
                if (temp != null)
                {
                    count++;
                    child = temp;
                }
                if (count >= 2)
                {
                    return root;
                }
            }
        }
           return child;
    }
}
