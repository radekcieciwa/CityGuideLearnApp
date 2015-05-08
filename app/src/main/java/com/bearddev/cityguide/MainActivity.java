package com.bearddev.cityguide;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
    }

    @Override
    public void onBackPressed() {
        // we will remove last fragment from stack
        if (!removeFragmentIfStackIsLargerThanOne()) {
            // if we didn't remove anything that means we want to close application
            super.onBackPressed();
        }
    }

    public boolean removeFragmentIfStackIsLargerThanOne() {
        int stackEntryCount = getFragmentManager().getBackStackEntryCount();
        if (stackEntryCount > 0) {
            // get last back stack entry, to get last fragment on stack
            FragmentManager.BackStackEntry stackEntry = getFragmentManager().getBackStackEntryAt(stackEntryCount - 1);
            // find fragment in view with his name add with add method
            Fragment f = getFragmentManager().findFragmentByTag(stackEntry.getName());
            // remove fragment from stack
            getFragmentManager().beginTransaction().remove(f).commit();
            // remove information that fragment is in stack
            getFragmentManager().popBackStack();
            return true;
        }

        return false;
    }

    public void pushFragment(Fragment fragment, String name) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.a_main_content, fragment, name);
        ft.addToBackStack(name);
        ft.commit();
    }
}
