package fib;

public class Cache {
  private int[] cache = new int[100];
  public int fib(int n) {
    int value = cache[n];
    if(value > 0)    return value;
    value = proceed(n);
    cache[n] = value;
    return value;
  }
  public static void main(String[] args) {
    Fibonacci f = new Fibonacci();
    Cache c = new Cache();
    f.fib = c.fib;
    System.out.println("fib(40) = " + f.fib(40));
  }
}

