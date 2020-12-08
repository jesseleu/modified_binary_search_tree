// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.
import java.util.ArrayList;
/**
 * BST Class.
 *
 * @author BJP4 
 * @version 2018.11.09 Jesse Leu edited
 */
public class BST<E extends Comparable<E>> {

    /**root of overall tree  */
    private BSTNode<E> overallRoot; 
    /**
     * constructs an empty search tree
     *
     */
    public BST() {
        overallRoot = null;
    }

    /**
     * add to tree
     * @param  value value
     * @param  idx index
     */    
    public void add(E value, int idx) {
        overallRoot = add(overallRoot, value, idx);
    }

    /**
     * add to tree
     *
     * @param  root root
     * @param  value value
     * @param  idx index
     * @return  SearchTreeNode
     */
    private BSTNode<E> add(BSTNode<E> root, E value, int idx) {
        if (root == null) {
            root = new BSTNode<E>(value, idx);
        } else if (root.data.compareTo(value) >= 0) {
            root.left = add(root.left, value, idx);
        } else {
            root.right = add(root.right, value, idx);
        }
        return root;
    }

    /**
     * get List
     * @param size size of tree
     * @return    array of inordered index 
     */
    public int[] getList(int size)  {
        int[] arr = new int[size];
        getList(overallRoot, arr,0);
        return arr;
    }

    /**
     * get List
     *
     * @param  root  root
     * @param  arr  array to store index
     * @param  index starting index 
     * @return    index 
     */
    private int getList(BSTNode<E> root, int[] arr, int index) {
        if (root == null) {
            return index;
        }
        index = getList(root.left, arr, index);
        arr[index ++] = root.idx;
        index = getList(root.right, arr, index);
        return index;
    }

    /**
     * get size
     *
     * @param  root  root
     * @return    size count 
     */
    private  int getSize(BSTNode<E> root) { 
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + 1 + getSize(root.right);
    }

    /**
     *get size
     *
     * @return    size
     */
    public int getSize() {
        return getSize(overallRoot);
    }

    /**
     * search in certain range
     *
     * @param  start start point
     * @param  end ending point
     * @return    array of result
     */
    public int[] searchRange(E start, E end) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        searchRange(overallRoot, start, end, arrList);
        int[] arr = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i ++) {
            arr[i] = arrList.get(i);
        }
        return arr;
    }

    /**
     * search in certain range
     * @param  root root
     * @param  start start point
     * @param  end ending point
     * @param  arrList arrayList to store result
     * @return    arrayList of result
     */
    private ArrayList<Integer> searchRange(BSTNode<E> root,E start, E end,ArrayList<Integer> arrList) {
        if (root == null) {
            return arrList;
        }
        searchRange(root.left,start,end, arrList);
        if (root.data.compareTo(start) >= 0 && root.data.compareTo(end) <= 0) {
            arrList.add(root.idx);
        }
        searchRange(root.right,start,end, arrList);
        return arrList;
    }

    /**
     * balance the tree
     *
     */
    public void balanceTree() {
        int size = getSize();
        ArrayList<BSTNode<E>> sortedArr = getNodeList();
        this.overallRoot =  balanceTree(sortedArr,0, size - 1);        
    }

    /**
     *  balance the tree
     * @param arr arrayList that store node
     * @param  start start index
     * @param  end  end index
     * @return    root node
     */
    private BSTNode<E> balanceTree(ArrayList<BSTNode<E>> arr,int start, int end) {
        if (start > end) {
            return null;   
        }
        int mid = (int) Math.floor(start + end)/2;
        BSTNode<E> root =  new BSTNode<E>(arr.get(mid).data ,arr.get(mid).idx);
        root.left = balanceTree (arr,start, mid-1);
        root.right = balanceTree(arr,mid+1, end);
        return root;
    }

    /**
     * get node List (only use for balancing tree)
     *
     * @return    arrayList of inordered node
      */
    private ArrayList<BSTNode<E>> getNodeList()  {
        ArrayList<BSTNode<E>> arr = new ArrayList<BSTNode<E>>();
        getNodeList(overallRoot, arr,0);
        return arr;
    }

    /**
     * get List (only use for balancing tree)
     *
     * @param  root  root
     * @param  arr  arrayList to store node
     * @param  index starting index  
     */
    private void getNodeList(BSTNode<E> root, ArrayList<BSTNode<E>> arr, int index) {
        if (root == null) {
            return;
        }
        getNodeList(root.left, arr, index);
        arr.add(root);
        getNodeList(root.right, arr, index);
    }

    /**
     * check if is balanced
     * @param root root 
     * @return   true if is balanced
     */
    private boolean isBalanced(BSTNode<E> root) {
        // put your code here
        boolean balanced = true;
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1 || 
        ! (isBalanced(root.left)) || ! (isBalanced(root.right))) {
            balanced = false;
        }

        return balanced;
    }

    /**
     * check if is balanced
     *
     * @return   true if is balanced
     */
    public boolean isBalanced() {
        return isBalanced(overallRoot);
    }

    /**
     * get hieght of tree
     *
     * @param  root  root
     * @return    height
     */
    private  int getHeight(BSTNode<E> root) { 
        if (root == null) {
            return 0;
        }
        return 1 + Math.max( getHeight(root.left) ,getHeight(root.right));
    }    

    /**
     * BSTNode Class.
     *
     * @author BJP4 
     * @version 2018.11.09 Jesse Leu edited
     */
    private static class BSTNode<E> {
        /** data stored in this node  */
        public E data; 
        /** index  */
        public int idx;
        /** left subtree  */
        public BSTNode<E> left;   
        /** right subtree  */
        public BSTNode<E> right;  

        /**
         * BST node
         *
         * @param  data data
         * @param  idx index
         */
        public BSTNode(E data,int idx) {
            this(data,idx, null, null);
        }

        /**
         * BST node
         *
         * @param  data data
         * @param  idx index
         * @param  left left
         * @param  right right
         */
        public BSTNode(E data,int idx, BSTNode<E> left,
        BSTNode<E> right) {
            this.data = data;
            this.left = left;
            this.idx = idx;
            this.right = right;
        }
    }
}
