class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if (firstName != null && firstName != "") {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        // write your code here
        if (lastName != null && lastName != "") {
            this.lastName = lastName;
        }

    }

    public String getFullName() {
        String fullName = "";
        if (firstName != "" && lastName != "") { // firstName lastName
            fullName = firstName.concat(" ").concat(lastName);
        } else {
            if (firstName == "" && lastName != "") { // lastName
                fullName = lastName;
            } else {
                if (firstName != "" && lastName == "") { // firstName
                    fullName = firstName;
                } else {
                    fullName = "Unknown"; // Unknown
                }
            }
        }

        return fullName; // write your code here
    }
}