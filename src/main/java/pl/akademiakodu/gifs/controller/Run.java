package pl.akademiakodu.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akademiakodu.gifs.model.Gif;
import pl.akademiakodu.gifs.repository.GifRepository;

import java.util.List;

@Controller
public class Run {
    @Autowired
    GifRepository gifRepository;
    //tak połączyliśmy GifRepository, bez tego wywala Whitelabel Error w przeglądarce.

    //tak jest przez konstruktor:
//    final GifRepository gifRepository;
//    public Run(GifRepository gifRepository) {
//        this.gifRepository = gifRepository
//    } wstrzyknęliśmy obiekt przez konstruktor
    @GetMapping("/")

    public String hello (ModelMap modelMap) {
       //Wyciągnięcie gifów
        List<Gif> gifList = gifRepository.getGifs();
        //przekazanie do warstwy widoków. modelmapa przyjmuje jako klucz z wartswy forntu, jako wartość z backendu
        modelMap.put("gifs", gifList);
        //zwrócenie widoku
        return "home.html";

    }

    @GetMapping("/showgifsinbrowser")
    @ResponseBody
    public String showGifNames () {
        return gifRepository.getGifNames();
    }

    @GetMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap) {
      //  1. wyciągniecie wartości
    List<Gif> favoritesGifs = gifRepository.getFavoritesGifs();
        //2. przekazanie do view
    modelMap.put("gifs", favoritesGifs);
        //3. zwrócenie widoku
        return "favorites.html";
    }

    @GetMapping("/gif/{name}") //w wąsach jakaś zmienna. poniżej adnotacja Path i nazwa tej zmiennej żeby to zmapować..
    //chcemy na frotnt dostarczyć obiekt o tej nzawie
    public String getGifByName(@PathVariable String name, ModelMap modelMap) {
        //  1. wyciągniecie wartości
        Gif g = gifRepository.getGifByName(name);
        //2.
        modelMap.put("gif", g);
      //  3.
        return "gif-details";
    }



}
