import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LCATest {

    @Test
    public void testConstructor()
    {
        LCA.Node<Integer, Integer> root = new LCA.Node<>(0, 0, new LCA.Node[]{null,null});
        assertEquals( "Check if we can make Nodes" , 0, root.key.intValue());
    }

    @Test
    public void testLCA()
    {
        LCA.Node<Integer, Integer> node6 = new LCA.Node<>(6,6,null);
        LCA.Node<Integer, Integer> node5 = new LCA.Node<>(5,5,null);
        LCA.Node<Integer, Integer> node4 = new LCA.Node<>(4,4,null);
        LCA.Node<Integer, Integer> node3 = new LCA.Node<>(3,3, null);
        LCA.Node<Integer, Integer> node2 = new LCA.Node<>(2,2, new LCA.Node[]{node5, node6});
        LCA.Node<Integer, Integer> node1 = new LCA.Node<>(1,1, new LCA.Node[]{node3, node4});
        LCA.Node<Integer, Integer> root = new LCA.Node<>(0, 0, new LCA.Node[]{node1, node2});
        assertEquals("The LCA of 5 and 6 should be 2", 2, root.findLCA(root, node5, node6).val);
        assertEquals("The LCA of 3 and 4 should be 1", 1, root.findLCA(root, node3, node4).val);
        assertEquals("The LCA of 3 and 6 should be Root", 0, root.findLCA(root, node3, node6).val);
        assertEquals("The LCA of 4 and 5 should be Root", 0, root.findLCA(root, node4, node5).val);
        assertEquals("The LCA of 1 and 6 should be Root", 0, root.findLCA(root, node1, node6).val);
    }
    @Test
    public void testNull()
    {
        LCA.Node<Integer, Integer> root = new LCA.Node<>(0, 0, new LCA.Node[]{null, null});
        assertEquals("Testing search for a Null Node", null, root.findLCA(root, null, null));
        root = null;
        assertEquals("Searching for Null Root", null, root.findLCA(root, null, null));
    }

}
