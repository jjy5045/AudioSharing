package com.project.healingEars.activity.ui.station;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
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

    private List<StationListVO> stationListVO = new ArrayList<>();

    public StationAdapter(List<StationListVO> stationListVO) {
        this.stationListVO = stationListVO;
    }

    //VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station, parent, false);
        ViewHolder holder = new ViewHolder(itemView);;

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       ///holder.bindItem(stationListVO.get(position));
        holder.item_name.setText(stationListVO.get(position).stnName.toString());
    }

    public int getItemCount() {
        //return stationListVO.size();
        return (null != stationListVO ? stationListVO.size() : 0);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        //ItemStationBinding binding;
        protected TextView item_name;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item_name = (TextView) itemView.findViewById(R.id.item_name);
            /*
            binding = ItemStationBinding.bind(itemView);
            //binding.setLifecycleOwner(this);
            binding.setVmShareModel(binding.getVmShareModel());
             */

        }

        public void bindItem(StationListVO stationListVO) {
            //binding.setVmShareModel(VmShareViewModel);

        }
    }
}


