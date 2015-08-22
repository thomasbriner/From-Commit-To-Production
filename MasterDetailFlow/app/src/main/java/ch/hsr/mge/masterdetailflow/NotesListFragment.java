package ch.hsr.mge.masterdetailflow;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NotesListFragment extends Fragment {

    private OnItemSelection itemSelectionCallback = null;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private NotesAdapter adapter;

    public interface OnItemSelection {
        void onItemSelected(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notes_list, container, false);


        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        Application app = (Application) getActivity().getApplication();

        adapter = new NotesAdapter(app.getNotes(), itemSelectionCallback);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof OnItemSelection)) {
            throw new IllegalStateException("Activity must implement OnItemSelection");
        }

        itemSelectionCallback = (OnItemSelection) activity;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.startObservingNotes();
    }

    @Override
    public void onPause() {
        super.onPause();
        adapter.stopObservingNotes();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        itemSelectionCallback = null;
    }
}
