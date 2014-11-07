package com.creditcard4j;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public abstract class CreditCard4JTest {
    @Rule public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUpEnvironment() {
        CreditCard4J.resetConfig();
    }
}
