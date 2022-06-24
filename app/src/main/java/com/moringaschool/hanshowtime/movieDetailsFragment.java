package com.moringaschool.hanshowtime;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.moringaschool.hanshowtime.models.MoviesDetailsResponse;
import com.moringaschool.hanshowtime.models.Result;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class movieDetailsFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.posterPathImageView)
    ImageView mPosterPathImageView;
    @BindView(R.id.movieNameTextView)
    TextView mMovieNameTextView;
    @BindView(R.id.genreTextView) TextView mGenreTextView;
    @BindView(R.id.ratingMovies) TextView mRatingMovies;
    @BindView(R.id.overviewTextView) TextView mOverviewTextView;
    @BindView(R.id.homepageTextView) TextView mHomepageTextView;

    private Result mMovies;
    private MoviesDetailsResponse mMovie;

    public movieDetailsFragment() {
        // Required empty public constructor

    }

    public static movieDetailsFragment newInstance(Result movie) {
        movieDetailsFragment movieDetailFragment = new movieDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", Parcels.wrap(movie));
        movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mMovies = Parcels.unwrap(getArguments().getParcelable("movie"));
        mMovie = Parcels.unwrap(getArguments().getParcelable("detail"));
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_movies_detail, container, false);
        ButterKnife.bind(this, view);


        Picasso.get().load("https://image.tmdb.org/t/p/w500"+mMovies. getPosterPath()).into(mPosterPathImageView);
        List<Integer> genres  = new ArrayList<>();


        mMovieNameTextView.setText(mMovies.getTitle());
        mGenreTextView.setText(android.text.TextUtils.join(", ", genres));
        mRatingMovies.setText(Double.toString(mMovies.getVoteAverage()) + "/10");
        mOverviewTextView.setText(mMovies.getOverview());


        mHomepageTextView.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        //new implicit intent called webIntent and provide it two arguments: The ACTION_VIEW activity, responsible for displaying data to the user,
        if (v == mHomepageTextView) {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.themoviedb.org/movie"));
            startActivity(intent);
        }


    }
}