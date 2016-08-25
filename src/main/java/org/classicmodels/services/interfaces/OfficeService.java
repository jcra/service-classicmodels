package org.classicmodels.services.interfaces;

import org.classicmodels.model.entities.Offices;

import java.util.List;

public interface OfficeService {

    Offices save(Offices offices) throws Exception;

    List<Offices> getAll() throws Exception;

    Offices getOffice(Long officeCode)throws Exception;

}
