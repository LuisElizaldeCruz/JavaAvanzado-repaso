package patronDisenoBuillder;

import java.util.Objects;

public class Persona {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Persona(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(firstName, persona.firstName) && Objects.equals(lastName, persona.lastName) && Objects.equals(email, persona.email) && Objects.equals(phone, persona.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phone);
    }

    @Override
    public String toString() {
        return "patronDisenoBuillder.Persona{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static final class PersonaBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;

        private PersonaBuilder() {
        }

        public static PersonaBuilder aPersona() {
            return new PersonaBuilder();
        }

        public PersonaBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonaBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonaBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public PersonaBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Persona build() {
            return new Persona(firstName, lastName, email, phone);
        }
    }
}
