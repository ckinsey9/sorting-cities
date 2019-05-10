package org.launchcode.comparators;

import org.launchcode.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator implements Comparator<City> {

    List<Comparator<City>> comparators = new ArrayList<>();

    public void add(Comparator<City> compareClass) {
        comparators.add(compareClass);
    }

    @Override
    public int compare(City o1, City o2) {
        int helper = comparators.get(0).compare(o1, o2);
        while (helper == 0) {
            return comparators.get(1).compare(o1,o2);
        }
        return helper;
    }

}
