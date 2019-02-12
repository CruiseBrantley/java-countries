package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//localhost:8080/names/
@RestController
@RequestMapping("/names")
public class NamesController
{
    @RequestMapping("/all")
    public ArrayList<Country> getAllCountries()
    {
        JavacountriesApplication.countryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return JavacountriesApplication.countryList.countryList;
    }

    @RequestMapping("/begin")
    public ArrayList<Country> getCountryBeginsWith(@RequestParam(value="letter") String l)
    {
        return JavacountriesApplication.countryList.findCountries( c -> (c.getName().toLowerCase().startsWith(l.toLowerCase())));
    }

    @RequestMapping("/size")
    public ArrayList<Country> getCountryDetail(@RequestParam(value="letters") int l)
    {
        return JavacountriesApplication.countryList.findCountries( c -> (c.getName().length() >= l));
    }
}
