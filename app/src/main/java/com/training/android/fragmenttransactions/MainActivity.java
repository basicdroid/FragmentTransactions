package com.training.android.fragmenttransactions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddA = (Button) findViewById(R.id.btnAddA);
        Button btnRemAAddB = (Button) findViewById(R.id.btnRemAAddB);
        Button btnReplaceBWithA = (Button) findViewById(R.id.btnReplaceBWithA);
        Button btnRemoveB = (Button) findViewById(R.id.btnRemoveB);
        Button btnAttachA = (Button) findViewById(R.id.btnAttachA);
        Button btnDetachA = (Button) findViewById(R.id.btnDetachA);

        // Set appropriate listener actions..
        btnAddA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragmentA();
            }
        });

        btnRemAAddB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragmentAThenAddFragmentB();
            }
        });

        btnReplaceBWithA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragmentBWithFragmentA();
            }
        });

        btnRemoveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragmentB();
            }
        });

        btnAttachA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attachFragmentA();
            }
        });

        btnDetachA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detachFragmentA();
            }
        });
    }

    private void addFragmentA() {
    }

    private void removeFragmentAThenAddFragmentB() {
    }

    private void replaceFragmentBWithFragmentA() {
    }

    private void removeFragmentB() {
    }

    private void attachFragmentA() {
    }

    private void detachFragmentA() {
    }
}
