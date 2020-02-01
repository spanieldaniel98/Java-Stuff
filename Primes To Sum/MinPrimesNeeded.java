//Need to credit code I didn't write!!

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import com.google.common.collect.Sets;

public class MinPrimesNeeded {
	public static void main(String[] args) {
		
		int X = 20; 
		
		List<Integer> primesUpTo1000 = primeNumbersBruteForce(1000);
		Set<Integer> primeSet = new HashSet<Integer>();
		for(int prime : primesUpTo1000) {
			primeSet.add(prime);
		}
		Set<Set<Integer>> primePowerSet = Sets.powerSet(primeSet);
		
		for(Set<Integer> set : primePowerSet) {
			int setTotal = 0;
			for(int i : set)
				setTotal += i;
			if(setTotal == X) {
				System.out.println("Number of primes <= 1000 required to summate to " + X + " = " + set.size());
				break;
			}
		}
		System.out.println("Not possible to generate " + X + "as a summation of primes <= 1000");
	}
	
	public static List<Integer> primeNumbersBruteForce(int n) {
	    List<Integer> primeNumbers = new LinkedList<>();
	    for (int i = 2; i <= n; i++) {
	        if (isPrimeBruteForce(i))
	            primeNumbers.add(i);
	    }
	    return primeNumbers;
	}
	
	public static boolean isPrimeBruteForce(int number) {
	    for (int i = 2; i < number; i++) {
	        if (number % i == 0)
	            return false;
	    }
	    return true;
	}
}