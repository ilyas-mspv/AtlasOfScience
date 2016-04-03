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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import imspv.atlasofscience.Adapter.ProfileItems;
import imspv.atlasofscience.Constants.Titles;
import imspv.atlasofscience.R;
import imspv.atlasofscience.Settings;
import imspv.atlasofscience.mlibs.RecyclerView.ItemClickSupport;

public class Profile extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.tab_profile;
    private List<Titles> titlesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProfileItems mAdapter;
    private TextView titless;

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
                             final Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

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
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getContext().getApplicationContext(),Settings.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(getContext().getApplicationContext(),"clicked "+ position,Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        Toast.makeText(getContext().getApplicationContext(),"clicked"+ position,Toast.LENGTH_SHORT).show();
                        break;
                }
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