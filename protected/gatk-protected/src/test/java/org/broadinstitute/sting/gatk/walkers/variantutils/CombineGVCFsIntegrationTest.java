/*
*  By downloading the PROGRAM you agree to the following terms of use:
*  
*  BROAD INSTITUTE - SOFTWARE LICENSE AGREEMENT - FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
*  
*  This Agreement is made between the Broad Institute, Inc. with a principal address at 7 Cambridge Center, Cambridge, MA 02142 (BROAD) and the LICENSEE and is effective at the date the downloading is completed (EFFECTIVE DATE).
*  
*  WHEREAS, LICENSEE desires to license the PROGRAM, as defined hereinafter, and BROAD wishes to have this PROGRAM utilized in the public interest, subject only to the royalty-free, nonexclusive, nontransferable license rights of the United States Government pursuant to 48 CFR 52.227-14; and
*  WHEREAS, LICENSEE desires to license the PROGRAM and BROAD desires to grant a license on the following terms and conditions.
*  NOW, THEREFORE, in consideration of the promises and covenants made herein, the parties hereto agree as follows:
*  
*  1. DEFINITIONS
*  1.1 PROGRAM shall mean copyright in the object code and source code known as GATK2 and related documentation, if any, as they exist on the EFFECTIVE DATE and can be downloaded from http://www.broadinstitute/GATK on the EFFECTIVE DATE.
*  
*  2. LICENSE
*  2.1   Grant. Subject to the terms of this Agreement, BROAD hereby grants to LICENSEE, solely for academic non-commercial research purposes, a non-exclusive, non-transferable license to: (a) download, execute and display the PROGRAM and (b) create bug fixes and modify the PROGRAM. 
*  The LICENSEE may apply the PROGRAM in a pipeline to data owned by users other than the LICENSEE and provide these users the results of the PROGRAM provided LICENSEE does so for academic non-commercial purposes only.  For clarification purposes, academic sponsored research is not a commercial use under the terms of this Agreement.
*  2.2  No Sublicensing or Additional Rights. LICENSEE shall not sublicense or distribute the PROGRAM, in whole or in part, without prior written permission from BROAD.  LICENSEE shall ensure that all of its users agree to the terms of this Agreement.  LICENSEE further agrees that it shall not put the PROGRAM on a network, server, or other similar technology that may be accessed by anyone other than the LICENSEE and its employees and users who have agreed to the terms of this agreement.
*  2.3  License Limitations. Nothing in this Agreement shall be construed to confer any rights upon LICENSEE by implication, estoppel, or otherwise to any computer software, trademark, intellectual property, or patent rights of BROAD, or of any other entity, except as expressly granted herein. LICENSEE agrees that the PROGRAM, in whole or part, shall not be used for any commercial purpose, including without limitation, as the basis of a commercial software or hardware product or to provide services. LICENSEE further agrees that the PROGRAM shall not be copied or otherwise adapted in order to circumvent the need for obtaining a license for use of the PROGRAM.  
*  
*  3. OWNERSHIP OF INTELLECTUAL PROPERTY 
*  LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies.  LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
*  Copyright 2012 Broad Institute, Inc.
*  Notice of attribution:  The GATK2 program was made available through the generosity of Medical and Population Genetics program at the Broad Institute, Inc.
*  LICENSEE shall not use any trademark or trade name of BROAD, or any variation, adaptation, or abbreviation, of such marks or trade names, or any names of officers, faculty, students, employees, or agents of BROAD except as states above for attribution purposes.
*  
*  4. INDEMNIFICATION
*  LICENSEE shall indemnify, defend, and hold harmless BROAD, and their respective officers, faculty, students, employees, associated investigators and agents, and their respective successors, heirs and assigns, (Indemnitees), against any liability, damage, loss, or expense (including reasonable attorneys fees and expenses) incurred by or imposed upon any of the Indemnitees in connection with any claims, suits, actions, demands or judgments arising out of any theory of liability (including, without limitation, actions in the form of tort, warranty, or strict liability and regardless of whether such action has any factual basis) pursuant to any right or license granted under this Agreement.
*  
*  5. NO REPRESENTATIONS OR WARRANTIES
*  THE PROGRAM IS DELIVERED AS IS.  BROAD MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING THE PROGRAM OR THE COPYRIGHT, EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER DEFECTS, WHETHER OR NOT DISCOVERABLE. BROAD EXTENDS NO WARRANTIES OF ANY KIND AS TO PROGRAM CONFORMITY WITH WHATEVER USER MANUALS OR OTHER LITERATURE MAY BE ISSUED FROM TIME TO TIME.
*  IN NO EVENT SHALL BROAD OR ITS RESPECTIVE DIRECTORS, OFFICERS, EMPLOYEES, AFFILIATED INVESTIGATORS AND AFFILIATES BE LIABLE FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES OF ANY KIND, INCLUDING, WITHOUT LIMITATION, ECONOMIC DAMAGES OR INJURY TO PROPERTY AND LOST PROFITS, REGARDLESS OF WHETHER BROAD SHALL BE ADVISED, SHALL HAVE OTHER REASON TO KNOW, OR IN FACT SHALL KNOW OF THE POSSIBILITY OF THE FOREGOING.
*  
*  6. ASSIGNMENT
*  This Agreement is personal to LICENSEE and any rights or obligations assigned by LICENSEE without the prior written consent of BROAD shall be null and void.
*  
*  7. MISCELLANEOUS
*  7.1 Export Control. LICENSEE gives assurance that it will comply with all United States export control laws and regulations controlling the export of the PROGRAM, including, without limitation, all Export Administration Regulations of the United States Department of Commerce. Among other things, these laws and regulations prohibit, or require a license for, the export of certain types of software to specified countries.
*  7.2 Termination. LICENSEE shall have the right to terminate this Agreement for any reason upon prior written notice to BROAD. If LICENSEE breaches any provision hereunder, and fails to cure such breach within thirty (30) days, BROAD may terminate this Agreement immediately. Upon termination, LICENSEE shall provide BROAD with written assurance that the original and all copies of the PROGRAM have been destroyed, except that, upon prior written authorization from BROAD, LICENSEE may retain a copy for archive purposes.
*  7.3 Survival. The following provisions shall survive the expiration or termination of this Agreement: Articles 1, 3, 4, 5 and Sections 2.2, 2.3, 7.3, and 7.4.
*  7.4 Notice. Any notices under this Agreement shall be in writing, shall specifically refer to this Agreement, and shall be sent by hand, recognized national overnight courier, confirmed facsimile transmission, confirmed electronic mail, or registered or certified mail, postage prepaid, return receipt requested.  All notices under this Agreement shall be deemed effective upon receipt. 
*  7.5 Amendment and Waiver; Entire Agreement. This Agreement may be amended, supplemented, or otherwise modified only by means of a written instrument signed by all parties. Any waiver of any rights or failure to act in a specific instance shall relate only to such instance and shall not be construed as an agreement to waive any rights or fail to act in any other instance, whether or not similar. This Agreement constitutes the entire agreement among the parties with respect to its subject matter and supersedes prior agreements or understandings between the parties relating to its subject matter. 
*  7.6 Binding Effect; Headings. This Agreement shall be binding upon and inure to the benefit of the parties and their respective permitted successors and assigns. All headings are for convenience only and shall not affect the meaning of any provision of this Agreement.
*  7.7 Governing Law. This Agreement shall be construed, governed, interpreted and applied in accordance with the internal laws of the Commonwealth of Massachusetts, U.S.A., without regard to conflict of laws principles.
*/

package org.broadinstitute.sting.gatk.walkers.variantutils;

import org.broadinstitute.sting.WalkerTest;
import org.broadinstitute.sting.utils.variant.GATKVCFUtils;
import org.broadinstitute.variant.variantcontext.VariantContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class CombineGVCFsIntegrationTest extends WalkerTest {
    public static String baseTestString(String args) {
        return "-T CombineGVCFs -R " + b37KGReference + " -o %s --no_cmdline_in_header -V "
                + privateTestDir + "gvcfExample1.vcf -V " + privateTestDir + "gvcfExample2.vcf" + args;
    }

    @Test
    public void testOneStartsBeforeTwoAndEndsAfterwards() throws Exception {
        final String cmd = baseTestString(" -L 1:69485-69509");
        final WalkerTestSpec spec = new WalkerTestSpec(cmd, 1, Arrays.asList(""));
        spec.disableShadowBCF();
        final File gVCF = executeTest("testOneStartsBeforeTwoAndEndsAfterwards", spec).first.get(0);
        final List<VariantContext> allVCs = GATKVCFUtils.readVCF(gVCF).getSecond();

        Assert.assertEquals(allVCs.size(), 2, "Observed: " + allVCs);

        final VariantContext first = allVCs.get(0);
        Assert.assertEquals(first.getStart(), 69491);
        Assert.assertEquals(first.getEnd(), 69497);
        Assert.assertEquals(first.getGenotypes().size(), 2);
        Assert.assertTrue(first.getGenotype("NA1").isCalled());
        Assert.assertTrue(first.getGenotype("NA2").isNoCall());

        final VariantContext second = allVCs.get(1);
        Assert.assertEquals(second.getStart(), 69498);
        Assert.assertEquals(second.getEnd(), 69506);
        Assert.assertEquals(second.getGenotypes().size(), 2);
        Assert.assertTrue(second.getGenotype("NA1").isCalled());
        Assert.assertTrue(second.getGenotype("NA2").isCalled());
    }

    @Test
    public void testTwoSpansManyBlocksInOne() throws Exception {
        final String cmd = baseTestString(" -L 1:69512-69634");
        final WalkerTestSpec spec = new WalkerTestSpec(cmd, 1, Arrays.asList(""));
        spec.disableShadowBCF();
        final File gVCF = executeTest("testTwoSpansManyBlocksInOne", spec).first.get(0);
        final List<VariantContext> allVCs = GATKVCFUtils.readVCF(gVCF).getSecond();

        Assert.assertEquals(allVCs.size(), 5);
    }

    @Test
    public void testOneHasAltAndTwoHasNothing() throws Exception {
        final String cmd = baseTestString(" -L 1:69511");
        final WalkerTestSpec spec = new WalkerTestSpec(cmd, 1, Arrays.asList(""));
        spec.disableShadowBCF();
        final File gVCF = executeTest("testOneHasAltAndTwoHasNothing", spec).first.get(0);
        final List<VariantContext> allVCs = GATKVCFUtils.readVCF(gVCF).getSecond();

        Assert.assertEquals(allVCs.size(), 1);

        final VariantContext first = allVCs.get(0);
        Assert.assertEquals(first.getStart(), 69511);
        Assert.assertEquals(first.getEnd(), 69511);
        Assert.assertEquals(first.getGenotypes().size(), 2);
    }

    @Test
    public void testOneHasAltAndTwoHasRefBlock() throws Exception {
        final String cmd = baseTestString(" -L 1:69635");
        final WalkerTestSpec spec = new WalkerTestSpec(cmd, 1, Arrays.asList(""));
        spec.disableShadowBCF();
        final File gVCF = executeTest("testOneHasAltAndTwoHasRefBlock", spec).first.get(0);
        final List<VariantContext> allVCs = GATKVCFUtils.readVCF(gVCF).getSecond();

        Assert.assertEquals(allVCs.size(), 1);

        final VariantContext first = allVCs.get(0);
        Assert.assertEquals(first.getStart(), 69635);
        Assert.assertEquals(first.getEnd(), 69635);
        Assert.assertEquals(first.getNAlleles(), 3);
        Assert.assertEquals(first.getGenotypes().size(), 2);
    }

    @Test
    public void testOneHasDeletionAndTwoHasRefBlock() throws Exception {
        final String cmd = baseTestString(" -L 1:69772-69783");
        final WalkerTestSpec spec = new WalkerTestSpec(cmd, 1, Arrays.asList(""));
        spec.disableShadowBCF();
        final File gVCF = executeTest("testOneHasDeletionAndTwoHasRefBlock", spec).first.get(0);
        final List<VariantContext> allVCs = GATKVCFUtils.readVCF(gVCF).getSecond();

        Assert.assertEquals(allVCs.size(), 3);

        final VariantContext first = allVCs.get(0);
        Assert.assertEquals(first.getStart(), 69772);
        Assert.assertEquals(first.getEnd(), 69776);
        Assert.assertEquals(first.getNAlleles(), 3);
        Assert.assertEquals(first.getGenotypes().size(), 2);

        final VariantContext second = allVCs.get(1);
        Assert.assertEquals(second.getStart(), 69773);
        Assert.assertEquals(second.getEnd(), 69774);
        Assert.assertEquals(second.getGenotypes().size(), 2);

        final VariantContext third = allVCs.get(2);
        Assert.assertEquals(third.getStart(), 69775);
        Assert.assertEquals(third.getEnd(), 69783);
        Assert.assertEquals(third.getGenotypes().size(), 2);
    }

    @Test
    public void testMD5s() throws Exception {
        final String cmd = baseTestString(" -L 1:69485-69791");
        final WalkerTestSpec spec = new WalkerTestSpec(cmd, 1, Arrays.asList("c279e089fd15359e75867b1318cb4d50"));
        spec.disableShadowBCF();
        executeTest("testMD5s", spec);
    }

    @Test
    public void testBasepairResolutionOutput() throws Exception {
        final String cmd = baseTestString(" -L 1:69485-69791 --convertToBasePairResolution");
        final WalkerTestSpec spec = new WalkerTestSpec(cmd, 1, Arrays.asList("a068fb2c35cdd14df1e8f1f92f4114b4"));
        spec.disableShadowBCF();
        executeTest("testBasepairResolutionOutput", spec);
    }

    @Test
    public void testBasepairResolutionInput() throws Exception {
        final String cmd = "-T CombineGVCFs -R " + b37KGReference + " -o %s --no_cmdline_in_header -V " + privateTestDir + "gvcf.basepairResolution.vcf";
        final WalkerTestSpec spec = new WalkerTestSpec(cmd, 1, Arrays.asList("0bd914cfa16349ee0439bfa5033a4f2a"));
        spec.disableShadowBCF();
        executeTest("testBasepairResolutionInput", spec);
    }
}
