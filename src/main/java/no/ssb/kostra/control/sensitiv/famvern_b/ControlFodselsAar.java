package no.ssb.kostra.control.sensitiv.famvern_b;

/*
 * $Log: ControlFodselsAar.java,v $
 * Revision 1.2  2009/02/08 12:38:36  pll
 * Ny implementasjon.
 *
 * Revision 1.1  2009/01/06 10:18:59  pll
 * Import.
 *
 * Revision 1.1  2009/01/05 18:06:01  pll
 * Import.
 *
 * Revision 1.2  2007/10/25 11:37:03  pll
 * Implementerer getErrorType.
 *
 * Revision 1.1.1.1  2007/09/18 12:24:07  pll
 * Versjon: 2006-rapporteringen
 *
 * Revision 1.2  2006/09/22 09:13:48  lwe
 * Oppdatert årgang
 *
 * Revision 1.1  2006/09/22 08:18:27  lwe
 * Flyttet 2005-filene over i 2006-katalog - men ikke oppdatert årstallene
 *
 * Revision 1.6  2006/01/05 08:16:32  lwe
 * added logmessage
 * 
 */
 
import java.util.Vector;
import no.ssb.kostra.control.Constants;
//import no.ssb.kostra.utils.*;

public final class ControlFodselsAar extends no.ssb.kostra.control.Control
    implements no.ssb.kostra.control.SingleRecordErrorReport
{
  private final String ERROR_TEXT = "K17: Deltakerens fødselsår";
  private Vector<Integer> lineNumbers = new Vector<Integer>();

  public boolean doControl(String line, int lineNumber, String region, String statistiskEnhet) {
  
    boolean lineHasError; 
    String fAar = RecordFields.getFieldValue(line, 15);
    
    try {
        int aar = Integer.parseInt(fAar);
        int upper_limit = Integer.parseInt(Constants.kostraYear);
        int lower_limit = upper_limit - 100;
        lineHasError = (aar<lower_limit || aar>upper_limit);
    } catch (Exception e) {
        lineHasError = true;
    }

    if (lineHasError) {        
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
      " er det ikke oppgitt fødselsår på deltakeren eller feltet har ugyldig format." + lf +
      "\tFeltet er obligatorisk å fylle ut."; 
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
