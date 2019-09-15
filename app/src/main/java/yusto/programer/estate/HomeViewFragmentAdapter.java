package yusto.programer.estate;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeViewFragmentAdapter extends FragmentPagerAdapter {
private  final List<Fragment>listFragment=new ArrayList<>();
private  final List<String>listTitle=new ArrayList<>();
    public HomeViewFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return listFragment.get(i);
    }

    @Override
    public int getCount() {
        return listTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
    public  void AddFragment(Fragment fragment, String title){
     listFragment.add(fragment);
     listTitle.add(title);
    }
}
