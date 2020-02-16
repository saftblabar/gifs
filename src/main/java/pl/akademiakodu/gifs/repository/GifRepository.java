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
    public List<Gif> getGifs() { //czy to jest 'getter' dla listy?
     return ALL_GIFS;
    }

    public String getGifNames() {
        String result = "";
        for (Gif igif : ALL_GIFS) {
            result += igif.getName();
        }
        return result;
    }

//pokazanie ulubionych zdjęć:
    public List<Gif> getFavoritesGifs (){
         ALL_GIFS.stream().
                filter(Gif::getFavorite)
                .collect(Collectors.toList());

     //   pętla zamiast streamu:

        List<Gif> favorites = new ArrayList<>();
        for (Gif allGif : ALL_GIFS) {
            if (allGif.getFavorite()) {
                favorites.add(allGif);
            }
        } return favorites;
    }

    //metoda do pokazywania konkretnego zdjęcia:
    public Gif getGifByName (String name) {
        Gif gif = null;
        for (Gif g : ALL_GIFS) {
            if (gif.getName().equals(name)){ //w konstruktorze jest name czyli nazwa gifa. Jak pętla natrafi na tę samą nazwę to ok, zwróci. jak nie to null i w przeglądarce wywali błąd.
                return g;
            }
        } return null;
    }
    public List<Gif> getGifsByCategoryId(int id) {
        //pusta lista gifów do której będziemy dosypywać
        List<Gif> gifs = new ArrayList<>();
        for (Gif g : ALL_GIFS) {
            if (g.getCategoryId() == id) {
                gifs.add(g);
            }
        } return gifs;
    }

}
