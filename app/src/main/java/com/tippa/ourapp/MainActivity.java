package com.tippa.ourapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;

import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
  BottomNavigationView navigation;
  ScrollView validScrollView, invalidScrollView;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeViews();
    initializeListeners();
    loadMainPage(1);
  }

  private void initializeViews() {
    validScrollView = findViewById(R.id.validScrollView);
    invalidScrollView = findViewById(R.id.invalidScrollView);
    navigation = findViewById(R.id.navigation);
  }

  private void initializeListeners() {
    navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
          case R.id.validItems:
            loadMainPage(1);
            return true;
          case R.id.invalidItems:
            loadMainPage(0);
            return true;
        }
        return false;
      }
    });
  }

  private void loadMainPage(int eatables) {
    if (eatables == 0) {
      validScrollView.setVisibility(View.GONE);
      invalidScrollView.setVisibility(View.VISIBLE);
    } else {
      validScrollView.setVisibility(View.VISIBLE);
      invalidScrollView.setVisibility(View.GONE);
    }
  }

  /*private void loadMainPagesBAk(String s) {
    LayoutInflater inflater = getLayoutInflater();
    final View viewItems = inflater.inflate(R.layout.view_valid_item, null, false);
    ViewGroup main = (ViewGroup) findViewById(R.id.mainContent);
    main.removeAllViews();
    for (String item : items) {
      TextView itemNameTv = (TextView) viewItems.findViewById(R.id.itemTypeTextView);
      itemNameTv.setText(item);
      ImageView imageView = (ImageView) viewItems.findViewById(R.id.itemTypeImageView);
      imageView.setImageResource(R.drawable.valid_menu);
      ViewGroup main2 = (ViewGroup) findViewById(R.id.mainContent);
      main2.addView(viewItems, main2.getChildCount());
    }
  }*/
}
