package com.giant.bomb.code.challenge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.giant.bomb.code.challenge.adapter.GamesAdapter;
import com.giant.bomb.code.challenge.callbacks.OnRecyclerViewItemClickListener;
import com.giant.bomb.code.challenge.constants.AppConstant;
import com.giant.bomb.code.challenge.databinding.FragmentFirstBinding;
import com.giant.bomb.code.challenge.model.GameBean;
import com.giant.bomb.code.challenge.view_model.GameViewModel;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    GameViewModel gameViewModel;
    private GamesAdapter adapter;
    private ArrayList<GameBean> gameBeanArrayList = new ArrayList<>();


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
        getGamesData();
        binding.searchGames.setOnClickListener(view1 -> {

            gameBeanArrayList.clear();
            binding.progressCircular.setVisibility(View.VISIBLE);
            gameViewModel.getGamesUsingFilter(binding.searchEt.getText().toString());
            renderData();
        });
    }

    private void init() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);

        // adapter
        adapter = new GamesAdapter(getActivity(), gameBeanArrayList);
        binding.recyclerView.setAdapter(adapter);

        OnRecyclerViewItemClickListener onRecyclerViewItemClickListener = new OnRecyclerViewItemClickListener() {
            @Override
            public void onRecyclerViewItemClicked(int position) {

                Bundle bundle = new Bundle();
                bundle.putParcelable(AppConstant.GAMES_URL, gameBeanArrayList.get(position));
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);

            }
        };
        adapter.setOnItemClickListener(onRecyclerViewItemClickListener);
    }


    /**
     * get movies articles from news api
     *
     * @param @null
     */
    private void getGamesData() {
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        renderData();
    }

    private void renderData() {
        gameViewModel.getGameResponseLiveData().observe(getActivity(), gameResponse -> {
            if (gameResponse != null) {

                binding.progressCircular.setVisibility(View.GONE);
                List<GameBean> responseGameBeanList = gameResponse.getGameBeanList();

                gameBeanArrayList.clear();
                gameBeanArrayList.addAll(responseGameBeanList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}