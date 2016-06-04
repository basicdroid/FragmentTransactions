package com.training.android.fragmenttransactions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        FragmentManager.OnBackStackChangedListener {

    private static final String TAG = "MainActivity";

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
        Button btnGoToPrev = (Button) findViewById(R.id.btnGoToPrev);

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

        btnGoToPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPrevious();
            }
        });

        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    private void addFragmentA() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, FragmentA.newInstance(), FragmentA.TAG);
        ft.addToBackStack("add");
        ft.commit();
    }

    private void removeFragmentAThenAddFragmentB() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        Fragment fragmentA = getSupportFragmentManager().findFragmentByTag(FragmentA.TAG);
        ft.remove(fragmentA);
        ft.add(R.id.fragment_container, FragmentB.newInstance(), FragmentB.TAG);
        ft.addToBackStack("removeAThenAddB");

        ft.commit();
    }

    private void replaceFragmentBWithFragmentA() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, FragmentA.newInstance(), FragmentA.TAG);
        ft.addToBackStack("replace");
        ft.commit();
    }

    private void removeFragmentB() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragmentB = getSupportFragmentManager().findFragmentByTag(FragmentB.TAG);
        ft.remove(fragmentB);
        ft.addToBackStack("removeB");
        ft.commit();
    }

    private void attachFragmentA() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.attach(FragmentA.newInstance());
        ft.addToBackStack("attach");
        ft.commit();
    }

    private void detachFragmentA() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragmentA = getSupportFragmentManager().findFragmentByTag(FragmentA.TAG);
        ft.detach(fragmentA);
        ft.addToBackStack("detach");
        ft.commit();
    }

    private void goToPrevious() {
        getSupportFragmentManager().popBackStack();
    }

    private void logBackStackEntry(FragmentManager.BackStackEntry entry) {
        if (entry != null) {
            Log.i(TAG, "BackStackEntry: " + entry.getName());
        } else {
            Log.i(TAG, "BackStackEntry: <NULL>");
        }
    }

    @Override
    public void onBackStackChanged() {
        Toast.makeText(this, "Backstack Changed", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "The following are the back stack entries");

        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
            logBackStackEntry(fm.getBackStackEntryAt(i));
        }
    }
}
