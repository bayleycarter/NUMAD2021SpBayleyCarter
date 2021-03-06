package edu.neu.madcourse.numad21sp_bayleycarter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {


    private final ArrayList<LinkName> listOfLinks;
    private ItemClickListener listener;
    //Context context;

    public ViewAdapter(ArrayList<LinkName> listOfLinks) {

        this.listOfLinks = listOfLinks;

    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        LinkName currentLink = listOfLinks.get(position);

        holder.linkName.setText(currentLink.getLinkName());
        holder.linkUrl.setText(currentLink.getLinkUrl());

    }

    @Override
    public int getItemCount() {
        return listOfLinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView linkName, linkUrl;

        public ViewHolder(@NonNull View itemView, ItemClickListener listener) {
            super(itemView);
            linkName = itemView.findViewById(R.id.link_name);
            linkUrl = itemView.findViewById(R.id.link_url);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}