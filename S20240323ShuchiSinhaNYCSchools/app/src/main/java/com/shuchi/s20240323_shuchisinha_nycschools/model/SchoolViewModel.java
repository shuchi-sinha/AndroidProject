package com.shuchi.s20240323_shuchisinha_nycschools.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.shuchi.s20240323_shuchisinha_nycschools.pojo.School;
import com.shuchi.s20240323_shuchisinha_nycschools.repository.SchoolRepository;

import java.util.List;

public class SchoolViewModel extends AndroidViewModel {

    private SchoolRepository mRepository;

    private final LiveData<List<School>> mAllSchools;

    public SchoolViewModel (Application application) {
        super(application);
        mRepository = SchoolRepository.getRepository(application.getApplicationContext());
        mAllSchools = mRepository.getAllSchools();
    }

    public LiveData<List<School>> getAllSchools() { return mAllSchools; }
    public LiveData<List<School>> getFilteredSchools(String searchString) { return mRepository.getFilteredSchools(searchString); }
    public void loadSchools() { mRepository.loadSchools(); }

}
