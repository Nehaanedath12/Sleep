package com.sangsolutions.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sangsolutions.sleep.Adapter.Factor;
import com.sangsolutions.sleep.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onResume() {
        super.onResume();
        viewData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.factor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FactorsActivity.class));
            }
        });

        viewData();

    }

    private void viewData() {
        List<Factor> mainList = new ArrayList<>(FactorSingleton.getInstance().getList());
        if(mainList.size()==1){
            binding.factorData.setText(mainList.get(0).getName());
        }else  if(mainList.size()>1){
            binding.factorData.setText(mainList.get(0).getName()+" +"+(mainList.size()-1));
        }

    }
}