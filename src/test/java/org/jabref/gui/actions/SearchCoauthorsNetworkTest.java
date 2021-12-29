package org.jabref.gui.actions;

import org.jabref.gui.DialogService;
import org.jabref.gui.LibraryTab;
import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchCoauthorsNetworkTest {
    private final LibraryTab libraryTab = mock(LibraryTab.class);
    List<BibEntry> entries = new ArrayList<>(); // Entry list to add in libraryTab

    @BeforeEach
    void setUp() {

        BibEntry e0 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "A A1 and B B1")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1109/PARC49193.2020.236624")
                .withField(StandardField.ISBN, "978-1-7281-6575-2")
                .withField(StandardField.JOURNALTITLE, "2020 International Conference on Power Electronics & IoT Applications in Renewable Energy and its Control (PARC)")
                .withField(StandardField.PAGES, "351--354")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Automatized Medical Chatbot (Medibot)")
                .withField(StandardField.KEYWORDS, "Human-machine interaction, Chatbot, Medical Chatbot, Natural Language Processing, Machine Learning, Bot")
                .withCitationKey("aha");

        BibEntry e1 = new BibEntry(StandardEntryType.Misc)
                .withField(StandardField.AUTHOR, "A A1 and B B1 and C C1")
                .withField(StandardField.TITLE, "A tale from the trenches")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1145/3377811.3380330")
                .withField(StandardField.SUBTITLE, "cognitive biases and software development")
                .withCitationKey("abc");

        BibEntry e2 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "A A1 and D D1")
                .withField(StandardField.DATE, "November 2020")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1109/MIC.2020.3037151")
                .withField(StandardField.ISSN, "1941-0131")
                .withField(StandardField.JOURNALTITLE, "IEEE Internet Computing")
                .withField(StandardField.PAGES, "1--1")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Chatbots as conversational healthcare services")
                .withField(StandardField.KEYWORDS, "Chatbot, Medical services, Internet, Data collection, Medical diagnostic imaging, Automation, Vocabulary")
                .withCitationKey("ehe");

        BibEntry e3 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "B B1 and E E1")
                .withField(StandardField.DATE, "November 2020")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1109/MIC.2020.3037151")
                .withField(StandardField.ISSN, "1941-0131")
                .withField(StandardField.JOURNALTITLE, "IEEE Internet Computing")
                .withField(StandardField.PAGES, "1--1")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Chatbots as conversational healthcare services")
                .withField(StandardField.KEYWORDS, "Chatbot, Medical services, Internet, Data collection, Medical diagnostic imaging, Automation, Vocabulary")
                .withCitationKey("uhu");

        BibEntry e4 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "Z Z1 and W W1")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1109/PARC49193.2020.236624")
                .withField(StandardField.ISBN, "978-1-7281-6575-2")
                .withField(StandardField.JOURNALTITLE, "2020 International Conference on Power Electronics & IoT Applications in Renewable Energy and its Control (PARC)")
                .withField(StandardField.PAGES, "351--354")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Automatized Medical Chatbot (Medibot)")
                .withField(StandardField.KEYWORDS, "Human-machine interaction, Chatbot, Medical Chatbot, Natural Language Processing, Machine Learning, Bot")
                .withCitationKey("ihi");

        BibEntry e5 = new BibEntry(StandardEntryType.Misc)
                .withField(StandardField.AUTHOR, "E E1")
                .withField(StandardField.TITLE, "A tale from the trenches")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1145/3377811.3380330")
                .withField(StandardField.SUBTITLE, "cognitive biases and software development")
                .withCitationKey("abc");

        BibEntry e6 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "F F1 and G G1 and A A1")
                .withField(StandardField.DATE, "November 2020")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1109/MIC.2020.3037151")
                .withField(StandardField.ISSN, "1941-0131")
                .withField(StandardField.JOURNALTITLE, "IEEE Internet Computing")
                .withField(StandardField.PAGES, "1--1")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Chatbots as conversational healthcare services")
                .withField(StandardField.KEYWORDS, "Chatbot, Medical services, Internet, Data collection, Medical diagnostic imaging, Automation, Vocabulary")
                .withCitationKey("lal");

        BibEntry e7 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "H H1 and I I1")
                .withField(StandardField.DATE, "November 2020")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1109/MIC.2020.3037151")
                .withField(StandardField.ISSN, "1941-0131")
                .withField(StandardField.JOURNALTITLE, "IEEE Internet Computing")
                .withField(StandardField.PAGES, "1--1")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Chatbots as conversational healthcare services")
                .withField(StandardField.KEYWORDS, "Chatbot, Medical services, Internet, Data collection, Medical diagnostic imaging, Automation, Vocabulary")
                .withCitationKey("es");

        BibEntry e8 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "J J1 and W W1")
                .withField(StandardField.DATE, "November 2020")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1109/MIC.2020.3037151")
                .withField(StandardField.ISSN, "1941-0131")
                .withField(StandardField.JOURNALTITLE, "IEEE Internet Computing")
                .withField(StandardField.PAGES, "1--1")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Chatbots as conversational healthcare services")
                .withField(StandardField.KEYWORDS, "Chatbot, Medical services, Internet, Data collection, Medical diagnostic imaging, Automation, Vocabulary")
                .withCitationKey("cgi");

        BibEntry e9 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "J J1 and H H1")
                .withField(StandardField.DATE, "November 2020")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1109/MIC.2020.3037151")
                .withField(StandardField.ISSN, "1941-0131")
                .withField(StandardField.JOURNALTITLE, "IEEE Internet Computing")
                .withField(StandardField.PAGES, "1--1")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Chatbots as conversational healthcare services")
                .withCitationKey("lap");

        BibEntry e10 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "")
                .withField(StandardField.DATE, "November 2020")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1109/MIC.2020.3037151")
                .withField(StandardField.ISSN, "1941-0131")
                .withField(StandardField.JOURNALTITLE, "IEEE Internet Computing")
                .withField(StandardField.PAGES, "1--1")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Chatbots as conversational healthcare services")
                .withCitationKey("bd");

        BibEntry e11 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "P P1 and Q Q1")
                .withField(StandardField.DATE, "November 2020")
                .withField(StandardField.YEAR, "2020")
                .withField(StandardField.DOI, "10.1109/MIC.2020.3037151")
                .withField(StandardField.ISSN, "1941-0131")
                .withField(StandardField.JOURNALTITLE, "IEEE Internet Computing")
                .withField(StandardField.PAGES, "1--1")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Chatbots as conversational healthcare services")
                .withCitationKey("bd");

        BibEntry e12 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "R R1")
                .withField(StandardField.DATE, "November 2021")
                .withField(StandardField.YEAR, "2021")
                .withField(StandardField.DOI, "10.1109/MIC.2020.3037151")
                .withField(StandardField.ISSN, "1941-0131")
                .withField(StandardField.JOURNALTITLE, "IEEE Internet Computing")
                .withField(StandardField.PAGES, "1--1")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Chatbots as conversational healthcare services")
                .withField(StandardField.KEYWORDS, "Chatbot, Medical services, Internet, Data collection, Medical diagnostic imaging, Automation, Vocabulary")
                .withCitationKey("rur");

        entries = List.of(e0,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12);

        when(libraryTab.getSelectedEntries()).thenReturn(entries);
        when(libraryTab.getDatabase()).thenReturn(new BibDatabase(entries));
        when(libraryTab.getEntries()).thenReturn(entries);
        libraryTab.insertEntries(entries);

    }

    private List execute(BibEntry entry){
        GetCoauthorsNetworkAction s = new GetCoauthorsNetworkAction(entry, libraryTab, mock(DialogService.class));
        s.execute();
        return s.getContent();
    }

    @Test
    void emptyAuthorField(){
        List graphContent = execute(entries.get(10));

        // Supposed correct answers
        assert(graphContent.isEmpty());
    }

    @Test
    void searchForNoConnections(){
        List graphContent = execute(entries.get(12));
        String s = "Coauthor: R R1\nConnections:\n";

        //Supposed correct answers
        assert(graphContent.get(0).equals(s));
    }


    @Test
    void searchForOneCoAuthorsNetWork(){
        List graphContent = execute(entries.get(5));
        String s = "Coauthor: E E1\nConnections:\nB B1(1)\n";
        
        // Supposed correct answers
        assert(graphContent.get(0).equals(s));

    }
    @Test
    void searchForTwoCoAuthorsNetWork(){
        List graphContent = execute(entries.get(8));
        String s = "Coauthor: J J1\nConnections:\nH H1(1)\nW W1(1)\n";

        // Supposed correct answers
        assert(graphContent.get(0).equals(s));
    }

    @Test
    void searchForMoreCoAuthorsNetwork(){
        List graphContent = execute(entries.get(1));


        String s = "Coauthor: A A1\nConnections:\nB B1(2)\nC C1(1)\nD D1(1)\nF F1(1)\nG G1(1)\n";
        String s2 = "Coauthor: B B1\nConnections:\nA A1(2)\nC C1(1)\nE E1(1)\n";
        String s3 = "Coauthor: C C1\nConnections:\nA A1(1)\nB B1(1)\n";


        // Supposed correct answers
        assert(graphContent.get(0).equals(s));
        assert(graphContent.get(1).equals(s2));
        assert(graphContent.get(2).equals(s3));
    }

}
