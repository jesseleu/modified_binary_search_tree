// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.
import java.util.Arrays;
import java.util.ArrayList;
/**
 * SearchTree Class.
 *
 * @author BJP4 
 * @version 2018.11.09 Jesse Leu edited
 */
public class SearchTree<E extends Comparable<E>> {
    /** root of overall tree  */   
    private SearchTreeNode<E> overallRoot; 

    /**
     * constructs an empty search tree
     *
     */
    public SearchTree() {
        overallRoot = null;
    }

    /**
     * add to tree
     * @param  value value
     * @param  idx index
     */    
    public void add(E value,int idx) {
        overallRoot = add(overallRoot, value,idx);
    }

    /**
     * add to tree
     *
     * @param  root root
     * @param  value value
     * @param  idx index
     * @return    SearchTreeNode
     */
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value,int idx) {
        if (root == null) {
            root = new SearchTreeNode<E>(value,idx);
        } else if (root.data.compareTo(value) > 0) {
            root.left = add(root.left, value,idx);
        }else if (root.data.compareTo(value) == 0) {
            if (root.down == null){
                root.down = new DupTreeNode(idx);
            }
            else {
                DupTreeNode newFront = new DupTreeNode(idx);
                newFront.down = root.down;
                root.down = newFront;
            }
        } else {
            root.right = add(root.right, value,idx);
        }
        return root;
    }

    /**
     * get List
     * @param size size of tree
     * @return    array of inordered index 
     */
    public int[] getList(int size) {
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
    private int getList(SearchTreeNode<E> root, int[] arr, int index) {
        if (root == null) {
            return index;
        }
        index = getList(root.left, arr, index);
        arr[index ++] = root.idx;
        if(root.down != null) {
            DupTreeNode current = root.down;
            while (current != null) {
                arr[index ++] = current.idx;
                current = current.down;
            }
        }
        index = getList(root.right, arr, index);
        return index;
    }

    /**
     * get size
     *
     * @param  root  root
     * @return    size count 
     */
    private  int getSize(SearchTreeNode<E> root) { 
        if (root == null) {
            return 0;
        }
        int down = 0;
        if(root.down != null) {
            down = 0;
            DupTreeNode current = root.down;
            while (current != null) {
                down ++;
                current = current.down;
            }
        }
        return getSize(root.left) + down + 1 + getSize(root.right);
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
    private ArrayList<Integer> searchRange(SearchTreeNode<E> root,E start, E end,ArrayList<Integer> arrList) {
        if (root == null) {
            return arrList;
        }
        searchRange(root.left,start,end, arrList);
        if (root.data.compareTo(start) >= 0 && root.data.compareTo(end) <= 0) {
            arrList.add(root.idx);
            if (root.down != null) {
                DupTreeNode current = root.down;
                while (current != null){
                    arrList.add(current.idx);
                    current = current.down;
                }
            }
        }
        searchRange(root.right,start,end, arrList);

        return arrList;
    }
    
    /**
     * SearchTreeNode Class.
     *
     * @author BJP4 
     * @version 2018.11.09 Jesse Leu edited
     */
    private static class SearchTreeNode<E> {
        /** data stored in this node  */
        public E data; 
        /** index  */
        public int idx;
        /** down node  */
        public DupTreeNode down; 
        /** left subtree  */
        public SearchTreeNode<E> left;   
        /** right subtree  */
        public SearchTreeNode<E> right;  

        /**
         * search tree node
         *
         * @param  data data
         * @param  idx index
         */
        public SearchTreeNode(E data,int idx) {
            this(data,idx,null, null, null);
        }

        /**
         * search tree node
         *
         * @param  data data
         * @param  idx index
         * @param  down same value
         * @param  left left
         * @param  right right
         */
        public SearchTreeNode(E data,int idx, DupTreeNode down, SearchTreeNode<E> left,
        SearchTreeNode<E> right) {
            this.data = data;
            this.idx = idx;
            this.down = down;
            this.left = left;
            this.right = right;
        }
    }
    /**
     * DupTreeNode Class.
     *
     * @author BJP4 
     * @version 2018.11.09 Jesse Leu edited
     */
    private static  class DupTreeNode {
        /** index  */
        public int idx;
        /** down node  */
        public DupTreeNode down; 

        /**
         * duplicate tree node
         *
         * @param  idx index
         */
        public DupTreeNode(int idx) {
            this(idx,null);
        }

        /**
         * duplicate tree node
         *
         * @param  idx index
         * @param  down store index of same value data 
         */
        public DupTreeNode(int idx, DupTreeNode down) {
            this.idx = idx;
            this.down = down;
        }

    }

}