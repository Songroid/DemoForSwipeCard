package com.example.song.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import it.michelelacorte.swipeablecard.OptionView;
import it.michelelacorte.swipeablecard.SwipeableCardAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.fragment, new BlankFragment());
        fragmentTransaction.commit();

        rv = (RecyclerView) findViewById(R.id.rv);
        llm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(llm);

        List<OptionView> optionViews = new ArrayList<>();

        optionViews.add(new OptionView.Builder()
                .normalCard()
                .image(R.mipmap.ic_launcher)
                .title("TITLE")
                .colorTitle(R.color.colorPrimary).build());
        optionViews.add(new OptionView.Builder()
                .normalCard()
                .text("Text, a lot of Text, a lot of Text, a lot of Text, a lot of Text")
                .title("TITLE")
                .colorTitle(R.color.colorPrimary).build());

        //Set custom adapter.
        SwipeableCardAdapter adapter = new SwipeableCardAdapter(optionViews, getApplicationContext());
        rv.setAdapter(adapter);
    }
}
