package com.example.pictopocketiv;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.pictopocketiv.search.PictoSearchFragment;

public class PictoSearchActivity extends AppCompatActivity {


    /** ACTIVITY STATE ENUM **/
    private enum ActivityState {
        WAITING_FOR_INPUT,
        SEARCHING,
        SHOWING_RESULT;
    }


    /** ATTRS **/
    private ActivityState mState = ActivityState.WAITING_FOR_INPUT;

    private FragmentManager mFramesManager;


    /** LIFECYCLE **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picto_search);
        initUI();
    }


    /** UI **/
    private void initUI() {
        setWidgets();
        setFrames();
    }

    private void setWidgets() {
        FrameLayout mFrameLayout = (FrameLayout) findViewById(R.id.search_fragment_container);
        mFramesManager = getSupportFragmentManager();

        //mActionBar = getSupportActionBar();
        //mActionBar.hide();
    }

    private void setFrames() {
        PictoSearchFragment mSearchFragment = PictoSearchFragment.newInstance(this);
        FragmentTransaction ft = mFramesManager.beginTransaction();
        ft.replace(R.id.search_fragment_container, mSearchFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}