package com.epam.codewars.duplletters;

import org.junit.Assert;
import org.junit.Test;

public class DedupTest {
    Dedup dedup = new Dedup();

    @Test
    public void shouldWork() {
        Assert.assertEquals("abc", dedup.dedup("abc"));
        Assert.assertEquals("", dedup.dedup("aaa"));
        Assert.assertEquals("", dedup.dedup("aaaa"));
        Assert.assertEquals("", dedup.dedup("aaaaa"));
        Assert.assertEquals("ac", dedup.dedup("abbc"));
        Assert.assertEquals("ac", dedup.dedup("abbbc"));
        Assert.assertEquals("abad", dedup.dedup("abbcccbad"));
        Assert.assertEquals("d", dedup.dedup("abccbbad"));
        Assert.assertEquals("r", dedup.dedup("abcdeffedcbar"));
        Assert.assertEquals("", dedup.dedup("abcdeffedcba"));
        Assert.assertEquals("", dedup.dedup("abcdefaaabbbvvvfedcba"));
        Assert.assertEquals("jokvzgxsaxplinxvlzgmwpupsvwhsvnfefoukoqglqftzwfsromfzhmklepkg", dedup.dedup("ssssoooobbffffeejbbbqqqqsssrrrovvvhhhsskxxuuuuuueeeezzzzcccvoommmmmmmjjjqqqzlllgxxxzzxsbbbbakkkttxuuurrrryypcceeeelqqqzzjjjjinxcccyyyyvpplzgdddmccczzzttaawffffrrreeeehhhzzzzllllvffrrrraavvvvpxxxxmmvvvvrrrppuuoooovvvvssssuuuyyyycrrrruujjfaaaaggggssfffyyyycccpggglllxxccciiwwwwsssucccciixxxxplllsmmmfffffxxxwwvkkkcceoorrryyyeiiimmmwbbffiidddsssshggsbbuuuuyyffvvkkkkggvllllbbboooonggwwwwfhhnnnxxoooohhhzzzzwwbbhhhaapppsssllllloopppaaaatttrreeeevvvvjjjjjjjeqqqfgglllofffukxxxxxxaaahhobbbzzzzmmaaaqgxxluuuccczzzzyyhhqfqqtpqqqpppwwwwzvvvviiiiwfnnooorrbbbbsssbbccyyyyvvvvccccccsrhhhhtttaaaammeeekkxxxxovvvccccmrryyfwwsssyyxxxxbbzssssmmmmhlllmkxxtttldddbbjffjjdddellhhhhcccuuuuhhpooffffkhhccccgvvviihhhhddiiihhhhhaaahhjjjjjdddmmmooolliiimmmm"));
    }
}