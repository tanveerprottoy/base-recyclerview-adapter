package com.tanveershafeeprottoy.baserecyclerviewadapter

open class BaseItemModelKotlin(var uniqueId: String) {

    override fun equals(other: Any?): Boolean {
        if(other == null) {
            return false
        }
        // check BaseItemModelKotlin is a superclass of other Class
        return if(other !is BaseItemModelKotlin) {
            false
        }
        else uniqueId == (other as BaseItemModel).uniqueId
    }

    override fun hashCode(): Int {
        return uniqueId.hashCode()
    }
}