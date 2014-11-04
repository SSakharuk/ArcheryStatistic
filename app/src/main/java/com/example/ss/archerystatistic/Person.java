package com.example.ss.archerystatistic;

import java.util.Date;

/**
 * Created by SS on 04.11.2014.
 */
public class Person {
    private int _id;
    private String _name;
    private int _age;
    private String _email;
    private String _dateCreated;
    private String _dateUpdated;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_age() {
        return _age;
    }

    public void set_age(int _age) {
        this._age = _age;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_dateCreated() {
        return _dateCreated;
    }

    public void set_dateCreated(String _dateCreated) {
        this._dateCreated = _dateCreated;
    }

    public String get_dateUpdated() {
        return _dateUpdated;
    }

    public void set_dateUpdated(String _dateUpdated) {
        this._dateUpdated = _dateUpdated;
    }

    @Override
    public String toString() {
        return _name;
    }
}
