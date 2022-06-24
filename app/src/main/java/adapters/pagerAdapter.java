package adapters;

import android.support.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.hanshowtime.models.Result;
import com.moringaschool.hanshowtime.movieDetailsFragment;

import java.util.List;

public class pagerAdapter extends FragmentPagerAdapter {

    private List<Result> mMovies;
    public pagerAdapter(@NonNull FragmentManager fm, int behavior, List<Result> movies) {
        super(fm, behavior);
        mMovies = movies;
    }

    @Override
    public Fragment getItem(int position) {
        return movieDetailsFragment.newInstance(mMovies.get(position));
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public CharSequence getPageTitle(int position) { // updates the title that appears in the scrolling tabs at the top of the screen
        return mMovies.get(position).getTitle();
    }
}