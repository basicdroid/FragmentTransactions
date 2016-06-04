package com.training.android.fragmenttransactions;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentA extends Fragment {

    public static final String TAG = "Fragment_A";

    public FragmentA() {
        // Required empty public constructor
    }

    public static FragmentA newInstance() {
        return new FragmentA();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.w(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.w(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.w(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.w(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.w(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.w(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.w(TAG, "onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.w(TAG, "onSaveInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.w(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.w(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.w(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.w(TAG, "onDetach");
    }
}
