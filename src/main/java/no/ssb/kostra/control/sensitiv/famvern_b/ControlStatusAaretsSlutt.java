package no.ssb.kostra.control.sensitiv.famvern_b;

/*
 * 
 */
 
import java.util.Vector;
import no.ssb.kostra.control.Constants;

public final class ControlStatusAaretsSlutt extends no.ssb.kostra.control.Control
    implements no.ssb.kostra.control.SingleRecordErrorReport
{
  private final String ERROR_TEXT = "K19: Status ved året slutt";
  private Vector<Integer> lineNumbers = new Vector<Integer>();

  public boolean doControl(String line, int lineNumber, String region, String statistiskEnhet)
  {
    String fieldValue = RecordFields.getFieldValue(line, 13);

    boolean lineHasError; 
  
    try
    {
      int kode = Integer.parseInt(fieldValue);
      lineHasError = (kode<1 || kode>2);
    }
    catch (Exception e)
    {
      lineHasError = true;
    }
  
    if (lineHasError)
    {
      lineNumbers.add (new Integer (lineNumber));
    }
    return lineHasError;
  }

  public String getErrorReport (int totalLineNumber)
  {
    String errorReport = ERROR_TEXT + ":" + lf + lf;
    if (foundError())
    {
      int numOfRecords = lineNumbers.size();
      errorReport += "\tFeil: i " + numOfRecords + 
      " record" + (numOfRecords == 1 ? "" : "s") + 
      " det er ikke fylt ut hva som er gruppens status ved utgangen av året.";
      if (numOfRecords <= 10)
      {
        errorReport += lf + "\t\t(Gjelder record nr.";
        for (int i=0; i<numOfRecords; i++)
        {
          errorReport += " " + lineNumbers.elementAt(i);
        }
        errorReport += ").";
      }
    }
    errorReport += lf + lf;
    return errorReport;
  }

  public boolean foundError()
  {
    return lineNumbers.size() > 0;
  }  

  public String getErrorText()
  {
    return  ERROR_TEXT;
  }

  public int getErrorType() {
    return Constants.NORMAL_ERROR;
  }
}
