package java.util.regex;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface MatchResult {

    
    int end();

    
    int end(int group);

    
    String group();

    
    String group(int group);

    
    int groupCount();

    
    int start();

    
    int start(int group);
}
