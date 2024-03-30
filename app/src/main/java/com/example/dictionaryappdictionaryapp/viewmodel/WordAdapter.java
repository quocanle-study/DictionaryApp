package com.example.dictionaryappdictionaryapp.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryappdictionaryapp.R;
import com.example.dictionaryappdictionaryapp.databinding.WordRowItemBinding;
import com.example.dictionaryappdictionaryapp.model.WordAndDefinition;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder>{
    private ArrayList<WordAndDefinition> wordAndDefinitions;
    private Context context;

    public WordAdapter(ArrayList<WordAndDefinition> wordAndDefinitions, Context context) {
        this.wordAndDefinitions = wordAndDefinitions;
        this.context = context;
    }

    public WordAdapter(ArrayList<WordAndDefinition> wordAndDefinitions) {
        this.wordAndDefinitions = wordAndDefinitions;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_row_item, parent, false);
        WordRowItemBinding binding = WordRowItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setWord(wordAndDefinitions.get(position));
    }

    @Override
    public int getItemCount() {
        return wordAndDefinitions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        WordRowItemBinding binding;
        public ViewHolder(WordRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        WordAndDefinition wordAndDefinition = wordAndDefinitions.get(position);
                        // do something
                    }
                }
            });
        }
    }
}
