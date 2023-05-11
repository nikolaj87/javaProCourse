package javatask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@ToString
@Setter
@Getter
@AllArgsConstructor
public class Person {
    private String name;
    private List<Person> friends;
}
