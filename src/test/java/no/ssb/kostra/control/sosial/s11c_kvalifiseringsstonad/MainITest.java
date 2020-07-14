package no.ssb.kostra.control.sosial.s11c_kvalifiseringsstonad;

import no.ssb.kostra.control.Constants;
import no.ssb.kostra.control.ErrorReport;
import no.ssb.kostra.control.FieldDefinition;
import no.ssb.kostra.controlprogram.Arguments;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MainITest {
    InputStream sysInBackup;
    private Arguments args;
    private ErrorReport er;
    private String inputFileContent;
    private List<FieldDefinition> fieldDefinitions;


    @Before
    public void beforeTest() {
        //                  00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111
        //                  00000000011111111112222222222333333333344444444445555555555666666666677777777778888888888999999999900000000001111111111222222222233333333334444444444555555555566666666
        //                  12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567
        inputFileContent = "420420040400001862190966315561510131121610011712011810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "4204200A0400001862190966315561510131121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "030120040400001862190966315561510131121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "420410040400001862190966315561510131121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "420420040400001862190966     1510131121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "420420040400001862310714894291510131121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "420420040400001862041116448591510131121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "420420040400001862190966315569510131121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "420420040400001862190966315561910131121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "420420040400001862190966315561530131121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "420420040400001862190966315561510031121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "420420040400001862190966315561520131121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "420420040400001862190966315561511031121610011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "4204200404000018621909663155615101      10011712071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "4204200404000018621909663155615101311209      12071810101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "4204200404000018621909663155615101311209010110      10101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "420420040400001862190966315561510131120901011012071030101012000100080010203040506070809101112001200010000000000000000000000000000000000000000000000000000000101117Per99\n" +
                           "42042004040000186219096631556151013112090101101207101    01200014008001020304050607080910111200120001000000000000000000000000000000000000000000000000000000000Knasken00\n" +
                           "4204200404000018621909663155615101311209010110120710101013     1400800102030405060708091011120012000100000000000000000000000000000000000000000000000000000000Knasken001\n" +
                           "4204200404000018621909663155615101311209010110120710101011104002000000102030405060708091011120012000100000000000000000000000000000000000000000000000000000000Knasken001\n" +
                           "4204200404000018621909663155615101311209010110120710101011134009000000102030405060708091011120012000100000000000000000000000000000000000000000000000000000000Knasken001\n" +
                           "4204200404000018621909663155615101311209010110120710101011134002010000102030405060708091011120012000100000000000000000000000000000000000000000000000000000000Knasken001\n" +
                           "4204200404000018621909663155615101311209010110120710101011134002000000102030405060708091011220012000100000000000000000000000000000000000000000000000000000000Knasken001\n" +
                           "4204200404000018621909663155615101311209010110120710101011134002000000102030405060708091011120000000100000000000000000000000000000000000000000000000000000000Knasken001\n" +
                           "4204200404000018621909663155615101311209010110120710101011134002000000102030405060708091011120000000100000000000000000000000000000000000000000000000000000002100Knasken\n" +
                           "4204200404000018621909663155615101311209010110120710101011134002000000000000000000000000000000012000100000000000000000000000000000000000000000000000000000000Knasken001\n" +
                           "4204200404000018621909663155615101311209010110120710101011134002000000102030405060708091011120890120100000000000000000000000000000000000000000000000000000000Knasken001\n" +
                           "4204200404000018621909663155615101311209010110120710101011134002000000102030405060708091011120000235300000000000000000000000000000000000000000000000000000000Knasken001\n" +
                           "4204200404000018621909663155615101311209010110120710101011134002000000102030405060708091011120012000100000000000000000000000000000000000000000000000000000000Knasken001\n" +
                           "4204200404000018621909663155615101311209010110120710101011134002000000102030405060708091011120012000331122001000000000000000000000000000000000000000000000000Knasken001\n" +
                           "4204200404000018621909663155615101311209010110120710101011134002000000102030405060708091011120012000331121800000000000000000000000000000000000000000000000000Knasken001\n";

        sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(inputFileContent.getBytes(StandardCharsets.ISO_8859_1));
        System.setIn(in);

        fieldDefinitions = FieldDefinitions.getFieldDefinitions();

        args = new Arguments(new String[]{"-s", "11CF", "-y", "2020", "-r", "420400"});
    }

    @After
    public void afterTest() {
        System.setIn(sysInBackup);
    }

    @Test
    public void testDoControl() {
        er = Main.doControls(args);

        if (Constants.DEBUG) {
            System.out.print(er.generateReport());
        }

        assertNotNull("Has content ErrorReport", er);
        assertEquals(Constants.CRITICAL_ERROR, er.getErrorType());
    }
}
