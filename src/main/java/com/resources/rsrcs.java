package com.resources;
import com.example.getpost.guest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysql.cj.log.NullLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
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

            try {
                final guest emp = new Gson().fromJson(payload, guest.class);
                System.out.println(emp);
                if (emp.getAge() == 0 || emp.getId().equals("") || emp.getFirstName().equals("")) {
                    throw new Exception();
                }
            }
            catch (Exception e)
            {
                return Response.status(400).entity("ERROR 400 BAD REQUEST The request could not be understood by the server due to malformed syntax. ").build();
            }
            return Response.noContent().build();
                //return Response.noContent().build();

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

    @PUT
    @Path("/PASS")
//    @Produces("")
    public Response checkPass(@QueryParam("userid") String id,@QueryParam("password") String pass)
    {
        if (id.equals("Laiba") && pass.equals("Okay123")) {

            return Response.ok("LOGIN SUCCESSFULLY" + id).build();
        }
        else
        {
            return Response.status(401).entity("401, UNAUTHHORIZED ACCESS").build();
        }
    }

}
