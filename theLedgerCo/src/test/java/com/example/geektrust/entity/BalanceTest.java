package com.example.geektrust.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {

    Balance balance;
    @BeforeEach
    void setUp() {
        balance = new Balance("IDIDI", "SHELLY",7654, 23);
    }

    @Test
    void getBankName() {
        assertEquals("IDIDI", balance.getBankName());
    }

    @Test
    void getEmiLeft() {
        assertEquals(23, balance.getEmiLeft());
    }

    @Test
    void getUserName() {
        assertEquals("SHELLY", balance.getUserName());
    }

    @Test
    void getAmountRepaid() {
        assertEquals(7654, balance.getAmountRepaid());
    }
}