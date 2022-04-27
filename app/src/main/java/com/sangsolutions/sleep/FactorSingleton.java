package com.sangsolutions.sleep;

import com.sangsolutions.sleep.Adapter.Factor;

import java.util.ArrayList;
import java.util.List;

public class FactorSingleton {
    private static FactorSingleton factorSingleton;
    public List<Factor> list = new ArrayList<>();

    private FactorSingleton(){}

    public static FactorSingleton getInstance(){
        if(factorSingleton ==null){
            factorSingleton = new FactorSingleton();
        }
        return factorSingleton;
    }

    public List<Factor> getList(){return list;}
    public void setList(List<Factor> list){
        this.list = list;
    }
    public void clearList(){list.clear();}

}
