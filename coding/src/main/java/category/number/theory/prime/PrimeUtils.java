package category.number.theory.prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeUtils {
    public static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int eratosthenes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static int euler(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                primes.add(i);
            }

            for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                isPrimes[i * primes.get(j)] = false;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
