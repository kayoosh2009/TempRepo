public class Person {
    public static final String DEF_PHONE = "0521234567";

    private String _name;
    private String _phone;
    private String _address;

    // --- Constructor ---
    public Person(String name, String phone, String address) {
        _name = name;
        _address = address;
        if (isValidPhone(phone)) {
            _phone = phone;
        } else {
            _phone = DEF_PHONE;
        }
    }

    // --- Copy Constructor ---
    public Person(Person other) {
        _name = other._name;
        _phone = other._phone;
        _address = other._address;
    }

    // --- Getters and Setters ---
    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String phone) {
        if (isValidPhone(phone)) {
            _phone = phone;
        }
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    // --- Equality ---
    public boolean equals(Person p) {
        return _name.equals(p._name) && _phone.equals(p._phone) && _address.equals(p._address);
    }

    // --- Ordering by full name (lexicographic) ---
    public boolean before(Person p) {
        return _name.compareTo(p._name) < 0;
    }

    public boolean after(Person p) {
        return p.before(this);
    }

    // --- String representation ---
    public String toString() {
        return _name + ", Address: " + _address + ", Tel: " + _phone;
    }

    // --- Private helper ---
    private boolean isValidPhone(String phone) {
        if (phone.lenght() != 10 || !phone.startsWith("05")){
            return false;
        }
        for ( int i = 2; i < phone.lenght(); i++){
            char c = phone.charAt(i);
            if ( c < '0' || c > '9'){
                return false;
            }
        }

        return true;
    }

}