/**
 * Wearable Class.
 *
 * @author Jesse Leu
 * @version 2018.11.09
 */
public class Wearable{
    /**wearable list  */
    private int ranking;
    /**name  */
    private String name;
    /**price  */
    private double price;
    /**body Location  */
    private String bodyLocation;
    /**category  */
    private String category;
    /**companyName  */
    private String companyName;
    /**URL  */
    private String url;
    /**map Location  */
    private String mapLocation;
    /**city  */
    private String city;
    /**state  */
    private String state;
    /**country  */
    private String country;

    /**
     * Constructor for objects of class Wearable
     * @param  ranking ranking
     * @param  name name
     * @param  price price
     * @param  bodyLocation body Location
     * @param category category
     * @param companyName company Name
     * @param url URL
     * @param mapLocation map Location
     * @param city city
     * @param state state
     * @param country country
     */
    public Wearable(int ranking,String name,double price,String bodyLocation,String category,String companyName,String url,String mapLocation,
    String city,String state, String country ) {
        this.ranking = ranking;
        setName(name);
        this.price = price;
        this.bodyLocation = bodyLocation;
        this. category = category;
        this.companyName = companyName;
        this.url = url;
        this.mapLocation = mapLocation;
        this.city = city;
        this.state= state;
        this.country = country;
    }

    /**
     * set name and change escape character
     *
     * @param  name name
     */
    public void setName(String name) {
        name = name.replace("\"","''");
        this.name = name;
    }

    /**
     * get Ranking
     *
     * @return    ranking
     */
    public int getRanking() {
        return ranking;
    }

    /**
     * get name
     *
     * @return    name
     */
    public String getName() {
        return name;
    }

    /**
     * get price
     *
     * @return    price
     */
    public double getPrice(){
        return price;
    }

    /**
     * get Body Location
     *
     * @return    Body Location
     */
    public String getBodyLocation() {
        return bodyLocation;
    }

    /**
     * get Category
     *
     * @return    Category
     */
    public String getCategory() {
        return category;
    }

    /**
     * get Company
     *
     * @return    Company
     */
     public String getCompany(){
        return companyName;
    }

     /**
     * get URL
     *
     * @return    URL
     */
    public String getUrl() {
        return url;
    }

     /**
     * get Map Location
     *
     * @return    Map Location
     */
    public String getMapLocation() {
        return mapLocation;
    }

     /**
     * get city
     *
     * @return    city
     */
    public String getCity() {
        return city;
    }

     /**
     * get state
     *
     * @return    state
     */
    public String getState() {
        return state;
    }

    /**
     * get country
     *
     * @return    country
     */
    public String getCountry() {
        return country;
    }

     /**
     * toString 
     *
     * @return    string result
     */
    public String toString() {
        return "Rank: " + ranking + " Name: " + name + " Price: " + price + " Body Location: " + bodyLocation + " Category: " + category + " Company name: " + companyName
        + " URL: " + url + " Location: " + mapLocation+city + " U.S State : " + state + " Country: " + country + "\n";
    }

    /**
     * to csv format
     *
     * @return   string to csv format
     */
    public String toCSVFormat() {
        return ranking + ",\""+name + "\","+price + ",\"" + bodyLocation + "\",\"" + category + "\",\"" + companyName + "\",\""
        + url+"\",\"" + mapLocation + "\",\"" + city+"\",\"" + state + "\",\"" + country + "\"\n";
    }
}
