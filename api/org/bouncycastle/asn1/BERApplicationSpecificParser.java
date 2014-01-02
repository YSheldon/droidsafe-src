package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;




public class BERApplicationSpecificParser implements ASN1ApplicationSpecificParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.366 -0500", hash_original_field = "0870A130AAC33D99955FFBF59B769627", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private  int tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.369 -0500", hash_original_field = "5A9D45C9D5E664BF2E986375EA817DEC", hash_generated_field = "BDA992D1A9789DCE4BA9542117A08206")

    private  ASN1StreamParser parser;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.371 -0500", hash_original_method = "E0609A70F39E6E6F4E13B827D68F5B4C", hash_generated_method = "E0609A70F39E6E6F4E13B827D68F5B4C")
    
BERApplicationSpecificParser(int tag, ASN1StreamParser parser)
    {
        this.tag = tag;
        this.parser = parser;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.373 -0500", hash_original_method = "FC19FBA5450B1E3458DF66BAD498F5C7", hash_generated_method = "CFC2257AA2D23BE006B10BEB054A5755")
    
public DEREncodable readObject()
        throws IOException
    {
        return parser.readObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.376 -0500", hash_original_method = "B2A8CB4DD75EA6F990011FAB1A0E301F", hash_generated_method = "4E72C646699C78D7A23099F13E78EA9F")
    
public DERObject getLoadedObject()
        throws IOException
    {
         return new BERApplicationSpecific(tag, parser.readVector());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.378 -0500", hash_original_method = "C25B7E6814F316F8AC8F55D830DF862A", hash_generated_method = "C5BF662686CC510B0E8AAA77A95B6DA6")
    
public DERObject getDERObject()
    {
        try
        {
            return getLoadedObject();
        }
        catch (IOException e)
        {
            throw new ASN1ParsingException(e.getMessage(), e);
        }
    }

    
}

