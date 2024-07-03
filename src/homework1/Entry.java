package homework1;

public class Entry implements Comparable<Entry> {
    private String name;
    private String address;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String csvLine) {
        String[] data = csvLine.split(";");
        this.name = data[0];
        this.address = data[1];
        this.city = data[2];
        this.postcode = data[3];
        this.country = data[4];
        this.phoneNumber = data[5];
    }

    @Override
    public int compareTo(Entry other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Street address: " + address + "\n" +
                "City: " + city + "\n" +
                "Postal code: " + postcode + "\n" +
                "Country: " + country + "\n" +
                "Phone number: " + phoneNumber + "\n";
    }

}

