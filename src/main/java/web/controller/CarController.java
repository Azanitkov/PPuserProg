package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {
    public CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping (value = "/cars")
public String printCars(@RequestParam(value = "count" , required = false , defaultValue = "5")int limit, Model model){
        model.addAttribute("cars", carService.Getlist(limit));
        return "cars/cars";
    }
}
