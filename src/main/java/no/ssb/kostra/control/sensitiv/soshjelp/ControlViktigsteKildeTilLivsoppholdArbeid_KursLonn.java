package no.ssb.kostra.control.sensitiv.soshjelp;

/*
 * 
 */
 
import java.util.Vector;
import no.ssb.kostra.control.Constants;

public final class ControlViktigsteKildeTilLivsoppholdArbeid_KursLonn extends no.ssb.kostra.control.Control
    implements no.ssb.kostra.control.SingleRecordErrorReport
{
  private final String ERROR_TEXT = 
          "K16: Viktigste kilde til livsopphold i relasjon til arbeidssituasjon. Kursstønad/lønn i arbeidsmarkedstiltak";
  private Vector<Integer> linesWithError = new Vector<Integer>();

  public boolean doControl(String line, int lineNumber, String region, String statistiskEnhet)
  {
    boolean lineHasError = false;

    String field_11 = RecordFields.getFieldValue(line, 11);
    String field_13 = RecordFields.getFieldValue(line, 13);

    if (field_11.equalsIgnoreCase("2"))
      lineHasError = ! (field_13.equalsIgnoreCase("03") ||
                        field_13.equalsIgnoreCase("05") ||
                        field_13.equalsIgnoreCase("06") ||
                        field_13.equalsIgnoreCase("09") ||
                        field_13.equalsIgnoreCase("10"));
  
    if (lineHasError)
      linesWithError.add(new Integer(lineNumber));

    return lineHasError;
  }

  public String getErrorReport (int totalLineNumber)
  {
    String errorReport = ERROR_TEXT + ":" + lf;
    int numOfRecords = linesWithError.size();
    if (numOfRecords > 0)
    {      
      errorReport += lf + "\tFeil: i " + numOfRecords + 
          " record" + (numOfRecords == 1 ? "" : "s") + " " +
          "er \"Kursstønad/lønn i arbeidsmarkedstiltak\" mottakerens " +
          "viktigste kilde til livsopphold" + lf + "\tved siste kontakt med " +
          "sosial-/NAV-kontoret, men arbeidssituasjonen er ikke " +
          "\"Under utdanning\"," + lf + "\t\"På arbeidsmarkedstiltak (statlig)\", " + 
          "\"Kommunal tiltaksplass\", \"Kurs gjennom Introduksjonsordning\"" + lf +
          "\teller \"Kvalifiseringsprogram\". Feltet er obligatorisk å fylle ut."; 
      if (numOfRecords <= 10)
      {
        errorReport += lf + "\t\t(Gjelder record nr.";
        for (int i=0; i<numOfRecords; i++)
        {
          errorReport += " " + linesWithError.elementAt(i);
        }
        errorReport += ").";
      }
    }
    errorReport += lf + lf;
    return errorReport;
  }

  public boolean foundError()
  {
    return linesWithError.size() > 0;
  }  

  public String getErrorText()
  {
    return  ERROR_TEXT;
  }

  public int getErrorType() {
    return Constants.NORMAL_ERROR;
  }
}