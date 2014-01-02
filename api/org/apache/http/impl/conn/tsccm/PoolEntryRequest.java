package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.concurrent.TimeUnit;

import org.apache.http.conn.ConnectionPoolTimeoutException;

public interface PoolEntryRequest {

    
    BasicPoolEntry getPoolEntry(
            long timeout, 
            TimeUnit tunit) throws InterruptedException, ConnectionPoolTimeoutException;

    
    void abortRequest();
    
}
