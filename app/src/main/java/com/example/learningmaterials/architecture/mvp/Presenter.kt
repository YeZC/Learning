package com.example.learningmaterials.architecture.mvp

import com.example.learningmaterials.architecture.mvc.DataCenter

class Presenter(private val iView: IView) {

    fun init(){
        val data = DataCenter.getData()
        iView.showData(data)
    }

    interface IView {
        fun showData(data: List<String>)
    }
}