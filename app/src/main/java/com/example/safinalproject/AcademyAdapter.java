package com.example.safinalproject;

import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AcademyAdapter extends RecyclerView.Adapter<AcademyAdapter.AcademyViewHolder> {

    private List<Academy> academyList;
    private List<Boolean> itemExpandedState;

    public AcademyAdapter(List<Academy> academyList) {
        this.academyList = academyList;
        itemExpandedState = new ArrayList<>();

        for (int i = 0; i < academyList.size(); i++) {
            itemExpandedState.add(false);
        }
    }

    @Override
    public AcademyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_academy, parent, false);
        return new AcademyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AcademyViewHolder holder, int position) {
        Academy academy = academyList.get(position);
        holder.tvCenterName.setText(academy.getCenterName());


        boolean isExpanded = itemExpandedState.get(position);
        holder.expandableSection.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.tvEmail.setText(academy.getEmail());
        holder.tvPhone.setText(academy.getPhone());
        holder.tvLocation.setText(academy.getLocation());
        holder.tvPlace.setText(academy.getPlace());


        holder.itemView.setOnClickListener(v -> {
            boolean newState = !itemExpandedState.get(position);
            itemExpandedState.set(position, newState);
            notifyItemChanged(position);
        });

        holder.btnFeedback.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), Review.class);
            holder.itemView.getContext().startActivity(intent);
        });

        holder.btnadmit.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), AdmitActivity.class);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return academyList.size();
    }

    public static class AcademyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCenterName, tvEmail, tvPhone, tvLocation, tvPlace;
        LinearLayout expandableSection;
        Button btnFeedback;
        Button btnadmit;
        public AcademyViewHolder(View itemView) {
            super(itemView);
            tvCenterName = itemView.findViewById(R.id.tv_center_name);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            tvLocation = itemView.findViewById(R.id.tv_location);
            tvPlace = itemView.findViewById(R.id.tv_place);
            expandableSection = itemView.findViewById(R.id.expandable_section);
            btnFeedback = itemView.findViewById(R.id.btn_feedback);
            btnadmit = itemView.findViewById(R.id.btn_admit);
        }
    }
}

