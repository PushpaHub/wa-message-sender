public class Contact {
    String phoneNumber;
    String name;
    String nombreCompleto;

    // Constructor
    public Contact(String phoneNumber, String name, String nombreCompleto) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.nombreCompleto = nombreCompleto;
    }

    // Métodos getters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}

