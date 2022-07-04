package com.resources;
import com.example.getpost.guest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/hello-world")
public class rsrcs {
        @GET
        public String hello() {
            return "Hello, World!";
        }

        @GET
        @Path("/JSON")

        public Object getguest()
        {
        JsonObject ob = new JsonObject();
        ob.addProperty("CONNECTION",true);
        ob.addProperty("MESSAGE","I'am a JSON message");
        return Response.ok(ob.toString()).build();
    }

        @POST
        @Path("/PostTest")
        public Response postJSON(String payload) throws Exception
        {
                final guest emp=new Gson().fromJson(payload,guest.class);
                System.out.println(emp.toString());
                //return Response.noContent().build();
            return Response.ok(emp.toString()).build();
        }

    @PUT
    @Path("/JSON/PUT")
//    @Produces("")
    public Response putJSON(@QueryParam("firstname") String name,@QueryParam("id") String id,@QueryParam("age") int i)
    {
        guest Guest = new guest();
        System.out.println(Guest.toString());
        Guest.setFirstName(name);
        Guest.setAge(i);
        Guest.setId(id);
        return Response.ok(Guest.toString()).build();
    }

}
