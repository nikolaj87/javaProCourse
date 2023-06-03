package main.java.javatask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class Person {
    private String name;
    private List<Person> friends;

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}


