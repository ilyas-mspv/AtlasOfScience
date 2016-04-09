package imspv.atlasofscience.TabFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import imspv.atlasofscience.Activities.SolveTask;
import imspv.atlasofscience.Adapter.TasksCards;
import imspv.atlasofscience.R;
import imspv.atlasofscience.dto.AtlasDTO;
import imspv.atlasofscience.mlibs.RecyclerView.ItemClickSupport;

public  class Tasks extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.tab_tasks;

    public Tasks() {
    }


    public static Tasks newInstance(Context context) {
        Tasks fragment = new Tasks();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_Tasks));
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(LAYOUT, container, false);

        RecyclerView rv  =(RecyclerView) rootView.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new TasksCards(createMockListData()));
        ItemClickSupport.addTo(rv).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                switch (position) {
                    case 0:
                        Intent solve = new Intent(getContext().getApplicationContext(), SolveTask.class);
                        startActivity(solve);
                        break;
                    case 1:
                        break;
                }
            }
        });

        return rootView;
    }

    private List<AtlasDTO> createMockListData(){
        List<AtlasDTO> data = new ArrayList<>();
        data.add(new AtlasDTO("Physics", "Topic", "task", "Start"));
        data.add(new AtlasDTO("Algebra","Topic","task","Start"));
        return data;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}