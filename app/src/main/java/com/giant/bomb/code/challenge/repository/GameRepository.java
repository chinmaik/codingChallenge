package com.giant.bomb.code.challenge.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.giant.bomb.code.challenge.constants.AppConstant;
import com.giant.bomb.code.challenge.response.GameResponse;
import com.giant.bomb.code.challenge.retrofit.ApiRequest;
import com.giant.bomb.code.challenge.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameRepository {
    private static final String TAG = GameRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public GameRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<GameResponse> getGames(String query, String key) {
        final MutableLiveData<GameResponse> data = new MutableLiveData<>();
        apiRequest.getGames("name:"+query, AppConstant.FORMAT_KEY, key)
                .enqueue(new Callback<GameResponse>() {

                    @Override
                    public void onResponse(Call<GameResponse> call, Response<GameResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<GameResponse> call, Throwable t) {
                        data.postValue(null);
                    }
                });
        return data;
    }
}
