package ch.hsr.mge.masterdetailflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class NoteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle arguments = new Bundle();
        int positionToShow = getIntent().getIntExtra(NoteDetailFragment.ARG_ITEM, -1);
        arguments.putInt(NoteDetailFragment.ARG_ITEM, positionToShow);

        NoteDetailFragment fragment = new NoteDetailFragment();
        fragment.setArguments(arguments);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.noteDetailContainer, fragment)
                .commit();
    }
}
