package org.jabref.gui.actions;

import org.jabref.gui.DialogService;
import org.jabref.gui.LibraryTab;
import org.jabref.model.entry.BibEntry;

import java.util.*;

public class GetCoauthorsNetworkAction extends SimpleCommand {

    private LibraryTab libraryTab;
    private BibEntry entry;
    private DialogService dialogService;

    //this variable is just implemented for testing (SearchCoAuthorsNetworkTest)
    private List<String> graphContent;

    public GetCoauthorsNetworkAction(BibEntry entry, LibraryTab libraryTab, DialogService dialogService) {
        this.entry = entry;
        this.libraryTab = libraryTab;
        this.dialogService = dialogService;
        this.graphContent = new ArrayList<String>();
    }

    private void addConnections(String coauthor, List<String> possibleConnections, TreeMap<String, TreeMap<String, Integer>> coauthorsNetwork) {
        if (possibleConnections.contains(coauthor)) {
            TreeMap<String, Integer> connectionsOfCoauthor = coauthorsNetwork.get(coauthor);
            for (String possibleConnection : possibleConnections) {
                if (!possibleConnection.equalsIgnoreCase(coauthor)) {
                    Integer value = connectionsOfCoauthor.get(possibleConnection);
                    if (value == null) {
                        connectionsOfCoauthor.put(possibleConnection, 1);
                    } else {
                        connectionsOfCoauthor.put(possibleConnection, ++value);
                    }
                }
            }
        }
    }

    private void showErrorMessage() {
        dialogService.showErrorDialogAndWait("Author field is empty! Complete author info so you can use this button properly.");
    }

    @Override
    public void execute() {
        String[] coauthors = entry.getAuthorFieldDecomposed();
        if (coauthors[0].equalsIgnoreCase("")) {
            showErrorMessage();
        } else {
            List<BibEntry> entries = libraryTab.getEntries();
            TreeMap<String, TreeMap<String, Integer>> coauthorsNetwork = new TreeMap<>();

            for (String coauthor : coauthors) {
                coauthorsNetwork.put(coauthor, new TreeMap<String, Integer>());
            }

            for (BibEntry entry : entries) {
                String[] coauthorsOfEntry = entry.getAuthorFieldDecomposed();
                List<String> coauthorsOfEntryAsList = Arrays.asList(coauthorsOfEntry);
                if (!coauthorsOfEntry[0].equalsIgnoreCase("")) {
                    for (String coauthor : coauthors) {
                        addConnections(coauthor, coauthorsOfEntryAsList, coauthorsNetwork);
                    }
                }
            }

            int i = 0;
            for (Map.Entry<String, TreeMap<String, Integer>> entry : coauthorsNetwork.entrySet()) {
                graphContent.add(i,"");
                graphContent.add(i, graphContent.get(i).concat(String.format("Coauthor: %s\n", entry.getKey())));
                graphContent.add(i, graphContent.get(i).concat("Connections:\n"));
                SortedMap<String, Integer> map = entry.getValue();
                for (Map.Entry<String, Integer> e : map.entrySet()) {
                    graphContent.add(i,graphContent.get(i).concat(String.format("%s(%d)\n", e.getKey(), e.getValue())));
                }
                dialogService.showInformationDialogAndWait("Coauthors Network", graphContent.get(i));
                i++;
            }
        }
    }

    List<String> getContent() {
        return graphContent;
    }

}
