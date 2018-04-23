package no.ssb.kostra.control.sensitiv.famvern;

/*
 * $Log: Control33.java,v $
 * Revision 1.3  2008/12/16 12:27:57  pll
 * no message
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
 * Revision 1.9  2006/01/05 08:16:32  lwe
 * added logmessage
 * 
 */
 
import java.util.Vector;
import no.ssb.kostra.control.Constants;

public final class Control33B extends no.ssb.kostra.control.Control
    implements no.ssb.kostra.control.SingleRecordErrorReport
{
  private final String ERROR_TEXT = "K33B: Hvis avkrysset for 'Annet' så spesifiser";
  private Vector<Integer> lineNumbers = new Vector<Integer>();

  public boolean doControl(String line, int lineNumber, String region, String statistiskEnhet)
  {
	  boolean lineHasError;
	  String field_3413 = RecordFields.getFieldValue(line, 3413);
	  String field_3415 = RecordFields.getFieldValue(line, 3415);
	  
	  try
	  {
		 int kode = Integer.parseInt(field_3413);
		 lineHasError = (kode == 1 && (field_3415.trim().length() == 0
				         || Integer.parseInt(field_3415) == 0 ));
	  }
	  catch (Exception e)
	  {
	    lineHasError = false;
	  }
      if (lineHasError)
	  {
	    lineNumbers.add (new Integer (lineNumber));
	  }
	  return lineHasError;
  }


/*  {  
    String field_34;
    
    for (int i=1; i<=14; i++) {      
      field_34 = RecordFields.getFieldValue(line,(i>9?3400+i:340+i));
      if (field_34.equalsIgnoreCase("1"))
        return false;      
    }
    
   lineNumbers.add (new Integer (lineNumber));    
    return true;
  }
*/
  public String getErrorReport (int totalLineNumber)
  {
    String errorReport = ERROR_TEXT + ":" + lf + lf;
    if (foundError())
    {
      int numOfRecords = lineNumbers.size();
      errorReport += "\tFeil: i " + numOfRecords + 
      " record" + (numOfRecords == 1 ? "" : "s") + 
      " Det er krysset for 'Andre, spesifiser' på spørsmålet om anbefalt " + lf +
      "\tkontakt med andre instanser siden opprettelsen, men spesifiseringen " + lf +
       "\tmangler, eller inneholder for mange (over 30) karakterer.."; 
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
