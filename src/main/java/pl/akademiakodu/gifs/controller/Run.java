package pl.akademiakodu.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akademiakodu.gifs.model.Gif;
import pl.akademiakodu.gifs.repository.GifRepository;

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
    @ResponseBody
    public String hello () {
        return "Dziala";
    }

    @GetMapping("/showgifsinbrowser")
    @ResponseBody
    public String showGifNames () {
        return gifRepository.getGifNames();
    }




}
