/**
 * The Patron class i basically a library user
 */
public class Patron {
    // Private member variables for patron details
    private String name;
    private String id;
    private String contact;

    /**
     * Constructor to initialize a Patron object with name, ID, and contact details.
     *
     * @param name    The name of the patron.
     * @param id      The unique ID for the patron.
     * @param contact The contact details of the patron.
     */
    public Patron(String name, String id, String contact) {
        this.name = name;
        this.id = id;
        this.contact = contact;
    }

    // Getters for patron details

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    /**
     * Returns a string representation of the patron details.
     */
    @Override
    public String toString() {
        return "Patron Name: " + name + 
               ", ID: " + id + 
               ", Contact: " + contact;
    }
}
