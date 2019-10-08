package com.rohan.roomcodelab;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mWordRepository;
    LiveData<List<Word>> allWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRepository=new WordRepository(application);
        allWords=mWordRepository.display();
    }
    LiveData<List<Word>> getAllWords() { return allWords; }

    public void insert(Word word) { mWordRepository.insert(word); }
}
