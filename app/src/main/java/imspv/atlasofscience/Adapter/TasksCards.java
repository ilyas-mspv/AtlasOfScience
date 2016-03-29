package imspv.atlasofscience.Adapter;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import imspv.atlasofscience.R;
import imspv.atlasofscience.dto.AtlasDTO;

public class TasksCards extends RecyclerView.Adapter<TasksCards.AtlasViewHolder> {

    private List<AtlasDTO> data;

    public TasksCards(List<AtlasDTO> data) {
        this.data = data;
    }

    @Override
    public AtlasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_item,parent,false);
        return new AtlasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AtlasViewHolder holder, int position) {

        holder.title.setText(data.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class AtlasViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView title;


        public AtlasViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);

        }
    }



}
