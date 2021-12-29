package org.jabref.gui.actions;

import org.jabref.gui.*;
import org.jabref.logic.search.DatabaseSearcher;
import org.jabref.logic.search.SearchQuery;
import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;
import org.jabref.model.search.rules.SearchRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static org.mockito.Mockito.*;

class SearchDocsFromSameYearActionTest {
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
                .withField(StandardField.DATE, "November 2021")
                .withField(StandardField.YEAR, "2021")
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
                .withField(StandardField.YEAR, "1998")
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
                .withField(StandardField.DATE, "November 2018")
                .withField(StandardField.YEAR, "2018")
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
                .withField(StandardField.DATE, "November")
                .withField(StandardField.YEAR, "")
                .withField(StandardField.DOI, "10.1109/MIC.2020.3037151")
                .withField(StandardField.ISSN, "1941-0131")
                .withField(StandardField.JOURNALTITLE, "IEEE Internet Computing")
                .withField(StandardField.PAGES, "1--1")
                .withField(StandardField.PUBLISHER, "IEEE")
                .withField(StandardField.TITLE, "Chatbots as conversational healthcare services")
                .withCitationKey("lap");

        BibEntry e10 = new BibEntry(StandardEntryType.Article)
                .withField(StandardField.AUTHOR, "Y Y1")
                .withField(StandardField.DATE, "November 2018")
                .withField(StandardField.YEAR, "2018")
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

        entries = List.of(e0,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11);

        when(libraryTab.getSelectedEntries()).thenReturn(entries);
        when(libraryTab.getDatabase()).thenReturn(new BibDatabase(entries));
        libraryTab.insertEntries(entries);

    }

    private String execute(BibEntry entry){
        SearchDocsFromSameYearAction s = new SearchDocsFromSameYearAction(entry, libraryTab, mock(DialogService.class));
        s.execute();
        return s.getQuery();
    }

    @Test
    void searchForYearWithJustOneDoc(){
        String query = execute(entries.get(4));

        // Returned entries from the search
        SearchQuery search = new SearchQuery(query, EnumSet.of(SearchRules.SearchFlags.CASE_SENSITIVE, SearchRules.SearchFlags.REGULAR_EXPRESSION));
        List<BibEntry> matches = new DatabaseSearcher(search, libraryTab.getDatabase()).getMatches();

        // Supposed correct answers
        assert(matches.size() == 1);
        assert(matches.contains(entries.get(4)));
    }

    @Test
    void searchForYearNonExistentInTheEntry(){
        String query = execute(entries.get(9));

        // Returned entries from the search
        SearchQuery search = new SearchQuery(query, EnumSet.of(SearchRules.SearchFlags.CASE_SENSITIVE, SearchRules.SearchFlags.REGULAR_EXPRESSION));
        List<BibEntry> matches = new DatabaseSearcher(search, libraryTab.getDatabase()).getMatches();

        // Supposed correct answers
        assert(matches.size() == 12);
    }

    @Test
    void searchForYearThatReturnTwoEntries(){
        String query = execute(entries.get(8));

        // Returned entries from the search
        SearchQuery search = new SearchQuery(query, EnumSet.of(SearchRules.SearchFlags.CASE_SENSITIVE, SearchRules.SearchFlags.REGULAR_EXPRESSION));
        List<BibEntry> matches = new DatabaseSearcher(search, libraryTab.getDatabase()).getMatches();

        // Supposed correct answers
        assert(matches.size() == 2);
        assert(matches.contains(entries.get(8)));
        assert(matches.contains(entries.get(10)));
    }

    @Test
    void searchForYearThatReturnMoreThanTwoEntries(){
        String query = execute(entries.get(0));

        // Returned entries from the search
        SearchQuery search = new SearchQuery(query, EnumSet.of(SearchRules.SearchFlags.CASE_SENSITIVE, SearchRules.SearchFlags.REGULAR_EXPRESSION));
        List<BibEntry> matches = new DatabaseSearcher(search, libraryTab.getDatabase()).getMatches();

        // Supposed correct answers
        assert(matches.size() == 7);
        assert(matches.contains(entries.get(0)));
        assert(matches.contains(entries.get(1)));
        assert(matches.contains(entries.get(2)));
        assert(matches.contains(entries.get(5)));
        assert(matches.contains(entries.get(6)));
        assert(matches.contains(entries.get(7)));
        assert(matches.contains(entries.get(11)));
    }

}
