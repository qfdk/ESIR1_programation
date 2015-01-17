package messagerie;
import java.util.Date;

/**
   Spécification des opérations de communication
 */
public interface GestionCommunication
{
  // opérations effectuées par le téléphone appelant
  /**
 * @param numero
 * @param msgVocalSiOccupe
 * @param dateDebut
 * @return si bien reusse
 */
public boolean appeler   (String numero, String msgVocalSiOccupe, Date dateDebut);
  /**
 * @param numero
 * @param sms
 * @param dateSMS
 */
public void    envoyerSMS(String numero, String sms, Date dateSMS);
  // opérations effectuées par le téléphone appelé
  /**
 * @param numeroAppelant
 * @return si bien accepte
 */
public boolean accepterAppel(String numeroAppelant);
  /**
 * @param message
 */
public void    recevoirSMS  (MessageSMS message);
  // opération effectuée indiféremment par l'appelant ou l'appelé
  /**
 * @param fin
 */
public void    cloreAppel(Date fin);
} // GestionCommunication
