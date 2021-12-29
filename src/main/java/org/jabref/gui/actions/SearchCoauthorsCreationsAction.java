package org.jabref.gui.actions;

import org.jabref.gui.DialogService;
import org.jabref.gui.LibraryTab;
import org.jabref.model.entry.BibEntry;

public class SearchCoauthorsCreationsAction extends SearchInGlobalBarFromCurrentEntryInfo {

    public SearchCoauthorsCreationsAction(BibEntry entry,LibraryTab libraryTab, DialogService dialogService) {
        super(entry, libraryTab, dialogService);
    }

    @Override
    String getInfoToCreateQuery(BibEntry entry) {
        String[] coauthors = entry.getAuthorFieldDecomposed();
        String query = "";
        if(!coauthors[0].equalsIgnoreCase("")) {
            for (int i = 0; i < coauthors.length; i++) {
                query = query.concat(String.format("author = \"%s\"", coauthors[i]));
                if (i != coauthors.length - 1) {
                    query = query.concat(" or ");
                }
            }
        }
        return query;
    }

    @Override
    void showErrorMessage(DialogService dialogService) {
        dialogService.showErrorDialogAndWait("Author field is empty! Complete author info so you can use this button properly.");
    }
}
