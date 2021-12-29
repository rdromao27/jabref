package org.jabref.gui.actions;

import org.jabref.gui.DialogService;
import org.jabref.gui.LibraryTab;
import org.jabref.model.entry.BibEntry;

public abstract class SearchInGlobalBarFromCurrentEntryInfo extends SimpleCommand {
        private LibraryTab libraryTab;
        private BibEntry entry;
        private DialogService dialogService;
        private String query;

        public SearchInGlobalBarFromCurrentEntryInfo(BibEntry entry, LibraryTab libraryTab, DialogService dialogService) {
            this.entry=entry;
            this.libraryTab=libraryTab;
            this.dialogService = dialogService;
            this.query = "";
        }

        abstract String getInfoToCreateQuery(BibEntry entry);

        abstract void showErrorMessage(DialogService dialogService);

        void putQueryInGlobalSearchBar(String text) {
            libraryTab.changeGlobalSearchBarSearchField(text);
            libraryTab.performSearch();
        }
        @Override
        public void execute() {
            query = getInfoToCreateQuery(entry);
            if(query.equalsIgnoreCase("")) {
                showErrorMessage(dialogService);
            } else
            putQueryInGlobalSearchBar(query);
        }

        String getQuery (){
            return query;
        }
}
