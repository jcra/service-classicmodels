package org.classicmodels.resources;

import org.classicmodels.model.entities.Offices;
import org.classicmodels.util.mappers.EntityMapper;
import org.classicmodels.model.views.Office;
import org.classicmodels.services.interfaces.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("offices")
public class OfficeResource extends BaseResource {

    @Autowired
    private OfficeService officeService;

    @POST
    @Path("offices")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Office office){

        try {

            Offices in = EntityMapper.INSTANCE.toOffices(office);

            officeService.save(in);

            office = EntityMapper.INSTANCE.toOfficeView(in);

            return  Response.status(Response.Status.OK).entity(office).build();

        } catch (Exception e) {
            return onException(e);
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll(){

        try {

            List<Offices> in = officeService.getAll();

            List<Office> out = EntityMapper.INSTANCE.toOfficeViewList(in);

            GenericEntity entity = new GenericEntity<List<Office>>(out){};

            return  Response.status(Response.Status.OK).entity(entity).build();

        } catch (Exception e) {
            return onException(e);
        }
    }

    @GET
    @Path("office/{officecode}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getOffice(@PathParam("officecode") Long officeCode){

        try {

            Offices in = officeService.getOffice(officeCode);

            Office out = EntityMapper.INSTANCE.toOfficeView(in);

            return  Response.status(Response.Status.OK).entity(out).build();

        } catch (Exception e) {
            return onException(e);
        }
    }

}
