package com.sangsolutions.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.sangsolutions.sleep.Adapter.Factor;
import com.sangsolutions.sleep.Adapter.FactorAdapter;
import com.sangsolutions.sleep.databinding.ActivityFactorsBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FactorsActivity extends AppCompatActivity {
    ActivityFactorsBinding binding;

    List<Factor> list;
    FactorAdapter adapter;
    boolean selectionActive=false;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFactorsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        list=new ArrayList<>();
        adapter=new FactorAdapter(this,list);
        binding.rv.setLayoutManager(new LinearLayoutManager(this));
        binding.rv.setAdapter(adapter);

        list.add( new Factor("Alchohol",1));
        list.add( new Factor("Caffine",2));
        list.add( new Factor("Smoking",3));
        list.add( new Factor("Pain",4));
        list.add( new Factor("WorkOut",5));

        adapter.notifyDataSetChanged();

        if(FactorSingleton.getInstance().getList().size()>0) {
            selectionActive = true;
            List<Factor> mainList = FactorSingleton.getInstance().getList();
            for (int i = 0; i < mainList.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j).getId()==mainList.get(i).getId()){
                        if(mainList.get(i).isbSelected()){
                            list.get(j).setbSelected(true);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }

        binding.doneB.setOnClickListener(view1 -> {
            @SuppressLint({"NewApi", "LocalSuppress"})
            List<Factor> matchesBody= list.stream()
                    .filter(p -> p.isbSelected()).collect(Collectors.toList());
            List<Factor>mainList=new ArrayList<>();
            for (int i=0;i<matchesBody.size();i++){
                mainList.add(new Factor(matchesBody.get(i).getName() ,matchesBody.get(i).getId(),matchesBody.get(i).isbSelected()  ));
                if (i + 1 == matchesBody.size()) {
                        FactorSingleton.getInstance().setList(mainList);
                        finish();
                    }
            }
            if(matchesBody.size()==0){
                Toast.makeText(FactorsActivity.this, getString(R.string.select_factors), Toast.LENGTH_SHORT).show();
            }
        });



    }
}