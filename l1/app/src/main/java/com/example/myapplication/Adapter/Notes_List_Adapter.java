package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Notes;
import com.example.myapplication.NotesClicListenet;
import com.example.myapplication.R;

import java.util.List;

public class Notes_List_Adapter extends RecyclerView.Adapter<NotesViewHolder>{

    Context context;
    List<Notes> list;

    NotesClicListenet listenet;

    public Notes_List_Adapter(Context context, List<Notes> list, NotesClicListenet listenet) {
        this.context = context;
        this.list = list;
        this.listenet = listenet;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.nodes_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

        holder.textView_title.setText(list.get(position).getTitle());
        holder.textView_title.setSelected(true);

        holder.textView_notes.setText(list.get(position).getNodes());

        holder.nodes_conteiner.setCardBackgroundColor(android.graphics.Color.rgb(176,196,222));
        holder.nodes_conteiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenet.onClick(list.get(holder.getAdapterPosition()));
            }
        });
        holder.nodes_conteiner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listenet.onLongClick(list.get(holder.getAdapterPosition()), holder.nodes_conteiner);
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList(List<Notes> filteredList){
        list = filteredList;
        notifyDataSetChanged();

    }
}

class NotesViewHolder extends RecyclerView.ViewHolder{

    CardView nodes_conteiner;
    TextView textView_title;

    TextView textView_notes;
    ImageView imageView_pin;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);

        nodes_conteiner = itemView.findViewById(R.id. nodes_conteiner);
        textView_title = itemView.findViewById(R.id. textView_title);
        textView_notes = itemView.findViewById(R.id. textView_notes);
        imageView_pin = itemView.findViewById(R.id. imageView_pin);
    }
}