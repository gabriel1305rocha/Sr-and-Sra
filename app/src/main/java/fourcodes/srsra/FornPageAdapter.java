package fourcodes.srsra;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Felipe on 06/04/2017.
 */

public class FornPageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public FornPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragMeuFornecedor tab1 = new FragMeuFornecedor();
                return tab1;
            case 1:
                FragFornecedor tab2 = new FragFornecedor();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
