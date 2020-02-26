package com.example.kritika_m.notetaking;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayNoteTest {

    @Rule
    public ActivityTestRule<DisplayNote> mActivityRule = new ActivityTestRule<>(DisplayNote.class);

    public DisplayNote displayNote;

    @Before
    public void setUp() throws Exception {
        displayNote = mActivityRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void displayList() {
        displayNote.displayList();
    }
}