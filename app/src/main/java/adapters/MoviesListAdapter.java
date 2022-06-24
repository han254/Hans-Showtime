package adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.hanshowtime.MoviesActivity;
import com.moringaschool.hanshowtime.models.Result;

import java.util.List;

public class MoviesListAdapter extends RecyclerView.Adapter {
    public MoviesListAdapter(MoviesActivity moviesActivity, List<Result> results) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
