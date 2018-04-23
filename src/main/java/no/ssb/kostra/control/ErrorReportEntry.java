package no.ssb.kostra.control;

public class ErrorReportEntry implements SingleRecordErrorReport {
	String saksbehandler = "";
	String journalnummer = "";
	String individId = "";
	String refNr = "";
	String kontrollNr = "Ikke Satt";
	String errorText = "";
	int errorType = Constants.NO_ERROR;

	public ErrorReportEntry() {
	}
/*
	public ErrorReportEntry(String kontrollNr, int errorType, String errorText, String journalnummer) {
		this.kontrollNr = kontrollNr;
		this.errorType = errorType;
		this.errorText = errorText;
		this.journalnummer = journalnummer;
	}
*/
	public ErrorReportEntry(String saksbehandler, String journalnummer, String individId, String refNr, String kontrollNr, String errorText,
			int errorType) {
		this.saksbehandler = saksbehandler;
		this.journalnummer = journalnummer;
		this.individId = individId;
		this.refNr = refNr;
		this.kontrollNr = kontrollNr;
		this.errorText = errorText;
		this.errorType = errorType;
	}

	public String getSaksbehandler() {
		return saksbehandler;
	}

	public void setSaksbehandler(String saksbehandler) {
		this.saksbehandler = saksbehandler;
	}

	public String getJournalnummer() {
		return journalnummer;
	}

	public void setJournalnummer(String journalnummer) {
		this.journalnummer = journalnummer;
	}

	public String getIndividId() {
		return individId;
	}

	public void setIndividId(String individId) {
		this.individId = individId;
	}

	public String getRefNr() {
		return refNr;
	}

	public void setRefNr(String refNr) {
		this.refNr = refNr;
	}

	public String getKontrollNr() {
		return kontrollNr;
	}

	public void setKontrollNr(String kontrollNr) {
		this.kontrollNr = kontrollNr;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public int getErrorType() {
		return errorType;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}


}