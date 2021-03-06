package no.ssb.kostra.control.felles;

import no.ssb.kostra.control.ErrorReport;
import no.ssb.kostra.control.ErrorReportEntry;
import no.ssb.kostra.control.Record;

import java.util.List;
import java.util.stream.Collectors;

public class ControlFelt1LikSumAvListe {
    public static Record doControl(Record r, ErrorReport er, ErrorReportEntry ere, List<List<String>> fieldLists) {
        fieldLists.forEach(fieldList -> {
                    String sumField = fieldList.get(0);
                    Integer sum = r.getFieldAsIntegerDefaultEquals0(sumField);
                    List<String> aggregateFields = fieldList.subList(1, fieldList.size());
                    Integer sumList = aggregateFields.stream()
                            .map(r::getFieldAsIntegerDefaultEquals0)
                            .reduce(0, Integer::sum);

                    if (!sum.equals(sumList)) {
                        String errorText = "Summen (" + sumField + ") med verdi (" + sum + ") er ulik summen (" + sumList + ") av følgende liste "
                                + aggregateFields.stream()
                                .map(f -> "("
                                        .concat(f)
                                        .concat(" = ")
                                        .concat(r.getFieldAsIntegerDefaultEquals0(f).toString())
                                        .concat(")")
                                )
                                .collect(Collectors.joining(", "));

                        ErrorReportEntry e = new ErrorReportEntry(
                                ere.getSaksbehandler()
                                , ere.getJournalnummer()
                                , ere.getIndividId()
                                , String.valueOf(r.getLine())
                                , ere.getKontrollNr().concat(", ").concat(sumField)
                                , errorText
                                , ere.getErrorType()
                        );

                        er.addEntry(e);
                    }
                }
        );

        return r;
    }

    /*
    *                         , new ErrorReportEntry(
                                "FILUTTREKK"
                                , createLinenumber(l, r.getLine())
                                , String.valueOf(r.getLine())
                                , " "
                                , "Kontroll 14 Kontroll av totalsummer for meklinger"
                                , "Totalene summerer seg ikke som de skal."
                                , Constants.NORMAL_ERROR
                        )
    * */

    public static List<List<String>> createFieldList(String measure, List<String> c1, List<String> c2) {
        List<List<String>> fieldLists = c1.stream()
                .map(c1Item -> c2.stream()
                        .map(c2Item -> String.join("_", measure, c1Item, c2Item))
                        .collect(Collectors.toList())

                )
                .collect(Collectors.toList());

        fieldLists.addAll(c2.stream()
                .map(c2Item -> c1.stream()
                        .map(c1Item -> String.join("_", measure, c1Item, c2Item))
                        .collect(Collectors.toList())

                )
                .collect(Collectors.toList())
        );
        return fieldLists;
    }

    public static List<List<String>> createFieldList(List<String> c1, List<String> c2) {
        List<List<String>> fieldLists = c1.stream()
                .map(c1Item -> c2.stream()
                        .map(c2Item -> String.join("_", c1Item, c2Item))
                        .collect(Collectors.toList())

                )
                .collect(Collectors.toList());

        fieldLists.addAll(c2.stream()
                .map(c2Item -> c1.stream()
                        .map(c1Item -> String.join("_", c1Item, c2Item))
                        .collect(Collectors.toList())

                )
                .collect(Collectors.toList())
        );
        return fieldLists;
    }
}
