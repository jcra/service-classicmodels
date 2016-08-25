package org.classicmodels.services;

import org.classicmodels.exceptions.ServiceException;
import org.classicmodels.exceptions.UserCausedException;
import org.classicmodels.model.entities.ProductLines;
import org.classicmodels.model.entities.Products;
import org.classicmodels.repositories.ProductLinesRepository;
import org.classicmodels.repositories.ProductsRepository;
import org.classicmodels.services.interfaces.ProductService;
import org.classicmodels.util.commons.Messages;
import org.classicmodels.util.commons.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductLinesRepository productLinesRepository;

    @Override
    public Products save(Products products) throws Exception {

        try{

            if(products == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "product");

            productsRepository.save(products);

            return products;

        }catch(DataIntegrityViolationException e){
            throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, e.getRootCause().getMessage(), e);
        }catch(UserCausedException e){
            throw e;
        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public List<Products> getAll() throws Exception {
        try{

            return productsRepository.findAll();

        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public Products getProduct(String productCode) throws Exception {

        try{

            if(productCode == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "productCode");

            Products out = productsRepository.findOne(productCode);

            if(out == null) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "productCode", productCode);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public List<Products> getProductByProductLine(String productLine) throws Exception {

        try{

            if(productLine == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "productLine");

            List<Products> out = productsRepository.findByProductLine_ProductLine(productLine);

            if(out.size() == 0) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "productLine", productLine);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public ProductLines saveProductLines(ProductLines productLines) throws Exception {

        try{

            if(productLines == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "productLines");

            productLinesRepository.save(productLines);

            return productLines;

        }catch(DataIntegrityViolationException e){
            throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, e.getRootCause().getMessage(), e);
        }catch(UserCausedException e){
            throw e;
        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }

    @Override
    public List<ProductLines> getAllProductLines() throws Exception {

        try{

            return productLinesRepository.findAll();

        }catch(Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }

    }

    @Override
    public ProductLines getProductLine(String productLine) throws Exception {

        try{

            if(productLine == null) throw new UserCausedException(ReturnCode.ERR_REQUIRED_FIELD, Messages.ERR_REQUIRED_FIELD, "productLines");

            ProductLines out = productLinesRepository.findOne(productLine);

            if(out == null) throw new UserCausedException(ReturnCode.ERR_RECORD_NOT_FOUND, Messages.ERR_RECORD_NOT_FOUND, "productLine", productLine);

            return out;

        }catch (UserCausedException e){
            throw e;
        }catch (Exception e){
            throw new ServiceException(ReturnCode.ERR_UNEXPECTED, Messages.ERR_UNEXPECTED, e);
        }
    }
}
