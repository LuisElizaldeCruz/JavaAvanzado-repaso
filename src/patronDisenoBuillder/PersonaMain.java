package patronDisenoBuillder;

public class PersonaMain {
    public static void main(String[] args) {
        Persona p = Persona.PersonaBuilder.aPersona()
                .withFirstName("John")
                .withLastName("smith")
                .withPhone("2340923840")
                .withEmail("luis@gmail.com")
                .build();

    }
}
