package test.example.todolist;

import java.lang.String;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import java.util.ArrayList;
import android.database.Cursor;


public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Tasks.db";
    public static final String TABLE_NAME = "tasks_table";
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "Task_Name";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        //can use insert method for SQLite Database or sql statement below
        String createTableStatement = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT)";
        db.execSQL(createTableStatement);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableStatement = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(dropTableStatement);
        onCreate(db);
    }

    public boolean addTask(Task task) {
        //remember "" inside string around strings
        if(contains(task.getName()))
            return false;
        SQLiteDatabase db = this.getWritableDatabase();
        String insertStatement = "INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ") " +
                "VALUES " + "(\"" + task.getName() + "\")";
        db.execSQL(insertStatement);
        db.close();
        return true;
    }

    public void deleteTask(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String deleteStatement = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_ID + " = " + id;
        db.execSQL(deleteStatement);
        db.close();
    }

    public boolean updateTask(Task task) {
        //remember "" inside string around strings
        if(contains(task.getName()))
            return false;
        SQLiteDatabase db = this.getWritableDatabase();
        String updateStatement = "UPDATE " + TABLE_NAME + " SET " + COL_NAME + " = \"" +
                task.getName() + "\" WHERE " + COL_ID + " = " + task.getTaskID();
        db.execSQL(updateStatement);
        db.close();
        return true;
    }

    public boolean contains(String taskName) {
        //check if duplicate task name
        //remember "" inside string around strings
        boolean insideDB;
        SQLiteDatabase db = this.getReadableDatabase();
        String queryStatement = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_NAME +
                " = \"" + taskName + "\"";
        Cursor cursor = db.rawQuery(queryStatement, null);
        if(cursor.moveToFirst())
            insideDB = true;
        else
            insideDB = false;
        db.close();
        return insideDB;
    }

    public ArrayList<Task> getAll() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        SQLiteDatabase db = this.getReadableDatabase();
        String queryStatement = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(queryStatement, null);
        int id;
        String name;
        if(cursor.moveToFirst()) {
            do {
                id = cursor.getInt(0);
                name = cursor.getString(1);
                tasks.add(new Task(id, name));
            } while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tasks;
    }
}
