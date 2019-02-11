package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//localhost:8080/data/allcountries
@RestController
@RequestMapping("/names")
public class NamesController
{
    @RequestMapping("/begin")
    public ArrayList<Country> getCountryDetail(@RequestParam(value="letter") String a)
    {
        return JavacountriesApplication.countryList.findCountries( e -> (e.getName().toLowerCase().startsWith(a.toLowerCase())));
    }

    @RequestMapping("/all")
    public ArrayList<Country> getAllCountries()
    {
        JavacountriesApplication.countryList.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return JavacountriesApplication.countryList.countryList;
    }
}
