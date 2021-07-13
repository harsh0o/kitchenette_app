package com.example.kitchenette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Adapter.CategoryAdapter;
import com.example.Adapter.PopularAdapter;
import com.example.Domain.CategoryDomain;
import com.example.Domain.FoodDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }


    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, CartListActivity.class));
            }
        });

        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, home.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Menu1", "food3", "this is menu 1 description ,here we write menu1 details and menu according to weeks.", 90.0));
        foodlist.add(new FoodDomain("Menu2", "food3", "this is menu 2 description ,here we write menu2 details and menu according to weeks. ", 80.0));
        foodlist.add(new FoodDomain("Menu3", "food3", " this is menu 3 description ,here we write menu3 details and menu according to weeks.", 85.0));

        adapter2 = new PopularAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("cat1","cat_1"));
        categoryList.add(new CategoryDomain("cat2","cat_2"));
        categoryList.add(new CategoryDomain("cat3","cat_3"));
        categoryList.add(new CategoryDomain("cat4","cat_4"));
        categoryList.add(new CategoryDomain("cat5","cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }

}