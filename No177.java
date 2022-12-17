// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node createTree(String[] nodes) {
        Node[] tree = new Node[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].equals("null")) {
                tree[i] = new Node(Integer.parseInt(nodes[i]));
            }
        }

        for (int i = 0; i < nodes.length; i++) {
            Node node = tree[i];
            if(node != null) {
                if(2*i+1 < nodes.length) {
                    node.left = tree[2*i+1];
                }
                if(2*i+2 < nodes.length) {
                    node.right = tree[2*i+2];
                }
            }
        }
        return tree[0];
    }
};


class No177 {
    // public Node connect(Node root) {
    //     if(root == null ) {
    //         return root;
    //     }

    //     List<Node> layer = new ArrayList<>(); 
    //     layer.add(root);
    //     List<Node> nextLayer = new ArrayList<>();

    //     while(layer.size() != 0) {
    //         for(int i = 0; i < layer.size(); i++) {
    //             if(i+1 == layer.size()) {
    //                 layer.get(i).next = null;
    //             } else {
    //                 layer.get(i).next = layer.get(i+1);
    //             }
                
    //             if(layer.get(i).left != null) {
    //                 nextLayer.add(layer.get(i).left);
    //             }

    //             if(layer.get(i).right != null) {
    //                 nextLayer.add(layer.get(i).right);
    //             }
    //         }

    //         layer.clear();
    //         layer.addAll(nextLayer);
    //         nextLayer.clear();
    //     }
        
    //     return root;
    // }

    public Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        if(root.left != null) {
            root.left.next = root.right;
        }

        if (root.val == 7 && root.right != null) {
            System.out.println("");
        }

        Node lNode = root.right == null ? root.left: root.right;
        
        Node rRoot = root.next;
    
        while(rRoot!=null && rRoot.left==null && rRoot.right==null) {
            rRoot = rRoot.next;
        }
        
        if (rRoot == null) {
            lNode.next = null;
        } else {
            Node rNode = rRoot.left == null ? rRoot.right:rRoot.left;
            lNode.next = rNode;
        }

        root.right = connect(root.right);
        root.left = connect(root.left);
        return root;
    }

    public static void main(String[] args) {
        String[] nodes =  {"2","1","3","0","7","9","1","2","null","1","0","null","null",
        "8","8","null","null","null","null","7"};
        Node tree = Node.createTree(nodes);
        tree = new No177().connect(tree);
    }
}