package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface CrossProcessCursor extends Cursor {
    
    CursorWindow getWindow();

    
    void fillWindow(int position, CursorWindow window);

    
    boolean onMove(int oldPosition, int newPosition); 
}
