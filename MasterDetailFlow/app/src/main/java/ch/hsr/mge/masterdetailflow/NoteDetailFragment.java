package ch.hsr.mge.masterdetailflow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ch.hsr.mge.masterdetailflow.domain.Note;

public class NoteDetailFragment extends Fragment {

    public static final String ARG_ITEM = "note_to_show";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_note_detail, container, false);

        if (getArguments().containsKey(ARG_ITEM)) {
            Application app = (Application) getActivity().getApplication();
            Note note = app.getNotes().get(getArguments().getInt(ARG_ITEM));
            initTitleEditText(rootView, note);
            initContentEditText(rootView, note);
        }

        return rootView;
    }

    private void initContentEditText(View rootView, final Note note) {
        TextView contentEditText = (TextView) rootView.findViewById(R.id.noteContentEditText);
        contentEditText.setText(note.getContent());
        contentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                note.setContent(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initTitleEditText(View rootView, final Note note) {
        TextView titleEditText = (TextView) rootView.findViewById(R.id.noteTitleEditText);
        titleEditText.setText(note.getTitle());
        titleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                note.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
