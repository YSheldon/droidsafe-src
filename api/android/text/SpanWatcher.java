package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface SpanWatcher extends NoCopySpan {
    
    public void onSpanAdded(Spannable text, Object what, int start, int end);
    
    public void onSpanRemoved(Spannable text, Object what, int start, int end); 
    
    public void onSpanChanged(Spannable text, Object what, int ostart, int oend,
                              int nstart, int nend);
}
