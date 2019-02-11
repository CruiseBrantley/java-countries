package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//localhost:8080/population/
@RestController
@RequestMapping("/population")
public class PopulationController
{
    @RequestMapping("/size")
    public ArrayList<Country> getCountryDetail(@RequestParam(value="people") int p)
    {
        return JavacountriesApplication.countryList.findCountries( c -> (c.getPopulation() >= p));
    }

    @RequestMapping("/min")
    public Country getPopulationMin()
    {
        ArrayList<Country> tempList = JavacountriesApplication.countryList.countryList;
        Country min = null;
        for( Country c : JavacountriesApplication.countryList.countryList)
        {
            if(min == null)
                min = c;
            if(c.getPopulation() < min.getPopulation())
                min = c;
        }
        return min;
    }

    @RequestMapping("/max")
    public Country getPopulationMax()
    {
        ArrayList<Country> tempList = JavacountriesApplication.countryList.countryList;
        Country max = null;
        for( Country c : JavacountriesApplication.countryList.countryList)
        {
            if(max == null)
                max = c;
            if(c.getPopulation() > max.getPopulation())
                max = c;
        }
        return max;
    }
}
