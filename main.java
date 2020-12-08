/**
 * main class.
 *
 * @author Jesse Leu
 * @version 2018.11.09
 */
public class main {
    /**
     * Constructor for objects of class main
     * 
     * @param args args
     */
    public static void main(String [] args) {
        Wearables test = new Wearables();
        System.out.println(test.readFromFile("Wearables") ? "File Read" : "failed");
        test.balanceRankingTree();
        System.out.println(test.generateCsv(test.getRankingPositionData(),"Sorted by Ranking") ? "Company CSV generated" : "failed");
        System.out.println(test.generateCsv(test.getPricePositionData(),"Sorted by price") ? "Price CSV generated" : "failed");
        System.out.println(test.generateCsv(test.getCoNamePositionData(),"Sorted by Company name") ? "companyName CSV generated" : "failed");
        System.out.println(test.generateCsv(test.searchRange("Archos","Casio"),"Company From Archos TO Casio") ? "Company searching CSV generated" : "failed");
        System.out.println(test.generateCsv(test.searchRange(20.0,100.0),"price From 20 To 100") ? "Price 20-100 CSV generated" : "failed");
        System.out.println(test.generateCsv(test.searchRange(1,20),"rankFrom 1 To 20") ? "ranking Top 20 CSV generated" : "failed");

    }

}
