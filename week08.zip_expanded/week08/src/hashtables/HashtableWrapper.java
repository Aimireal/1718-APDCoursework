package hashtables;

/**
 * A wrapper for the Hashtable class
 * 
 * @author Hugh Osborne 
 * @version October 2011
 */
public class HashtableWrapper<S,T> extends java.util.Hashtable<S,T>
{
    public HashtableWrapper(int size) {
        super(size);
    }
}
