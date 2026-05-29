package com.test.Service;

import com.test.model.DbData;
import com.test.repository.DbJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    private DbJPA dbJPA;

    public List<DbData>  getDbData(){

        return this.dbJPA.findAll();
    }

}
