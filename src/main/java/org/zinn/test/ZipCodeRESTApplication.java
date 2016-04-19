package org.zinn.test;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@ApplicationPath("/rest")
public class ZipCodeRESTApplication extends Application
{
    @Context
    ServletContext context;

    @Override
    public Set<Object> getSingletons()
    {
        Set<Object> singletons = new HashSet<>();
        singletons.add(new ZipCodeREST(context.getRealPath("WEB-INF/classes/META-INF/zipCodes.txt")));
        return singletons;
    }

}
