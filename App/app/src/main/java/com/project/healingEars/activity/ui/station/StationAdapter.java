package com.project.healingEars.activity.ui.station;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.databinding.ItemStationBinding;
import com.project.healingEars.activity.ui.VmShareViewModel;
import com.project.healingEars.http.vo.StationListVO;

import java.util.ArrayList;
import java.util.List;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.ViewHolder> {

    private static final String TAG = "StationAdapter";

    private List<StationListVO> stationListVOS = new ArrayList<>();

    VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.bindItem(stationListVOS.get(position));
    }

    @Override
    public int getItemCount() {
        return stationListVOS.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //RecyclerItemBinding itemBinding;
        //
        //출처: https://kitesoft.tistory.com/115?category=549069 [안드로이드 앱 개발]
        ItemStationBinding binding;
        
        


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemStationBinding.bind(itemView);

        }

        public void bindItem(StationListVO stationListVO) {
            binding.setVmShareModel(VmShareViewModel);

        }
    }
}


