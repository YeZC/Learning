package com.example.learningmaterials.设计模式.g_外观模式;

import com.example.learningmaterials.设计模式.g_外观模式.inverst.NationalDebt;
import com.example.learningmaterials.设计模式.g_外观模式.inverst.Realty;
import com.example.learningmaterials.设计模式.g_外观模式.inverst.Stock1;
import com.example.learningmaterials.设计模式.g_外观模式.inverst.Stock2;

public class Fund {

    private Stock1 stock1;
    private Stock2 stock2;
    private NationalDebt nationalDebt;
    private Realty realty;


    public Fund() {
        this.stock1 = new Stock1();
        this.stock2 = new Stock2();
        this.nationalDebt = new NationalDebt();
        this.realty = new Realty();
    }

    public void buy(){
        this.stock1.buy();
        this.stock2.buy();
        this.nationalDebt.buy();
        this.realty.buy();
    }

    public void sell() {
        this.stock1.sell();
        this.stock2.sell();
        this.nationalDebt.sell();
        this.realty.sell();
    }
}
