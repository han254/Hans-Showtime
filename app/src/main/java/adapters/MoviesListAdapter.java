package adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.hanshowtime.R;
import com.moringaschool.hanshowtime.models.Result;
import com.moringaschool.hanshowtime.movieDetailsActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MoviesViewHolder> {
    private List<Result> mMovies;
    private Context mContext;

    public MoviesListAdapter(Context context, List<Result> movies) {
        mContext = context;
        mMovies = movies;
    }


    @Override
    public MoviesListAdapter.MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        MoviesViewHolder viewHolder = new MoviesViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(MoviesListAdapter.MoviesViewHolder holder, int position) {
        holder.bindMovies(mMovies.get(position));



    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }


    public class MoviesViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.movieImageView)
        ImageView mMovieImageView;
        @BindView(R.id.titleMovie)
        TextView mTitleMovie;
        @BindView(R.id.releaseDateTextview)
        TextView mReleaseDateTextview;
        @BindView(R.id.ratingMovies)
        TextView mRating;

        private Context mContext;


        public MoviesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindMovies(Result result) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500"+result. getPosterPath()).into(mMovieImageView);
            mTitleMovie.setText(result.getTitle()) ;
            mReleaseDateTextview.setText(result.getReleaseDate());
            mRating.setText(Double.toString(result.getVoteAverage()) + "/10");

        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, movieDetailsActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("movies", Parcels.wrap(mMovies));
            mContext.startActivity(intent);
        }
    }
}
