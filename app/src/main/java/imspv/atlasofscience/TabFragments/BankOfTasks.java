package imspv.atlasofscience.TabFragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import imspv.atlasofscience.R;

public class BankOfTasks extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.tab_bank;

    public BankOfTasks() {
    }


    public static BankOfTasks newInstance(Context context) {
        BankOfTasks fragment = new BankOfTasks();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_Bank));
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(LAYOUT, container, false);

        return rootView;
    }


    public void setContext(Context context) {
        this.context = context;
    }

}