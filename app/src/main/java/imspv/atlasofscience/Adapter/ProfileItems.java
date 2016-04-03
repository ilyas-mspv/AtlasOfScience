package imspv.atlasofscience.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import imspv.atlasofscience.Constants.Titles;
import imspv.atlasofscience.R;

/**
 * Created by 1 on 03.04.2016.
 */
public class ProfileItems extends RecyclerView.Adapter<ProfileItems.ViewHolder> {

    private List<Titles> titlesList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView image;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            image = (ImageView)view.findViewById(R.id.image_title);


        }
    }

    public ProfileItems(List<Titles> titlesList) {
        this.titlesList = titlesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_titles_row, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Titles titles = titlesList.get(position);
        holder.title.setText(titles.getTitle());

    }

    @Override
    public int getItemCount() {
        return titlesList.size();
    }


}
