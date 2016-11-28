package StreamApiTests;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pr10StudentsByGroup {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String readLine = scanner.nextLine();
        List<Person> persons = new ArrayList<>();
        while (!readLine.equals("END")) {
            String[] tokens = readLine.split("[\\s]+");
            String name = tokens[0] + " " + tokens[1];
            int group = Integer.valueOf(tokens[2]);

            Person person = new Person(name, group);
            persons.add(person);
            readLine = scanner.nextLine();
        }
        Stream<Person> people = persons.stream();
        Map<Integer, List<Person>> map = people.collect(Collectors.groupingBy(Person::getGroup));
        map.entrySet().forEach(es -> {
            System.out.printf("%s - %s%n", es.getKey(),
                    String.join(", ", es.getValue().stream().map(Person::toString).collect(Collectors.toList())));
        });
    }
}

class Person {
    private String name;
    private int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public Integer getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return name;
    }
}

