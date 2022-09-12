package com.giant.bomb.code.challenge.response;

import com.giant.bomb.code.challenge.model.GameBean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GameResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("results")
    @Expose
    private List<GameBean> gameBeanList = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<GameBean> getGameBeanList() {
        return gameBeanList;
    }

    public void setGameBeanList(List<GameBean> gameBeanList) {
        this.gameBeanList = gameBeanList;
    }
}
