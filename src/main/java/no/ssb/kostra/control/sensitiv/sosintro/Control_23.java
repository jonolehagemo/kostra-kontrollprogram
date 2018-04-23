package no.ssb.kostra.control.sensitiv.sosintro;

/*
 * $Log: Control_19.java,v $
 * Revision 1.1  2009/10/13 12:01:55  pll
 * Import.
 *
 * Revision 1.1  2009/10/13 10:56:19  pll
 *
 * Revision 1.1  2009/10/13 10:46:44  pll
 *
 * 
 */
 
import java.util.Vector;
import no.ssb.kostra.control.Constants;

public final class Control_23 extends no.ssb.kostra.control.Control
    implements no.ssb.kostra.control.SingleRecordErrorReport
{
  private final String ERROR_TEXT = "K23: Introduksjonsstønad på kr 220 000,- eller mer";
  private Vector<Integer> linesWithError = new Vector<Integer>();
  private int UPPER_LIMIT = 220000;
  private String UPPER_LIMIT_STR = "220 000";
  
  
  public boolean doControl(String line, int lineNumber, String region, String statistiskEnhet)
  {
    boolean lineHasError = false;
    
      String field_16 = RecordFields.getFieldValue(line, 1601);
      try {
        int belop = Integer.parseInt(field_16);
        lineHasError = belop >= UPPER_LIMIT;
      } catch (NumberFormatException e) {}
    
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
          " record" + (numOfRecords == 1 ? "" : "s") + 
          " introduksjonsstønaden som deltakeren har fått i løpet av " + lf +
          "\trapporteringsåret overstiger Statistisk sentralbyrås kontrollgrense på kr "+ UPPER_LIMIT_STR + ".";
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