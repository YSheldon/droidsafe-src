package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.address.SipURI;

public interface SipURIExt extends SipURI {

    
    public void removeHeaders();

    
    public void removeHeader(String headerName);

    
    public boolean hasGrParam();

    
    public void setGrParam(String value);

}
