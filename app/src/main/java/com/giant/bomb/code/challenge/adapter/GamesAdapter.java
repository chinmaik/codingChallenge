package com.giant.bomb.code.challenge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.giant.bomb.code.challenge.R;
import com.giant.bomb.code.challenge.callbacks.OnRecyclerViewItemClickListener;
import com.giant.bomb.code.challenge.model.GameBean;

import java.util.ArrayList;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> {

    private Context context;
    ArrayList<GameBean> gameArrayList;
    private OnRecyclerViewItemClickListener listener;

    public GamesAdapter(Context context, ArrayList<GameBean> articleArrayList) {
        this.context = context;
        this.gameArrayList = articleArrayList;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_each_row_game, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        GameBean gameBean = gameArrayList.get(i);
        viewHolder.tvTitle.setText(gameBean.getName());
        Glide.with(context)
                .load(gameBean.getImageDataBean().getThumbUrl())
                .into(viewHolder.imgViewCover);
    }

    @Override
    public int getItemCount() {
        return gameArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgViewCover;
        private final TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgViewCover =  itemView.findViewById(R.id.imgViewCover);
            tvTitle =  itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onRecyclerViewItemClicked(getAdapterPosition());
                }
            });
        }
    }
}
