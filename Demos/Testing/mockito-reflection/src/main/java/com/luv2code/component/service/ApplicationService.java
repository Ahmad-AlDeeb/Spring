package com.luv2code.component.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.component.dao.ApplicationDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {


    private ApplicationDao applicationDao;

    @Autowired
    public ApplicationService(ApplicationDao applicationDao) {
        this.applicationDao = applicationDao;
    }

    public double addGradeResultsForSingleClass(List<Double> numbers) {
        return applicationDao.addGradeResultsForSingleClass(numbers);
    }

    public double findGradePointAverage (List<Double> grades ) {
        return applicationDao.findGradePointAverage(grades);
    }

    public Object checkNull(Object obj) {
        return applicationDao.checkNull(obj);
    }

}
