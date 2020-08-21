package no.ssb.kostra.control.sosial.s11_sosialhjelp;

import no.ssb.kostra.control.Code;
import no.ssb.kostra.control.FieldDefinition;

import java.util.List;

public class FieldDefinitions {
    public static List<FieldDefinition> getFieldDefinitions() {
        return List.of(
                new FieldDefinition(1, "KOMMUNE_NR",
                        "String",
                        "textBox",
                        1, 4,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(2, "VERSION",
                        "String",
                        "textBox",
                        5, 6,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(3, "BYDELSNR",
                        "String",
                        "textBox",
                        7, 8,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(4, "DISTRIKTSNR",
                        "String",
                        "textBox",
                        9, 10,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(5, "PERSON_JOURNALNR",
                        "String",
                        "textBox",
                        11, 18,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(6, "PERSON_FODSELSNR",
                        "String",
                        "textBox",
                        19, 29,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(7, "PERSON_DUF",
                        "String",
                        "textBox",
                        30, 41,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(8, "KJONN",
                        "String",
                        "dropDownList",
                        42, 42,
                        List.of(
                                new Code("1", "Mann"),
                                new Code("2", "Kvinne")),
                        "",
                        false),
                new FieldDefinition(9, "EKTSTAT",
                        "String",
                        "dropDownList",
                        43, 43,
                        List.of(
                                new Code("1", "Ugift"),
                                new Code("2", "Gift"),
                                new Code("3", "Samboer"),
                                new Code("4", "Skilt/separert"),
                                new Code("5", "Enke/enkemann")),
                        "",
                        false),
                new FieldDefinition(101, "BU18",
                        "String",
                        "dropDownList",
                        44, 44,
                        List.of(
                                new Code("1", "Ja"),
                                new Code("2", "Nei")),
                        "",
                        false),
                new FieldDefinition(102, "ANTBU18",
                        "Integer",
                        "textBox",
                        45, 46,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(11, "VKLO",
                        "String",
                        "dropDownList",
                        47, 47,
                        List.of(new Code("1", "Arbeidsinntekt"),
                                new Code("2", "Kursstønad/lønn i arbeidsmarkedstiltak"),
                                new Code("3", "Trygd/pensjon"),
                                new Code("4", "Stipend/lån"),
                                new Code("5", "Sosialhjelp"),
                                new Code("6", "Introduksjonsstøtte"),
                                new Code("7", "Ektefelle/samboers arbeidsinntekt"),
                                new Code("8", "Kvalifiseringsstønad"),
                                new Code("9", "Annen inntekt")),
                        "",
                        false),
                new FieldDefinition(12, "TRYGDESIT",
                        "String",
                        "dropDownList",
                        48, 49,
                        List.of(new Code("01", "Sykepenger"),
                                new Code("02", "Dagpenger"),
                                new Code("04", "Uføretrygd"),
                                new Code("05", "Overgangsstønad"),
                                new Code("06", "Etterlattepensjon"),
                                new Code("07", "Alderspensjon"),
                                new Code("09", "Supplerende stønad (kort botid)"),
                                new Code("10", "Annen trygd"),
                                new Code("11", "Arbeidsavklaringspenger"),
                                new Code("12", "Har ingen trygd/pensjon")),
                        "",
                        false),
                new FieldDefinition(13, "ARBSIT",
                        "String",
                        "dropDownList",
                        50, 51,
                        List.of(new Code("01", "Arbeid, heltid"),
                                new Code("02", "Arbeid, deltid"),
                                new Code("03", "Under utdanning"),
                                new Code("04", "Ikke arbeidssøker"),
                                new Code("05", "Arbeidsmarkedstiltak (statlig)"),
                                new Code("06", "Kommunalt tiltak"),
                                new Code("07", "Registrert arbeidsledig"),
                                new Code("08", "Arbeidsledig, men ikke registrert hos NAV"),
                                new Code("09", "Introduksjonsordning"),
                                new Code("10", "Kvalifiseringsprogram")),
                        "",
                        false),
                new FieldDefinition(141, "STMND_1",
                        "String",
                        "checkBox",
                        52, 53,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("01", "Januar")),
                        "",
                        false),
                new FieldDefinition(142, "STMND_2",
                        "String",
                        "checkBox",
                        54, 55,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("02", "Februar")),
                        "",
                        false),
                new FieldDefinition(143, "STMND_3",
                        "String",
                        "checkBox",
                        56, 57,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("03", "Mars")),
                        "",
                        false),
                new FieldDefinition(144, "STMND_4",
                        "String",
                        "checkBox",
                        58, 59,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("04", "April")),
                        "",
                        false),
                new FieldDefinition(145, "STMND_5",
                        "String",
                        "checkBox",
                        60, 61,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("05", "Mai")),
                        "",
                        false),
                new FieldDefinition(146, "STMND_6",
                        "String",
                        "checkBox",
                        62, 63,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("06", "Juni")),
                        "",
                        false),
                new FieldDefinition(147, "STMND_7",
                        "String",
                        "checkBox",
                        64, 65,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("07", "Juli")),
                        "",
                        false),
                new FieldDefinition(148, "STMND_8",
                        "String",
                        "checkBox",
                        66, 67,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("08", "August")),
                        "",
                        false),
                new FieldDefinition(149, "STMND_9",
                        "String",
                        "checkBox",
                        68, 69,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("09", "September")),
                        "",
                        false),
                new FieldDefinition(1410, "STMND_10",
                        "String",
                        "checkBox",
                        70, 71,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("10", "Oktober")),
                        "",
                        false),
                new FieldDefinition(1411, "STMND_11",
                        "String",
                        "checkBox",
                        72, 73,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("11", "November")),
                        "",
                        false),
                new FieldDefinition(1412, "STMND_12",
                        "String",
                        "checkBox",
                        74, 75,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("12", "Desember")),
                        "",
                        false),
                new FieldDefinition(151, "BIDRAG",
                        "Integer",
                        "textBox",
                        76, 82,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(152, "LAAN",
                        "Integer",
                        "textBox",
                        83, 89,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(161, "BIDRAG_JAN",
                        "Integer",
                        "textBox",
                        90, 96,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(162, "LAAN_JAN",
                        "Integer",
                        "textBox",
                        97, 103,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(163, "BIDRAG_FEB",
                        "Integer",
                        "textBox",
                        104, 110,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(164, "LAAN_FEB",
                        "Integer",
                        "textBox",
                        111, 117,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(165, "BIDRAG_MARS",
                        "Integer",
                        "textBox",
                        118, 124,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(166, "LAAN_MARS",
                        "Integer",
                        "textBox",
                        125, 131,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(167, "BIDRAG_APRIL",
                        "Integer",
                        "textBox",
                        132, 138,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(168, "LAAN_APRIL",
                        "Integer",
                        "textBox",
                        139, 145,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(169, "BIDRAG_MAI",
                        "Integer",
                        "textBox",
                        146, 152,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1610, "LAAN_MAI",
                        "Integer",
                        "textBox",
                        153, 159,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1611, "BIDRAG_JUNI",
                        "Integer",
                        "textBox",
                        160, 166,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1612, "LAAN_JUNI",
                        "Integer",
                        "textBox",
                        167, 173,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1613, "BIDRAG_JULI",
                        "Integer",
                        "textBox",
                        174, 180,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1614, "LAAN_JULI",
                        "Integer",
                        "textBox",
                        181, 187,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1615, "BIDRAG_AUG",
                        "Integer",
                        "textBox",
                        188, 194,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1616, "LAAN_AUG",
                        "Integer",
                        "textBox",
                        195, 201,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1617, "BIDRAG_SEPT",
                        "Integer",
                        "textBox",
                        202, 208,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1618, "LAAN_SEPT",
                        "Integer",
                        "textBox",
                        209, 215,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1619, "BIDRAG_OKT",
                        "Integer",
                        "textBox",
                        216, 222,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1620, "LAAN_OKT",
                        "Integer",
                        "textBox",
                        223, 229,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1621, "BIDRAG_NOV",
                        "Integer",
                        "textBox",
                        230, 236,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1622, "LAAN_NOV",
                        "Integer",
                        "textBox",
                        237, 243,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1623, "BIDRAG_DES",
                        "Integer",
                        "textBox",
                        244, 250,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(1624, "LAAN_DES",
                        "Integer",
                        "textBox",
                        251, 257,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(17, "GITT_OKONOMIRAD",
                        "String",
                        "dropDownList",
                        258, 258,
                        List.of(
                                new Code("1", "Ja"),
                                new Code("2", "Nei")),
                        "",
                        false),
                new FieldDefinition(18, "FAAT_INDIVIDUELL_PLAN",
                        "String",
                        "dropDownList",
                        259, 259,
                        List.of(
                                new Code("1", "Ja"),
                                new Code("2", "Nei")),
                        "",
                        false),
                new FieldDefinition(19, "SAKSBEHANDLER",
                        "String",
                        "textBox",
                        260, 269,
                        List.of(),
                        "",
                        false),
                new FieldDefinition(20, "BOSIT",
                        "Integer",
                        "dropDownList",
                        270, 270,
                        List.of(new Code("1", "Bor i leid privat bolig"),
                                new Code("2", "Bor i leid kommunal bolig"),
                                new Code("3", "Bor i eid bolig"),
                                new Code("4", "Er uten bolig"),
                                new Code("6", "Bor i institusjon"),
                                new Code("7", "Annet")),
                        "",
                        false),
                new FieldDefinition(21, "VILKARSOSLOV",
                        "String",
                        "dropDownList",
                        271, 271,
                        List.of(
                                new Code("1", "Ja"),
                                new Code("2", "Nei")),
                        "",
                        false),
                new FieldDefinition(22, "VILKARSAMEKT",
                        "String",
                        "dropDownList",
                        272, 272,
                        List.of(
                                new Code("1", "Ja"),
                                new Code("2", "Nei")),
                        "",
                        false),
                new FieldDefinition(23, "UTBETDATO",
                        "Date",
                        "textBox",
                        273, 278,
                        List.of(),
                        "ddMMyy",
                        false),
                new FieldDefinition(24, "UTBETTOMDATO",
                        "Date",
                        "textBox",
                        279, 284,
                        List.of(),
                        "ddMMyy",
                        false),
                new FieldDefinition(251, "VILKARARBEID",
                        "String",
                        "checkBox",
                        285, 286,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("16", "Delta på arbeidstrening/arbeidspraksis")),
                        "",
                        false),
                new FieldDefinition(252, "VILKARKURS",
                        "String",
                        "checkBox",
                        287, 288,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("17", "Delta på arbeidsrettede kurs, opplæring eller jobbsøkingskurs")),
                        "",
                        false),
                new FieldDefinition(254, "VILKARUTD",
                        "String",
                        "checkBox",
                        289, 290,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("04", "Benytte rett til skole")),
                        "",
                        false),
                new FieldDefinition(256, "VILKARJOBBLOG",
                        "String",
                        "checkBox",
                        291, 292,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("06", "Registrere seg som arbeidssøker/føre jobblogg")),
                        "",
                        false),
                new FieldDefinition(257, "VILKARJOBBTILB",
                        "String",
                        "checkBox",
                        293, 294,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("07", "Ta imot et konkret jobbtilbud")),
                        "",
                        false),
                new FieldDefinition(258, "VILKARSAMT",
                        "String",
                        "checkBox",
                        295, 296,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("08", "Møte til veiledningssamtaler")),
                        "",
                        false),
                new FieldDefinition(2510, "VILKAROKRETT",
                        "String",
                        "checkBox",
                        297, 298,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("10", "Gjøre gjeldende andre økonomiske rettigheter")),
                        "",
                        false),
                new FieldDefinition(2511, "VILKARLIVSH",
                        "String",
                        "checkBox",
                        299, 300,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("18", "Realisere formuesgoder/ redusere boutgifter")),
                        "",
                        false),
                new FieldDefinition(2514, "VILKARHELSE",
                        "String",
                        "checkBox",
                        301, 302,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("14", "Oppsøke helsetjenester/ lege")),
                        "",
                        false),
                new FieldDefinition(2515, "VILKARANNET",
                        "String",
                        "checkBox",
                        303, 304,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("15", "Annet")),
                        "",
                        false),
                new FieldDefinition(2516, "VILKARDIGPLAN",
                        "String",
                        "checkBox",
                        305, 306,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("19", "Bruke og følge opp digital aktivitetsplan")),
                        "",
                        false),
                new FieldDefinition(26, "VEDTAKDATO",
                        "Date",
                        "textBox",
                        307, 312,
                        List.of(),
                        "ddMMyy",
                        false),
                new FieldDefinition(271, "VEDTAKARB",
                        "String",
                        "checkBox",
                        313, 314,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("01", "Mottaker er i arbeid")),
                        "",
                        false),
                new FieldDefinition(272, "VEDTAKAKT",
                        "String",
                        "checkBox",
                        315, 316,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("02", "Mottaker er allerede i aktivitet knyttet til mottak av statlig eller annen kommunal ytelse")),
                        "",
                        false),
                new FieldDefinition(273, "VEDTAKHELSE",
                        "String",
                        "checkBox",
                        317, 318,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("03", "Mottakers helsemessige eller sosiale situasjon hindrer deltakelse i aktivitet")),
                        "",
                        false),
                new FieldDefinition(274, "VEDTAKGRUNN",
                        "String",
                        "checkBox",
                        319, 320,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("04", "Andre tungtveiende grunner taler mot at det stilles vilkår om aktivitet")),
                        "",
                        false),
                new FieldDefinition(281, "SANKSJONRED",
                        "String",
                        "checkBox",
                        321, 322,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("01", "Redusert stønad")),
                        "",
                        false),
                new FieldDefinition(282, "SANKSJONANDRE",
                        "String",
                        "checkBox",
                        323, 324,
                        List.of(
                                new Code("00", "Uoppgitt"),
                                new Code("  ", "Blank"),
                                new Code("02", "Andre konsekvenser")),
                        "",
                        false)
        );
    }

    public static Integer getFieldLength() {
        return getFieldDefinitions().get(getFieldDefinitions().size() - 1).getTo();
    }
}
