package com.rrj.major_project_teachnook.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.rrj.major_project_teachnook.R;
import com.rrj.major_project_teachnook.adapter;
import com.rrj.major_project_teachnook.databinding.FragmentHomeBinding;
import com.rrj.major_project_teachnook.pojo;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ListView l;
    adapter a;
    ArrayList<pojo> al;

    public FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        l = view.findViewById(R.id.listview);
        al = new ArrayList<>();

        al.add(new pojo("PACK OF 4 JEANS","LEVI'S",R.drawable.landscape_1476310438_levis_501_stretch,"RS. 4000"));
        al.add(new pojo("XCLUZE 8.0","ADIDAS",R.drawable.__gb2761_7_adidas_ftwwht_pulblu_teconi_original_imagkyyypbnztg5y_jpeg,"RS. 7000"));
        al.add(new pojo("PROMON X9","NIKE",R.drawable.run_nike_running_shoes_1661870227,"RS. 6000"));
        al.add(new pojo("SERIES Z CLASSIC","GUCCI",R.drawable.images_5,"RS. 10000"));
        al.add(new pojo("LIMITED EDITION SNEAKERS","PUMA",R.drawable._33ffa3ff670c4140949cca7_puma_women_39_s_california_sneaker_jpg,"RS. 11000"));
        al.add(new pojo("FORMAL COMBO","PETER ENGLAND",R.drawable.peterengland1,"RS. 9000"));

        a = new adapter(al,getActivity());
        l.setAdapter(a);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}