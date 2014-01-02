package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Date;

import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;






public final class Validity {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.964 -0400", hash_original_field = "A6DF2012EFBA1C423892102016009D73", hash_generated_field = "07FA11BFB5637FC4281B8963015521E1")

    public static final ASN1Sequence ASN1
        = new ASN1Sequence(new ASN1Type[] {Time.ASN1, Time.ASN1 }) {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.856 -0500", hash_original_method = "F657B381EF2DD7260C3FCC1376D0818A", hash_generated_method = "B47DDE899B17072ADFE0B706A8FFCD7C")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new Validity((Date) values[0], (Date) values[1]);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.858 -0500", hash_original_method = "3170F5CCBA8205B82D53F07AAA85DBB3", hash_generated_method = "25595DF7700E93DC6752BC56D2F2B6D9")
        
@Override protected void getValues(Object object, Object[] values) {
            Validity validity = (Validity) object;
            values[0] = validity.notBefore;
            values[1] = validity.notAfter;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.838 -0500", hash_original_field = "939E4B8755FEFDE7585F0609AA03F4F6", hash_generated_field = "E3E827D7CD2761B5AB55619FED686D61")

    private  Date notBefore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.841 -0500", hash_original_field = "BBDBC72835865CDFD7A55064C8322889", hash_generated_field = "9EC5214487C0E45ED3A209D46FF5E8A8")

    private  Date notAfter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.843 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.846 -0500", hash_original_method = "F8867A5D4F27966CF2038460A4C147B6", hash_generated_method = "AE329B84A653DE3778A8C54ECEF53548")
    
public Validity(Date notBefore, Date notAfter) {
        this.notBefore = notBefore;
        this.notAfter = notAfter;
    }

    /**
     * Returns the value of notBefore field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.848 -0500", hash_original_method = "CB2A2B3C356F1AD47950BB2253ACA4BD", hash_generated_method = "04488B711A48D81B20A16D9A63805F99")
    
public Date getNotBefore() {
        return notBefore;
    }

    /**
     * Returns the value of notAfter field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.850 -0500", hash_original_method = "9EADF7E1E76408811693CE379F621727", hash_generated_method = "F084439CBA509EBC5DE73DA83B400817")
    
public Date getNotAfter() {
        return notAfter;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 Validity value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.852 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }
}

