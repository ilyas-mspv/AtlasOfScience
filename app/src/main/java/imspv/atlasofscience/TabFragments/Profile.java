package imspv.atlasofscience.TabFragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import imspv.atlasofscience.Adapter.ProfileItems;
import imspv.atlasofscience.R;
import imspv.atlasofscience.Settings;
import imspv.atlasofscience.TabFragments.profile.Titles;
import imspv.atlasofscience.recyclerview.ItemClickSupport;

public class Profile extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.tab_profile;
    private List<Titles> titlesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProfileItems mAdapter;
    private TextView titless;
    private RelativeLayout rl;
    public Profile() {
    }


    public static Profile newInstance(Context context) {
        Profile fragment = new Profile();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_Profile));
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        rl = (RelativeLayout) view.findViewById(R.id.myteac);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext().getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
            }
        });



        recyclerView = (RecyclerView) view.findViewById(R.id.profile_recycler);
        mAdapter = new ProfileItems(titlesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Titles titles = titlesList.get(position);
                Toast.makeText(getContext().getApplicationContext(), titles.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext().getApplicationContext(), Settings.class);
                startActivity(intent);

            }
        });



        titles();
        return view;
    }

    private void titles() {
        Titles titles = new Titles(context.getString(R.string.my_classm));
        titlesList.add(titles);

        titles = new Titles(context.getString(R.string.my_teachers));
        titlesList.add(titles);

        titles = new Titles(context.getString(R.string.Bank));
        titlesList.add(titles);

        titles = new Titles(context.getString(R.string.Settings));
        titlesList.add(titles);

        titles = new Titles(context.getString(R.string.about));
        titlesList.add(titles);

        titles = new Titles(context.getString(R.string.exit));
        titlesList.add(titles);

        mAdapter.notifyDataSetChanged();
    }


    public void setContext(Context context) {
        this.context = context;
    }

}