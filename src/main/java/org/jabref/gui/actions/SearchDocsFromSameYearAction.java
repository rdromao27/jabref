package org.jabref.gui.actions;

import org.jabref.gui.DialogService;
import org.jabref.gui.LibraryTab;
import org.jabref.model.entry.BibEntry;




public class SearchDocsFromSameYearAction extends SearchInGlobalBarFromCurrentEntryInfo {

    public SearchDocsFromSameYearAction(BibEntry entry, LibraryTab libraryTab,DialogService dialogService) {
        super(entry,libraryTab, dialogService);
    }

    @Override
    String getInfoToCreateQuery(BibEntry entry) {
        String year = entry.getYearField();
        String query = "";
        if(!year.equalsIgnoreCase("")) {
            query = String.format("year = \"%s\"", year);
        }
        return query;
    }

    @Override
    void showErrorMessage(DialogService dialogService) {
        dialogService.showErrorDialogAndWait("Year field is empty! Complete year info so you can use this button properly.");
    }

}
