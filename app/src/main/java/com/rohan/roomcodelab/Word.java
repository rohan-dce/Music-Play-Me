package com.rohan.roomcodelab;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String Word;

    public Word(String Word){this.Word=Word;}

    @NonNull
    public String getWord() {
        return Word;
    }
}
