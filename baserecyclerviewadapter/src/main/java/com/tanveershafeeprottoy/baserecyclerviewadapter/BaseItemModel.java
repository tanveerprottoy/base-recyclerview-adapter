package com.tanveershafeeprottoy.baserecyclerviewadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

public abstract class BaseItemModel {
    // a unique id for use with DiffUtil
    @NonNull private String uniqueId;

    public BaseItemModel(@NonNull String id) {
        this.uniqueId = Objects.requireNonNull(id, "id must not be null");
    }

    @NonNull
    public String getUniqueId() {
        return uniqueId;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj == null) {
            return false;
        }
        // check BaseItemModel is a superclass of obj's Class
        if(!BaseItemModel.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        return uniqueId.equals(((BaseItemModel) obj).getUniqueId());
    }
}
