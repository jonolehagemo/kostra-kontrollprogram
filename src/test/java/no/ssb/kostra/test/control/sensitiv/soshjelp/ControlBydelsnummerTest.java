package no.ssb.kostra.test.control.sensitiv.soshjelp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import no.ssb.kostra.control.sensitiv.soshjelp.ControlBydelsnummer;
/**
 * Created by ojj on 16.01.2019.
 */
public class ControlBydelsnummerTest {


    String rec_1 = "";
    String rec_2 = "";
    ControlBydelsnummer t;

    //
    @Before
    public void beforeTest() {
        t = new ControlBydelsnummer();
//		// -----0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222233333333333333333333333
//		// -----0000000001111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990000000000111111111122222222223333333333444444444455555555556666666666777777777788888888889999999999000000000011111111112222222222333333333344444444445555555555666666666677777777778888888888999999999900000000001111111111222
//		// -----1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012
        rec_1 = "1003180404000018621909663155600000000000013101512040102030405060708091011120073964000000000739640000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011per000010212200000000000000000000000000000000000000000000000000";
        rec_2 = "0301180404000018621909663155600000000000013101512040102030405060708091011120073964000000000739640000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011per000010212200000000000000000000000000000000000000000000000000";

    }

    @Test
    public void testControlBydelsnummerOK1() {
        assertFalse(t.doControl(rec_1, 1, "100300", ""));
    }

    @Test
    public void testControlBydelsnummerFail1() {
        assertTrue(t.doControl(rec_1, 1, "030100", ""));
    }


    @Test
    public void testControlBydelsnummerOK2() {
        assertFalse(t.doControl(rec_2, 1, "030100", ""));
    }

    @Test
    public void testControlBydelsnummerOK3() {
        assertFalse(t.doControl(rec_2, 1, "030104", ""));
    }


    @Test
    public void testControlBydelsnummerFail2() {
        assertTrue(t.doControl(rec_2, 1, "030199", ""));
    }


}