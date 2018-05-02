package com.example.mrrobot.customernew.parcelable;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;



@AutoValue
public abstract class Task implements Parcelable {

    public abstract long id();
    public abstract String summary();
    public abstract String description();

    public static Builder builder() {
        return new AutoValue_Task.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setId(long value);
        public abstract Builder setSummary(String value);
        public abstract Builder setDescription(String value);
        public abstract Task build();
    }
}
