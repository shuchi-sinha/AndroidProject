package com.shuchi.s20240323_shuchisinha_nycschools.database;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.shuchi.s20240323_shuchisinha_nycschools.pojo.SATScores;

import java.util.List;

@Dao
public interface SATScoresDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<SATScores> scores);

    @Query("DELETE FROM sat_table")
    void deleteAll();

    @Transaction
    @Query("SELECT * FROM sat_table where dbn = :schoolDBN")
    LiveData<SATScores> getScore(String schoolDBN);

    @VisibleForTesting
    @Transaction
    @Query("SELECT * FROM sat_table  ORDER BY school_name ASC")
    LiveData<List<SATScores>> getAllScores();
}
