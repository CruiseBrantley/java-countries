package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//localhost:8080/age/
@RestController
@RequestMapping("/age")
public class AgeController
{
    @RequestMapping("/age")
    public ArrayList<Country> getCountryDetail(@RequestParam(value="age") int a)
    {
        return JavacountriesApplication.countryList.findCountries( c -> (c.getAge() >= a));
    }

    @RequestMapping("/min")
    public Country getAgeMin()
    {
        ArrayList<Country> tempList = JavacountriesApplication.countryList.countryList;
        Country min = null;
        for( Country c : JavacountriesApplication.countryList.countryList)
        {
            if(min == null)
                min = c;
            if(c.getAge() < min.getAge())
                min = c;
        }
        return min;
    }

    @RequestMapping("/max")
    public Country getAgeMax()
    {
        ArrayList<Country> tempList = JavacountriesApplication.countryList.countryList;
        Country max = null;
        for( Country c : JavacountriesApplication.countryList.countryList)
        {
            if(max == null)
                max = c;
            if(c.getAge() > max.getAge())
                max = c;
        }
        return max;
    }
}
