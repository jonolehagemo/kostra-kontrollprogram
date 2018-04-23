package no.ssb.kostra.control.regnskap.regn0J;

import java.util.Vector;
import no.ssb.kostra.control.Constants;

final class ControlSektorer extends no.ssb.kostra.control.Control {
	private String[] validArter = { "000", "610", "640", "395", "320", "355",
			"430", "450", "499", "550", "570", "650", "110", "151", "152",
			"200", "890", "900", "070", "075", "080"
	// "00","10","14","15","19",
	// "20","31","38","39","41","47","49",
	// "50","63","66","68","70",
	// "75","90","98","99"
	};

	private Vector<String[]> invalidArter = new Vector<String[]>();

	public boolean doControl(String line, int lineNumber, String region, String statistiskEnhet) {
		String art = RecordFields.getArt(line);

		// Kontrollen skal ikke foretas hvis belop = 0 og art er definert.
		try {
			int belop = RecordFields.getBelopIntValue(line);
			if (belop == 0 && art.trim().length() > 0) {
				return false;
			}
		} catch (Exception e) {
			// Returnerer her ogsaa. Gir ikke mening med kontroll
			// hvis belop ikke er angitt.
			return false;
		}

		boolean lineHasError = !isValidArt(art);

		if (lineHasError) {
			String[] container = new String[2];
			container[0] = Integer.toString(lineNumber);
			container[1] = art;
			invalidArter.add(container);
		}
		return lineHasError;
	}

	public String getErrorReport(int totalLineNumber) {
		String errorReport = "Kontroll 8, Ugyldig bruk av sektorer:" + lf + lf;
		int numOfRecords = invalidArter.size();
		if (numOfRecords > 0) {
			errorReport += "\tFeil: Ugyldig" + (numOfRecords == 1 ? "" : "e")
					+ " sektor" + (numOfRecords == 1 ? "" : "er") + ":" + lf;
			for (int i = 0; i < numOfRecords; i++) {
				String[] container = (String[]) invalidArter.elementAt(i);
				errorReport += "\tsektor " + container[1] + " (Record nr. "
						+ container[0] + ")" + lf;
			}
		}
		errorReport += lf + "\tKorreksjon: Rett opp feil sektor med gyldig sektor. For oversikt over gyldige sektorer se gjeldende versjonav KOSTRA-kontoplanen."
				+ lf + lf + lf;
		return errorReport;
	}

	public boolean foundError() {
		return invalidArter.size() > 0;
	}

	private boolean isValidArt(String art) {
		for (int i = validArter.length - 1; i >= 0; i--) {
			if (art.equalsIgnoreCase(validArter[i])) {
				return true;
			}
		}
		return false;
	}

	public int getErrorType() {
		return Constants.CRITICAL_ERROR;
	}
}