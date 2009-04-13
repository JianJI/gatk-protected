package org.broadinstitute.sting.playground.utils;

import org.broadinstitute.sting.playground.gatk.walkers.AlleleFrequencyWalker;
import java.util.Arrays;
import java.lang.Math;
import org.broadinstitute.sting.utils.GenomeLoc;

public class AlleleFrequencyEstimate {
    //AlleleFrequencyEstimate();
    public GenomeLoc location;
    public char ref;
    public char alt;
    public int N;
    public double qhat;
    public double qstar;
    public double lodVsRef;
    public double lodVsNextBest;
    public double pBest;
    public double pRef;
    public int depth;
    public String notes;

    GenomeLoc l;

    public AlleleFrequencyEstimate(GenomeLoc location, char ref, char alt, int N, double qhat, double qstar, double lodVsRef, double lodVsNextBest, double pBest, double pRef, int depth)
    {
        this.location = location;
        this.ref = ref;
        this.alt = alt;
        this.N = N;
        this.qhat = qhat;
        this.qstar = qstar;
        this.lodVsRef = lodVsRef;
        this.lodVsNextBest = lodVsNextBest;
        this.depth = depth;
        this.notes = "";
    }

    /** Return the most likely genotype. */
    public String genotype()
    {
        int alt_count = (int)(qstar * N);
        int ref_count = N-alt_count;
        char[] alleles = new char[N];
        int i;
        for (i = 0; i < ref_count; i++) { alleles[i] = ref; }
        for (; i < N; i++) { alleles[i] = alt; }
        Arrays.sort(alleles);
        return new String(alleles);
    }

    public double emperical_allele_frequency()
    {
        return (double)Math.round((double)qhat * (double)N) / (double)N;
    }

    public double emperical_allele_frequency(int N)
    {
        return (double)Math.round((double)qhat * (double)N) / (double)N;
    }

    public String asGFFString()
    {
        String s = "";
        s += String.format("%s\tCALLER\tVARIANT\t%s\t%s\t%f\t.\t.\t",
                               location.getContig(),
                               location.getStart(),
                               location.getStart(),
                               lodVsRef);
        s += String.format("REF %c\t;\t", ref);
        s += String.format("ALT %c\t;\t", alt);
        s += String.format("FREQ %f\t;\t;", qstar);
        s += String.format("DEPTH %d\t;\t", depth);
        s += String.format("LODvsREF %f\t;\t", lodVsRef);
        s += String.format("LODvsNEXTBEST %f\t;\t", lodVsNextBest);

        s += "\n";

        // add bases and quals.

        return s;
    }

    public String asTabularString() {
        return String.format("RESULT %s %c %c %f %f %f %f %d %s\n",
	                                        location,
	                                        ref,
	                                        alt,
	                                        qhat,
	                                        qstar,
                                            lodVsRef,
                                            lodVsNextBest,
	                                        depth, 
                                            notes);
    }

    public String toString() { return asTabularString(); }

    public String asString() {
        // Print out the called bases
        // Notes: switched from qhat to qstar because qhat doesn't work at n=1 (1 observed base) where having a single non-ref
        //        base has you calculate qstar = 0.0 and qhat = 0.49 and that leads to a genotype predicition of AG according
        //        to qhat, but AA according to qstar.  This needs to be further investigated to see whether we really want
        //        to use qstar, but make N (number of chormosomes) switch to n (number of reads at locus) for n=1
        long numNonrefBases = Math.round(qstar * N);
        long numRefBases = N - numNonrefBases;
        if (ref < alt) { // order bases alphabetically
            return AlleleFrequencyWalker.repeat(ref, numRefBases) + AlleleFrequencyWalker.repeat(alt, numNonrefBases);
        }else{
            return AlleleFrequencyWalker.repeat(alt, numNonrefBases) + AlleleFrequencyWalker.repeat(ref, numRefBases);
        }
    }
}
