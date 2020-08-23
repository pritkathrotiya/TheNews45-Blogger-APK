package com.pritkathrotiya.thenews45;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private Context context;
    private List<Item> items;

    public PostAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.post_list, parent, false);
        return new PostViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, final int position) {

        final Item item = items.get(position);
        holder.postTitle.setText(item.getTitle());

        final Document document = Jsoup.parse(item.getContent());
        holder.postDesc.setText(document.text());

        final Elements element = document.select("img");
        Glide.with(context).load(element.get(0).attr("src")).into(holder.postImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("postTitle", item.getTitle());
                intent.putExtra("postImage",element.get(0).attr("src"));
                intent.putExtra("postDesc", document.toString());
                intent.putExtra("postTag", item.getLabels().get(0));
                intent.putExtra("postTime",item.getPublished());
                intent.putExtra("postUrl",item.getUrl());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        ImageView postImage;
        TextView postTitle;
        TextView postDesc;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            postImage = (ImageView) itemView.findViewById(R.id.post_image);
            postTitle = (TextView) itemView.findViewById(R.id.post_title);
            postDesc = (TextView) itemView.findViewById(R.id.post_desc);
        }
    }
}
