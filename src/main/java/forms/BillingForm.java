package forms;

public class BillingForm {
    private String firstName;
    private String lastName;
    private String company;
    private String country;
    private String streetAddress;
    private String city;
    private String stateCanton;
    private String pinCode;
    private String phone;
    private String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getCountry() {
        return country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getStateCanton() {
        return stateCanton;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    BillingForm(BillingFormBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.company = builder.company;
        this.country = builder.country;
        this.streetAddress = builder.streetAddress;
        this.city = builder.city;
        this.stateCanton = builder.stateCanton;
        this.pinCode = builder.pinCode;
        this.phone = builder.phone;
        this.emailAddress = builder.emailAddress;
    }

    //BuilderClass
    public static class BillingFormBuilder {
        private String firstName;
        private String lastName;
        private String company;
        private String country;
        private String streetAddress;
        private String city;
        private String stateCanton;
        private String pinCode;
        private String phone;
        private String emailAddress;

        public BillingFormBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public BillingFormBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public BillingFormBuilder setCompany(String company) {
            this.company = company;
            return this;
        }

        public BillingFormBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public BillingFormBuilder setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public BillingFormBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public BillingFormBuilder setStateCanton(String stateCanton) {
            this.stateCanton = stateCanton;
            return this;
        }

        public BillingFormBuilder setPinCode(String pinCode) {
            this.pinCode = pinCode;
            return this;
        }

        public BillingFormBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public BillingFormBuilder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public BillingForm build() {
            return new  BillingForm(this);
        }
    }
}
