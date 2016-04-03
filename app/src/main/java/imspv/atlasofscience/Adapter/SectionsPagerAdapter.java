package imspv.atlasofscience.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

import imspv.atlasofscience.TabFragments.AbstractTabFragment;
import imspv.atlasofscience.TabFragments.Profile;
import imspv.atlasofscience.TabFragments.Tasks;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private Map<Integer,AbstractTabFragment> tabs;
    private Context context;


    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabMap(context);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }
    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, Tasks.newInstance(context));
        tabs.put(1, Profile.newInstance(context));
    }
}
