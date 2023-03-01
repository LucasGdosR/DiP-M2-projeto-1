package repository;

import model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository <E extends Person> {
    private final List<E> repository = new ArrayList<>();

    public void add(E person) {
        repository.add(person);
    }

    public List<E> getRepository() {
        return repository;
    }
}
