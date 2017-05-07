package rsa.encrypt.decrypt;

/**
 * 
 * Most basic and general explanation: cryptography is all about number theory,
 * and all integer numbers (except 0 and 1) are made up of primes, so you deal
 * with primes a lot in number theory. <br>
 * <br>
 * More specifically, some important cryptographic algorithms such as RSA
 * critically depend on the fact that prime factorization of large numbers takes
 * a long time. Basically you have a "public key" consisting of a product of two
 * large primes used to encrypt a message, and a "secret key" consisting of
 * those two primes used to decrypt the message. You can make the public key
 * public, and everyone can use it to encrypt messages to you, but only you know
 * the prime factors and can decrypt the messages. Everyone else would have to
 * factor the number, which takes too long to be practical, given the current
 * state of the art of number theory. <br>
 * <br>
 * The RSA encryption algorithm which is commonly used in secure commerce web
 * sites, is based on the fact that it is easy to take two (very large) prime
 * numbers and multiply them, while it is extremely hard to do the opposite -
 * meaning: take a very large number, given which it has only two prime factors,
 * and find them.<br>
 * <br>
 * text --public_key--> cipher text --private_key--> text<br>
 * <br>
 * public_key  = product of primes (shared)<br>
 * private_key = product of primes (primes known to user)<br>
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class MainClass {

}
