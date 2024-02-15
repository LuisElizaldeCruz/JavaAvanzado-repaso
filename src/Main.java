import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("London");
        cities.add("New York");
        cities.add("Tokyo");
        cities.add("Barcelona");
        cities.add("Buenos Aires");
        cities.add("Bogota");
        cities.add("Ciudad de México");
        cities.add("Lima");

        /*
        for (int i = 0; i < cities.size(); i++){
            System.out.println(cities.get(i));
        }
        */
        //cities.stream().forEach(city -> System.out.println(city));//expresion lamda
        //o tambien se puede abreviar de la siguiente manera (Referencia a metodo)
        cities.stream().forEach(Main::printCity);
        //o tambien de la siguiente manera
        //cities.stream().forEach(System.out::println);
    }

    public static void printCity(String city) {
        System.out.println(city);
    }
}
