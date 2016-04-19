package org.zinn.test;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/zipcodes")
public class ZipCodeREST
{
    private List<ZipCode>           zipCodesList    = new ArrayList<>();
    private Map<String, ZipCode>    zipCodesMap     = new HashMap<>();

    ZipCodeREST(String zipCodesFilename)
    {
        java.nio.file.Path zipCodeTextFilePath = Paths.get(zipCodesFilename);
        try
        {
            List<String> zipCodeLines = Files.readAllLines(zipCodeTextFilePath);
            for(String line : zipCodeLines)
            {
                String[] columns = line.split("\t");
                if (columns.length==5)
                {
                    ZipCode zipCode = new ZipCode();
                    zipCode.setZipCode(columns[0]);
                    zipCode.setType(columns[1]);
                    zipCode.setTown(columns[2]);
                    zipCode.setState(columns[3]);
                    zipCode.setCounty(columns[4]);

                    zipCodesList.add(zipCode);
                    zipCodesMap.put(zipCode.getZipCode(), zipCode);
                }
            }
        }
        catch(IOException e)
        {
            throw new WebApplicationException("Could not initialize Zip Code database.", e);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/single/{zipCode}")
    public ZipCode getZipCode(@PathParam("zipCode") String zipCode)
    {
        return zipCodesMap.get(zipCode);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/state/{state}")
    public List<ZipCode> getAllZipCodes(@PathParam("state") String stateCode)
    {
        final String searchStateCode = stateCode == null ? "" : stateCode.toUpperCase().trim();
        return zipCodesList.stream().filter(
                zipCode -> zipCode.getState().equals(searchStateCode)).collect(Collectors.toList());
    }
}
