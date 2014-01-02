package javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

public interface ExtensionHeader extends Header {
    String getValue();
    void setValue(String value) throws ParseException;
}
