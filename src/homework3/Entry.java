package homework3;
public class Entry {
    String surname, name, streetAddress, city, postcode, country, phoneNumber;

    public Entry(String surname, String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, %s, Address: %s, %s, %s, %s, Phone: %s",
                surname, name, streetAddress, city, postcode, country, phoneNumber);
    }
}
