package com.shuchi.s20240323_shuchisinha_nycschools.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.shuchi.s20240323_shuchisinha_nycschools.pojo.SATScores;
import com.shuchi.s20240323_shuchisinha_nycschools.repository.SchoolRepository;

public class SATScoresViewModel extends AndroidViewModel {

    private SchoolRepository mRepository;

    public SATScoresViewModel(@NonNull Application application) {
        super(application);
        mRepository = SchoolRepository.getRepository(application.getApplicationContext());
    }

    public LiveData<SATScores> getScoresForSchool(String schoolDBN) { return mRepository.getSATScoresForSchool(schoolDBN);}

}
