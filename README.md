# Number Theory

This repository contains the solution for **Lab 3: Number Theory**, assigned for the (CSE214) Discrete Structures course. The assignment covers prime checking, prime factorization, GCD and LCM computation, and the Chinese Remainder Theorem.

## Project Structure

- `src/` - Contains Java source files for each function in the lab.

## Assignment Overview

### 1. Prime Number Checker

Implements a function to check if a positive integer is a prime using the **Sieve of Eratosthenes** algorithm.

### 2. Prime Factorization

Creates a function to compute the prime factors of a given integer.

### 3. GCD and LCM Computation

Provides functions to compute the **GCD** and **LCM** of two positive integers:
   - **Using the Euclidean algorithm** for GCD and the relationship between GCD and LCM for LCM.
   - **Using prime factorization** for both GCD and LCM calculations.

### 4. Chinese Remainder Theorem

Implements the **Chinese Remainder Theorem** for inputs (m1, m2, m3, ..., mn), which are pairwise relatively prime, and (a1, a2, ..., an) to find an integer `x` such that:
   - `x = a1 (mod m1)`
   - `x = a2 (mod m2)`
   - `x = an (mod mn)`

## Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/mosheriif/discrete-number-theory.git
   ```

2. Compile the Java files:
   ```bash
   javac src/*.java
   ```

3. Run the main class:
   ```bash
   java src.Main
   ```

## Assumptions

- The user can only enter positive integers.
- For the chinese remainder theorem implementation, the user is initially asked to state the number of congruences in the system, and the input is in the form `x = a1 (mod m1)`.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
