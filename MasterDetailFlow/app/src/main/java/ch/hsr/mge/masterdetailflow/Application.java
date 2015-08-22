package ch.hsr.mge.masterdetailflow;

import ch.hsr.mge.masterdetailflow.domain.Notes;

public class Application extends android.app.Application {
    private Notes notes = new Notes();

    public Notes getNotes() {
        return notes;
    }
}
