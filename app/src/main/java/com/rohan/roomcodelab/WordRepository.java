package com.rohan.roomcodelab;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllwords;

    public WordRepository(Application application)
    {
        WordRoomDatabase db=WordRoomDatabase.getDatabase(application);
        this.mWordDao=db.mWordDao();
        mAllwords=mWordDao.display();
    }

    LiveData<List<Word>> display() {
        return mAllwords;
    }


    public void insert (Word word)
    {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao)
        {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
