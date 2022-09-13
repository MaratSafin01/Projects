package crud.app.controller;

import crud.app.dao.CarDAO;
import crud.app.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("cars", carDAO.getAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        Car car = carDAO.findById(id);
        model.addAttribute("car", car);
        return "show";
    }

    @GetMapping("/{id}/edit")
    public String editCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carDAO.findById(id));
        return "editPage";
    }

    @PatchMapping("{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("car")@Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/editPage";
        }
        carDAO.update(id,car);
        return "redirect:/cars";
    }

    @GetMapping("/new")
    public String newCar(@ModelAttribute("car") Car car) {

        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/new";
        }
        carDAO.save(car);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        carDAO.delete(id);
        return "redirect:/cars";
    }
}
