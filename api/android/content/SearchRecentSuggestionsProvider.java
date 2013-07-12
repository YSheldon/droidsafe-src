package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.SearchManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class SearchRecentSuggestionsProvider extends ContentProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.297 -0400", hash_original_field = "2325EF4ABFCA50C092A123BB59FD3F59", hash_generated_field = "5E9A5C7D075BBF710B4D594B2F64B868")

    private String mAuthority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.297 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.297 -0400", hash_original_field = "2C0B9C980126BA4B48753CA9AA0C4331", hash_generated_field = "9C78137A5E34C9818D08D92469A7DDDE")

    private boolean mTwoLineDisplay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.297 -0400", hash_original_field = "E711705495807BC6D03B4078616F7024", hash_generated_field = "A3AB1DCCDB0859AC3C99EF131C021999")

    private SQLiteOpenHelper mOpenHelper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.297 -0400", hash_original_field = "6130C8CF316BD3D09A82233C1E227CAE", hash_generated_field = "474B06C5F572DACCF7230DB8072DB33C")

    private Uri mSuggestionsUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.297 -0400", hash_original_field = "A85FF24823B815BB2CDF9277BA736B81", hash_generated_field = "2FC625BBB545DBD2933174B07F6C1795")

    private UriMatcher mUriMatcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.297 -0400", hash_original_field = "00DE8AE7F1F161260B9F7F7F7A7C0A11", hash_generated_field = "BC8EF6A22053F5C6D2A036FACDF0B4A4")

    private String mSuggestSuggestionClause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.297 -0400", hash_original_field = "C7A93AB75A426A7348145102772B2D99", hash_generated_field = "A57E41BCBB900DBD0AC3878DC7781CBD")

    private String[] mSuggestionProjection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.298 -0400", hash_original_method = "0A26B49425F8122D436D3AFA62ACEDE1", hash_generated_method = "0A26B49425F8122D436D3AFA62ACEDE1")
    public SearchRecentSuggestionsProvider ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.300 -0400", hash_original_method = "E16CA3DFE54EBEC32586C921FDE66A1B", hash_generated_method = "83589AF27C6AC3A29974591C24EC5526")
    protected void setupSuggestions(String authority, int mode) {
    if(TextUtils.isEmpty(authority) || 
                ((mode & DATABASE_MODE_QUERIES) == 0))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_291585780 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_291585780.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_291585780;
        } //End block
        mTwoLineDisplay = (0 != (mode & DATABASE_MODE_2LINES));
        mAuthority = new String(authority);
        mMode = mode;
        mSuggestionsUri = Uri.parse("content://" + mAuthority + "/suggestions");
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI(mAuthority, SearchManager.SUGGEST_URI_PATH_QUERY, URI_MATCH_SUGGEST);
    if(mTwoLineDisplay)        
        {
            mSuggestSuggestionClause = "display1 LIKE ? OR display2 LIKE ?";
            mSuggestionProjection = new String [] {
                    "0 AS " + SearchManager.SUGGEST_COLUMN_FORMAT,
                    "'android.resource://system/"
                            + com.android.internal.R.drawable.ic_menu_recent_history + "' AS "
                            + SearchManager.SUGGEST_COLUMN_ICON_1,
                    "display1 AS " + SearchManager.SUGGEST_COLUMN_TEXT_1,
                    "display2 AS " + SearchManager.SUGGEST_COLUMN_TEXT_2,
                    "query AS " + SearchManager.SUGGEST_COLUMN_QUERY,
                    "_id"
            };
        } //End block
        else
        {
            mSuggestSuggestionClause = "display1 LIKE ?";
            mSuggestionProjection = new String [] {
                    "0 AS " + SearchManager.SUGGEST_COLUMN_FORMAT,
                    "'android.resource://system/"
                            + com.android.internal.R.drawable.ic_menu_recent_history + "' AS "
                            + SearchManager.SUGGEST_COLUMN_ICON_1,
                    "display1 AS " + SearchManager.SUGGEST_COLUMN_TEXT_1,
                    "query AS " + SearchManager.SUGGEST_COLUMN_QUERY,
                    "_id"
            };
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.302 -0400", hash_original_method = "7D0F511FF715F3B1AC0B77B3BBE41D35", hash_generated_method = "ACA63A659DCC476CB565CDAF3A47BCB0")
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(uri.getTaint());
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int length = uri.getPathSegments().size();
    if(length != 1)        
        {
            IllegalArgumentException var78F6B5CCB63FEE14EEDD519FE7505B4F_1372138253 = new IllegalArgumentException("Unknown Uri");
            var78F6B5CCB63FEE14EEDD519FE7505B4F_1372138253.addTaint(taint);
            throw var78F6B5CCB63FEE14EEDD519FE7505B4F_1372138253;
        } //End block
        final String base = uri.getPathSegments().get(0);
        int count = 0;
    if(base.equals(sSuggestions))        
        {
            count = db.delete(sSuggestions, selection, selectionArgs);
        } //End block
        else
        {
            IllegalArgumentException var78F6B5CCB63FEE14EEDD519FE7505B4F_555310775 = new IllegalArgumentException("Unknown Uri");
            var78F6B5CCB63FEE14EEDD519FE7505B4F_555310775.addTaint(taint);
            throw var78F6B5CCB63FEE14EEDD519FE7505B4F_555310775;
        } //End block
        getContext().getContentResolver().notifyChange(uri, null);
        int varE2942A04780E223B215EB8B663CF5353_656672503 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934359357 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934359357;
        // ---------- Original Method ----------
        //SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        //final int length = uri.getPathSegments().size();
        //if (length != 1) {
            //throw new IllegalArgumentException("Unknown Uri");
        //}
        //final String base = uri.getPathSegments().get(0);
        //int count = 0;
        //if (base.equals(sSuggestions)) {
            //count = db.delete(sSuggestions, selection, selectionArgs);
        //} else {
            //throw new IllegalArgumentException("Unknown Uri");
        //}
        //getContext().getContentResolver().notifyChange(uri, null);
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.302 -0400", hash_original_method = "ACCB8C00D81DE098BA99F6628F676962", hash_generated_method = "EEA2C89B76C58D3F7E58B522B522743C")
    @Override
    public String getType(Uri uri) {
        addTaint(uri.getTaint());
    if(mUriMatcher.match(uri) == URI_MATCH_SUGGEST)        
        {
String varB2BDA07D3D54DA4D492F1922F6275CEC_572036344 =             SearchManager.SUGGEST_MIME_TYPE;
            varB2BDA07D3D54DA4D492F1922F6275CEC_572036344.addTaint(taint);
            return varB2BDA07D3D54DA4D492F1922F6275CEC_572036344;
        } //End block
        int length = uri.getPathSegments().size();
    if(length >= 1)        
        {
            String base = uri.getPathSegments().get(0);
    if(base.equals(sSuggestions))            
            {
    if(length == 1)                
                {
String var8656A5815F761CC0FE349DD358871A6C_1584223219 =                     "vnd.android.cursor.dir/suggestion";
                    var8656A5815F761CC0FE349DD358871A6C_1584223219.addTaint(taint);
                    return var8656A5815F761CC0FE349DD358871A6C_1584223219;
                } //End block
                else
    if(length == 2)                
                {
String var490969663096EE604BFBACDCB27FFDD5_748739975 =                     "vnd.android.cursor.item/suggestion";
                    var490969663096EE604BFBACDCB27FFDD5_748739975.addTaint(taint);
                    return var490969663096EE604BFBACDCB27FFDD5_748739975;
                } //End block
            } //End block
        } //End block
        IllegalArgumentException var78F6B5CCB63FEE14EEDD519FE7505B4F_1125785517 = new IllegalArgumentException("Unknown Uri");
        var78F6B5CCB63FEE14EEDD519FE7505B4F_1125785517.addTaint(taint);
        throw var78F6B5CCB63FEE14EEDD519FE7505B4F_1125785517;
        // ---------- Original Method ----------
        //if (mUriMatcher.match(uri) == URI_MATCH_SUGGEST) {
            //return SearchManager.SUGGEST_MIME_TYPE;
        //}
        //int length = uri.getPathSegments().size();
        //if (length >= 1) {
            //String base = uri.getPathSegments().get(0);
            //if (base.equals(sSuggestions)) {
                //if (length == 1) {
                    //return "vnd.android.cursor.dir/suggestion";
                //} else if (length == 2) {
                    //return "vnd.android.cursor.item/suggestion";
                //}
            //}
        //}
        //throw new IllegalArgumentException("Unknown Uri");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.304 -0400", hash_original_method = "FF93685A731F041589830914387F684E", hash_generated_method = "8AE6055D2F69A5E65888258F56E7D1D1")
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        addTaint(values.getTaint());
        addTaint(uri.getTaint());
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int length = uri.getPathSegments().size();
    if(length < 1)        
        {
            IllegalArgumentException var78F6B5CCB63FEE14EEDD519FE7505B4F_1766711699 = new IllegalArgumentException("Unknown Uri");
            var78F6B5CCB63FEE14EEDD519FE7505B4F_1766711699.addTaint(taint);
            throw var78F6B5CCB63FEE14EEDD519FE7505B4F_1766711699;
        } //End block
        long rowID = -1;
        String base = uri.getPathSegments().get(0);
        Uri newUri = null;
    if(base.equals(sSuggestions))        
        {
    if(length == 1)            
            {
                rowID = db.insert(sSuggestions, NULL_COLUMN, values);
    if(rowID > 0)                
                {
                    newUri = Uri.withAppendedPath(mSuggestionsUri, String.valueOf(rowID));
                } //End block
            } //End block
        } //End block
    if(rowID < 0)        
        {
            IllegalArgumentException var78F6B5CCB63FEE14EEDD519FE7505B4F_1536280520 = new IllegalArgumentException("Unknown Uri");
            var78F6B5CCB63FEE14EEDD519FE7505B4F_1536280520.addTaint(taint);
            throw var78F6B5CCB63FEE14EEDD519FE7505B4F_1536280520;
        } //End block
        getContext().getContentResolver().notifyChange(newUri, null);
Uri var6313300DCD5E35AA1F8DE70965D30D12_1573737955 =         newUri;
        var6313300DCD5E35AA1F8DE70965D30D12_1573737955.addTaint(taint);
        return var6313300DCD5E35AA1F8DE70965D30D12_1573737955;
        // ---------- Original Method ----------
        //SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        //int length = uri.getPathSegments().size();
        //if (length < 1) {
            //throw new IllegalArgumentException("Unknown Uri");
        //}
        //long rowID = -1;
        //String base = uri.getPathSegments().get(0);
        //Uri newUri = null;
        //if (base.equals(sSuggestions)) {
            //if (length == 1) {
                //rowID = db.insert(sSuggestions, NULL_COLUMN, values);
                //if (rowID > 0) {
                    //newUri = Uri.withAppendedPath(mSuggestionsUri, String.valueOf(rowID));
                //}
            //}
        //}
        //if (rowID < 0) {
            //throw new IllegalArgumentException("Unknown Uri");
        //}
        //getContext().getContentResolver().notifyChange(newUri, null);
        //return newUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.305 -0400", hash_original_method = "B13C0C999B2C074C09328C18BB8361D9", hash_generated_method = "D0E2684913E616A06BE05E0A3118FFA4")
    @Override
    public boolean onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mAuthority == null || mMode == 0)        
        {
            IllegalArgumentException var28077CC31DC67E0C90CC045D4DD93EE3_1497254838 = new IllegalArgumentException("Provider not configured");
            var28077CC31DC67E0C90CC045D4DD93EE3_1497254838.addTaint(taint);
            throw var28077CC31DC67E0C90CC045D4DD93EE3_1497254838;
        } //End block
        int mWorkingDbVersion = DATABASE_VERSION + mMode;
        mOpenHelper = new DatabaseHelper(getContext(), mWorkingDbVersion);
        boolean varB326B5062B2F0E69046810717534CB09_999083284 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_272486422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_272486422;
        // ---------- Original Method ----------
        //if (mAuthority == null || mMode == 0) {
            //throw new IllegalArgumentException("Provider not configured");
        //}
        //int mWorkingDbVersion = DATABASE_VERSION + mMode;
        //mOpenHelper = new DatabaseHelper(getContext(), mWorkingDbVersion);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.309 -0400", hash_original_method = "16EE4F46EB7789D35890A8E3BA57F4D4", hash_generated_method = "CDB1D5FE3D9BA2B6480F292E4B48244B")
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, 
            String sortOrder) {
        addTaint(sortOrder.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(uri.getTaint());
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
    if(mUriMatcher.match(uri) == URI_MATCH_SUGGEST)        
        {
            String suggestSelection;
            String[] myArgs;
    if(TextUtils.isEmpty(selectionArgs[0]))            
            {
                suggestSelection = null;
                myArgs = null;
            } //End block
            else
            {
                String like = "%" + selectionArgs[0] + "%";
    if(mTwoLineDisplay)                
                {
                    myArgs = new String [] { like, like };
                } //End block
                else
                {
                    myArgs = new String [] { like };
                } //End block
                suggestSelection = mSuggestSuggestionClause;
            } //End block
            Cursor c = db.query(sSuggestions, mSuggestionProjection,
                    suggestSelection, myArgs, null, null, ORDER_BY, null);
            c.setNotificationUri(getContext().getContentResolver(), uri);
Cursor var807FB10045EE51C06BDB74744A6714DF_1749333751 =             c;
            var807FB10045EE51C06BDB74744A6714DF_1749333751.addTaint(taint);
            return var807FB10045EE51C06BDB74744A6714DF_1749333751;
        } //End block
        int length = uri.getPathSegments().size();
    if(length != 1 && length != 2)        
        {
            IllegalArgumentException var78F6B5CCB63FEE14EEDD519FE7505B4F_1984829868 = new IllegalArgumentException("Unknown Uri");
            var78F6B5CCB63FEE14EEDD519FE7505B4F_1984829868.addTaint(taint);
            throw var78F6B5CCB63FEE14EEDD519FE7505B4F_1984829868;
        } //End block
        String base = uri.getPathSegments().get(0);
    if(!base.equals(sSuggestions))        
        {
            IllegalArgumentException var78F6B5CCB63FEE14EEDD519FE7505B4F_1076019358 = new IllegalArgumentException("Unknown Uri");
            var78F6B5CCB63FEE14EEDD519FE7505B4F_1076019358.addTaint(taint);
            throw var78F6B5CCB63FEE14EEDD519FE7505B4F_1076019358;
        } //End block
        String[] useProjection = null;
    if(projection != null && projection.length > 0)        
        {
            useProjection = new String[projection.length + 1];
            System.arraycopy(projection, 0, useProjection, 0, projection.length);
            useProjection[projection.length] = "_id AS _id";
        } //End block
        StringBuilder whereClause = new StringBuilder(256);
    if(length == 2)        
        {
            whereClause.append("(_id = ").append(uri.getPathSegments().get(1)).append(")");
        } //End block
    if(selection != null && selection.length() > 0)        
        {
    if(whereClause.length() > 0)            
            {
                whereClause.append(" AND ");
            } //End block
            whereClause.append('(');
            whereClause.append(selection);
            whereClause.append(')');
        } //End block
        Cursor c = db.query(base, useProjection, whereClause.toString(),
                selectionArgs, null, null, sortOrder,
                null);
        c.setNotificationUri(getContext().getContentResolver(), uri);
Cursor var807FB10045EE51C06BDB74744A6714DF_1007787818 =         c;
        var807FB10045EE51C06BDB74744A6714DF_1007787818.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_1007787818;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.312 -0400", hash_original_method = "55DFD7752393168BC8C4EABC7763F14D", hash_generated_method = "4483510740E92BF06E96843EAA174D3D")
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(values.getTaint());
        addTaint(uri.getTaint());
        UnsupportedOperationException var61082A6212A41E0B82A287C327D858C5_1621035133 = new UnsupportedOperationException("Not implemented");
        var61082A6212A41E0B82A287C327D858C5_1621035133.addTaint(taint);
        throw var61082A6212A41E0B82A287C327D858C5_1621035133;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("Not implemented");
    }

    
    private static class DatabaseHelper extends SQLiteOpenHelper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.312 -0400", hash_original_field = "8B87C38A8EA38B485FFD08DF439AE2B0", hash_generated_field = "E37741801665C28F1D0231A69288300D")

        private int mNewVersion;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.312 -0400", hash_original_method = "B1DAC55CA2505DC3136A6C56FC8EE7EF", hash_generated_method = "BB4F1402B9881A4A2D878A4F75BB10F0")
        public  DatabaseHelper(Context context, int newVersion) {
            super(context, sDatabaseName, null, newVersion);
            addTaint(context.getTaint());
            mNewVersion = newVersion;
            // ---------- Original Method ----------
            //mNewVersion = newVersion;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.313 -0400", hash_original_method = "E06D1FEB96F210607100333501CDD83C", hash_generated_method = "D728B7D3126C20414E211181808953EB")
        @Override
        public void onCreate(SQLiteDatabase db) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(db.getTaint());
            StringBuilder builder = new StringBuilder();
            builder.append("CREATE TABLE suggestions (" +
                    "_id INTEGER PRIMARY KEY" +
                    ",display1 TEXT UNIQUE ON CONFLICT REPLACE");
    if(0 != (mNewVersion & DATABASE_MODE_2LINES))            
            {
                builder.append(",display2 TEXT");
            } //End block
            builder.append(",query TEXT" +
                    ",date LONG" +
                    ");");
            db.execSQL(builder.toString());
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //builder.append("CREATE TABLE suggestions (" +
                    //"_id INTEGER PRIMARY KEY" +
                    //",display1 TEXT UNIQUE ON CONFLICT REPLACE");
            //if (0 != (mNewVersion & DATABASE_MODE_2LINES)) {
                //builder.append(",display2 TEXT");
            //}
            //builder.append(",query TEXT" +
                    //",date LONG" +
                    //");");
            //db.execSQL(builder.toString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.314 -0400", hash_original_method = "2B559659D3FF90972195D37AA84A3E73", hash_generated_method = "B65439C8FDD9D5D3839140878856D122")
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(newVersion);
            addTaint(oldVersion);
            addTaint(db.getTaint());
            db.execSQL("DROP TABLE IF EXISTS suggestions");
            onCreate(db);
            // ---------- Original Method ----------
            //Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    //+ newVersion + ", which will destroy all old data");
            //db.execSQL("DROP TABLE IF EXISTS suggestions");
            //onCreate(db);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.314 -0400", hash_original_field = "C25B2620413165EC9A59B837C91D068C", hash_generated_field = "B0E1D7C3FF742238FED651F73F9C940A")

    private static final String TAG = "SuggestionsProvider";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.314 -0400", hash_original_field = "32BC9897935E98FA998CEE53F73B3502", hash_generated_field = "48D2DF6A8AEC894ADA5705E319C23EAE")

    private static final String sDatabaseName = "suggestions.db";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.314 -0400", hash_original_field = "F311FB67C63930CD99BC8EE705EE7414", hash_generated_field = "57F77DA6F947E6544C7754D90AC8B874")

    private static final String sSuggestions = "suggestions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.314 -0400", hash_original_field = "9A7E051DD7E5BBF94A4F848B53C10526", hash_generated_field = "8E4DC53338B9A8C9461F6C695ACB0AD0")

    private static final String ORDER_BY = "date DESC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.314 -0400", hash_original_field = "9F6DE590698D764A3C437678C93B8B88", hash_generated_field = "340612B392192217455628392DBD44D6")

    private static final String NULL_COLUMN = "query";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.315 -0400", hash_original_field = "121E3F6892F6F9FD4567C63158FB37F5", hash_generated_field = "2B3129C4C5E459CCA395CDDBD8A5DC0B")

    private static final int DATABASE_VERSION = 2 * 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.315 -0400", hash_original_field = "9ACD41854B4EE3A3C9AF904C5EB8489C", hash_generated_field = "E35B80185FCB1D4B9E5E92D2D867212A")

    public static final int DATABASE_MODE_QUERIES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.315 -0400", hash_original_field = "4B7757156FD7945A089C532CB0363E6D", hash_generated_field = "A1D1955602EC18263FD6A326A5386D33")

    public static final int DATABASE_MODE_2LINES = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.315 -0400", hash_original_field = "57E8B1BC169F2210C3D7B6E255E82A8F", hash_generated_field = "11E4D2BF5D0DD08F8B44D57153614D99")

    private static final int URI_MATCH_SUGGEST = 1;
}

