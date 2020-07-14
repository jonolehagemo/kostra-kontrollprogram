package no.ssb.kostra.control.felles;

import no.ssb.kostra.control.ErrorReport;
import no.ssb.kostra.control.ErrorReportEntry;
import no.ssb.kostra.control.Record;
import no.ssb.kostra.utils.Toolkit;

public class ControlAlderFraFodselsnummer {
    public static Record doControl(Record p, ErrorReport er, ErrorReportEntry ere, String fieldSSN1, String operator, int age1) {
        boolean hasErrors = false;

        try {
            int age = Toolkit.getAlderFromFnr(p.getFieldAsString(fieldSSN1));

            if (operator.equalsIgnoreCase("<")) {
                hasErrors = !(age < age1);

            } else if (operator.equalsIgnoreCase(">")) {
                hasErrors = !(age > age1);

            } else if (operator.equalsIgnoreCase("==")) {
                hasErrors = !(age == age1);
            }
        } catch (Exception e) {
            hasErrors = true;
        }

        if (hasErrors) {
            ere.setRefNr(String.valueOf(p.getLine()));
            er.addEntry(ere);
        }

        return p;
    }
}
