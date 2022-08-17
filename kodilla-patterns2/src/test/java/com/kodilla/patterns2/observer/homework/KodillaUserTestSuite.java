package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KodillaUserTestSuite {

    @Test
    public void testUpdate() {
        // Given
        KodillaUser kodillaUser1 = new KodillaUser("Dominik Czarnecki");
        KodillaUser kodillaUser2 = new KodillaUser("Patrycja Nowak");
        KodillaUser kodillaUser3 = new KodillaUser("Cezary Kowalski");
        Mentor johnSmith = new Mentor("John Smith");
        Mentor ivoneEscobar= new Mentor("Ivone Escobar");
        Mentor jessiePinkman = new Mentor("Jessie Pinkman");
        kodillaUser1.registerObserver(johnSmith);
        kodillaUser2.registerObserver(ivoneEscobar);
        kodillaUser3.registerObserver(jessiePinkman);
        // When
        kodillaUser1.addTask("Task_1_1");
        kodillaUser2.addTask("Task_1_1");
        kodillaUser3.addTask("Task_21");
        kodillaUser1.addTask("Task_2_1");
        kodillaUser3.addTask("Task_22");
        // Then
        assertEquals(2, johnSmith.getUpdateCount());
        assertEquals(1, ivoneEscobar.getUpdateCount());
        assertEquals(2, jessiePinkman.getUpdateCount());
    }
}
