package com.company;

import org.junit.*;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @Before
    public void setup(){
        account = new BankAccount("Tom", "Smith", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test..");
    }

    @Test
    public void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @Test
    public void withdraw_check() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() {
        double balance = account.withdraw(600.00, false);
            assertEquals(400.00, balance, 0);
    }

    @Test
    public void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {
        assertTrue("Here message will show if something went wrong", account.isChecking());
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After any test cases. Count = " + count++);
        System.out.println("Finish. Count = " + count);
    }

    @After
    public void teardown(){
        System.out.println("Count = " + count++);
    }
}