package com.project.healingEars.activity.ui.station;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.databinding.ItemStationBinding;
import com.project.healingEars.activity.ui.VmShareViewModel;
import com.project.healingEars.http.vo.StationListVO;

import java.util.ArrayList;
import java.util.List;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.ViewHolder> {

    private static final String TAG = "StationAdapter";

    private static List<StationListVO> LstationListVO = new ArrayList<>();

    Context context;

    public StationAdapter(List<StationListVO> stationListVO) {
        this.LstationListVO = stationListVO;
    }

    //VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station, parent, false);
        ViewHolder holder = new ViewHolder(itemView);;
        context = parent.getContext();

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       ///holder.bindItem(stationListVO.get(position));
        holder.item_name.setText(LstationListVO.get(position).stnName.toString());
        holder.item_location.setText((LstationListVO.get(position).stnSido.toString()));

    }

    public int getItemCount() {
        //return stationListVO.size();
        return (null != LstationListVO ? LstationListVO.size() : 0);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        //ItemStationBinding binding;
        protected TextView item_name;
        protected TextView item_location;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item_name = (TextView) itemView.findViewById(R.id.item_name);
            this.item_location = (TextView) itemView.findViewById((R.id.item_location));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ?????? ????????? ???????????? ????????? ?????????
                    int currentPos = getAdapterPosition();
                    // ?????? ???????????? ????????? VO ????????? ??????
                    StationListVO stationListVO = LstationListVO.get(currentPos);

                    // navigation ??? ?????? ????????? ?????? ??????
                    StationFragmentDirections.ActionNavStationToNavStationInfo action = StationFragmentDirections.actionNavStationToNavStationInfo();
                    // ???????????? ?????? ????????? ??????????????? ???????????? ?????? ??????
                    action.setStnId(stationListVO.stnId);
                    // ???????????? ?????? navigation action ??????
                    Navigation.findNavController(view).navigate(action);

                    // ????????? ?????? ?????? ??????
                    // Navigation.findNavController(view).navigate(R.id.action_nav_station_to_nav_station_info);

                    //Toast.makeText(view.getContext(), stationListVO.stnId +"\n" + stationListVO.stnName +" ???", Toast.LENGTH_LONG).show();
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    return false;
                }
            });
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


