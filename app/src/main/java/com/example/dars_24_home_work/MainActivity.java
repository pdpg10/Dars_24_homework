package com.example.dars_24_home_work;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity
        extends AppCompatActivity
        implements View.OnClickListener {
    private int counter;

    public static void main(String[] args) {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        System.out.println(2/0);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add) {
            counter++;
            NumberFragment fragment = NumberFragment.create(counter + "");
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();
        } else if (v.getId() == R.id.btn_clear) {
            counter = 0;
            getSupportFragmentManager()
                    .popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

    }
}
