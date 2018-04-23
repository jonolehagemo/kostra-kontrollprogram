package no.ssb.kostra.control.regnskap.regn0C;

import java.io.*;
import java.util.*;
import no.ssb.kostra.utils.Regioner;
import no.ssb.kostra.control.*;

public final class Main {
  
  private String regionNumber;
  private File sourceFile;
  private File reportFile;
  private String[] regnskap;
  private Control[] controls;
  private final String lf = Constants.lineSeparator;
  private final String VERSION = "0C." + Constants.kostraYear + ".01";
  

  
  
  public Main
    (String regionNumber, File sourceFile, File reportFile, String[] regnskap) {
    
    this.regionNumber = regionNumber;
    this.sourceFile = sourceFile;
    this.reportFile = reportFile;
    this.regnskap = regnskap;
    initControls();
  }

  
  
  
  public int start() {
    
    int lineNumber = 0;
    int error_type = Constants.NO_ERROR;
    
    for (int j=0; j<regnskap.length; j++) {
      
      if (! regnskap[j].equalsIgnoreCase("")) {
        
          lineNumber += 1;
          //Sjekker recordlengde forst, fordi feil reccordlengde 
          //vil kunne odelegge mange andre kontroller 
          //(StringIndexOutOfBoundsException etc.)
          if (! controls[0].doControl(regnskap[j], lineNumber, regionNumber, "")) {
            for (int i=1; i<controls.length; i++)
              controls[i].doControl(regnskap[j], lineNumber, regionNumber, "");
          }
        }
      }

    try
    {
      BufferedWriter fileWriter = null;
      if (reportFile != null)
        fileWriter = new BufferedWriter (new FileWriter (reportFile));

      String report =  "-------------------------------------------------" + lf;    
             report += lf;
             report += " Feilmeldingsrapport for " + regionNumber + " " + Regioner.getRegionName(regionNumber) + lf;
             report += lf;
             report += "-------------------------------------------------" + lf + lf;

      report += "Kontrollprogramversjon: " + VERSION + lf;
      report += "Rapport generert: " + Calendar.getInstance().getTime() + lf;
      report += "Kontrollert fil: " + (sourceFile != null ? sourceFile.getAbsolutePath() : "") + lf;
      report += "Type regnskap: 0C - Bevilgningsregnskap fylkeskommune" + lf + lf;

      int numOfErrors = 0;
      int control_error_type;
      String buffer = "";
      
      for (int i=0; i<controls.length; i++)
      {
        if (controls[i].foundError())
        {
          control_error_type = controls[i].getErrorType();
          if (control_error_type > error_type)
            error_type = control_error_type;

          if (control_error_type == Constants.CRITICAL_ERROR)
             buffer +=Constants.CRITICAL_ERROR_TEXT_MSG + lf;
          
          buffer += controls[i].getErrorReport (lineNumber);
          numOfErrors += 1;
        }
      }

      if (numOfErrors > 0)
      {
        report += "Følgende " + (numOfErrors == 1 ? "kontroll" : (numOfErrors + " kontroller")) + " har funnet feil eller advarsler:" +lf + lf;
        report += buffer;  
      }
      else
      {
        if (lineNumber == 0) {
          report += "Finner ingen data!";
          error_type = Constants.CRITICAL_ERROR;
        } else {          
          report += "Ingen feil funnet!";
        }
      }
      
      if (fileWriter != null)
      {  
        fileWriter.write (report);
        fileWriter.close();
      } else {
        System.out.println(report);
      }     
    }
    catch (Exception e)
    {
      System.out.println("Can't write report file: ");
      System.out.println(e.toString());;
      System.exit (Constants.IO_ERROR);
    }
    
    return error_type;
  }

  private void initControls()
  {
    controls = new Control[23];
    controls[0] = new ControlRecordlengde();
    controls[1] = new ControlAargang();
    controls[2] = new ControlKvartal();
    controls[3] = new ControlFylkeskommunenummer();
    controls[4] = new ControlKontoklasse();
    controls[5] = new ControlOrgNummer();
    controls[6] = new ControlFunksjoner();
    controls[7] = new ControlArter();
//    controls[7] = new ControlKontoklasseOgFunksjon();
    controls[8] = new Control8a();
//    controls[9] = new Control8b();
    controls[9] = new ControlKontoklasseOgArtInvestering();
    controls[10] = new ControlKontoklasseOgArtDrift();
    controls[11] = new ControlDubletter();
    controls[12] = new ControlSummering();
    controls[13] = new ControlSkatteinntekter();
//    controls[14] = new ControlInterneOverforinger();
    controls[14] = new ControlOverforingDriftInvestering();
    controls[15] = new ControlAvskrivinger();
    controls[16] = new Control490();
    controls[17] = new Control465();
    controls[18] = new ControlArt490();
    controls[19] = new ControlRecord();
//    controls[19] = new no.ssb.kostra.control.regnskap.ControlOrgNr();
    controls[20] = new ControlNumericalFields();
    controls[21] = new Control22a();
    controls[22] = new Control22b();
  }
}