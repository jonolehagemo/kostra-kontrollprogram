package no.ssb.kostra.control.sensitiv.barnevern;

import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import no.ssb.kostra.control.Constants;
import no.ssb.kostra.control.ErrorReport;
import no.ssb.kostra.control.ErrorReportEntry;

/**
 * 
 * @author ojj
 * @version $Revision$
 * 
 */
public class AvgiverNodeHandler extends NodeHandler {
	public AvgiverNodeHandler(ErrorReport er, String region,
			Map<String, String> avgiver) {
		super(er, region, avgiver);
	}

	/**
	 * <pre>
	 * Prosesserer/kontrollerer et Avgiver-nodetre ved at man: <br/>
	 * - Avgiver K1: Validering av avgiver
	 *   - Kontrollerer mot filbeskrivelse for avgiver, Avgiver.xsd 
	 * - Avgiver K2: Årgang
	 *   - Kontrollerer at årgangen for filutrekket er for gjeldende rapporteringsår
	 * - Avgiver K3: Organisasjonnummer
	 *   - Kontrollerer at filen har organisasjonsnummer for avgiver
	 * - Avgiver K4: Kommunenummer
	 *   - Kontrollerer at kommunenummer i webskjemaet likt med tilsvarende i filutrekket
	 * - Avgiver K5: Gyldig kommunenummer
	 *   - Kontrollerer at kommunenummeret fins i liste over gyldige kommunenumre som er med i denne rapporteringen
	 * - Avgiver K6: Kommunenavn
	 *   - Kontrollerer at kommunenavn fins i filen
	 * </pre>
	 * 
	 * @param node
	 *            StructuredNode som er en Avgiver-node
	 */
	@Override
	public void process(StructuredNode node) {
		try {
			/**
			 * Tar vare på avgiverinformasjon da denne også trengs ved
			 * kontrollering av Individ-noder
			 */
			avgiver.put("Organisasjonsnummer",
					node.queryString("@Organisasjonsnummer"));
			avgiver.put("Versjon", node.queryString("@Versjon"));
			avgiver.put("Kommunenummer", node.queryString("@Kommunenummer"));
			avgiver.put("Kommunenavn", node.queryString("@Kommunenavn"));

			/**
			 * <pre>
			 * - Avgiver K1: Validering av avgiver
			 *   - Kontrollerer mot filbeskrivelse for avgiver, Avgiver.xsd
			 * </pre>
			 */
			controlValidateByXSD(er, new ErrorReportEntry("Kontrollprogrammet",
					"0", "0", "0", "Avgiver K1: Validering av avgiver",
					"Klarer ikke å validere Avgiver mot filspesifikasjon",
					Constants.CRITICAL_ERROR), node.getNode()
					.getOwnerDocument(), "Avgiver.xsd");

			/**
			 * <pre>
			 * - Avgiver K2: Årgang
			 *   - Kontrollerer at årgangen for filutrekket er for gjeldende rapporteringsår
			 * </pre>
			 */
			controlEquals(er, new ErrorReportEntry(" ", "", " ", " ",
					"Avgiver K2: Årgang",
					"Filen inneholder feil rapporteringsår (" + node.queryString("@Versjon") + "), forventet " + Constants.kostraYear + ".",
					Constants.CRITICAL_ERROR), node.queryString("@Versjon"),
					Constants.kostraYear);

			/**
			 * <pre>
			 * - Avgiver K3: Organisasjonnummer
			 *   - Kontrollerer at filen har organisasjonsnummer for avgiver
			 * </pre>
			 */
			controlExists(er, new ErrorReportEntry(" ", " ", " ", " ",
					"Avgiver K3: Organisasjonnummer",
					"Filen mangler organisasjonsnummer.",
					Constants.CRITICAL_ERROR),
					node.queryString("@Organisasjonsnummer"));

			/**
			 * <pre>
			 * - Avgiver K4: Kommunenummer
			 *   - Kontrollerer at kommunenummer i webskjemaet likt med tilsvarende i filutrekket
			 * </pre>
			 */
			controlEquals(
					er,
					new ErrorReportEntry(
							" ",
							" ",
							" ",
							" ",
							"Avgiver K4: Kommunenummer",
							"Filen inneholder feil kommunenummer. Forskjellig kommunenummer i skjema og filuttrekk."
									+ node.queryString("@Kommunenummer")
									+ " : " + this.region,
							Constants.CRITICAL_ERROR),
					node.queryString("@Kommunenummer"), region.substring(0, 4));

			/**
			 * <pre>
			 * - Avgiver K5: Gyldig kommunenummer
			 *   - Kontrollerer at kommunenummeret fins i liste over gyldige kommunenumre som er med i denne rapporteringen
			 * </pre>
			 */
			controlBoolean(
					er,
					new ErrorReportEntry(
							" ",
							" ",
							" ",
							" ",
							"Avgiver K5: Gyldig kommunenummer",
							"Filen inneholder feil kommunenummer. Fins ikke i listen over gyldige kommunenumre.",
							Constants.CRITICAL_ERROR),
					no.ssb.kostra.utils.Regioner.kommuneNrIsValid(region));

			/**
			 * <pre>
			 * - Avgiver K6: Kommunenavn
			 *   - Kontrollerer at kommunenavn fins i filen
			 * </pre>
			 */
			controlExists(er, new ErrorReportEntry(" ", " ", " ", " ",
					"Avgiver K6: Kommunenavn", "Filen mangler kommunenavn.",
					Constants.CRITICAL_ERROR), node.queryString("@Kommunenavn"));

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
}