package com.rrj.major_project_teachnook.ui.gallery;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rrj.major_project_teachnook.DBHelper;
import com.rrj.major_project_teachnook.DBHelper2;
import com.rrj.major_project_teachnook.Home_Page;
import com.rrj.major_project_teachnook.MainActivity;
import com.rrj.major_project_teachnook.R;
import com.rrj.major_project_teachnook.adapter;
import com.rrj.major_project_teachnook.adapter2;
import com.rrj.major_project_teachnook.databinding.FragmentGalleryBinding;
import com.rrj.major_project_teachnook.pojo;
import com.rrj.major_project_teachnook.ui.home.HomeFragment;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    ListView l2;
    adapter2 a2;
    ArrayList<pojo> al2;
    DBHelper2 db2 = null;
    Button b;

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db2 = new DBHelper2(getActivity());
        b = view.findViewById(R.id.button3);
        if(db2.getCount()==0){
            Toast.makeText(getActivity(), "           CART IS EMPTY \n PLEASE ADD SOME ITEMS", Toast.LENGTH_SHORT).show();
//            Intent r = new Intent(getActivity(), Home_Page.class);
//            startActivity(r);
            b.setVisibility(View.GONE);
        }
        else {
            String name = "", brand = "", price = "";
            int image = 0;

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "ORDER PLACED SUCCESSFULLY!!", Toast.LENGTH_LONG).show();
                    db2.deleteTable();
                    Toast.makeText(getActivity(), "NO ITEM IN YOUR CART", Toast.LENGTH_SHORT).show();
                }
            });
            l2 = view.findViewById(R.id.listview2);
            al2 = new ArrayList<>();
            Cursor c = db2.getCartData(name, brand, image, price);
            while (c.moveToNext()) {
                al2.add(new pojo(c.getString(0), c.getString(1), Integer.parseInt(c.getString(2)), c.getString(3)));
            }
            a2 = new adapter2(al2, getActivity());
            l2.setAdapter(a2);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}