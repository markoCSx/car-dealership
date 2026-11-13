package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {

    @Test
    void test_display() {
        UserInterface yo = new UserInterface();
        yo.display();
    }
}