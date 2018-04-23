package no.ssb.kostra.control.sensitiv.sosintro;

/*
 * 
 */
 
import java.util.Vector;
import no.ssb.kostra.control.Constants;

public final class ControlStatusDeltakelseAaretsSlutt extends no.ssb.kostra.control.Control
    implements no.ssb.kostra.control.SingleRecordErrorReport
{
  private final String ERROR_TEXT = "K12: Status for deltakelse ved årets slutt";
  private Vector<Integer> linesWithError = new Vector<Integer>();

  public boolean doControl(String line, int lineNumber, String region, String statistiskEnhet)
  {
    boolean lineHasError = false;

    String field_13 = RecordFields.getFieldValue(line, 13);
    try
    {
      lineHasError = !(field_13.equalsIgnoreCase("01") ||
    		  		   field_13.equalsIgnoreCase("02") ||
    		  		   field_13.equalsIgnoreCase("03") ||
    		  		   field_13.equalsIgnoreCase("04") ||
    		  		   field_13.equalsIgnoreCase("05") ||
    		  		   field_13.equalsIgnoreCase("06") ||
    		  		   field_13.equalsIgnoreCase("07") ||
    		  		   field_13.equalsIgnoreCase("08") ||
    		  		   field_13.equalsIgnoreCase("09") ||
    		  		   field_13.equalsIgnoreCase("10")
    		  		  );
    }
    catch (NumberFormatException e)
    {
      lineHasError = true;
    }

    if (lineHasError)
    {
      linesWithError.add(new Integer(lineNumber));
    }

    return lineHasError;
  }

  public String getErrorReport (int totalLineNumber)
  {
    String errorReport = ERROR_TEXT + ":" + lf;
    int numOfRecords = linesWithError.size();
    if (numOfRecords > 0)
    {      
      errorReport += lf + "\tFeil: i " + numOfRecords + 
          " record" + (numOfRecords == 1 ? "" : "s") + 
          " er ikke mottakerens status for deltakelse i" + lf + "\tintroduksjonsordningen " +
          "ved utgangen av rapporteringsåret" + lf + "\tfylt ut, eller feil " +
          "kode er benyttet. Feltet er obligatorisk å fylle ut."; 
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