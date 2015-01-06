package messagerie;
import java.util.Date;

/**
   Spécification des opérations de communication
 */
public interface GestionCommunication
{
  // opérations effectuées par le téléphone appelant
  public boolean appeler   (String numero, String msgVocalSiOccupe, Date dateDebut);
  public void    envoyerSMS(String numero, String sms, Date dateSMS);
  // opérations effectuées par le téléphone appelé
  public boolean accepterAppel(String numeroAppelant);
  public void    recevoirSMS  (MessageSMS message);
  // opération effectuée indiféremment par l'appelant ou l'appelé
  public void    cloreAppel(Date fin);
} // GestionCommunication
