package com.giant.bomb.code.challenge.view_model;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.giant.bomb.code.challenge.constants.AppConstant;
import com.giant.bomb.code.challenge.repository.GameRepository;
import com.giant.bomb.code.challenge.response.GameResponse;

public class GameViewModel extends AndroidViewModel {

    private GameRepository gameRepository;
    private LiveData<GameResponse> gameResponseLiveData;

    public GameViewModel(@NonNull Application application) {
        super(application);

        gameRepository = new GameRepository();
        this.gameResponseLiveData = gameRepository.getGames("", AppConstant.API_KEY);
    }

    public void getGamesUsingFilter(String filterKeyword) {
        this.gameResponseLiveData = gameRepository.getGames(filterKeyword, AppConstant.API_KEY);
    }

    public LiveData<GameResponse> getGameResponseLiveData() {
        return gameResponseLiveData;
    }
}
