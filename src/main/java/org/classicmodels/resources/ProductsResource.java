package org.classicmodels.resources;

import org.classicmodels.model.entities.ProductLines;
import org.classicmodels.model.entities.Products;
import org.classicmodels.model.views.Product;
import org.classicmodels.model.views.ProductLine;
import org.classicmodels.services.interfaces.ProductService;
import org.classicmodels.util.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("products")
public class ProductsResource extends BaseResource{

    @Autowired
    private ProductService productService;


    @POST
    @Path("product")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Product product){

        try {

            Products in = EntityMapper.INSTANCE.toProducts(product);

            in.setProductLine(productService.getProductLine(product.getProductLine()));

            productService.save(in);

            product = EntityMapper.INSTANCE.toProductView(in);

            return Response.status(Response.Status.OK).entity(product).build();

        }catch (Exception e){
            return onException(e);
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll(){

        try {

            List<Products> in = productService.getAll();

            List<Product> out = EntityMapper.INSTANCE.toProductViewList(in);

            GenericEntity entity = new GenericEntity<List<Product>>(out){};

            return Response.status(Response.Status.OK).entity(entity).build();

        }catch (Exception e){
            return onException(e);
        }
    }

    @GET
    @Path("product/{productCode}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getProduct(@PathParam("productCode") String productCode){

        try{

            Products in = productService.getProduct(productCode);

            Product out = EntityMapper.INSTANCE.toProductView(in);

            return Response.status(Response.Status.OK).entity(out).build();

        }catch (Exception e){
            return onException(e);
        }
    }

    @GET
    @Path("product/productline/{productline}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getProductsByProductLine(@PathParam("productline") String productLine){

        try{

            List<Products> in = productService.getProductByProductLine(productLine);

            List<Product> out = EntityMapper.INSTANCE.toProductViewList(in);

            GenericEntity entity = new GenericEntity<List<Product>>(out){};

            return Response.status(Response.Status.OK).entity(entity).build();

        }catch (Exception e){
            return onException(e);
        }

    }

    @POST
    @Path("productline")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createProductLine(ProductLine productLine){

        try{

            ProductLines in = EntityMapper.INSTANCE.toProductLines(productLine);

            productService.saveProductLines(in);

            productLine = EntityMapper.INSTANCE.toProductLineView(in);

            return Response.status(Response.Status.OK).entity(productLine).build();

        }catch(Exception e){
            return onException(e);
        }
    }

    @GET
    @Path("productline")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllProductLines(){

        try{

            List<ProductLines> in = productService.getAllProductLines();

            List<ProductLine> out = EntityMapper.INSTANCE.toProductLineViewList(in);

            GenericEntity entity = new GenericEntity<List<ProductLine>>(out){};

            return Response.status(Response.Status.OK).entity(entity).build();

        }catch(Exception e){
            return onException(e);
        }
    }

    @GET
    @Path("productline/{productline}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getProductLines(@PathParam("productline") String productline){

        try{

            ProductLines in = productService.getProductLine(productline);

            ProductLine out = EntityMapper.INSTANCE.toProductLineView(in);

            return Response.status(Response.Status.OK).entity(out).build();

        }catch(Exception e){
            return onException(e);
        }
    }

}
