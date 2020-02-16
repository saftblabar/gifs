package pl.akademiakodu.gifs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiakodu.gifs.model.Category;
import pl.akademiakodu.gifs.repository.CategoryRepository;

import java.util.List;

@Controller
public class CategoryController {

    @GetMapping("/categories")
    public String gifCategories(ModelMap modelMap) {
        //1.pobranie wszystkich kategorii
        List<Category> categoryList = CategoryRepository.getAllCategories();
        //2.
        modelMap.put("categories", categoryList); //klucz to co potwrzebuje frontend i wartość
        //3.
        return "categories";
    }
}
