package pl.akademiakodu.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.akademiakodu.gifs.model.Category;
import pl.akademiakodu.gifs.model.Gif;
import pl.akademiakodu.gifs.repository.CategoryRepository;
import pl.akademiakodu.gifs.repository.GifRepository;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GifRepository gifRepository;

    @GetMapping("/categories")
    public String gifCategories(ModelMap modelMap) {
        //1.pobranie wszystkich kategorii
        List<Category> categoryList = categoryRepository.getAllCategories();
        //2.
        modelMap.put("categories", categoryList); //klucz to co potwrzebuje frontend i wartość
        //3.
        return "categories";
    }
    //wchodzimy do category,
    @GetMapping("/category/{id}")
    public String gifsCategory (@PathVariable int id, ModelMap modelMap) {
        //1. pobranie kategorii po id
        Category cat = categoryRepository.getCategoryById(id);
        // 2. pobranie gifów z id danej kategorii
        List<Gif> gifs = gifRepository.getGifsByCategoryId(id);
        //3. przekazanie do widoku
        modelMap.put("category", cat);
        modelMap.put("gifs", gifs);
        return "category";
    }


}
