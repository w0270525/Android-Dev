package com.example.jonathan.finalproject;

import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.util.Log;

public class DatabaseAdapter {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_VIDEO = "video";
    public static final String KEY_TITLE ="title";
    public static final String TAG = "DBAdapter";

    private static final String DATABASE_VIDEO = "MyDB";
    private static final String DATABASE_TABLE = "videos";
    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE =
            "create table videos(_id integer primary key autoincrement,"
                    + "video text not null,title text not null);";

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DatabaseAdapter(Context ctx)
    {
        DBHelper = new DatabaseHelper(ctx);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context,DATABASE_VIDEO,null,DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db)
        {
            try{
                db.execSQL(DATABASE_CREATE);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }//end method onCreate

        public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
        {
            Log.w(TAG,"Upgrade database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS videos");
            onCreate(db);
        }//end method onUpgrade
    }

    //open the database
    public DatabaseAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //close the database
    public void close()
    {
        DBHelper.close();
    }

    //insert a video into the database
    public long insertVideo(String video,String title)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_VIDEO, video);
        initialValues.put(KEY_TITLE, title);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //delete a particular video
    public boolean deleteVideo(long rowId)
    {
        return db.delete(DATABASE_TABLE,KEY_ROWID + "=" + rowId,null) >0;
    }

    //retrieve all the videos
    public Cursor getAllVideo()
    {
        return db.query(DATABASE_TABLE,new String[]{KEY_ROWID,KEY_VIDEO,
                KEY_TITLE},null,null,null,null,null);
    }

    //retrieve a single video
    public Cursor getVideo(long rowId) throws SQLException
    {
        Cursor mCursor = db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                KEY_VIDEO,KEY_TITLE},KEY_ROWID + "=" + rowId,null,null,null,null,null);
        if(mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //updates a video
    public boolean updateVideo(long rowId,String video,String title)
    {
        ContentValues cval = new ContentValues();
        cval.put(KEY_VIDEO, video);
        cval.put(KEY_TITLE, title);
        return db.update(DATABASE_TABLE, cval, KEY_ROWID + "=" + rowId,null) >0;
    }

}//end class DBAdapter












