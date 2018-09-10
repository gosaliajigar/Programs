package bigdata.algorithms;

/**
 * Source : https://www.youtube.com/watch?v=P8Kt6Abq_rM
 * 			https://www.youtube.com/watch?v=xJUwspSaR1E
 * 			http://www.cs.princeton.edu/~chazelle/courses/BIB/pagerank.htm
 * 			https://www.quora.com/What-is-the-function-of-the-damping-factor-in-PageRank
 * 
 * @author Jigar Gosalia
 *
 */
public class PageRank {
	/*
	 * 	A points to B, C		incoming(A)	= 1		outgoing(A) = 2
	 *  B points to D			incoming(B)	= 2		outgoing(B) = 1
	 *  C points to A, B, D		incoming(C)	= 2		outgoing(C) = 3
	 *  D points to C			incoming(D)	= 2		outgoing(D) = 1
	 *
	 *===================================================================================================
	 * 			I0					I1						I2						PageRank		Rank
	 *===================================================================================================
	 * A		1/4				C	(1/4)/3				C	(3/8)/3						1.5/12		1
	 * B		1/4				A;C (1/4)/2 + (1/4)/3	A;C (1/12)/2 + (3/8)/3			2/12		2
	 * C		1/4				A;D	(1/4)/2	+ (1/4)/1	A;D	(1/12)/2					4.5/12		4
	 * D		1/4				B;C (1/4)/1 + (1/4)/3	B;C (5/24)/1 + (3/8)/3			4/12		3
	 * 
	 * ============
	 * Conclusions:
	 * ============
	 * - Node C is most important web-site.
	 * - Node D is important as it is pointed by C.
	 * 
	 * NOTE : Sum of all ranks in any iteration = 1;
	 * 
	 * ========= 
	 * Formula :
	 * ========= 
	 * PageRank(A) = [Previous Iteration PageRank(incoming)]/outgoing(incoming)
	 * 
	 * In order to negate the effect of sinks, damping factor is added to formula.
	 * 
	 * ========= 
	 * Formula :
	 * ========= 
	 * PR(A) = (1-d) + d(PR(T1)/C(T1) + ... + PR(Tn)/C(Tn)) <br>
	 * <br>
	 * 		PR(A) 			PageRank of Page A (the one we want to work out) <br>
	 * 		d 				a dampening factor. Nominally this is set to 0.85 <br>
	 * 		PR(T1) 			PageRank(T1) pointing to Page A (in-bound or incoming web-site T1 to A in previous iteration) <br>
	 * 		C(T1) 			number of links off that page (# of out-bound or outgoing web-sites from T1) <br>
	 * 		PR(Tn)/C(Tn) 	means we do that for each page pointing to Page A <br>
	 * <br>
	 * <br>
	 * The dampening factor basically says that a page cannot vote another page to be as equally important as it is.
	 * This means that pages that are harder to get to in the web are less important
	 * NOTES:
	 * 
	 * d(... 	: All these fractions of votes are added together but, to stop the other pages having too much 
	 * 		influence, this total vote is “damped down” by multiplying it by 0.85 (the factor d)
	 * 
	 * (1 - d) 	: (1 – d) bit at the beginning is a bit of probability math magic so the "sum of all web pages 
	 * 		PageRanks will be one": it adds in the bit lost by the d(.... It also means that if a page has no 
	 * 		links to it (no back-links) even then it will still get a small PR of 0.15 (i.e. 1 – 0.85). 
	 * 		(Aside: the Google paper says "the sum of all pages" but they mean the "the normalized sum" – 
	 * 		otherwise known as "the average" to you and me.
	 * 
	 */
}
