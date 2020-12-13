package com.nirmaljeffrey.navigationsample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.nirmaljeffrey.navigationsample.databinding.ListItemBinding;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder> {



    private List<Integer> numbers;


    private MainClickListener clickListener;

    public void setClickListener(MainClickListener clickListener) {
        this.clickListener = clickListener;
    }


    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
        notifyDataSetChanged();
    }

    public interface MainClickListener {
        void onNumberClick(Integer number);
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item,
                        parent, false);
        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
      holder.bind(numbers.get(position));
    }

    @Override
    public int getItemCount() {
        return numbers == null? 0 : numbers.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ListItemBinding binding;
        public MainViewHolder(@NonNull  ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(this);
        }

        private void bind(Integer number) {
            binding.setNumber(String.valueOf(number));
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            if (position != RecyclerView.NO_POSITION) {
                clickListener.onNumberClick(numbers.get(position));
            }
        }
    }


}
