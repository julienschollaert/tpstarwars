package com.julientp.jee;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class Request {
    private static List<film> films = new ArrayList<>();

    public List<film> getAll(){
        return films;
    }

}
