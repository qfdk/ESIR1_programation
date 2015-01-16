package messagerie;

import java.util.Date;
import java.util.Scanner;

import forfait.AbsForfait;

/**
 * Informations d'Abonné gérées par l'opérateur
 */
public class AbonneOperateur implements GestionCommunication
{
	private String nom;
	private Operateur operateur;
	private AbsForfait forfait;
	private Telephone telephone;
	private NumeroTelephone numeroTel;
	private BoiteSMS boiteSMS;
	private BoiteVocale boiteVocale;
	private boolean statTel = false;

	/**
	 * @return the statTel
	 */
	public boolean isStatTel()
	{
		return statTel;
	}

	/**
	 * @param statTel the statTel to set
	 */
	public void setStatTel(boolean statTel)
	{
		this.statTel = statTel;
	}

	/**
	 * const
	 * @param nom  nom de l'operateur
	 */
	public AbonneOperateur(String nom)
	{
		boiteSMS = new BoiteSMS();
		boiteVocale = new BoiteVocale();
		setNom(nom);
	}

	// ------------------------------------------------------------------------
	// méthodes de l'interface GestionCommunication
	// ------------------------------------------------------------------------

	@Override
	public boolean appeler(String numero, String msgVocalSiOccupe,
			Date dateDebut)
	{
		System.out.println("Tentative Appel de " + this + " ---->" + numero
				+ " en date du " + dateDebut);
		return operateur.etablirCommunication(this, numero,
				msgVocalSiOccupe, dateDebut);
	}

	@Override
	public void envoyerSMS(String numero, String sms, Date dateSMS)
	{
		operateur.posterSMS(this, numero, sms, dateSMS);
	}

	@Override
	public void recevoirSMS(MessageSMS message)
	{
		boiteSMS.ajouterSMS(message);
		this.synchroniser();
	}

	@Override
	public boolean accepterAppel(String numeroAppelant)
	{
		System.out.println("Vous voulez accepter l''appel de "+numeroAppelant);
		Scanner scanner=new Scanner(System.in);
		String tmp=scanner.nextLine();
		scanner.close();
		if(tmp.equals("y")||tmp.equals("o"))
		{
			return true;
		}
		return false;
	}

	@Override
	public void cloreAppel(Date fin)
	{
		operateur.cloreAppel(this, fin);
	}

	// ------------------------------------------------------------------------
	// autres méthodes
	// ------------------------------------------------------------------------

	/**
	 * transférer sur le téléphone les SMS du serveur
	 */
	public void synchroniser()
	{
		if (!telephone.isEteind())
		{
			this.boiteSMS.getListmeSms().addAll(boiteSMS.getListmeSms().size(),
					telephone.getBoiteSMS().getListmeSms());
			telephone.getBoiteSMS().supprimerSMS();
		}

	}

	/**
	 * @return s'il est hors ligne
	 */
	public boolean estHorsLigne()
	{
		return !this.isStatTel();
	}

	/**
	 * @return s'il est libre
	 */
	public boolean estLibre()
	{
		if (!telephone.isEteind())
		{
			return !operateur.estApplesEnCours(this);
		}
		return false;
	}

	/**
	 * Pour obtenir la valeur de nom
	 * 
	 * @return la valeur de nom
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Pour modifier la valeur de nom
	 * 
	 * @param nom la nouvelle valeur de nom
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Pour obtenir la valeur de operateur
	 * 
	 * @return la valeur de operateur
	 */
	public Operateur getOperateur()
	{
		return operateur;
	}

	/**
	 * Pour modifier la valeur de operateur
	 * 
	 * @param operateur la nouvelle valeur de operateur
	 */
	public void setOperateur(Operateur operateur)
	{
		this.operateur = operateur;
	}

	/**
	 * Pour obtenir la valeur de forfait
	 * 
	 * @return la valeur de forfait
	 */
	public AbsForfait getForfait()
	{
		return forfait;
	}

	/**
	 * Pour modifier la valeur de forfait
	 * 
	 * @param forfait la nouvelle valeur de forfait
	 */
	public void setForfait(AbsForfait forfait)
	{
		this.forfait = forfait;
	}

	/**
	 * Pour obtenir la valeur de telephone
	 * 
	 * @return la valeur de telephone
	 */
	public Telephone getTelephone()
	{
		return telephone;
	}

	/**
	 * Pour modifier la valeur de telephone
	 * 
	 * @param telephone la nouvelle valeur de telephone
	 */
	public void setTelephone(Telephone telephone)
	{
		this.telephone = telephone;
	}

	/**
	 * Pour obtenir la valeur de numeroTel
	 * 
	 * @return la valeur de numeroTel
	 */
	public NumeroTelephone getNumeroTel()
	{
		return numeroTel;
	}

	/**
	 * Pour modifier la valeur de numeroTel
	 * 
	 * @param numeroTel la nouvelle valeur de numeroTel
	 */
	public void setNumeroTel(NumeroTelephone numeroTel)
	{
		this.numeroTel = numeroTel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return getNom() + " " + getNumeroTel();
	}

	/**
	 * Pour obtenir la valeur de boiteSMS
	 * 
	 * @return la valeur de boiteSMS
	 */
	public BoiteSMS getBoiteSMS()
	{
		return boiteSMS;
	}

	/**
	 * Pour modifier la valeur de boiteSMS
	 * 
	 * @param boiteSMS la nouvelle valeur de boiteSMS
	 */
	public void setBoiteSMS(BoiteSMS boiteSMS)
	{
		this.boiteSMS = boiteSMS;
	}

	/**
	 * Pour obtenir la valeur de boiteVocale
	 * 
	 * @return la valeur de boiteVocale
	 */
	public BoiteVocale getBoiteVocale()
	{
		return boiteVocale;
	}

	/**
	 * Pour modifier la valeur de boiteVocale
	 * 
	 * @param boiteVocale la nouvelle valeur de boiteVocale
	 */
	public void setBoiteVocale(BoiteVocale boiteVocale)
	{
		this.boiteVocale = boiteVocale;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof AbonneOperateur)
		{
			if (this.getNumeroTel().getNum()
					.equals(((AbonneOperateur) obj).getNumeroTel().getNum()))
			{
				return true;
			}
		}
		return false;
	}

} // AbonneOperateur
