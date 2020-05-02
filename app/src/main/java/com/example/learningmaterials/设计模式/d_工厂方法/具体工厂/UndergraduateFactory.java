package com.example.learningmaterials.设计模式.d_工厂方法.具体工厂;

import com.example.learningmaterials.设计模式.d_工厂方法.ILeiFengFactory;
import com.example.learningmaterials.设计模式.d_工厂方法.LeiFeng;
import com.example.learningmaterials.设计模式.d_工厂方法.具体实现类.Undergraduate;

public class UndergraduateFactory implements ILeiFengFactory {
    @Override
    public LeiFeng createLeiFeng() {
        return new Undergraduate();
    }
}
