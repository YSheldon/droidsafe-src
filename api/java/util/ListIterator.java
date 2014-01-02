package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ListIterator<E> extends Iterator<E> {

    
    void add(E object);

    
    public boolean hasNext();

    
    public boolean hasPrevious();

    
    public E next();

    
    public int nextIndex();

    
    public E previous();

    
    public int previousIndex();

    
    public void remove();

    
    void set(E object);
}
