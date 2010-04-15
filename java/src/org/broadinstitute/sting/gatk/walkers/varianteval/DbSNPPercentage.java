package org.broadinstitute.sting.gatk.walkers.varianteval;

import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.*;
import org.broadinstitute.sting.gatk.contexts.variantcontext.VariantContext;
import org.broadinstitute.sting.gatk.contexts.variantcontext.Allele;
import org.broadinstitute.sting.playground.utils.report.tags.Analysis;
import org.broadinstitute.sting.playground.utils.report.tags.DataPoint;

/**
 * The Broad Institute
 * SOFTWARE COPYRIGHT NOTICE AGREEMENT
 * This software and its documentation are copyright 2009 by the
 * Broad Institute/Massachusetts Institute of Technology. All rights are reserved.
 * <p/>
 * This software is supplied without any warranty or guaranteed support whatsoever. Neither
 * the Broad Institute nor MIT can be responsible for its use, misuse, or functionality.
 */
@Analysis(name = "DbSNP Overlap", description = "the overlap between DbSNP sites and other SNP tracks")
public class DbSNPPercentage extends VariantEvaluator {

    @DataPoint(name = "DbSNP count", description = "number of DPSNP sites")
    long nDBSNPs = 0;

    @DataPoint(name = "total count", description = "number of total snp sites")
    long nEvalSNPs = 0;

    @DataPoint(name = "novel snps", description = "number of total snp sites")
    long novelSites = 0;

    @DataPoint(name = "snps at comp", description = "number of SNP sites at comp sites")
    long nSNPsAtComp = 0;

    @DataPoint(name = "% snps at comp", description = "percentage of SNP sites at comp sites")
    double compRate = 0.0;

    @DataPoint(name = "concordant", description = "number of concordant sites")
    long nConcordant = 0;

    @DataPoint(name = "% concordant", description = "the concordance rate")
    double concordantRate = 0.0;

    public DbSNPPercentage(VariantEval2Walker parent) {
        // don't do anything
    }

    public String getName() {
        return "dbOverlap";
    }

    public int getComparisonOrder() {
        return 2;   // we need to see each eval track and each comp track
    }

    public long nNovelSites() { return Math.abs(nEvalSNPs - nSNPsAtComp); }
    public double dbSNPRate() { return rate(nSNPsAtComp, nEvalSNPs); }
    public double concordanceRate() { return rate(nConcordant, nSNPsAtComp); }

    public void finalizeEvaluation() {
        compRate = 100 * dbSNPRate();
        concordantRate = 100 * concordanceRate();
        novelSites = nNovelSites();
    }

    public boolean enabled() {
        return true;
    }

    /**
     * Returns true if every allele in eval is also in dbsnp
     *
     * @param eval  eval context
     * @param dbsnp db context
     * @return true if eval and db are discordant
     */
    public boolean discordantP(VariantContext eval, VariantContext dbsnp) {
        for (Allele a : eval.getAlleles()) {
            if (!dbsnp.hasAllele(a, true))
                return true;
        }

        return false;
    }

    public String update2(VariantContext eval, VariantContext dbsnp, RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        boolean dbSNPIsGood = dbsnp != null && dbsnp.isSNP() && dbsnp.isNotFiltered();
        boolean evalIsGood = eval != null && eval.isSNP();

        if (dbSNPIsGood) nDBSNPs++;             // count the number of dbSNP events
        if (evalIsGood) nEvalSNPs++;           // count the number of dbSNP events

        if (dbSNPIsGood && evalIsGood) {
            nSNPsAtComp++;

            if (!discordantP(eval, dbsnp))     // count whether we're concordant or not with the dbSNP value
                nConcordant++;
        }

        return null; // we don't capture any interesting sites
    }
}