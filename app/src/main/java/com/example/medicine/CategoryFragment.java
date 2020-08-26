package com.example.medicine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<DoctorsCategoryModel> list = new ArrayList<>();
    private DoctorsCategoryAdapter adapter;

    public CategoryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.doctorsCategoryRecylerID);

        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Cardiology"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Darmetology"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"ENT"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Gastroentarology"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"General Practitioner"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Neorology"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Obstetrics & Gynecology"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Oncology"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Opthalmology"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Orthopedics & Rheomatology"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Pediatrics"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Respiaratory Deseases"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Dentist"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Psychiatry"));
        list.add(new DoctorsCategoryModel(R.drawable.ic_test_pic,"Medicine Specialist"));

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),3));

        adapter = new DoctorsCategoryAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        return view;
    }
}