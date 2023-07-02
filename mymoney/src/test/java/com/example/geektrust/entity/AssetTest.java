package com.example.geektrust.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssetTest {

    Asset equity ;
    @Test
    void setInitialWeightage() {
        equity.setInitialWeightage(40);
        assertEquals(40, equity.getInitialWeightage());
    }

    @Test
    void setInitialInvestment() {
        equity.setInitialInvestment(40000);
        assertEquals(40000, equity.getInitialInvestment());
    }


    @BeforeEach
    void setUp() {
         equity = new Asset(6000,60);
    }
}