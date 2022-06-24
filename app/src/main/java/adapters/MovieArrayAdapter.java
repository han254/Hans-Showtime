package adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MovieArrayAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mMovies;
    private String[] mGenres;
    private String[] mRatings;
    private String[] mYears;
    private String[] mOverview;


    public MovieArrayAdapter(Context mContext, int resource) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mMovies = mMovies;
        this.mOverview = mOverview;

    }

    @Override
    public Object getItem(int position) {
        String movie = mMovies[position];
        String overview = mOverview[position];

        return String.format("\n" + movie + "\n" + "Genre:" + "\n" + overview);

    }

    @Override
    public int getCount() {
        return mMovies.length;
    }
}