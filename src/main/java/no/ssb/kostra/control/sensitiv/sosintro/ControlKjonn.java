package no.ssb.kostra.control.sensitiv.sosintro;

/*
 * $Log: ControlKjonn.java,v $
 * Revision 1.2  2007/10/25 11:37:12  pll
 * Implementerer getErrorType.
 *
 * Revision 1.1.1.1  2007/09/18 12:24:07  pll
 * Versjon: 2006-rapporteringen
 *
 * Revision 1.2  2006/09/22 09:13:51  lwe
 * Oppdatert årgang
 *
 * Revision 1.1  2006/09/22 08:18:31  lwe
 * Flyttet 2005-filene over i 2006-katalog - men ikke oppdatert årstallene
 *
 * Revision 1.4  2006/01/05 08:31:54  lwe
 * replaced _final class_ with _public final class_
 *
 * Revision 1.3  2006/01/05 08:16:37  lwe
 * added logmessage
 * 
 */
 
import java.util.Vector;
import no.ssb.kostra.control.Constants;

public final class ControlKjonn extends no.ssb.kostra.control.Control
    implements no.ssb.kostra.control.SingleRecordErrorReport
{
  private final String ERROR_TEXT = "K7: Kjønn";
  private Vector<Integer> linesWithError = new Vector<Integer>();

  public boolean doControl(String line, int lineNumber, String region, String statistiskEnhet)
  {
    String kjonn = RecordFields.getKjonn(line);
  
    boolean lineHasError = ! (kjonn.equalsIgnoreCase("1") || 
                              kjonn.equalsIgnoreCase("2"));

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
      errorReport += lf + "\tFeil: Mottakerens kjønn er ikke fylt ut, eller feil kode er benyttet i " + numOfRecords + 
          " record" + (numOfRecords == 1 ? "" : "s") + ". Feltet er obligatorisk å fylle ut."; 
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