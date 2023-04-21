package com.inventiveit.exception;

/*
  This class is the exception that would get triggered when the clients try to get a record that is not existing
*/
public class DreamCaseNotFoundException extends Exception{

    public DreamCaseNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}