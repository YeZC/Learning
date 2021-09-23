package com.example.learningmaterials.architecture.mvvm

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log.println
import android.widget.EditText

class ViewBinder {
    companion object {
        fun bind(editText: EditText, stringAttr: StringAttr?){
            editText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if(!TextUtils.equals(stringAttr?.value, s)){
                        stringAttr?.value = s.toString()
                        println("表现数据通知内存")
                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })
            stringAttr?.onChangeListener = object : StringAttr.OnChangeListener {
                override fun onChange(newValue: String?) {
                    if(!TextUtils.equals(editText.text.toString(), newValue)){
                        editText.setText(newValue)
                        println("内存通知表现数据")
                    }
                }
            }
        }
    }
}