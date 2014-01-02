package android.support.v4.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;





public abstract class ResourceCursorAdapter extends CursorAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:25.585 -0500", hash_original_field = "F80FE138111E8F75E38A0C3EDBD52F31", hash_generated_field = "5CC2A1296B93C3BD6A25D936449BB206")

    private int mLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:25.587 -0500", hash_original_field = "918E0C68C84C673BCCCB4F85D3B04922", hash_generated_field = "987A6AA6040898D3C8BF11B145CB7E2D")


    private int mDropDownLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:25.589 -0500", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    
    private LayoutInflater mInflater;
    
    /**
     * Constructor the enables auto-requery.
     *
     * @deprecated This option is discouraged, as it results in Cursor queries
     * being performed on the application's UI thread and thus can cause poor
     * responsiveness or even Application Not Responding errors.  As an alternative,
     * use {@link android.app.LoaderManager} with a {@link android.content.CursorLoader}.
     *
     * @param context The context where the ListView associated with this adapter is running
     * @param layout resource identifier of a layout file that defines the views
     *            for this list item.  Unless you override them later, this will
     *            define both the item views and the drop down views.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:25.592 -0500", hash_original_method = "64F07E8E3FA816788C81269041C7BE2C", hash_generated_method = "257374666F478F88D8CC80372ECE2E46")
    
@Deprecated
    public ResourceCursorAdapter(Context context, int layout, Cursor c) {
        super(context, c);
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    /**
     * Constructor with default behavior as per
     * {@link CursorAdapter#CursorAdapter(Context, Cursor, boolean)}; it is recommended
     * you not use this, but instead {@link #ResourceCursorAdapter(Context, int, Cursor, int)}.
     * When using this constructor, {@link #FLAG_REGISTER_CONTENT_OBSERVER}
     * will always be set.
     *
     * @param context The context where the ListView associated with this adapter is running
     * @param layout resource identifier of a layout file that defines the views
     *            for this list item.  Unless you override them later, this will
     *            define both the item views and the drop down views.
     * @param c The cursor from which to get the data.
     * @param autoRequery If true the adapter will call requery() on the
     *                    cursor whenever it changes so the most recent
     *                    data is always displayed.  Using true here is discouraged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:25.596 -0500", hash_original_method = "2548BF0AFC8B02A5BB725BAA0B70445F", hash_generated_method = "3E89798C9B2C5D2F03EB5ECE916B9FB6")
    
public ResourceCursorAdapter(Context context, int layout, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Standard constructor.
     *
     * @param context The context where the ListView associated with this adapter is running
     * @param layout Resource identifier of a layout file that defines the views
     *            for this list item.  Unless you override them later, this will
     *            define both the item views and the drop down views.
     * @param c The cursor from which to get the data.
     * @param flags Flags used to determine the behavior of the adapter,
     * as per {@link CursorAdapter#CursorAdapter(Context, Cursor, int)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:25.600 -0500", hash_original_method = "1C7227D889BF56CFA0B952AEE07E9BD1", hash_generated_method = "230043E07A223F365DEADF6010FE2226")
    
public ResourceCursorAdapter(Context context, int layout, Cursor c, int flags) {
        super(context, c, flags);
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Inflates view(s) from the specified XML file.
     * 
     * @see android.widget.CursorAdapter#newView(android.content.Context,
     *      android.database.Cursor, ViewGroup)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:25.604 -0500", hash_original_method = "E86C9DC4408CF260B8E6AACF31CF8025", hash_generated_method = "CF872DAE47252191A5AA057CAEF11C5C")
    
@Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return mInflater.inflate(mLayout, parent, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:25.608 -0500", hash_original_method = "C82CC5D78027B48163EBCC94CFA263B9", hash_generated_method = "4CD3623D685FE4D87739977587B9495D")
    
@Override
    public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        return mInflater.inflate(mDropDownLayout, parent, false);
    }

    /**
     * <p>Sets the layout resource of the item views.</p>
     *
     * @param layout the layout resources used to create item views
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:25.613 -0500", hash_original_method = "D5BDA165ADCD99BE26CEA9E8AC3FEB13", hash_generated_method = "2850FAC8F643784AAA922AAC702CED74")
    
public void setViewResource(int layout) {
        mLayout = layout;
    }
    
    /**
     * <p>Sets the layout resource of the drop down views.</p>
     *
     * @param dropDownLayout the layout resources used to create drop down views
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:25.616 -0500", hash_original_method = "62C4D5A7D859DBC1B997DA83ECA5AEBB", hash_generated_method = "FC88CA115289FA083E96B2DB0EBA9FF6")
    
public void setDropDownViewResource(int dropDownLayout) {
        mDropDownLayout = dropDownLayout;
    }

    
}

