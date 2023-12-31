package demo_04.controller;

import demo_04.model.dto.request.MenuRequest;
import demo_04.model.service.impl.category.ICategoryService;
import demo_04.model.service.impl.menu.IMenuService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final IMenuService menuService;
    private final ICategoryService categoryService;

    @GetMapping
    public String findAllMenu(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model) {
        model.addAttribute("menu",menuService.findAll(name, page, size) );
        model.addAttribute("name", name);
        return "menu/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("menu",new MenuRequest());
        model.addAttribute("catalog",categoryService.findAll());
        return "menu/add";
    }

    @PostMapping("/add")
    public String addMenu(@ModelAttribute MenuRequest menuRequest){
        menuService.save(menuRequest);
        return "redirect:/menu";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable Long id) {
        model.addAttribute("menu",menuService.findById(id));
        model.addAttribute("catalog",categoryService.findAll());
        return "menu/edit";
    }
    @PostMapping("/update")
    public String updateMenu(@ModelAttribute("menu") MenuRequest menuRequest){
        System.out.println('a');
        System.out.println(menuRequest.getImage());
        System.out.println("b");
        menuService.save(menuRequest);
        return "redirect:/menu";
    }

    @GetMapping("delete/{id}")
    private String deleteMenu(@PathVariable Long id){
        menuService.delete(id);
        return "redirect:/menu";
    }


}
