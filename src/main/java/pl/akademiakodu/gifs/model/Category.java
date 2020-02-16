package pl.akademiakodu.gifs.model;

import lombok.Getter;
import lombok.Setter;

public class Category {

    @Getter
    @Setter
    private int id;
    //gettery i settery mogą być nad klasą, wtedy będą rzutowane na wszystkie pola.
    @Getter
    @Setter
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
