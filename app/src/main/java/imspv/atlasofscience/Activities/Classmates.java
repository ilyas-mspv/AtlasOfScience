package imspv.atlasofscience.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import imspv.atlasofscience.R;

public class Classmates extends AppCompatActivity {


    private static final int LAYOUT = R.layout.profile_activity_classmates;
    private ArrayAdapter<String> mAdapter;
    final String[] Classmates = new String[] {
            "User 1" ,
            "User 2",
            "User 3",
            "User 4",
            "User 5",
            "User 6",
            "User 7",
            "User 8",
            "User 9",
            "User 10",
            "User 11",
            "User 12",
            "User 13",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView classmates = (ListView) findViewById(R.id.classmates);


        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Classmates);
        classmates.setAdapter(mAdapter);


    }

}
