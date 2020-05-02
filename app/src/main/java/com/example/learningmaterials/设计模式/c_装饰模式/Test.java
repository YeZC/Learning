package com.example.learningmaterials.设计模式.c_装饰模式;

import com.example.learningmaterials.设计模式.c_装饰模式.costume.BusinessSuit;
import com.example.learningmaterials.设计模式.c_装饰模式.costume.CasualPants;
import com.example.learningmaterials.设计模式.c_装饰模式.costume.CasualShoes;
import com.example.learningmaterials.设计模式.c_装饰模式.costume.LeatherShoes;
import com.example.learningmaterials.设计模式.c_装饰模式.costume.Necktie;
import com.example.learningmaterials.设计模式.c_装饰模式.costume.TShirt;

public class Test {

    public static void main(String[] args) {

        Person person = new Person("小明");

        TShirt tShirt = new TShirt();
        CasualPants casualPants = new CasualPants();
        CasualShoes casualShoes = new CasualShoes();
        BusinessSuit businessSuit = new BusinessSuit();
        Necktie necktie = new Necktie();
        LeatherShoes leatherShoes = new LeatherShoes();


        // 穿着一
        tShirt.wear(person);
        casualPants.wear(tShirt);
        casualShoes.wear(casualPants);
        System.out.println("穿着一:" + casualShoes.getInfo());

        // 穿着二
        businessSuit.wear(person);
        necktie.wear(businessSuit);
        leatherShoes.wear(necktie);
        System.out.println("穿着二:" + leatherShoes.getInfo());
    }
}
