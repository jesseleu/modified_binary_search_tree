import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
/**
 * Wearables Class.
 *
 * @author Jesse Leu
 * @version 2018.11.09
 */
public class Wearables {
    /**wearable list  */
    private Wearable[] wearableList;
    /**ranking tree  */
    private BST<Integer> rankingTree;
    /**company NameTree tree  */
    private SearchTree<String> companyNameTree;
    /**price Tree */
    private SearchTree<Double> priceTree;
    /**
     * Constructor for objects of class Wearables
     */
    public Wearables() {
        rankingTree = new BST<Integer>();
        companyNameTree = new SearchTree<String>();
        priceTree = new SearchTree<Double>();
    }

    /**
     * read file
     *
     * @param  fileName  fileName  
     * @return    true if success false if not
     */
    public boolean readFromFile(String fileName) {
        boolean isRead = false; 
        int fileNum;
        int rank;
        double price;
        String fileDir = "data/";
        File myFile = new File(fileDir + fileName + ".txt");
        try {
            Scanner in = new Scanner(myFile);
            fileNum = Integer.valueOf(in.next());
            wearableList = new Wearable[fileNum];
            in.next();
            in.nextLine();
            for (int i = 0; i < fileNum; i ++) {     
                String [] tokken = in.nextLine().split("@");
                rank = Integer.valueOf(tokken[0]);
                price = Double.valueOf(tokken[2]);
                wearableList[i] = (new Wearable(rank,tokken[1],price,tokken[3],tokken[4],tokken[5],tokken[6],tokken[7],tokken[8]
                    ,tokken[9],tokken[10]));

                rankingTree.add(rank,i);
                companyNameTree.add(tokken[5],i);
                priceTree.add(price,i);
            }
            isRead = true;
        }
        catch (FileNotFoundException e) {
            wearableList = new Wearable[0];
        }
        return isRead;
    }

    /**
     * get wearable in list
     *
     * @param  index  index
     * @return    wearable at the index
     */
    public Wearable getWearableAtIndex(int index) {
        if (wearableList == null) {
            throw new NullPointerException("Must Read File First");
        }
        if (index < 0 || index >= wearableList.length ) {
            throw new IllegalArgumentException ("Please check Index");
        }
        return wearableList[index];
    }

    /**
     * get ranking position list
     *
     * @return   list of result
     */
    public int[] getRankingPositionData() {
        return rankingTree.getList(wearableList.length);
    }

    /**
     * get price position list
     *
     * @return   list of result
     */
    public int[] getPricePositionData() {
        return priceTree.getList(wearableList.length);
    }

    /**
     * get company name position list
     *
     * @return   list of result
     */
    public int[] getCoNamePositionData() {
        return companyNameTree.getList(wearableList.length);
    }

    /**
     * output csv file 
     *
     * @param  positions list of index
     * @param  fileName  file name
     * @return    true if success false if not
     */
    public boolean generateCsv(int[] positions, String fileName) {
        boolean generated = false;
        int length = positions.length;
        String res = "";
        res += "Ranking,Name,Price,Body Location,Category,Company Name,Company URL,Company Location,Company City,Company US State,Company Country\n";
        String fileDir = "data/";
        File myFile = new File(fileDir + fileName + ".csv");
        for (int i = 0 ;i < length; i ++ ) {
            res += getWearableAtIndex(positions[i]).toCSVFormat();
        }
        try{

            PrintStream printMap = new PrintStream(myFile,"ASCII");
            printMap.print(res);
            printMap.close();

            generated = true;
        }
        catch (FileNotFoundException e) {

        }
        catch (UnsupportedEncodingException e) {

        }
        return generated;
    }

    /**
     * search price in certain range
     *
     * @param  start start point
     * @param  end ending point
     * @return    array of result
     */
    public int[] searchRange(double start, double end) {
        return priceTree.searchRange(start, end);
    }

    /**
     * search company name in certain range
     *
     * @param  start start point
     * @param  end ending point
     * @return    array of result
     */
    public int[] searchRange(String start, String end) {
        return companyNameTree.searchRange(start, end);
    }

    /**
     * search ranking in certain range
     *
     * @param  start start point
     * @param  end ending point
     * @return    array of result
     */
    public int[] searchRange(int start, int end) {
        return rankingTree.searchRange(start, end);
    }
    
    /**
     * balance the ranking tree
     *
     */
    public void balanceRankingTree() {
        rankingTree.balanceTree();
    }


    /**
     * toString
     *
     * @return    string method
     */
    public String toString() {
        if (wearableList == null){
            return "[]";
        }
        return Arrays.toString(wearableList);
    }

}