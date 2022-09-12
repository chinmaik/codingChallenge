package com.giant.bomb.code.challenge.retrofit;


import com.giant.bomb.code.challenge.constants.AppConstant;
import com.giant.bomb.code.challenge.response.GameResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET(AppConstant.GAMES_URL)
    Call<GameResponse> getGames(
            @Query(AppConstant.FILTER_QUERY) String filterQuery,
            @Query(AppConstant.FORMAT_QUERY) String formatQuery,
            @Query(AppConstant.API_KEY_QUERY) String apiKey
    );
}
