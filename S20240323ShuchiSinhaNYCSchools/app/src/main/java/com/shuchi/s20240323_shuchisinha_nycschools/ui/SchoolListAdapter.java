package com.shuchi.s20240323_shuchisinha_nycschools.ui;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.shuchi.s20240323_shuchisinha_nycschools.pojo.School;

public class SchoolListAdapter extends ListAdapter<School, SchoolSimpleViewHolder> {

    public SchoolListAdapter(@NonNull DiffUtil.ItemCallback<School> diffCallback) {
        super(diffCallback);
    }

    @Override
    public SchoolSimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return SchoolSimpleViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(SchoolSimpleViewHolder holder, int position) {
        School current = getItem(position);
        holder.bind(current);
    }

    public static class SchoolDiff extends DiffUtil.ItemCallback<School> {

        @Override
        public boolean areItemsTheSame(@NonNull School oldItem, @NonNull School newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull School oldItem, @NonNull School newItem) {
            return oldItem.getSchool_name().equals(newItem.getSchool_name());
        }
    }
}
