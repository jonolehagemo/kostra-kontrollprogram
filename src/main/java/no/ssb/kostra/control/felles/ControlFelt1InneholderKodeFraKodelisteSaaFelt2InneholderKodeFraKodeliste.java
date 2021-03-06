package no.ssb.kostra.control.felles;

import no.ssb.kostra.control.ErrorReport;
import no.ssb.kostra.control.ErrorReportEntry;
import no.ssb.kostra.control.Record;

import java.util.List;

public class ControlFelt1InneholderKodeFraKodelisteSaaFelt2InneholderKodeFraKodeliste {
    public static Record doControl(Record r, ErrorReport er, ErrorReportEntry ere, String field1, List<String> codeList1, String field2, List<String> codeList2) {
        if (Comparator.isCodeInCodelist(r.getFieldAsString(field1), codeList1)){
                if (!Comparator.isCodeInCodelist(r.getFieldAsString(field2), codeList2)){
                    ere.setRefNr(String.valueOf(r.getLine()));
                    er.addEntry(ere);
                }
        }

        return r;
    }
}
