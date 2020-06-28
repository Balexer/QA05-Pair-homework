package tests;

import org.testng.annotations.Test;

public class AlexParallelTests {

    @Test
    public void test1() {
        System.out.println("1 Поток: " + Thread.currentThread().getId());

    }

    @Test
    public void test2() {
        System.out.println("2 Поток: " + Thread.currentThread().getId());
    }

    @Test
    public void test3() {
        System.out.println("3 Поток: " + Thread.currentThread().getId());
    }

    @Test
    public void test4() {
        System.out.println("4 Поток: " + Thread.currentThread().getId());
    }

    @Test
    public void test5() {
        System.out.println("5 Поток: " + Thread.currentThread().getId());
    }

    @Test
    public void test6() {
        System.out.println("6 Поток: " + Thread.currentThread().getId());
    }
}
