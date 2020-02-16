package pl.akademiakodu.gifs.model;

import lombok.Getter;
import lombok.Setter;

//konstruktor daliśmy przez alt insert, przez lomboka jest @AllArgsConstructor (ma wszystkie argumenty w konstrutorze)
//gettery i setter adnotacje w lomboku

@Getter
@Setter
public class Gif {
    private String name;
    private String username;
    private Boolean favorite;
    private int categoryId;

    public Gif(String name, String username, Boolean favorite, int categoryId) {
        this.name = name;
        this.username = username;
        this.favorite = favorite;
        this.categoryId = categoryId;
    }
}
