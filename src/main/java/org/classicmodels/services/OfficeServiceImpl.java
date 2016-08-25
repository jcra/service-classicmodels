package org.classicmodels.services;

import org.classicmodels.exceptions.ServiceException;
import org.classicmodels.exceptions.UserCausedException;
import org.classicmodels.model.entities.Offices;
import org.classicmodels.repositories.OfficeRepository;
import org.classicmodels.services.interfaces.OfficeService;
import org.classicmodels.util.commons.Messages;
import org.classicmodels.util.commons.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("OfficeService")
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    @Transactional
    @Override
    public Offices save(Offices offices) throws Exception{

        try{

            if(offices ==  null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "offices");
            officeRepository.save(offices);
            return offices;

        }catch(DataIntegrityViolationException e){
            throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, e.getRootCause().getMessage(), e);
        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public List<Offices> getAll() throws Exception{

        try{

            return officeRepository.findAll();

        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public Offices getOffice(Long officeCode) throws Exception{

        try{

            if(officeCode == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "officeCode");

            Offices out = officeRepository.findOne(officeCode);

            if(out == null) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "officeCode", officeCode);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }
}
