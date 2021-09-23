package com.example.learningmaterials.architecture.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learningmaterials.R
import kotlinx.android.synthetic.main.activity_mvc.*

class MvpActivity : AppCompatActivity(), Presenter.IView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)

        Presenter(this).init()
    }

    override fun showData(data: List<String>) {
        data1View.setText(data[0])
        data2View.setText(data[1])
    }

}