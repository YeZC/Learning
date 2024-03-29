package com.example.learningmaterials.architecture.mvvm

class StringAttr {
    var value: String? = null
        set(value) {
            field = value
            onChangeListener?.onChange(value)
        }
    var onChangeListener: OnChangeListener? = null
    
    interface OnChangeListener {
        fun onChange(newValue: String?)
    }
}