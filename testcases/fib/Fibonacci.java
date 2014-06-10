package fib;

public class Fibonacci {
  public int fib(int n) {
    if(n < 2)    return n;
    else    return fib(n-1) + fib(n-2);
  }
  public static void main(String[] args) {
    Fibonacci f = new Fibonacci();
    System.out.println("fib(40) = " + f.fib(40));
  }
}

