package com.example.ss.archerystatistic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by SS on 04.11.2014.
 */
public class ArcheryDataSource {
    private SQLiteDatabase database;
    private SQLDatabaseHelper  dbHelper;
    private String[] allColumns = { SQLDatabaseHelper.COLUMN_ID,
            SQLDatabaseHelper.COLUMN_NAME, SQLDatabaseHelper.COLUMN_AGE,
            SQLDatabaseHelper.COLUMN_EMAIL, SQLDatabaseHelper.COLUMN_DATE_CREATED,
            SQLDatabaseHelper.COLUMN_DATE_UPDATED};

    public ArcheryDataSource(Context context) {
        dbHelper = new SQLDatabaseHelper(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Person createPerson(String name){
        return createPerson(name, 10, "Empty", new Date(), new Date());
    }

    public Person createPerson(String name, int age, String email, Date dateCreated, Date dateUpdated)
    {
        //"yyyy-MM-dd HH:mm:ss";
        ContentValues values = new ContentValues();
        values.put(SQLDatabaseHelper.COLUMN_NAME, name);
        values.put(SQLDatabaseHelper.COLUMN_AGE, age);
        values.put(SQLDatabaseHelper.COLUMN_EMAIL, name);
        values.put(SQLDatabaseHelper.COLUMN_DATE_CREATED, dateCreated.toString());
        values.put(SQLDatabaseHelper.COLUMN_DATE_UPDATED, dateUpdated.toString());

        long insertId = database.insert(SQLDatabaseHelper.TABLE_PERSON, null, values);

        Cursor cursor = database.query(SQLDatabaseHelper.TABLE_PERSON, allColumns, SQLDatabaseHelper.COLUMN_ID + " = " + insertId, null,null,null,null);

        cursor.moveToFirst();
        Person newPerson = cursorToPerson(cursor);
        cursor.close();
        return newPerson;
    }

    public void deletePerson(Person person)
    {
        long id = person.get_id();
        System.out.println("Person deleted with id: " + id);
        database.delete(SQLDatabaseHelper.TABLE_PERSON, SQLDatabaseHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Person> getAllPersons() {
        List<Person> personsCollection = new ArrayList<Person>();

        Cursor cursor = database.query(SQLDatabaseHelper.TABLE_PERSON,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Person person = cursorToPerson(cursor);
            personsCollection.add(person);
            cursor.moveToNext();
        }

        cursor.close();
        return personsCollection;
    }


    private Person cursorToPerson(Cursor cursor) {
        Person person = new Person();

        person.set_id(cursor.getInt(0));
        person.set_name(cursor.getString(1));
        person.set_age(cursor.getInt(2));
        person.set_email(cursor.getString(3));
        person.set_dateCreated(cursor.getString(4));
        person.set_dateUpdated(cursor.getString(5));

        return person;
    }


}
