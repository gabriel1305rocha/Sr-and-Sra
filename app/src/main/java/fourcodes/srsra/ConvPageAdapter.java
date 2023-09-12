package fourcodes.srsra;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ConvPageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ConvPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragResumo tab1 = new FragResumo();
                return tab1;
            case 1:
                FragTodos tab2 = new FragTodos();
                return tab2;
            case 2:
                FragConvites tab3 = new FragConvites();
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