package org.bouncycastle.crypto.agreement;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;

public class ECDHBasicAgreement implements BasicAgreement {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.819 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "33F61DD1418CAC13EC66C645A8578DF2")

    private ECPrivateKeyParameters key;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.819 -0400", hash_original_method = "96D932906701A5168A9F039F437639FE", hash_generated_method = "96D932906701A5168A9F039F437639FE")
    public ECDHBasicAgreement ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.820 -0400", hash_original_method = "C673BA12443BA4859FBCFCA898D52D2A", hash_generated_method = "E19C4EAC31689C280C3CB5FC55C9A89F")
    public void init(
        CipherParameters key) {
        this.key = (ECPrivateKeyParameters)key;
        // ---------- Original Method ----------
        //this.key = (ECPrivateKeyParameters)key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.820 -0400", hash_original_method = "A4626478FBEED8D6DC4BEF1AE35576B3", hash_generated_method = "FA73F7A244BAEE95EA32061382FFD9E1")
    public BigInteger calculateAgreement(
        CipherParameters pubKey) {
        addTaint(pubKey.getTaint());
        ECPublicKeyParameters pub = (ECPublicKeyParameters)pubKey;
        ECPoint P = pub.getQ().multiply(key.getD());
BigInteger varC51B7E4AD72D846F8CD5C771B0587BB2_1535646439 =         P.getX().toBigInteger();
        varC51B7E4AD72D846F8CD5C771B0587BB2_1535646439.addTaint(taint);
        return varC51B7E4AD72D846F8CD5C771B0587BB2_1535646439;
        // ---------- Original Method ----------
        //ECPublicKeyParameters pub = (ECPublicKeyParameters)pubKey;
        //ECPoint P = pub.getQ().multiply(key.getD());
        //return P.getX().toBigInteger();
    }

    
}

