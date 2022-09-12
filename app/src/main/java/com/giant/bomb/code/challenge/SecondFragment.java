package com.giant.bomb.code.challenge;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.giant.bomb.code.challenge.constants.AppConstant;
import com.giant.bomb.code.challenge.databinding.FragmentSecondBinding;
import com.giant.bomb.code.challenge.model.GameBean;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private String title;
    private GameBean gameBean;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        gameBean = bundle.getParcelable(AppConstant.GAMES_URL);
        title = gameBean.getName();

        if(!TextUtils.isEmpty(gameBean.getDescription())){
            binding.textviewDescription.setText(Html.fromHtml(gameBean.getDescription()));
        }


        Glide.with(getActivity())
                .load(gameBean.getImageDataBean().getOriginalUrl())
                .into(binding.gameIv);

        binding.buttonSecond.setOnClickListener(view1 -> NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_SecondFragment_to_FirstFragment));
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(title);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}