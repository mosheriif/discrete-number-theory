import java.util.ArrayList;

import static java.lang.Math.*;

public class NumberTheory {
    public boolean isPrime(int num)
    {
        if (num <= 1)
        {
            return false;
        }
        boolean[] primes = new boolean[num + 1];
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < num + 1; i++)
        {
            primes[i] = true;
        }
        for (int i = 2; i < num + 1; i++)
        {
            if (primes[i])
            {
                for (int j = i + 1; j < num + 1; j++)
                {
                    if ( (j % i) == 0)
                    {
                        primes[j] = false;
                    }
                }
            }
        }
        return primes[num];
    }
    public ArrayList<Integer> primeFactors (int num)
    {
        ArrayList<Integer> factors = new ArrayList<>();
        if (isPrime(num))
        {
            factors.add(num);
            return factors;
        }
        if (num <= 1)
        {
            return null;
        }
        boolean[] primes = new boolean[num + 1];
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < num + 1; i++)
        {
            primes[i] = true;
        }
        for (int i = 2; i < num + 1; i++)
        {
            if (primes[i])
            {
                for (int j = i + 1; j < num + 1; j++)
                {
                    if ( (j % i) == 0)
                    {
                        primes[j] = false;
                    }
                }
            }
        }
        for (int i = 2; i < num + 1; i++)
        {
            if (primes[i])
            {
                if ( (num % i) == 0)
                {
                    num = num / i;
                    factors.add(i);
                }
            }
        }
        return factors;
    }
    public int[] euclidean (int a, int b)
    {
        int x = a;
        int y = b;
        while (y != 0)
        {
            int r = x % y;
            x = y;
            y = r;
        }
        int[] gcdlcm = new int[2];
        gcdlcm[0] = x;
        gcdlcm[1] = (a * b) / x;
        return gcdlcm;
    }

    public int[] factoriser (int a, int b)
    {
        ArrayList<Integer> factorsOfA = primeFactors(a);
        ArrayList<Integer> factorsOfB = primeFactors(b);
        int length = max( factorsOfA.get(factorsOfA.size() - 1) , factorsOfB.get(factorsOfB.size() - 1) );
        int[] multiplicityA = new int[length + 1];
        int[] multiplicityB = new int[length + 1];
        int x = a;
        int y = b;
        for (int i = 0; i < factorsOfA.size(); i++)
        {
            while ( (x % factorsOfA.get(i)) == 0)
            {
                x = x / factorsOfA.get(i);
                multiplicityA[factorsOfA.get(i)]++;
            }
        }
        for (int i = 0; i < factorsOfB.size(); i++)
        {
            while ( (y % factorsOfB.get(i)) == 0)
            {
                y = y / factorsOfB.get(i);
                multiplicityB[factorsOfB.get(i)]++;
            }
        }
        int gcd = 1;
        int lcm = 1;
        for (int i = 0; i < length + 1; i++)
        {
            if ( (multiplicityA[i] != 0) || (multiplicityB[i] != 0) )
            {
                gcd = gcd * (int) pow(i, min(multiplicityA[i], multiplicityB[i]));
                lcm = lcm * (int) pow(i, max(multiplicityA[i], multiplicityB[i]));
            }
        }
        int[] gcdlcm = new int[2];
        gcdlcm[0] = gcd;
        gcdlcm[1] = lcm;
        return gcdlcm;
    }
    public int chineseRemainder (int[] a, int[] m)
    {
        boolean pairwisePrime = true;
        for (int i = 0; i < m.length; i++)
        {
            for (int j = i + 1; j < m.length; j++)
            {
                int[] check = euclidean(m[i], m[j]);
                if (check[0] != 1)
                {
                    pairwisePrime = false;
                }
            }
        }
        if (!pairwisePrime)
        {
            return Integer.MIN_VALUE;
        }
        int[] n = new int[m.length];
        int N = 1;
        for (int i = 0; i < m.length; i++)
        {
            N = N * m[i];
        }
        for (int i = 0; i < m.length; i++)
        {
            n[i] = N / m[i];
        }
        int[] inverses = new int[m.length];
        for (int i = 0; i < m.length; i++)
        {
            int temp = n[i] % m[i];
            if (temp == 1)
            {
                inverses[i] = temp;
            }
            else
            {
                int temp2 = temp;
                while ((temp % m[i]) != 1)
                {
                    temp = temp + temp2;
                }
                inverses[i] = ( temp / temp2 );
            }
        }
        int result = 0;
        for (int i = 0; i < m.length; i++)
        {
            result = result + (a[i] * n[i] * inverses[i]);
        }
        result = result % N;
        return result;
    }
}
