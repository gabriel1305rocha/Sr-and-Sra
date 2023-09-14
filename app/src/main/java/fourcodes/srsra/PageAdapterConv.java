package fourcodes.srsra;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapterConv extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapterConv(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragConvResumo tab1 = new FragConvResumo();
                return tab1;
            case 1:
                FragConvTodos tab2 = new FragConvTodos();
                return tab2;
            case 2:
                FragConvConvites tab3 = new FragConvConvites();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}