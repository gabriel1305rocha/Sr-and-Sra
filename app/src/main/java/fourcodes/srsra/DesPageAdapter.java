package fourcodes.srsra;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DesPageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public DesPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragDesGeral tab1 = new FragDesGeral();
                return tab1;
            case 1:
                FragDesMensal tab2 = new FragDesMensal();
                return tab2;
            case 2:
                FragDesItem tab3 = new FragDesItem();
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

