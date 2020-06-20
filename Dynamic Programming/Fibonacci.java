class Fibonacci {

  public int CalculateFibonacci(int n) {
    if(n==0)
    return 0;
    else if(n==1)
    return 1;

    int curr=0,prev=1,prevPrev=0;
    for(int i=2;i<=n;i++) {
      curr=prev+prevPrev;
      prevPrev=prev;
      prev=curr;
    }

    return curr;
  }

  public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}
