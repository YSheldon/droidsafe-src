package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

public interface ReasonPhraseCatalog {

    
    public String getReason(int status, Locale loc)
        ;

}
