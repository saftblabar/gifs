package pl.akademiakodu.gifs.repository;


import org.springframework.stereotype.Repository;
import pl.akademiakodu.gifs.model.Gif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//adnotacja dla repozytoriów:
@Repository

public class GifRepository {


    //statyczna lista gifów:
    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "mols", true, 1),
            new Gif("ben-and-mike", "mika", true, 2),
            new Gif("book-dominos", "mem", true, 0),
            new Gif("compiler-bot", "bot", true, 1),
            new Gif("cowboy-coder", "code", true, 1),
            new Gif("infinite-andrew", "andrew", false, 2)
    );
    //metoda która podaje nam wszystkie gify
    public List<Gif> getGifs() {
     return ALL_GIFS;
    }

    public String getGifNames() {
        String result = "";
        for (Gif igif : ALL_GIFS) {
            result += igif.getName();
        }
        return result;
    }


    public List<Gif> getFavoritesGifs (){
        return ALL_GIFS.stream().
                filter(Gif::getFavorite)
                .collect(Collectors.toList());

        List<Gif> favorites = new ArrayList<>();
        for (Gif allGif : ALL_GIFS) {
            if (allGif.getFavorite()) {
                favorites.add(allGif);
            }
        } return favorites;
    }
}
