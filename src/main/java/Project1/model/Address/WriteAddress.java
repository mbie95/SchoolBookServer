package Project1.model.Address;

/**
 *
 * @author marcin
 */
public class WriteAddress {
    private String city;
    private String street_and_number;
    private String post_code;
    
    WriteAddress() {
        
    }
    
    WriteAddress(Address ad) {
        this.city = ad.getCity();
        this.street_and_number = ad.getStreetAndNumber();
        this.post_code = ad.getPostCode();
    }
    
    public WriteAddress(String city, String str, String post) {
        this.city = city;
        this.street_and_number = str;
        this.post_code = post;
    }

    public String getCity() {
        return city;
    }

    public String getStreet_and_number() {
        return street_and_number;
    }

    public String getPost_code() {
        return post_code;
    }
}
